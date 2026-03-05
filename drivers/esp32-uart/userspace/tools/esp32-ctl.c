// SPDX-License-Identifier: GPL-2.0-or-later
/*
 * esp32-ctl — CLI tool for ESP32 communication over UART
 * 
 * This tool uses libesp32 to send commands and display responses from the ESP32.
 * It supports commands like ping, get_version, get_status, reset, set_led, and get_sensor.
 */

#include <errno.h>
#include <getopt.h>
#include <limits.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "esp32.h"

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
		"  ping                     Verify communication link\n"
		"  version                  Get firmware version\n"
		"  status                   Get device status\n"
		"  reset                    Reset ESP32\n"
		"  led <id> <on|off> [bri]  Set LED state\n"
		"  sensor                   Read sensor data\n"
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

static int cmd_ping(esp32_dev_t *d)
{
	int ret = esp32_ping(d);

	if (ret) {
		fprintf(stderr, "ping failed: %d\n", ret);
		return EXIT_COMM;
	}
	printf("PONG\n");
	return EXIT_OK;
}

static int cmd_version(esp32_dev_t *d)
{
	char ver[ESP32_VERSION_MAX_LEN];
	int ret = esp32_get_version(d, ver, sizeof(ver));

	if (ret) {
		fprintf(stderr, "get_version failed: %d\n", ret);
		return EXIT_COMM;
	}
	printf("%s\n", ver);
	return EXIT_OK;
}

static int cmd_status(esp32_dev_t *d)
{
	struct esp32_status st;
	int ret = esp32_get_status(d, &st);

	if (ret) {
		fprintf(stderr, "get_status failed: %d\n", ret);
		return EXIT_COMM;
	}
	printf("state:     %u\n", st.state);
	printf("wifi_rssi: %d dBm\n", (int8_t)st.wifi_rssi);
	printf("uptime:    %u s\n", st.uptime_sec);
	printf("free_heap: %u bytes\n", st.free_heap);
	return EXIT_OK;
}

static int cmd_reset(esp32_dev_t *d)
{
	int ret = esp32_reset(d);

	if (ret) {
		fprintf(stderr, "reset failed: %d\n", ret);
		return EXIT_COMM;
	}
	printf("OK\n");
	return EXIT_OK;
}

static int cmd_led(esp32_dev_t *d, int argc, char **argv)
{
	if (argc < 2) {
		fprintf(stderr, "led: requires <id> <on|off> [brightness]\n");
		return EXIT_ARGS;
	}

	long led_id;

	if (parse_long(argv[0], &led_id, 10) < 0 || led_id < 0 ||
	    led_id > 255) {
		fprintf(stderr, "led: invalid id '%s'\n", argv[0]);
		return EXIT_ARGS;
	}

	uint8_t state;

	if (strcmp(argv[1], "on") == 0) {
		state = 1;
	} else if (strcmp(argv[1], "off") == 0) {
		state = 0;
	} else {
		fprintf(stderr, "led: state must be 'on' or 'off', got '%s'\n",
			argv[1]);
		return EXIT_ARGS;
	}

	long brightness = (state == 1) ? 255 : 0;

	if (argc >= 3) {
		if (parse_long(argv[2], &brightness, 10) < 0 ||
		    brightness < 0 || brightness > 255) {
			fprintf(stderr, "led: invalid brightness '%s'\n",
				argv[2]);
			return EXIT_ARGS;
		}
	}

	struct esp32_led led = {
		.led_id = (uint8_t)led_id,
		.state = state,
		.brightness = (uint8_t)brightness,
	};

	int ret = esp32_set_led(d, &led);

	if (ret) {
		fprintf(stderr, "set_led failed: %d\n", ret);
		return EXIT_COMM;
	}
	printf("OK\n");
	return EXIT_OK;
}

static int cmd_sensor(esp32_dev_t *d)
{
	struct esp32_sensor s;
	int ret = esp32_get_sensor(d, &s);

	if (ret) {
		fprintf(stderr, "get_sensor failed: %d\n", ret);
		return EXIT_COMM;
	}
	printf("temperature: %.2f C\n", s.temperature / 100.0);
	printf("humidity:    %.2f %%RH\n", s.humidity / 100.0);
	printf("light:       %u lux\n", s.light_lux);
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

	esp32_dev_t *d = esp32_open(device, baud);

	if (!d) {
		fprintf(stderr, "failed to open %s at %d baud: %s\n", device,
			baud, strerror(errno));
		return EXIT_COMM;
	}
	esp32_set_verbose(d, verbose);

	int rc;

	if (strcmp(cmd, "ping") == 0) {
		rc = cmd_ping(d);
	} else if (strcmp(cmd, "version") == 0) {
		rc = cmd_version(d);
	} else if (strcmp(cmd, "status") == 0) {
		rc = cmd_status(d);
	} else if (strcmp(cmd, "reset") == 0) {
		rc = cmd_reset(d);
	} else if (strcmp(cmd, "led") == 0) {
		rc = cmd_led(d, argc - optind - 1, &argv[optind + 1]);
	} else if (strcmp(cmd, "sensor") == 0) {
		rc = cmd_sensor(d);
	} else {
		fprintf(stderr, "unknown command: %s\n", cmd);
		usage(argv[0]);
		rc = EXIT_ARGS;
	}

	esp32_close(d);
	return rc;
}
