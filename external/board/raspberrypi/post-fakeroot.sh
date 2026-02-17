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

# Fix SSH directory and file permissions for StrictModes.
# Buildroot's SYSTEM_RSYNC uses --chmod=u=rwX,go=rX which normalizes
# ALL overlay files to 0755 (directories) and 0644 (regular files).
# OpenSSH StrictModes (enabled by default) requires:
#   - ~/.ssh/ must be 0700 (not group/other-readable)
#   - ~/.ssh/authorized_keys must be 0600 (not group/other-readable)
#   - User's home directory must not be group/other-writable
# Without this fix, SSH key authentication will be silently rejected.
if [ -d "${FAKEROOT_TARGET_DIR}/root/.ssh" ]; then
    chmod 0700 "${FAKEROOT_TARGET_DIR}/root/.ssh"
    if [ -f "${FAKEROOT_TARGET_DIR}/root/.ssh/authorized_keys" ]; then
        chmod 0600 "${FAKEROOT_TARGET_DIR}/root/.ssh/authorized_keys"
    fi
    # Remove unnecessary example file from final image
    rm -f "${FAKEROOT_TARGET_DIR}/root/.ssh/authorized_keys.example"
fi
