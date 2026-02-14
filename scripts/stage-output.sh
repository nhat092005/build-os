#!/bin/bash

set -e

# Configuration
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"
BUILDROOT_IMAGES="$PROJECT_ROOT/buildroot/output/images"
BUILDROOT_TARGET="$PROJECT_ROOT/buildroot/output/target"
OUTPUT_DIR="$PROJECT_ROOT/output"
BOOT_DIR="$OUTPUT_DIR/BOOT"
ROOTFS_DIR="$OUTPUT_DIR/rootfs"

# Check required images exist
check_images() {
    # Verify images exist
    if [ ! -f "$BUILDROOT_IMAGES/boot.vfat" ]; then
        echo "Error: boot.vfat not found."
        exit 1
    fi
    
    if [ ! -d "$BUILDROOT_TARGET" ]; then
        echo "Error: buildroot target directory not found."
        exit 1
    fi
}

# Extract boot partition
extract_boot() {
    # Clean old boot directory
    if [ -d "$BOOT_DIR" ]; then
        rm -rf "$BOOT_DIR"
    fi
    
    mkdir -p "$BOOT_DIR"
    
    # Extract FAT filesystem using mtools
    mcopy -s -i "$BUILDROOT_IMAGES/boot.vfat" ::* "$BOOT_DIR/" 2>/dev/null || {
        echo "Error: Failed to extract boot partition"
        exit 1
    }
}

# Copy rootfs from target directory
extract_rootfs() {
    # Clean old rootfs directory
    if [ -d "$ROOTFS_DIR" ]; then
        rm -rf "$ROOTFS_DIR"
    fi
    
    mkdir -p "$ROOTFS_DIR"
    
    # Copy directly from buildroot target directory
    rsync -a --info=progress2 "$BUILDROOT_TARGET/" "$ROOTFS_DIR/" || {
        echo "Error: Failed to copy rootfs from target"
        exit 1
    }
}

# Main
main() {
    check_images
    extract_boot
    extract_rootfs
}

# Check root privileges (needed for cleaning some directories)
if [ "$EUID" -ne 0 ]; then
    echo "Error: This script must be run as root."
    exit 1
fi

main "$@"
