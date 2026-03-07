# Userspace: GPIO Chardev

## CLI Tool: gpio-chardev-ctl

Direct ioctl-based control tool for `/dev/gpio-chardev`. No library —
includes UAPI header directly.

### Usage

```
gpio-chardev-ctl <command> [options]

Commands:
  on                              Turn GPIO on
  off                             Turn GPIO off
  toggle                          Toggle GPIO state
  get                             Get GPIO state
  gpio                            Get GPIO pin number
  blink [count] [on_ms] [off_ms]  Blink GPIO
```

Device path: `/dev/gpio-chardev`
GPIO_CHARDEV_BASE: 512 (subtracted for display)

### Examples

```bash
# Turn on
gpio-chardev-ctl on
# Output: GPIO 21: ON

# Toggle
gpio-chardev-ctl toggle
# Output: GPIO 21: TOGGLED
#         GPIO 21: OFF

# Get state
gpio-chardev-ctl get
# Output: GPIO 21 state: OFF

# Get GPIO pin
gpio-chardev-ctl gpio
# Output: GPIO pin: 533

# Blink 5 times, 500ms on, 250ms off
gpio-chardev-ctl blink 5 500 250
# Output: Blinking GPIO 21: 5 times (500ms on, 250ms off)
```

### Implementation

The tool opens `/dev/gpio-chardev` with `O_RDWR`, then issues ioctl calls:

- `GPIO_CHARDEV_IOC_SET_STATE` with `GPIO_CHARDEV_ON`/`OFF`
- `GPIO_CHARDEV_IOC_GET_STATE` — returns state as unsigned int
- `GPIO_CHARDEV_IOC_TOGGLE` — no argument
- `GPIO_CHARDEV_IOC_GET_GPIO` — returns sysfs GPIO number
- `GPIO_CHARDEV_IOC_BLINK` — `struct gpio_chardev_blink`
