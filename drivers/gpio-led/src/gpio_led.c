/* SPDX-License-Identifier: GPL-2.0-or-later */
/*
 * GPIO LED Character Device Driver
 *
 * Author: nhat092005
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
#include <linux/kthread.h>

#include "../include/gpio_led.h"

/* Module parameters */
static int gpio_pin = GPIO_LED_DEFAULT_PIN;
module_param(gpio_pin, int, 0444);
MODULE_PARM_DESC(gpio_pin, "GPIO pin number");

static struct gpio_led_dev *gpio_led_device;
static struct task_struct *blink_thread;
static atomic_t blink_stop;

/* Platform device for GPIO access */
static struct platform_device *gpio_pdev;
static struct gpiod_lookup_table *gpio_lookup_table;

/**
 * gpio_led_parse_value - Parse input string to get LED value
 * @buf: Input buffer
 * @len: Length of input buffer
 * @value: Pointer to store parsed value (0 or 1)
 * Return 0 on success, -EINVAL on failure
 */
static int gpio_led_parse_value(const char *buf, size_t len, int *value)
{
	char tmp[GPIO_LED_MAX_BUFFER];
	int ret;

	if (len >= GPIO_LED_MAX_BUFFER)
		return -EINVAL;

	memcpy(tmp, buf, len);
	tmp[len] = '\0';

	ret = kstrtoint(tmp, 10, value);
	if (ret == 0)
	{
		if (*value != 0 && *value != 1)
			return -EINVAL;
		return 0;
	}

	if (strncasecmp(tmp, "on", 2) == 0)
	{
		*value = 1;
		return 0;
	}
	else if (strncasecmp(tmp, "off", 3) == 0)
	{
		*value = 0;
		return 0;
	}

	return -EINVAL;
}

/**
 * gpio_led_blink_fn - Kernel thread function for blinking LED
 * @data: Pointer to gpio_led_blink structure
 * Return: 0 on thread exit
 */
static int gpio_led_blink_fn(void *data)
{
	struct gpio_led_blink *blink = data;
	struct gpio_led_dev *dev = gpio_led_device;
	__u32 count = 0;

	while (!kthread_should_stop() && !atomic_read(&blink_stop))
	{
		if (blink->count != 0 && count >= blink->count)
			break;

		mutex_lock(&dev->lock);
		gpiod_set_value(dev->gpio_desc, 1);
		dev->state = 1;
		mutex_unlock(&dev->lock);
		msleep(blink->delay_on);

		if (kthread_should_stop() || atomic_read(&blink_stop))
			break;

		mutex_lock(&dev->lock);
		gpiod_set_value(dev->gpio_desc, 0);
		dev->state = 0;
		mutex_unlock(&dev->lock);
		msleep(blink->delay_off);

		count++;
	}

	mutex_lock(&dev->lock);
	gpiod_set_value(dev->gpio_desc, 0);
	dev->state = 0;
	mutex_unlock(&dev->lock);

	kfree(blink);
	return 0;
}

/**
 * gpio_led_open - Open function for GPIO LED device
 * @inode: Pointer to inode structure
 * @filp: Pointer to file structure
 * Return: 0 on success
 */
static int gpio_led_open(struct inode *inode, struct file *filp)
{
	struct gpio_led_dev *dev;

	dev = container_of(inode->i_cdev, struct gpio_led_dev, cdev);
	filp->private_data = dev;
	return 0;
}

/**
 * gpio_led_release - Release function for GPIO LED device
 * @inode: Pointer to inode structure
 * @filp: Pointer to file structure
 * Return: 0 on success
 */
static int gpio_led_release(struct inode *inode, struct file *filp)
{
	return 0;
}

/**
 * gpio_led_read - Read function for GPIO LED device
 * @filp: Pointer to file structure
 * @buf: User buffer to store read data
 * @count: Number of bytes to read
 * @f_pos: File position pointer
 * Return: Number of bytes read on success, negative error code on failure
 */
static ssize_t gpio_led_read(struct file *filp, char __user *buf,
							 size_t count, loff_t *f_pos)
{
	struct gpio_led_dev *dev = filp->private_data;
	char kbuf[GPIO_LED_MAX_BUFFER];
	int len, ret;

	if (*f_pos > 0)
		return 0;

	mutex_lock(&dev->lock);
	dev->state = gpiod_get_value(dev->gpio_desc);
	len = scnprintf(kbuf, sizeof(kbuf), "%d\n", dev->state);
	mutex_unlock(&dev->lock);

	if (len > count)
		len = count;

	ret = copy_to_user(buf, kbuf, len);

	*f_pos += len;
	return len;
}

/**
 * gpio_led_write - Write function for GPIO LED device
 * @filp: Pointer to file structure
 * @buf: User buffer containing data to write
 * @count: Number of bytes to write
 * @f_pos: File position pointer
 * Return: Number of bytes written on success, negative error code on failure
 */
static ssize_t gpio_led_write(struct file *filp, const char __user *buf,
							  size_t count, loff_t *f_pos)
{
	struct gpio_led_dev *dev = filp->private_data;
	char kbuf[GPIO_LED_MAX_BUFFER];
	ssize_t len;
	int value, ret;

	if (count == 0)
		return 0;

	len = min(count, sizeof(kbuf) - 1);
	ret = copy_from_user(kbuf, buf, len);

	kbuf[len] = '\0';

	ret = gpio_led_parse_value(kbuf, len, &value);

	mutex_lock(&dev->lock);
	gpiod_set_value(dev->gpio_desc, value);
	dev->state = value;
	mutex_unlock(&dev->lock);

	return count;
}

/**
 * gpio_led_ioctl - IOCTL function for GPIO LED device
 * @filp: Pointer to file structure
 * @cmd: IOCTL command
 * @arg: Argument for IOCTL command
 * Return: 0 on success, negative error code on failure
 */
static long gpio_led_ioctl(struct file *filp, unsigned int cmd,
						   unsigned long arg)
{
	struct gpio_led_dev *dev = filp->private_data;
	struct gpio_led_blink *blink;
	__u32 value;
	int ret = 0;

	switch (cmd)
	{
	case GPIO_LED_IOC_SET_STATE:
		if (copy_from_user(&value, (__u32 __user *)arg, sizeof(value)))
			return -EFAULT;
		if (value != GPIO_LED_OFF && value != GPIO_LED_ON)
			return -EINVAL;
		mutex_lock(&dev->lock);
		gpiod_set_value(dev->gpio_desc, value);
		dev->state = value;
		mutex_unlock(&dev->lock);
		break;

	case GPIO_LED_IOC_GET_STATE:
		mutex_lock(&dev->lock);
		value = gpiod_get_value(dev->gpio_desc);
		dev->state = value;
		mutex_unlock(&dev->lock);
		if (copy_to_user((__u32 __user *)arg, &value, sizeof(value)))
			return -EFAULT;
		break;

	case GPIO_LED_IOC_TOGGLE:
		mutex_lock(&dev->lock);
		dev->state = !gpiod_get_value(dev->gpio_desc);
		gpiod_set_value(dev->gpio_desc, dev->state);
		mutex_unlock(&dev->lock);
		break;

	case GPIO_LED_IOC_GET_GPIO:
		value = dev->gpio_pin;
		if (copy_to_user((__u32 __user *)arg, &value, sizeof(value)))
			return -EFAULT;
		break;

	case GPIO_LED_IOC_BLINK:
		if (blink_thread)
		{
			atomic_set(&blink_stop, 1);
			kthread_stop(blink_thread);
			blink_thread = NULL;
		}
		blink = kmalloc(sizeof(*blink), GFP_KERNEL);
		if (!blink)
			return -ENOMEM;
		if (copy_from_user(blink, (struct gpio_led_blink __user *)arg,
						   sizeof(*blink)))
		{
			kfree(blink);
			return -EFAULT;
		}
		if (blink->delay_on == 0 || blink->delay_off == 0)
		{
			kfree(blink);
			return -EINVAL;
		}
		atomic_set(&blink_stop, 0);
		blink_thread = kthread_run(gpio_led_blink_fn, blink,
								   "gpio_led_blink");
		if (IS_ERR(blink_thread))
		{
			ret = PTR_ERR(blink_thread);
			blink_thread = NULL;
			kfree(blink);
			return ret;
		}
		break;

	default:
		return -ENOTTY;
	}

	return ret;
}

/* File operations structure */
static const struct file_operations gpio_led_fops = {
	.owner = THIS_MODULE,
	.open = gpio_led_open,
	.release = gpio_led_release,
	.read = gpio_led_read,
	.write = gpio_led_write,
	.unlocked_ioctl = gpio_led_ioctl,
};

/**
 * gpio_led_cleanup - Cleanup function for GPIO LED device
 * @dev: Pointer to gpio_led_dev structure
 */
static void gpio_led_cleanup(struct gpio_led_dev *dev)
{
	if (!dev)
		return;

	if (blink_thread)
	{
		atomic_set(&blink_stop, 1);
		kthread_stop(blink_thread);
		blink_thread = NULL;
	}

	if (dev->gpio_requested)
		gpiod_set_value(dev->gpio_desc, 0);

	if (dev->device && !IS_ERR(dev->device))
		device_destroy(dev->class, dev->dev_num);

	if (dev->class && !IS_ERR(dev->class))
		class_destroy(dev->class);

	if (dev->dev_num)
		cdev_del(&dev->cdev);

	if (dev->dev_num)
		unregister_chrdev_region(dev->dev_num, 1);

	if (dev->gpio_requested && dev->gpio_desc)
	{
		gpiod_put(dev->gpio_desc);
		dev->gpio_desc = NULL;
	}

	kfree(dev);
}

/**
 * gpio_led_init - Module initialization function
 * Return: 0 on success, negative error code on failure
 */
static int __init gpio_led_init(void)
{
	struct gpio_led_dev *dev;
	int ret;

	pr_info("%s: Initializing driver v%s\n",
			GPIO_LED_DRIVER_NAME, GPIO_LED_DRIVER_VERSION);

	dev = kzalloc(sizeof(*dev), GFP_KERNEL);
	if (!dev)
		return -ENOMEM;

	gpio_led_device = dev;
	dev->gpio_pin = gpio_pin;
	mutex_init(&dev->lock);
	atomic_set(&blink_stop, 0);

	/* Create GPIO lookup table dynamically */
	gpio_lookup_table = kzalloc(sizeof(*gpio_lookup_table) + 2 * sizeof(struct gpiod_lookup), GFP_KERNEL);
	if (!gpio_lookup_table)
	{
		ret = -ENOMEM;
		goto err_cleanup;
	}

	gpio_lookup_table->dev_id = "gpio-led-pdev";
	gpio_lookup_table->table[0].key = "pinctrl-bcm2711";
	gpio_lookup_table->table[0].chip_hwnum = dev->gpio_pin;
	gpio_lookup_table->table[0].con_id = "led";
	gpio_lookup_table->table[0].flags = GPIO_ACTIVE_HIGH;
	/* Try alternative chip name for older Pi models */
	if (!gpio_lookup_table->table[0].key)
	{
		gpio_lookup_table->table[0].key = "pinctrl-bcm2835";
	}

	/* Register lookup table */
	gpiod_add_lookup_table(gpio_lookup_table);

	/* Create platform device */
	gpio_pdev = platform_device_register_simple("gpio-led-pdev", -1, NULL, 0);
	if (IS_ERR(gpio_pdev))
	{
		ret = PTR_ERR(gpio_pdev);
		pr_err("%s: Failed to register platform device: %d\n",
			   GPIO_LED_DRIVER_NAME, ret);
		gpiod_remove_lookup_table(gpio_lookup_table);
		gpio_pdev = NULL;
		goto err_cleanup;
	}

	/* Request GPIO through platform device */
	dev->gpio_desc = devm_gpiod_get(&gpio_pdev->dev, "led", GPIOD_OUT_LOW);
	if (IS_ERR(dev->gpio_desc))
	{
		ret = PTR_ERR(dev->gpio_desc);
		pr_err("%s: Failed to get GPIO%d: %d\n",
			   GPIO_LED_DRIVER_NAME, dev->gpio_pin, ret);
		dev->gpio_desc = NULL;
		goto err_cleanup;
	}
	dev->gpio_requested = true;

	pr_info("%s: Successfully configured GPIO%d (using platform device)\n",
			GPIO_LED_DRIVER_NAME, dev->gpio_pin);

	ret = alloc_chrdev_region(&dev->dev_num, 0, 1, GPIO_LED_DRIVER_NAME);
	if (ret < 0)
		goto err_cleanup;

	cdev_init(&dev->cdev, &gpio_led_fops);
	dev->cdev.owner = THIS_MODULE;

	ret = cdev_add(&dev->cdev, dev->dev_num, 1);
	if (ret < 0)
		goto err_cleanup;

	dev->class = class_create(GPIO_LED_CLASS_NAME);
	if (IS_ERR(dev->class))
	{
		ret = PTR_ERR(dev->class);
		goto err_cleanup;
	}

	dev->device = device_create(dev->class, NULL, dev->dev_num,
								NULL, GPIO_LED_DRIVER_NAME);
	if (IS_ERR(dev->device))
	{
		ret = PTR_ERR(dev->device);
		goto err_cleanup;
	}

	pr_info("%s: Device /dev/%s created (GPIO%d)\n",
			GPIO_LED_DRIVER_NAME, GPIO_LED_DRIVER_NAME, dev->gpio_pin);

	return 0;

err_cleanup:
	gpio_led_cleanup(dev);
	gpio_led_device = NULL;
	return ret;
}

/**
 * gpio_led_exit - Module exit function
 */
static void __exit gpio_led_exit(void)
{
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

	gpio_led_cleanup(gpio_led_device);
	gpio_led_device = NULL;
	pr_info("%s: Driver removed\n", GPIO_LED_DRIVER_NAME);
}

module_init(gpio_led_init);
module_exit(gpio_led_exit);

MODULE_LICENSE("GPL");
MODULE_AUTHOR("nhat092005");
MODULE_DESCRIPTION("GPIO LED Character Device Driver");
MODULE_VERSION(GPIO_LED_DRIVER_VERSION);
