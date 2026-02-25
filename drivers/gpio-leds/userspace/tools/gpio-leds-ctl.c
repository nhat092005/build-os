// SPDX-License-Identifier: GPL-2.0
/*
 * GPIO LED Control Utility
 *
 * This utility allows users to control GPIO LEDs from the command line.
 * It supports turning LEDs on/off, setting brightness, configuring triggers,
 * and more. It uses the libled library to interact with the LED devices.
 */

#define _DEFAULT_SOURCE

#include "libled.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <getopt.h>
#include <stdarg.h>
#include <limits.h>
#include <errno.h>

/* Command handler function type */
typedef int (*cmd_handler_t)(led_device_t *led, int argc, char *argv[]);

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

/* Forward declarations */

/**
 * usage - Display usage information
 * @progname: Name of the program (argv[0])
 * This function prints the usage instructions for the gpio-leds-ctl tool,
 * including available commands and options.
 */
static void usage(const char *progname);

/**
 * print_error - Print formatted error message to stderr
 * @fmt: Format string (printf-style)
 * @...: Additional arguments for format string
 * This function prints an error message to stderr, prefixed with "Error: ".
 */
static void print_error(const char *fmt, ...);

/* Command handlers */

/**
 * cmd_on - Handle 'on' command to turn LED on
 * @led: LED device handle
 * @argc: Argument count
 * @argv: Argument vector (not used)
 * Return: 0 on success, non-zero on failure
 */
static int cmd_on(led_device_t *led, int argc, char *argv[]);

/**
 * cmd_off - Handle 'off' command to turn LED off
 * @led: LED device handle
 * @argc: Argument count
 * @argv: Argument vector (not used)
 * Return: 0 on success, non-zero on failure
 */
static int cmd_off(led_device_t *led, int argc, char *argv[]);

/**
 * cmd_set - Handle 'set' command to set LED brightness
 * @led: LED device handle
 * @argc: Argument count
 * @argv: Argument vector (expects brightness value)
 * Return: 0 on success, non-zero on failure
 */
static int cmd_set(led_device_t *led, int argc, char *argv[]);

/**
 * cmd_get - Handle 'get' command to get current LED brightness
 * @led: LED device handle
 * @argc: Argument count
 * @argv: Argument vector (not used)
 * Return: 0 on success, non-zero on failure
 */
static int cmd_get(led_device_t *led, int argc, char *argv[]);

/**
 * cmd_trigger - Handle 'trigger' command to set/get LED trigger
 * @led: LED device handle
 * @argc: Argument count
 * @argv: Argument vector (optional trigger name)
 * Return: 0 on success, non-zero on failure
 */
static int cmd_trigger(led_device_t *led, int argc, char *argv[]);

/**
 * cmd_blink - Handle 'blink' command to blink LED
 * @led: LED device handle
 * @argc: Argument count
 * @argv: Argument vector (optional count and delay)
 * Return: 0 on success, non-zero on failure
 */
static int cmd_blink(led_device_t *led, int argc, char *argv[]);

/**
 * cmd_timer - Handle 'timer' command to set timer trigger
 * @led: LED device handle
 * @argc: Argument count
 * @argv: Argument vector (optional on/off delays)
 * Return: 0 on success, non-zero on failure
 */
static int cmd_timer(led_device_t *led, int argc, char *argv[]);

/**
 * cmd_pulse - Handle 'pulse' command to pulse LED (fade in/out)
 * @led: LED device handle
 * @argc: Argument count
 * @argv: Argument vector (optional duration and steps)
 * Return: 0 on success, non-zero on failure
 */
static int cmd_pulse(led_device_t *led, int argc, char *argv[]);

/**
 * cmd_info - Handle 'info' command to show LED information
 * @led: LED device handle
 * @argc: Argument count
 * @argv: Argument vector (not used)
 * Return: 0 on success, non-zero on failure
 */
static int cmd_info(led_device_t *led, int argc, char *argv[]);


/**
 * parse_int - Safely parse a string to int
 * @str: NUL-terminated string
 * @result: Output int
 * Return: 0 on success, -1 on failure
 */
static int parse_int(const char *str, int *result);

/* Command table */
static struct command commands[] = {
	{"on", cmd_on, "", "Turn LED on"},
	{"off", cmd_off, "", "Turn LED off"},
	{"set", cmd_set, "<brightness>", "Set brightness (0-max)"},
	{"get", cmd_get, "", "Get current brightness"},
	{"trigger", cmd_trigger, "[name]", "Set or get trigger"},
	{"blink", cmd_blink, "[count] [delay_ms]", "Blink LED"},
	{"timer", cmd_timer, "[on_ms] [off_ms]", "Set timer trigger"},
	{"pulse", cmd_pulse, "[duration] [steps]", "Pulse LED (fade)"},
	{"info", cmd_info, "", "Show LED information"},
	{NULL, NULL, NULL, NULL}};

/* Main */
int main(int argc, char *argv[])
{
	led_device_t led;
	const char *led_name = "gpio-led"; /* Default LED device name */
	const char *cmd_name;
	int opt, ret, i;

	static struct option long_options[] = {
		{"device", required_argument, 0, 'd'},
		{"help", no_argument, 0, 'h'},
		{0, 0, 0, 0}};

	/* Parse options */
	while ((opt = getopt_long(argc, argv, "d:h", long_options, NULL)) != -1)
	{
		switch (opt)
		{
		case 'd':
			led_name = optarg;
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

	/* Open LED device */
	ret = led_open(&led, led_name);
	if (ret < 0)
	{
		print_error("Failed to open LED '%s': %s",
					led_name, led_strerror(ret));
		return 1;
	}

	/* Find and execute command */
	for (i = 0; commands[i].name != NULL; i++)
	{
		if (strcmp(cmd_name, commands[i].name) == 0)
		{
			ret = commands[i].handler(&led,
									  argc - optind - 1,
									  argv + optind + 1);
			led_close(&led);
			return ret;
		}
	}

	print_error("Unknown command: %s", cmd_name);
	led_close(&led);
	usage(argv[0]);
	return 1;
}

static void usage(const char *progname)
{
	int i;

	printf("GPIO LED Driver Control Tool\n");
	printf("Usage: %s [options] <command> [args...]\n", progname);
	printf("Options:\n");
	printf("  -d, --device NAME    LED device name\n");
	printf("  -h, --help           Show this help message\n");
	printf("Commands:\n");

	for (i = 0; commands[i].name != NULL; i++)
	{
		printf("  %-8s %-20s %s\n",
			   commands[i].name,
			   commands[i].args,
			   commands[i].description);
	}
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

/* Command implementations */
static int cmd_on(led_device_t *led, int argc __attribute__((unused)),
				  char *argv[] __attribute__((unused)))
{
	int ret;

	ret = led_on(led);
	if (ret < 0)
	{
		print_error("Failed to turn LED on: %s", led_strerror(ret));
		return 1;
	}

	printf("GPIO %d (%s): ON\n", led_get_gpio_pin(led) - GPIO_BASE, led->name);
	return 0;
}

static int cmd_off(led_device_t *led, int argc __attribute__((unused)),
				   char *argv[] __attribute__((unused)))
{
	int ret;

	ret = led_off(led);
	if (ret < 0)
	{
		print_error("Failed to turn LED off: %s", led_strerror(ret));
		return 1;
	}

	printf("GPIO %d (%s): OFF\n", led_get_gpio_pin(led) - GPIO_BASE, led->name);
	return 0;
}

static int cmd_set(led_device_t *led, int argc, char *argv[])
{
	int brightness, ret;

	if (argc < 1)
	{
		print_error("Missing brightness value");
		return 1;
	}

	if (parse_int(argv[0], &brightness) != 0)
	{
		print_error("Invalid brightness value: %s", argv[0]);
		return 1;
	}

	ret = led_set_brightness(led, brightness);
	if (ret < 0)
	{
		print_error("Failed to set brightness: %s", led_strerror(ret));
		return 1;
	}

	printf("GPIO %d (%s): brightness set to %d\n", led_get_gpio_pin(led) - GPIO_BASE, led->name, brightness);
	return 0;
}

static int cmd_get(led_device_t *led, int argc __attribute__((unused)),
				   char *argv[] __attribute__((unused)))
{
	int brightness;

	brightness = led_get_brightness(led);
	if (brightness < 0)
	{
		print_error("Failed to get brightness: %s", led_strerror(brightness));
		return 1;
	}

	printf("GPIO %d (%s): brightness=%d\n", led_get_gpio_pin(led) - GPIO_BASE, led->name, brightness);
	return 0;
}

static int cmd_trigger(led_device_t *led, int argc, char *argv[])
{
	char buffer[LED_BUFFER_SIZE];
	int ret;

	if (argc < 1)
	{
		/* Get current trigger */
		ret = led_get_trigger(led, buffer, sizeof(buffer));
		if (ret < 0)
		{
			print_error("Failed to get trigger: %s", led_strerror(ret));
			return 1;
		}
		printf("GPIO %d (%s): trigger=%s\n", led_get_gpio_pin(led) - GPIO_BASE, led->name, buffer);
	}
	else
	{
		/* Set trigger */
		ret = led_set_trigger(led, argv[0]);
		if (ret < 0)
		{
			print_error("Failed to set trigger: %s", led_strerror(ret));
			return 1;
		}
		printf("GPIO %d (%s): trigger set to '%s'\n", led_get_gpio_pin(led) - GPIO_BASE, led->name, argv[0]);
	}

	return 0;
}

static int cmd_blink(led_device_t *led, int argc, char *argv[])
{
	int count = 10;		/* Default: 10 blinks */
	int delay_ms = 500; /* Default: 500ms */
	int ret;

	if (argc >= 1 && parse_int(argv[0], &count) != 0)
	{
		print_error("Invalid count value: %s", argv[0]);
		return 1;
	}
	if (argc >= 2 && parse_int(argv[1], &delay_ms) != 0)
	{
		print_error("Invalid delay value: %s", argv[1]);
		return 1;
	}

	ret = led_blink(led, count, delay_ms);
	if (ret < 0)
	{
		print_error("Failed to blink LED: %s", led_strerror(ret));
		return 1;
	}

	printf("GPIO %d (%s): blinked %d times with %dms delay\n", led_get_gpio_pin(led) - GPIO_BASE, led->name, count, delay_ms);
	return 0;
}

static int cmd_timer(led_device_t *led, int argc, char *argv[])
{
	int delay_on = 500;	 /* Default: 500ms on */
	int delay_off = 500; /* Default: 500ms off */
	int ret;

	if (argc >= 1 && parse_int(argv[0], &delay_on) != 0)
	{
		print_error("Invalid delay_on value: %s", argv[0]);
		return 1;
	}
	if (argc >= 2 && parse_int(argv[1], &delay_off) != 0)
	{
		print_error("Invalid delay_off value: %s", argv[1]);
		return 1;
	}

	ret = led_set_timer(led, delay_on, delay_off);
	if (ret < 0)
	{
		print_error("Failed to set timer: %s", led_strerror(ret));
		return 1;
	}

	printf("GPIO %d (%s): timer set %dms on, %dms off\n", led_get_gpio_pin(led) - GPIO_BASE, led->name, delay_on, delay_off);
	return 0;
}

static int cmd_pulse(led_device_t *led, int argc, char *argv[])
{
	int duration = 3000; /* Default: 3 seconds */
	int steps = 50;		 /* Default: 50 steps */
	int ret;

	if (argc >= 1 && parse_int(argv[0], &duration) != 0)
	{
		print_error("Invalid duration value: %s", argv[0]);
		return 1;
	}
	if (argc >= 2 && parse_int(argv[1], &steps) != 0)
	{
		print_error("Invalid steps value: %s", argv[1]);
		return 1;
	}

	ret = led_pulse(led, duration, steps);
	if (ret < 0)
	{
		print_error("Failed to pulse LED: %s", led_strerror(ret));
		return 1;
	}

	printf("GPIO %d (%s): pulsed for %dms with %d steps\n", led_get_gpio_pin(led) - GPIO_BASE, led->name, duration, steps);
	return 0;
}

static int cmd_info(led_device_t *led, int argc __attribute__((unused)),
					char *argv[] __attribute__((unused)))
{
	led_info_t info;
	int ret;

	ret = led_get_info(led, &info);
	if (ret < 0)
	{
		print_error("Failed to get LED info: %s", led_strerror(ret));
		return 1;
	}

	printf("GPIO %d (%s)\n", info.gpio_pin - GPIO_BASE, info.name);
	printf("Path:       %s\n", led->path);
	printf("GPIO pin:   %d\n", info.gpio_pin - GPIO_BASE);
	printf("Brightness: %d / %d\n", info.brightness, info.max_brightness);
	printf("Trigger:    %s\n", info.trigger);

	return 0;
}

static int parse_int(const char *str, int *result)
{
	char *endptr;
	long val;

	errno = 0;
	val = strtol(str, &endptr, 10);
	if (errno != 0 || endptr == str || *endptr != '\0')
		return -1;
	if (val < INT_MIN || val > INT_MAX)
		return -1;

	*result = (int)val;
	return 0;
}