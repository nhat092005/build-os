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

#include "uapi/gpio-chardev.h"

/* Driver information */
#define GPIO_CHARDEV_DRIVER_NAME "gpio-chardev"
#define GPIO_CHARDEV_DRIVER_VERSION "1.0.0"
#define GPIO_CHARDEV_CLASS_NAME "gpio-chardev-class"

/* Default configuration */
#define GPIO_CHARDEV_DEFAULT_PIN 17
#define GPIO_CHARDEV_MAX_BUFFER 16

/**
 * struct gpio_chardev_dev - GPIO character device structure
 * @dev_num: Device number (major:minor)
 * @cdev: Character device structure
 * @class: Device class pointer
 * @device: Device pointer
 * @lock: Mutex for device access synchronization
 * @gpio_pin: GPIO pin number used by this device
 * @state: Current GPIO state (0=off, 1=on)
 * @gpio_requested: Flag indicating if GPIO has been requested
 *
 * This structure holds all the information needed to manage the
 * GPIO character device.
 */
struct gpio_chardev_dev
{
    dev_t dev_num;
    struct cdev cdev;
    struct class *class;
    struct device *device;
    struct mutex lock;
    int gpio_pin;
    struct gpio_desc *gpio_desc;
    int state;
    bool gpio_requested;
};

#endif /* __KERNEL__ */

#endif /* _GPIO_CHARDEV_H */
