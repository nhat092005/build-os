#!/bin/sh
# Custom post-build script for Raspberry Pi 4 64-bit
# This script configures the target root filesystem

set -u
set -e

# Add a console on tty1
if [ -e ${TARGET_DIR}/etc/inittab ]; then
    grep -qE '^tty1::' ${TARGET_DIR}/etc/inittab || \
        sed -i '/GENERIC_SERIAL/a\
tty1::respawn:/sbin/getty -L  tty1 0 vt100 # HDMI console' ${TARGET_DIR}/etc/inittab
    # systemd doesn't use /etc/inittab, enable getty.tty1.service instead
elif [ -d ${TARGET_DIR}/etc/systemd ]; then
    mkdir -p "${TARGET_DIR}/etc/systemd/system/getty.target.wants"
    ln -sf /lib/systemd/system/getty@.service \
       "${TARGET_DIR}/etc/systemd/system/getty.target.wants/getty@tty1.service"
fi

# Ensure sshd privilege separation user exists (safety fallback)
# Buildroot's OPENSSH_USERS mechanism creates this during fakeroot,
# but we add it here as a belt-and-suspenders safeguard.
if [ -f ${TARGET_DIR}/usr/sbin/sshd ]; then
    # Add sshd group if missing
    if ! grep -q '^sshd:' ${TARGET_DIR}/etc/group 2>/dev/null; then
        echo "sshd:x:101:" >> ${TARGET_DIR}/etc/group
    fi
    # Add sshd user if missing
    if ! grep -q '^sshd:' ${TARGET_DIR}/etc/passwd 2>/dev/null; then
        echo "sshd:x:100:101:SSH drop priv user:/var/empty:/bin/false" >> ${TARGET_DIR}/etc/passwd
    fi
    # Add sshd shadow entry if missing
    if ! grep -q '^sshd:' ${TARGET_DIR}/etc/shadow 2>/dev/null; then
        echo "sshd:*:::::::" >> ${TARGET_DIR}/etc/shadow
    fi
    # Ensure /var/empty exists for privilege separation
    mkdir -p ${TARGET_DIR}/var/empty
fi

# Remove the default wpa_supplicant.conf installed by wpa_supplicant package
# at /etc/wpa_supplicant.conf (dummy config with key_mgmt=NONE).
# Our real WiFi config is at /etc/wpa_supplicant/wpa_supplicant.conf
# provided by the rootfs overlay.
rm -f ${TARGET_DIR}/etc/wpa_supplicant.conf
