# gpio-chardev

A Linux kernel character device driver that controls a single GPIO pin through standard file operations and ioctl commands. The driver creates a device node at `/dev/gpio-chardev`.

## Directory Structure

```
gpio-chardev/
├── Makefile
├── include/
│   ├── gpio-chardev.h              # Internal kernel header (device struct, constants)
│   └── uapi/
│       └── gpio-chardev.h          # User-kernel shared header (ioctl definitions)
├── src/
│   ├── Makefile
│   └── gpio-chardev.c              # Kernel module source
└── userspace/
    ├── Makefile
    └── tools/
        └── gpio-chardev-ctl.c      # Userspace command-line tool
```

## Kernel Module

### GPIO Access Method

The module uses a GPIO lookup table (`gpiod_lookup_table`) registered at load time to request the GPIO pin through the `gpiod` consumer API. It creates a platform device (`gpio-led-pdev`) as the GPIO consumer. This approach does not require Device Tree support.

### Module Parameter

| Parameter  | Type | Default | Description                |
| ---------- | ---- | ------- | -------------------------- |
| `gpio_pin` | int  | 17      | GPIO pin number to control |

### File Operations

- **read**: Returns the current GPIO state as a string (`"0\n"` or `"1\n"`).
- **write**: Accepts `"0"` or `"1"` to set the GPIO state.
- **ioctl**: Provides structured control commands (see below).

### IOCTL Commands

Defined in `include/uapi/gpio-chardev.h` using magic number `'G'`:

| Command                      | Direction | Description                                  |
| ---------------------------- | --------- | -------------------------------------------- |
| `GPIO_CHARDEV_IOC_SET_STATE` | Write     | Set GPIO to ON (1) or OFF (0)                |
| `GPIO_CHARDEV_IOC_GET_STATE` | Read      | Get current GPIO state                       |
| `GPIO_CHARDEV_IOC_TOGGLE`    | None      | Toggle GPIO state                            |
| `GPIO_CHARDEV_IOC_GET_GPIO`  | Read      | Get the configured GPIO pin number           |
| `GPIO_CHARDEV_IOC_BLINK`     | Write     | Start a blink sequence using a kernel thread |

### Blink

The `GPIO_CHARDEV_IOC_BLINK` command accepts a `struct gpio_chardev_blink` with the following fields:

| Field       | Type    | Description                           |
| ----------- | ------- | ------------------------------------- |
| `count`     | `__u32` | Number of blink cycles (0 = infinite) |
| `delay_on`  | `__u32` | ON duration in milliseconds           |
| `delay_off` | `__u32` | OFF duration in milliseconds          |

Blinking runs in a dedicated kernel thread (`gpio_chardev_blink`). Issuing a new blink command stops any active blink thread before starting a new one. The LED is turned off when the thread exits.

### Initialization and Cleanup

On load, the module:

1. Allocates and registers a GPIO lookup table for `pinctrl-bcm2711`.
2. Creates a platform device and requests the GPIO descriptor.
3. Allocates a character device region, initializes a `cdev`, creates a device class and device node.

On unload, the module stops any running blink thread, turns off the LED, and releases all resources in reverse order.

## Userspace Tool: gpio-chardev-ctl

A command-line utility that communicates with the driver through the ioctl interface. It opens `/dev/gpio-chardev` and executes the requested command.

### Commands

```
gpio-chardev-ctl on                                  # Turn GPIO on
gpio-chardev-ctl off                                 # Turn GPIO off
gpio-chardev-ctl toggle                              # Toggle GPIO state
gpio-chardev-ctl get                                 # Get current state
gpio-chardev-ctl gpio                                # Get GPIO pin number
gpio-chardev-ctl blink <count> <on_ms> <off_ms>      # Start blinking
```

## Build

```
make all             # Build kernel module and userspace tool
make modules         # Build kernel module only
make tools           # Build userspace tool only
make clean           # Clean all build artifacts
```
