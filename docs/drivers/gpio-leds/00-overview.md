# GPIO LEDs

## Hardware: LEDs

Kernel driver and userspace tools for controlling GPIO LEDs. Integrates
with the standard Linux LED class subsystem (`/sys/class/leds/`).

## Stack

```
┌──────────────────────────────────┐
│ LED (GPIO 20, active-high)       │ ← Hardware
└────────────┬─────────────────────┘
             │ gpiod_set_value
┌────────────▼─────────────────────┐
│ gpio_leds.ko                     │ ← Kernel Driver
│ subsystem: LED class             │
│ /sys/class/leds/gpio-led/        │
└────────────┬─────────────────────┘
             │ /sys/class/leds/ sysfs API
┌────────────▼─────────────────────┐
│ gpio-leds-ctl                    │ ← Userspace tool
│ depends: libled                  │
└──────────────────────────────────┘
```

## Components

| Component      | Present | Path                              |
| -------------- | ------- | --------------------------------- |
| Kernel module  | Yes     | `src/gpio_leds.c`                 |
| DTS overlay    | Yes     | `dts/gpio-leds-overlay.dts`       |
| Userspace lib  | Yes     | `userspace/lib/libled.{h,c}`      |
| Userspace tool | Yes     | `userspace/tools/gpio-leds-ctl.c` |
