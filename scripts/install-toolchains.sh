#!/bin/bash

set -e

# Configuration
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"
TOOLCHAINS_DIR="$PROJECT_ROOT/toolchains"
BUILDROOT_DIR="$PROJECT_ROOT/buildroot"
BR2_EXTERNAL="$PROJECT_ROOT/external"
KERNEL_SRC_DIR="$PROJECT_ROOT/kernel"

SDK_NAME="aarch64-buildroot-linux-gnu_sdk-buildroot"
SDK_TAR="$BUILDROOT_DIR/output/images/${SDK_NAME}.tar.gz"
SDK_DEST="$TOOLCHAINS_DIR/${SDK_NAME}"

check_BUILDROOT() {
    if [ ! -d "$BUILDROOT_DIR" ]; then
        echo "Error: Buildroot directory not found."
        exit 1
    fi
}

check_SDK_tarball() {
    if [ ! -f "$SDK_TAR" ]; then
        echo "Error: SDK tarball not found at $SDK_TAR"
        exit 1
    fi
}

install_toolchains() {
    # Ensure toolchains directory exists
    mkdir -p "$TOOLCHAINS_DIR"

    # Build SDK only if tarball doesn't exist
    if [ ! -f "$SDK_TAR" ]; then
        make -C "$BUILDROOT_DIR" BR2_EXTERNAL="$BR2_EXTERNAL" LINUX_OVERRIDE_SRCDIR="$KERNEL_SRC_DIR"
        make -C "$BUILDROOT_DIR" BR2_EXTERNAL="$BR2_EXTERNAL" LINUX_OVERRIDE_SRCDIR="$KERNEL_SRC_DIR" sdk
    else
        echo "SDK tarball already exists, skipping build"
    fi

    check_SDK_tarball

    # Extract toolchain
    if [ -d "$SDK_DEST" ]; then
        rm -rf "$SDK_DEST"
    fi
    
    echo "Extracting toolchain to $TOOLCHAINS_DIR"
    tar -xf "$SDK_TAR" -C "$TOOLCHAINS_DIR"
    
    # Relocate SDK (update absolute paths after extraction)
    if [ -f "$SDK_DEST/relocate-sdk.sh" ]; then
        (cd "$SDK_DEST" && ./relocate-sdk.sh)
        echo "SDK relocation complete."
    else
        echo "Warning: relocate-sdk.sh not found, SDK may have path issues"
    fi
    
    # Verify compiler exists and is executable
    if [ -x "$SDK_DEST/bin/aarch64-linux-gcc" ]; then
        echo "Toolchain installed successfully to $SDK_DEST"
    else
        echo "Error: Compiler not found or not executable at $SDK_DEST/bin/aarch64-linux-gcc"
        exit 1
    fi
}

main() {
    check_BUILDROOT
    install_toolchains
}

main "$@"
