// SPDX-License-Identifier: GPL-2.0
/*
 * gpio-sysfs-ctl - GPIO Control Utility
 * Command-line tool using gpio-sysfs for GPIO control
 */

#include "libio.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <getopt.h>
#include <stdarg.h>

/* Command handler function type */
typedef int (*cmd_handler_t)(gpio_sysfs_device_t *gpio, int argc, char *argv[]);

/**
 * struct command - Command definition
 * @name: Command name
 * @handler: Function to handle the command
 * @args: Argument description for usage
 * @description: Brief description of the command
 */
struct command
{
	const char *name;
	cmd_handler_t handler;
	const char *args;
	const char *description;
};

/* Global options */
static int verbose = 0;

/* Forward declarations */

/**
 * usage - Print usage information
 * @progname: Name of the program
 * This function prints the usage information for the command-line tool,
 * including available options and commands.
 */
static void usage(const char *progname);

/**
 * print_error - Print an error message
 * @fmt: Format string (like printf)
 * This function prints an error message to stderr, prefixed with "Error: ".
 */
static void print_error(const char *fmt, ...);

/**
 * print_verbose - Print a verbose message
 * @fmt: Format string (like printf)
 * This function prints a verbose message to stdout if the verbose flag is set.
 */
static void print_verbose(const char *fmt, ...);

/* Command handlers */

/**
 * cmd_export - Handle 'export' command to export a GPIO
 * @gpio: GPIO device handle
 * @argc: Argument count
 * @argv: Argument vector (expects GPIO pin number)
 * Return: 0 on success, non-zero on failure
 */
static int cmd_export(gpio_sysfs_device_t *gpio, int argc, char *argv[]);

/**
 * cmd_unexport - Handle 'unexport' command to unexport a GPIO
 * @gpio: GPIO device handle
 * @argc: Argument count
 * @argv: Argument vector (expects GPIO pin number)
 * Return: 0 on success, non-zero on failure
 */
static int cmd_unexport(gpio_sysfs_device_t *gpio, int argc, char *argv[]);

/**
 * cmd_set_direction - Handle 'direction' command to set GPIO direction
 * @gpio: GPIO device handle
 * @argc: Argument count
 * @argv: Argument vector (expects "in" or "out")
 * Return: 0 on success, non-zero on failure
 */
static int cmd_set_direction(gpio_sysfs_device_t *gpio, int argc, char *argv[]);

/**
 * cmd_get_direction - Handle 'direction' command to get GPIO direction
 * @gpio: GPIO device handle
 * @argc: Argument count
 * @argv: Argument vector (not used)
 * Return: 0 on success, non-zero on failure
 */
static int cmd_get_direction(gpio_sysfs_device_t *gpio, int argc __attribute__((unused)),
							 char *argv[] __attribute__((unused)));

/**
 * cmd_set_value - Handle 'set' command to set GPIO value
 * @gpio: GPIO device handle
 * @argc: Argument count
 * @argv: Argument vector (expects value 0 or 1)
 * Return: 0 on success, non-zero on failure
 */
static int cmd_set_value(gpio_sysfs_device_t *gpio, int argc, char *argv[]);

/**
 * cmd_get_value - Handle 'get' command to get current GPIO value
 * @gpio: GPIO device handle
 * @argc: Argument count
 * @argv: Argument vector (not used)
 * Return: 0 on success, non-zero on failure
 */
static int cmd_get_value(gpio_sysfs_device_t *gpio, int argc __attribute__((unused)),
						 char *argv[] __attribute__((unused)));

/**
 * cmd_blink - Handle 'blink' command to blink GPIO
 * @gpio: GPIO device handle
 * @argc: Argument count
 * @argv: Argument vector (expects count and delay_ms)
 * Return: 0 on success, non-zero on failure
 */
static int cmd_blink(gpio_sysfs_device_t *gpio, int argc, char *argv[]);

/**
 * cmd_set_edge - Handle 'edge' command to set GPIO edge
 * @gpio: GPIO device handle
 * @argc: Argument count
 * @argv: Argument vector (expects edge value)
 * Return: 0 on success, non-zero on failure
 */
static int cmd_set_edge(gpio_sysfs_device_t *gpio, int argc, char *argv[]);

/**
 * cmd_get_edge - Handle 'edge' command to get GPIO edge
 * @gpio: GPIO device handle
 * @argc: Argument count
 * @argv: Argument vector (not used)
 * Return: 0 on success, non-zero on failure
 */
static int cmd_get_edge(gpio_sysfs_device_t *gpio, int argc __attribute__((unused)),
						char *argv[] __attribute__((unused)));

/**
 * cmd_set_active_low - Handle 'active_low' command to set GPIO active_low
 * @gpio: GPIO device handle
 * @argc: Argument count
 * @argv: Argument vector (expects 0 or 1)
 * Return: 0 on success, non-zero on failure
 */
static int cmd_set_active_low(gpio_sysfs_device_t *gpio, int argc, char *argv[]);

/**
 * cmd_get_active_low - Handle 'active_low' command to get GPIO active_low setting
 * @gpio: GPIO device handle
 * @argc: Argument count
 * @argv: Argument vector (not used)
 * Return: 0 on success, non-zero on failure
 */
static int cmd_get_active_low(gpio_sysfs_device_t *gpio, int argc __attribute__((unused)),
							  char *argv[] __attribute__((unused)));

/**
 * cmd_list - Handle 'list' command to list available LEDs
 * @gpio: GPIO device handle (not used)
 * @argc: Argument count
 * @argv: Argument vector (not used)
 * Return: 0 on success, non-zero on failure
 */
static int cmd_list(gpio_sysfs_device_t *gpio, int argc, char *argv[]);

/**
 * cmd_info - Handle 'info' command to show GPIO information
 * @gpio: GPIO device handle
 * @argc: Argument count
 * @argv: Argument vector (not used)
 * Return: 0 on success, non-zero on failure
 */
static int cmd_info(gpio_sysfs_device_t *gpio, int argc, char *argv[]);

/* Command table */
static struct command commands[] = {
	{"export", cmd_export, "<gpio_pin>", "Export a GPIO pin"},
	{"unexport", cmd_unexport, "<gpio_pin>", "Unexport a GPIO pin"},
	{"set direction", cmd_set_direction, "<in|out>", "Set GPIO direction"},
	{"get direction", cmd_get_direction, "", "Get GPIO direction"},
	{"set value", cmd_set_value, "<0|1>", "Set GPIO value"},
	{"get value", cmd_get_value, "", "Get GPIO value"},
	{"blink", cmd_blink, "<count> <delay_ms>", "Blink GPIO with count and delay"},
	{"set edge", cmd_set_edge, "<none|rising|falling|both>", "Set GPIO edge"},
	{"get edge", cmd_get_edge, "", "Get GPIO edge"},
	{"set active_low", cmd_set_active_low, "<0|1>", "Set GPIO active_low"},
	{"get active_low", cmd_get_active_low, "", "Get GPIO active_low setting"},
	{"list", cmd_list, "", "List available GPIO devices"},
	{"info", cmd_info, "", "Show GPIO information"},
	{NULL, NULL, NULL, NULL}};

/* Main */
int main(int argc, char *argv[])
{
	gpio_sysfs_device_t led;
	const char *cmd_name;
	int opt, ret, i;

	static struct option long_options[] = {
		{"verbose", no_argument, 0, 'v'},
		{"help", no_argument, 0, 'h'},
		{0, 0, 0, 0}};

	/* Parse options */
	while ((opt = getopt_long(argc, argv, "d:vh", long_options, NULL)) != -1)
	{
		switch (opt)
		{
		case 'v':
			verbose = 1;
			break;
		case 'h':
			usage(argv[0]);
			return 0;
		default:
			usage(argv[0]);
			return 1;
		}
	}

	/* Check for command */
	if (optind >= argc)
	{
		print_error("No command specified");
		usage(argv[0]);
		return 1;
	}

	cmd_name = argv[optind];

	/* Handle 'list' command separately (doesn't need LED device) */
	if (strcmp(cmd_name, "list") == 0)
	{
		return cmd_list(NULL, argc - optind - 1, argv + optind + 1);
	}

	print_error("Unknown command: %s", cmd_name);
	gpio_close(&led);
	usage(argv[0]);
	return 1;
}

static void usage(const char *progname)
{
	int i;

	printf("Usage: %s [options] <command> [args...]\n\n", progname);
	printf("Options:\n");
	printf("  -d, --device NAME    GPIO device name (default: custom-gpio)\n");
	printf("  -v, --verbose        Verbose output\n");
	printf("  -h, --help           Show this help message\n\n");
	printf("Commands:\n");

	for (i = 0; commands[i].name != NULL; i++)
	{
		printf("  %-8s %-20s %s\n",
			   commands[i].name,
			   commands[i].args,
			   commands[i].description);
	}

	printf("\nExamples:\n");
	printf("  %s export 22\n", progname);
	printf("  %s set direction out\n", progname);
	printf("  %s set value 1\n", progname);
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

static void print_verbose(const char *fmt, ...)
{
	va_list args;
	if (!verbose)
		return;
	va_start(args, fmt);
	vprintf(fmt, args);
	va_end(args);
	printf("\n");
}

/* Command implementations */

static int cmd_export(gpio_sysfs_device_t *gpio, int argc, char *argv[])
{
	int ret;

	if (argc < 1)
	{
		print_error("Missing GPIO pin number");
		return 1;
	}

	print_verbose("Exporting GPIO pin %s", argv[0]);
	char pin_str[16];
	snprintf(pin_str, sizeof(pin_str), "%d", atoi(argv[0]) + GPIO_BASE);
	ret = gpio_export(pin_str);
	if (ret < 0)
	{
		print_error("Failed to export GPIO: %s", gpio_strerror(ret));
		return 1;
	}

	return 0;
}

static int cmd_unexport(gpio_sysfs_device_t *gpio, int argc, char *argv[])
{
	int ret;

	if (argc < 1)
	{
		print_error("Missing GPIO pin number");
		return 1;
	}

	print_verbose("Unexporting GPIO pin %s", argv[0]);
	char pin_str[16];
	snprintf(pin_str, sizeof(pin_str), "%d", atoi(argv[0]) + GPIO_BASE);
	ret = gpio_unexport(pin_str);
	if (ret < 0)
	{
		print_error("Failed to unexport GPIO: %s", gpio_strerror(ret));
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

	print_verbose("Setting GPIO direction to %s", argv[0]);
	ret = gpio_set_direction(gpio, argv[0]);
	if (ret < 0)
	{
		print_error("Failed to set GPIO direction: %s", gpio_strerror(ret));
		return 1;
	}

	return 0;
}

static int cmd_get_direction(gpio_sysfs_device_t *gpio, int argc __attribute__((unused)),
							 char *argv[] __attribute__((unused)))
{
	char buffer[16];
	int ret;

	ret = gpio_get_direction(gpio, buffer, sizeof(buffer));
	if (ret < 0)
	{
		print_error("Failed to get GPIO direction: %s", gpio_strerror(ret));
		return 1;
	}

	printf("GPIO direction: %s\n", buffer);
	return 0;
}

static int cmd_set_value(gpio_sysfs_device_t *gpio, int argc, char *argv[])
{
	int ret, value;

	if (argc < 1)
	{
		print_error("Missing value (0|1)");
		return 1;
	}

	value = atoi(argv[0]);
	if (value != 0 && value != 1)
	{
		print_error("Invalid value: %s (must be 0 or 1)", argv[0]);
		return 1;
	}

	print_verbose("Setting GPIO value to %d", value);
	ret = gpio_set_value(gpio, value);
	if (ret < 0)
	{
		print_error("Failed to set GPIO value: %s", gpio_strerror(ret));
		return 1;
	}

	return 0;
}

static int cmd_get_value(gpio_sysfs_device_t *gpio, int argc __attribute__((unused)),
						 char *argv[] __attribute__((unused)))
{
	int value, ret;

	ret = gpio_get_value(gpio, &value);
	if (ret < 0)
	{
		print_error("Failed to get GPIO value: %s", gpio_strerror(ret));
		return 1;
	}

	printf("GPIO value: %d\n", value);
	return 0;
}

static int cmd_blink(gpio_sysfs_device_t *gpio, int argc, char *argv[])
{
	int count, delay_ms, ret;

	if (argc < 2)
	{
		print_error("Missing arguments: <count> <delay_ms>");
		return 1;
	}

	count = atoi(argv[0]);
	delay_ms = atoi(argv[1]);

	print_verbose("Blinking GPIO %d times with %d ms delay",
				  count, delay_ms);

	for (int i = 0; i < count; i++)
	{
		ret = gpio_set_value(gpio, 1);
		if (ret < 0)
		{
			print_error("Failed to set GPIO value: %s", gpio_strerror(ret));
			return 1;
		}
		usleep(delay_ms * 1000);

		ret = gpio_set_value(gpio, 0);
		if (ret < 0)
		{
			print_error("Failed to set GPIO value: %s", gpio_strerror(ret));
			return 1;
		}
		usleep(delay_ms * 1000);
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

	print_verbose("Setting GPIO edge to %s", argv[0]);
	ret = gpio_set_edge(gpio, argv[0]);
	if (ret < 0)
	{
		print_error("Failed to set GPIO edge: %s", gpio_strerror(ret));
		return 1;
	}

	return 0;
}

static int cmd_get_edge(gpio_sysfs_device_t *gpio, int argc __attribute__((unused)),
						char *argv[] __attribute__((unused)))
{
	char buffer[16];
	int ret;

	ret = gpio_get_edge(gpio, buffer, sizeof(buffer));
	if (ret < 0)
	{
		print_error("Failed to get GPIO edge: %s", gpio_strerror(ret));
		return 1;
	}

	printf("GPIO edge: %s\n", buffer);
	return 0;
}

static int cmd_set_active_low(gpio_sysfs_device_t *gpio, int argc, char *argv[])
{
	int ret, active_low;

	if (argc < 1)
	{
		print_error("Missing value (0|1)");
		return 1;
	}

	active_low = atoi(argv[0]);
	if (active_low != 0 && active_low != 1)
	{
		print_error("Invalid value: %s (must be 0 or 1)", argv[0]);
		return 1;
	}

	print_verbose("Setting GPIO active_low to %d", active_low);
	ret = gpio_set_active_low(gpio, active_low);
	if (ret < 0)
	{
		print_error("Failed to set GPIO active_low: %s", gpio_strerror(ret));
		return 1;
	}

	return 0;
}

static int cmd_get_active_low(gpio_sysfs_device_t *gpio, int argc __attribute__((unused)),
							  char *argv[] __attribute__((unused)))
{
	int active_low, ret;

	ret = gpio_get_active_low(gpio, &active_low);
	if (ret < 0)
	{
		print_error("Failed to get GPIO active_low: %s", gpio_strerror(ret));
		return 1;
	}

	printf("GPIO active_low: %d\n", active_low);
	return 0;
}

/* Callback for led_list */
static int list_callback(const char *name, void *user_data __attribute__((unused)))
{
	printf("%s\n", name);
	return 0; /* Continue enumeration */
}

static int cmd_list(gpio_sysfs_device_t *gpio __attribute__((unused)),
					int argc __attribute__((unused)),
					char *argv[] __attribute__((unused)))
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

static int cmd_info(gpio_sysfs_device_t *gpio, int argc __attribute__((unused)),
					char *argv[] __attribute__((unused)))
{
	gpio_sysfs_info_t info;
	int ret;

	ret = gpio_get_info(gpio, &info);
	if (ret < 0)
	{
		print_error("Failed to get GPIO info: %s", gpio_strerror(ret));
		return 1;
	}

	printf("GPIO: %s\n", info.gpio_pin);
	printf("Direction: %s\n", info.direction);
	printf("Edge: %s\n", info.edge);
	printf("Value: %d\n", info.value);
	printf("Active Low: %d\n", info.active_low);

	return 0;
}