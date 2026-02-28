/* SPDX-License-Identifier: GPL-2.0-or-later */
/*
 * GPIO Rust Driver - Shared Constants
 *
 * This header defines constants and macros shared across the GPIO Rust driver,
 * including both C and Rust code. It can be included by both kernel and userspace code.
 */

#ifndef _GPIO_RUST_H
#define _GPIO_RUST_H

#ifdef __KERNEL__
#include "uapi/gpio_rust.h"

/* Prototypes for C helper functions called from Rust via FFI.
 * Declaring them here satisfies -Wmissing-prototypes in gpio_helpers.c
 * and makes the ABI explicit for the Rust bindgen step.
 */

/* GPIO API wrappers */
int rust_helper_gpio_request(unsigned int gpio, const char *label);
void rust_helper_gpio_free(unsigned int gpio);
int rust_helper_gpio_direction_output(unsigned int gpio, int value);
void rust_helper_gpio_set_value(unsigned int gpio, int value);
int rust_helper_gpio_get_value(unsigned int gpio);

/* Module-parameter accessors */
unsigned int rust_helper_get_gpio_pin(void);
unsigned int rust_helper_get_hw_pin_param(void);

/* Misc char device lifecycle */
int rust_helper_misc_register(void);
void rust_helper_misc_deregister(void);

/* Rust-exported callbacks called from C file_operations */
int rust_gpio_handle_get_value(void);
void rust_gpio_handle_set_value(int value);
unsigned int rust_gpio_handle_get_hw_pin(void);

#endif /* __KERNEL__ */

/* Driver information */
#define GPIO_RUST_DRIVER_NAME "gpio-rust"
#define GPIO_RUST_DRIVER_VERSION "1.0.0"

/* Default GPIO configuration */
#define GPIO_RUST_DEFAULT_PIN 16

/* GPIO base number for sysfs (gpiochip0 on Raspberry Pi, kernel 6.x) */
#define GPIO_RUST_BASE 512

#endif /* _GPIO_RUST_H */
