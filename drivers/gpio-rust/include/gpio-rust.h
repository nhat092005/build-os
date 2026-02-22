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
#include "uapi/gpio-rust.h"
#endif

/* Driver information */
#define GPIO_RUST_DRIVER_NAME "gpio-rust"
#define GPIO_RUST_DRIVER_VERSION "1.0.0"

/* Default GPIO configuration */
#define GPIO_RUST_DEFAULT_PIN 22

/* GPIO base number for sysfs (gpiochip0 on Raspberry Pi, kernel 6.x) */
#define GPIO_RUST_BASE 512

/* Device Tree compatible string */
#define GPIO_RUST_DT_COMPAT "custom,gpio-rust"

#endif /* _GPIO_RUST_H */
