# DS3231 RTC Driver

Linux I2C client driver for the Maxim DS3231 Extremely Accurate I2C-Integrated RTC/TCXO.

## Hardware

| Signal | RPi Pin | GPIO | Description |
|--------|---------|------|-------------|
| VCC    | 1 / 17  | —    | 3.3 V       |
| GND    | 6       | —    | Ground      |
| SDA    | 3       | GPIO2| I2C1 data   |
| SCL    | 5       | GPIO3| I2C1 clock  |
| SQW    | —       | —    | Not connected (Phase 2) |

## Features

- Standard Linux RTC device (`/dev/rtcN`)
- `hwclock` compatible — no custom ioctls
- 7-byte atomic I2C block read/write (no mid-read glitch)
- BCD ↔ binary via kernel `<linux/bcd.h>`
- Oscillator Stop Flag (OSF) detection and auto-clear
- On-chip temperature sensor via sysfs
- Device Tree overlay for Raspberry Pi

## Quick Start

```bash
# Build everything (module + overlay + tool)
make modules DRIVER=ds3231-rtc
make dtbo DTBO=ds3231-rtc
make tools DRIVER=ds3231-rtc

# Stage and deploy
make install-modules
make install-overlays
make install-tools
sudo make deploy-sdcard DEVICE=/dev/sdX

# Enable on Raspberry Pi (/boot/config.txt)
dtparam=i2c_arm=on
dtoverlay=ds3231-rtc
```

## Usage

```bash
# Standard Linux tools
hwclock -r          # Read hardware RTC
hwclock -w          # Sync system time → RTC
hwclock -s          # Sync RTC → system time

# Custom CLI tool
ds3231-rtc-ctl read                        # Read time
ds3231-rtc-ctl set 2025-06-15 14:30:00     # Set time
ds3231-rtc-ctl temp                        # Read temperature
ds3231-rtc-ctl info                        # Driver information
```

## Directory Structure

```
ds3231-rtc/
├── Makefile                    Top-level orchestrator
├── README.md                   This file
├── build/                      Build output (auto-created)
│   ├── dtbo/ds3231-rtc.dtbo
│   ├── module/ds3231-rtc.ko
│   └── tools/ds3231-rtc-ctl
├── dts/
│   ├── ds3231-rtc-overlay.dts  Device Tree overlay
│   └── Makefile
├── include/
│   ├── ds3231-rtc.h            Internal driver header
│   └── uapi/ds3231-rtc.h       User-space API constants
├── src/
│   ├── ds3231-rtc.c            Kernel module source
│   ├── Kbuild
│   └── Makefile
└── userspace/
    ├── Makefile
    └── tools/
        └── ds3231-rtc-ctl.c    CLI control tool
```

## Sysfs Interface

| Path | Mode | Description |
|------|------|-------------|
| `/sys/class/rtc/rtcN/time` | RO | Current time (HH:MM:SS) |
| `/sys/class/rtc/rtcN/date` | RO | Current date (YYYY-MM-DD) |
| `/sys/class/rtc/rtcN/since_epoch` | RO | Unix timestamp |
| `/sys/class/rtc/rtcN/name` | RO | Driver name |
| `/sys/class/hwmon/hwmonX/temp1_input` | RO | Chip temperature in milli-°C (e.g. 25000 = 25.0 °C) |

## License

GPL-2.0-or-later
