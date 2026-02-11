#!/bin/bash

set -e

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"
TOOLS_DIR="$PROJECT_ROOT/drivers"
MOUNT_POINT="/tmp/sdcard_rootfs"

detect_rootfs_partition() {
    echo "Detecting rootfs partition" >&2
    local partitions=()
    local count=0
    while IFS= read -r line; do
        local dev=$(echo "$line" | awk '{print $1}')
        local label=$(echo "$line" | awk '{print $2}')
        local fstype=$(echo "$line" | awk '{print $3}')
        
        if [[ "$label" == "rootfs" ]] || [[ "$fstype" == "ext4" ]]; then
            local parent=$(lsblk -no PKNAME "/dev/$dev" 2>/dev/null || echo "$dev")
            if [[ -f "/sys/block/$parent/removable" ]] && [[ "$(cat /sys/block/$parent/removable)" == "1" ]] || [[ "$parent" == mmcblk* ]]; then
                partitions+=("/dev/$dev")
                count=$((count + 1))
                echo "  [$count] /dev/$dev - $label ($fstype)" >&2
            fi
        fi
    done < <(lsblk -nlo NAME,LABEL,FSTYPE)
    
    if [ $count -eq 0 ]; then
        echo "Error: No rootfs partition found" >&2
        exit 1
    fi
    
    if [ $count -eq 1 ]; then
        echo "Selected: ${partitions[0]}" >&2
        echo "${partitions[0]}"
        return
    fi
    
    read -p "Select partition [1-$count]: " selection
    
    if [ "$selection" -lt 1 ] || [ "$selection" -gt $count ]; then
        echo "Error: Invalid selection" >&2
        exit 1
    fi
    
    echo "${partitions[$((selection-1))]}"
}

check_tools() {
    echo "Checking tools"
    local tools=()
    while IFS= read -r tool; do
        tools+=("$tool")
        echo "  $(basename "$tool")"
    done < <(find "$TOOLS_DIR" -path "*/build/tools/*" -type f -executable 2>/dev/null)
    
    if [ ${#tools[@]} -eq 0 ]; then
        echo "Error: No tools found" >&2
        echo "Run 'make driver' first" >&2
        exit 1
    fi
    
    echo "Total: ${#tools[@]}"
}

mount_partition() {
    local partition=$1
    
    if mount | grep -q "$partition"; then
        umount "$partition" 2>/dev/null || true
    fi
    
    mkdir -p "$MOUNT_POINT"
    mount "$partition" "$MOUNT_POINT"
    
    if [ ! -d "$MOUNT_POINT/usr/bin" ]; then
        echo "Error: Invalid rootfs" >&2
        umount "$MOUNT_POINT"
        exit 1
    fi
}

copy_tools() {
    while IFS= read -r tool; do
        local name=$(basename "$tool")
        cp "$tool" "$MOUNT_POINT/usr/bin/$name"
        chmod +x "$MOUNT_POINT/usr/bin/$name"
        echo "  $name"
        copied=$((copied + 1))
    done < <(find "$TOOLS_DIR" -path "*/build/tools/*" -type f -executable 2>/dev/null)
}

cleanup() {
    sync
    umount "$MOUNT_POINT" 2>/dev/null || true
    rmdir "$MOUNT_POINT" 2>/dev/null || true
}

main() {
    check_tools
    
    ROOTFS_PARTITION=$(detect_rootfs_partition)
    
    read -p "Install to $ROOTFS_PARTITION? (y/n): " confirm
    if [ "$confirm" != "y" ]; then
        echo "Cancelled"
        exit 0
    fi

    mount_partition "$ROOTFS_PARTITION"
    
    copy_tools
    
    cleanup
}

trap cleanup EXIT

main "$@"
