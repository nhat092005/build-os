/* SPDX-License-Identifier: GPL-2.0-or-later */
/*
 * GPIO Inputs Driver — Internal Header
 *
 * Kernel-internal definitions shared across driver source files.
 * Not exposed to userspace — no uapi, no ioctl.
 */

#ifndef _GPIO_INPUTS_H
#define _GPIO_INPUTS_H

#include <linux/gpio/consumer.h>
#include <linux/input.h>
#include <linux/workqueue.h>

/* Software debounce fallback delay — used if gpiod_set_debounce() returns -ENOTSUPP */
#define GPIO_INPUTS_DEBOUNCE_MS 20

/* Default event code when DT does not specify linux,code */
#define GPIO_INPUTS_DEFAULT_KEY BTN_0

/**
 * struct gpio_button - Per-button state
 * @gpiod:     GPIO descriptor (from devm_gpiod_get_index())
 * @irq:       IRQ number (from gpiod_to_irq())
 * @code:      EV_KEY event code (from DT linux,code or GPIO_INPUTS_DEFAULT_KEY)
 * @debounce:  Delayed-work for software debounce fallback
 * @priv:      Back-pointer to driver private data (used in work handler)
 */
struct gpio_button {
	struct gpio_desc *gpiod;
	unsigned int irq;
	unsigned int code;
	struct delayed_work debounce;
	struct gpio_inputs_priv *priv;
};

/**
 * struct gpio_inputs_priv - Driver private data
 * @input:    Shared input device (one input_dev for all buttons)
 * @nbuttons: Number of buttons configured via DT
 * @buttons:  Flexible array of per-button state (allocated in probe())
 */
struct gpio_inputs_priv {
	struct input_dev *input;
	unsigned int nbuttons;
	struct gpio_button buttons[];
};

#endif /* _GPIO_INPUTS_H */
