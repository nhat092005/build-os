# gpio-chardev — GPIO LED Character Device Driver

## Overview

| Field      | Value                                    |
| ---------- | ---------------------------------------- |
| Module     | `gpio_chardev.ko`                        |
| Subsystem  | Character device (`alloc_chrdev_region`) |
| GPIO       | GPIO21 (active high)                     |
| Compatible | `gpio-chardev`                           |
| Device     | `/dev/gpio_chardev`                      |
| DTS        | `gpio-chardev-overlay.dts`               |

## Build

```bash
make modules MODULE=gpio-chardev
make dtbo DTBO=gpio-chardev
make tools TOOLS=gpio-chardev
```

## DTS Configuration

```dts
gpio_chardev: gpio_chardev {
    compatible = "gpio-chardev";
    gpios = <&gpio 21 0>;  /* GPIO21, active high */
};
```

## Usage

```bash
gpio-chardev-ctl on      # LED on
gpio-chardev-ctl off     # LED off
gpio-chardev-ctl blink   # Blink (uses delayed_work)
```

## Features

- Custom ioctl interface for LED control
- Blink mode via `delayed_work` in kernel
- `mutex_lock_interruptible()` in all file_ops
