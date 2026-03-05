// SPDX-License-Identifier: GPL-2.0-or-later
/*
 * GPIO LED Driver - LED Class Interface with Device Tree Support
 *
 * This driver provides LED control through GPIO pins using the standard
 * Linux LED class interface with Device Tree support. It follows mainline
 * kernel conventions and is suitable for production use.
 */

#include <linux/module.h>
#include <linux/kernel.h>
#include <linux/platform_device.h>
#include <linux/leds.h>
#include <linux/gpio/consumer.h>
#include <linux/of.h>
#include <linux/property.h>
#include <linux/slab.h>

#include "../include/gpio_leds.h"

/**
 * gpio_led_set_brightness() - Set LED brightness
 * @cdev: LED class device
 * @brightness: Brightness value (0=off, >0=on)
 *
 * This function is called by LED core to set LED brightness.
 * For simple GPIO LEDs, we only support ON/OFF (no PWM yet).
 *
 * Return: 0 on success, negative error code on failure
 */
static int gpio_led_set_brightness(struct led_classdev *cdev,
				   enum led_brightness brightness)
{
	struct gpio_led_data *led =
		container_of(cdev, struct gpio_led_data, cdev);
	int value;

	/* Convert brightness to logical GPIO value.
	 * Active-low polarity is handled automatically by the gpiod
	 * descriptor layer based on DTS flags — no software inversion.
	 */
	value = brightness ? 1 : 0;

	/* Use appropriate GPIO function based on sleep capability */
	if (led->can_sleep)
		gpiod_set_value_cansleep(led->gpiod, value);
	else
		gpiod_set_value(led->gpiod, value);

	return 0;
}

/**
 * gpio_led_get_brightness() - Get current LED brightness
 * @cdev: LED class device
 *
 * Return: Current brightness value (LED_OFF or LED_FULL)
 */
static enum led_brightness gpio_led_get_brightness(struct led_classdev *cdev)
{
	struct gpio_led_data *led =
		container_of(cdev, struct gpio_led_data, cdev);
	int value;

	/* gpiod_get_value() returns logical value adjusted for polarity */
	if (led->can_sleep)
		value = gpiod_get_value_cansleep(led->gpiod);
	else
		value = gpiod_get_value(led->gpiod);

	if (value < 0) {
		dev_err_ratelimited(cdev->dev->parent,
				    "Failed to read GPIO: %d\n", value);
		return LED_OFF;
	}

	return value ? LED_FULL : LED_OFF;
}

/**
 * gpio_led_parse_dt() - Parse Device Tree properties
 * @dev: Device pointer
 * @led: GPIO LED data structure
 *
 * Parses LED configuration from Device Tree including:
 * - LED label (name in sysfs)
 * - Default trigger (heartbeat, timer, etc.)
 * - Default state (on/off/keep)
 * - Active-low flag
 * - Suspend behavior
 *
 * Return: 0 on success, negative error code on failure
 */
static int gpio_led_parse_dt(struct device *dev, struct gpio_led_data *led)
{
	const char *state;
	const char *label;
	const char *trigger;
	int ret;

	/* Get LED label (name in sysfs) */
	ret = device_property_read_string(dev, "label", &label);
	if (ret) {
		/* Fallback to device name if no label specified */
		label = dev_name(dev);
		dev_dbg(dev, "No label specified, using device name: %s\n",
			label);
	}
	led->cdev.name = devm_kstrdup(dev, label, GFP_KERNEL);
	if (!led->cdev.name)
		return -ENOMEM;

	/* Get default trigger (optional) */
	ret = device_property_read_string(dev, "linux,default-trigger",
					  &trigger);
	if (!ret) {
		led->cdev.default_trigger =
			devm_kstrdup(dev, trigger, GFP_KERNEL);
		if (!led->cdev.default_trigger)
			return -ENOMEM;
		dev_dbg(dev, "Default trigger: %s\n", trigger);
	}

	/* Get default state */
	ret = device_property_read_string(dev, "default-state", &state);
	if (!ret) {
		if (strcmp(state, "on") == 0) {
			led->default_state = LED_FULL;
			dev_dbg(dev, "Default state: ON\n");
		} else if (strcmp(state, "keep") == 0) {
			led->default_state = LED_FULL; /* Keep current state */
			dev_dbg(dev, "Default state: KEEP\n");
		} else {
			led->default_state = LED_OFF;
			dev_dbg(dev, "Default state: OFF\n");
		}
	} else {
		led->default_state = LED_OFF;
	}

	/*
	 * Active-low polarity is handled by the gpiod descriptor layer
	 * via the DTS gpios flags cell (GPIO_ACTIVE_LOW).  No software
	 * active-low property is needed.
	 */

	/* Check if state should be retained during suspend */
	led->retain_state_suspended =
		device_property_read_bool(dev, "retain-state-suspended");
	if (led->retain_state_suspended) {
		led->cdev.flags |= LED_CORE_SUSPENDRESUME;
		dev_dbg(dev, "LED state will be retained during suspend\n");
	}

	return 0;
}

/**
 * gpio_state_show() - Expose current GPIO logical state via sysfs
 * @dev: LED class device
 * @attr: Device attribute (unused)
 * @buf: Output buffer
 *
 * Shows the current logical output state of the GPIO (0=off, 1=on).
 * The gpiod API already adjusts for active-low polarity, so the returned
 * value is always the logical state.
 * Read from: /sys/class/leds/<name>/gpio_state
 *
 * Return: Number of bytes written to buf
 */
static ssize_t gpio_state_show(struct device *dev,
			       struct device_attribute *attr, char *buf)
{
	struct led_classdev *cdev = dev_get_drvdata(dev);
	struct gpio_led_data *led =
		container_of(cdev, struct gpio_led_data, cdev);
	int val;

	if (led->can_sleep)
		val = gpiod_get_value_cansleep(led->gpiod);
	else
		val = gpiod_get_value(led->gpiod);

	if (val < 0)
		return val;

	/* gpiod_get_value() returns logical value — no manual inversion */
	return sysfs_emit(buf, "%d\n", val);
}
static DEVICE_ATTR_RO(gpio_state);

/**
 * gpio_pin_show() - Expose hardware GPIO pin number via sysfs
 * @dev: LED class device
 * @attr: Device attribute (unused)
 * @buf: Output buffer
 *
 * Shows the hardware GPIO number backing this LED.
 * Read from: /sys/class/leds/<name>/gpio_pin
 *
 * Return: Number of bytes written to buf
 */
static ssize_t gpio_pin_show(struct device *dev, struct device_attribute *attr,
			     char *buf)
{
	struct led_classdev *cdev = dev_get_drvdata(dev);
	struct gpio_led_data *led =
		container_of(cdev, struct gpio_led_data, cdev);

	return sysfs_emit(buf, "%d\n", desc_to_gpio(led->gpiod));
}
static DEVICE_ATTR_RO(gpio_pin);

/* Extra sysfs attributes appended to the LED class device */
static struct attribute *gpio_led_attrs[] = {
	&dev_attr_gpio_state.attr,
	&dev_attr_gpio_pin.attr,
	NULL,
};

static const struct attribute_group gpio_led_group = {
	.attrs = gpio_led_attrs,
};

static const struct attribute_group *gpio_led_groups[] = {
	&gpio_led_group,
	NULL,
};

/**
 * gpio_led_probe() - Probe function for GPIO LED device
 * @pdev: Platform device
 *
 * This function is called when a device matching this driver is found.
 * It performs the following:
 * 1. Allocates memory for LED data structure
 * 2. Parses Device Tree properties
 * 3. Requests GPIO from Device Tree
 * 4. Configures GPIO direction and initial state
 * 5. Registers LED with LED subsystem
 *
 * Return: 0 on success, negative error code on failure
 */
static int gpio_led_probe(struct platform_device *pdev)
{
	struct device *dev = &pdev->dev;
	struct gpio_led_data *led;
	int ret;

	dev_info(dev, "Probing GPIO LED driver v%s\n",
		 GPIO_LEDS_DRIVER_VERSION);

	/* Allocate memory for LED data */
	led = devm_kzalloc(dev, sizeof(*led), GFP_KERNEL);
	if (!led)
		return -ENOMEM;

	/* Parse Device Tree properties */
	ret = gpio_led_parse_dt(dev, led);
	if (ret) {
		dev_err(dev, "Failed to parse Device Tree properties: %d\n",
			ret);
		return ret;
	}

	/*
	 * Get GPIO descriptor from Device Tree.
	 * Use GPIOD_OUT_HIGH or GPIOD_OUT_LOW to set direction + initial
	 * logical value at acquisition time.  The gpiod layer handles
	 * active-low inversion based on the DTS flags cell automatically.
	 */
	led->gpiod = devm_gpiod_get(dev, NULL,
				    led->default_state == LED_FULL ?
					    GPIOD_OUT_HIGH :
					    GPIOD_OUT_LOW);
	if (IS_ERR(led->gpiod)) {
		ret = PTR_ERR(led->gpiod);
		dev_err(dev, "Failed to get GPIO descriptor: %d\n", ret);
		return ret;
	}

	/* Check if GPIO operations may sleep */
	led->can_sleep = gpiod_cansleep(led->gpiod);

	/* Setup LED class device */
	led->cdev.brightness_set_blocking = gpio_led_set_brightness;
	led->cdev.brightness_get = gpio_led_get_brightness;
	led->cdev.max_brightness = LED_FULL;
	led->cdev.brightness = led->default_state;

	/* Attach extra sysfs attributes (gpio_pin) */
	led->cdev.groups = gpio_led_groups;

	/* Register LED class device with LED subsystem */
	ret = devm_led_classdev_register(dev, &led->cdev);
	if (ret) {
		dev_err(dev, "Failed to register LED class device: %d\n", ret);
		return ret;
	}

	/* Store LED data in platform device */
	platform_set_drvdata(pdev, led);

	dev_info(dev, "LED '%s' registered\n", led->cdev.name);
	dev_dbg(dev, "  Interface: /sys/class/leds/%s/\n", led->cdev.name);

	return 0;
}

/**
 * gpio_led_remove() - Remove function for GPIO LED device
 * @pdev: Platform device
 *
 * This function is called when the device is removed.
 * Cleanup is handled automatically by devm_* functions.
 */
static void gpio_led_remove(struct platform_device *pdev)
{
	struct gpio_led_data *led = platform_get_drvdata(pdev);

	dev_info(&pdev->dev, "Removing LED '%s'\n", led->cdev.name);

	/* All cleanup is automatic via devm_* */
}

/**
 * gpio_led_suspend() - Suspend function
 * @dev: Device pointer
 *
 * Called when system enters suspend state.
 * If retain_state_suspended is false, turns off LED.
 *
 * Return: 0 on success
 */
static int gpio_led_suspend(struct device *dev)
{
	struct gpio_led_data *led = dev_get_drvdata(dev);

	if (!led->retain_state_suspended) {
		dev_dbg(dev, "Turning off LED during suspend\n");
		gpio_led_set_brightness(&led->cdev, LED_OFF);
	}

	return 0;
}

/**
 * gpio_led_resume() - Resume function
 * @dev: Device pointer
 *
 * Called when system resumes from suspend.
 * If retain_state_suspended is false, restores LED state.
 *
 * Return: 0 on success
 */
static int gpio_led_resume(struct device *dev)
{
	struct gpio_led_data *led = dev_get_drvdata(dev);
	int ret;

	if (!led->retain_state_suspended) {
		ret = gpio_led_set_brightness(&led->cdev, led->cdev.brightness);
		if (ret)
			dev_warn(
				dev,
				"Failed to restore LED state after resume: %d\n",
				ret);
	}

	return 0;
}

/* Power management operations */
static DEFINE_SIMPLE_DEV_PM_OPS(gpio_led_pm_ops, gpio_led_suspend,
				gpio_led_resume);

/* Device Tree match table */
static const struct of_device_id gpio_led_of_match[] = {
	{ .compatible = "custom,gpio-led" },
	{}
};
MODULE_DEVICE_TABLE(of, gpio_led_of_match);

/* Platform driver structure */
static struct platform_driver gpio_led_driver = {
	.probe = gpio_led_probe,
	.remove = gpio_led_remove,
	.driver = {
		.name = GPIO_LEDS_DRIVER_NAME,
		.of_match_table = gpio_led_of_match,
		.pm = pm_sleep_ptr(&gpio_led_pm_ops),
	},
};

/* Register platform driver using module_platform_driver macro */
module_platform_driver(gpio_led_driver);

MODULE_AUTHOR("nhat092005");
MODULE_DESCRIPTION(
	"GPIO LED Driver - LED Class Interface with Device Tree Support");
MODULE_LICENSE("GPL");
MODULE_VERSION(GPIO_LEDS_DRIVER_VERSION);
MODULE_ALIAS("platform:" GPIO_LEDS_DRIVER_NAME);
