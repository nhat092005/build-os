/* SPDX-License-Identifier: GPL-2.0 WITH Linux-syscall-note */
/*
 * GPIO LED Driver - User API
 *
 * Shared constants between kernel driver and userspace.
 *
 * Sysfs interface exposed by this driver:
 *   /sys/class/leds/<name>/brightness     - R/W: 0=off, 255=full
 *   /sys/class/leds/<name>/max_brightness - RO:  maximum brightness value
 *   /sys/class/leds/<name>/trigger        - R/W: active trigger name
 *   /sys/class/leds/<name>/gpio_pin       - RO:  hardware GPIO pin number
 */

#ifndef _UAPI_GPIO_LEDS_H
#define _UAPI_GPIO_LEDS_H

/*
 * Sysfs attribute name for querying the hardware GPIO pin number.
 * Read this file to find out which physical GPIO pin the LED is wired to.
 * Example: cat /sys/class/leds/gpio-led/gpio_pin
 */
#define GPIO_LED_ATTR_GPIO_PIN  "gpio_pin"

#endif /* _UAPI_GPIO_LEDS_H */
