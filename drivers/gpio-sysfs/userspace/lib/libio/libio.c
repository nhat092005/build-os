// SPDX-License-Identifier: GPL-2.0
/*
 * GPIO Control Library Implementation
 * 
 * This library provides functions to control Linux GPIO pins 
 * via the sysfs interface. It allows userspace applications 
 * to easily manipulate GPIO pins without needing to interact 
 * with sysfs directly.
 */

#include "libio.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <fcntl.h>
#include <errno.h>
#include <ctype.h>
#include <limits.h>
#include <sys/stat.h>
#include <dirent.h>

/* Internal helper prototypes */

/**
 * write_sysfs - Helper to write a string value to a sysfs file
 * @path: Path to sysfs file
 * @value: String value to write
 * Return: 0 on success, negative errno on failure
 */
static int write_sysfs(const char *path, const char *value);

/**
 * read_sysfs - Helper to read a string value from a sysfs file
 * @path: Path to sysfs file
 * @buffer: Buffer to store the read value
 * @size: Size of the buffer
 * Return: 0 on success, negative errno on failure
 */
static int read_sysfs(const char *path, char *buffer, size_t size);

int gpio_export(const char *gpio_pin)
{
	return write_sysfs(GPIO_EXPORT_PATH, gpio_pin);
}

int gpio_unexport(const char *gpio_pin)
{
	return write_sysfs(GPIO_UNEXPORT_PATH, gpio_pin);
}

int gpio_open(gpio_sysfs_device_t *gpio, const char *gpio_pin)
{
	if (!gpio || !gpio_pin)
		return -EINVAL;

	strncpy(gpio->gpio_pin, gpio_pin, sizeof(gpio->gpio_pin) - 1);
	gpio->gpio_pin[sizeof(gpio->gpio_pin) - 1] = '\0';

	snprintf(gpio->base_path, sizeof(gpio->base_path),
			 "%s/gpio%s", GPIO_SYSFS_PATH, gpio_pin);
	snprintf(gpio->value_path, sizeof(gpio->value_path),
			 "%s/gpio%s/value", GPIO_SYSFS_PATH, gpio_pin);
	snprintf(gpio->direction_path, sizeof(gpio->direction_path),
			 "%s/gpio%s/direction", GPIO_SYSFS_PATH, gpio_pin);
	snprintf(gpio->edge_path, sizeof(gpio->edge_path),
			 "%s/gpio%s/edge", GPIO_SYSFS_PATH, gpio_pin);
	snprintf(gpio->active_low_path, sizeof(gpio->active_low_path),
			 "%s/gpio%s/active_low", GPIO_SYSFS_PATH, gpio_pin);

	/* Verify the sysfs directory exists (i.e., the GPIO has been exported) */
	if (access(gpio->base_path, F_OK) != 0)
		return -ENODEV;

	return 0;
}

int gpio_set_direction(gpio_sysfs_device_t *gpio, const char *direction)
{
	return write_sysfs(gpio->direction_path, direction);
}

int gpio_get_direction(gpio_sysfs_device_t *gpio, char *buffer, size_t size)
{
	return read_sysfs(gpio->direction_path, buffer, size);
}

int gpio_set_value(gpio_sysfs_device_t *gpio, int value)
{
	return write_sysfs(gpio->value_path, value ? "1" : "0");
}

int gpio_get_value(gpio_sysfs_device_t *gpio, int *value)
{
	char buf[4];
	int ret;
	char *endptr;
	long parsed;

	ret = read_sysfs(gpio->value_path, buf, sizeof(buf));
	if (ret < 0)
		return ret;

	errno = 0;
	parsed = strtol(buf, &endptr, 10);
	if (errno != 0 || endptr == buf) {
		/* Kernel should always write "0" or "1" — treat as I/O error */
		return -EIO;
	}

	*value = (int)parsed;
	return 0;
}

int gpio_set_edge(gpio_sysfs_device_t *gpio, const char *edge)
{
	return write_sysfs(gpio->edge_path, edge);
}

int gpio_get_edge(gpio_sysfs_device_t *gpio, char *buffer, size_t size)
{
	return read_sysfs(gpio->edge_path, buffer, size);
}

int gpio_set_active_low(gpio_sysfs_device_t *gpio, int active_low)
{
	return write_sysfs(gpio->active_low_path, active_low ? "1" : "0");
}

int gpio_get_active_low(gpio_sysfs_device_t *gpio, int *active_low)
{
	char buf[4];
	int ret;
	char *endptr;
	long parsed;

	ret = read_sysfs(gpio->active_low_path, buf, sizeof(buf));
	if (ret < 0)
		return ret;

	errno = 0;
	parsed = strtol(buf, &endptr, 10);
	if (errno != 0 || endptr == buf) {
		return -EIO;
	}

	*active_low = (int)parsed;
	return 0;
}

int gpio_get_info(gpio_sysfs_device_t *gpio, gpio_sysfs_info_t *info)
{
	int ret;

	if (!gpio || !info)
		return -EINVAL;

	strncpy(info->gpio_pin, gpio->gpio_pin, sizeof(info->gpio_pin) - 1);
	info->gpio_pin[sizeof(info->gpio_pin) - 1] = '\0';

	ret = gpio_get_direction(gpio, info->direction, sizeof(info->direction));
	if (ret < 0)
		return ret;

	ret = gpio_get_edge(gpio, info->edge, sizeof(info->edge));
	if (ret < 0)
		return ret;

	ret = gpio_get_value(gpio, &info->value);
	if (ret < 0)
		return ret;

	ret = gpio_get_active_low(gpio, &info->active_low);
	if (ret < 0)
		return ret;

	return 0;
}

int gpio_list(gpio_list_callback_t callback, void *user_data)
{
	DIR *dir;
	struct dirent *entry;
	char path[GPIO_BUFFER_SIZE];
	struct stat st;
	int ret = 0;
	int count = 0;

	dir = opendir(GPIO_SYSFS_PATH);
	if (!dir)
		return -errno;

	while ((entry = readdir(dir)) != NULL)
	{
		if (strncmp(entry->d_name, "gpio", 4) != 0)
			continue;
		if (!isdigit((unsigned char)entry->d_name[4]))
			continue;

		snprintf(path, sizeof(path), "%s/%s", GPIO_SYSFS_PATH, entry->d_name);
		if (stat(path, &st) != 0 || !S_ISDIR(st.st_mode))
			continue;

		ret = callback(entry->d_name, user_data);
		count++;
		if (ret != 0)
			break;
	}

	closedir(dir);

	if (ret != 0)
		return ret;
	return count;
}

const char *gpio_strerror(int errnum)
{
	if (errnum > 0)
		errnum = -errnum;
	return strerror(-errnum);
}

int parse_int(const char *str, int *result)
{
	char *endptr;
	long val;

	if (!str || !result)
		return -EINVAL;

	errno = 0;
	val = strtol(str, &endptr, 10);
	if (errno != 0 || endptr == str || *endptr != '\0')
		return -EINVAL;
	if (val < INT_MIN || val > INT_MAX)
		return -ERANGE;

	*result = (int)val;
	return 0;
}

/**
 * write_sysfs - Helper to write a string value to a sysfs file
 * @path: Path to sysfs file
 * @value: String value to write
 * Return: 0 on success, negative errno on failure
 */
static int write_sysfs(const char *path, const char *value)
{
	int fd;
	ssize_t ret;
	size_t len = strlen(value);

	fd = open(path, O_WRONLY);
	if (fd < 0)
		return -errno;

	do {
		ret = write(fd, value, len);
	} while (ret < 0 && errno == EINTR);

	if (ret < 0)
	{
		int err = -errno;
		close(fd);
		return err;
	}

	if ((size_t)ret != len)
	{
		close(fd);
		return -EIO; /* partial write */
	}

	close(fd);
	return 0;
}

/**
 * read_sysfs - Helper to read a string value from a sysfs file
 * @path: Path to sysfs file
 * @buffer: Buffer to store result
 * @size: Size of buffer
 * Return: 0 on success, negative errno on failure
 */
static int read_sysfs(const char *path, char *buffer, size_t size)
{
	int fd;
	ssize_t ret;

	fd = open(path, O_RDONLY);
	if (fd < 0)
		return -errno;

	do {
		ret = read(fd, buffer, size - 1);
	} while (ret < 0 && errno == EINTR);

	if (ret < 0)
	{
		int err = -errno;
		close(fd);
		return err;
	}

	buffer[ret] = '\0';
	if (ret > 0 && buffer[ret - 1] == '\n')
		buffer[ret - 1] = '\0';

	close(fd);
	return 0;
}