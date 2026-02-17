# build-os

Minimal embedded Linux build system based on Buildroot.

## Description

`build-os` provides a complete build environment for creating custom embedded Linux systems targeting Raspberry Pi 4. It integrates Buildroot 2025.11 with a custom kernel (6.12.70), custom drivers, and automated deployment scripts.

This repository focuses on:

- Building bootable SD card images for Raspberry Pi 4
- Using local kernel source (6.12.70) via `LINUX_OVERRIDE_SRCDIR`
- Compiling custom kernel drivers (GPIO, LED control)
- Safe deployment workflow with ownership preservation
- Automated CI/CD with GitHub Actions

## Requirements

- Linux host (Ubuntu 20.04+ recommended)
- 20GB+ free disk space
- 2GB+ RAM
- Git
- Build dependencies (installed automatically by CI or via `apt-get`)

## Features

- **Target Platform:** Raspberry Pi 4 64-bit (aarch64)
- **Buildroot:** 2025.11 with BR2_EXTERNAL support
- **Kernel:** 6.12.70 from local source
- **Custom Drivers:**
  - `gpio-chardev` - GPIO17 character device
  - `leds-gpio-custom` - Custom LED control
- **Deployment Scripts:**
  - `stage-output.sh` - Extract image with ownership preservation
  - `deploy-sdcard.sh` - Deploy to SD card with partitioning
- **CI/CD:** Automated builds, PR validation, releases

## Quick Start

### Build Complete Image

```bash
# Clone repository with submodules
git clone --recurse-submodules https://github.com/nhat092005/build-os.git
cd build-os

# Build everything (kernel + modules + image)
make build-all

# Result: sdcard.img (153MB bootable image)
```

### Deploy to SD Card

#### Method 1: Direct DD

```bash
sudo dd if=sdcard.img of=/dev/sdX bs=4M status=progress
sync
```

#### Method 2: Extract and Deploy (allows modifications)

```bash
# Extract to output/ directory
sudo make stage-output

# Modify files in output/BOOT/ or output/rootfs/ if needed

# Deploy to SD card
sudo make deploy-sdcard DEVICE=/dev/sdX
```
