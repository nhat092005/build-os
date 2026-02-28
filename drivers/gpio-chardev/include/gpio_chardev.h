/* SPDX-License-Identifier: GPL-2.0-or-later */
/*
 * GPIO Character Device Driver - Internal Header
 *
 * This header file contains internal definitions and structures for the
 * GPIO character device driver. This is for kernel-internal use only.
 */

#ifndef _GPIO_CHARDEV_H
#define _GPIO_CHARDEV_H

#ifdef __KERNEL__

#include <linux/cdev.h>
#include <linux/device.h>
#include <linux/mutex.h>
#include <linux/types.h>
#include <linux/gpio/consumer.h>
#include <linux/workqueue.h>

#include "uapi/gpio_chardev.h"

/* Driver information */
#define GPIO_CHARDEV_DRIVER_NAME "gpio-chardev"
#define GPIO_CHARDEV_DRIVER_VERSION "1.1.0"
#define GPIO_CHARDEV_CLASS_NAME "gpio-chardev-class"

/* Default configuration */
#define GPIO_CHARDEV_DEFAULT_PIN 17
#define GPIO_CHARDEV_MAX_BUFFER 16

/**
 * struct gpio_chardev_dev - GPIO character device structure
 * @dev_num:         Device number (major:minor)
 * @cdev:            Character device structure
 * @dev:             Embedded device (owned by cdev layer via cdev_device_add)
 * @lock:            Mutex serialising GPIO access (state reads/writes)
 * @gpio_pin:        GPIO pin number (populated from DT via desc_to_gpio())
 * @gpio_desc:       GPIO descriptor (managed by devres)
 * @blink_work:      Delayed work for LED blink (replaces kthread)
 * @blink_count:     Number of cycles completed so far
 * @blink_total:     Total cycles to blink (0 = infinite)
 * @blink_delay_on:  On-phase duration in milliseconds
 * @blink_delay_off: Off-phase duration in milliseconds
 * @blink_phase:     Current blink phase (0 = off -> on, 1 = on -> off)
 * @blink_active:    true while blink is scheduled
 */
struct gpio_chardev_dev {
	dev_t dev_num;
	struct cdev cdev;
	struct device dev;
	struct mutex lock; /* serialises GPIO access across all file_ops */
	int gpio_pin;
	struct gpio_desc *gpio_desc;

	/* Blink via delayed workqueue (no kthread) */
	struct delayed_work blink_work;
	__u32 blink_count;
	__u32 blink_total;
	__u32 blink_delay_on;
	__u32 blink_delay_off;
	int blink_phase;
	bool blink_active;
};

#endif /* __KERNEL__ */

#endif /* _GPIO_CHARDEV_H */
