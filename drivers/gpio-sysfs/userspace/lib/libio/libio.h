// SPDX-License-Identifier: GPL-2.0
/*
 * GPIO Control Library
 *
 * This library provides functions to control Linux GPIO pins
 * via the sysfs interface. It allows userspace applications
 * to easily manipulate GPIO pins without needing to interact
 * with sysfs directly.
 */

#ifndef _LIB_IO_H
#define _LIB_IO_H

#include <stddef.h>

/* Constants */
#define GPIO_BUFFER_SIZE 128
#define GPIO_SYSFS_PATH "/sys/class/gpio"
#define GPIO_EXPORT_PATH GPIO_SYSFS_PATH "/export"
#define GPIO_UNEXPORT_PATH GPIO_SYSFS_PATH "/unexport"

#define GPIO_BASE 512

/**
 * struct gpio_sysfs_device - GPIO device handle
 * @gpio_pin:        GPIO pin number string (e.g., "534")
 * @base_path:       Base sysfs path  (e.g., "/sys/class/gpio/gpio534")
 * @value_path:      Path to value file
 * @direction_path:  Path to direction file
 * @edge_path:       Path to edge file (for interrupts)
 * @active_low_path: Path to active_low file
 */
typedef struct gpio_sysfs_device
{
    char gpio_pin[16];
    char base_path[GPIO_BUFFER_SIZE];
    char value_path[GPIO_BUFFER_SIZE];
    char direction_path[GPIO_BUFFER_SIZE];
    char edge_path[GPIO_BUFFER_SIZE];
    char active_low_path[GPIO_BUFFER_SIZE];
} gpio_sysfs_device_t;

typedef struct gpio_sysfs_info
{
    char gpio_pin[16];
    char direction[GPIO_BUFFER_SIZE];
    char edge[GPIO_BUFFER_SIZE];
    int value;
    int active_low;
} gpio_sysfs_info_t;

/**
 * gpio_list_callback_t - Callback function for GPIO enumeration
 * @gpio_pin:  GPIO directory name (e.g., "gpio534")
 * @user_data: User-provided data
 * Return: 0 to continue, non-zero to stop enumeration
 */
typedef int (*gpio_list_callback_t)(const char *gpio_pin, void *user_data);

/* Core GPIO Functions */

/**
 * gpio_export - Export a GPIO pin via sysfs
 * @gpio_pin: GPIO pin number string (e.g., "534")
 * Return: 0 on success, negative errno on failure
 */
int gpio_export(const char *gpio_pin);

/**
 * gpio_unexport - Unexport a GPIO pin via sysfs
 * @gpio_pin: GPIO pin number string (e.g., "534")
 * Return: 0 on success, negative errno on failure
 */
int gpio_unexport(const char *gpio_pin);

/**
 * gpio_open - Initialize a gpio_sysfs_device_t and fill all sysfs paths
 * @gpio:     Pointer to gpio_sysfs_device_t to fill
 * @gpio_pin: GPIO pin number string (e.g., "534")
 * Return: 0 on success, negative errno on failure
 */
int gpio_open(gpio_sysfs_device_t *gpio, const char *gpio_pin);

/**
 * gpio_set_direction - Set GPIO direction
 * @gpio:      GPIO device handle
 * @direction: "in" or "out"
 * Return: 0 on success, negative errno on failure
 */
int gpio_set_direction(gpio_sysfs_device_t *gpio, const char *direction);

/**
 * gpio_get_direction - Get current GPIO direction
 * @gpio:   GPIO device handle
 * @buffer: Buffer to store result
 * @size:   Size of buffer
 * Return: 0 on success, negative errno on failure
 */
int gpio_get_direction(gpio_sysfs_device_t *gpio, char *buffer, size_t size);

/**
 * gpio_set_value - Set GPIO output value
 * @gpio:  GPIO device handle
 * @value: 0 or 1
 * Return: 0 on success, negative errno on failure
 */
int gpio_set_value(gpio_sysfs_device_t *gpio, int value);

/**
 * gpio_get_value - Get current GPIO value
 * @gpio:  GPIO device handle
 * @value: Pointer to int to store value (0 or 1)
 * Return: 0 on success, negative errno on failure
 */
int gpio_get_value(gpio_sysfs_device_t *gpio, int *value);

/**
 * gpio_set_edge - Set GPIO edge trigger for interrupts
 * @gpio: GPIO device handle
 * @edge: "none", "rising", "falling", or "both"
 * Return: 0 on success, negative errno on failure
 */
int gpio_set_edge(gpio_sysfs_device_t *gpio, const char *edge);

/**
 * gpio_get_edge - Get current GPIO edge setting
 * @gpio:   GPIO device handle
 * @buffer: Buffer to store result
 * @size:   Size of buffer
 * Return: 0 on success, negative errno on failure
 */
int gpio_get_edge(gpio_sysfs_device_t *gpio, char *buffer, size_t size);

/**
 * gpio_set_active_low - Set GPIO active_low polarity
 * @gpio:       GPIO device handle
 * @active_low: 0 = active high, 1 = active low
 * Return: 0 on success, negative errno on failure
 */
int gpio_set_active_low(gpio_sysfs_device_t *gpio, int active_low);

/**
 * gpio_get_active_low - Get current GPIO active_low setting
 * @gpio:       GPIO device handle
 * @active_low: Pointer to int to store value (0 or 1)
 * Return: 0 on success, negative errno on failure
 */
int gpio_get_active_low(gpio_sysfs_device_t *gpio, int *active_low);

/**
 * gpio_get_info - Read all GPIO attributes at once
 * @gpio: GPIO device handle
 * @info: Pointer to gpio_sysfs_info_t to fill
 * Return: 0 on success, negative errno on failure
 */
int gpio_get_info(gpio_sysfs_device_t *gpio, gpio_sysfs_info_t *info);

/**
 * gpio_list - Enumerate exported GPIOs and invoke callback for each
 * @callback:  Callback invoked for each GPIO directory found
 * @user_data: Passed through to callback
 * Return: Number of GPIOs listed on success, negative errno on failure
 */
int gpio_list(gpio_list_callback_t callback, void *user_data);

/**
 * gpio_strerror - Convert errno value to human-readable string
 * @errnum: Positive or negative errno value
 * Return: Pointer to error string (do not free)
 */
const char *gpio_strerror(int errnum);

/**
 * parse_int - Safely parse an integer string
 * @str: NUL-terminated string to parse
 * @result: Pointer to int to store parsed value
 * Return: 0 on success, negative errno on failure (-EINVAL, -ERANGE)
 */
int parse_int(const char *str, int *result);

#endif /* _LIB_IO_H */