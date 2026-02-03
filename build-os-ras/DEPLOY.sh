#!/bin/bash
# Deploy rootfs to SD card - Auto sync all files

set -e

ROOTFS_SRC="rootfs"
SD_BOOT="/dev/sda1"
SD_ROOTFS="/dev/sda2"
BOOT_MOUNT="/media/nhat/BOOT"
ROOTFS_MOUNT="/media/nhat/rootfs"

echo "===================================="
echo "  SD Card Deploy Script - Pi4"
echo "===================================="
echo ""

# 1. Unmount all existing SD card mounts
echo "[CLEANUP] Unmounting existing SD card mounts..."
sudo umount /media/nhat/BOOT* 2>/dev/null || true
sudo umount /media/nhat/rootfs* 2>/dev/null || true
sudo umount "$SD_BOOT" 2>/dev/null || true
sudo umount "$SD_ROOTFS" 2>/dev/null || true

# 2. Remove old directories
sudo rm -rf /media/nhat/BOOT* /media/nhat/rootfs* 2>/dev/null || true

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

# 5. Deploy ALL files using rsync (efficient, preserves permissions, handles updates)
echo "[DEPLOY] Syncing rootfs to SD card..."
echo "  This will copy/update all modified files..."
sudo rsync -avd --exclude='lost+found' "$ROOTFS_SRC/" "$ROOTFS_MOUNT/" | grep -E "^(sending|sent|total)" || true
echo ""

# 6. Ensure critical scripts are executable
echo "[PERMISSIONS] Setting executable permissions..."
sudo chmod +x "$ROOTFS_MOUNT/init"
sudo chmod +x "$ROOTFS_MOUNT/etc/init.d/"*
sudo chmod +x "$ROOTFS_MOUNT/usr/share/udhcpc/default.script" 2>/dev/null || true
echo "  Executable permissions set"
echo ""

# 7. Verify critical files
echo "[VERIFY] Checking critical files..."
ERRORS=0

[ -f "$ROOTFS_MOUNT/init" ] && echo "  init: OK" || { echo "  init: MISSING"; ERRORS=1; }
[ -f "$ROOTFS_MOUNT/etc/init.d/rcS" ] && echo "  rcS: OK" || { echo "  rcS: MISSING"; ERRORS=1; }
[ -f "$ROOTFS_MOUNT/etc/init.d/S10modules" ] && echo "  S10modules: OK" || { echo "  S10modules: MISSING"; ERRORS=1; }
[ -f "$ROOTFS_MOUNT/etc/init.d/S40wpa_supplicant" ] && echo "  S40wpa_supplicant: OK" || { echo "  S40wpa_supplicant: MISSING"; ERRORS=1; }
[ -f "$ROOTFS_MOUNT/usr/share/udhcpc/default.script" ] && echo "  udhcpc script: OK" || { echo "  udhcpc script: MISSING"; ERRORS=1; }
[ -f "$ROOTFS_MOUNT/etc/wpa_supplicant/wpa_supplicant.conf" ] && echo "  WiFi config: OK" || { echo "  WiFi config: MISSING"; ERRORS=1; }

if [ $ERRORS -ne 0 ]; then
    echo ""
    echo "WARNING: Some critical files are missing!"
fi
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

echo "===================================="
echo "  DEPLOY COMPLETE - READY TO BOOT"
echo "===================================="
echo ""
echo "Remove SD card and insert into Pi4"