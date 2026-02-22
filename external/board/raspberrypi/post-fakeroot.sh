#!/bin/sh

# Post-fakeroot script for Raspberry Pi 4 64-bit
# This runs inside the fakeroot environment after user table processing.

set -e

FAKEROOT_TARGET_DIR="${1}"

# Check that the target directory was passed as an argument and is not empty or unset.
if [ -z "${FAKEROOT_TARGET_DIR}" ]; then
    echo "ERROR: post-fakeroot.sh: target directory not passed as \$1" >&2
    exit 1
fi

# Buildroot creates a directory at /var/empty with 
# permissions 0755 and ownership 0:0 (root:root). 
if [ -d "${FAKEROOT_TARGET_DIR}/var/empty" ]; then
    chown 0:0 "${FAKEROOT_TARGET_DIR}/var/empty"
    chmod 0700 "${FAKEROOT_TARGET_DIR}/var/empty"
fi
