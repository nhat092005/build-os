// SPDX-License-Identifier: GPL-2.0-or-later
/*
 * GPIO Inputs Driver
 *
 * This driver demonstrates how to use the Linux GPIO and Input subsystems
 * to implement a simple button input driver.  It supports multiple buttons
 * described in the Device Tree, with automatic GPIO and IRQ configuration.
 */

#include <linux/module.h>
#include <linux/platform_device.h>
#include <linux/input.h>
#include <linux/gpio/consumer.h>
#include <linux/interrupt.h>
#include <linux/of.h>
#include <linux/property.h>
#include <linux/slab.h>
#include <linux/pm.h>
#include <linux/workqueue.h>

#include "../include/gpio_inputs.h"

#define DRIVER_NAME "gpio-inputs"
#define DRIVER_VERSION "1.0.0"

/**
 * gpio_inputs_report() - Read GPIO and report event to input core
 * @btn: button to read and report
 *
 * Called from both the IRQ thread and the debounce work handler.
 * `gpiod_get_value_cansleep()` returns the logical value (0 = released,
 * 1 = pressed) already adjusted for GPIO_ACTIVE_LOW polarity in the DT.
 */
static void gpio_inputs_report(struct gpio_button *btn)
{
	struct gpio_inputs_priv *priv = btn->priv;
	int val;

	val = gpiod_get_value_cansleep(btn->gpiod);
	if (val < 0) {
		dev_err_ratelimited(&priv->input->dev,
				    "gpio read failed for code %u: %d\n",
				    btn->code, val);
		return;
	}

	input_report_key(priv->input, btn->code, val);
	input_sync(priv->input);
}

/**
 * gpio_inputs_debounce_work() - Software debounce work handler
 * @work: delayed_work embedded in struct gpio_button
 *
 * Invoked 20 ms after the GPIO edge to read the settled GPIO value.
 * Used as fallback when gpiod_set_debounce() returns -ENOTSUPP.
 */
static void gpio_inputs_debounce_work(struct work_struct *work)
{
	struct gpio_button *btn =
		container_of(work, struct gpio_button, debounce.work);

	gpio_inputs_report(btn);
}

/**
 * gpio_inputs_irq_handler() - IRQ top-half
 * @irq:  IRQ number (unused)
 * @data: pointer to struct gpio_button
 *
 * Only wakes the threaded handler — no GPIO reads in hard-IRQ context.
 *
 * Return: IRQ_WAKE_THREAD always
 */
static irqreturn_t gpio_inputs_irq_handler(int irq, void *data)
{
	return IRQ_WAKE_THREAD;
}

/**
 * gpio_inputs_irq_thread() - IRQ threaded handler
 * @irq:  IRQ number (unused)
 * @data: pointer to struct gpio_button
 *
 * If hardware debounce is available this reads and reports immediately.
 * If software debounce is in use (btn->debounce was initialised), schedules
 * the delayed work instead — the work handler does the actual read/report.
 *
 * Return: IRQ_HANDLED always
 */
static irqreturn_t gpio_inputs_irq_thread(int irq, void *data)
{
	struct gpio_button *btn = data;

	/*
	 * Only use delayed-work debounce if the work was initialised.
	 * Check by seeing if the delayed_work timer_list function pointer
	 * is set — INIT_DELAYED_WORK sets it; we only call it for the
	 * software-debounce path.
	 *
	 * Simpler: track with a bool in struct gpio_button.
	 */
	if (btn->priv->buttons[0].debounce.work.func ==
	    gpio_inputs_debounce_work) {
		/*
		 * Cancel any pending debounce and restart the timer.
		 * msecs_to_jiffies(0) means "next jiffie" — schedule with
		 * GPIO_INPUTS_DEBOUNCE_MS delay for the actual settling wait.
		 */
		mod_delayed_work(system_wq, &btn->debounce,
				 msecs_to_jiffies(GPIO_INPUTS_DEBOUNCE_MS));
	} else {
		gpio_inputs_report(btn);
	}

	return IRQ_HANDLED;
}

/**
 * gpio_inputs_probe() - Platform driver probe
 * @pdev: platform device matching "bos,gpio-inputs" DT node
 *
 * Allocates per-button state, configures GPIO, debounce, IRQs, and
 * registers the input device.
 *
 * Return: 0 on success, negative errno on failure
 */
static int gpio_inputs_probe(struct platform_device *pdev)
{
	struct device *dev = &pdev->dev;
	struct gpio_inputs_priv *priv;
	struct input_dev *input;
	unsigned int nbuttons;
	unsigned int i;
	int ret;

	/*
	 * Count the number of GPIOs described by the DT node.
	 * gpiod_count() returns the number of descriptors for a given
	 * con_id (NULL = unnamed, matched by property order in gpios=).
	 */
	ret = gpiod_count(dev, NULL);
	if (ret < 0) {
		dev_err(dev, "no GPIOs specified in DT: %d\n", ret);
		return ret;
	}
	nbuttons = (unsigned int)ret;

	/* Allocate priv with flexible array sized for nbuttons */
	priv = devm_kzalloc(dev, struct_size(priv, buttons, nbuttons),
			    GFP_KERNEL);
	if (!priv)
		return -ENOMEM;

	priv->nbuttons = nbuttons;

	/* Allocate the shared input device */
	input = devm_input_allocate_device(dev);
	if (!input)
		return -ENOMEM;

	priv->input = input;

	input->name = DRIVER_NAME;
	input->phys = DRIVER_NAME "/input0";
	input->id.bustype = BUS_HOST;

	platform_set_drvdata(pdev, priv);

	/* Configure each button */
	for (i = 0; i < nbuttons; i++) {
		struct gpio_button *btn = &priv->buttons[i];
		u32 code;

		btn->priv = priv;

		/* Acquire GPIO descriptor — direction INPUT, polarity from DT */
		btn->gpiod = devm_gpiod_get_index(dev, NULL, i, GPIOD_IN);
		if (IS_ERR(btn->gpiod)) {
			dev_err(dev, "failed to get GPIO %u: %ld\n", i,
				PTR_ERR(btn->gpiod));
			return PTR_ERR(btn->gpiod);
		}

		/* Read event code from DT linux,code array, default BTN_0+i */
		ret = device_property_read_u32_array(dev, "linux,code", &code,
						     1);
		if (ret || i > 0) {
			/*
			 * Single-element or multi-button: read per-button code.
			 * For multi-button DTs the property is an array; for
			 * simplicity we read element [i] via the raw OF API.
			 * Fall back to BTN_0+i if not found.
			 */
			struct property *prop;
			const __be32 *val;

			prop = of_find_property(dev->of_node, "linux,code",
						NULL);
			if (prop && i < prop->length / sizeof(__be32)) {
				val = (__be32 *)prop->value + i;
				btn->code = be32_to_cpup(val);
			} else {
				btn->code = GPIO_INPUTS_DEFAULT_KEY + i;
			}
		} else {
			btn->code = code;
		}

		/* Register EV_KEY capability */
		input_set_capability(input, EV_KEY, btn->code);

		/* Try hardware debounce first */
		ret = gpiod_set_debounce(btn->gpiod,
					 GPIO_INPUTS_DEBOUNCE_MS * 1000);
		if (ret == -ENOTSUPP) {
			/*
			 * Hardware debounce not available — initialise
			 * delayed_work for software fallback.  The IRQ thread
			 * detects this by checking the work function pointer.
			 */
			dev_dbg(dev,
				"button%u: hw debounce not supported, using sw (%d ms)\n",
				i, GPIO_INPUTS_DEBOUNCE_MS);
			INIT_DELAYED_WORK(&btn->debounce,
					  gpio_inputs_debounce_work);
		} else if (ret) {
			dev_warn(dev,
				 "button%u: gpiod_set_debounce() failed: %d\n",
				 i, ret);
		}

		/* Get IRQ number from GPIO descriptor */
		ret = gpiod_to_irq(btn->gpiod);
		if (ret < 0) {
			dev_err(dev, "button%u: gpiod_to_irq() failed: %d\n", i,
				ret);
			return ret;
		}
		btn->irq = (unsigned int)ret;

		/*
		 * Request threaded IRQ:
		 *   top-half: returns IRQ_WAKE_THREAD (no GPIO read here)
		 *   thread:   reads GPIO and reports event
		 *   IRQF_TRIGGER_RISING|FALLING: catch both press and release edges
		 *   IRQF_ONESHOT: thread runs with IRQ masked (required)
		 */
		ret = devm_request_threaded_irq(dev, btn->irq,
						gpio_inputs_irq_handler,
						gpio_inputs_irq_thread,
						IRQF_TRIGGER_RISING |
						IRQF_TRIGGER_FALLING |
						IRQF_ONESHOT,
						DRIVER_NAME, btn);
		if (ret) {
			dev_err(dev, "button%u: failed to request IRQ %u: %d\n",
				i, btn->irq, ret);
			return ret;
		}

		dev_dbg(dev, "button%u: GPIO irq=%u code=%u\n", i, btn->irq,
			btn->code);
	}

	/*
	 * Register input device with the input core.
	 * For devm_input_allocate_device() devices, devres automatically
	 * calls input_unregister_device() on driver removal.
	 */
	ret = input_register_device(input);
	if (ret) {
		dev_err(dev, "failed to register input device: %d\n", ret);
		return ret;
	}

	dev_info(dev, "%s v%s: probed %u button(s), input=%s\n", DRIVER_NAME,
		 DRIVER_VERSION, nbuttons, input->name);

	return 0;
}

/**
 * gpio_inputs_remove() - Platform driver remove
 * @pdev: platform device being unbound
 *
 * All resources were allocated with devm_* — the kernel frees them
 * automatically via devres.  Cancel any pending debounce work manually
 * since delayed_work is not a devm resource.
 */
static void gpio_inputs_remove(struct platform_device *pdev)
{
	struct gpio_inputs_priv *priv = platform_get_drvdata(pdev);
	unsigned int i;

	for (i = 0; i < priv->nbuttons; i++) {
		struct gpio_button *btn = &priv->buttons[i];

		if (btn->debounce.work.func == gpio_inputs_debounce_work)
			cancel_delayed_work_sync(&btn->debounce);
	}

	dev_info(&pdev->dev, "driver removed\n");
}

/* ================================================================
 * Power Management
 * ================================================================
 */

/**
 * gpio_inputs_suspend() - System suspend handler
 * @dev: device pointer
 *
 * Cancel any pending debounce work then disable IRQs to prevent
 * spurious wakeups from floating GPIO lines during system sleep.
 *
 * Return: 0 always
 */
static int gpio_inputs_suspend(struct device *dev)
{
	struct gpio_inputs_priv *priv = dev_get_drvdata(dev);
	unsigned int i;

	for (i = 0; i < priv->nbuttons; i++) {
		struct gpio_button *btn = &priv->buttons[i];

		if (btn->debounce.work.func == gpio_inputs_debounce_work)
			cancel_delayed_work_sync(&btn->debounce);

		disable_irq(btn->irq);
	}

	return 0;
}

/**
 * gpio_inputs_resume() - System resume handler
 * @dev: device pointer
 *
 * Re-enables IRQs and re-reads current GPIO state to catch any button
 * state changes that occurred during suspend.
 *
 * Return: 0 always
 */
static int gpio_inputs_resume(struct device *dev)
{
	struct gpio_inputs_priv *priv = dev_get_drvdata(dev);
	unsigned int i;

	for (i = 0; i < priv->nbuttons; i++) {
		struct gpio_button *btn = &priv->buttons[i];

		/* Report current state in case it changed during sleep */
		gpio_inputs_report(btn);

		enable_irq(btn->irq);
	}

	return 0;
}

static DEFINE_SIMPLE_DEV_PM_OPS(gpio_inputs_pm_ops, gpio_inputs_suspend,
				gpio_inputs_resume);

/* ================================================================
 * Platform Driver Registration
 * ================================================================
 */

static const struct of_device_id gpio_inputs_of_match[] = {
	{ .compatible = "bos,gpio-inputs" },
	{}
};
MODULE_DEVICE_TABLE(of, gpio_inputs_of_match);

static struct platform_driver gpio_inputs_driver = {
	.probe  = gpio_inputs_probe,
	.remove = gpio_inputs_remove,
	.driver = {
		.name           = DRIVER_NAME,
		.of_match_table = gpio_inputs_of_match,
		.pm             = pm_sleep_ptr(&gpio_inputs_pm_ops),
	},
};
module_platform_driver(gpio_inputs_driver);

MODULE_AUTHOR("nhat092005");
MODULE_DESCRIPTION("GPIO Inputs Driver — Linux Input Subsystem");
MODULE_LICENSE("GPL");
MODULE_VERSION(DRIVER_VERSION);
