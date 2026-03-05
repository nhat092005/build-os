/* SPDX-License-Identifier: GPL-2.0-or-later */
/*
 * GPIO LED Driver - Internal Header
 *
 * This header file contains internal definitions for the GPIO LED driver.
 * This is for kernel-internal use only.
 */

#ifndef _GPIO_LEDS_H
#define _GPIO_LEDS_H

#ifdef __KERNEL__

#include <linux/leds.h>
#include <linux/gpio/consumer.h>
#include <linux/platform_device.h>

#include "uapi/gpio_leds.h"

/* Driver information */
#define GPIO_LEDS_DRIVER_NAME "gpio-leds"
#define GPIO_LEDS_DRIVER_VERSION "1.0.0"

/**
 * struct gpio_led_data - GPIO LED device data
 * @cdev: LED class device
 * @gpiod: GPIO descriptor for the LED
 * @default_state: Default state of LED at boot
 * @retain_state_suspended: Keep LED state during suspend
 * @can_sleep: GPIO operations may sleep
 *
 * Active-low polarity is handled by the GPIO descriptor layer
 * via the DTS gpios flags cell (GPIO_ACTIVE_LOW = 1).  The driver
 * always works with logical values: 1 = on, 0 = off.
 */
struct gpio_led_data {
	struct led_classdev cdev;
	struct gpio_desc *gpiod;
	bool retain_state_suspended;
	bool can_sleep;
	enum led_brightness default_state;
};

#endif /* __KERNEL__ */

#endif /* _GPIO_LEDS_H */
