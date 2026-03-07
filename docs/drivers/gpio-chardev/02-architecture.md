# Architecture: GPIO Chardev

## System Diagram

```
┌────────────────────────────────────────────────┐
│ HARDWARE: LED → GPIO21                         │
└───────────────────┬────────────────────────────┘
                    │ gpiod_set_value / gpiod_get_value
┌───────────────────▼────────────────────────────┐
│ gpio_chardev.ko                                │
│                                                │
│ Platform driver (DTS-configured)               │
│   ├─ devm_gpiod_get() → GPIO descriptor        │
│   ├─ alloc_chrdev_region() → major number       │
│   ├─ class_create() → /sys/class/gpio-chardev   │
│   ├─ cdev_device_add() → /dev/gpio-chardev      │
│   └─ delayed_work → blink support               │
│                                                │
│ Interfaces:                                    │
│   /dev/gpio-chardev (read/write/ioctl)         │
│   ioctl: SET_STATE, GET_STATE, TOGGLE,         │
│          GET_GPIO, BLINK                       │
└────────────────────────────────────────────────┘
```

## Design Decisions

### Why cdev instead of misc device?

The driver uses manual `alloc_chrdev_region()` + `cdev_device_add()` for
full control over device naming and registration. This creates
`/dev/gpio-chardev` with proper sysfs integration.

### Blink via delayed_work

Blink is implemented in-kernel using `delayed_work`:

- `count=0` means infinite blink
- Each work invocation toggles the GPIO and reschedules
- `cancel_delayed_work_sync()` in remove() ensures clean shutdown

### Concurrency

- `mutex` serializes all file_ops and ioctl calls
- Blink work handler also acquires the mutex
- `mutex_lock_interruptible()` for userspace-facing paths
