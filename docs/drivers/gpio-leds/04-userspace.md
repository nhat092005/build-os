# Userspace: GPIO LEDs

## Library: libled

LED control library wrapping `/sys/class/leds/<name>/` sysfs operations.

### API

```c
int led_open(led_device_t *led, const char *name);
void led_close(led_device_t *led);

/* Basic control */
int led_on(led_device_t *led);
int led_off(led_device_t *led);
int led_set_brightness(led_device_t *led, int value);
int led_get_brightness(led_device_t *led);       /* returns brightness */
int led_get_max_brightness(led_device_t *led);   /* returns max */

/* Triggers */
int led_set_trigger(led_device_t *led, const char *trigger);
int led_get_trigger(led_device_t *led, char *buf, size_t size);
int led_set_timer(led_device_t *led, int on_ms, int off_ms);

/* Effects */
int led_blink(led_device_t *led, int count, int delay_ms);
int led_pulse(led_device_t *led, int duration_ms, int steps);

/* Info */
int led_get_info(led_device_t *led, led_info_t *info);
int led_get_gpio_pin(led_device_t *led);   /* returns raw GPIO number */
int led_list(led_list_callback_t cb, void *user_data);
int led_exists(const char *name);
```

### Data Types

**`led_device_t`** — wraps sysfs paths for brightness, trigger, delay_on/off, gpio_pin

**`led_info_t`** — snapshot: name, brightness, max_brightness, trigger, gpio_pin

## CLI Tool: gpio-leds-ctl

### Usage

```
gpio-leds-ctl [options] <command> [args...]

Options:
  -d, --device NAME    LED device name (default: "gpio-led")
  -h, --help           Show help

Commands:
  on                          Turn LED on (max brightness)
  off                         Turn LED off
  set <brightness>            Set brightness (0-max)
  get                         Get current brightness
  trigger [name]              Set or get trigger
  blink [count] [delay_ms]    Blink LED (default: 10× 500ms)
  timer [on_ms] [off_ms]      Set timer trigger (default: 500/500)
  pulse [duration] [steps]    Pulse LED (fade, default: 3000ms 50 steps)
  info                        Show LED information
```

### Examples

```bash
# Turn on
gpio-leds-ctl on
# Output: GPIO 20 (gpio-led): ON

# Set trigger to heartbeat
gpio-leds-ctl trigger heartbeat
# Output: GPIO 20 (gpio-led): trigger set to 'heartbeat'

# Blink 5 times, 200ms interval
gpio-leds-ctl blink 5 200

# Timer trigger: 1s on, 500ms off
gpio-leds-ctl timer 1000 500

# Info
gpio-leds-ctl info
# Output:
#   GPIO 20 (gpio-led)
#   Path:       /sys/class/leds/gpio-led
#   GPIO pin:   20
#   Brightness: 0 / 1
#   Trigger:    none

# Use different LED device
gpio-leds-ctl -d my-led on
```
