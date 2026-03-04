/* SPDX-License-Identifier: GPL-2.0-only */
/*
 * GPIO Inputs Test Tool
 *
 * This is a simple userspace tool to read events from the gpio-inputs driver.
 * It scans /sys/class/input for a device with the specified name (default "gpio-inputs"),
 * opens the corresponding /dev/input/eventX device, and prints key press/release events 
 * to the console. 
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>
#include <signal.h>
#include <unistd.h>
#include <fcntl.h>
#include <dirent.h>

#include <linux/input.h>

#define SYS_INPUT_DIR "/sys/class/input"
#define DEV_INPUT_DIR "/dev/input"
#define NAME_BUF_SIZE 256
#define PATH_BUF_SIZE 512

static volatile int running = 1;

static void sigint_handler(int sig)
{
	(void)sig;
	running = 0;
}

/**
 * find_event_device() - Scan /sys/class/input/ to find device by name
 * @target_name: device name to match (e.g. "gpio-inputs")
 * @out_path:    buffer for the resulting /dev/input/eventX path
 * @out_len:     size of out_path buffer
 *
 * Returns 0 on success, -1 if device not found.
 */
static int find_event_device(const char *target_name, char *out_path,
			     size_t out_len);

/**
 * keycode_to_name() - Return a human-readable key name for an EV_KEY code
 * @code: input event code
 *
 * Returns a static string for common button codes; falls back to decimal.
 */
static const char *keycode_to_name(unsigned int code);

int main(int argc, char *argv[])
{
	const char *device_name = "gpio-inputs";
	char dev_path[PATH_BUF_SIZE];
	struct input_event ev;
	ssize_t n;
	int fd;
	int ret = 0;

	if (argc >= 2)
		device_name = argv[1];

	/* Install SIGINT handler for clean exit */
	signal(SIGINT, sigint_handler);

	/* Find the /dev/input/eventX device */
	if (find_event_device(device_name, dev_path, sizeof(dev_path)) < 0) {
		fprintf(stderr, "Device '%s' not found in %s\n", device_name,
			SYS_INPUT_DIR);
		fprintf(stderr, "Is the gpio-inputs module loaded?\n");
		return EXIT_FAILURE;
	}

	printf("Opening %s (%s)\n", dev_path, device_name);
	printf("Press Ctrl+C to exit\n\n");

	fd = open(dev_path, O_RDONLY);
	if (fd < 0) {
		perror("open");
		return EXIT_FAILURE;
	}

	while (running) {
		n = read(fd, &ev, sizeof(ev));
		if (n < 0) {
			if (errno == EINTR)
				continue; /* SIGINT — loop condition handles exit */
			perror("read");
			ret = EXIT_FAILURE;
			break;
		}
		if ((size_t)n < sizeof(ev))
			continue;

		/* Only report key press/release events (ignore EV_SYN etc.) */
		if (ev.type != EV_KEY)
			continue;

		printf("%-12s %s\n", keycode_to_name(ev.code),
		       ev.value ? "pressed" : "released");
		fflush(stdout);
	}

	printf("\nExiting.\n");
	close(fd);
	return ret;
}

static int find_event_device(const char *target_name, char *out_path,
			     size_t out_len)
{
	DIR *dir;
	struct dirent *entry;
	char name_path[PATH_BUF_SIZE];
	char name_buf[NAME_BUF_SIZE];
	FILE *f;
	int found = 0;

	dir = opendir(SYS_INPUT_DIR);
	if (!dir) {
		perror("opendir " SYS_INPUT_DIR);
		return -1;
	}

	while ((entry = readdir(dir)) != NULL) {
		/* Only process eventX directories */
		if (strncmp(entry->d_name, "event", 5) != 0)
			continue;

		snprintf(name_path, sizeof(name_path), "%s/%s/device/name",
			 SYS_INPUT_DIR, entry->d_name);

		f = fopen(name_path, "r");
		if (!f)
			continue;

		if (fgets(name_buf, sizeof(name_buf), f)) {
			/* Strip trailing newline */
			name_buf[strcspn(name_buf, "\n")] = '\0';

			if (strcmp(name_buf, target_name) == 0) {
				snprintf(out_path, out_len, "%s/%s",
					 DEV_INPUT_DIR, entry->d_name);
				found = 1;
			}
		}
		fclose(f);

		if (found)
			break;
	}

	closedir(dir);
	return found ? 0 : -1;
}

static const char *keycode_to_name(unsigned int code)
{
	static char buf[32];

	switch (code) {
	case BTN_0:
		return "BTN_0";
	case BTN_1:
		return "BTN_1";
	case BTN_2:
		return "BTN_2";
	case BTN_3:
		return "BTN_3";
	case BTN_SOUTH:
		return "BTN_SOUTH";
	case BTN_EAST:
		return "BTN_EAST";
	case KEY_ENTER:
		return "KEY_ENTER";
	case KEY_1:
		return "KEY_1";
	case KEY_2:
		return "KEY_2";
	case KEY_SPACE:
		return "KEY_SPACE";
	default:
		snprintf(buf, sizeof(buf), "KEY_%u", code);
		return buf;
	}
}