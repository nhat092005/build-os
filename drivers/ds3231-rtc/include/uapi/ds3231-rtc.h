/* SPDX-License-Identifier: GPL-2.0 WITH Linux-syscall-note */
/*
 * DS3231 RTC Driver - User API
 *
 * Shared constants between kernel driver and userspace tools.
 *
 * This driver registers as an RTC device via the Linux RTC subsystem.
 * Standard RTC interfaces are available automatically:
 *
 *   /dev/rtcN                           - Character device (RTC ioctls)
 *   /sys/class/rtc/rtcN/time            - RO:  current time  (HH:MM:SS)
 *   /sys/class/rtc/rtcN/date            - RO:  current date  (YYYY-MM-DD)
 *   /sys/class/rtc/rtcN/since_epoch     - RO:  seconds since Unix epoch
 *   /sys/class/rtc/rtcN/name            - RO:  driver name
 *
 * Temperature monitoring via hwmon subsystem:
 *   /sys/class/hwmon/hwmonN/temp1_input - RO: chip temperature in m°C
 */

#ifndef _UAPI_DS3231_RTC_H
#define _UAPI_DS3231_RTC_H

/*
 * hwmon temperature attribute name.
 * The value is in milli-degrees Celsius (e.g. "25250" = 25.25 °C).
 *
 * Example (hwmon path):
 *   cat /sys/class/hwmon/hwmonN/temp1_input
 *   25250
 */
#define DS3231_HWMON_TEMP_ATTR "temp1_input"

#endif /* _UAPI_DS3231_RTC_H */
