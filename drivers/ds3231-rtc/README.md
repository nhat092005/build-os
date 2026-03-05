# ds3231-rtc — DS3231 I2C RTC Driver

## Overview

| Field      | Value                                  |
| ---------- | -------------------------------------- |
| Module     | `ds3231-rtc.ko`                        |
| Subsystem  | RTC + hwmon                            |
| Bus        | I2C1, addr `0x68`                      |
| Compatible | `maxim,ds3231`                         |
| Device     | `/dev/rtc0`, `/sys/class/hwmon/hwmon*` |
| IRQ        | GPIO4 (falling edge, alarm)            |
| DTS        | `ds3231-rtc-overlay.dts`               |

## Build

```bash
make modules MODULE=ds3231-rtc
make dtbo DTBO=ds3231-rtc
make tools TOOLS=ds3231-rtc
```

## DTS Configuration

```dts
ds3231: ds3231@68 {
    compatible = "maxim,ds3231";
    reg = <0x68>;
    interrupt-parent = <&gpio>;
    interrupts = <4 2>;  /* GPIO4, falling edge */
};
```

I2C1, 400 kHz clock. Requires `dtparam=i2c_arm=on`.

## Usage

```bash
# Read RTC time
hwclock -r -f /dev/rtc0

# Read temperature
cat /sys/class/hwmon/hwmon*/temp1_input

# Userspace tool
ds3231-rtc-ctl --help
```
