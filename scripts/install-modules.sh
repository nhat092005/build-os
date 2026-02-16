#!/bin/bash

set -euo pipefail

# Configuration
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"

DRIVERS_DIR="$PROJECT_ROOT/drivers"
OUTPUT_DIR="$PROJECT_ROOT/output"
ROOTFS_DIR="$OUTPUT_DIR/rootfs"

# Check staged rootfs exists
check_rootfs() {
    if [ ! -d "$ROOTFS_DIR" ]; then
        echo "Error: Rootfs not found at $ROOTFS_DIR"
        exit 1
    fi
}

# Auto-detect kernel version
detect_kernel_version() {
    local modules_dir="$ROOTFS_DIR/lib/modules"

    if [ ! -d "$modules_dir" ]; then
        echo "Error: $modules_dir not found"
        exit 1
    fi

    KERNEL_VERSION="$(basename "$(find "$modules_dir" -mindepth 1 -maxdepth 1 -type d | head -n 1)")"

    if [ -z "$KERNEL_VERSION" ]; then
        echo "Error: Could not detect kernel version"
        exit 1
    fi

    LIB_MODULES_DIR="$modules_dir/$KERNEL_VERSION/extra"
}

# Find kernel modules in drivers/*/build/module/
find_modules() {
    find "$DRIVERS_DIR" \
        -path "*/build/module/*.ko" \
        -type f 2>/dev/null
}

# Install kernel modules to rootfs
install_modules() {
    local installed=0
    mkdir -p "$LIB_MODULES_DIR"

    while IFS= read -r module; do
        [ -z "$module" ] && continue

        local name
        name="$(basename "$module")"

        cp -f "$module" "$LIB_MODULES_DIR/$name"
        echo "Installed $name"

        installed=$((installed + 1))

    done < <(find_modules)

    if [ "$installed" -eq 0 ]; then
        echo "No kernel modules found to install."
    else
        echo "Installed $installed module(s) to $LIB_MODULES_DIR"
    fi
}

# Main
main() {
    check_rootfs
    detect_kernel_version
    install_modules
}

main "$@"
