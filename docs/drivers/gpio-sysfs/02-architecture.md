# Architecture: GPIO Sysfs

## System Diagram

```
┌─────────────────────────────────────────────────────────────┐
│ HARDWARE                                                    │
│ BCM2711 GPIO Controller                                     │
└───────────────────────┬─────────────────────────────────────┘
                        │ SoC Internal Bus
┌───────────────────────▼─────────────────────────────────────┐
│ KERNEL SPACE                                                │
│                                                             │
│ Built-in GPIO sysfs driver (deprecated in 4.x)              │
│ Exposes sysfs ABI at /sys/class/gpio/                       │
│                                                             │
│ Kernel Interface:                                           │
│   /sys/class/gpio/export                                    │
│   /sys/class/gpio/unexport                                  │
│   /sys/class/gpio/gpioN/direction                           │
│   /sys/class/gpio/gpioN/value                               │
└───────────────────────┬─────────────────────────────────────┘
                        │ open(), read(), write() on sysfs
┌───────────────────────▼─────────────────────────────────────┐
│ USERSPACE                                                   │
│                                                             │
│ libio.c                                                     │
│ ├─► gpio_export()                                           │
│ ├─► gpio_set_direction()                                    │
│ └─► gpio_set_value()                                        │
│                                                             │
│ gpio-sysfs-ctl                                              │
│ └─► CLI argument parsing -> libio calls                     │
└─────────────────────────────────────────────────────────────┘
```

## Design Decisions

### Built-in Sysfs ABI

Because the standard Linux kernel exposes GPIOs via sysfs, **no custom kernel module is needed**. This approach was historically the standard way to toggle GPIOs from userspace scripts and programs.

### Why Deprecated?

The sysfs interface has several critical flaws that led to its deprecation:

1. **No lifecycle management**: If a userspace process exports a pin, changes its state, and crashes, the pin remains exported and in its modified state.
2. **Race conditions**: The separation of `export`, `direction`, and `value` into different sysfs files means configuring a pin is not an atomic operation.
3. **No bulk operations**: Toggling multiple pins requires multiple synchronous file system writes.

For new designs in this OS, the `gpio-chardev` driver is preferred as it relies on file descriptors (automatically closing/reverting on process crash) and atomic `ioctl` calls. However, `gpio-sysfs` is retained here as an educational example of sysfs interactions from C.

## Kernel↔Userspace Boundary

- **Kernel**: Handles hardware access, exposes `/sys/class/gpio/*` files. No custom kernel code is compiled for this driver.
- **Userspace**: Takes full responsibility for exporting the pin, configuring direction, and writing/reading values.

## Data Flow

### Write path (userspace → hardware)

```
userspace: gpio-sysfs-ctl 21 set value 1
    │
    ▼ libio calls
    │ 1. snprintf path: /sys/class/gpio/gpio533/value
    │ 2. fd = open(path, O_WRONLY)
    │ 3. write(fd, "1\n", 2)
    │ 4. close(fd)
    ▼
kernel: sysfs -> gpiolib -> hardware register
```

## Kernel APIs Used

_(No kernel module is written, so no kernel headers are included directly.)_

## Concurrency Model

Userspace `libio.c` uses standard POSIX file I/O.
There is no internal mutex in `libio.c`. If multiple threads or processes attempt to write to the same sysfs file concurrently, they may interleave or clobber the configuration due to the non-atomic nature of the sysfs API.

## Dependencies

| Dependency | Where     | Why                                                          |
| ---------- | --------- | ------------------------------------------------------------ |
| sysfs      | userspace | Relies on sysfs being mounted at `/sys`                      |
| `libc`     | userspace | Standard POSIX file I/O (`open`, `read`, `write`, `readdir`) |

## Limitations

| Limitation        | Impact                                      | Workaround                                                                |
| ----------------- | ------------------------------------------- | ------------------------------------------------------------------------- |
| Sysfs Deprecation | May be removed in future kernels            | Migrate to `gpio-chardev`                                                 |
| State Leakage     | Process crash leaves pin configured         | None, must manually `unexport`                                            |
| Performance       | sysfs file open/close per operation is slow | Keep fd open for tight loops, but `libio` currently opens/closes per call |
