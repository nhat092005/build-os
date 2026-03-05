# gpio-leds — GPIO LED Class Driver

## Overview

| Field      | Value                         |
| ---------- | ----------------------------- |
| Module     | `gpio_leds.ko`                |
| Subsystem  | LED class (`platform_driver`) |
| GPIO       | GPIO20 (active high)          |
| Compatible | `custom,gpio-led`             |
| Device     | `/sys/class/leds/*`           |
| DTS        | `gpio-leds-overlay.dts`       |

## Build

```bash
make modules MODULE=gpio-leds
make dtbo DTBO=gpio-leds
make tools TOOLS=gpio-leds
```

## DTS Configuration

```dts
gpio_led: gpio-led {
    compatible = "custom,gpio-led";
    gpios = <&gpio 20 0>;  /* GPIO20, active high */
};
```

## Usage

```bash
# Control via sysfs
echo 1 > /sys/class/leds/.../brightness   # On
echo 0 > /sys/class/leds/.../brightness   # Off

# Userspace tool
gpio-leds-ctl --help
```
