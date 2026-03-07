# GPIO Character Device

## Hardware: LEDs / General I/O

Kernel character device driver providing fine-grained ioctl control over
a GPIO pin. Registers `/dev/gpio-chardev` and implements asynchronous blinking
inside the kernel.

## Stack

```
┌──────────────────────────────────┐
│ Hardware (GPIO 21, active-high)  │ ← Hardware
└────────────┬─────────────────────┘
             │ gpiod_set_value (in ioctl/work)
┌────────────▼─────────────────────┐
│ gpio_chardev.ko                  │ ← Kernel Driver
│ subsystem: char device           │
│ /dev/gpio-chardev                │
└────────────┬─────────────────────┘
             │ ioctl()
┌────────────▼─────────────────────┐
│ gpio-chardev-ctl                 │ ← Userspace tool
└──────────────────────────────────┘
```

## Components

| Component      | Present | Path                                 |
| -------------- | ------- | ------------------------------------ |
| Kernel module  | Yes     | `src/gpio_chardev.c`                 |
| DTS overlay    | Yes     | `dts/gpio-chardev-overlay.dts`       |
| UAPI header    | Yes     | `include/uapi/gpio_chardev.h`        |
| Userspace tool | Yes     | `userspace/tools/gpio-chardev-ctl.C` |
