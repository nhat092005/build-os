// SPDX-License-Identifier: GPL-2.0-or-later
/*
 * GPIO LED Character Device Driver
 *
 * Provides a character device interface to control a GPIO pin as an LED.
 * GPIO configuration is sourced entirely from the Device Tree via the
 * `gpios` property of the matching DTS node — no board-file lookup table.
 * Bind by loading the gpio-chardev.dtbo overlay before insmod.
 */

#include <linux/module.h>
#include <linux/kernel.h>
#include <linux/init.h>
#include <linux/fs.h>
#include <linux/cdev.h>
#include <linux/device.h>
#include <linux/gpio/consumer.h>
#include <linux/of.h>
#include <linux/platform_device.h>
#include <linux/uaccess.h>
#include <linux/mutex.h>
#include <linux/slab.h>
#include <linux/delay.h>
#include <linux/workqueue.h>

#include "../include/gpio_chardev.h"

/* Module-level class — created once at module load, destroyed at module exit */
static struct class *gpio_chardev_class;

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
	struct gpio_chardev_dev *dev =
		container_of(work, struct gpio_chardev_dev, blink_work.work);
	__u32 delay_ms;

	mutex_lock(&dev->lock);

	if (!dev->blink_active) {
		mutex_unlock(&dev->lock);
		return;
	}

	if (dev->blink_phase == 0) {
		/* Off -> On transition */
		gpiod_set_value(dev->gpio_desc, 1);
		dev->blink_phase = 1;
		delay_ms = dev->blink_delay_on;
	} else {
		/* On -> Off transition */
		gpiod_set_value(dev->gpio_desc, 0);
		dev->blink_phase = 0;
		dev->blink_count++;

		/* Check if we reached the target count */
		if (dev->blink_total != 0 &&
		    dev->blink_count >= dev->blink_total) {
			dev->blink_active = false;
			mutex_unlock(&dev->lock);
			return;
		}
		delay_ms = dev->blink_delay_off;
	}

	mutex_unlock(&dev->lock);

	schedule_delayed_work(&dev->blink_work, msecs_to_jiffies(delay_ms));
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

	switch (cmd) {
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
		if (ret < 0) {
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
	.llseek = noop_llseek,
};

static const struct of_device_id gpio_chardev_of_match[] = {
	{ .compatible = "gpio-chardev" },
	{}
};
MODULE_DEVICE_TABLE(of, gpio_chardev_of_match);

/**
 * gpio_chardev_probe - Bind driver to a DT node, set up chardev + GPIO
 * @pdev: platform device provided by the OF core
 *
 * Acquires the GPIO described by the `gpios` property of the DT node,
 * allocates a character device, and makes /dev/gpio-chardev available.
 *
 * Returns 0 on success, negative error code on failure.
 */
static int gpio_chardev_probe(struct platform_device *pdev)
{
	struct gpio_chardev_dev *priv;
	int ret;

	priv = devm_kzalloc(&pdev->dev, sizeof(*priv), GFP_KERNEL);
	if (!priv)
		return -ENOMEM;

	ret = devm_mutex_init(&pdev->dev, &priv->lock);
	if (ret)
		return ret;
	INIT_DELAYED_WORK(&priv->blink_work, gpio_chardev_blink_work_fn);
	priv->blink_active = false;

	/*
	 * Acquire the GPIO from the DT `gpios` property (NULL con_id).
	 * Initial state OUT_LOW keeps the LED off until explicitly enabled.
	 */
	priv->gpio_desc = devm_gpiod_get(&pdev->dev, NULL, GPIOD_OUT_LOW);
	if (IS_ERR(priv->gpio_desc))
		return dev_err_probe(&pdev->dev, PTR_ERR(priv->gpio_desc),
				     "failed to get GPIO\n");

	/*
	 * Populate gpio_pin for the GPIO_CHARDEV_IOC_GET_GPIO ioctl so that
	 * userspace can discover which hardware pin is in use.
	 */
	priv->gpio_pin = desc_to_gpio(priv->gpio_desc);

	ret = alloc_chrdev_region(&priv->dev_num, 0, 1,
				  GPIO_CHARDEV_DRIVER_NAME);
	if (ret < 0) {
		dev_err(&pdev->dev, "failed to allocate chrdev region: %d\n",
			ret);
		return ret;
	}

	cdev_init(&priv->cdev, &gpio_chardev_fops);
	priv->cdev.owner = THIS_MODULE;

	/* Initialise the embedded device and link it to the class */
	device_initialize(&priv->dev);
	priv->dev.devt = priv->dev_num;
	priv->dev.class = gpio_chardev_class;
	priv->dev.parent = &pdev->dev;
	dev_set_name(&priv->dev, GPIO_CHARDEV_DRIVER_NAME);

	/* Atomic cdev + sysfs device creation — avoids race between add steps */
	ret = cdev_device_add(&priv->cdev, &priv->dev);
	if (ret < 0) {
		dev_err(&pdev->dev, "cdev_device_add failed: %d\n", ret);
		goto err_unregister_chrdev;
	}

	platform_set_drvdata(pdev, priv);

	dev_info(&pdev->dev, "device /dev/%s created (GPIO%d)\n",
		 GPIO_CHARDEV_DRIVER_NAME, priv->gpio_pin);

	return 0;

err_unregister_chrdev:
	put_device(&priv->dev);
	unregister_chrdev_region(priv->dev_num, 1);
	return ret;
}

/**
 * gpio_chardev_remove - Tear down character device and release GPIO
 * @pdev: platform device being unbound
 *
 * Stops any in-flight blink work, turns off the LED, then destroys
 * the character device.  GPIO is released automatically by devres.
 */
static void gpio_chardev_remove(struct platform_device *pdev)
{
	struct gpio_chardev_dev *priv = platform_get_drvdata(pdev);

	/* Stop blink — set flag under lock to prevent a new reschedule */
	mutex_lock(&priv->lock);
	priv->blink_active = false;
	mutex_unlock(&priv->lock);
	cancel_delayed_work_sync(&priv->blink_work);

	/* Turn LED off under lock to serialise with in-flight file_ops */
	mutex_lock(&priv->lock);
	gpiod_set_value(priv->gpio_desc, 0);
	mutex_unlock(&priv->lock);

	cdev_device_del(&priv->cdev, &priv->dev);
	put_device(&priv->dev);
	unregister_chrdev_region(priv->dev_num, 1);

	dev_info(&pdev->dev, "driver removed\n");
}

static struct platform_driver gpio_chardev_driver = {
	.probe = gpio_chardev_probe,
	.remove = gpio_chardev_remove,
	.driver = {
		.name = GPIO_CHARDEV_DRIVER_NAME,
		.of_match_table = gpio_chardev_of_match,
	},
};

static int __init gpio_chardev_init(void)
{
	gpio_chardev_class = class_create(GPIO_CHARDEV_CLASS_NAME);
	if (IS_ERR(gpio_chardev_class))
		return PTR_ERR(gpio_chardev_class);

	return platform_driver_register(&gpio_chardev_driver);
}

static void __exit gpio_chardev_exit(void)
{
	platform_driver_unregister(&gpio_chardev_driver);
	class_destroy(gpio_chardev_class);
}

module_init(gpio_chardev_init);
module_exit(gpio_chardev_exit);

MODULE_AUTHOR("nhat092005");
MODULE_DESCRIPTION("GPIO LED Character Device Driver");
MODULE_LICENSE("GPL");
MODULE_VERSION(GPIO_CHARDEV_DRIVER_VERSION);
