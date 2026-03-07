# Userspace: GPIO Sysfs

## Library API: libio

### `gpio_export(const char *gpio_pin)`

Export a GPIO pin via `/sys/class/gpio/export`.
Returns 0 on success, negative errno on failure.

### `gpio_unexport(const char *gpio_pin)`

Unexport a GPIO pin via `/sys/class/gpio/unexport`.

### `gpio_open(gpio_sysfs_device_t *gpio, const char *gpio_pin)`

Initialize a device handle. Fills all sysfs path strings.
Returns `-ENODEV` if GPIO is not exported.

### `gpio_set_direction(gpio, "in"|"out")`

Write to `.../direction` sysfs file.

### `gpio_set_value(gpio, 0|1)`

Write to `.../value` sysfs file.

### `gpio_set_edge(gpio, "none"|"rising"|"falling"|"both")`

Write to `.../edge` sysfs file.

### `gpio_set_active_low(gpio, 0|1)`

Write to `.../active_low` sysfs file.

### `gpio_get_info(gpio, info)`

Read all attributes at once into a `gpio_sysfs_info_t`.

### `gpio_list(callback, user_data)`

Enumerate all exported GPIOs via `readdir()` on `/sys/class/gpio/`.
Returns count of GPIOs found.

## CLI Tool: gpio-sysfs-ctl

### Usage

```
gpio-sysfs-ctl <command> [args...]

Commands:
  list                              List all exported GPIOs
  export <pin>                      Export GPIO pin (BCM number)
  unexport <pin>                    Unexport GPIO pin (BCM number)
  <pin> set direction <in|out>      Set direction
  <pin> get direction               Get direction
  <pin> set value <0|1>             Set output value
  <pin> get value                   Get current value
  <pin> set edge <none|rising|falling|both>  Set edge trigger
  <pin> get edge                    Get edge setting
  <pin> set active_low <0|1>        Set polarity inversion
  <pin> get active_low              Get polarity setting
  <pin> blink <count> <delay_ms>    Blink GPIO (toggle on/off)
  <pin> info                        Show all GPIO attributes
```

`<pin>` is always the BCM GPIO number (0-27). The tool adds `GPIO_BASE`
(512) automatically to form the sysfs GPIO number.

### Examples

```bash
# Export GPIO 21, set as output, turn on LED
gpio-sysfs-ctl export 21
gpio-sysfs-ctl 21 set direction out
gpio-sysfs-ctl 21 set value 1
# Output: GPIO 21: ON

# Show all attributes
gpio-sysfs-ctl 21 info
# Output:
#   GPIO:       533
#   Direction:  OUTPUT
#   Edge:       NONE
#   Value:      1
#   Active Low: ACTIVE_HIGH

# Blink 5 times with 500ms delay
gpio-sysfs-ctl 21 blink 5 500

# Clean up
gpio-sysfs-ctl unexport 21
```
