// SPDX-License-Identifier: GPL-2.0
/*
 * libgpio-rust - GPIO Rust Driver Control Library Implementation
 *
 * Provides userspace access to the gpio-rust kernel module via the
 * misc character device at /dev/gpio-rust.
 *
 * Operations:
 *   - read()  → current GPIO value ("0\n" or "1\n")
 *   - write() → set GPIO value ("0" or "1")
 *   - ioctl() → structured control (set/get/toggle/get_gpio)
 */

#include "libgpio-rust.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <fcntl.h>
#include <errno.h>

int gpio_rust_open(gpio_rust_device_t *dev)
{
	if (!dev)
		return -EINVAL;

	snprintf(dev->dev_path, sizeof(dev->dev_path), "%s",
		 GPIO_RUST_DEV_PATH);

	dev->fd = open(dev->dev_path, O_RDWR);
	if (dev->fd < 0)
		return -errno;

	return 0;
}

void gpio_rust_close(gpio_rust_device_t *dev)
{
	if (dev && dev->fd >= 0) {
		close(dev->fd);
		dev->fd = -1;
	}
}

int gpio_rust_set_value(gpio_rust_device_t *dev, int value)
{
	ssize_t ret;
	const char *val_str;

	if (!dev || dev->fd < 0)
		return -EBADF;

	val_str = value ? "1" : "0";
	ret = write(dev->fd, val_str, 1);
	if (ret < 0)
		return -errno;

	return 0;
}

int gpio_rust_get_value(gpio_rust_device_t *dev, int *value)
{
	uint32_t val;
	int ret;

	if (!dev || dev->fd < 0)
		return -EBADF;
	if (!value)
		return -EINVAL;

	ret = ioctl(dev->fd, GPIO_RUST_IOC_GET_STATE, &val);
	if (ret < 0)
		return -errno;

	*value = (int)val;
	return 0;
}

int gpio_rust_toggle(gpio_rust_device_t *dev)
{
	int ret;

	if (!dev || dev->fd < 0)
		return -EBADF;

	ret = ioctl(dev->fd, GPIO_RUST_IOC_TOGGLE);
	if (ret < 0)
		return -errno;

	return 0;
}

int gpio_rust_get_info(gpio_rust_device_t *dev, gpio_rust_info_t *info)
{
	uint32_t gpio_pin;
	int ret;

	if (!dev || !info)
		return -EINVAL;
	if (dev->fd < 0)
		return -EBADF;

	/* Get hardware GPIO pin number via ioctl */
	ret = ioctl(dev->fd, GPIO_RUST_IOC_GET_GPIO, &gpio_pin);
	if (ret < 0)
		return -errno;
	info->gpio_pin = (int)gpio_pin;

	/* Direction is always "out" for this driver */
	strncpy(info->direction, "out", sizeof(info->direction) - 1);
	info->direction[sizeof(info->direction) - 1] = '\0';

	/* Get current value */
	ret = gpio_rust_get_value(dev, &info->value);
	if (ret < 0)
		return ret;

	return 0;
}

int gpio_rust_blink(gpio_rust_device_t *dev, int count, int delay_ms)
{
	int i, ret;

	for (i = 0; i < count; i++) {
		ret = gpio_rust_set_value(dev, 1);
		if (ret < 0)
			return ret;
		usleep((useconds_t)delay_ms * 1000);

		ret = gpio_rust_set_value(dev, 0);
		if (ret < 0)
			return ret;
		if (i < count - 1)
			usleep((useconds_t)delay_ms * 1000);
	}

	return 0;
}

const char *gpio_rust_strerror(int errnum)
{
	if (errnum > 0)
		errnum = -errnum;
	return strerror(-errnum);
}
