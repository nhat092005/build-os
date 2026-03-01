#!/bin/bash

# Map defconfig toolchain path to /toolchain via symlink.

set -e

# Create toolchains directory in the mounted project
mkdir -p /build/toolchains

# Symlink the toolchain directory to a fixed location 
# expected by the kernel build system.
SDK_LINK="/build/toolchains/aarch64-buildroot-linux-gnu_sdk-buildroot"
if [ ! -L "$SDK_LINK" ]; then
    ln -sf /toolchain "$SDK_LINK"
fi

# Invalidate kernel stamps if RUSTC path changes to avoid stale build errors.
RUSTC_PATH="/usr/local/cargo/bin/rustc"
STAMP_DIR="/build/buildroot/output/build/linux-custom"

if [ -d "$STAMP_DIR" ] && [ -f "$STAMP_DIR/.config" ]; then
    if grep -q "^CONFIG_RUSTC_VERSION=" "$STAMP_DIR/.config" && \
       ! grep -q "RUSTC=$RUSTC_PATH" "$STAMP_DIR/.config"; then
        echo "RUSTC path mismatch — invalidating kernel stamps"
        rm -f "$STAMP_DIR"/.stamp_configured \
              "$STAMP_DIR"/.stamp_kconfig_fixup_done \
              "$STAMP_DIR"/.stamp_dotconfig \
              "$STAMP_DIR"/.stamp_built \
              "$STAMP_DIR"/.stamp_target_installed \
              "$STAMP_DIR"/.stamp_images_installed \
              "$STAMP_DIR"/.stamp_installed
        echo "Kernel will be reconfigured on next build."
    fi
fi

exec "$@"