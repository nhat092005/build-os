// SPDX-License-Identifier: GPL-2.0-or-later
/*
 * ds3231-rtc-ctl — Userspace control tool for DS3231 RTC
 *
 * Communicates with the DS3231 driver through the standard Linux RTC
 * ioctl interface (/dev/rtcN).  No custom ioctls required.
 *
 * Additionally reads the custom "temperature" sysfs attribute when the
 * driver's sysfs path can be resolved.
 *
 * Usage:
 *   ds3231-rtc-ctl read                        Read current time
 *   ds3231-rtc-ctl set YYYY-MM-DD HH:MM:SS     Set time
 *   ds3231-rtc-ctl temp                         Read chip temperature
 *   ds3231-rtc-ctl info                         Show RTC/driver info
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>
#include <fcntl.h>
#include <limits.h>
#include <unistd.h>
#include <dirent.h>
#include <sys/ioctl.h>
#include <linux/rtc.h>

/* --------------------------------------------------------------- */
/* Configuration                                                    */
/* --------------------------------------------------------------- */
#define DEFAULT_RTC_DEV     "/dev/rtc0"
#define SYSFS_RTC_BASE      "/sys/class/rtc"
#define TEMP_ATTR_NAME      "temperature"

/* --------------------------------------------------------------- */
/* Helpers                                                          */
/* --------------------------------------------------------------- */

/* Weekday names (0=Sunday, matching POSIX tm_wday) */
static const char * const wday_names[7] = {
	"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"
};

/**
 * resolve_rtc_node() - Find the /sys/class/rtc/rtcN entry for ds3231-rtc
 * @rtc_name: output buffer for the rtcN directory name (e.g. "rtc1")
 * @buflen:   size of @rtc_name buffer
 *
 * Scans /sys/class/rtc/ entries and reads the "name" file to match
 * "ds3231-rtc".  Falls back to "rtc0" if not found.
 *
 * Return: 0 if found, -1 if not found (caller should fall back to rtc0)
 */
static int resolve_rtc_node(char *rtc_name, size_t buflen)
{
	DIR *dir;
	struct dirent *ent;
	/* sizeof(SYSFS_RTC_BASE) + '/' + NAME_MAX + "/name" + NUL */
	char path[sizeof(SYSFS_RTC_BASE) + NAME_MAX + sizeof("/name")];
	char name[64];
	FILE *fp;

	dir = opendir(SYSFS_RTC_BASE);
	if (!dir)
		return -1;

	while ((ent = readdir(dir)) != NULL) {
		if (strncmp(ent->d_name, "rtc", 3) != 0)
			continue;

		snprintf(path, sizeof(path), "%s/%s/name",
			 SYSFS_RTC_BASE, ent->d_name);
		fp = fopen(path, "r");
		if (!fp)
			continue;
		if (fgets(name, sizeof(name), fp)) {
			name[strcspn(name, "\n")] = '\0';
			if (strcmp(name, "ds3231-rtc") == 0) {
				fclose(fp);
				closedir(dir);
				strncpy(rtc_name, ent->d_name, buflen - 1);
				rtc_name[buflen - 1] = '\0';
				return 0;
			}
		}
		fclose(fp);
	}
	closedir(dir);
	return -1;
}

/**
 * open_rtc() - Open the DS3231 RTC character device
 *
 * Scans sysfs to locate the correct /dev/rtcN for ds3231-rtc.
 * Falls back to /dev/rtc0 if sysfs scan fails.
 *
 * Return: file descriptor on success, exits on failure
 */
static int open_rtc(void)
{
	char rtc_node[32];
	char dev_path[64];
	int fd;

	if (resolve_rtc_node(rtc_node, sizeof(rtc_node)) == 0)
		snprintf(dev_path, sizeof(dev_path), "/dev/%s", rtc_node);
	else
		snprintf(dev_path, sizeof(dev_path), "%s", DEFAULT_RTC_DEV);

	fd = open(dev_path, O_RDWR);
	if (fd >= 0)
		return fd;

	fprintf(stderr, "Error: cannot open %s: %s\n", dev_path,
		strerror(errno));
	fprintf(stderr, "Hint: is ds3231-rtc.ko loaded and DS3231 connected?\n");
	exit(EXIT_FAILURE);
}

/**
 * resolve_temp_sysfs() - Build path to the temperature sysfs attribute
 * @buf:    output buffer
 * @buflen: size of @buf
 *
 * Re-uses resolve_rtc_node() to find the correct rtcN entry, then builds
 * the i2c device's temperature attribute path.
 *
 * Return: 0 on success, -1 if not found
 */
static int resolve_temp_sysfs(char *buf, size_t buflen)
{
	char rtc_node[32];

	if (resolve_rtc_node(rtc_node, sizeof(rtc_node)) != 0)
		return -1;

	snprintf(buf, buflen, "%s/%s/device/%s",
		 SYSFS_RTC_BASE, rtc_node, TEMP_ATTR_NAME);
	return 0;
}

/* --------------------------------------------------------------- */
/* Commands                                                         */
/* --------------------------------------------------------------- */

/**
 * cmd_read() - Read and display the current time from DS3231
 */
static int cmd_read(void)
{
	struct rtc_time rtc_tm;
	int fd = open_rtc();

	if (ioctl(fd, RTC_RD_TIME, &rtc_tm) < 0) {
		if (errno == ENODATA)
			fprintf(stderr,
				"Error: time not valid (oscillator was stopped). "
				"Set the time first.\n");
		else
			fprintf(stderr, "Error: RTC_RD_TIME: %s\n",
				strerror(errno));
		close(fd);
		return EXIT_FAILURE;
	}

	close(fd);

	printf("%04d-%02d-%02d %02d:%02d:%02d (%s)\n",
	       rtc_tm.tm_year + 1900,
	       rtc_tm.tm_mon + 1,
	       rtc_tm.tm_mday,
	       rtc_tm.tm_hour,
	       rtc_tm.tm_min,
	       rtc_tm.tm_sec,
	       rtc_tm.tm_wday >= 0 && rtc_tm.tm_wday <= 6
		       ? wday_names[rtc_tm.tm_wday] : "?");

	return EXIT_SUCCESS;
}

/**
 * day_of_week() - Compute ISO weekday (0=Sun..6=Sat) without timezone
 * @y: full year (e.g. 2025)
 * @m: month 1-12
 * @d: day-of-month 1-31
 *
 * Uses the Tomohiko Sakamoto algorithm — pure arithmetic, no mktime(),
 * no timezone dependency.
 */
static int day_of_week(int y, int m, int d)
{
	static const int t[] = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};

	if (m < 3)
		y--;
	return (y + y / 4 - y / 100 + y / 400 + t[m - 1] + d) % 7;
}

/**
 * cmd_set() - Set DS3231 time from "YYYY-MM-DD HH:MM:SS" arguments
 */
static int cmd_set(const char *date_str, const char *time_str)
{
	struct rtc_time rtc_tm;
	int year, mon, mday, hour, min, sec;
	int fd;

	if (sscanf(date_str, "%d-%d-%d", &year, &mon, &mday) != 3) {
		fprintf(stderr, "Error: bad date format (use YYYY-MM-DD)\n");
		return EXIT_FAILURE;
	}
	if (sscanf(time_str, "%d:%d:%d", &hour, &min, &sec) != 3) {
		fprintf(stderr, "Error: bad time format (use HH:MM:SS)\n");
		return EXIT_FAILURE;
	}

	/* Full range validation */
	if (year < 2000 || year > 2099) {
		fprintf(stderr, "Error: year must be 2000–2099\n");
		return EXIT_FAILURE;
	}
	if (mon < 1 || mon > 12) {
		fprintf(stderr, "Error: month must be 01–12\n");
		return EXIT_FAILURE;
	}
	if (mday < 1 || mday > 31) {
		fprintf(stderr, "Error: day must be 01–31\n");
		return EXIT_FAILURE;
	}
	if (hour < 0 || hour > 23) {
		fprintf(stderr, "Error: hour must be 00–23\n");
		return EXIT_FAILURE;
	}
	if (min < 0 || min > 59) {
		fprintf(stderr, "Error: minute must be 00–59\n");
		return EXIT_FAILURE;
	}
	if (sec < 0 || sec > 59) {
		fprintf(stderr, "Error: second must be 00–59\n");
		return EXIT_FAILURE;
	}

	memset(&rtc_tm, 0, sizeof(rtc_tm));
	rtc_tm.tm_year = year - 1900;
	rtc_tm.tm_mon  = mon - 1;
	rtc_tm.tm_mday = mday;
	rtc_tm.tm_hour = hour;
	rtc_tm.tm_min  = min;
	rtc_tm.tm_sec  = sec;

	/* Compute weekday via Sakamoto algorithm (no timezone dependency) */
	rtc_tm.tm_wday = day_of_week(year, mon, mday);

	fd = open_rtc();
	if (ioctl(fd, RTC_SET_TIME, &rtc_tm) < 0) {
		fprintf(stderr, "Error: RTC_SET_TIME: %s\n", strerror(errno));
		close(fd);
		return EXIT_FAILURE;
	}
	close(fd);

	printf("Time set: %04d-%02d-%02d %02d:%02d:%02d (%s)\n",
	       year, mon, mday, hour, min, sec,
	       wday_names[rtc_tm.tm_wday]);
	return EXIT_SUCCESS;
}

/**
 * cmd_temp() - Read and display the DS3231 on-chip temperature
 */
static int cmd_temp(void)
{
	char sysfs_path[256];
	FILE *fp;
	long millideg;

	if (resolve_temp_sysfs(sysfs_path, sizeof(sysfs_path)) < 0) {
		fprintf(stderr,
			"Error: cannot locate DS3231 temperature sysfs\n");
		return EXIT_FAILURE;
	}

	fp = fopen(sysfs_path, "r");
	if (!fp) {
		fprintf(stderr, "Error: %s: %s\n", sysfs_path,
			strerror(errno));
		return EXIT_FAILURE;
	}

	if (fscanf(fp, "%ld", &millideg) != 1) {
		fprintf(stderr, "Error: failed to parse temperature\n");
		fclose(fp);
		return EXIT_FAILURE;
	}
	fclose(fp);

	printf("%.2f °C\n", (double)millideg / 1000.0);
	return EXIT_SUCCESS;
}

/**
 * cmd_info() - Summarise DS3231 driver and hardware details
 */
static int cmd_info(void)
{
	printf("DS3231 RTC Driver — Information\n");
	printf("  Device:        %s\n", DEFAULT_RTC_DEV);
	printf("  Driver:        ds3231-rtc (maxim,ds3231)\n");
	printf("  Bus:           I2C1 @ address 0x68\n");
	printf("  Year range:    2000-01-01 … 2099-12-31\n");
	printf("  I2C speed:     up to 400 kHz (Fast Mode)\n");
	printf("  Temperature:   on-chip TCXO sensor, 0.25 °C resolution\n");
	printf("  Battery:       CR2032 coin cell (timekeeping on VBAT)\n");
	printf("\n");
	printf("Standard tools:\n");
	printf("  hwclock -r          Read hardware RTC\n");
	printf("  hwclock -w          Write system time to RTC\n");
	printf("  hwclock -s          Set system clock from RTC\n");
	printf("  hwclock --verbose   Verbose diagnostics\n");
	printf("\n");
	printf("Custom commands:\n");
	printf("  ds3231-rtc-ctl read                     Read time\n");
	printf("  ds3231-rtc-ctl set YYYY-MM-DD HH:MM:SS  Set time\n");
	printf("  ds3231-rtc-ctl temp                     Read temperature\n");
	return EXIT_SUCCESS;
}

/* --------------------------------------------------------------- */
/* Main                                                             */
/* --------------------------------------------------------------- */
static void usage(const char *prog)
{
	fprintf(stderr,
		"Usage:\n"
		"  %s read\n"
		"  %s set YYYY-MM-DD HH:MM:SS\n"
		"  %s temp\n"
		"  %s info\n",
		prog, prog, prog, prog);
}

int main(int argc, char *argv[])
{
	if (argc < 2) {
		usage(argv[0]);
		return EXIT_FAILURE;
	}

	if (strcmp(argv[1], "read") == 0)
		return cmd_read();

	if (strcmp(argv[1], "set") == 0) {
		if (argc < 4) {
			fprintf(stderr, "Error: 'set' requires YYYY-MM-DD HH:MM:SS\n");
			return EXIT_FAILURE;
		}
		return cmd_set(argv[2], argv[3]);
	}

	if (strcmp(argv[1], "temp") == 0)
		return cmd_temp();

	if (strcmp(argv[1], "info") == 0)
		return cmd_info();

	fprintf(stderr, "Unknown command: %s\n", argv[1]);
	usage(argv[0]);
	return EXIT_FAILURE;
}
