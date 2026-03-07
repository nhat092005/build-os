# DS3231 RTC — Overview

Kernel driver and userspace control tool for the Maxim DS3231 Real-Time Clock (RTC). The DS3231 is a highly accurate I2C RTC with an integrated temperature-compensated crystal oscillator (TCXO) and crystal.

This driver integrates with the standard Linux RTC subsystem (`/dev/rtc0`) and the hwmon subsystem (for reading the on-chip temperature).

## Stack

```
┌──────────────────────────────────────────────┐
│ DS3231 (I2C, 0x68) + CR2032 battery          │ ← Hardware
└──────────┬──────────────────┬────────────────┘
           │ I2C              │ SQW/INT (GPIO4)
┌──────────▼──────────────────▼────────────────┐
│ ds3231-rtc.ko                                │ ← Kernel Driver
│ subsystem: RTC (/dev/rtcN), hwmon            │
└──────────┬───────────────────────────────────┘
           │ ioctl (RTC) / sysfs (hwmon)
┌──────────▼───────────────────────────────────┐
│ ds3231-rtc-ctl / hwclock                     │ ← Userspace
└──────────────────────────────────────────────┘
```

## Components

| Component      | Present | Path                               |
| -------------- | ------- | ---------------------------------- |
| Kernel module  | Yes     | `src/ds3231-rtc.c`                 |
| DTS overlay    | Yes     | `dts/ds3231-rtc-overlay.dts`       |
| Public header  | Yes     | `include/ds3231-rtc.h`             |
| UAPI header    | Yes     | `include/uapi/ds3231-rtc.h`        |
| Userspace lib  | No      | — (uses standard Linux RTC ioctls) |
| Userspace tool | Yes     | `userspace/tools/ds3231-rtc-ctl.c` |

## Quick Start

```bash
# 1. Build and install
make modules dtbo tools MODULE=ds3231-rtc DTBO=ds3231-rtc TOOLS=ds3231-rtc
sudo make install-modules install-overlays install-tools

# 2. Add device tree overlay to /boot/config.txt
# dtoverlay=ds3231-rtc

# 3. Load driver
sudo insmod ds3231_rtc.ko

# 4. Use the custom CLI tool
ds3231-rtc-ctl read
ds3231-rtc-ctl temp

# 5. Provide standard standard hwclock integration
hwclock -r -f /dev/rtc0
```
