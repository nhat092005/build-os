/* SPDX-License-Identifier: GPL-2.0-or-later */
/*
 * GPIO GPIO IOCTL Test Tool
 *
 * Author: nhat092005
 *
 * Command-line utility to test ioctl interface of gpio-led driver.
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

/* Function prototypes */
static void print_usage(const char *prog);
static int set_led_state(int fd, unsigned int state);
static int get_led_state(int fd);
static int toggle_led(int fd);
static int get_gpio_pin(int fd);
static int blink_led(int fd, unsigned int count, unsigned int on_ms,
		     unsigned int off_ms);

int main(int argc, char *argv[])
{
	int fd;
	int ret = 0;

	if (argc < 2) {
		print_usage(argv[0]);
		return 1;
	}

	/* Open device */
	fd = open(DEVICE_PATH, O_RDWR);
	if (fd < 0) {
		perror("Failed to open device");
		fprintf(stderr, "Make sure driver is loaded: insmod gpio_chardev.ko\n");
		return 1;
	}

	/* Execute command */
	const char *cmd = argv[1];

	if (strcmp(cmd, "on") == 0) {
		ret = set_led_state(fd, GPIO_CHARDEV_ON);
		if (ret == 0) {
			printf("GPIO turned ON\n");
		}
	} else if (strcmp(cmd, "off") == 0) {
		ret = set_led_state(fd, GPIO_CHARDEV_OFF);
		if (ret == 0) {
			printf("GPIO turned OFF\n");
		}
	} else if (strcmp(cmd, "toggle") == 0) {
		ret = toggle_led(fd);
		if (ret == 0) {
			printf("GPIO toggled\n");
		}
	} else if (strcmp(cmd, "get") == 0) {
		ret = get_led_state(fd);
		if (ret >= 0) {
			printf("GPIO state: %s\n", ret ? "ON" : "OFF");
			ret = 0;
		}
	} else if (strcmp(cmd, "gpio") == 0) {
		ret = get_gpio_pin(fd);
		if (ret >= 0) {
			printf("GPIO pin: %d\n", ret);
			ret = 0;
		}
	} else if (strcmp(cmd, "blink") == 0) {
		unsigned int count = (argc >= 3) ? atoi(argv[2]) : 10;
		unsigned int on_ms = (argc >= 4) ? atoi(argv[3]) : 500;
		unsigned int off_ms = (argc >= 5) ? atoi(argv[4]) : 500;

		ret = blink_led(fd, count, on_ms, off_ms);
		if (ret == 0) {
			printf("Blinking GPIO %u times (%ums on, %ums off)\n",
			       count, on_ms, off_ms);
		}
	} else {
		fprintf(stderr, "Unknown command: %s\n", cmd);
		print_usage(argv[0]);
		ret = 1;
	}

	close(fd);
	return ret;
}

static void print_usage(const char *prog)
{
	printf("GPIO GPIO IOCTL Test Tool\n");
	printf("Usage: %s <command> [options]\n\n", prog);
	printf("Commands:\n");
	printf("  on                Turn GPIO on\n");
	printf("  off               Turn GPIO off\n");
	printf("  toggle            Toggle GPIO state\n");
	printf("  get               Get GPIO state\n");
	printf("  gpio              Get GPIO pin number\n");
	printf("  blink [count] [on_ms] [off_ms]\n");
	printf("                    Blink GPIO (default: 10 times, 500ms)\n");
	printf("\n");
	printf("Examples:\n");
	printf("  %s on                        # Turn GPIO on\n", prog);
	printf("  %s off                       # Turn GPIO off\n", prog);
	printf("  %s toggle                    # Toggle GPIO\n", prog);
	printf("  %s get                       # Get GPIO state\n", prog);
	printf("  %s gpio                      # Get GPIO pin\n", prog);
	printf("  %s blink 20 300 300          # Blink 20 times, 300ms on/off\n",
	       prog);
	printf("\n");
	printf("Device: %s\n", DEVICE_PATH);
}

static int set_led_state(int fd, unsigned int state)
{
	if (ioctl(fd, GPIO_CHARDEV_IOC_SET_STATE, &state) < 0) {
		perror("ioctl GPIO_CHARDEV_IOC_SET_STATE failed");
		return -1;
	}
	return 0;
}

static int get_led_state(int fd)
{
	unsigned int state;

	if (ioctl(fd, GPIO_CHARDEV_IOC_GET_STATE, &state) < 0) {
		perror("ioctl GPIO_CHARDEV_IOC_GET_STATE failed");
		return -1;
	}
	return state;
}

static int toggle_led(int fd)
{
	if (ioctl(fd, GPIO_CHARDEV_IOC_TOGGLE) < 0) {
		perror("ioctl GPIO_CHARDEV_IOC_TOGGLE failed");
		return -1;
	}
	return 0;
}

static int get_gpio_pin(int fd)
{
	unsigned int gpio;

	if (ioctl(fd, GPIO_CHARDEV_IOC_GET_GPIO, &gpio) < 0) {
		perror("ioctl GPIO_CHARDEV_IOC_GET_GPIO failed");
		return -1;
	}
	return gpio;
}

static int blink_led(int fd, unsigned int count, unsigned int on_ms,
		     unsigned int off_ms)
{
	struct gpio_chardev_blink blink = {
		.count = count,
		.delay_on = on_ms,
		.delay_off = off_ms,
	};

	if (ioctl(fd, GPIO_CHARDEV_IOC_BLINK, &blink) < 0) {
		perror("ioctl GPIO_CHARDEV_IOC_BLINK failed");
		return -1;
	}
	return 0;
}
