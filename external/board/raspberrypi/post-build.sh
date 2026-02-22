#!/bin/sh

# This post-build script runs after the root filesystem 
# has been fully built and staged in the target directory.

# It performs final adjustments to the target filesystem, 
# such as configuring a console on tty1 and

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

# Buildroot's OPENSSH_USERS mechanism creates this during fakeroot,
# but we add it here as a belt-and-suspenders safeguard.
if [ -f ${TARGET_DIR}/usr/sbin/sshd ]; then
    mkdir -p ${TARGET_DIR}/var/empty
fi
