# bh1750 — BH1750 Ambient Light Sensor Driver

## Overview

| Field      | Value                              |
| ---------- | ---------------------------------- |
| Module     | `bh1750.ko`                        |
| Subsystem  | IIO (Industrial I/O)               |
| Bus        | I2C1, addr `0x23`                  |
| Compatible | `rohm,bh1750`                      |
| Device     | `/sys/bus/iio/devices/iio:device*` |
| DTS        | `bh1750-overlay.dts`               |

## Build

```bash
make modules MODULE=bh1750
make dtbo DTBO=bh1750
```

## DTS Configuration

```dts
bh1750: bh1750@23 {
    compatible = "rohm,bh1750";
    reg = <0x23>;
};
```

I2C1, 100 kHz clock. Requires `dtparam=i2c_arm=on` in `config.txt`.

## Usage

```bash
# Read ambient light level
cat /sys/bus/iio/devices/iio:device*/in_illuminance_raw
```
