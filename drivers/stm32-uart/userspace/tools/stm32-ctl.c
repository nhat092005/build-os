// SPDX-License-Identifier: GPL-2.0-or-later
/*
 * stm32-ctl — CLI tool for STM32 communication over UART
 *
 * This tool allows users to send commands to an STM32 microcontroller over a
 * UART connection.  It supports various commands like ping, get_version,
 * get_status, reset, gpio-set/get, adc read, and pwm control.
 */

#include <errno.h>
#include <getopt.h>
#include <limits.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "stm32.h"

#define DEFAULT_BAUD 115200
#define DEFAULT_DEVICE "/dev/ttyAMA0"

#define EXIT_OK 0
#define EXIT_COMM 1
#define EXIT_ARGS 2

static const struct option long_opts[] = {
	{ "device", required_argument, NULL, 'd' },
	{ "baud", required_argument, NULL, 'b' },
	{ "verbose", no_argument, NULL, 'v' },
	{ "help", no_argument, NULL, 'h' },
	{ NULL, 0, NULL, 0 }
};

static void usage(const char *prog)
{
	fprintf(stderr,
		"Usage: %s -d <device> [-b baud] [-v] <command> [args...]\n"
		"Commands:\n"
		"  ping                           Verify communication link\n"
		"  version                        Get firmware version\n"
		"  status                         Get device status\n"
		"  reset                          Reset STM32\n"
		"  gpio-set <pin> <in|out> <0|1>  Set GPIO pin\n"
		"  gpio-get <pin>                 Read GPIO pin state\n"
		"  adc <channel>                  Read ADC channel\n"
		"  pwm <ch> <freq_hz> <duty>      Set PWM output\n"
		"Options:\n"
		"  -d, --device <path>  UART device (default: %s)\n"
		"  -b, --baud <rate>    Baud rate (default: %d)\n"
		"  -v, --verbose        Enable debug output\n"
		"  -h, --help           Show this help\n",
		prog, DEFAULT_DEVICE, DEFAULT_BAUD);
}

/**
 * parse_long() - Parse string to long with full error checking
 * @str:    input string
 * @out:    output value
 * @base:   numeric base (0 for auto-detect)
 *
 * Returns 0 on success, -1 on error.
 */
static int parse_long(const char *str, long *out, int base)
{
	char *endptr;

	errno = 0;
	long val = strtol(str, &endptr, base);

	if (errno != 0 || endptr == str || *endptr != '\0')
		return -1;
	*out = val;
	return 0;
}

static int cmd_ping(stm32_dev_t *d)
{
	int ret = stm32_ping(d);

	if (ret) {
		fprintf(stderr, "ping failed: %d\n", ret);
		return EXIT_COMM;
	}
	printf("PONG\n");
	return EXIT_OK;
}

static int cmd_version(stm32_dev_t *d)
{
	char ver[STM32_VERSION_MAX_LEN];
	int ret = stm32_get_version(d, ver, sizeof(ver));

	if (ret) {
		fprintf(stderr, "get_version failed: %d\n", ret);
		return EXIT_COMM;
	}
	printf("%s\n", ver);
	return EXIT_OK;
}

static int cmd_status(stm32_dev_t *d)
{
	struct stm32_status st;
	int ret = stm32_get_status(d, &st);

	if (ret) {
		fprintf(stderr, "get_status failed: %d\n", ret);
		return EXIT_COMM;
	}
	printf("state:    %u\n", st.state);
	printf("uptime:   %u s\n", st.uptime_sec);
	printf("vcc:      %u mV\n", st.vcc_mv);
	printf("mcu_temp: %d C\n", st.mcu_temp);
	return EXIT_OK;
}

static int cmd_reset(stm32_dev_t *d)
{
	int ret = stm32_reset(d);

	if (ret) {
		fprintf(stderr, "reset failed: %d\n", ret);
		return EXIT_COMM;
	}
	printf("OK\n");
	return EXIT_OK;
}

static int cmd_gpio_set(stm32_dev_t *d, int argc, char **argv)
{
	if (argc < 3) {
		fprintf(stderr, "gpio-set: requires <pin> <in|out> <0|1>\n");
		return EXIT_ARGS;
	}

	long pin;

	if (parse_long(argv[0], &pin, 10) < 0 || pin < 0 || pin > 255) {
		fprintf(stderr, "gpio-set: invalid pin '%s'\n", argv[0]);
		return EXIT_ARGS;
	}

	uint8_t direction;

	if (strcmp(argv[1], "out") == 0) {
		direction = 1;
	} else if (strcmp(argv[1], "in") == 0) {
		direction = 0;
	} else {
		fprintf(stderr,
			"gpio-set: direction must be 'in' or 'out', got '%s'\n",
			argv[1]);
		return EXIT_ARGS;
	}

	long value;

	if (parse_long(argv[2], &value, 10) < 0 || value < 0 || value > 1) {
		fprintf(stderr, "gpio-set: value must be 0 or 1, got '%s'\n",
			argv[2]);
		return EXIT_ARGS;
	}

	struct stm32_gpio gpio = {
		.pin = (uint8_t)pin,
		.direction = direction,
		.value = (uint8_t)value,
	};

	int ret = stm32_set_gpio(d, &gpio);

	if (ret) {
		fprintf(stderr, "set_gpio failed: %d\n", ret);
		return EXIT_COMM;
	}
	printf("OK\n");
	return EXIT_OK;
}

static int cmd_gpio_get(stm32_dev_t *d, int argc, char **argv)
{
	if (argc < 1) {
		fprintf(stderr, "gpio-get: requires <pin>\n");
		return EXIT_ARGS;
	}

	long pin;

	if (parse_long(argv[0], &pin, 10) < 0 || pin < 0 || pin > 255) {
		fprintf(stderr, "gpio-get: invalid pin '%s'\n", argv[0]);
		return EXIT_ARGS;
	}

	struct stm32_gpio gpio;
	int ret = stm32_get_gpio(d, (uint8_t)pin, &gpio);

	if (ret) {
		fprintf(stderr, "get_gpio failed: %d\n", ret);
		return EXIT_COMM;
	}
	printf("pin:       %u\n", gpio.pin);
	printf("direction: %s\n", gpio.direction ? "output" : "input");
	printf("value:     %u\n", gpio.value);
	return EXIT_OK;
}

static int cmd_adc(stm32_dev_t *d, int argc, char **argv)
{
	if (argc < 1) {
		fprintf(stderr, "adc: requires <channel>\n");
		return EXIT_ARGS;
	}

	long ch;

	if (parse_long(argv[0], &ch, 10) < 0 || ch < 0 || ch > 255) {
		fprintf(stderr, "adc: invalid channel '%s'\n", argv[0]);
		return EXIT_ARGS;
	}

	struct stm32_adc adc;
	int ret = stm32_get_adc(d, (uint8_t)ch, &adc);

	if (ret) {
		fprintf(stderr, "get_adc failed: %d\n", ret);
		return EXIT_COMM;
	}
	printf("channel:    %u\n", adc.channel);
	printf("raw:        %u\n", adc.raw);
	printf("voltage_mv: %u\n", adc.voltage_mv);
	return EXIT_OK;
}

static int cmd_pwm(stm32_dev_t *d, int argc, char **argv)
{
	if (argc < 3) {
		fprintf(stderr, "pwm: requires <channel> <freq_hz> <duty>\n");
		return EXIT_ARGS;
	}

	long ch, freq, duty;

	if (parse_long(argv[0], &ch, 10) < 0 || ch < 0 || ch > 255) {
		fprintf(stderr, "pwm: invalid channel '%s'\n", argv[0]);
		return EXIT_ARGS;
	}

	if (parse_long(argv[1], &freq, 10) < 0 || freq < 0 || freq > 65535) {
		fprintf(stderr, "pwm: invalid frequency '%s'\n", argv[1]);
		return EXIT_ARGS;
	}

	if (parse_long(argv[2], &duty, 10) < 0 || duty < 0 || duty > 10000) {
		fprintf(stderr,
			"pwm: duty must be 0-10000 (0.00%%-100.00%%), got '%s'\n",
			argv[2]);
		return EXIT_ARGS;
	}

	struct stm32_pwm pwm = {
		.channel = (uint8_t)ch,
		.frequency = (uint16_t)freq,
		.duty = (uint16_t)duty,
	};

	int ret = stm32_set_pwm(d, &pwm);

	if (ret) {
		fprintf(stderr, "set_pwm failed: %d\n", ret);
		return EXIT_COMM;
	}
	printf("OK\n");
	return EXIT_OK;
}

int main(int argc, char *argv[])
{
	const char *device = DEFAULT_DEVICE;
	int baud = DEFAULT_BAUD;
	bool verbose = false;
	int opt;

	while ((opt = getopt_long(argc, argv, "d:b:vh", long_opts, NULL)) !=
	       -1) {
		switch (opt) {
		case 'd':
			device = optarg;
			break;
		case 'b': {
			long val;

			if (parse_long(optarg, &val, 10) < 0 || val <= 0 ||
			    val > INT_MAX) {
				fprintf(stderr, "invalid baud rate: %s\n",
					optarg);
				return EXIT_ARGS;
			}
			baud = (int)val;
			break;
		}
		case 'v':
			verbose = true;
			break;
		case 'h':
			usage(argv[0]);
			return EXIT_OK;
		default:
			usage(argv[0]);
			return EXIT_ARGS;
		}
	}

	if (optind >= argc) {
		fprintf(stderr, "error: no command specified\n");
		usage(argv[0]);
		return EXIT_ARGS;
	}

	const char *cmd = argv[optind];

	stm32_dev_t *d = stm32_open(device, baud);

	if (!d) {
		fprintf(stderr, "failed to open %s at %d baud: %s\n", device,
			baud, strerror(errno));
		return EXIT_COMM;
	}
	stm32_set_verbose(d, verbose);

	int rc;

	if (strcmp(cmd, "ping") == 0) {
		rc = cmd_ping(d);
	} else if (strcmp(cmd, "version") == 0) {
		rc = cmd_version(d);
	} else if (strcmp(cmd, "status") == 0) {
		rc = cmd_status(d);
	} else if (strcmp(cmd, "reset") == 0) {
		rc = cmd_reset(d);
	} else if (strcmp(cmd, "gpio-set") == 0) {
		rc = cmd_gpio_set(d, argc - optind - 1, &argv[optind + 1]);
	} else if (strcmp(cmd, "gpio-get") == 0) {
		rc = cmd_gpio_get(d, argc - optind - 1, &argv[optind + 1]);
	} else if (strcmp(cmd, "adc") == 0) {
		rc = cmd_adc(d, argc - optind - 1, &argv[optind + 1]);
	} else if (strcmp(cmd, "pwm") == 0) {
		rc = cmd_pwm(d, argc - optind - 1, &argv[optind + 1]);
	} else {
		fprintf(stderr, "unknown command: %s\n", cmd);
		usage(argv[0]);
		rc = EXIT_ARGS;
	}

	stm32_close(d);
	return rc;
}
