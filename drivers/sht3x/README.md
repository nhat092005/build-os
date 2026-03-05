# sht3x — SHT3x Temperature & Humidity Sensor Driver

## Overview

| Field      | Value                                          |
| ---------- | ---------------------------------------------- |
| Module     | `sht3x.ko`                                     |
| Subsystem  | hwmon (`devm_hwmon_device_register_with_info`) |
| Bus        | I2C1, addr `0x44`                              |
| Compatible | `sensirion,sht3x`                              |
| Device     | `/sys/class/hwmon/hwmon*`                      |
| DTS        | `sht3x-overlay.dts`                            |

## Build

```bash
make modules MODULE=sht3x
make dtbo DTBO=sht3x
```

## DTS Configuration

```dts
sht3x: sht3x@44 {
    compatible = "sensirion,sht3x";
    reg = <0x44>;
};
```

I2C1, 100 kHz clock. Requires `dtparam=i2c_arm=on`.

## Usage

```bash
# Read temperature (millidegrees Celsius)
cat /sys/class/hwmon/hwmon*/temp1_input

# Read humidity (milli-percent)
cat /sys/class/hwmon/hwmon*/humidity1_input
```

## Safety

Heater control with `WARN_ON_ONCE` safety: warns if heater is on for more than 30 seconds without kernel panic.
