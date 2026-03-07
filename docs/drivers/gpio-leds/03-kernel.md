# Kernel Driver: GPIO LEDs

## Module Registration

```c
module_platform_driver(gpio_leds_driver);
```

**Driver ID table:**

```c
static const struct of_device_id gpio_leds_of_match[] = {
	{ .compatible = "custom,gpio-led" },
	{ }
};
```

## Private Data Structure

```c
struct gpio_leds_data {
	struct led_classdev cdev;
	struct gpio_desc *desc;
	const char *label;
	bool retain_state;
	int saved_brightness;
};
```

## probe()

1. Parse DT properties: `label`, `default-state`, `default-trigger`, `retain-state-suspend`
2. `devm_gpiod_get(dev, NULL, GPIOD_OUT_LOW|HIGH)` — based on default-state
3. Configure `led_classdev`:
   - `cdev.name = label`
   - `cdev.brightness_set_blocking = gpio_leds_brightness_set`
   - `cdev.max_brightness = 1` (GPIO: binary on/off)
   - `cdev.default_trigger` from DTS
4. `devm_led_classdev_register(dev, &cdev)` — register with LED class
5. Create custom sysfs: `gpio_state` (show), `gpio_pin` (show)

**Expected dmesg:**

```
gpio-leds gpio-leds: Probing GPIO LED driver v1.0.0
gpio-leds gpio-leds: LED 'gpio-led' registered on GPIO20
```

## remove()

Minimal — all resources devm-managed. Logs removal message.

## Custom sysfs Attributes

```c
static DEVICE_ATTR_RO(gpio_state);   /* 0444 — shows 0/1 */
static DEVICE_ATTR_RO(gpio_pin);     /* 0444 — shows BCM pin number */
```

| Attribute    | Permission | Returns                             |
| ------------ | ---------- | ----------------------------------- |
| `gpio_state` | 0444       | "0\n" or "1\n"                      |
| `gpio_pin`   | 0444       | hardware GPIO number (e.g. "532\n") |

The `gpio_pin` value includes `GPIO_BASE` (512). Userspace subtracts
GPIO_BASE to get the BCM pin.

## Kbuild

```makefile
obj-m += gpio_leds.o
```
