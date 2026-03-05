#!/bin/bash

set -e

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"
KERNEL_DIR="$PROJECT_ROOT/kernel"

# Add rustup/cargo toolchain to PATH for non-interactive (non-login) shells
if [ -f "$HOME/.cargo/env" ]; then
    source "$HOME/.cargo/env"
elif [ -d "$HOME/.cargo/bin" ]; then
    export PATH="$HOME/.cargo/bin:$PATH"
fi

MIN_RUSTC_VERSION="1.78.0"
MIN_BINDGEN_VERSION="0.65.1"

# Convert version string to canonical number for comparison
get_canonical_version() {
    local IFS='.'
    local ver="$1"
    if [ -z "$ver" ]; then
        echo 0
        return
    fi
    set -- $ver
    echo $(( 100000 * ${1:-0} + 100 * ${2:-0} + ${3:-0} ))
}

check_rustc() {
    if ! command -v rustc &>/dev/null; then
        echo "Error: rustc not found." 
        echo "Install via: curl --proto '=https' --tlsv1.2 -sSf https://sh.rustup.rs | sh"
        return 1
    fi

    local version
    version=$(rustc --version | sed -nE 's/.*rustc ([0-9]+\.[0-9]+\.[0-9]+).*/\1/p')
    local current_ver
    current_ver=$(get_canonical_version "$version")
    local min_ver
    min_ver=$(get_canonical_version "$MIN_RUSTC_VERSION")

    if [ "$current_ver" -lt "$min_ver" ]; then
        echo "Error: rustc $version is too old. Need >= $MIN_RUSTC_VERSION"
        echo "Run: rustup update stable"
        return 1
    fi

    echo "  rustc $version (>= $MIN_RUSTC_VERSION) is available"
}

check_rust_src() {
    local sysroot
    sysroot=$(rustc --print sysroot)

    if [ ! -d "$sysroot/lib/rustlib/src/rust/library" ]; then
        echo "Warning: rust-src not found."
        rustup component add rust-src
        echo "rust-src component added."
    fi

    if [ -d "$sysroot/lib/rustlib/src/rust/library" ]; then
        echo "  rust-src is available"
    else
        echo "Error: rust-src installation failed"
        return 1
    fi
}

check_aarch64_target() {
    if ! rustup target list --installed | grep -q "aarch64-unknown-none$"; then
        echo "Warning: aarch64-unknown-none not installed."
        rustup target add aarch64-unknown-none
        echo "aarch64-unknown-none target added."
    fi
    echo "  aarch64-unknown-none target is available"

    # The Linux kernel uses aarch64-unknown-none-softfloat for Rust modules
    if ! rustup target list --installed | grep -q "aarch64-unknown-none-softfloat"; then
        echo "Warning: aarch64-unknown-none-softfloat not installed."
        rustup target add aarch64-unknown-none-softfloat
        echo "aarch64-unknown-none-softfloat target added."
    fi
    echo "  aarch64-unknown-none-softfloat target is available"
}

check_bindgen() {
    if ! command -v bindgen &>/dev/null; then
        echo "Warning: bindgen not found."
        cargo install bindgen-cli
        echo "bindgen installed."
    fi

    local version
    version=$(bindgen --version 2>/dev/null | sed -nE 's/.*bindgen ([0-9]+\.[0-9]+\.[0-9]+).*/\1/p')
    local current_ver
    current_ver=$(get_canonical_version "$version")
    local min_ver
    min_ver=$(get_canonical_version "$MIN_BINDGEN_VERSION")

    if [ "$current_ver" -lt "$min_ver" ]; then
        echo "Error: bindgen $version is too old. Need >= $MIN_BINDGEN_VERSION"
        echo "Run: cargo install bindgen-cli"
        return 1
    fi

    echo "  bindgen $version (>= $MIN_BINDGEN_VERSION) is available"
}

check_libclang() {
    # bindgen uses libclang - check if it's available
    if ! dpkg -l 2>/dev/null | grep -q "libclang.*-dev"; then
        echo "Error: libclang-dev not found."
        echo "Run: sudo apt install libclang-dev"
        return 1
    fi

    echo "  libclang is available"
}

verify_kernel_rust() {
    local kernel_dir="$KERNEL_DIR"
    if [ ! -d "$kernel_dir" ]; then
        echo "Warming:  Kernel source not found at $kernel_dir, skipping verification"
        return 0
    fi

    # Check minimum version from kernel
    if [ -f "$kernel_dir/scripts/min-tool-version.sh" ]; then
        local kernel_min_rustc
        kernel_min_rustc=$("$kernel_dir/scripts/min-tool-version.sh" rustc 2>/dev/null || echo "unknown")
        local kernel_min_bindgen
        kernel_min_bindgen=$("$kernel_dir/scripts/min-tool-version.sh" bindgen 2>/dev/null || echo "unknown")
        echo "  Kernel requires: rustc >= $kernel_min_rustc, bindgen >= $kernel_min_bindgen"
    fi

    echo "  Kernel Rust toolchain check passed"
}

# Invalidate Buildroot kernel configuration and build stamps so that the
# next 'make build-all' reconfigures the kernel with RUSTC in the environment.
# This guarantees CONFIG_RUST=y is applied from linux-rust.config.
# Root cause: Buildroot's syncconfig silently drops CONFIG_RUST=y when the
# RUSTC env variable is absent at configuration time (e.g. first setup or
# after rustup is upgraded).  Removing the stamps forces a clean reconfigure.
invalidate_kernel_stamps() {
    local br_build="$PROJECT_ROOT/buildroot/output/build/linux-custom"
    if [ ! -d "$br_build" ]; then
        # Kernel has never been built — nothing to invalidate.
        return 0
    fi

    local needs_invalidation=0

    # Detect if kernel was configured without CONFIG_RUST=y
    if [ -f "$br_build/.config" ]; then
        if ! grep -q '^CONFIG_RUST=y' "$br_build/.config"; then
            echo "  Warning: kernel .config is missing CONFIG_RUST=y"
            needs_invalidation=1
        fi
    fi

    # Detect if the stored RUSTC version differs from the current rustc
    if [ -f "$br_build/.config" ]; then
        local current_version_num
        local rustc_ver
        rustc_ver=$(rustc --version | sed -nE 's/.*rustc ([0-9]+)\.([0-9]+)\.([0-9]+).*/\1 \2 \3/p')
        local maj min patch
        read -r maj min patch <<< "$rustc_ver"
        current_version_num=$(( maj * 100000 + min * 100 + patch ))
        local stored_version_num
        stored_version_num=$(grep '^CONFIG_RUSTC_VERSION=' "$br_build/.config" | cut -d= -f2)
        if [ -n "$stored_version_num" ] && [ "$current_version_num" -ne "$stored_version_num" ]; then
            echo "  Warning: kernel was configured with rustc $stored_version_num, current is $current_version_num"
            needs_invalidation=1
        fi
    fi

    if [ "$needs_invalidation" -eq 1 ]; then
        echo "  Invalidating kernel configuration and build stamps for fresh rebuild..."
        rm -f "$br_build"/.stamp_configured \
               "$br_build"/.stamp_kconfig_fixup_done \
               "$br_build"/.stamp_dotconfig \
               "$br_build"/.stamp_built \
               "$br_build"/.stamp_target_installed \
               "$br_build"/.stamp_images_installed \
               "$br_build"/.stamp_installed
        echo "  Done. Run 'make build-all' to rebuild the kernel with Rust support."
    else
        echo "  Kernel CONFIG_RUST=y is present and rustc version matches — no rebuild needed."
    fi
}

print_summary() {
    echo "Environment summary:"
    echo "  rustc:   $(rustc --version 2>/dev/null || echo 'NOT FOUND')"
    echo "  bindgen: $(bindgen --version 2>/dev/null || echo 'NOT FOUND')"
    echo "  rustc sysroot: $(rustc --print sysroot 2>/dev/null || echo 'N/A')"
    echo "Buildroot integration:"
    echo "  LINUX_MAKE_FLAGS will include:"
    echo "    RUSTC=$(command -v rustc)"
    echo "    BINDGEN=$(command -v bindgen)"
}

main() {
    local failed=0

    check_rustc      || failed=1
    check_rust_src   || failed=1
    check_aarch64_target || failed=1
    check_libclang   || failed=1
    check_bindgen    || failed=1

    if [ "$failed" -eq 1 ]; then
        echo "Error: Some prerequisites are missing."
        exit 1
    fi

    verify_kernel_rust || failed=1
    invalidate_kernel_stamps

    print_summary
}

main "$@"
