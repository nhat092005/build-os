// SPDX-License-Identifier: GPL-2.0
/*
 * gpio_helpers.c — C wrappers for inline GPIO functions + misc char device
 *
 * In kernel 6.x, legacy GPIO API functions (gpio_request, gpio_free,
 * gpio_direction_output, gpio_set_value, gpio_get_value) are defined as
 * static inline functions in <linux/gpio.h>. This means they don't exist
 * as linkable symbols and cannot be called directly from Rust FFI.
 *
 * This file provides:
 *   1. Non-inline wrapper functions that Rust can call via extern "C"
 *      declarations (rust_helper_gpio_*).
 *   2. A misc character device (/dev/gpio-rust) that exposes the GPIO
 *      state to userspace via read/write/ioctl. The Rust module calls
 *      rust_helper_misc_register() / rust_helper_misc_deregister() to
 *      manage the device lifecycle.
 */

#include <linux/module.h>
#include <linux/gpio.h>
#include <linux/miscdevice.h>
#include <linux/fs.h>
#include <linux/uaccess.h>

#include "../include/uapi/gpio-rust.h"
#include "../include/gpio-rust.h"

/* Prototypes — suppress -Wmissing-prototypes */
int rust_helper_gpio_request(unsigned int gpio, const char *label);
void rust_helper_gpio_free(unsigned int gpio);
int rust_helper_gpio_direction_output(unsigned int gpio, int value);
void rust_helper_gpio_set_value(unsigned int gpio, int value);
int rust_helper_gpio_get_value(unsigned int gpio);

/*
 * Wrappers use the rust_helper_ prefix convention from the kernel's
 * Rust helpers, which avoids symbol name collisions.
 */

int rust_helper_gpio_request(unsigned int gpio, const char *label)
{
	return gpio_request(gpio, label);
}
EXPORT_SYMBOL_GPL(rust_helper_gpio_request);

void rust_helper_gpio_free(unsigned int gpio)
{
	gpio_free(gpio);
}
EXPORT_SYMBOL_GPL(rust_helper_gpio_free);

int rust_helper_gpio_direction_output(unsigned int gpio, int value)
{
	return gpio_direction_output(gpio, value);
}
EXPORT_SYMBOL_GPL(rust_helper_gpio_direction_output);

void rust_helper_gpio_set_value(unsigned int gpio, int value)
{
	gpio_set_value(gpio, value);
}
EXPORT_SYMBOL_GPL(rust_helper_gpio_set_value);

int rust_helper_gpio_get_value(unsigned int gpio)
{
	return gpio_get_value(gpio);
}
EXPORT_SYMBOL_GPL(rust_helper_gpio_get_value);

/* ------------------------------------------------------------------ */
/* Misc character device for userspace control (/dev/gpio-rust)       */
/* ------------------------------------------------------------------ */

/* GPIO pin number (global sysfs number, set by Rust module at init) */
static unsigned int gpio_rust_ctl_pin;

/* Hardware BCM pin number (for reporting to userspace) */
static unsigned int gpio_rust_hw_pin;

static ssize_t gpio_rust_dev_read(struct file *filp, char __user *buf,
				  size_t count, loff_t *ppos)
{
	char kbuf[4];
	int len, value;

	if (*ppos > 0)
		return 0;

	value = gpio_get_value(gpio_rust_ctl_pin);
	len = snprintf(kbuf, sizeof(kbuf), "%d\n", value);

	if ((size_t)len > count)
		len = count;

	if (copy_to_user(buf, kbuf, len))
		return -EFAULT;

	*ppos += len;
	return len;
}

static ssize_t gpio_rust_dev_write(struct file *filp, const char __user *buf,
				   size_t count, loff_t *ppos)
{
	char kbuf[4];
	int value;
	size_t len;

	if (count == 0)
		return 0;

	len = min(count, sizeof(kbuf) - 1);
	if (copy_from_user(kbuf, buf, len))
		return -EFAULT;
	kbuf[len] = '\0';

	if (kstrtoint(kbuf, 10, &value))
		return -EINVAL;
	if (value != 0 && value != 1)
		return -EINVAL;

	gpio_set_value(gpio_rust_ctl_pin, value);
	return count;
}

static long gpio_rust_dev_ioctl(struct file *filp, unsigned int cmd,
				unsigned long arg)
{
	__u32 value;

	switch (cmd) {
	case GPIO_RUST_IOC_SET_STATE:
		if (copy_from_user(&value, (__u32 __user *)arg, sizeof(value)))
			return -EFAULT;
		if (value != GPIO_RUST_OFF && value != GPIO_RUST_ON)
			return -EINVAL;
		gpio_set_value(gpio_rust_ctl_pin, value);
		break;

	case GPIO_RUST_IOC_GET_STATE:
		value = gpio_get_value(gpio_rust_ctl_pin);
		if (copy_to_user((__u32 __user *)arg, &value, sizeof(value)))
			return -EFAULT;
		break;

	case GPIO_RUST_IOC_TOGGLE:
		value = !gpio_get_value(gpio_rust_ctl_pin);
		gpio_set_value(gpio_rust_ctl_pin, value);
		break;

	case GPIO_RUST_IOC_GET_GPIO:
		value = gpio_rust_hw_pin;
		if (copy_to_user((__u32 __user *)arg, &value, sizeof(value)))
			return -EFAULT;
		break;

	default:
		return -ENOTTY;
	}

	return 0;
}

static const struct file_operations gpio_rust_dev_fops = {
	.owner          = THIS_MODULE,
	.read           = gpio_rust_dev_read,
	.write          = gpio_rust_dev_write,
	.unlocked_ioctl = gpio_rust_dev_ioctl,
};

static struct miscdevice gpio_rust_miscdev = {
	.minor = MISC_DYNAMIC_MINOR,
	.name  = GPIO_RUST_DRIVER_NAME,
	.fops  = &gpio_rust_dev_fops,
};

/*
 * rust_helper_misc_register - Register the /dev/gpio-rust misc device
 * @pin:    Global GPIO number (e.g. 534)
 * @hw_pin: Hardware BCM GPIO number (e.g. 22)
 *
 * Called from the Rust module's init() function.
 * Return: 0 on success, negative errno on failure
 */
int rust_helper_misc_register(unsigned int pin, unsigned int hw_pin);
int rust_helper_misc_register(unsigned int pin, unsigned int hw_pin)
{
	gpio_rust_ctl_pin = pin;
	gpio_rust_hw_pin  = hw_pin;
	return misc_register(&gpio_rust_miscdev);
}
EXPORT_SYMBOL_GPL(rust_helper_misc_register);

/*
 * rust_helper_misc_deregister - Deregister the /dev/gpio-rust misc device
 *
 * Called from the Rust module's drop() function.
 */
void rust_helper_misc_deregister(void);
void rust_helper_misc_deregister(void)
{
	misc_deregister(&gpio_rust_miscdev);
}
EXPORT_SYMBOL_GPL(rust_helper_misc_deregister);
