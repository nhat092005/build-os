# build-os

Embedded Linux build system for Raspberry Pi 4 (64-bit) based on Buildroot, with custom kernel drivers and automated SD card deployment.

## Overview

This project integrates Buildroot with a local Raspberry Pi kernel source tree to produce bootable SD card images. It includes out-of-tree GPIO kernel drivers, userspace control tools, and scripts for staging and deploying the final image.

- Target: Raspberry Pi 4 (aarch64)
- Buildroot: included as a Git submodule
- Kernel: Raspberry Pi Linux, included as a Git submodule, built via `LINUX_OVERRIDE_SRCDIR`
- License: MIT

## Directory Structure

```
build-os/
├── Makefile              # Top-level build orchestration
├── buildroot/            # Buildroot submodule
├── kernel/               # Raspberry Pi Linux kernel submodule
├── external/             # Buildroot BR2_EXTERNAL tree (board config, packages)
├── drivers/              # Out-of-tree kernel drivers and userspace tools
│   ├── gpio-chardev/     # Character device driver for GPIO control
│   ├── gpio-leds/        # LED class driver with Device Tree support
│   └── gpio-sysfs/
├── scripts/              # Deployment and installation scripts
├── output/               # Staged boot and rootfs (generated)
└── toolchains/           # Extracted Buildroot SDK (generated)
```

## Requirements

- Linux host (Ubuntu 20.04+ recommended)
- 20GB+ free disk space
- Git
- Standard build dependencies (`gcc`, `make`, `patch`, `cpio`, `unzip`, `rsync`, `bc`, `libncurses-dev`, etc.)

## Getting Started

### Clone

```
git clone --recurse-submodules https://github.com/nhat092005/build-os.git
cd build-os
```

### Load Defconfig

```
make raspberrypi4_64_custom_defconfig
```

### Build Everything

```
make build-all
```

This runs `buildroot`, then builds device tree overlays, kernel modules, and userspace tools.

### Deploy to SD Card

```
# Stage Buildroot output into output/BOOT/ and output/rootfs/
sudo make stage-output

# Install custom modules, overlays, and tools into staged rootfs
make install-modules
sudo make install-overlays
make install-tools

# Identify your SD card
make identify-sdcard

# Deploy
sudo make deploy-sdcard DEVICE=/dev/sdX
```

## Makefile Targets

### Build

| Target      | Description                                         |
| ----------- | --------------------------------------------------- |
| `build-all` | Build Buildroot image, DT overlays, modules, tools  |
| `buildroot` | Build kernel and rootfs with Buildroot               |
| `dtbo`      | Build device tree blob overlays from drivers         |
| `modules`   | Build out-of-tree kernel modules                     |
| `tools`     | Build userspace tools                                |

### Configuration

| Target              | Description                                   |
| ------------------- | --------------------------------------------- |
| `menuconfig`        | Open Buildroot interactive configuration      |
| `<name>_defconfig`  | Load a Buildroot defconfig                    |

### Driver (via Buildroot package system)

| Target               | Description                          |
| -------------------- | ------------------------------------ |
| `driver`             | Build driver package(s) in Buildroot |
| `driver-rebuild`     | Rebuild driver package(s)            |
| `driver-reconfigure` | Reconfigure driver package(s)        |
| `driver-clean`       | Clean driver package(s)             |
| `driver-dirclean`    | Remove driver build directory        |

### Deployment

| Target             | Root Required | Description                                    |
| ------------------ | ------------- | ---------------------------------------------- |
| `stage-output`     | Yes           | Extract boot.vfat and rootfs.ext4 into output/ |
| `identify-sdcard`  | No            | List block devices and detect SD cards         |
| `deploy-sdcard`    | Yes           | Flash base image and apply staged output       |
| `image`            | Yes           | Shortcut: identify + deploy                    |
| `output-clean`     | Yes           | Remove the output/ directory                   |

### Install / Remove

| Target               | Description                                      |
| -------------------- | ------------------------------------------------ |
| `install-modules`    | Copy built .ko files to staged rootfs            |
| `remove-modules`     | Remove .ko files from staged rootfs              |
| `install-overlays`   | Copy .dtbo files to staged boot partition        |
| `remove-overlays`    | Remove .dtbo files from staged boot              |
| `install-tools`      | Copy userspace ELF binaries to staged rootfs     |
| `remove-tools`       | Remove userspace binaries from staged rootfs     |
| `install-toolchains` | Extract and install Buildroot SDK to toolchains/ |
| `remove-toolchains`  | Delete the toolchains/ directory                 |

### Clean

| Target              | Description                             |
| ------------------- | --------------------------------------- |
| `clean`             | Clean all (Buildroot + drivers + output)|
| `buildroot-clean`   | Clean Buildroot output                  |
| `buildroot-distclean` | Reset Buildroot to pristine state     |
| `dtbo-clean`        | Clean device tree overlays              |
| `modules-clean`     | Clean kernel modules                    |
| `tools-clean`       | Clean userspace tools                   |

### Build Options

| Variable | Default    | Description                       |
| -------- | ---------- | --------------------------------- |
| `MODULE` | `all`      | Specific driver module to build   |
| `TOOLS`  | `all`      | Specific userspace tool to build  |
| `DTBO`   | `all`      | Specific DT overlay to build      |
| `DRIVER` | `all`      | Specific Buildroot driver package |
| `DEVICE` | `/dev/sda` | Target SD card device             |

## Custom Drivers

### gpio-chardev

Character device driver exposing a single GPIO pin at `/dev/gpio-chardev`. Supports read/write and ioctl operations (set, get, toggle, blink). Uses a GPIO lookup table at module load time. Default pin: GPIO17. Includes the `gpio-chardev-ctl` command-line tool.

### gpio-leds

Platform driver using the Linux LED class subsystem. Devices are configured via Device Tree overlay and controlled through sysfs at `/sys/class/leds/<led-name>/`. Supports configurable triggers, active-low logic, default state, and suspend/resume behavior. Default pin: GPIO27. Includes the `libled` library and `gpio-led-ctl` command-line tool.

## License

MIT
