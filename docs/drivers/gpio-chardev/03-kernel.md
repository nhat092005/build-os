# Kernel Driver: GPIO Chardev

## Module Registration

```c
module_init(gpio_chardev_init);
module_exit(gpio_chardev_exit);
```

Init: `class_create("gpio-chardev")` → `platform_driver_register()`
Exit: `platform_driver_unregister()` → `class_destroy()`

**Driver ID table:**

```c
static const struct of_device_id gpio_chardev_of_match[] = {
	{ .compatible = "gpio-chardev" },
	{ }
};
```

## Private Data Structure

```c
struct gpio_chardev_dev {
	struct device *dev;
	struct gpio_desc *desc;
	struct cdev cdev;
	dev_t devno;
	struct mutex lock;
	struct delayed_work blink_work;
	bool blinking;
	u32 blink_count;
	u32 blink_remaining;
	u32 blink_delay_on;
	u32 blink_delay_off;
	bool blink_phase;
};
```

## probe()

1. `devm_gpiod_get(dev, NULL, GPIOD_OUT_LOW)` — acquire GPIO
2. `alloc_chrdev_region()` — allocate dynamic major number
3. `cdev_init() + cdev_device_add()` — create char device
4. `INIT_DELAYED_WORK()` — blink support
5. `devm_mutex_init()` — lock initialization

**Expected dmesg:**

```
gpio-chardev gpio-chardev: device /dev/gpio-chardev created (GPIO21)
```

## file_operations

```c
static const struct file_operations gpio_chardev_fops = {
	.owner          = THIS_MODULE,
	.open           = gpio_chardev_open,
	.release        = gpio_chardev_release,
	.read           = gpio_chardev_read,
	.write          = gpio_chardev_write,
	.unlocked_ioctl = gpio_chardev_ioctl,
};
```

| Operation | Behavior                                   |
| --------- | ------------------------------------------ |
| `read`    | Returns current state as ASCII "0\n"/"1\n" |
| `write`   | Parses "0"/"1" and sets GPIO               |
| `ioctl`   | See ioctl table below                      |

## ioctl Interface

Magic number: `'G'`

| Command                      | Nr  | Direction | Type                        | Description           |
| ---------------------------- | --- | --------- | --------------------------- | --------------------- |
| `GPIO_CHARDEV_IOC_SET_STATE` | 1   | `_IOW`    | `__u32`                     | Set 0 (off) or 1 (on) |
| `GPIO_CHARDEV_IOC_GET_STATE` | 2   | `_IOR`    | `__u32`                     | Get current state     |
| `GPIO_CHARDEV_IOC_TOGGLE`    | 3   | `_IO`     | —                           | Toggle state          |
| `GPIO_CHARDEV_IOC_GET_GPIO`  | 4   | `_IOR`    | `__u32`                     | Get GPIO pin number   |
| `GPIO_CHARDEV_IOC_BLINK`     | 5   | `_IOW`    | `struct gpio_chardev_blink` | Start blink           |

### Blink ioctl payload

```c
struct gpio_chardev_blink {
	__u32 count;      /* 0 = infinite */
	__u32 delay_on;   /* ms */
	__u32 delay_off;  /* ms */
};
```

## Kbuild

```makefile
obj-m += gpio_chardev.o
```
