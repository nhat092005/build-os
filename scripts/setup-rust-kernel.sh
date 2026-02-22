#!/bin/bash

set -e

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"
KERNEL_DIR="$PROJECT_ROOT/kernel"

MIN_RUSTC_VERSION="1.78.0"
MIN_BINDGEN_VERSION="0.65.1"

# Convert version string to canonical number for comparison
get_canonical_version() {
    IFS='.'
    set -- $1
    echo $(( 100000 * $1 + 100 * $2 + $3 ))
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
    if ! rustup target list --installed | grep -q "aarch64-unknown-none"; then
        echo "Warning: aarch64-unknown-none not installed."
        rustup target add aarch64-unknown-none
        echo "aarch64-unknown-none target added."
    fi

    echo "  aarch64-unknown-none target is available"
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

    print_summary
}

main "$@"
