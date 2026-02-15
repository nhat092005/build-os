/* SPDX-License-Identifier: GPL-2.0-or-later */
/*
 * GPIO LED Driver - Internal Header
 *
 * This header file contains internal definitions for the GPIO LED driver.
 * This is for kernel-internal use only.
 */

#ifndef _LEDS_GPIO_CUSTOM_H
#define _LEDS_GPIO_CUSTOM_H

#ifdef __KERNEL__

#include <linux/leds.h>
#include <linux/gpio/consumer.h>
#include <linux/platform_device.h>

#include "uapi/leds-gpio-custom.h"

/* Driver information */
#define DRIVER_NAME "leds-gpio-custom"
#define DRIVER_VERSION "1.0.0"

/**
 * struct gpio_led_data - GPIO LED device data
 * @cdev: LED class device
 * @gpiod: GPIO descriptor for the LED
 * @active_low: Flag indicating if LED is active low
 * @default_state: Default state of LED at boot
 * @retain_state_suspended: Keep LED state during suspend
 * @can_sleep: GPIO operations may sleep
 *
 * This structure holds all information needed to manage a GPIO-based LED
 * using the Linux LED class subsystem.
 */
struct gpio_led_data
{
	struct led_classdev cdev;
	struct gpio_desc *gpiod;
	bool active_low;
	bool retain_state_suspended;
	bool can_sleep;
	enum led_brightness default_state;
};

#endif /* __KERNEL__ */

#endif /* _LEDS_GPIO_CUSTOM_H */
