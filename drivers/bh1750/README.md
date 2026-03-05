# bh1750

A Linux kernel IIO driver for the ROHM BH1750FVI ambient light sensor over I2C.

## Hardware

| Signal | RPi Pin | GPIO  | Description    |
| ------ | ------- | ----- | -------------- |
| VCC    | 1 / 17  | —     | 3.3 V          |
| GND    | 6       | —     | Ground         |
| SDA    | 3       | GPIO2 | I2C1 data      |
| SCL    | 5       | GPIO3 | I2C1 clock     |
| ADDR   | GND     | —     | 0x23 (default) |

Alternate address: 0x5C (ADDR pin HIGH). Set via `dtoverlay=bh1750,addr=0x5c`.

## Kernel Subsystem

- `i2c_driver` + `iio_device`
- Userspace interface: IIO sysfs `/sys/bus/iio/devices/iio:deviceX/`
  - `in_illuminance_raw` — raw ADC count
  - `in_illuminance_scale` — scale factor (raw \* scale = lux)
- Supports three resolution modes: H-res (1 lux), H-res2 (0.5 lux), L-res (4 lux)
- Runtime PM: powers down sensor when idle

## Directory Structure

```
bh1750/
├── Makefile
├── dts/
│   ├── Makefile
│   └── bh1750-overlay.dts
└── src/
    ├── Kbuild
    ├── Makefile
    └── bh1750.c
```

## Quick Start

```bash
# Build
make modules DRIVER=bh1750
make dtbo DTBO=bh1750

# Install
make install-modules
make install-overlays
sudo make deploy-sdcard DEVICE=/dev/sdX
```

Add to `/boot/config.txt` (once only):
```
dtparam=i2c_arm=on
dtoverlay=bh1750
```

## Verify on Target

```bash
dmesg | grep bh1750            # expect: I2C probe success, IIO device registered
ls /sys/bus/iio/devices/iio:device0/
cat /sys/bus/iio/devices/iio:device0/in_illuminance_raw
cat /sys/bus/iio/devices/iio:device0/in_illuminance_scale
```
