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

The module binds to a platform device node defined via a Device Tree Overlay (`dts/gpio-chardev-overlay.dts`). It requests the GPIO descriptor through the `devm_gpiod_get()` API.

### Device Tree Overlay (DTO) Configurations

By default, the overlay configures **GPIO 21** as output. You can load this overlay dynamically in `/boot/config.txt`.

The overlay supports the `__overrides__` node, allowing you to dynamically change the GPIO pin at boot time without recompiling the DTS.

**Example in `/boot/config.txt`:**
```ini
# Use default GPIO 21
dtoverlay=gpio-chardev-overlay

# Override to use GPIO 17 instead
dtoverlay=gpio-chardev-overlay,gpio=17
```

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

Blinking runs in a dedicated delayed workqueue. Issuing a new blink command cancels any active blink work before starting a new one. The LED is turned off when the blink process completes or is canceled.

### Initialization and Cleanup

On load, the module:

1. Registers a platform driver `gpio-chardev`.
2. Upon successful probe (when the driver binds to the device tree node), it extracts the GPIO pin using `devm_gpiod_get()`.
3. Allocates a character device region, initializes a `cdev`, creates a device class and device node at `/dev/gpio-chardev`.

On unload/remove, the module stops any running blink queue, turns off the LED, and the managed (`devm_`) framework safely releases resources in reverse order.

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
