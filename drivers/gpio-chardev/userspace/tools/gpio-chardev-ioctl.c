/* SPDX-License-Identifier: GPL-2.0-or-later */
/*
 * GPIO CHARDEV IOCTL Tool
 *
 * Author: nhat092005
 *
 * Command-line utility to test ioctl interface of gpio-chardev driver.
 */

#define _DEFAULT_SOURCE

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/ioctl.h>
#include <errno.h>

/* Include UAPI header - same header used by kernel */
#include "../../include/uapi/gpio-chardev.h"

#define DEVICE_PATH "/dev/gpio-chardev"

/* Private Function Prototypes */
static void print_usage(const char *prog);
static int set_led_state(int fd, unsigned int state);
static int get_led_state(int fd);
static int toggle_led(int fd);
static int get_gpio_pin(int fd);
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

	if (strcmp(cmd, "on") == 0)
	{
		ret = set_led_state(fd, GPIO_CHARDEV_ON);
		if (ret == 0)
		{
			printf("GPIO turned ON\n");
		}
	}
	else if (strcmp(cmd, "off") == 0)
	{
		ret = set_led_state(fd, GPIO_CHARDEV_OFF);
		if (ret == 0)
		{
			printf("GPIO turned OFF\n");
		}
	}
	else if (strcmp(cmd, "toggle") == 0)
	{
		ret = toggle_led(fd);
		if (ret == 0)
		{
			printf("GPIO toggled\n");
		}
	}
	else if (strcmp(cmd, "get") == 0)
	{
		ret = get_led_state(fd);
		if (ret >= 0)
		{
			printf("GPIO state: %s\n", ret ? "ON" : "OFF");
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
			unsigned int count = atoi(argv[2]);
			unsigned int on_ms = atoi(argv[3]);
			unsigned int off_ms = atoi(argv[4]);

			ret = blink_led(fd, count, on_ms, off_ms);
			if (ret == 0)
			{
				printf("Blinking GPIO %u times (%ums on, %ums off)\n",
					   count, on_ms, off_ms);
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
