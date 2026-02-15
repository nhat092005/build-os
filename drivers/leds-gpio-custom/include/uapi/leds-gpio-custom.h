/* SPDX-License-Identifier: GPL-2.0 WITH Linux-syscall-note */
/*
 * GPIO LED Driver - User API
 *
 * This header defines constants and structures for the GPIO LED driver.
 * It can be included by both kernel and userspace code.
 *
 * Note: This driver uses LED class subsystem, so control is via sysfs:
 *   /sys/class/leds/<led-name>/brightness
 *   /sys/class/leds/<led-name>/trigger
 *   /sys/class/leds/<led-name>/max_brightness
 */

#ifndef _UAPI_LEDS_GPIO_CUSTOM_H
#define _UAPI_LEDS_GPIO_CUSTOM_H

#include <linux/types.h>

/*
 * LED States (used in sysfs brightness attribute)
 */
#define LED_OFF 0
#define LED_HALF 127
#define LED_FULL 255

/*
 * Common LED Triggers
 * Write these to /sys/class/leds/<led-name>/trigger
 *
 * Example triggers:
 *   - none: No trigger, manual control
 *   - heartbeat: Mimic heartbeat pattern
 *   - timer: Blink with configurable on/off times
 *   - default-on: Always on
 *   - cpu: Blink on CPU activity
 *   - mmc0/mmc1: Blink on SD card activity
 */

#endif /* _UAPI_LEDS_GPIO_CUSTOM_H */
