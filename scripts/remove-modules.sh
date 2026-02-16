#!/bin/bash

set -euo pipefail

# Configuration
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"

OUTPUT_DIR="$PROJECT_ROOT/output"
ROOTFS_DIR="$OUTPUT_DIR/rootfs"

# Check staged rootfs exists
check_rootfs() {
    if [ ! -d "$ROOTFS_DIR" ]; then
        echo "Error: Invalid rootfs directory: $ROOTFS_DIR"
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

    # Assume there's only one kernel version directory under lib/modules
    KERNEL_VERSION="$(basename "$(find "$modules_dir" -mindepth 1 -maxdepth 1 -type d | head -n 1)")"

    if [ -z "$KERNEL_VERSION" ]; then
        echo "Error: Could not detect kernel version"
        exit 1
    fi
}

# Remove installed modules from rootfs
remove_modules() {
    local dest="$ROOTFS_DIR/lib/modules/$KERNEL_VERSION/extra"

    if [ ! -d "$dest" ]; then
        echo "No extra directory found at $dest"
        exit 0
    fi

    local removed=0

    shopt -s nullglob
    for file in "$dest"/*.ko "$dest"/*.ko.xz; do
        rm -f "$file"
        echo "Removed $(basename "$file")"
        removed=$((removed + 1))
    done
    shopt -u nullglob

    if [ "$removed" -eq 0 ]; then
        echo "No kernel modules found to remove."
    else
        echo "Removed $removed module(s) from $dest"
    fi
}

main() {
    check_rootfs
    detect_kernel_version
    remove_modules
}

main "$@"
