/* SPDX-License-Identifier: GPL-2.0-or-later */
/*
 * GPIO LED Character Device Driver
 *
 * This driver provides a character device interface to control a GPIO pin as an LED.
 * It supports basic operations like turning the LED on/off, toggling its state,
 * and blinking it with configurable parameters. The driver uses a platform device
 * to manage GPIO access and a delayed workqueue for blinking functionality.
 */

#include <linux/module.h>
#include <linux/kernel.h>
#include <linux/init.h>
#include <linux/fs.h>
#include <linux/cdev.h>
#include <linux/device.h>
#include <linux/gpio/consumer.h>
#include <linux/gpio/machine.h>
#include <linux/platform_device.h>
#include <linux/uaccess.h>
#include <linux/mutex.h>
#include <linux/slab.h>
#include <linux/delay.h>
#include <linux/workqueue.h>

#include "../include/gpio-chardev.h"

/* Module parameters */
static int gpio_pin = GPIO_CHARDEV_DEFAULT_PIN;
module_param(gpio_pin, int, 0444);
MODULE_PARM_DESC(gpio_pin, "GPIO pin number");

/* Device structure */
static struct gpio_chardev_dev *gpio_chardev_device;

/* Platform device for GPIO access */
static struct platform_device *gpio_pdev;
static struct gpiod_lookup_table *gpio_lookup_table;

/**
 * gpio_chardev_blink_work_fn - Delayed work function for blinking LED
 * @work: Pointer to delayed_work embedded in gpio_chardev_dev
 *
 * Alternates LED state between on and off phases, rescheduling itself
 * until the requested blink count is reached.  Runs on the system
 * workqueue — no kthread lifecycle management needed.
 */
static void gpio_chardev_blink_work_fn(struct work_struct *work)
{
	struct gpio_chardev_dev *dev = container_of(work,
												struct gpio_chardev_dev,
												blink_work.work);
	__u32 delay_ms;

	mutex_lock(&dev->lock);

	if (!dev->blink_active)
	{
		mutex_unlock(&dev->lock);
		return;
	}

	if (dev->blink_phase == 0)
	{
		/* Off -> On transition */
		gpiod_set_value(dev->gpio_desc, 1);
		dev->blink_phase = 1;
		delay_ms = dev->blink_delay_on;
	}
	else
	{
		/* On -> Off transition */
		gpiod_set_value(dev->gpio_desc, 0);
		dev->blink_phase = 0;
		dev->blink_count++;

		/* Check if we reached the target count */
		if (dev->blink_total != 0 &&
			dev->blink_count >= dev->blink_total)
		{
			dev->blink_active = false;
			mutex_unlock(&dev->lock);
			return;
		}
		delay_ms = dev->blink_delay_off;
	}

	mutex_unlock(&dev->lock);

	schedule_delayed_work(&dev->blink_work,
						  msecs_to_jiffies(delay_ms));
}

/**
 * gpio_chardev_open - Open function for GPIO LED device
 * @inode: Pointer to inode structure
 * @filp: Pointer to file structure
 * Return: 0 on success
 */
static int gpio_chardev_open(struct inode *inode, struct file *filp)
{
	struct gpio_chardev_dev *dev;

	dev = container_of(inode->i_cdev, struct gpio_chardev_dev, cdev);
	filp->private_data = dev;
	return 0;
}

/**
 * gpio_chardev_release - Release function for GPIO LED device
 * @inode: Pointer to inode structure
 * @filp: Pointer to file structure
 * Return: 0 on success
 */
static int gpio_chardev_release(struct inode *inode, struct file *filp)
{
	return 0;
}

/**
 * gpio_chardev_read - Read function for GPIO LED device
 * @filp: Pointer to file structure
 * @buf: User buffer to store read data
 * @count: Number of bytes to read
 * @f_pos: File position pointer
 * Return: Number of bytes read or negative error code
 */
static ssize_t gpio_chardev_read(struct file *filp, char __user *buf,
								 size_t count, loff_t *f_pos)
{
	struct gpio_chardev_dev *dev = filp->private_data;
	char kbuf[GPIO_CHARDEV_MAX_BUFFER];
	int len, value;

	if (*f_pos > 0)
		return 0;

	if (mutex_lock_interruptible(&dev->lock))
		return -ERESTARTSYS;
	value = gpiod_get_value(dev->gpio_desc);
	mutex_unlock(&dev->lock);

	if (value < 0)
		return value;

	len = scnprintf(kbuf, sizeof(kbuf), "%d\n", value);
	if (len > count)
		len = count;

	if (copy_to_user(buf, kbuf, len))
		return -EFAULT;

	*f_pos += len;
	return len;
}

/**
 * gpio_chardev_write - Write function for GPIO LED device
 * @filp: Pointer to file structure
 * @buf: User buffer containing data to write
 * @count: Number of bytes to write
 * @f_pos: File position pointer
 * Return: Number of bytes written or negative error code
 */
static ssize_t gpio_chardev_write(struct file *filp, const char __user *buf,
								  size_t count, loff_t *f_pos)
{
	struct gpio_chardev_dev *dev = filp->private_data;
	char kbuf[GPIO_CHARDEV_MAX_BUFFER];
	int value;
	size_t len;

	if (count == 0)
		return 0;

	len = min(count, sizeof(kbuf) - 1);
	if (copy_from_user(kbuf, buf, len))
		return -EFAULT;

	kbuf[len] = '\0';

	/* Parse input accept 0 or 1 */
	if (kstrtoint(kbuf, 10, &value))
		return -EINVAL;

	if (value != 0 && value != 1)
		return -EINVAL;

	if (mutex_lock_interruptible(&dev->lock))
		return -ERESTARTSYS;
	gpiod_set_value(dev->gpio_desc, value);
	mutex_unlock(&dev->lock);

	return count;
}

/**
 * gpio_chardev_ioctl - IOCTL function for GPIO LED device
 * @filp: Pointer to file structure
 * @cmd: IOCTL command
 * @arg: IOCTL argument
 * Return: 0 on success or negative error code
 */
static long gpio_chardev_ioctl(struct file *filp, unsigned int cmd,
							   unsigned long arg)
{
	struct gpio_chardev_dev *dev = filp->private_data;
	struct gpio_chardev_blink blink_params;
	__u32 value;
	int ret = 0;

	switch (cmd)
	{
	case GPIO_CHARDEV_IOC_SET_STATE:
		if (copy_from_user(&value, (__u32 __user *)arg, sizeof(value)))
			return -EFAULT;
		if (value != GPIO_CHARDEV_OFF && value != GPIO_CHARDEV_ON)
			return -EINVAL;
		if (mutex_lock_interruptible(&dev->lock))
			return -ERESTARTSYS;
		gpiod_set_value(dev->gpio_desc, value);
		mutex_unlock(&dev->lock);
		break;

	case GPIO_CHARDEV_IOC_GET_STATE:
		if (mutex_lock_interruptible(&dev->lock))
			return -ERESTARTSYS;
		ret = gpiod_get_value(dev->gpio_desc);
		mutex_unlock(&dev->lock);
		if (ret < 0)
			return ret;
		value = ret;
		if (copy_to_user((__u32 __user *)arg, &value, sizeof(value)))
			return -EFAULT;
		break;

	case GPIO_CHARDEV_IOC_TOGGLE:
		if (mutex_lock_interruptible(&dev->lock))
			return -ERESTARTSYS;
		ret = gpiod_get_value(dev->gpio_desc);
		if (ret < 0)
		{
			mutex_unlock(&dev->lock);
			return ret;
		}
		gpiod_set_value(dev->gpio_desc, !ret);
		mutex_unlock(&dev->lock);
		break;

	case GPIO_CHARDEV_IOC_GET_GPIO:
		value = dev->gpio_pin;
		if (copy_to_user((__u32 __user *)arg, &value, sizeof(value)))
			return -EFAULT;
		break;

	case GPIO_CHARDEV_IOC_BLINK:
		if (copy_from_user(&blink_params,
						   (struct gpio_chardev_blink __user *)arg,
						   sizeof(blink_params)))
			return -EFAULT;

		if (blink_params.delay_on == 0 || blink_params.delay_off == 0)
			return -EINVAL;

		/*
		 * Cancel any ongoing blink work, then configure and
		 * start a new one.  cancel_delayed_work_sync() is
		 * safe to call even if no work is pending.
		 */
		cancel_delayed_work_sync(&dev->blink_work);

		if (mutex_lock_interruptible(&dev->lock))
			return -ERESTARTSYS;
		dev->blink_delay_on = blink_params.delay_on;
		dev->blink_delay_off = blink_params.delay_off;
		dev->blink_total = blink_params.count;
		dev->blink_count = 0;
		dev->blink_phase = 0;
		dev->blink_active = true;
		mutex_unlock(&dev->lock);

		/* Kick the first iteration immediately */
		schedule_delayed_work(&dev->blink_work, 0);
		break;

	default:
		return -ENOTTY;
	}

	return ret;
}

/* File operations structure */
static const struct file_operations gpio_chardev_fops = {
	.owner = THIS_MODULE,
	.open = gpio_chardev_open,
	.release = gpio_chardev_release,
	.read = gpio_chardev_read,
	.write = gpio_chardev_write,
	.unlocked_ioctl = gpio_chardev_ioctl,
};

/**
 * gpio_chardev_init - Module initialization function
 */
static int __init gpio_chardev_init(void)
{
	struct gpio_chardev_dev *dev;
	int ret;

	pr_info("%s: Initializing driver v%s\n",
			GPIO_CHARDEV_DRIVER_NAME, GPIO_CHARDEV_DRIVER_VERSION);

	dev = kzalloc(sizeof(*dev), GFP_KERNEL);
	if (!dev)
		return -ENOMEM;

	gpio_chardev_device = dev;
	dev->gpio_pin = gpio_pin;
	mutex_init(&dev->lock);
	INIT_DELAYED_WORK(&dev->blink_work, gpio_chardev_blink_work_fn);
	dev->blink_active = false;

	/* Create GPIO lookup table dynamically */
	gpio_lookup_table = kzalloc(sizeof(*gpio_lookup_table) +
									2 * sizeof(struct gpiod_lookup),
								GFP_KERNEL);
	if (!gpio_lookup_table)
	{
		ret = -ENOMEM;
		goto err_free_dev;
	}

	gpio_lookup_table->dev_id = "gpio-led-pdev";
	gpio_lookup_table->table[0].key = "pinctrl-bcm2711";
	gpio_lookup_table->table[0].chip_hwnum = dev->gpio_pin;
	gpio_lookup_table->table[0].con_id = "led";
	gpio_lookup_table->table[0].flags = GPIO_ACTIVE_HIGH;

	/* Register lookup table */
	gpiod_add_lookup_table(gpio_lookup_table);

	/* Create platform device */
	gpio_pdev = platform_device_register_simple("gpio-led-pdev", -1, NULL, 0);
	if (IS_ERR(gpio_pdev))
	{
		ret = PTR_ERR(gpio_pdev);
		pr_err("%s: Failed to register platform device: %d\n",
			   GPIO_CHARDEV_DRIVER_NAME, ret);
		gpio_pdev = NULL;
		goto err_remove_lookup;
	}

	/* Request GPIO through platform device */
	dev->gpio_desc = devm_gpiod_get(&gpio_pdev->dev, "led", GPIOD_OUT_LOW);
	if (IS_ERR(dev->gpio_desc))
	{
		ret = PTR_ERR(dev->gpio_desc);
		pr_err("%s: Failed to get GPIO%d: %d\n",
			   GPIO_CHARDEV_DRIVER_NAME, dev->gpio_pin, ret);
		dev->gpio_desc = NULL;
		goto err_unregister_pdev;
	}
	dev->gpio_requested = true;

	pr_info("%s: Successfully configured GPIO%d\n",
			GPIO_CHARDEV_DRIVER_NAME, dev->gpio_pin);

	/* Allocate character device region */
	ret = alloc_chrdev_region(&dev->dev_num, 0, 1, GPIO_CHARDEV_DRIVER_NAME);
	if (ret < 0)
	{
		pr_err("%s: Failed to allocate chrdev region: %d\n",
			   GPIO_CHARDEV_DRIVER_NAME, ret);
		goto err_unregister_pdev;
	}

	/* Initialize and add character device */
	cdev_init(&dev->cdev, &gpio_chardev_fops);
	dev->cdev.owner = THIS_MODULE;

	ret = cdev_add(&dev->cdev, dev->dev_num, 1);
	if (ret < 0)
	{
		pr_err("%s: Failed to add cdev: %d\n",
			   GPIO_CHARDEV_DRIVER_NAME, ret);
		goto err_unregister_chrdev;
	}

	/* Create device class */
	dev->class = class_create(GPIO_CHARDEV_CLASS_NAME);
	if (IS_ERR(dev->class))
	{
		ret = PTR_ERR(dev->class);
		pr_err("%s: Failed to create class: %d\n",
			   GPIO_CHARDEV_DRIVER_NAME, ret);
		goto err_del_cdev;
	}

	/* Create device */
	dev->device = device_create(dev->class, NULL, dev->dev_num,
								NULL, GPIO_CHARDEV_DRIVER_NAME);
	if (IS_ERR(dev->device))
	{
		ret = PTR_ERR(dev->device);
		pr_err("%s: Failed to create device: %d\n",
			   GPIO_CHARDEV_DRIVER_NAME, ret);
		goto err_destroy_class;
	}

	pr_info("%s: Device /dev/%s created (GPIO%d)\n",
			GPIO_CHARDEV_DRIVER_NAME, GPIO_CHARDEV_DRIVER_NAME, dev->gpio_pin);

	return 0;

err_destroy_class:
	class_destroy(dev->class);
err_del_cdev:
	cdev_del(&dev->cdev);
err_unregister_chrdev:
	unregister_chrdev_region(dev->dev_num, 1);
err_unregister_pdev:
	if (gpio_pdev)
		platform_device_unregister(gpio_pdev);
err_remove_lookup:
	if (gpio_lookup_table)
	{
		gpiod_remove_lookup_table(gpio_lookup_table);
		kfree(gpio_lookup_table);
	}
err_free_dev:
	kfree(dev);
	gpio_chardev_device = NULL;
	return ret;
}

/**
 * gpio_chardev_exit - Module exit function
 */
static void __exit gpio_chardev_exit(void)
{
	struct gpio_chardev_dev *dev = gpio_chardev_device;

	if (!dev)
		return;

	/* Stop any pending blink work — set flag under lock to avoid data race */
	mutex_lock(&dev->lock);
	dev->blink_active = false;
	mutex_unlock(&dev->lock);
	cancel_delayed_work_sync(&dev->blink_work);

	/* Turn off LED under lock to serialise with in-flight file_ops */
	mutex_lock(&dev->lock);
	if (dev->gpio_requested && dev->gpio_desc)
		gpiod_set_value(dev->gpio_desc, 0);
	mutex_unlock(&dev->lock);

	/* Destroy device and class */
	if (dev->device && !IS_ERR(dev->device))
		device_destroy(dev->class, dev->dev_num);

	if (dev->class && !IS_ERR(dev->class))
		class_destroy(dev->class);

	/* Remove character device */
	if (dev->dev_num)
	{
		cdev_del(&dev->cdev);
		unregister_chrdev_region(dev->dev_num, 1);
	}

	/* Unregister platform device */
	if (gpio_pdev)
	{
		platform_device_unregister(gpio_pdev);
		gpio_pdev = NULL;
	}

	/* Remove GPIO lookup table */
	if (gpio_lookup_table)
	{
		gpiod_remove_lookup_table(gpio_lookup_table);
		kfree(gpio_lookup_table);
		gpio_lookup_table = NULL;
	}

	/* Free device structure (mutex_destroy before kfree) */
	mutex_destroy(&dev->lock);
	kfree(dev);
	gpio_chardev_device = NULL;

	pr_info("%s: Driver removed\n", GPIO_CHARDEV_DRIVER_NAME);
}

module_init(gpio_chardev_init);
module_exit(gpio_chardev_exit);

MODULE_AUTHOR("nhat092005");
MODULE_DESCRIPTION("GPIO LED Character Device Driver");
MODULE_LICENSE("GPL");
MODULE_VERSION(GPIO_CHARDEV_DRIVER_VERSION);