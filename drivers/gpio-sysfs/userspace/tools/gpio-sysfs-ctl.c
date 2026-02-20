// SPDX-License-Identifier: GPL-2.0
/*
 * gpio-sysfs-ctl - GPIO Control Utility
 * Command-line tool for controlling GPIO pins via Linux sysfs interface
 */

#include "libio.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <stdarg.h>

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

	snprintf(str_pin, sizeof(str_pin), "%d", atoi(cmd) + GPIO_BASE);

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
	printf("Usage: %s <command> [args...]\n\n", progname);
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
	printf("\nExamples:\n");
	printf("  %s export 22\n", progname);
	printf("  %s 22 set direction out\n", progname);
	printf("  %s 22 set value 1\n", progname);
	printf("  %s 22 blink 5 500\n", progname);
	printf("  %s list\n", progname);
}

static int cmd_export(int argc, char *argv[])
{
	char str_pin[16];
	int ret;

	if (argc < 1)
	{
		print_error("Missing GPIO pin offset");
		return 1;
	}

	snprintf(str_pin, sizeof(str_pin), "%d", atoi(argv[0]) + GPIO_BASE);

	ret = gpio_export(str_pin);
	if (ret < 0)
	{
		print_error("Failed to export GPIO %s: %s", str_pin, gpio_strerror(ret));
		return 1;
	}
	return 0;
}

static int cmd_unexport(int argc, char *argv[])
{
	char str_pin[16];
	int ret;

	if (argc < 1)
	{
		print_error("Missing GPIO pin offset");
		return 1;
	}

	snprintf(str_pin, sizeof(str_pin), "%d", atoi(argv[0]) + GPIO_BASE);
	ret = gpio_unexport(str_pin);
	if (ret < 0)
	{
		print_error("Failed to unexport GPIO %s: %s", str_pin, gpio_strerror(ret));
		return 1;
	}
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
	printf("direction: %s\n", buffer);
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

	value = atoi(argv[0]);
	if (value != 0 && value != 1)
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
	printf("value: %d\n", value);
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

	count = atoi(argv[0]);
	delay_ms = atoi(argv[1]);

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
	printf("edge: %s\n", buffer);
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

	active_low = atoi(argv[0]);
	if (active_low != 0 && active_low != 1)
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
	printf("active_low: %d\n", active_low);
	return 0;
}

static int list_callback(const char *name, void *user_data __attribute__((unused)))
{
	printf("%s\n", name);
	return 0;
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
	printf("Direction:  %s\n", info.direction);
	printf("Edge:       %s\n", info.edge);
	printf("Value:      %d\n", info.value);
	printf("Active Low: %d\n", info.active_low);
	return 0;
}