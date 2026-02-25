// SPDX-License-Identifier: GPL-2.0
/*
 * GPIO Control Utility
 *
 * This utility allows users to control GPIO pins from the command line
 * using the sysfs interface. It supports exporting/unexporting pins,
 * setting direction, value, edge, and active_low attributes, and more.
 */

#include "libio.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <stdarg.h>
#include <errno.h>

/**
 * print_error - Helper to print error messages
 * @fmt: Format string (printf-style)
 */
static void print_error(const char *fmt, ...);

/**
 * usage - Print usage information
 * @progname: Name of the program (argv[0])
 */
static void usage(const char *progname);

/* Command implementations */

/**
 * cmd_export - Handle 'export' command
 * @argc: Argument count (excluding command name)
 * @argv: Argument vector (excluding command name)
 * Return: 0 on success, non-zero on failure
 */
static int cmd_export(int argc, char *argv[]);

/**
 * cmd_unexport - Handle 'unexport' command
 * @argc: Argument count (excluding command name)
 * @argv: Argument vector (excluding command name)
 * Return: 0 on success, non-zero on failure
 */
static int cmd_unexport(int argc, char *argv[]);

/**
 * cmd_set_direction - Handle 'set direction' command
 * @gpio: GPIO device handle
 * @argc: Argument count (excluding command name)
 * @argv: Argument vector (excluding command name)
 * Return: 0 on success, non-zero on failure
 */
static int cmd_set_direction(gpio_sysfs_device_t *gpio, int argc, char *argv[]);

/**
 * cmd_get_direction - Handle 'get direction' command
 * @gpio: GPIO device handle
 * Return: 0 on success, non-zero on failure
 */
static int cmd_get_direction(gpio_sysfs_device_t *gpio);

/**
 * cmd_set_value - Handle 'set value' command
 * @gpio: GPIO device handle
 * @argc: Argument count (excluding command name)
 * @argv: Argument vector (excluding command name)
 * Return: 0 on success, non-zero on failure
 */
static int cmd_set_value(gpio_sysfs_device_t *gpio, int argc, char *argv[]);

/**
 * cmd_get_value - Handle 'get value' command
 * @gpio: GPIO device handle
 * Return: 0 on success, non-zero on failure
 */
static int cmd_get_value(gpio_sysfs_device_t *gpio);

/**
 * cmd_set_edge - Handle 'set edge' command
 * @gpio: GPIO device handle
 * @argc: Argument count (excluding command name)
 * @argv: Argument vector (excluding command name)
 * Return: 0 on success, non-zero on failure
 */
static int cmd_set_edge(gpio_sysfs_device_t *gpio, int argc, char *argv[]);

/**
 * cmd_get_edge - Handle 'get edge' command
 * @gpio: GPIO device handle
 * Return: 0 on success, non-zero on failure
 */
static int cmd_get_edge(gpio_sysfs_device_t *gpio);

/**
 * cmd_set_active_low - Handle 'set active_low' command
 * @gpio: GPIO device handle
 * @argc: Argument count (excluding command name)
 * @argv: Argument vector (excluding command name)
 * Return: 0 on success, non-zero on failure
 */
static int cmd_set_active_low(gpio_sysfs_device_t *gpio, int argc, char *argv[]);

/**
 * cmd_get_active_low - Handle 'get active_low' command
 * @gpio: GPIO device handle
 * Return: 0 on success, non-zero on failure
 */
static int cmd_get_active_low(gpio_sysfs_device_t *gpio);

/**
 * cmd_blink - Handle 'blink' command to toggle GPIO value
 * @gpio: GPIO device handle
 * @argc: Argument count (excluding command name)
 * @argv: Argument vector (excluding command name)
 * Return: 0 on success, non-zero on failure
 */
static int cmd_blink(gpio_sysfs_device_t *gpio, int argc, char *argv[]);

/**
 * cmd_info - Handle 'info' command to display GPIO information
 * @gpio: GPIO device handle
 * Return: 0 on success, non-zero on failure
 */
static int cmd_info(gpio_sysfs_device_t *gpio);

/**
 * cmd_list - Handle 'list' command to display all GPIO devices
 * Return: 0 on success, non-zero on failure
 */
static int cmd_list(void);

/**
 * list_callback - Callback for gpio_list to print GPIO names
 * @name: GPIO directory name (e.g., "gpio534")
 * @user_data: User-provided data (unused)
 * Return: 0 to continue listing, non-zero to stop
 */
static int list_callback(const char *name, void *user_data);

/**
 * gpio_pin_to_offset - Convert gpio_pin string back to BCM pin offset
 * @gpio: GPIO device handle
 * Return: BCM pin offset on success, -1 on parse error
 */
static int gpio_pin_to_offset(const gpio_sysfs_device_t *gpio);

int main(int argc, char *argv[])
{
	gpio_sysfs_device_t gpio;
	const char *cmd;
	const char *sub;
	int ret;

	if (argc < 2)
	{
		usage(argv[0]);
		return 1;
	}

	/*
	 * Runtime deprecation notice: /sys/class/gpio is deprecated since
	 * kernel 4.x.  Prefer the character-device interface (/dev/gpiochipN)
	 * via libgpiod or the gpio-chardev driver for new development.
	 */

	cmd = argv[1];

	if (strcmp(cmd, "list") == 0)
		return cmd_list();

	if (strcmp(cmd, "export") == 0)
		return cmd_export(argc - 2, argv + 2);

	if (strcmp(cmd, "unexport") == 0)
		return cmd_unexport(argc - 2, argv + 2);

	/* argv[1] = pin, argv[2] = sub-command */
	if (argc < 3)
	{
		print_error("Expected: <pin> <command> [args]");
		usage(argv[0]);
		return 1;
	}

	char str_pin[16];
	int pin_offset;

	if (parse_int(cmd, &pin_offset) != 0)
	{
		print_error("Invalid GPIO pin offset '%s': not a valid integer", cmd);
		return 1;
	}
	snprintf(str_pin, sizeof(str_pin), "%d", pin_offset + GPIO_BASE);

	ret = gpio_open(&gpio, str_pin); /* str_pin = pin number string + 512 */

	if (ret < 0)
	{
		print_error("Failed to open GPIO %s: %s", str_pin, gpio_strerror(ret));
		return 1;
	}

	sub = argv[2];

	if (strcmp(sub, "set") == 0)
	{
		if (argc < 4)
		{
			print_error("Missing argument after 'set'");
			return 1;
		}
		if (strcmp(argv[3], "direction") == 0)
			return cmd_set_direction(&gpio, argc - 4, argv + 4);
		if (strcmp(argv[3], "value") == 0)
			return cmd_set_value(&gpio, argc - 4, argv + 4);
		if (strcmp(argv[3], "edge") == 0)
			return cmd_set_edge(&gpio, argc - 4, argv + 4);
		if (strcmp(argv[3], "active_low") == 0)
			return cmd_set_active_low(&gpio, argc - 4, argv + 4);
		print_error("Unknown 'set' target: %s", argv[3]);
		return 1;
	}

	if (strcmp(sub, "get") == 0)
	{
		if (argc < 4)
		{
			print_error("Missing argument after 'get'");
			return 1;
		}
		if (strcmp(argv[3], "direction") == 0)
			return cmd_get_direction(&gpio);
		if (strcmp(argv[3], "value") == 0)
			return cmd_get_value(&gpio);
		if (strcmp(argv[3], "edge") == 0)
			return cmd_get_edge(&gpio);
		if (strcmp(argv[3], "active_low") == 0)
			return cmd_get_active_low(&gpio);
		print_error("Unknown 'get' target: %s", argv[3]);
		return 1;
	}

	if (strcmp(sub, "blink") == 0)
		return cmd_blink(&gpio, argc - 3, argv + 3);

	if (strcmp(sub, "info") == 0)
		return cmd_info(&gpio);

	print_error("Unknown command: %s", sub);
	usage(argv[0]);
	return 1;
}

static void print_error(const char *fmt, ...)
{
	va_list args;

	fprintf(stderr, "Error: ");
	va_start(args, fmt);
	vfprintf(stderr, fmt, args);
	va_end(args);
	fprintf(stderr, "\n");
}

static void usage(const char *progname)
{
	printf("GPIO Sysfs Control Tool\n");
	printf("Usage: %s <command> [args...]\n", progname);
	printf("Commands:\n");
	printf("  list\n");
	printf("  export <pin>\n");
	printf("  unexport <pin>\n");
	printf("  <pin> set direction <in|out>\n");
	printf("  <pin> get direction\n");
	printf("  <pin> set value <0|1>\n");
	printf("  <pin> get value\n");
	printf("  <pin> set edge <none|rising|falling|both>\n");
	printf("  <pin> get edge\n");
	printf("  <pin> set active_low <0|1>\n");
	printf("  <pin> get active_low\n");
	printf("  <pin> blink <count> <delay_ms>\n");
	printf("  <pin> info\n");
}

static int cmd_export(int argc, char *argv[])
{
	int pin, gpio_num;
	char str_pin[16];
	int ret;

	if (argc < 1)
	{
		print_error("Missing GPIO pin offset");
		return 1;
	}

	if (parse_int(argv[0], &pin) != 0)
	{
		print_error("Invalid GPIO pin offset '%s': not a valid integer", argv[0]);
		return 1;
	}
	gpio_num = pin + GPIO_BASE;

	snprintf(str_pin, sizeof(str_pin), "%d", gpio_num);

	ret = gpio_export(str_pin);
	if (ret < 0)
	{
		print_error("Failed to export GPIO %d: %s",
					gpio_num, gpio_strerror(ret));
		return 1;
	}

	printf("GPIO %d (gpio%d): Exported successfully\n", pin, gpio_num);
	return 0;
}

static int cmd_unexport(int argc, char *argv[])
{
	int pin, gpio_num;
	char str_pin[16];
	int ret;

	if (argc < 1)
	{
		print_error("Missing GPIO pin offset");
		return 1;
	}

	if (parse_int(argv[0], &pin) != 0)
	{
		print_error("Invalid GPIO pin offset '%s': not a valid integer", argv[0]);
		return 1;
	}
	gpio_num = pin + GPIO_BASE;

	snprintf(str_pin, sizeof(str_pin), "%d", gpio_num);

	ret = gpio_unexport(str_pin);
	if (ret < 0)
	{
		print_error("Failed to unexport GPIO %d: %s",
					gpio_num, gpio_strerror(ret));
		return 1;
	}

	printf("GPIO %d (gpio%d): Unexported successfully\n",
		   pin, gpio_num);

	return 0;
}

static int cmd_set_direction(gpio_sysfs_device_t *gpio, int argc, char *argv[])
{
	int ret;

	if (argc < 1)
	{
		print_error("Missing direction (in|out)");
		return 1;
	}

	ret = gpio_set_direction(gpio, argv[0]);
	if (ret < 0)
	{
		print_error("Failed to set direction: %s", gpio_strerror(ret));
		return 1;
	}
	printf("GPIO %d: %s\n", gpio_pin_to_offset(gpio), strcmp(argv[0], "in") == 0 ? "INPUT" : "OUTPUT");
	return 0;
}

static int cmd_get_direction(gpio_sysfs_device_t *gpio)
{
	char buffer[GPIO_BUFFER_SIZE];
	int ret;

	ret = gpio_get_direction(gpio, buffer, sizeof(buffer));
	if (ret < 0)
	{
		print_error("Failed to get direction: %s", gpio_strerror(ret));
		return 1;
	}
	printf("GPIO %d: %s\n", gpio_pin_to_offset(gpio), strcmp(buffer, "in") == 0 ? "INPUT" : "OUTPUT");
	return 0;
}

static int cmd_set_value(gpio_sysfs_device_t *gpio, int argc, char *argv[])
{
	int value, ret;

	if (argc < 1)
	{
		print_error("Missing value (0|1)");
		return 1;
	}

	if (parse_int(argv[0], &value) != 0 || (value != 0 && value != 1))
	{
		print_error("Invalid value '%s' (must be 0 or 1)", argv[0]);
		return 1;
	}

	ret = gpio_set_value(gpio, value);
	if (ret < 0)
	{
		print_error("Failed to set value: %s", gpio_strerror(ret));
		return 1;
	}

	gpio_sysfs_info_t info;
	ret = gpio_get_info(gpio, &info);
	if (ret < 0)
	{
		print_error("Failed to get GPIO info: %s", gpio_strerror(ret));
		return 1;
	}

	if (info.active_low)
	{
		value = !value; /* Invert value for active_low */
	}
	printf("GPIO %d: %s\n", gpio_pin_to_offset(gpio), value ? "ON" : "OFF");
	return 0;
}

static int cmd_get_value(gpio_sysfs_device_t *gpio)
{
	int value, ret;

	ret = gpio_get_value(gpio, &value);
	if (ret < 0)
	{
		print_error("Failed to get value: %s", gpio_strerror(ret));
		return 1;
	}

	gpio_sysfs_info_t info;
	ret = gpio_get_info(gpio, &info);
	if (ret < 0)
	{
		print_error("Failed to get GPIO info: %s", gpio_strerror(ret));
		return 1;
	}

	if (info.active_low)
	{
		value = !value; /* Invert value for active_low */
	}
	printf("GPIO %d: value = %s\n", gpio_pin_to_offset(gpio), value ? "ON" : "OFF");
	return 0;
}

static int cmd_blink(gpio_sysfs_device_t *gpio, int argc, char *argv[])
{
	int count, delay_ms, i, ret;

	if (argc < 2)
	{
		print_error("Missing arguments: <count> <delay_ms>");
		return 1;
	}

	if (parse_int(argv[0], &count) != 0 || count <= 0)
	{
		print_error("Invalid count '%s': must be a positive integer", argv[0]);
		return 1;
	}
	if (parse_int(argv[1], &delay_ms) != 0 || delay_ms < 0)
	{
		print_error("Invalid delay_ms '%s': must be a non-negative integer", argv[1]);
		return 1;
	}

	for (i = 0; i < count; i++)
	{
		ret = gpio_set_value(gpio, 1);
		if (ret < 0)
		{
			print_error("Failed to set value: %s", gpio_strerror(ret));
			return 1;
		}
		usleep((useconds_t)delay_ms * 1000);

		ret = gpio_set_value(gpio, 0);
		if (ret < 0)
		{
			print_error("Failed to set value: %s", gpio_strerror(ret));
			return 1;
		}
		usleep((useconds_t)delay_ms * 1000);
	}
	return 0;
}

static int cmd_set_edge(gpio_sysfs_device_t *gpio, int argc, char *argv[])
{
	int ret;

	if (argc < 1)
	{
		print_error("Missing edge value (none|rising|falling|both)");
		return 1;
	}

	ret = gpio_set_edge(gpio, argv[0]);
	if (ret < 0)
	{
		print_error("Failed to set edge: %s", gpio_strerror(ret));
		return 1;
	}
	printf("GPIO %d: %s\n", gpio_pin_to_offset(gpio),
		   strcmp(argv[0], "none") == 0 ? "NONE" : strcmp(argv[0], "rising") == 0 ? "RISING"
											   : strcmp(argv[0], "falling") == 0  ? "FALLING"
																				  : "BOTH");
	return 0;
}

static int cmd_get_edge(gpio_sysfs_device_t *gpio)
{
	char buffer[GPIO_BUFFER_SIZE];
	int ret;

	ret = gpio_get_edge(gpio, buffer, sizeof(buffer));
	if (ret < 0)
	{
		print_error("Failed to get edge: %s", gpio_strerror(ret));
		return 1;
	}
	printf("GPIO %d: edge = %s\n", gpio_pin_to_offset(gpio),
		   strcmp(buffer, "none") == 0 ? "NONE" : strcmp(buffer, "rising") == 0 ? "RISING"
											  : strcmp(buffer, "falling") == 0	? "FALLING"
																				: "BOTH");
	return 0;
}

static int cmd_set_active_low(gpio_sysfs_device_t *gpio, int argc, char *argv[])
{
	int active_low, ret;

	if (argc < 1)
	{
		print_error("Missing value (0|1)");
		return 1;
	}

	if (parse_int(argv[0], &active_low) != 0 || (active_low != 0 && active_low != 1))
	{
		print_error("Invalid value '%s' (must be 0 or 1)", argv[0]);
		return 1;
	}

	ret = gpio_set_active_low(gpio, active_low);
	if (ret < 0)
	{
		print_error("Failed to set active_low: %s", gpio_strerror(ret));
		return 1;
	}
	printf("GPIO %d: %s\n", gpio_pin_to_offset(gpio),
		   active_low ? "ACTIVE_LOW" : "ACTIVE_HIGH");
	return 0;
}

static int cmd_get_active_low(gpio_sysfs_device_t *gpio)
{
	int active_low, ret;

	ret = gpio_get_active_low(gpio, &active_low);
	if (ret < 0)
	{
		print_error("Failed to get active_low: %s", gpio_strerror(ret));
		return 1;
	}
	printf("GPIO %d: active_low = %s\n", gpio_pin_to_offset(gpio),
		   active_low ? "ACTIVE_LOW" : "ACTIVE_HIGH");
	return 0;
}

static int list_callback(const char *name, void *user_data __attribute__((unused)))
{
	printf("%s\n", name);
	return 0;
}

static int gpio_pin_to_offset(const gpio_sysfs_device_t *gpio)
{
	int val;
	if (parse_int(gpio->gpio_pin, &val) != 0)
		return -1;
	return val - GPIO_BASE;
}

static int cmd_list(void)
{
	int ret;

	ret = gpio_list(list_callback, NULL);
	if (ret < 0)
	{
		print_error("Failed to list GPIOs: %s", gpio_strerror(ret));
		return 1;
	}
	if (ret == 0)
		printf("No GPIO devices found\n");
	return 0;
}

static int cmd_info(gpio_sysfs_device_t *gpio)
{
	gpio_sysfs_info_t info;
	int ret;

	ret = gpio_get_info(gpio, &info);
	if (ret < 0)
	{
		print_error("Failed to get GPIO info: %s", gpio_strerror(ret));
		return 1;
	}

	printf("GPIO:       %s\n", info.gpio_pin);
	printf("Direction:  %s\n", strcmp(info.direction, "in") == 0 ? "INPUT" : "OUTPUT");
	printf("Edge:       %s\n", strcmp(info.edge, "none") == 0	   ? "NONE"
							   : strcmp(info.edge, "rising") == 0  ? "RISING"
							   : strcmp(info.edge, "falling") == 0 ? "FALLING"
																   : "BOTH");
	printf("Value:      %d\n", info.value);
	printf("Active Low: %s\n", info.active_low ? "ACTIVE_LOW" : "ACTIVE_HIGH");
	return 0;
}