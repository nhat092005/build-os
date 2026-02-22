// SPDX-License-Identifier: GPL-2.0
/*
 * GPIO Rust Driver Control Library
 *
 * This library provides functions to control the GPIO Rust driver from userspace.
 * It allows userspace applications to easily manipulate GPIO state, direction,
 * and retrieve information without needing to interact with the device file directly.
 */

#ifndef _LIB_GPIO_RUST_H
#define _LIB_GPIO_RUST_H

#include <stddef.h>
#include <stdint.h>
#include <sys/ioctl.h>

/** Buffer size for internal operations */
#define GPIO_RUST_BUFFER_SIZE 64

/** Default GPIO pin number (matching gpio-rust kernel module) */
#define GPIO_RUST_DEFAULT_PIN 22

/** GPIO base number for sysfs (gpiochip0 on Raspberry Pi) */
#define GPIO_RUST_BASE 512

/** Computed sysfs GPIO number (pin + base) */
#define GPIO_RUST_SYSFS_PIN (GPIO_RUST_DEFAULT_PIN + GPIO_RUST_BASE)

/** Device path */
#define GPIO_RUST_DEV_PATH "/dev/gpio-rust"

/*
 * IOCTL definitions (must match kernel uapi/gpio-rust.h)
 */
#define GPIO_RUST_IOC_MAGIC     'R'
#define GPIO_RUST_IOC_SET_STATE _IOW(GPIO_RUST_IOC_MAGIC, 1, uint32_t)
#define GPIO_RUST_IOC_GET_STATE _IOR(GPIO_RUST_IOC_MAGIC, 2, uint32_t)
#define GPIO_RUST_IOC_TOGGLE    _IO(GPIO_RUST_IOC_MAGIC, 3)
#define GPIO_RUST_IOC_GET_GPIO  _IOR(GPIO_RUST_IOC_MAGIC, 4, uint32_t)

/**
 * struct gpio_rust_device - GPIO Rust device handle
 * @fd:       File descriptor for /dev/gpio-rust (-1 if not open)
 * @dev_path: Path to the device file
 *
 * Holds the open file descriptor to the misc char device.
 */
typedef struct gpio_rust_device {
	int fd;
	char dev_path[GPIO_RUST_BUFFER_SIZE];
} gpio_rust_device_t;

/**
 * struct gpio_rust_info - Snapshot of GPIO Rust device state
 * @gpio_pin:  Hardware GPIO pin number
 * @direction: Current direction (always "out")
 * @value:     Current value (0 or 1)
 */
typedef struct gpio_rust_info {
	int gpio_pin;
	char direction[GPIO_RUST_BUFFER_SIZE];
	int value;
} gpio_rust_info_t;

/**
 * gpio_rust_open - Open the GPIO Rust device
 * @dev: Pointer to gpio_rust_device_t to initialize
 *
 * Opens /dev/gpio-rust and stores the file descriptor.
 * Return: 0 on success, negative errno on failure
 */
int gpio_rust_open(gpio_rust_device_t *dev);

/**
 * gpio_rust_close - Close the GPIO Rust device
 * @dev: GPIO device handle
 */
void gpio_rust_close(gpio_rust_device_t *dev);

/**
 * gpio_rust_set_value - Set GPIO output value
 * @dev:   GPIO device handle
 * @value: 0 (LOW) or 1 (HIGH)
 * Return: 0 on success, negative errno on failure
 */
int gpio_rust_set_value(gpio_rust_device_t *dev, int value);

/**
 * gpio_rust_get_value - Get current GPIO value
 * @dev:   GPIO device handle
 * @value: Pointer to int to store result (0 or 1)
 * Return: 0 on success, negative errno on failure
 */
int gpio_rust_get_value(gpio_rust_device_t *dev, int *value);

/**
 * gpio_rust_toggle - Toggle the GPIO state
 * @dev: GPIO device handle
 * Return: 0 on success, negative errno on failure
 */
int gpio_rust_toggle(gpio_rust_device_t *dev);

/**
 * gpio_rust_get_info - Read GPIO device information
 * @dev:  GPIO device handle
 * @info: Pointer to gpio_rust_info_t to fill
 * Return: 0 on success, negative errno on failure
 */
int gpio_rust_get_info(gpio_rust_device_t *dev, gpio_rust_info_t *info);

/**
 * gpio_rust_blink - Blink the GPIO with specified parameters
 * @dev:      GPIO device handle
 * @count:    Number of blinks
 * @delay_ms: Delay between on/off in milliseconds
 * Return: 0 on success, negative errno on failure
 *
 * This function blocks for the duration of the blink sequence.
 */
int gpio_rust_blink(gpio_rust_device_t *dev, int count, int delay_ms);

/**
 * gpio_rust_strerror - Convert errno value to human-readable string
 * @errnum: Positive or negative errno value
 * Return: Pointer to error string (do not free)
 */
const char *gpio_rust_strerror(int errnum);

#endif /* _LIB_GPIO_RUST_H */
