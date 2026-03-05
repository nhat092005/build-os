# build-os

[![CI](https://github.com/nhat092005/build-os/actions/workflows/ci.yml/badge.svg)](https://github.com/nhat092005/build-os/actions/workflows/ci.yml)
[![Release](https://github.com/nhat092005/build-os/actions/workflows/release.yml/badge.svg)](https://github.com/nhat092005/build-os/actions/workflows/release.yml)

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
├── Makefile              # Single build entry point (IN_DOCKER-aware: wrapper outside, real logic inside)
├── docker/               # Docker image definitions (builder + SDK)
├── buildroot/            # Buildroot submodule
├── kernel/               # Raspberry Pi Linux kernel submodule
├── external/             # Buildroot BR2_EXTERNAL tree (board config, packages)
├── drivers/              # Out-of-tree kernel drivers and userspace tools
├── scripts/              # Deployment and installation scripts
├── output/               # Staged boot and rootfs (generated)
└── toolchains/           # Extracted Buildroot SDK (generated)
```

## Requirements

- Linux host (x86_64)
- Docker Engine ≥ 24 (all build tools are hermetic inside the container)
- 20 GB+ free disk space
- Git

## Getting Started

```
git clone --recurse-submodules https://github.com/nhat092005/build-os.git

cd build-os

make docker-build
```

### Build Everything

```
make buildroot
```

This builds the full Buildroot image (kernel + rootfs + all drivers). Takes ~60 min on first run.

For driver iteration after initial Buildroot build:

```
make build-all
```

Builds device tree overlays, kernel modules, and userspace tools for all drivers.

### Deploy to SD Card

```
# Stage Buildroot output into output/BOOT/ and output/rootfs/
sudo make stage-output

# Install custom modules, overlays, and tools into staged rootfs
make install-modules
make install-overlays
make install-tools

# Deploy
sudo make deploy-sdcard DEVICE=/dev/sdX
```

## Raspberry Pi GPIO Pinout

``` 
 (3.3V)                    1  |  2   (5V)
 GPIO2  (SDA1)             3  |  4   (5V)
 GPIO3  (SCL1)             5  |  6   (GND)
 GPIO4  (GPIO_GCLK)        7  |  8   GPIO14 (UART_TXD0)
 (GND)                     9  | 10   GPIO15 (UART_RXD0)
 GPIO17 (GPIO_GEN0)       11  | 12   GPIO18 (GPIO_GEN1)
 GPIO27 (GPIO_GEN2)       13  | 14   (GND)
 GPIO22 (GPIO_GEN3)       15  | 16   GPIO23 (GPIO_GEN4)
 (3.3V)                   17  | 18   GPIO24 (GPIO_GEN5)
 GPIO10 (SPI0_MOSI)       19  | 20   (GND)
 GPIO9  (SPI0_MISO)       21  | 22   GPIO25 (GPIO_GEN6)
 GPIO11 (SPI0_CLK)        23  | 24   GPIO8  (SPI0_CE0_N)
 (GND)                    25  | 26   GPIO7  (SPI0_CE1_N)
 ID_SD  (I2C_EEPROM)      27  | 28   ID_SC  (I2C_EEPROM)
 GPIO5                    29  | 30   (GND)
 GPIO6                    31  | 32   GPIO12
 GPIO13                   33  | 34   (GND)
 GPIO19                   35  | 36   GPIO16
 GPIO26                   37  | 38   GPIO20
 (GND)                    39  | 40   GPIO21
```

## Driver Usage

### GPIO / Hardware Pin Assignments

| Driver         | Signal       | GPIO       | Notes                            |
| -------------- | ------------ | ---------- | -------------------------------- |
| `gpio-chardev` | LED          | GPIO21     | DTS overlay (overridable)        |
| `gpio-leds`    | LED          | GPIO20     | DTS overlay                      |
| `gpio-rust`    | LED          | GPIO16     | DTS overlay + `gpio_pin` param   |
| `gpio-inputs`  | Button 0     | GPIO12     | DTS, GPIO_ACTIVE_LOW             |
| `ds3231-rtc`   | I2C1 SDA/SCL | GPIO2/3    | I2C1 bus, addr 0x68              |
| `ds3231-rtc`   | SQW/IRQ      | GPIO4      | Alarm interrupt                  |
| `bh1750`       | I2C1 SDA/SCL | GPIO2/3    | I2C1 bus, addr 0x23 (default)    |
| `sht3x`        | I2C1 SDA/SCL | GPIO2/3    | I2C1 bus, addr 0x44 (default)    |
| `esp32-uart`   | UART TX/RX   | GPIO14/15  | `/dev/ttyAMA0`, no kernel module |
| `stm32-uart`   | UART TX/RX   | GPIO14/15  | `/dev/ttyAMA0`, no kernel module |
| `gpio-sysfs`   | Any          | Configurable | Userspace only, no .ko         |

## Makefile Targets

### Build

| Target      | Description                                        |
| ----------- | -------------------------------------------------- |
| `build-all` | Build Buildroot image, DT overlays, modules, tools |
| `buildroot` | Build kernel and rootfs with Buildroot             |
| `dtbo`      | Build device tree blob overlays from drivers       |
| `modules`   | Build out-of-tree kernel modules                   |
| `tools`     | Build userspace tools                              |

### Configuration

| Target             | Description                              |
| ------------------ | ---------------------------------------- |
| `buildroot-config` | Open Buildroot interactive menuconfig    |

### Driver (via Buildroot package system)

| Target               | Description                          |
| -------------------- | ------------------------------------ |
| `driver`             | Build driver package(s) in Buildroot |
| `driver-rebuild`     | Rebuild driver package(s)            |
| `driver-reconfigure` | Reconfigure driver package(s)        |
| `driver-clean`       | Clean driver package(s)              |
| `driver-dirclean`    | Remove driver build directory        |

### Deployment

| Target            | Root Required | Description                                    |
| ----------------- | ------------- | ---------------------------------------------- |
| `stage-output`    | Yes           | Extract boot.vfat and rootfs.ext4 into output/ |
| `deploy-sdcard`   | Yes           | Flash base image and apply staged output       |

### Install / Remove

| Target             | Description                                      |
| ------------------ | ------------------------------------------------ |
| `install-modules`  | Copy built .ko files to staged rootfs            |
| `install-overlays` | Copy .dtbo files to staged boot partition        |
| `install-tools`    | Copy userspace ELF binaries to staged rootfs     |

### Clean

| Target            | Description                              |
| ----------------- | ---------------------------------------- |
| `clean`           | Clean driver build artifacts (dtbo + modules + tools) |
| `buildroot-clean` | Clean Buildroot output (triggers full rebuild after) |
| `dtbo-clean`      | Clean device tree overlays               |
| `modules-clean`   | Clean kernel modules                     |
| `tools-clean`     | Clean userspace tools                    |

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

Character device driver exposing a single GPIO pin at `/dev/gpio-chardev`. Supports read/write and ioctl operations (set, get, toggle, blink). Configured via Device Tree overlay (GPIO21 by default). Includes the `gpio-chardev-ctl` command-line tool.

### gpio-leds

Platform driver using the Linux LED class subsystem. Devices are configured via Device Tree overlay (GPIO20) and controlled through sysfs at `/sys/class/leds/gpio-led/`. Supports configurable triggers, active-low logic, default state, and suspend/resume behavior. Includes the `libled` library and `gpio-led-ctl` command-line tool.

### gpio-sysfs

A userspace-only GPIO control tool that uses the kernel's built-in sysfs GPIO interface at `/sys/class/gpio/`. No custom kernel module is required; it works with any kernel that has the sysfs GPIO interface enabled.

### gpio-rust

A safe Rust kernel module demonstrating a 4-layer mixed C-Rust architecture for GPIO control. C provides a thin shim for `miscdevice` registration and `module_param`; Rust owns all GPIO logic via RAII. Exposes `/dev/gpio-rust` with `read`, `write`, and `ioctl` support. Default GPIO pin: GPIO16 (overridable via `gpio_pin` module parameter). Includes `gpio-rust-ctl`.

### gpio-inputs

Platform driver using the Linux input subsystem for GPIO push buttons. Reports button events as `EV_KEY` on `/dev/input/eventX`. IRQ-driven with debounce. GPIO12 bound to `BTN_0`, `GPIO_ACTIVE_LOW`.

### ds3231-rtc

I2C driver for the Maxim DS3231 RTC + temperature sensor. Registers an `rtc_device` (`/dev/rtc0`) and a hwmon device (`/sys/class/hwmon/hwmonX/temp1_input`). Requires `dtparam=i2c_arm=on`. GPIO4 = alarm IRQ.

### bh1750

I2C IIO driver for the ROHM BH1750FVI ambient light sensor. Exposes `in_illuminance_raw` and `in_illuminance_scale` via IIO sysfs. I2C address 0x23 (default) on I2C1.

### sht3x

I2C hwmon driver for the Sensirion SHT3x temperature and humidity sensor. Exposes `temp1_input` (milli-°C) and `humidity1_input` (milli-%RH) via hwmon sysfs. I2C address 0x44 (default) on I2C1.

### esp32-uart

Userspace-only CLI tool (`esp32-ctl`) for communicating with an ESP32 over UART (`/dev/ttyAMA0`). Uses `libesp32` → `libuart-transport` (from `common/`). No kernel module.

### stm32-uart

Userspace-only CLI tool (`stm32-ctl`) for communicating with an STM32 over UART (`/dev/ttyAMA0`). Uses `libstm32` → `libuart-transport` (from `common/`). No kernel module.

## Documents

- [Buildroot](buildroot/README) - Build system configuration and image generation workflow  
- [Kernel](kernel/README) - Raspberry Pi Linux integration and kernel customization  
- [Drivers](drivers/README.md) - Out-of-tree kernel modules and userspace tools  
- [Scripts](scripts/README.md) - Deployment, staging, and automation utilities  
- [External](external/README.md) - BR2_EXTERNAL tree (board config, packages, custom integration)  

## License

MIT
