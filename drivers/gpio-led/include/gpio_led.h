/* SPDX-License-Identifier: GPL-2.0-or-later */
/*
 * GPIO LED Character Device Driver - Internal Header
 *
 * This header file contains internal definitions and structures for the
 * GPIO LED character device driver. This is for kernel-internal use only.
 */

#ifndef _GPIO_LED_H
#define _GPIO_LED_H

#ifdef __KERNEL__

#include <linux/cdev.h>
#include <linux/device.h>
#include <linux/mutex.h>
#include <linux/types.h>
#include <linux/gpio/consumer.h>
#include "uapi/gpio_led.h"

/* Driver information */
#define GPIO_LED_DRIVER_NAME "gpio_led"
#define GPIO_LED_DRIVER_VERSION "1.0.0"
#define GPIO_LED_CLASS_NAME "gpio_led_class"

/* Default configuration */
#define GPIO_LED_DEFAULT_PIN 17
#define GPIO_LED_MAX_BUFFER 16

/**
 * struct gpio_led_dev - GPIO LED device structure
 * @dev_num: Device number (major:minor)
 * @cdev: Character device structure
 * @class: Device class pointer
 * @device: Device pointer
 * @lock: Mutex for device access synchronization
 * @gpio_pin: GPIO pin number used by this device
 * @state: Current LED state (0=off, 1=on)
 * @gpio_requested: Flag indicating if GPIO has been requested
 *
 * This structure holds all the information needed to manage the
 * GPIO LED character device.
 */
struct gpio_led_dev
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

#endif /* _GPIO_LED_H */
