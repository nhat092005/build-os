#!/bin/bash

# Map defconfig toolchain path to /toolchain via symlink.

set -e

# Create toolchains directory in the mounted project
mkdir -p /root/toolchains

# Symlink the toolchain directory to a fixed location
# expected by the kernel build system.
SDK_LINK="/root/toolchains/aarch64-buildroot-linux-gnu_sdk-buildroot"
if [ ! -L "$SDK_LINK" ]; then
    ln -sf /toolchain "$SDK_LINK"
fi

exec "$@"
