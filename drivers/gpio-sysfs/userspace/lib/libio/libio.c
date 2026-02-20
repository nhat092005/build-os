// SPDX-License-Identifier: GPL-2.0
/*
 * libio - GPIO Control Library Implementation
 * Library for controlling Linux GPIO sysfs interface
 */

#include "libio.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <fcntl.h>
#include <errno.h>
#include <sys/stat.h>
#include <dirent.h>

/* Internal helper functions */

/**
 * write_sysfs - Write a string value to a sysfs file
 * @path: Path to the sysfs file
 * @value: String value to write
 * Return: 0 on success, negative errno on failure
 */
static int write_sysfs(const char *path, const char *value);

/**
 * read_sysfs - Read a string value from a sysfs file
 * @path: Path to the sysfs file
 * @buffer: Buffer to store the read value
 * @size: Size of the buffer
 * Return: 0 on success, negative errno on failure
 */
static int read_sysfs(const char *path, char *buffer, size_t size);

/* Public API Implementation */

int gpio_export(const char *gpio_pin)
{
	return write_sysfs(GPIO_EXPORT_PATH, gpio_pin);
}

int gpio_unexport(const char *gpio_pin)
{
	return write_sysfs(GPIO_UNEXPORT_PATH, gpio_pin);
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
	char buffer[4];
	int ret = read_sysfs(gpio->value_path, buffer, sizeof(buffer));
	if (ret < 0)
		return ret;
	*value = (buffer[0] == '1') ? 1 : 0;
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
	char buffer[4];
	int ret = read_sysfs(gpio->active_low_path, buffer, sizeof(buffer));
	if (ret < 0)
		return ret;
	*active_low = (buffer[0] == '1') ? 1 : 0;
	return 0;
}

int gpio_list(gpio_list_callback_t callback, void *user_data)
{
	DIR *dir;
	struct dirent *entry;
	int ret = 0;
	int count = 0;

	dir = opendir(GPIO_SYSFS_PATH);
	if (!dir)
		return -errno;

	while ((entry = readdir(dir)) != NULL)
	{
		if (entry->d_type == DT_DIR &&
			strncmp(entry->d_name, "gpio", 4) == 0 &&
			isdigit(entry->d_name[4])) // eliminate gpiochip
		{
			ret = callback(entry->d_name, user_data);
			count++;

			if (ret != 0)
				break;
		}
	}

	closedir(dir);

	if (ret != 0)
		return ret;

	return count;
}

const char *gpio_strerror(int errnum)
{
	/* Convert positive error to negative */
	if (errnum > 0)
		errnum = -errnum;

	/* Use standard strerror for errno values */
	return strerror(-errnum);
}

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