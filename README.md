# build-os

[![CI](https://github.com/nhat092005/build-os/actions/workflows/ci.yml/badge.svg)](https://github.com/nhat092005/build-os/actions/workflows/ci.yml)
[![Release](https://github.com/nhat092005/build-os/actions/workflows/release.yml/badge.svg)](https://github.com/nhat092005/build-os/actions/workflows/release.yml)

Embedded Linux OS for Raspberry Pi 4 with custom out-of-tree kernel drivers.

## Target

| Field        | Value                            |
| ------------ | -------------------------------- |
| Board        | Raspberry Pi 4 Model B (BCM2711) |
| Architecture | aarch64 (arm64)                  |
| Kernel       | 6.12.70 RPi fork                 |
| Toolchain    | GCC 14.x (`aarch64-linux-`)      |
| Rust         | rustc 1.93.1 + bindgen 0.72.1    |
| Build system | GNU Make + Docker + Buildroot    |

## Drivers

| Driver       | Type          | Interface               |
| ------------ | ------------- | ----------------------- |
| bh1750       | IIO           | I2C light sensor        |
| ds3231-rtc   | RTC + hwmon   | I2C real-time clock     |
| gpio-chardev | chrdev        | GPIO character device   |
| gpio-inputs  | input         | GPIO button             |
| gpio-leds    | LED class     | GPIO LED                |
| gpio-rust    | misc (Rust+C) | GPIO hybrid driver      |
| sht3x        | hwmon         | I2C temp/humidity       |
| esp32-uart   | userspace     | UART communication      |
| stm32-uart   | userspace     | UART communication      |
| gpio-sysfs   | userspace     | sysfs GPIO (deprecated) |

## Quick Start

```bash
# Clone
git clone --recurse-submodules https://github.com/nhat092005/build-os.git
cd build-os

# Build Docker image
make docker-build

# Build Buildroot
make buildroot

# Build all drivers
make build

# Full OS build (Buildroot + drivers, ~60 min first time)
make build-all
```

## Build Commands

```bash
make buildroot                 # Build Buildroot
make dtbo [DTBO=<name>]        # Device Tree overlays
make modules [MODULE=<name>]   # Kernel modules
make tools [TOOLS=<name>]      # Userspace tools
make driver-list               # List available drivers
```

## Deploy to SD Card

```bash
sudo make stage-output
sudo make deploy-sdcard DEVICE=/dev/sdX
```

## CI/CD

- **ci.yml** — build + checkpatch on push/PR
- **docker-publish.yml** — push builder image to ghcr.io
- **release.yml** — full OS build + GitHub Release on `v*` tag

## Documentation

- [Docker Documentation](./docker/README.md) - Docker image for building the OS
- [Drivers Documentation](./drivers/README.md) - Out-of-tree kernel drivers
- [External Documentation](./external-drivers/README.md) - External drivers
- [Scripts Documentation](./scripts/README.md) - Build scripts
- [Common Documentation](./common/README.md) - Common files

## License

MIT
