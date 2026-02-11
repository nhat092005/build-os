/* SPDX-License-Identifier: GPL-2.0 WITH Linux-syscall-note */
/*
 * GPIO Character Device Driver - User API
 *
 * This header defines the user-visible API for the GPIO character device driver.
 * It can be included by both kernel and userspace code.
 */

#ifndef _UAPI_GPIO_CHARDEV_H
#define _UAPI_GPIO_CHARDEV_H

#include <linux/types.h>
#include <linux/ioctl.h>

/*
 * IOCTL commands for GPIO Character Device driver
 */
#define GPIO_CHARDEV_IOC_MAGIC 'G'

/* Set GPIO state (ON/OFF) */
#define GPIO_CHARDEV_IOC_SET_STATE _IOW(GPIO_CHARDEV_IOC_MAGIC, 1, __u32)

/* Get GPIO state */
#define GPIO_CHARDEV_IOC_GET_STATE _IOR(GPIO_CHARDEV_IOC_MAGIC, 2, __u32)

/* Toggle GPIO state */
#define GPIO_CHARDEV_IOC_TOGGLE _IO(GPIO_CHARDEV_IOC_MAGIC, 3)

/* Get GPIO pin number */
#define GPIO_CHARDEV_IOC_GET_GPIO _IOR(GPIO_CHARDEV_IOC_MAGIC, 4, __u32)

/* Blink GPIO (parameter: count, 0 = infinite) */
#define GPIO_CHARDEV_IOC_BLINK _IOW(GPIO_CHARDEV_IOC_MAGIC, 5, struct gpio_chardev_blink)

/*
 * GPIO states
 */
#define GPIO_CHARDEV_OFF 0
#define GPIO_CHARDEV_ON 1

/*
 * Blink configuration structure
 */
struct gpio_chardev_blink
{
	__u32 count;	 /* Number of blinks, 0 = infinite */
	__u32 delay_on;	 /* ON duration in milliseconds */
	__u32 delay_off; /* OFF duration in milliseconds */
};

#endif /* _UAPI_GPIO_CHARDEV_H */
