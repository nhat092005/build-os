# Userspace: GPIO Rust

## Library: libgpio-rust

Provides a C API over the `/dev/gpio-rust` character device using ioctls.

### API

```c
int gpio_rust_open(gpio_rust_device_t *dev);
void gpio_rust_close(gpio_rust_device_t *dev);

int gpio_rust_set_value(gpio_rust_device_t *dev, int value);
int gpio_rust_get_value(gpio_rust_device_t *dev, int *value);
int gpio_rust_toggle(gpio_rust_device_t *dev);
int gpio_rust_get_info(gpio_rust_device_t *dev, gpio_rust_info_t *info);
int gpio_rust_blink(gpio_rust_device_t *dev, int count, int delay_ms);
```

**`gpio_rust_device_t`** holds the open file descriptor to the misc device.

## CLI Tool: gpio-rust-ctl

Command-line interface to the `libgpio-rust` functions.

### Usage

```
gpio-rust-ctl <command> [options]

Commands:
  on                          Turn LED on (GPIO HIGH)
  off                         Turn LED off (GPIO LOW)
  get                         Get current LED state
  toggle                      Toggle LED state
  blink <count> <delay_ms>    Blink LED
  status                      Show GPIO pin info
  help                        Show this help
```

### Examples

```bash
# Toggle the LED
gpio-rust-ctl toggle
# Output: GPIO 16: ON

# Blink 5 times, 200ms delay between states
gpio-rust-ctl blink 5 200
# Output:
# Blinking GPIO 16: 5 times, 200ms interval
# Blink complete

# Get full status
gpio-rust-ctl status
# Output:
#   Driver:     gpio-rust
#   GPIO Pin:   16
#   Direction:  out
#   Value:      1 (ON)
#   Device:     /dev/gpio-rust
```
