#!/bin/bash

set -e

# Configuration
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"
IMAGE_DIR="$PROJECT_ROOT/buildroot/output/images"
SDCARD_IMG="$IMAGE_DIR/sdcard.img"
BOOT_IMG="$IMAGE_DIR/boot.vfat"
ROOTFS_IMG="$IMAGE_DIR/rootfs.ext4"

# Verify device exists and is a block device
verify_device() {
    local device=$1
    
    if [ ! -b "$device" ]; then
        echo "Error: $device is not a valid block device"
        exit 1
    fi
    
    # Check if device is mounted
    if mount | grep -q "^$device"; then
        echo "Warning: $device has mounted partitions"
        echo "Unmounting..."
        umount ${device}* 2>/dev/null || true
    fi
}

# Get device info
get_device_info() {
    local device=$1
    echo "Device Information:"
    lsblk -o NAME,SIZE,TYPE,MOUNTPOINT "$device" 2>/dev/null || true
}

# Confirm dangerous operation
confirm_operation() {
    local device=$1
    echo "This will COMPLETELY ERASE all data on $device"
    get_device_info "$device"
    read -p "Are you ABSOLUTELY SURE you want to continue? (y/n): " confirm
    if [ "$confirm" != "y" ]; then
        echo "Aborted. No changes made."
        exit 0
    fi
}

# Method 1: Flash complete image (using dd)
deploy_complete_image() {
    local device=$1
    echo "Method: Complete Image Flash"
    echo "Source: $SDCARD_IMG"
    echo "Target: $device"
    if [ ! -f "$SDCARD_IMG" ]; then
        echo "Error: Image not found: $SDCARD_IMG"
        echo "Build the image first with: make buildroot"
        exit 1
    fi
    
    confirm_operation "$device"
    
    echo "[1/3] Unmounting device..."
    umount ${device}* 2>/dev/null || true
    
    echo "[2/3] Flashing image to SD card..."
    dd if="$SDCARD_IMG" of="$device" bs=4M status=progress conv=fsync
    
    echo "[3/3] Syncing..."
    sync
    
    get_device_info "$device"
}

# Method 2: Manual partition and copy (advanced)
deploy_manual() {
    local device=$1
    local boot_part="${device}1"
    local rootfs_part="${device}2"
    
    # Handle mmcblk naming convention
    if [[ "$device" == *"mmcblk"* ]] || [[ "$device" == *"loop"* ]]; then
        boot_part="${device}p1"
        rootfs_part="${device}p2"
    fi
    
    echo "Method: Manual Partition Deployment"
    echo "Target: $device"
    echo "Boot partition: $boot_part"
    echo "Root partition: $rootfs_part"
    
    if [ ! -f "$BOOT_IMG" ] || [ ! -f "$ROOTFS_IMG" ]; then
        echo "Error: Images not found"
        [ ! -f "$BOOT_IMG" ] && echo "  Missing: $BOOT_IMG"
        [ ! -f "$ROOTFS_IMG" ] && echo "  Missing: $ROOTFS_IMG"
        exit 1
    fi
    
    confirm_operation "$device"
    
    echo "[1/7] Unmounting device..."
    umount ${device}* 2>/dev/null || true
    
    echo "[2/7] Creating partition table..."
    parted -s "$device" mklabel msdos
    parted -s "$device" mkpart primary fat32 1MiB 33MiB
    parted -s "$device" set 1 boot on
    parted -s "$device" mkpart primary ext4 33MiB 100%
    
    echo "[3/7] Formatting boot partition (FAT32)..."
    mkfs.vfat -F 32 -n BOOT "$boot_part"
    
    echo "[4/7] Formatting root partition (ext4)..."
    mkfs.ext4 -F -L rootfs "$rootfs_part"
    
    echo "[5/7] Copying boot files..."
    mkdir -p /tmp/boot_mnt
    mount "$boot_part" /tmp/boot_mnt
    
    # Extract boot partition contents
    mkdir -p /tmp/boot_extract
    mcopy -s -i "$BOOT_IMG" ::* /tmp/boot_extract/ 2>/dev/null || true
    cp -r /tmp/boot_extract/* /tmp/boot_mnt/
    
    umount /tmp/boot_mnt
    rm -rf /tmp/boot_extract
    
    echo "[6/7] Copying root filesystem..."
    mkdir -p /tmp/rootfs_mnt
    mount "$rootfs_part" /tmp/rootfs_mnt
    
    # Mount rootfs image as loop device and copy contents
    mkdir -p /tmp/rootfs_src
    mount -o loop,ro "$ROOTFS_IMG" /tmp/rootfs_src
    
    echo "  Copying files (this may take a few minutes)..."
    rsync -a /tmp/rootfs_src/* /tmp/rootfs_mnt/ || {
        echo "Error: Failed to copy rootfs"
        umount /tmp/rootfs_src
        umount /tmp/rootfs_mnt
        exit 1
    }
    
    # Cleanup
    umount /tmp/rootfs_src
    rm -rf /tmp/rootfs_src
    umount /tmp/rootfs_mnt
    rm -rf /tmp/rootfs_mnt
    
    echo "[7/7] Syncing..."
    sync
    
    get_device_info "$device"
}

# Main
main() {    
    local device=$1
    local method=$2
    
    # Verify device
    verify_device "$device"
    
    # Deploy based on method
    case "$method" in
        auto)
            deploy_complete_image "$device"
            ;;
        manual)
            deploy_manual "$device"
            ;;
        *)
            echo "Error: Unknown method '$method'"
            usage
            ;;
    esac
}

# Run
main "$@"