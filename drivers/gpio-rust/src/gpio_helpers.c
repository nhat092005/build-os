// SPDX-License-Identifier: GPL-2.0
/*
 * GPIO Rust Driver - C Helper Functions
 *
 * This file implements C helper functions that wrap kernel GPIO APIs and
 * expose a misc char device for user-space interaction. The actual GPIO logic
 * is owned by Rust; C only handles buffer copies and delegates to Rust handlers.
 */

#include <linux/module.h>
#include <linux/gpio.h>
#include <linux/miscdevice.h>
#include <linux/fs.h>
#include <linux/uaccess.h>
#include <linux/mutex.h>

#include "../include/uapi/gpio-rust.h"
#include "../include/gpio-rust.h"

/* Prototypes — suppress -Wmissing-prototypes */

/* Section 1: GPIO API wrappers for Rust Layer 3 */

/**
 * rust_helper_gpio_request - Request control of a GPIO pin
 * @gpio: GPIO pin number (hardware BCM pin)
 * @label: Human-readable label for the GPIO (for debugging)
 * Return: 0 on success, negative errno on failure
 */
int rust_helper_gpio_request(unsigned int gpio, const char *label);

/**
 * rust_helper_gpio_free - Release control of a GPIO pin
 * @gpio: GPIO pin number (hardware BCM pin)
 */
void rust_helper_gpio_free(unsigned int gpio);

/**
 * rust_helper_gpio_direction_output - Set GPIO pin as output and initial value
 * @gpio: GPIO pin number (hardware BCM pin)
 * @value: Initial value (0=off, 1=on)
 * Return: 0 on success, negative errno on failure
 */
int rust_helper_gpio_direction_output(unsigned int gpio, int value);

/**
 * rust_helper_gpio_set_value - Set GPIO pin value
 * @gpio: GPIO pin number (hardware BCM pin)
 * @value: Value to set (0=off, 1=on)
 */
void rust_helper_gpio_set_value(unsigned int gpio, int value);

/**
 * rust_helper_gpio_get_value - Get GPIO pin value
 * @gpio: GPIO pin number (hardware BCM pin)
 * Return: Current value (0=off, 1=on)
 */
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

/* Section 2: Misc char device — file_ops delegate to Rust Layer 4    */

/*
 * Rust-exported handler functions (defined in gpio_driver.rs, Layer 4).
 * All GPIO logic is owned by Rust; C only handles buffer copies.
 */
extern int rust_gpio_handle_get_value(void);
extern void rust_gpio_handle_set_value(int value);
extern unsigned int rust_gpio_handle_get_hw_pin(void);

/* Serialize file_operations to prevent concurrent GPIO access */

static DEFINE_MUTEX(gpio_rust_lock);

/**
 * gpio_rust_dev_read - Handle read() on /dev/gpio-rust
 * @filp: File pointer (unused)
 * @buf: User buffer to copy GPIO state into
 * @count: Size of user buffer
 * @ppos: File position pointer (used to allow single read)
 * Return: Number of bytes read on success, negative errno on failure
 */
static ssize_t gpio_rust_dev_read(struct file *filp, char __user *buf,
				  size_t count, loff_t *ppos)
{
	char kbuf[4];
	int len, value;

	if (*ppos > 0)
		return 0;

	mutex_lock(&gpio_rust_lock);
	value = rust_gpio_handle_get_value();
	mutex_unlock(&gpio_rust_lock);

	len = snprintf(kbuf, sizeof(kbuf), "%d\n", value);

	if ((size_t)len > count)
		len = count;

	if (copy_to_user(buf, kbuf, len))
		return -EFAULT;

	*ppos += len;
	return len;
}

/**
 * gpio_rust_dev_write - Handle write() on /dev/gpio-rust
 * @filp: File pointer (unused)
 * @buf: User buffer containing new GPIO state ("0" or "1")
 * @count: Size of user buffer
 * @ppos: File position pointer (unused)
 * Return: Number of bytes written on success, negative errno on failure
 */
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

	mutex_lock(&gpio_rust_lock);
	rust_gpio_handle_set_value(value);
	mutex_unlock(&gpio_rust_lock);

	return count;
}

/**
 * gpio_rust_dev_ioctl - Handle ioctl() on /dev/gpio-rust
 * @filp: File pointer (unused)
 * @cmd: IOCTL command code
 * @arg: IOCTL argument (pointer to user data)
 * Return: 0 on success, negative errno on failure
 */
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
		mutex_lock(&gpio_rust_lock);
		rust_gpio_handle_set_value(value);
		mutex_unlock(&gpio_rust_lock);
		break;

	case GPIO_RUST_IOC_GET_STATE:
		mutex_lock(&gpio_rust_lock);
		value = rust_gpio_handle_get_value();
		mutex_unlock(&gpio_rust_lock);
		if (copy_to_user((__u32 __user *)arg, &value, sizeof(value)))
			return -EFAULT;
		break;

	case GPIO_RUST_IOC_TOGGLE:
		mutex_lock(&gpio_rust_lock);
		value = !rust_gpio_handle_get_value();
		rust_gpio_handle_set_value(value);
		mutex_unlock(&gpio_rust_lock);
		break;

	case GPIO_RUST_IOC_GET_GPIO:
		value = rust_gpio_handle_get_hw_pin();
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
 *
 * Called from the Rust module's init(). GPIO pin state is managed entirely
 * by Rust via atomic globals; this function only registers the miscdevice.
 * Return: 0 on success, negative errno on failure
 */
int rust_helper_misc_register(void);
int rust_helper_misc_register(void)
{
	return misc_register(&gpio_rust_miscdev);
}
EXPORT_SYMBOL_GPL(rust_helper_misc_register);

/*
 * rust_helper_misc_deregister - Deregister the /dev/gpio-rust misc device
 *
 * Called from the Rust module's drop(). Blocks until all in-flight
 * file_operations complete before returning.
 */
void rust_helper_misc_deregister(void);
void rust_helper_misc_deregister(void)
{
	misc_deregister(&gpio_rust_miscdev);
}
EXPORT_SYMBOL_GPL(rust_helper_misc_deregister);
