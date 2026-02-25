/* SPDX-License-Identifier: GPL-2.0-or-later */
/*
 * GPIO CHARDEV IOCTL Tool
 *
 * This is a simple userspace tool to interact with the GPIO character device driver
 * using IOCTL commands. It allows users to control the GPIO pin state, toggle it,
 * get the current state, and blink the GPIO with specified parameters.
 */

#define _DEFAULT_SOURCE

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/ioctl.h>
#include <errno.h>
#include <limits.h>

/* Include UAPI header - same header used by kernel */
#include "../../include/uapi/gpio-chardev.h"

#define DEVICE_PATH "/dev/gpio-chardev"

/* Private Function Prototypes */
static void print_usage(const char *prog);
static int set_led_state(int fd, unsigned int state);
static int get_led_state(int fd);
static int toggle_led(int fd);
static int get_gpio_pin(int fd);

/**
 * parse_uint - Safely parse an unsigned integer string
 * @str: NUL-terminated string to parse
 * @result: Pointer to unsigned int to store parsed value
 * Return: 0 on success, -1 on failure
 */
static int parse_uint(const char *str, unsigned int *result)
{
	char *endptr;
	unsigned long val;

	errno = 0;
	val = strtoul(str, &endptr, 10);
	if (errno != 0 || endptr == str || *endptr != '\0')
		return -1;
	if (val > UINT_MAX)
		return -1;

	*result = (unsigned int)val;
	return 0;
}
static int blink_led(int fd, unsigned int count, unsigned int on_ms,
					 unsigned int off_ms);

/**
 * main - Entry point of the program
 */
int main(int argc, char *argv[])
{
	int fd;
	int ret = 0;

	if (argc < 2)
	{
		print_usage(argv[0]);
		return 1;
	}

	/* Open device */
	fd = open(DEVICE_PATH, O_RDWR);
	if (fd < 0)
	{
		perror("Failed to open device");
		fprintf(stderr, "Make sure driver is loaded: insmod gpio_chardev.ko\n");
		return 1;
	}

	/* Execute command */
	const char *cmd = argv[1];

	int gpio_pin = get_gpio_pin(fd);

	if (strcmp(cmd, "on") == 0)
	{
		ret = set_led_state(fd, GPIO_CHARDEV_ON);
		if (ret == 0)
		{
			printf("GPIO %d: ON\n", gpio_pin);
		}
	}
	else if (strcmp(cmd, "off") == 0)
	{
		ret = set_led_state(fd, GPIO_CHARDEV_OFF);
		if (ret == 0)
		{
			printf("GPIO %d: OFF\n", gpio_pin);
		}
	}
	else if (strcmp(cmd, "toggle") == 0)
	{
		ret = toggle_led(fd);
		if (ret == 0)
		{
			printf("GPIO %d: TOGGLED\n", gpio_pin);
			printf("GPIO %d: %s\n", gpio_pin, get_led_state(fd) ? "ON" : "OFF");
		}
	}
	else if (strcmp(cmd, "get") == 0)
	{
		ret = get_led_state(fd);
		if (ret >= 0)
		{
			printf("GPIO %d state: %s\n", gpio_pin, ret ? "ON" : "OFF");
			ret = 0;
		}
	}
	else if (strcmp(cmd, "gpio") == 0)
	{
		ret = get_gpio_pin(fd);
		if (ret >= 0)
		{
			printf("GPIO pin: %d\n", ret);
			ret = 0;
		}
	}
	else if (strcmp(cmd, "blink") == 0)
	{
		if (argc != 5)
		{
			fprintf(stderr, "Usage: %s blink [count] [on_ms] [off_ms]\n", argv[0]);
			print_usage(argv[0]);
			ret = 1;
		}
		else
		{
			unsigned int count, on_ms, off_ms;

			if (parse_uint(argv[2], &count) != 0 ||
			    parse_uint(argv[3], &on_ms) != 0 ||
			    parse_uint(argv[4], &off_ms) != 0)
			{
				fprintf(stderr, "Error: invalid blink arguments\n");
				ret = 1;
			}
			else
			{
				ret = blink_led(fd, count, on_ms, off_ms);
				if (ret == 0)
				{
					printf("Blinking GPIO %d: %d times (%ums on, %ums off)\n",
						   gpio_pin, count, on_ms, off_ms);
				}
			}
		}
	}
	else
	{
		fprintf(stderr, "Unknown command: %s\n", cmd);
		print_usage(argv[0]);
		ret = 1;
	}

	close(fd);
	return ret;
}

/**
 * print_usage - Print usage information
 * @prog: Program name
 */
static void print_usage(const char *prog)
{
	printf("GPIO Character Device Control Tool\n");
	printf("Usage: %s <command> [options]\n", prog);
	printf("  on                                  Turn GPIO on\n");
	printf("  off                                 Turn GPIO off\n");
	printf("  toggle                              Toggle GPIO state\n");
	printf("  get                                 Get GPIO state\n");
	printf("  gpio                                Get GPIO pin number\n");
	printf("  blink [count] [on_ms] [off_ms]      Blink GPIO\n");
	printf("Device: %s\n", DEVICE_PATH);
}

/**
 * set_led_state - Set GPIO state (ON/OFF)
 * @fd: File descriptor of the device
 * @state: Desired state (GPIO_CHARDEV_ON or GPIO_CHARDEV_OFF)
 * Returns 0 on success, -1 on failure
 */
static int set_led_state(int fd, unsigned int state)
{
	if (ioctl(fd, GPIO_CHARDEV_IOC_SET_STATE, &state) < 0)
	{
		perror("ioctl GPIO_CHARDEV_IOC_SET_STATE failed");
		return -1;
	}
	return 0;
}

/**
 * get_led_state - Get current GPIO state
 * @fd: File descriptor of the device
 * Returns 1 for ON, 0 for OFF, -1 on failure
 */
static int get_led_state(int fd)
{
	unsigned int state;

	if (ioctl(fd, GPIO_CHARDEV_IOC_GET_STATE, &state) < 0)
	{
		perror("ioctl GPIO_CHARDEV_IOC_GET_STATE failed");
		return -1;
	}
	return state;
}

/**
 * toggle_led - Toggle GPIO state
 * @fd: File descriptor of the device
 * Returns 0 on success, -1 on failure
 */
static int toggle_led(int fd)
{
	if (ioctl(fd, GPIO_CHARDEV_IOC_TOGGLE) < 0)
	{
		perror("ioctl GPIO_CHARDEV_IOC_TOGGLE failed");
		return -1;
	}
	return 0;
}

/**
 * get_gpio_pin - Get GPIO pin number associated with the device
 * @fd: File descriptor of the device
 * Returns GPIO pin number on success, -1 on failure
 */
static int get_gpio_pin(int fd)
{
	unsigned int gpio;

	if (ioctl(fd, GPIO_CHARDEV_IOC_GET_GPIO, &gpio) < 0)
	{
		perror("ioctl GPIO_CHARDEV_IOC_GET_GPIO failed");
		return -1;
	}
	return gpio;
}

/**
 * blink_led - Blink GPIO with specified parameters
 * @fd: File descriptor of the device
 * @count: Number of blinks (0 for infinite)
 * @on_ms: ON duration in milliseconds
 * @off_ms: OFF duration in milliseconds
 * Returns 0 on success, -1 on failure
 */
static int blink_led(int fd, unsigned int count, unsigned int on_ms,
					 unsigned int off_ms)
{
	struct gpio_chardev_blink blink = {
		.count = count,
		.delay_on = on_ms,
		.delay_off = off_ms,
	};

	if (ioctl(fd, GPIO_CHARDEV_IOC_BLINK, &blink) < 0)
	{
		perror("ioctl GPIO_CHARDEV_IOC_BLINK failed");
		return -1;
	}
	return 0;
}
