# sht3x

A Linux kernel hwmon driver for the Sensirion SHT30/SHT31/SHT35 temperature and humidity sensor over I2C.

## Hardware

| Signal | RPi Pin | GPIO  | Description       |
|--------|---------|-------|-------------------|
| VCC    | 1 / 17  | —     | 3.3 V             |
| GND    | 6       | —     | Ground            |
| SDA    | 3       | GPIO2 | I2C1 data         |
| SCL    | 5       | GPIO3 | I2C1 clock        |
| ADDR   | GND     | —     | 0x44 (default)    |

Alternate address: 0x45 (ADDR pin HIGH). Set via `dtoverlay=sht3x,addr=0x45`.

## Kernel Subsystem

- `i2c_driver` + `hwmon_device`
- `compatible = "sensirion,sht3x"` in DTS
- Userspace interface: `/sys/class/hwmon/hwmonX/`
  - `temp1_input` — temperature in milli-°C (e.g. 25000 = 25.0 °C)
  - `humidity1_input` — relative humidity in milli-%RH (e.g. 60000 = 60.0 %RH)
  - `heater_enable` — sysfs attribute for heater on/off (30 s safety watchdog)
- CRC-8 integrity check (poly 0x31, init 0xFF) on every read
- Period measurement mode (1 Hz) and single-shot mode

## Directory Structure

```
sht3x/
├── Makefile
├── dts/
│   ├── Makefile
│   └── sht3x-overlay.dts
└── src/
    ├── Kbuild
    ├── Makefile
    └── sht3x.c
```

## Quick Start

```bash
# Build
make modules DRIVER=sht3x
make dtbo DTBO=sht3x

# Install
make install-modules
make install-overlays
sudo make deploy-sdcard DEVICE=/dev/sdX
```

Add to `/boot/config.txt` (once only):
```
dtparam=i2c_arm=on
dtoverlay=sht3x
```

## Verify on Target

```bash
dmesg | grep sht3x             # expect: probe success, soft reset, hwmon registered
ls /sys/class/hwmon/hwmon1/    # index may vary
cat /sys/class/hwmon/hwmon1/temp1_input
cat /sys/class/hwmon/hwmon1/humidity1_input
```
