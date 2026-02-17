#!/bin/bash

set -e

# Configuration
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"
OUTPUT_DIR="$PROJECT_ROOT/output"
BOOT_DIR="$OUTPUT_DIR/BOOT"
ROOTFS_DIR="$OUTPUT_DIR/rootfs"
SDCARD_IMG="$PROJECT_ROOT/buildroot/output/images/sdcard.img"

# Check prerequisites
check_prerequisites() {
    if [ ! -f "$SDCARD_IMG" ]; then
        echo "Error: sdcard.img not found at $SDCARD_IMG"
        exit 1
    fi

    if [ ! -d "$BOOT_DIR" ] || [ ! -d "$ROOTFS_DIR" ]; then
        echo "Error: Staged output not found"
        exit 1
    fi

    local boot_files
    boot_files=$(find "$BOOT_DIR" -type f 2>/dev/null | wc -l)
    local rootfs_files
    rootfs_files=$(find "$ROOTFS_DIR" -type f 2>/dev/null | wc -l)

    if [ "$boot_files" -eq 0 ] || [ "$rootfs_files" -eq 0 ]; then
        echo "Error: Staged output is empty"
        exit 1
    fi
}

# Verify device
verify_device() {
    local device=$1

    if [ -z "$device" ]; then
        echo "Error: No device specified"
        exit 1
    fi

    if [ ! -b "$device" ]; then
        echo "Error: $device is not a block device"
        exit 1
    fi

    # Safety: refuse to write to system disk
    local root_disk
    root_disk=$(lsblk -no PKNAME / 2>/dev/null || true)
    if [ -n "$root_disk" ] && [ "$device" = "/dev/$root_disk" ]; then
        echo "Error: Refusing to write to system disk $device"
        exit 1
    fi
}

# Get device info
get_device_info() {
    local device=$1
    lsblk -o NAME,SIZE,TYPE,FSTYPE,LABEL,MOUNTPOINT "$device" 2>/dev/null || true
}

# Unmount all partitions on device
unmount_device() {
    local device=$1
    umount "${device}"* 2>/dev/null || true
    sleep 1
}

# Get partition name 
get_part_name() {
    local device=$1
    local num=$2
    if [[ "$device" == *"mmcblk"* ]] || [[ "$device" == *"loop"* ]] || [[ "$device" == *"nvme"* ]]; then
        echo "${device}p${num}"
    else
        echo "${device}${num}"
    fi
}

# Flash base image via DD
flash_base_image() {
    local device=$1
    dd if="$SDCARD_IMG" of="$device" bs=4M status=progress conv=fsync
    sync
    sleep 2
}

# Expand rootfs partition to fill SD card
expand_rootfs_partition() {
    local device=$1
    local rootfs_part
    rootfs_part=$(get_part_name "$device" 2)

    # Re-read partition table
    partprobe "$device" 2>/dev/null || true
    sleep 1

    # Expand partition 2 to fill remaining space
    echo ", +" | sfdisk -N 2 "$device" --no-reread 2>/dev/null || true
    partprobe "$device" 2>/dev/null || true
    sleep 1

    # Resize filesystem
    e2fsck -f -y "$rootfs_part" 2>/dev/null || true
    resize2fs "$rootfs_part" 2>/dev/null || true

    sync
}

# Apply customized boot files from output/BOOT
apply_boot_files() {
    local device=$1
    local boot_part
    boot_part=$(get_part_name "$device" 1)
    local mnt="/tmp/deploy_boot_$$"

    mkdir -p "$mnt"
    
    if ! mount "$boot_part" "$mnt"; then
        echo "Error: Cannot mount $boot_part"
        exit 1
    fi

    # Delete old content first to free space
    rm -rf "${mnt:?}"/*

    # Copy new content
    rsync -a --info=progress2 "$BOOT_DIR/" "$mnt/" || {
        umount "$mnt"
        exit 1
    }

    sync
    umount "$mnt"
    rmdir "$mnt"
}

# Apply customized rootfs from output/rootfs
apply_rootfs_files() {
    local device=$1
    local rootfs_part
    rootfs_part=$(get_part_name "$device" 2)
    local mnt="/tmp/deploy_rootfs_$$"

    mkdir -p "$mnt"

    if ! mount "$rootfs_part" "$mnt"; then
        echo "Error: Cannot mount $rootfs_part"
        exit 1
    fi

    # Delete old content first to free space
    rm -rf "${mnt:?}"/*

    # Copy new content
    rsync -a --info=progress2 "$ROOTFS_DIR/" "$mnt/" || {
        umount "$mnt"
        exit 1
    }

    sync
    umount "$mnt"
    rmdir "$mnt"
}

# Confirm with user
confirm_proceed() {
    read -r -p "Type 'y' to continue: (y/n) " confirm
    if [ "$confirm" != "y" ]; then
        exit 0
    fi
}
# Cleanup on error
cleanup() {
    umount /tmp/deploy_boot_* 2>/dev/null || true
    umount /tmp/deploy_rootfs_* 2>/dev/null || true
    rmdir /tmp/deploy_boot_* 2>/dev/null || true
    rmdir /tmp/deploy_rootfs_* 2>/dev/null || true
}

trap cleanup EXIT ERR

# Check root
if [ "$EUID" -ne 0 ]; then
    echo "Error: This script must be run as root."
    exit 1
fi

# Main
main() {
    local device=$1

    check_prerequisites
    verify_device "$device"
    get_device_info "$device"

    confirm_proceed

    unmount_device "$device"

    flash_base_image "$device"

    expand_rootfs_partition "$device"

    apply_boot_files "$device"

    apply_rootfs_files "$device"

    get_device_info "$device"
}

main "$@"
