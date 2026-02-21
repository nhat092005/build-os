// SPDX-License-Identifier: GPL-2.0
/*
 * libled - LED Control Library
 *
 * This library provides functions to control Linux LED class devices via sysfs.
 * It allows userspace applications to easily manipulate LED brightness, triggers,
 * and other attributes without needing to interact with sysfs directly.
 */

#ifndef _LIBLED_H
#define _LIBLED_H

#include <stddef.h>

#define GPIO_BASE 512

/* Constants */
#define LED_BUFFER_SIZE 512
#define LED_BASE_PATH "/sys/class/leds"

/**
 * struct led_device - LED device handle
 * @name: LED device name (e.g. "gpio-led")
 * @path: Base sysfs path (/sys/class/leds/<name>)
 * @brightness_path: Path to brightness attribute
 * @trigger_path: Path to trigger attribute
 * @max_brightness_path: Path to max_brightness attribute
 * @delay_on_path: Path to delay_on attribute (timer trigger)
 * @delay_off_path: Path to delay_off attribute (timer trigger)
 * @gpio_pin_path: Path to gpio_pin attribute (hardware GPIO number)
 */
typedef struct led_device
{
    char name[LED_BUFFER_SIZE];
    char path[LED_BUFFER_SIZE];
    char brightness_path[LED_BUFFER_SIZE];
    char trigger_path[LED_BUFFER_SIZE];
    char max_brightness_path[LED_BUFFER_SIZE];
    char delay_on_path[LED_BUFFER_SIZE];
    char delay_off_path[LED_BUFFER_SIZE];
    char gpio_pin_path[LED_BUFFER_SIZE];
} led_device_t;

/**
 * struct led_info - LED device information
 * @name: LED name (sysfs device name)
 * @brightness: Current brightness value
 * @max_brightness: Maximum brightness value
 * @trigger: Current trigger name
 * @gpio_pin: Hardware GPIO pin number (-1 if unavailable)
 */
typedef struct led_info
{
    char name[LED_BUFFER_SIZE];
    int brightness;
    int max_brightness;
    char trigger[LED_BUFFER_SIZE];
    int gpio_pin;
} led_info_t;

/**
 * led_list_callback_t - Callback function for LED enumeration
 * @name: LED device name
 * @user_data: User-provided data
 * Return: 0 to continue, non-zero to stop enumeration
 */
typedef int (*led_list_callback_t)(const char *name, void *user_data);

/* Core LED Functions */

/**
 * led_open - Open and initialize an LED device
 * @led: Pointer to led_device structure to initialize
 * @name: Name of the LED device (e.g., "custom-led")
 * Return: 0 on success, negative errno on failure
 */
int led_open(led_device_t *led, const char *name);

/**
 * led_close - Close LED device (currently no-op, for API completeness)
 * @led: Pointer to led_device structure
 */
void led_close(led_device_t *led);

/**
 * led_set_brightness - Set LED brightness
 * @led: LED device handle
 * @value: Brightness value (0 to max_brightness)
 * Return: 0 on success, negative errno on failure
 */
int led_set_brightness(led_device_t *led, int value);

/**
 * led_get_brightness - Get current LED brightness
 * @led: LED device handle
 * Return: Current brightness value on success, negative errno on failure
 */
int led_get_brightness(led_device_t *led);

/**
 * led_get_max_brightness - Get maximum brightness value
 * @led: LED device handle
 * Return: Maximum brightness value on success, negative errno on failure
 */
int led_get_max_brightness(led_device_t *led);

/**
 * led_on - Turn LED on to maximum brightness
 * @led: LED device handle
 * Return: 0 on success, negative errno on failure
 */
int led_on(led_device_t *led);

/**
 * led_off - Turn LED off
 * @led: LED device handle
 * Return: 0 on success, negative errno on failure
 */
int led_off(led_device_t *led);

/* Trigger Functions */

/**
 * led_set_trigger - Set LED trigger
 * @led: LED device handle
 * @trigger: Trigger name (e.g., "none", "timer", "heartbeat")
 * Return: 0 on success, negative errno on failure
 */
int led_set_trigger(led_device_t *led, const char *trigger);

/**
 * led_get_trigger - Get current LED trigger
 * @led: LED device handle
 * @buffer: Buffer to store trigger string
 * @size: Size of buffer
 * Return: 0 on success, negative errno on failure
 */
int led_get_trigger(led_device_t *led, char *buffer, size_t size);

/**
 * led_set_timer - Set timer trigger with on/off delays
 * @led: LED device handle
 * @delay_on_ms: Time LED is on (milliseconds)
 * @delay_off_ms: Time LED is off (milliseconds)
 * Return: 0 on success, negative errno on failure
 */
int led_set_timer(led_device_t *led, int delay_on_ms, int delay_off_ms);

/* Advanced Functions */

/**
 * led_blink - Blink LED for specified count
 * @led: LED device handle
 * @count: Number of blinks (0 = infinite)
 * @delay_ms: Delay between blinks in milliseconds
 * Return: 0 on success, negative errno on failure
 */
int led_blink(led_device_t *led, int count, int delay_ms);

/**
 * led_pulse - Pulse LED with fade in/out effect
 * @led: LED device handle
 * @duration_ms: Total duration in milliseconds
 * @steps: Number of brightness steps (smoothness)
 * Return: 0 on success, negative errno on failure
 */
int led_pulse(led_device_t *led, int duration_ms, int steps);

/* Enumeration Functions */

/**
 * led_list - List all available LED devices
 * @callback: Callback function called for each LED
 * @user_data: User data passed to callback
 * Return: Number of LEDs found, negative errno on failure
 */
int led_list(led_list_callback_t callback, void *user_data);

/**
 * led_get_info - Get LED device information
 * @led: LED device handle
 * @info: Pointer to led_info structure to fill
 * Return: 0 on success, negative errno on failure
 */
int led_get_info(led_device_t *led, led_info_t *info);

/**
 * led_get_gpio_pin - Get the hardware GPIO pin number this LED is wired to
 * @led: LED device handle
 * Return: GPIO pin number (>= 0) on success, negative errno on failure
 */
int led_get_gpio_pin(led_device_t *led);

/* Utility Functions */

/**
 * led_exists - Check if LED device exists
 * @name: LED device name
 * Return: 1 if exists, 0 if not, negative errno on error
 */
int led_exists(const char *name);

/**
 * led_strerror - Get error message for LED error code
 * @errnum: Error number (should be negative)
 * Return: Error message string
 */
const char *led_strerror(int errnum);

#endif /* _LIBLED_H */