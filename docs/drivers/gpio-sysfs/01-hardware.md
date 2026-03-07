# Hardware: GPIO Sysfs

## Interface

This is a **userspace-only** driver — no kernel module, no DTS overlay.
It uses the Linux kernel's built-in GPIO sysfs interface at
`/sys/class/gpio/`.

> **Deprecated:** The sysfs GPIO interface has been deprecated since kernel
> 4.x in favor of the character device interface (`/dev/gpiochipN`).
> Use `gpio-chardev` for new work.

## GPIO Numbering

The BCM2711 GPIO controller is exposed as a single gpiochip at base 512:

```
sysfs_gpio_number = BCM_pin + 512
```

| BCM Pin | sysfs Number | Example use  |
| ------- | ------------ | ------------ |
| GPIO 21 | 533          | LED output   |
| GPIO 20 | 532          | LED output   |
| GPIO 12 | 524          | Button input |

## Wiring

Any GPIO pin can be used. The tool accepts BCM pin numbers (0-27) and
adds `GPIO_BASE` (512) internally:

```
gpio-sysfs-ctl export 21       → exports sysfs gpio533
gpio-sysfs-ctl 21 set direction out
gpio-sysfs-ctl 21 set value 1  → turns on GPIO21
```

## sysfs ABI

```
/sys/class/gpio/
├── export          write pin number to create gpioN/
├── unexport        write pin number to remove gpioN/
└── gpioN/
    ├── direction   "in" or "out"
    ├── value       "0" or "1"
    ├── edge        "none", "rising", "falling", "both"
    └── active_low  "0" or "1"
```
