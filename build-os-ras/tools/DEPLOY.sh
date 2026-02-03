#!/bin/bash
# Deploy BOOT and rootfs to SD card - Auto sync all files

set -e

SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"

BOOT_SRC="$SCRIPT_DIR/../BOOT"
ROOTFS_SRC="$SCRIPT_DIR/../rootfs"

SD_BOOT="/dev/sda1"
SD_ROOTFS="/dev/sda2"

BOOT_MOUNT="/media/$USER/BOOT"
ROOTFS_MOUNT="/media/$USER/rootfs"

# 1. Unmount all existing SD card mounts
echo "[CLEANUP] Unmounting existing SD card mounts..."
sudo umount /media/$USER/BOOT* 2>/dev/null || true
sudo umount /media/$USER/rootfs* 2>/dev/null || true
sudo umount "$SD_BOOT" 2>/dev/null || true
sudo umount "$SD_ROOTFS" 2>/dev/null || true

# 2. Remove old directories
sudo rm -rf /media/$USER/BOOT* /media/$USER/rootfs* 2>/dev/null || true

# 3. Create clean mount points
echo "[SETUP] Creating mount points..."
sudo mkdir -p "$BOOT_MOUNT" "$ROOTFS_MOUNT"

# 4. Mount SD card partitions
echo "[MOUNT] Mounting SD card..."
sudo mount "$SD_BOOT" "$BOOT_MOUNT" || { echo "ERROR: Cannot mount boot partition"; exit 1; }
sudo mount "$SD_ROOTFS" "$ROOTFS_MOUNT" || { echo "ERROR: Cannot mount rootfs partition"; exit 1; }
echo "  $SD_BOOT  -> $BOOT_MOUNT"
echo "  $SD_ROOTFS -> $ROOTFS_MOUNT"
echo ""

# 5. Deploy BOOT partition - Full sync with delete (mirror exactly)
echo "[DEPLOY] Syncing BOOT to SD card..."
sudo rsync -a --delete --exclude='lost+found' --no-perms --no-owner --no-group \
    "$BOOT_SRC/" "$BOOT_MOUNT/" 2>/dev/null
echo " BOOT synced successfully"
echo ""

# 6. Deploy rootfs partition - Full sync with delete (mirror exactly)
echo "[DEPLOY] Syncing rootfs to SD card..."
sudo rsync -a --delete --exclude='lost+found' \
    "$ROOTFS_SRC/" "$ROOTFS_MOUNT/" 2>/dev/null
echo " rootfs synced successfully"
echo ""

# 7. Ensure critical scripts are executable
echo "[PERMISSIONS] Setting executable permissions..."
sudo chmod +x "$ROOTFS_MOUNT/init"
sudo chmod +x "$ROOTFS_MOUNT/etc/init.d/"*
sudo chmod +x "$ROOTFS_MOUNT/usr/share/udhcpc/default.script" 2>/dev/null || true
echo " Executable permissions set"
echo ""

# 8. Sync and unmount
echo "[SYNC] Flushing to SD card..."
sync
sync  # Double sync for safety

echo "[UNMOUNT] Unmounting SD card..."
sudo umount "$BOOT_MOUNT"
sudo umount "$ROOTFS_MOUNT"
sudo rmdir "$BOOT_MOUNT" "$ROOTFS_MOUNT"
echo ""

echo "Remove SD card and insert into Pi4"