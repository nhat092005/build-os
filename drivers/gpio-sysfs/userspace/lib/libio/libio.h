// SPDX-License-Identifier: GPL-2.0
/*
 * libio - GPIO Control Library
 * Library for controlling Linux GPIO sysfs interface
 */

#ifndef _LIBIO_H
#define _LIBIO_H

#include <stddef.h>

/* Constants */
#define GPIO_BUFFER_SIZE 64
#define GPIO_SYSFS_PATH "/sys/class/gpio"
#define GPIO_EXPORT_PATH GPIO_SYSFS_PATH "/export"
#define GPIO_UNEXPORT_PATH GPIO_SYSFS_PATH "/unexport"

#define GPIO_BASE 512
#define GPIO_PIN "gpio%d"
#define GPIO_VALUE_PATH GPIO_SYSFS_PATH "/gpio%d/value"
#define GPIO_DIRECTION_PATH GPIO_SYSFS_PATH "/gpio%d/direction"

/**
 * struct gpio_device - GPIO device handle
 * @gpio_pin: GPIO pin number (e.g., "534")
 * @base_path: Base sysfs path for the GPIO (e.g., "/sys/class/gpio/gpio534)")
 * @value_path: Path to value file
 * @direction_path: Path to direction file
 * @edge_path: Path to edge file (for interrupts)
 * @active_low_path: Path to active_low file
 * @delay_on_path: Path to delay_on file (for timer trigger)
 * @delay_off_path: Path to delay_off file (for timer trigger)
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
 * @gpio_pin: GPIO pin number
 * @user_data: User-provided data
 * Return: 0 to continue, non-zero to stop enumeration
 */
typedef int (*gpio_list_callback_t)(const char *gpio_pin, void *user_data);

/* Core GPIO Functions */

/**
 * gpio_export - Export a GPIO pin
 * @gpio_pin: GPIO pin number to export (e.g., "534")
 * Return: 0 on success, negative errno on failure
 */
int gpio_export(const char *gpio_pin);

/**
 * gpio_unexport - Unexport a GPIO pin
 * @gpio_pin: GPIO pin number to unexport (e.g., "534")
 * Return: 0 on success, negative errno on failure
 */
int gpio_unexport(const char *gpio_pin);

/**
 * gpio_open - Open a GPIO device by name
 * @gpio: Pointer to gpio_sysfs_device_t structure to fill
 * @name: GPIO pin name (e.g., "gpio534")
 * Return: 0 on success, negative errno on failure
 */
int gpio_set_direction(gpio_sysfs_device_t *gpio, const char *direction);

/**
 * gpio_get_direction - Get current GPIO direction
 * @gpio: GPIO device handle
 * @buffer: Buffer to store direction string
 * @size: Size of buffer
 * Return: 0 on success, negative errno on failure
 */
int gpio_get_direction(gpio_sysfs_device_t *gpio, char *buffer, size_t size);

/**
 * gpio_set_value - Set GPIO value
 * @gpio: GPIO device handle
 * @value: Value to set (0 or 1)
 * Return: 0 on success, negative errno on failure
 */
int gpio_set_value(gpio_sysfs_device_t *gpio, int value);

/**
 * gpio_get_value - Get current GPIO value
 * @gpio: GPIO device handle
 * @value: Pointer to int to store the value (0 or 1)
 * Return: Current GPIO value (0 or 1) on success, negative errno on failure
 */
int gpio_get_value(gpio_sysfs_device_t *gpio, int *value);

/**
 * gpio_set_edge - Set GPIO edge for interrupts
 * @gpio: GPIO device handle
 * @edge: Edge type ("none", "rising", "falling", "both")
 * Return: 0 on success, negative errno on failure
 */
int gpio_set_edge(gpio_sysfs_device_t *gpio, const char *edge);

/**
 * gpio_get_edge - Get current GPIO edge setting
 * @gpio: GPIO device handle
 * @buffer: Buffer to store edge string
 * @size: Size of buffer
 * Return: 0 on success, negative errno on failure
 */
int gpio_get_edge(gpio_sysfs_device_t *gpio, char *buffer, size_t size);

/**
 * gpio_set_active_low - Set GPIO active_low setting
 * @gpio: GPIO device handle
 * @active_low: 0 for active high, 1 for active low
 * Return: 0 on success, negative errno on failure
 */
int gpio_set_active_low(gpio_sysfs_device_t *gpio, int active_low);

/**
 * gpio_get_active_low - Get current GPIO active_low setting
 * @gpio: GPIO device handle
 * @active_low: Pointer to int to store active_low value (0 for active high, 1 for active low)
 * Return: 0 on success, negative errno on failure
 */
int gpio_get_active_low(gpio_sysfs_device_t *gpio, int *active_low);

/**
 * gpio_list - List available GPIOs and invoke callback for each
 * @callback: Callback function to invoke for each GPIO
 * @user_data: User-provided data to pass to callback
 * Return: Number of GPIOs listed, negative errno on failure
 */
int gpio_list(gpio_list_callback_t callback, void *user_data);

/**
 * gpio_strerror - Convert error number to human-readable string
 * @errnum: Error number (positive or negative)
 * This function converts a positive or negative error number to 
 * a human-readable string using the standard strerror function. 
 * It ensures that the error number is treated as negative for lookup.
 */
const char *gpio_strerror(int errnum);

#endif /* _LIBIO_H */