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
#define HWMON_TEMP_ATTR     "temp1_input"

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
				snprintf(rtc_name, buflen, "%.*s", (int)(buflen - 1), ent->d_name);
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
 * resolve_temp_sysfs() - Build path to the hwmon temperature attribute
 * @buf:    output buffer
 * @buflen: size of @buf
 *
 * Finds the rtcN node, then scans the hwmon subdirectory under the
 * parent I2C device to locate temp1_input.
 *
 * Return: 0 on success, -1 if not found
 */
static int resolve_temp_sysfs(char *buf, size_t buflen)
{
	char rtc_node[32];
	/* /sys/class/rtc/ + rtcN + /device/hwmon/ + NUL */
	char hwmon_dir[sizeof(SYSFS_RTC_BASE) + NAME_MAX +
		       sizeof("/device/hwmon/")];
	DIR *dir;
	struct dirent *ent;

	if (resolve_rtc_node(rtc_node, sizeof(rtc_node)) != 0)
		return -1;

	snprintf(hwmon_dir, sizeof(hwmon_dir), "%s/%s/device/hwmon",
		 SYSFS_RTC_BASE, rtc_node);

	dir = opendir(hwmon_dir);
	if (!dir)
		return -1;

	while ((ent = readdir(dir)) != NULL) {
		if (strncmp(ent->d_name, "hwmon", 5) != 0)
			continue;
		closedir(dir);
		snprintf(buf, buflen, "%s/%s/%s",
			 hwmon_dir, ent->d_name, HWMON_TEMP_ATTR);
		return 0;
	}

	closedir(dir);
	return -1;
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
	if (year < 2000 || year > 2199) {
		fprintf(stderr, "Error: year must be 2000–2199\n");
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
	char sysfs_path[sizeof(SYSFS_RTC_BASE) + NAME_MAX +
			sizeof("/device/hwmon/") + NAME_MAX +
			sizeof("/") + sizeof(HWMON_TEMP_ATTR)];
	FILE *fp;
	long millideg;

	if (resolve_temp_sysfs(sysfs_path, sizeof(sysfs_path)) < 0) {
		fprintf(stderr,
			"Error: cannot locate DS3231 hwmon temperature\n");
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
	printf("  Year range:    2000-01-01 … 2199-12-31\n");
	printf("  I2C speed:     up to 400 kHz (Fast Mode)\n");
	printf("  Temperature:   on-chip TCXO sensor, 0.25 °C resolution\n");
	printf("  Alarm:         Alarm 1, second-precision (requires SQW wiring)\n");
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
	printf("  ds3231-rtc-ctl alarm-read               Read alarm setting\n");
	printf("  ds3231-rtc-ctl alarm-set DD HH:MM:SS    Set alarm 1\n");
	printf("  ds3231-rtc-ctl alarm-on                 Enable alarm IRQ\n");
	printf("  ds3231-rtc-ctl alarm-off                Disable alarm IRQ\n");
	return EXIT_SUCCESS;
}

/* --------------------------------------------------------------- */
/* Alarm Commands                                                   */
/* --------------------------------------------------------------- */

/**
 * cmd_alarm_read() - Read and display the current Alarm 1 setting
 */
static int cmd_alarm_read(void)
{
	struct rtc_wkalrm alarm;
	int fd = open_rtc();

	memset(&alarm, 0, sizeof(alarm));
	if (ioctl(fd, RTC_WKALM_RD, &alarm) < 0) {
		fprintf(stderr, "Error: RTC_WKALM_RD: %s\n", strerror(errno));
		close(fd);
		return EXIT_FAILURE;
	}
	close(fd);

	printf("Alarm 1: day=%02d %02d:%02d:%02d  enabled=%s  pending=%s\n",
	       alarm.time.tm_mday,
	       alarm.time.tm_hour,
	       alarm.time.tm_min,
	       alarm.time.tm_sec,
	       alarm.enabled ? "yes" : "no",
	       alarm.pending ? "yes" : "no");

	return EXIT_SUCCESS;
}

/**
 * cmd_alarm_set() - Set Alarm 1 from "DD HH:MM:SS" arguments
 *
 * Sets the alarm and enables the interrupt in one operation.
 */
static int cmd_alarm_set(const char *day_str, const char *time_str)
{
	struct rtc_wkalrm alarm;
	int mday, hour, min, sec;
	char *endptr;
	int fd;

	errno = 0;
	mday = (int)strtol(day_str, &endptr, 10);
	if (errno || *endptr != '\0' || mday < 1 || mday > 31) {
		fprintf(stderr, "Error: day must be 01–31\n");
		return EXIT_FAILURE;
	}

	if (sscanf(time_str, "%d:%d:%d", &hour, &min, &sec) != 3) {
		fprintf(stderr, "Error: bad time format (use HH:MM:SS)\n");
		return EXIT_FAILURE;
	}
	if (hour < 0 || hour > 23 || min < 0 || min > 59 ||
	    sec < 0 || sec > 59) {
		fprintf(stderr, "Error: invalid time values\n");
		return EXIT_FAILURE;
	}

	memset(&alarm, 0, sizeof(alarm));
	alarm.enabled      = 1;
	alarm.time.tm_mday = mday;
	alarm.time.tm_hour = hour;
	alarm.time.tm_min  = min;
	alarm.time.tm_sec  = sec;

	fd = open_rtc();
	if (ioctl(fd, RTC_WKALM_SET, &alarm) < 0) {
		fprintf(stderr, "Error: RTC_WKALM_SET: %s\n", strerror(errno));
		close(fd);
		return EXIT_FAILURE;
	}
	close(fd);

	printf("Alarm 1 set: day=%02d %02d:%02d:%02d (enabled)\n",
	       mday, hour, min, sec);
	return EXIT_SUCCESS;
}

/**
 * cmd_alarm_enable() - Enable Alarm 1 interrupt
 */
static int cmd_alarm_enable(void)
{
	int fd = open_rtc();

	if (ioctl(fd, RTC_AIE_ON, 0) < 0) {
		fprintf(stderr, "Error: RTC_AIE_ON: %s\n", strerror(errno));
		close(fd);
		return EXIT_FAILURE;
	}
	close(fd);

	printf("Alarm 1 interrupt enabled\n");
	return EXIT_SUCCESS;
}

/**
 * cmd_alarm_disable() - Disable Alarm 1 interrupt
 */
static int cmd_alarm_disable(void)
{
	int fd = open_rtc();

	if (ioctl(fd, RTC_AIE_OFF, 0) < 0) {
		fprintf(stderr, "Error: RTC_AIE_OFF: %s\n", strerror(errno));
		close(fd);
		return EXIT_FAILURE;
	}
	close(fd);

	printf("Alarm 1 interrupt disabled\n");
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
		"  %s alarm-read\n"
		"  %s alarm-set DD HH:MM:SS\n"
		"  %s alarm-on\n"
		"  %s alarm-off\n"
		"  %s info\n",
		prog, prog, prog, prog, prog, prog, prog, prog);
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

	if (strcmp(argv[1], "alarm-read") == 0)
		return cmd_alarm_read();

	if (strcmp(argv[1], "alarm-set") == 0) {
		if (argc < 4) {
			fprintf(stderr, "Error: 'alarm-set' requires DD HH:MM:SS\n");
			return EXIT_FAILURE;
		}
		return cmd_alarm_set(argv[2], argv[3]);
	}

	if (strcmp(argv[1], "alarm-on") == 0)
		return cmd_alarm_enable();

	if (strcmp(argv[1], "alarm-off") == 0)
		return cmd_alarm_disable();

	if (strcmp(argv[1], "info") == 0)
		return cmd_info();

	fprintf(stderr, "Unknown command: %s\n", argv[1]);
	usage(argv[0]);
	return EXIT_FAILURE;
}
