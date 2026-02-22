// SPDX-License-Identifier: GPL-2.0
/*
 * LED Control Library Implementation
 *
 * This library provides functions to control Linux LED class devices via sysfs.
 * It allows userspace applications to easily manipulate LED brightness, triggers,
 * and other attributes without needing to interact with sysfs directly.
 */

#include "libled.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <fcntl.h>
#include <errno.h>
#include <sys/stat.h>
#include <limits.h>
#include <dirent.h>

/* Internal helper functions */
static int write_sysfs(const char *path, const char *value);
static int read_sysfs(const char *path, char *buffer, size_t size);

/**
 * write_sysfs - Write a value to a sysfs file
 * @path: Path to the sysfs file
 * @value: Value to write (string)
 * Return: 0 on success, negative errno on failure
 */
static int write_sysfs(const char *path, const char *value)
{
	int fd, ret;
	ssize_t len;

	fd = open(path, O_WRONLY);
	if (fd < 0)
		return -errno;

	len = strlen(value);
	ret = write(fd, value, len);
	if (ret < 0)
	{
		ret = -errno;
		close(fd);
		return ret;
	}

	close(fd);
	return 0;
}

/**
 * read_sysfs - Read a value from a sysfs file
 * @path: Path to the sysfs file
 * @buffer: Buffer to store the read value
 * @size: Size of the buffer
 * Return: 0 on success, negative errno on failure
 */
static int read_sysfs(const char *path, char *buffer, size_t size)
{
	int fd, ret;

	fd = open(path, O_RDONLY);
	if (fd < 0)
		return -errno;

	ret = read(fd, buffer, size - 1);
	if (ret < 0)
	{
		ret = -errno;
		close(fd);
		return ret;
	}

	buffer[ret] = '\0';
	/* Remove trailing newline if present */
	if (ret > 0 && buffer[ret - 1] == '\n')
		buffer[ret - 1] = '\0';

	close(fd);
	return 0;
}

/* Public API Implementation */

int led_open(led_device_t *led, const char *name)
{
	struct stat st;
	int ret;
	size_t name_len;

	if (!led || !name)
		return -EINVAL;

	/* Validate name length to prevent truncation */
	name_len = strlen(name);
	if (name_len == 0)
		return -EINVAL;

	/* Maximum safe LED name length calculation:
	 * LED_BUFFER_SIZE - strlen("/sys/class/leds/") - strlen("/max_brightness") - 1
	 * = 512 - 17 - 16 - 1 = 478 chars
	 */
	if (name_len > 478)
		return -ENAMETOOLONG;

	memset(led, 0, sizeof(*led));

	/* Safe copy with explicit null termination */
	strncpy(led->name, name, LED_BUFFER_SIZE - 1);
	led->name[LED_BUFFER_SIZE - 1] = '\0';

	/* Build base path with return value check */
	ret = snprintf(led->path, LED_BUFFER_SIZE, "%s/%s", LED_BASE_PATH, name);
	if (ret < 0 || ret >= LED_BUFFER_SIZE)
		return -ENAMETOOLONG;

	/* Check if LED device exists */
	if (stat(led->path, &st) < 0)
		return -ENOENT;

	/* Build all sysfs paths with return value checks */
	ret = snprintf(led->brightness_path, LED_BUFFER_SIZE,
				   "%s/brightness", led->path);
	if (ret < 0 || ret >= LED_BUFFER_SIZE)
		return -ENAMETOOLONG;

	ret = snprintf(led->trigger_path, LED_BUFFER_SIZE,
				   "%s/trigger", led->path);
	if (ret < 0 || ret >= LED_BUFFER_SIZE)
		return -ENAMETOOLONG;

	ret = snprintf(led->max_brightness_path, LED_BUFFER_SIZE,
				   "%s/max_brightness", led->path);
	if (ret < 0 || ret >= LED_BUFFER_SIZE)
		return -ENAMETOOLONG;

	ret = snprintf(led->delay_on_path, LED_BUFFER_SIZE,
				   "%s/delay_on", led->path);
	if (ret < 0 || ret >= LED_BUFFER_SIZE)
		return -ENAMETOOLONG;

	ret = snprintf(led->delay_off_path, LED_BUFFER_SIZE,
				   "%s/delay_off", led->path);
	if (ret < 0 || ret >= LED_BUFFER_SIZE)
		return -ENAMETOOLONG;

	ret = snprintf(led->gpio_pin_path, LED_BUFFER_SIZE,
				   "%s/gpio_pin", led->path);
	if (ret < 0 || ret >= LED_BUFFER_SIZE)
		return -ENAMETOOLONG;

	return 0;
}

void led_close(led_device_t *led)
{
	/* Currently no resources to free, but keep for API consistency */
	(void)led;
}

int led_set_brightness(led_device_t *led, int value)
{
	char buffer[16];

	if (!led)
		return -EINVAL;

	snprintf(buffer, sizeof(buffer), "%d", value);
	return write_sysfs(led->brightness_path, buffer);
}

int led_get_brightness(led_device_t *led)
{
	char buffer[16];
	char *endptr;
	long val;
	int ret;

	if (!led)
		return -EINVAL;

	ret = read_sysfs(led->brightness_path, buffer, sizeof(buffer));
	if (ret < 0)
		return ret;

	errno = 0;
	val = strtol(buffer, &endptr, 10);
	if (errno != 0 || endptr == buffer || val < 0 || val > INT_MAX)
		return -EIO;

	return (int)val;
}

int led_get_max_brightness(led_device_t *led)
{
	char buffer[16];
	char *endptr;
	long val;
	int ret;

	if (!led)
		return -EINVAL;

	ret = read_sysfs(led->max_brightness_path, buffer, sizeof(buffer));
	if (ret < 0)
		return ret;

	errno = 0;
	val = strtol(buffer, &endptr, 10);
	if (errno != 0 || endptr == buffer || val < 0 || val > INT_MAX)
		return -EIO;

	return (int)val;
}

int led_on(led_device_t *led)
{
	int max_brightness;

	if (!led)
		return -EINVAL;

	max_brightness = led_get_max_brightness(led);
	if (max_brightness < 0)
		max_brightness = 255; /* Default fallback */

	return led_set_brightness(led, max_brightness);
}

int led_off(led_device_t *led)
{
	if (!led)
		return -EINVAL;

	return led_set_brightness(led, 0);
}

int led_set_trigger(led_device_t *led, const char *trigger)
{
	if (!led || !trigger)
		return -EINVAL;

	return write_sysfs(led->trigger_path, trigger);
}

int led_get_trigger(led_device_t *led, char *buffer, size_t size)
{
	if (!led || !buffer || size == 0)
		return -EINVAL;

	return read_sysfs(led->trigger_path, buffer, size);
}

int led_set_timer(led_device_t *led, int delay_on_ms, int delay_off_ms)
{
	char buffer[16];
	int ret;

	if (!led)
		return -EINVAL;

	/* Set timer trigger first */
	ret = led_set_trigger(led, "timer");
	if (ret < 0)
		return ret;

	/* Set delay_on */
	snprintf(buffer, sizeof(buffer), "%d", delay_on_ms);
	ret = write_sysfs(led->delay_on_path, buffer);
	if (ret < 0)
		return ret;

	/* Set delay_off */
	snprintf(buffer, sizeof(buffer), "%d", delay_off_ms);
	return write_sysfs(led->delay_off_path, buffer);
}

int led_blink(led_device_t *led, int count, int delay_ms)
{
	int i, ret;
	int max_brightness;

	if (!led)
		return -EINVAL;

	/* First set trigger to none for manual control */
	ret = led_set_trigger(led, "none");
	if (ret < 0)
		return ret;

	max_brightness = led_get_max_brightness(led);
	if (max_brightness < 0)
		max_brightness = 255;

	/* Blink loop */
	for (i = 0; count == 0 || i < count; i++)
	{
		/* Turn on */
		ret = led_set_brightness(led, max_brightness);
		if (ret < 0)
			return ret;

		usleep(delay_ms * 1000);

		/* Turn off */
		ret = led_set_brightness(led, 0);
		if (ret < 0)
			return ret;

		usleep(delay_ms * 1000);
	}

	return 0;
}

int led_pulse(led_device_t *led, int duration_ms, int steps)
{
	int max_brightness, step_delay, i, brightness;
	int ret;

	if (!led || steps <= 0)
		return -EINVAL;

	/* Set trigger to none for manual control */
	ret = led_set_trigger(led, "none");
	if (ret < 0)
		return ret;

	max_brightness = led_get_max_brightness(led);
	if (max_brightness < 0)
		max_brightness = 255;

	step_delay = (duration_ms * 1000) / (steps * 2); /* Microseconds per step */

	/* Fade in */
	for (i = 0; i <= steps; i++)
	{
		brightness = (max_brightness * i) / steps;
		ret = led_set_brightness(led, brightness);
		if (ret < 0)
			return ret;
		usleep(step_delay);
	}

	/* Fade out */
	for (i = steps; i >= 0; i--)
	{
		brightness = (max_brightness * i) / steps;
		ret = led_set_brightness(led, brightness);
		if (ret < 0)
			return ret;
		usleep(step_delay);
	}

	return 0;
}

int led_list(led_list_callback_t callback, void *user_data)
{
	DIR *dir;
	struct dirent *entry;
	int count = 0;
	int ret;

	if (!callback)
		return -EINVAL;

	dir = opendir(LED_BASE_PATH);
	if (!dir)
		return -errno;

	while ((entry = readdir(dir)) != NULL)
	{
		/* Skip hidden files and "." ".." */
		if (entry->d_name[0] == '.')
			continue;

		count++;
		ret = callback(entry->d_name, user_data);
		if (ret != 0)
		{
			closedir(dir);
			return count;
		}
	}

	closedir(dir);
	return count;
}

int led_get_info(led_device_t *led, led_info_t *info)
{
	int ret;

	if (!led || !info)
		return -EINVAL;

	memset(info, 0, sizeof(*info));

	/* Copy name safely - use memcpy since we know source is null-terminated */
	{
		size_t name_len = strlen(led->name);
		if (name_len >= LED_BUFFER_SIZE)
			name_len = LED_BUFFER_SIZE - 1;
		memcpy(info->name, led->name, name_len);
		info->name[name_len] = '\0';
	}

	/* Get brightness */
	ret = led_get_brightness(led);
	if (ret < 0)
		return ret;
	info->brightness = ret;

	/* Get max brightness */
	ret = led_get_max_brightness(led);
	if (ret < 0)
		return ret;
	info->max_brightness = ret;

	/* Get trigger */
	ret = led_get_trigger(led, info->trigger, sizeof(info->trigger));
	if (ret < 0)
		return ret;

	/* Get GPIO pin number (may be absent on non-gpio-leds drivers) */
	ret = led_get_gpio_pin(led);
	info->gpio_pin = (ret >= 0) ? ret : -1;

	return 0;
}

int led_get_gpio_pin(led_device_t *led)
{
	char buffer[16];
	char *endptr;
	long val;
	int ret;

	if (!led)
		return -EINVAL;

	ret = read_sysfs(led->gpio_pin_path, buffer, sizeof(buffer));
	if (ret < 0)
		return ret;

	errno = 0;
	val = strtol(buffer, &endptr, 10);
	if (errno != 0 || endptr == buffer || val < 0 || val > INT_MAX)
		return -EIO;

	return (int)val;
}

int led_exists(const char *name)
{
	char path[LED_BUFFER_SIZE];
	struct stat st;

	if (!name)
		return -EINVAL;

	snprintf(path, sizeof(path), "%s/%s", LED_BASE_PATH, name);

	if (stat(path, &st) < 0)
		return 0; /* Does not exist */

	return 1; /* Exists */
}

const char *led_strerror(int errnum)
{
	/* Convert positive error to negative */
	if (errnum > 0)
		errnum = -errnum;

	/* Use standard strerror for errno values */
	return strerror(-errnum);
}