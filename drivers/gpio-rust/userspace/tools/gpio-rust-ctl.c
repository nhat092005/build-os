// SPDX-License-Identifier: GPL-2.0
/*
 * GPIO Rust Driver Control Tool
 *
 * This is a simple command-line tool to control the GPIO Rust driver from userspace.
 * It uses the libgpio-rust library to interact with the /dev/gpio-rust device.
 */

#define _DEFAULT_SOURCE

#include "libgpio-rust.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <errno.h>

/**
 * print_usage - Display usage information
 * @prog: Program name (argv[0])
 * This function prints the usage instructions for the gpio-rust-ctl tool, 
 * including available commands and examples.
 */
static void print_usage(const char *prog);

/**
 * cmd_on - Turn the GPIO LED on (set value to HIGH)
 * @dev: GPIO device handle
 * This command sets the GPIO value to 1 (HIGH), which should turn the LED on.
 */
static int cmd_on(gpio_rust_device_t *dev);

/**
 * cmd_off - Turn the GPIO LED off (set value to LOW)
 * @dev: GPIO device handle
 * This command sets the GPIO value to 0 (LOW), which should turn the LED off.
 */
static int cmd_off(gpio_rust_device_t *dev);

/**
 * cmd_get - Get current GPIO LED state
 * @dev: GPIO device handle
 * This command reads the current GPIO value and prints it.
 */
static int cmd_get(gpio_rust_device_t *dev);

/**
 * cmd_toggle - Toggle the GPIO LED state
 * @dev: GPIO device handle
 * This command toggles the current GPIO value (0->1 or 1->0).
 */
static int cmd_toggle(gpio_rust_device_t *dev);

/**
 * cmd_blink - Blink the GPIO LED a specified number of times with a delay
 * @dev: GPIO device handle
 * @argc: Argument count (should be 2: count and delay_ms)
 * @argv: Argument vector (should contain count and delay_ms)
 * This command blinks the LED by toggling it on and off with a specified delay.
 */
static int cmd_blink(gpio_rust_device_t *dev, int argc, char *argv[]);

/**
 * cmd_status - Show current GPIO pin information
 * @dev: GPIO device handle
 * This command retrieves and displays the current status of the GPIO pin,
 * including its direction and value.
 */
static int cmd_status(gpio_rust_device_t *dev);

int main(int argc, char *argv[])
{
	gpio_rust_device_t dev;
	const char *cmd;
	int ret;

	if (argc < 2) {
		print_usage(argv[0]);
		return 1;
	}

	cmd = argv[1];

	/* Handle help before anything else */
	if (strcmp(cmd, "help") == 0 || strcmp(cmd, "--help") == 0 ||
	    strcmp(cmd, "-h") == 0) {
		print_usage(argv[0]);
		return 0;
	}

	/* Open the char device /dev/gpio-rust */
	ret = gpio_rust_open(&dev);
	if (ret < 0) {
		fprintf(stderr, "Error: failed to open %s: %s\n",
			GPIO_RUST_DEV_PATH, gpio_rust_strerror(ret));
		fprintf(stderr, "Make sure gpio_rust module is loaded: "
			"insmod gpio_rust.ko\n");
		return 1;
	}

	/* Dispatch command */
	if (strcmp(cmd, "on") == 0)
		ret = cmd_on(&dev);
	else if (strcmp(cmd, "off") == 0)
		ret = cmd_off(&dev);
	else if (strcmp(cmd, "get") == 0)
		ret = cmd_get(&dev);
	else if (strcmp(cmd, "toggle") == 0)
		ret = cmd_toggle(&dev);
	else if (strcmp(cmd, "blink") == 0)
		ret = cmd_blink(&dev, argc - 2, argv + 2);
	else if (strcmp(cmd, "status") == 0)
		ret = cmd_status(&dev);
	else {
		fprintf(stderr, "Error: unknown command '%s'\n", cmd);
		print_usage(argv[0]);
		ret = 1;
	}

	gpio_rust_close(&dev);
	return ret;
}

static void print_usage(const char *prog)
{
	printf("GPIO Rust Driver Control Tool\n\n");
	printf("Usage: %s <command> [options]\n\n", prog);
	printf("Commands:\n");
	printf("  on                          Turn LED on (GPIO HIGH)\n");
	printf("  off                         Turn LED off (GPIO LOW)\n");
	printf("  get                         Get current LED state\n");
	printf("  toggle                      Toggle LED state\n");
	printf("  blink <count> <delay_ms>    Blink LED\n");
	printf("  status                      Show GPIO pin info\n");
	printf("  help                        Show this help\n");
	printf("\nGPIO Pin: %d (device: %s)\n",
	       GPIO_RUST_DEFAULT_PIN, GPIO_RUST_DEV_PATH);
	printf("\nExamples:\n");
	printf("  %s on                       # Turn LED on\n", prog);
	printf("  %s off                      # Turn LED off\n", prog);
	printf("  %s blink 5 500              # Blink 5 times, 500ms interval\n", prog);
	printf("  %s status                   # Show current state\n", prog);
}

static int cmd_on(gpio_rust_device_t *dev)
{
	int ret;

	ret = gpio_rust_set_value(dev, 1);
	if (ret < 0) {
		fprintf(stderr, "Error: failed to turn on: %s\n",
			gpio_rust_strerror(ret));
		return 1;
	}
	printf("GPIO %d: ON\n", GPIO_RUST_DEFAULT_PIN);
	return 0;
}

static int cmd_off(gpio_rust_device_t *dev)
{
	int ret;

	ret = gpio_rust_set_value(dev, 0);
	if (ret < 0) {
		fprintf(stderr, "Error: failed to turn off: %s\n",
			gpio_rust_strerror(ret));
		return 1;
	}
	printf("GPIO %d: OFF\n", GPIO_RUST_DEFAULT_PIN);
	return 0;
}

static int cmd_get(gpio_rust_device_t *dev)
{
	int value, ret;

	ret = gpio_rust_get_value(dev, &value);
	if (ret < 0) {
		fprintf(stderr, "Error: failed to read value: %s\n",
			gpio_rust_strerror(ret));
		return 1;
	}
	printf("GPIO %d: %s (%d)\n", GPIO_RUST_DEFAULT_PIN,
	       value ? "ON" : "OFF", value);
	return 0;
}

static int cmd_toggle(gpio_rust_device_t *dev)
{
	int value, ret;

	/* Use ioctl toggle for atomic operation */
	ret = gpio_rust_toggle(dev);
	if (ret < 0) {
		fprintf(stderr, "Error: failed to toggle: %s\n",
			gpio_rust_strerror(ret));
		return 1;
	}

	/* Read back to report new state */
	ret = gpio_rust_get_value(dev, &value);
	if (ret < 0) {
		/* Toggle succeeded, just can't report state */
		printf("GPIO %d: toggled\n", GPIO_RUST_DEFAULT_PIN);
		return 0;
	}
	printf("GPIO %d: %s\n", GPIO_RUST_DEFAULT_PIN,
	       value ? "ON" : "OFF");
	return 0;
}

static int cmd_blink(gpio_rust_device_t *dev, int argc, char *argv[])
{
	int count, delay_ms, ret;

	if (argc < 2) {
		fprintf(stderr, "Usage: gpio-rust-ctl blink <count> <delay_ms>\n");
		return 1;
	}

	count = atoi(argv[0]);
	delay_ms = atoi(argv[1]);

	if (count <= 0 || delay_ms <= 0) {
		fprintf(stderr, "Error: count and delay_ms must be positive\n");
		return 1;
	}

	printf("Blinking GPIO %d: %d times, %dms interval\n",
	       GPIO_RUST_DEFAULT_PIN, count, delay_ms);

	ret = gpio_rust_blink(dev, count, delay_ms);
	if (ret < 0) {
		fprintf(stderr, "Error: blink failed: %s\n",
			gpio_rust_strerror(ret));
		return 1;
	}
	printf("Blink complete\n");
	return 0;
}

static int cmd_status(gpio_rust_device_t *dev)
{
	gpio_rust_info_t info;
	int ret;

	ret = gpio_rust_get_info(dev, &info);
	if (ret < 0) {
		fprintf(stderr, "Error: failed to get status: %s\n",
			gpio_rust_strerror(ret));
		return 1;
	}

	printf("  Driver:     gpio-rust (Rust kernel module)\n");
	printf("  GPIO Pin:   %d\n", info.gpio_pin);
	printf("  Direction:  %s\n", info.direction);
	printf("  Value:      %d (%s)\n", info.value,
	       info.value ? "ON" : "OFF");
	printf("  Device:     %s\n", GPIO_RUST_DEV_PATH);
	return 0;
}
