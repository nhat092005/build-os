#!/bin/sh
# Post-fakeroot script for Raspberry Pi 4 64-bit
# This runs inside the fakeroot environment after user table processing.
#
# IMPORTANT: Buildroot passes the target directory as $1 (positional argument),
# NOT as the TARGET_DIR environment variable. In the fakeroot context,
# TARGET_DIR is NOT exported — only $1 is available.

set -e

FAKEROOT_TARGET_DIR="${1}"

if [ -z "${FAKEROOT_TARGET_DIR}" ]; then
    echo "ERROR: post-fakeroot.sh: target directory not passed as \$1" >&2
    exit 1
fi

# Fix /var/empty ownership and permissions for sshd privilege separation.
# Buildroot's mkusers script chowns /var/empty to sshd:sshd (100:101)
# because it's defined as sshd's home directory in OPENSSH_USERS.
# However, OpenSSH requires /var/empty to be:
#   - Owned by root:root (UID 0, GID 0)
#   - Not group-writable or world-writable
# Without this fix, sshd refuses to start with:
#   "Privilege separation user sshd does not exist" or
#   "/var/empty must be owned by root and not group or world-writable."
if [ -d "${FAKEROOT_TARGET_DIR}/var/empty" ]; then
    chown 0:0 "${FAKEROOT_TARGET_DIR}/var/empty"
    chmod 0755 "${FAKEROOT_TARGET_DIR}/var/empty"
fi
