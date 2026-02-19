// SPDX-License-Identifier: GPL-2.0
/*
 * led-ctl - LED Control Utility
 * Command-line tool using libled for LED control
 */

#include "libled.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <getopt.h>
#include <stdarg.h>

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
 * cmd_list - Handle 'list' command to list available LEDs
 * @led: LED device handle (not used)
 * @argc: Argument count
 * @argv: Argument vector (not used)
 * Return: 0 on success, non-zero on failure
 */
static int cmd_list(led_device_t *led, int argc, char *argv[]);

/**
 * cmd_info - Handle 'info' command to show LED information
 * @led: LED device handle
 * @argc: Argument count
 * @argv: Argument vector (not used)
 * Return: 0 on success, non-zero on failure
 */
static int cmd_info(led_device_t *led, int argc, char *argv[]);

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
	{"list", cmd_list, "", "List available LEDs"},
	{"info", cmd_info, "", "Show LED information"},
	{NULL, NULL, NULL, NULL}};

/* Main */
int main(int argc, char *argv[])
{
	led_device_t led;
	const char *led_name = "custom-led";
	const char *cmd_name;
	int opt, ret, i;

	static struct option long_options[] = {
		{"device", required_argument, 0, 'd'},
		{"verbose", no_argument, 0, 'v'},
		{"help", no_argument, 0, 'h'},
		{0, 0, 0, 0}};

	/* Parse options */
	while ((opt = getopt_long(argc, argv, "d:vh", long_options, NULL)) != -1)
	{
		switch (opt)
		{
		case 'd':
			led_name = optarg;
			break;
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

	/* Open LED device */
	print_verbose("Opening LED device: %s", led_name);
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

	printf("Usage: %s [options] <command> [args...]\n\n", progname);
	printf("Options:\n");
	printf("  -d, --device NAME    LED device name (default: custom-led)\n");
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
	printf("  %s on\n", progname);
	printf("  %s set 128\n", progname);
	printf("  %s -d custom:red:status trigger heartbeat\n", progname);
	printf("  %s blink 10 300\n", progname);
	printf("  %s timer 200 800\n", progname);
	printf("  %s pulse 3000 100\n\n", progname);
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
static int cmd_on(led_device_t *led, int argc __attribute__((unused)),
				  char *argv[] __attribute__((unused)))
{
	int ret;

	print_verbose("Turning LED on");
	ret = led_on(led);
	if (ret < 0)
	{
		print_error("Failed to turn LED on: %s", led_strerror(ret));
		return 1;
	}

	return 0;
}

static int cmd_off(led_device_t *led, int argc __attribute__((unused)),
				   char *argv[] __attribute__((unused)))
{
	int ret;

	print_verbose("Turning LED off");
	ret = led_off(led);
	if (ret < 0)
	{
		print_error("Failed to turn LED off: %s", led_strerror(ret));
		return 1;
	}

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

	brightness = atoi(argv[0]);
	print_verbose("Setting brightness to %d", brightness);

	ret = led_set_brightness(led, brightness);
	if (ret < 0)
	{
		print_error("Failed to set brightness: %s", led_strerror(ret));
		return 1;
	}

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

	printf("%d\n", brightness);
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
		printf("%s\n", buffer);
	}
	else
	{
		/* Set trigger */
		print_verbose("Setting trigger to '%s'", argv[0]);
		ret = led_set_trigger(led, argv[0]);
		if (ret < 0)
		{
			print_error("Failed to set trigger: %s", led_strerror(ret));
			return 1;
		}
	}

	return 0;
}

static int cmd_blink(led_device_t *led, int argc, char *argv[])
{
	int count = 10;		/* Default: 10 blinks */
	int delay_ms = 500; /* Default: 500ms */
	int ret;

	if (argc >= 1)
		count = atoi(argv[0]);
	if (argc >= 2)
		delay_ms = atoi(argv[1]);

	print_verbose("Blinking %d times with %dms delay", count, delay_ms);

	ret = led_blink(led, count, delay_ms);
	if (ret < 0)
	{
		print_error("Failed to blink LED: %s", led_strerror(ret));
		return 1;
	}

	return 0;
}

static int cmd_timer(led_device_t *led, int argc, char *argv[])
{
	int delay_on = 500;	 /* Default: 500ms on */
	int delay_off = 500; /* Default: 500ms off */
	int ret;

	if (argc >= 1)
		delay_on = atoi(argv[0]);
	if (argc >= 2)
		delay_off = atoi(argv[1]);

	print_verbose("Setting timer: %dms on, %dms off", delay_on, delay_off);

	ret = led_set_timer(led, delay_on, delay_off);
	if (ret < 0)
	{
		print_error("Failed to set timer: %s", led_strerror(ret));
		return 1;
	}

	return 0;
}

static int cmd_pulse(led_device_t *led, int argc, char *argv[])
{
	int duration = 3000; /* Default: 3 seconds */
	int steps = 50;		 /* Default: 50 steps */
	int ret;

	if (argc >= 1)
		duration = atoi(argv[0]);
	if (argc >= 2)
		steps = atoi(argv[1]);

	print_verbose("Pulsing for %dms with %d steps", duration, steps);

	ret = led_pulse(led, duration, steps);
	if (ret < 0)
	{
		print_error("Failed to pulse LED: %s", led_strerror(ret));
		return 1;
	}

	return 0;
}

/* Callback for led_list */
static int list_callback(const char *name, void *user_data __attribute__((unused)))
{
	printf("%s\n", name);
	return 0; /* Continue enumeration */
}

static int cmd_list(led_device_t *led __attribute__((unused)),
					int argc __attribute__((unused)),
					char *argv[] __attribute__((unused)))
{
	int ret;

	ret = led_list(list_callback, NULL);
	if (ret < 0)
	{
		print_error("Failed to list LEDs: %s", led_strerror(ret));
		return 1;
	}

	if (ret == 0)
		printf("No LED devices found\n");

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

	printf("LED: %s\n", info.name);
	printf("Path: %s\n", led->path);
	printf("Brightness: %d/%d\n", info.brightness, info.max_brightness);
	printf("Trigger: %s\n", info.trigger);

	return 0;
}