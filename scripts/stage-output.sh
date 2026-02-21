#!/bin/bash

set -e

# Configuration
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"
BUILDROOT_IMAGES="$PROJECT_ROOT/buildroot/output/images"

OUTPUT_DIR="$PROJECT_ROOT/output"
BOOT_DIR="$OUTPUT_DIR/BOOT"
ROOTFS_DIR="$OUTPUT_DIR/rootfs"

# Check root
if [ "$EUID" -ne 0 ]; then
    echo "Error: This script must be run as root."
    exit 1
fi

# Check required images exist
check_images() {
    if [ ! -f "$BUILDROOT_IMAGES/boot.vfat" ]; then
        echo "Error: boot.vfat not found in $BUILDROOT_IMAGES"
        exit 1
    fi

    if [ ! -f "$BUILDROOT_IMAGES/rootfs.ext4" ]; then
        echo "Error: rootfs.ext4 not found in $BUILDROOT_IMAGES"
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

    echo "Boot partition extracted to $BOOT_DIR"
}

# Extract rootfs from ext4 image
extract_rootfs() {
    # Clean old rootfs directory
    if [ -d "$ROOTFS_DIR" ]; then
        rm -rf "$ROOTFS_DIR"
    fi
    mkdir -p "$ROOTFS_DIR"

    # Create temporary mount point
    TEMP_MOUNT=$(mktemp -d)
    
    # Mount ext4 image
    mount -o loop,ro "$BUILDROOT_IMAGES/rootfs.ext4" "$TEMP_MOUNT" || {
        echo "Error: Failed to mount rootfs.ext4"
        rmdir "$TEMP_MOUNT"
        exit 1
    }

    # Copy with rsync to preserve permissions, ownership, and timestamps
    # -a: archive mode (preserve everything)
    # -H: preserve hard links
    # -A: preserve ACLs
    # -X: preserve extended attributes
    rsync -aHAX "$TEMP_MOUNT/" "$ROOTFS_DIR/" || {
        echo "Error: Failed to copy rootfs"
        umount "$TEMP_MOUNT"
        rmdir "$TEMP_MOUNT"
        exit 1
    }

    # Cleanup
    umount "$TEMP_MOUNT"
    rmdir "$TEMP_MOUNT"

    echo "rootfs extracted to $ROOTFS_DIR"
}

# Overlay config.txt from external board config (if exists)
overlay_config() {
    local config_src="$PROJECT_ROOT/external/board/raspberrypi/config.txt"
    if [ -f "$config_src" ]; then
        cp -f "$config_src" "$BOOT_DIR/config.txt"
        echo "Overlaid config.txt from $config_src"
    fi
}

# Main
main() {
    check_images
    extract_boot
    extract_rootfs
    overlay_config
}

main "$@"
