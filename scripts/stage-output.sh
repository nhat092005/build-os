#!/bin/bash

set -e

# Configuration
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"
BUILDROOT_IMAGES="$PROJECT_ROOT/buildroot/output/images"
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
    
    if [ ! -f "$BUILDROOT_IMAGES/rootfs.ext4" ]; then
        echo "Error: rootfs.ext4 not found."
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

# Extract rootfs partition
extract_rootfs() {
    # Clean old rootfs directory
    if [ -d "$ROOTFS_DIR" ]; then
        rm -rf "$ROOTFS_DIR"
    fi
    
    mkdir -p "$ROOTFS_DIR"
    
    # Mount rootfs image temporarily
    local TEMP_MOUNT="/tmp/rootfs_extract_$$"
    mkdir -p "$TEMP_MOUNT"
    
    mount -o loop,ro "$BUILDROOT_IMAGES/rootfs.ext4" "$TEMP_MOUNT" || {
        echo "Error: Failed to mount rootfs.ext4"
        exit 1
    }
    
    # Copy files to rootfs directory
    rsync -a --info=progress2 "$TEMP_MOUNT/" "$ROOTFS_DIR/" || {
        umount "$TEMP_MOUNT"
        echo "Error: Failed to copy rootfs"
        exit 1
    }
    
    # Cleanup
    umount "$TEMP_MOUNT"
    rmdir "$TEMP_MOUNT"
}

# Main
main() {
    check_images
    extract_boot
    extract_rootfs
}

# Cleanup on error
cleanup_on_error() {
    umount /tmp/rootfs_extract_* 2>/dev/null || true
    rmdir /tmp/rootfs_extract_* 2>/dev/null || true
}

trap cleanup_on_error ERR

# Check root privileges
if [ "$EUID" -ne 0 ]; then
    echo "Error: This script must be run as root."
    exit 1
fi

main "$@"