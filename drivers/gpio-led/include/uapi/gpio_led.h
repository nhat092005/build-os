/* SPDX-License-Identifier: GPL-2.0 WITH Linux-syscall-note */
/*
 * GPIO LED Driver - User API
 *
 * This header defines the user-visible API for the GPIO LED driver.
 * It can be included by both kernel and userspace code.
 */

#ifndef _UAPI_GPIO_LED_H
#define _UAPI_GPIO_LED_H

#include <linux/types.h>
#include <linux/ioctl.h>

/*
 * IOCTL commands for GPIO LED driver
 */
#define GPIO_LED_IOC_MAGIC 'G'

/* Set LED state (ON/OFF) */
#define GPIO_LED_IOC_SET_STATE _IOW(GPIO_LED_IOC_MAGIC, 1, __u32)

/* Get LED state */
#define GPIO_LED_IOC_GET_STATE _IOR(GPIO_LED_IOC_MAGIC, 2, __u32)

/* Toggle LED state */
#define GPIO_LED_IOC_TOGGLE _IO(GPIO_LED_IOC_MAGIC, 3)

/* Get GPIO pin number */
#define GPIO_LED_IOC_GET_GPIO _IOR(GPIO_LED_IOC_MAGIC, 4, __u32)

/* Blink LED (parameter: count, 0 = infinite) */
#define GPIO_LED_IOC_BLINK _IOW(GPIO_LED_IOC_MAGIC, 5, struct gpio_led_blink)

/*
 * LED states
 */
#define GPIO_LED_OFF 0
#define GPIO_LED_ON 1

/*
 * Blink configuration structure
 */
struct gpio_led_blink
{
	__u32 count;	 /* Number of blinks, 0 = infinite */
	__u32 delay_on;	 /* ON duration in milliseconds */
	__u32 delay_off; /* OFF duration in milliseconds */
};

#endif /* _UAPI_GPIO_LED_H */
