#!/bin/bash

set -e

lsblk -o NAME,SIZE,TYPE,MOUNTPOINT,MODEL

# Try to detect removable devices
echo ""
echo "Removable devices detected:"
for dev in /sys/block/sd*; do
    if [ -f "$dev/removable" ] && [ "$(cat $dev/removable)" = "1" ]; then
        devname=$(basename $dev)
        size=$(lsblk -n -o SIZE /dev/$devname | head -1)
        echo "  /dev/$devname - $size (removable)"
    fi
done

for dev in /sys/block/mmcblk*; do
    if [ -d "$dev" ]; then
        devname=$(basename $dev)
        size=$(lsblk -n -o SIZE /dev/$devname | head -1)
        echo "  /dev/$devname - $size (MMC/SD)"
    fi
done
