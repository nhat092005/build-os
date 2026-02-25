/* SPDX-License-Identifier: GPL-2.0 WITH Linux-syscall-note */
/*
 * GPIO Rust Driver - User API
 *
 * This header defines the user-visible API for the GPIO Rust driver.
 * It can be included by both kernel and userspace code.
 */

#ifndef _UAPI_GPIO_RUST_H
#define _UAPI_GPIO_RUST_H

#include <linux/types.h>
#include <linux/ioctl.h>

/*
 * IOCTL commands for GPIO Rust driver
 */
#define GPIO_RUST_IOC_MAGIC 'R'

/* Set GPIO state (0=off, 1=on) */
#define GPIO_RUST_IOC_SET_STATE _IOW(GPIO_RUST_IOC_MAGIC, 1, __u32)

/* Get GPIO state */
#define GPIO_RUST_IOC_GET_STATE _IOR(GPIO_RUST_IOC_MAGIC, 2, __u32)

/* Toggle GPIO state */
#define GPIO_RUST_IOC_TOGGLE _IO(GPIO_RUST_IOC_MAGIC, 3)

/* Get GPIO pin number (hardware BCM pin) */
#define GPIO_RUST_IOC_GET_GPIO _IOR(GPIO_RUST_IOC_MAGIC, 4, __u32)

/*
 * GPIO states
 */
#define GPIO_RUST_OFF 0
#define GPIO_RUST_ON 1

/*
 * Device path
 */
#define GPIO_RUST_DEV_PATH "/dev/gpio-rust"

#endif /* _UAPI_GPIO_RUST_H */
