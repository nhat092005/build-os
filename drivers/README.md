# Drivers

This directory contains out-of-tree Linux kernel drivers and their associated userspace tools for GPIO-based hardware control on Raspberry Pi.

## Directory Structure

```
drivers/
├── Makefile            # Top-level build system
├── common/             # Shared libraries (libuart-transport)
├── bh1750/             # IIO ambient light sensor driver (BH1750, I2C)
├── ds3231-rtc/         # RTC + hwmon driver (DS3231, I2C)
├── esp32-uart/         # Userspace UART tool for ESP32 (libuart-transport)
├── gpio-chardev/       # Character device driver for GPIO LED control
├── gpio-inputs/        # Input subsystem driver for GPIO push buttons
├── gpio-leds/          # LED class driver with Device Tree support
├── gpio-rust/          # Rust kernel module with C shim for GPIO/misc device
├── gpio-sysfs/         # Userspace-only GPIO control via /sys/class/gpio
├── sht3x/              # hwmon driver for SHT3x temperature/humidity (I2C)
└── stm32-uart/         # Userspace UART tool for STM32 (libuart-transport)
```

## Available Drivers

### gpio-chardev

A character device driver that exposes a single GPIO pin through `/dev/gpio-chardev`. Provides read, write, and ioctl interfaces for LED control including on/off, toggle, and blink operations. Uses a Device Tree overlay to configure the GPIO pin (GPIO21). Includes a userspace command-line tool `gpio-chardev-ctl`.

### gpio-leds

A platform driver that integrates with the Linux LED class subsystem. Devices are configured via Device Tree overlay and controlled through the standard sysfs interface at `/sys/class/leds/<led-name>/`. Supports configurable triggers, active-low logic, suspend/resume behavior, and per-LED default state. Includes a userspace library (`libled`) and command-line tool (`gpio-led-ctl`).

### gpio-rust

A safe Rust kernel module that demonstrates the upstream kernel Rust driver pattern applied to GPIO control within a "Mixed C-Rust Architecture". It uses Rust's ownership system to manage GPIO resources automatically through RAII (the `Drop` trait), while C-based wrappers create a character misc device (`/dev/gpio-rust`) to support userspace interaction via `read`, `write`, and `ioctl` commands. The module manages a single GPIO pin (default GPIO16, overridable via `gpio_pin` module parameter) and is accompanied by a userspace CLI tool `gpio-rust-ctl`.

### gpio-sysfs

A userspace-only GPIO control tool that uses the kernel's built-in sysfs GPIO interface at `/sys/class/gpio/`. No custom kernel module is required.

### bh1750

An I2C industrial I/O (IIO) driver for the ROHM BH1750 ambient light sensor. Integrates with the Linux IIO subsystem and exposes ambient illuminance via sysfs at `in_illuminance_raw` and `in_illuminance_scale`. Configured via Device Tree overlay (`compatible = "rohm,bh1750"`), sharing I2C1 (GPIO2/GPIO3) with other I2C sensors.

### ds3231-rtc

An I2C driver for the Maxim DS3231 RTC + temperature sensor. Registers both an `rtc_device` (`/dev/rtc0`) and a hwmon device (`temp1_input`). GPIO4 is used for the DS3231 SQW/interrupt output (alarm IRQ). Requires `dtparam=i2c_arm=on` in `config.txt`.

### esp32-uart

A userspace-only UART transport tool for communicating with an ESP32 microcontroller. Uses `libuart-transport` from `common/` and the `termios` API on `/dev/ttyAMA0` (GPIO14/GPIO15). No kernel module required.

### gpio-inputs

A platform driver using the Linux input subsystem to expose GPIO push buttons as `EV_KEY` input events on `/dev/input/eventX`. Uses threaded IRQ handling and Device Tree for pin configuration. GPIO12 is assigned to `button0` with `GPIO_ACTIVE_LOW` polarity (`compatible = "bos,gpio-inputs"`).

### sht3x

An I2C hwmon driver for the Sensirion SHT3x temperature and humidity sensor. Exposes `temp1_input` and `humidity1_input` via the hwmon sysfs interface. Includes a safety heater watchdog using `WARN_ON_ONCE()`. I2C address 0x44, sharing I2C1 with other sensors.

### stm32-uart

A userspace-only UART transport tool for communicating with an STM32 microcontroller. Uses `libuart-transport` from `common/` and the `termios` API on `/dev/ttyAMA0` (GPIO14/GPIO15). No kernel module required.

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
