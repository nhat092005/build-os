# gpio-sysfs

A userspace-only GPIO control tool that uses the kernel's built-in sysfs GPIO interface at `/sys/class/gpio/`. No custom kernel module is required; it works with any kernel that has the sysfs GPIO interface enabled.

## Directory Structure

```
gpio-sysfs/
├── Makefile
└── userspace/
    ├── Makefile
    ├── lib/
    │   └── libio/
    │       ├── libio.c             # GPIO sysfs control library
    │       └── libio.h             # Library API header
    └── tools/
        └── gpio-sysfs-ctl.c       # Command-line tool using libio
```

## How It Works

The sysfs GPIO interface exposes each exported pin as a directory under `/sys/class/gpio/gpio<N>/`. The tool reads and writes files in this directory to control the pin:

| Sysfs File                           | Purpose                                                      |
| ------------------------------------ | ------------------------------------------------------------ |
| `/sys/class/gpio/export`             | Export a pin to userspace                                    |
| `/sys/class/gpio/unexport`           | Release a pin                                                |
| `/sys/class/gpio/gpio<N>/direction`  | Set/get `in` or `out`                                        |
| `/sys/class/gpio/gpio<N>/value`      | Set/get `0` or `1`                                           |
| `/sys/class/gpio/gpio<N>/edge`       | Set/get interrupt edge (`none`, `rising`, `falling`, `both`) |
| `/sys/class/gpio/gpio<N>/active_low` | Invert polarity (`0` = active high, `1` = active low)        |

### Pin Number Mapping

The tool accepts a **GPIO offset** (0–based BCM pin number) and automatically adds `GPIO_BASE = 512` to get the sysfs pin number:

```
sysfs_pin = user_pin + 512
```

For example, BCM GPIO22 → sysfs pin 534 → `/sys/class/gpio/gpio534/`.

## Userspace Library: libio

Located in `userspace/lib/libio/`. Provides a thin wrapper around file I/O to `/sys/class/gpio/`.

### Data Structures

| Type                  | Description                                                         |
| --------------------- | ------------------------------------------------------------------- |
| `gpio_sysfs_device_t` | Handle containing pin number string and pre-built sysfs paths       |
| `gpio_sysfs_info_t`   | Snapshot of all pin attributes (direction, edge, value, active_low) |

### API

| Function                              | Description                                                  |
| ------------------------------------- | ------------------------------------------------------------ |
| `gpio_export(pin)`                    | Write pin to `/sys/class/gpio/export`                        |
| `gpio_unexport(pin)`                  | Write pin to `/sys/class/gpio/unexport`                      |
| `gpio_open(gpio, pin)`                | Initialize handle and verify pin is exported                 |
| `gpio_set_direction(gpio, dir)`       | Write `"in"` or `"out"` to direction file                    |
| `gpio_get_direction(gpio, buf, size)` | Read direction file into buffer                              |
| `gpio_set_value(gpio, value)`         | Write `0` or `1` to value file                               |
| `gpio_get_value(gpio, &value)`        | Read value file                                              |
| `gpio_set_edge(gpio, edge)`           | Write `"none"`, `"rising"`, `"falling"`, or `"both"`         |
| `gpio_get_edge(gpio, buf, size)`      | Read edge file                                               |
| `gpio_set_active_low(gpio, val)`      | Write `0` or `1` to active_low file                          |
| `gpio_get_active_low(gpio, &val)`     | Read active_low file                                         |
| `gpio_get_info(gpio, &info)`          | Read all attributes at once into `gpio_sysfs_info_t`         |
| `gpio_list(callback, user_data)`      | Enumerate exported GPIO directories, invoke callback per pin |
| `gpio_strerror(err)`                  | Convert negative errno to human-readable string              |

All functions return 0 on success or a negative errno value on failure.

## Userspace Tool: gpio-sysfs-ctl

Command-line tool built on `libio`. Commands follow the pattern `gpio-sysfs-ctl <pin> <command> [args]`.

### Commands

```
gpio-sysfs-ctl list                                 # List all exported GPIO pins
gpio-sysfs-ctl export <pin>                         # Export a GPIO pin
gpio-sysfs-ctl unexport <pin>                       # Unexport a GPIO pin

gpio-sysfs-ctl <pin> set direction <in|out>         # Set direction
gpio-sysfs-ctl <pin> get direction                  # Get current direction

gpio-sysfs-ctl <pin> set value <0|1>                # Set output value
gpio-sysfs-ctl <pin> get value                      # Get current value

gpio-sysfs-ctl <pin> set edge <none|rising|falling|both>  # Set interrupt edge
gpio-sysfs-ctl <pin> get edge                       # Get interrupt edge

gpio-sysfs-ctl <pin> set active_low <0|1>           # Set active-low polarity
gpio-sysfs-ctl <pin> get active_low                 # Get active-low setting

gpio-sysfs-ctl <pin> blink <count> <delay_ms>       # Blink pin N times
gpio-sysfs-ctl <pin> info                           # Show all pin attributes
```

### Example Session

```bash
# Export GPIO22, configure as output, turn on, blink 5 times, clean up
gpio-sysfs-ctl export 22
gpio-sysfs-ctl 22 set direction out
gpio-sysfs-ctl 22 set value 1
gpio-sysfs-ctl 22 blink 5 500
gpio-sysfs-ctl unexport 22
```

## Build

```
make all             # Build userspace tool and library (default)
make tools           # Build userspace tool only
make clean           # Clean all build artifacts
```