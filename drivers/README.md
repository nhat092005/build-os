# Drivers

This directory contains out-of-tree Linux kernel drivers and their associated userspace tools for GPIO-based hardware control on Raspberry Pi.

## Directory Structure

```
drivers/
├── Makefile            # Top-level build system
├── gpio-chardev/       # Character device driver for GPIO LED control
├── gpio-leds/          # LED class driver with Device Tree support
└── gpio-sysfs/         # (placeholder)
```

## Available Drivers

### gpio-chardev

A character device driver that exposes a single GPIO pin through `/dev/gpio-chardev`. Provides read, write, and ioctl interfaces for LED control including on/off, toggle, and blink operations. Uses a GPIO lookup table to request the pin at runtime (default GPIO17). Includes a userspace command-line tool `gpio-chardev-ctl`.

### gpio-leds

A platform driver that integrates with the Linux LED class subsystem. Devices are configured via Device Tree overlay and controlled through the standard sysfs interface at `/sys/class/leds/<led-name>/`. Supports configurable triggers, active-low logic, suspend/resume behavior, and per-LED default state. Includes a userspace library (`libled`) and command-line tool (`gpio-led-ctl`).

### gpio-rust

A safe Rust kernel module that demonstrates the upstream kernel Rust driver pattern applied to GPIO control within a "Mixed C-Rust Architecture". It uses Rust's ownership system to manage GPIO resources automatically through RAII (the `Drop` trait), while C-based wrappers create a character misc device (`/dev/gpio-rust`) to support userspace interaction via `read`, `write`, and `ioctl` commands. The module manages a single GPIO pin (default GPIO22) and is accompanied by a userspace CLI tool `gpio-rust-ctl`.

### gpio-sysfs

A userspace-only GPIO control tool that uses the kernel's built-in sysfs GPIO interface at `/sys/class/gpio/`. No custom kernel module is required.

## Top-Level Makefile

The top-level Makefile auto-detects subdirectories and dispatches builds to each driver. It supports building kernel modules, userspace tools, and device tree blob overlays individually or all at once.

### Build Targets

| Target          | Description                                                                     |
| --------------- | ------------------------------------------------------------------------------- |
| `all`           | Build device tree overlays, kernel modules, and userspace tools for all drivers |
| `modules`       | Build kernel modules for all drivers                                            |
| `tools`         | Build userspace tools for all drivers                                           |
| `dtbo`          | Build device tree blob overlays for all drivers                                 |
| `clean`         | Clean all build artifacts                                                       |
| `modules-clean` | Clean kernel module artifacts only                                              |
| `tools-clean`   | Clean userspace tool artifacts only                                             |
| `dtbo-clean`    | Clean device tree overlay artifacts only                                        |
| `list`          | List available driver subdirectories                                            |

### Building a Single Driver

Use the `MODULE`, `TOOLS`, or `DTBO` variables to target a specific driver:

```
make modules MODULE=gpio-chardev
make tools TOOLS=gpio-leds
make dtbo DTBO=gpio-leds
```
