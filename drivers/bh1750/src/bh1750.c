// SPDX-License-Identifier: GPL-2.0-or-later
/*
 * BH1750 Ambient Light Sensor — Linux Kernel Driver (IIO)
 *
 * This driver provides support for the BH1750 ambient light sensor over I2C,
 * exposing raw and processed light measurements via the IIO subsystem.
 */

#include <linux/module.h>
#include <linux/kernel.h>
#include <linux/i2c.h>
#include <linux/iio/iio.h>
#include <linux/iio/sysfs.h>
#include <linux/mutex.h>
#include <linux/delay.h>
#include <linux/jiffies.h>
#include <linux/workqueue.h>
#include <linux/pm_runtime.h>
#include <linux/byteorder/generic.h>

#include "../include/bh1750.h"

/* I2C retry configuration */
#define BH1750_I2C_RETRIES 3
#define BH1750_I2C_RETRY_DELAY_US 1000 /* µs */

/* Module parameter: resolution mode (0=H, 1=H2, 2=L) */
static unsigned int resolution;
module_param(resolution, uint, 0444);
MODULE_PARM_DESC(
	resolution,
	"Measurement resolution (0=H-res 1lx, 1=H-res2 0.5lx, 2=L-res 4lx)");

/**
 * struct bh1750_data - BH1750 device private data
 * @client: I2C client handle
 * @lock: serializes all I2C transactions
 * @work: periodic measurement delayed_work
 * @raw: cached raw ADC reading
 * @last_update: jiffies timestamp of last successful measurement
 * @valid: true if cached data is valid
 * @res: current resolution mode
 * @continuous: true if continuous measurement mode is active
 */
struct bh1750_data {
	struct i2c_client *client;
	struct mutex lock; /* serializes all I2C transactions */
	struct delayed_work work;
	u16 raw;
	unsigned long last_update;
	bool valid;
	enum bh1750_resolution res;
	bool continuous;
};

/*
 * Low-level I2C helpers
 */

/**
 * bh1750_send_cmd() - Send a single-byte command to the sensor
 * @data: driver private data
 * @cmd: command byte
 *
 * Caller MUST hold @data->lock.
 *
 * Return: 0 on success, negative errno on failure
 */
static int bh1750_send_cmd(struct bh1750_data *data, u8 cmd)
{
	struct i2c_client *client = data->client;
	int ret, i;

	for (i = 0; i < BH1750_I2C_RETRIES; i++) {
		ret = i2c_master_send(client, &cmd, 1);
		if (ret == 1)
			return 0;
		if (ret >= 0)
			ret = -EIO;
		if (i < BH1750_I2C_RETRIES - 1)
			usleep_range(BH1750_I2C_RETRY_DELAY_US,
				     BH1750_I2C_RETRY_DELAY_US * 2);
	}
	dev_err(&client->dev,
		"I2C send cmd 0x%02x failed after %d retries: %d\n", cmd,
		BH1750_I2C_RETRIES, ret);
	return ret;
}

/**
 * bh1750_read_raw_value() - Read 2-byte measurement result from the sensor
 * @data: driver private data
 * @raw: output raw ADC value (big-endian converted to CPU)
 *
 * Caller MUST hold @data->lock.
 *
 * Return: 0 on success, negative errno on failure
 */
static int bh1750_read_raw_value(struct bh1750_data *data, u16 *raw)
{
	struct i2c_client *client = data->client;
	__be16 buf;
	int ret, i;

	for (i = 0; i < BH1750_I2C_RETRIES; i++) {
		ret = i2c_master_recv(client, (u8 *)&buf, sizeof(buf));
		if (ret == sizeof(buf)) {
			*raw = be16_to_cpu(buf);
			return 0;
		}
		if (ret >= 0)
			ret = -EIO;
		if (i < BH1750_I2C_RETRIES - 1)
			usleep_range(BH1750_I2C_RETRY_DELAY_US,
				     BH1750_I2C_RETRY_DELAY_US * 2);
	}
	dev_err(&client->dev,
		"I2C recv measurement failed after %d retries: %d\n",
		BH1750_I2C_RETRIES, ret);
	return ret;
}

/*
 * Measurement functions
 */

/**
 * bh1750_measure_one_time() - Trigger a one-time measurement
 * @data: driver private data
 *
 * Sends the one-time measurement command for the current resolution mode,
 * waits for completion, and reads the raw ADC value.
 *
 * Caller MUST hold @data->lock.
 *
 * Return: 0 on success, negative errno on failure
 */
static int bh1750_measure_one_time(struct bh1750_data *data)
{
	int ret;

	ret = bh1750_send_cmd(data, bh1750_ot_cmd[data->res]);
	if (ret)
		return ret;

	fsleep(bh1750_meas_delay_us[data->res]);

	ret = bh1750_read_raw_value(data, &data->raw);
	if (ret)
		return ret;

	data->last_update = jiffies;
	data->valid = true;
	return 0;
}

/**
 * bh1750_start_continuous() - Start continuous measurement mode
 * @data: driver private data
 *
 * Caller MUST hold @data->lock.
 *
 * Return: 0 on success, negative errno on failure
 */
static int bh1750_start_continuous(struct bh1750_data *data)
{
	return bh1750_send_cmd(data, bh1750_cont_cmd[data->res]);
}

/*
 * Periodic work handler
 */

/**
 * bh1750_work_fn() - Periodic measurement work handler
 * @work: delayed_work embedded in struct bh1750_data
 *
 * Reads from continuous mode, caches result, and reschedules.
 */
static void bh1750_work_fn(struct work_struct *work)
{
	struct bh1750_data *data =
		container_of(work, struct bh1750_data, work.work);
	int ret;

	mutex_lock(&data->lock);
	ret = bh1750_read_raw_value(data, &data->raw);
	if (!ret) {
		data->last_update = jiffies;
		data->valid = true;
	} else {
		dev_dbg(&data->client->dev, "Periodic read failed: %d\n", ret);
	}
	mutex_unlock(&data->lock);

	schedule_delayed_work(&data->work,
			      msecs_to_jiffies(bh1750_poll_ms[data->res]));
}

/*
 * IIO interface
 */

/**
 * bh1750_read_measurement() - Read measurement, preferring continuous cache
 * @data: driver private data
 *
 * If continuous mode is running and cached data is fresh (< 1 s),
 * returns cached values.  Otherwise falls back to one-time measurement.
 *
 * Caller MUST hold @data->lock.
 *
 * Return: 0 on success, negative errno on failure
 */
static int bh1750_read_measurement(struct bh1750_data *data)
{
	if (data->continuous && data->valid &&
	    time_before(jiffies, data->last_update + HZ))
		return 0;

	return bh1750_measure_one_time(data);
}

static int bh1750_read_raw(struct iio_dev *indio_dev,
			   struct iio_chan_spec const *chan, int *val,
			   int *val2, long mask)
{
	struct bh1750_data *data = iio_priv(indio_dev);
	struct device *dev = &data->client->dev;
	int ret;

	switch (mask) {
	case IIO_CHAN_INFO_RAW:
		ret = pm_runtime_resume_and_get(dev);
		if (ret)
			return ret;

		if (mutex_lock_interruptible(&data->lock)) {
			pm_runtime_mark_last_busy(dev);
			pm_runtime_put_autosuspend(dev);
			return -ERESTARTSYS;
		}
		ret = bh1750_read_measurement(data);
		if (!ret)
			*val = data->raw;
		mutex_unlock(&data->lock);

		pm_runtime_mark_last_busy(dev);
		pm_runtime_put_autosuspend(dev);

		return ret ? ret : IIO_VAL_INT;

	case IIO_CHAN_INFO_SCALE:
		*val = bh1750_scale_int[data->res];
		*val2 = bh1750_scale_micro[data->res];
		return IIO_VAL_INT_PLUS_MICRO;

	case IIO_CHAN_INFO_PROCESSED:
		ret = pm_runtime_resume_and_get(dev);
		if (ret)
			return ret;

		if (mutex_lock_interruptible(&data->lock)) {
			pm_runtime_mark_last_busy(dev);
			pm_runtime_put_autosuspend(dev);
			return -ERESTARTSYS;
		}
		ret = bh1750_read_measurement(data);
		if (!ret) {
			/*
			 * Compute lux in milli-lux for precision:
			 *   H-res/L-res:  mlux = raw * 1000 / 1.2
			 *                      = raw * 10000 / 12
			 *   H-res2:       mlux = raw * 1000 / 2.4
			 *                      = raw * 10000 / 24
			 */
			if (data->res == BH1750_RES_H2)
				*val = data->raw * 10000 / 24;
			else
				*val = data->raw * 10000 / 12;
		}
		mutex_unlock(&data->lock);

		pm_runtime_mark_last_busy(dev);
		pm_runtime_put_autosuspend(dev);

		return ret ? ret : IIO_VAL_INT;

	default:
		return -EINVAL;
	}
}

static const struct iio_info bh1750_iio_info = {
	.read_raw = bh1750_read_raw,
};

static const struct iio_chan_spec bh1750_channels[] = {
	{
		.type = IIO_LIGHT,
		.info_mask_separate = BIT(IIO_CHAN_INFO_RAW) |
				      BIT(IIO_CHAN_INFO_SCALE) |
				      BIT(IIO_CHAN_INFO_PROCESSED),
	},
};

/*
 * Runtime Power Management
 */

static int bh1750_runtime_suspend(struct device *dev)
{
	struct iio_dev *indio_dev = dev_get_drvdata(dev);
	struct bh1750_data *data = iio_priv(indio_dev);
	int ret;

	/* Stop continuous polling before powering down */
	if (data->continuous)
		cancel_delayed_work_sync(&data->work);

	mutex_lock(&data->lock);
	ret = bh1750_send_cmd(data, BH1750_CMD_POWER_DOWN);
	data->valid = false;
	mutex_unlock(&data->lock);

	if (ret)
		dev_warn(dev, "Failed to power down: %d\n", ret);

	return 0;
}

static int bh1750_runtime_resume(struct device *dev)
{
	struct iio_dev *indio_dev = dev_get_drvdata(dev);
	struct bh1750_data *data = iio_priv(indio_dev);
	int ret;

	mutex_lock(&data->lock);
	ret = bh1750_send_cmd(data, BH1750_CMD_POWER_ON);
	if (ret) {
		mutex_unlock(&data->lock);
		dev_err(dev, "Failed to power on: %d\n", ret);
		return ret;
	}

	/* Sensor needs >= 10 ms after power-on before accepting commands */
	fsleep(BH1750_POWER_ON_DELAY_US);

	/* Re-enter continuous mode if it was previously active */
	if (data->continuous) {
		ret = bh1750_start_continuous(data);
		if (ret) {
			mutex_unlock(&data->lock);
			dev_err(dev, "Failed to restart continuous mode: %d\n",
				ret);
			return ret;
		}
	}
	mutex_unlock(&data->lock);

	/* Restart periodic polling */
	if (data->continuous)
		schedule_delayed_work(
			&data->work,
			msecs_to_jiffies(bh1750_poll_ms[data->res]));

	return 0;
}

static DEFINE_RUNTIME_DEV_PM_OPS(bh1750_pm_ops, bh1750_runtime_suspend,
				 bh1750_runtime_resume, NULL);

/*
 * Probe / Remove
 */

/**
 * bh1750_probe() - Probe function for BH1750 I2C device
 * @client: I2C client
 *
 * Return: 0 on success, negative errno on failure
 */
static int bh1750_probe(struct i2c_client *client)
{
	struct device *dev = &client->dev;
	struct iio_dev *indio_dev;
	struct bh1750_data *data;
	int ret;

	dev_info(dev, "Probing BH1750 driver v%s\n", BH1750_DRIVER_VERSION);

	if (!i2c_check_functionality(client->adapter, I2C_FUNC_I2C)) {
		dev_err(dev, "I2C adapter does not support plain I2C\n");
		return -ENODEV;
	}

	/* Clamp resolution module param */
	if (resolution >= BH1750_RES_MAX) {
		dev_warn(dev, "Invalid resolution %u, defaulting to H-res\n",
			 resolution);
		resolution = BH1750_RES_H;
	}

	indio_dev = devm_iio_device_alloc(dev, sizeof(*data));
	if (!indio_dev)
		return -ENOMEM;

	data = iio_priv(indio_dev);
	data->client = client;
	data->res = resolution;
	i2c_set_clientdata(client, indio_dev);

	ret = devm_mutex_init(dev, &data->lock);
	if (ret)
		return ret;

	/* Power on the sensor */
	mutex_lock(&data->lock);
	ret = bh1750_send_cmd(data, BH1750_CMD_POWER_ON);
	mutex_unlock(&data->lock);
	if (ret) {
		dev_err(dev, "Failed to power on sensor: %d\n", ret);
		return ret;
	}

	/* Wait for sensor to be ready after power-on */
	fsleep(BH1750_POWER_ON_DELAY_US);

	/* Configure IIO device */
	indio_dev->name = BH1750_DRIVER_NAME;
	indio_dev->info = &bh1750_iio_info;
	indio_dev->channels = bh1750_channels;
	indio_dev->num_channels = ARRAY_SIZE(bh1750_channels);
	indio_dev->modes = INDIO_DIRECT_MODE;

	/* Start continuous measurement mode */
	mutex_lock(&data->lock);
	ret = bh1750_start_continuous(data);
	if (ret) {
		mutex_unlock(&data->lock);
		dev_warn(
			dev,
			"Failed to start continuous mode: %d, using one-time only\n",
			ret);
	} else {
		data->continuous = true;
		mutex_unlock(&data->lock);
	}

	/* Register IIO device */
	ret = devm_iio_device_register(dev, indio_dev);
	if (ret) {
		dev_err(dev, "Failed to register IIO device: %d\n", ret);
		return ret;
	}

	/* Start periodic work if continuous mode is active */
	if (data->continuous) {
		INIT_DELAYED_WORK(&data->work, bh1750_work_fn);
		schedule_delayed_work(
			&data->work,
			msecs_to_jiffies(bh1750_poll_ms[data->res]));
	}

	/* Enable runtime PM with autosuspend */
	devm_pm_runtime_enable(dev);
	pm_runtime_set_active(dev);
	pm_runtime_set_autosuspend_delay(dev, BH1750_AUTOSUSPEND_DELAY_MS);
	pm_runtime_use_autosuspend(dev);

	dev_info(dev, "BH1750 sensor registered at 0x%02x (resolution=%u)\n",
		 client->addr, data->res);

	return 0;
}

/**
 * bh1750_remove() - Remove function for BH1750 I2C device
 * @client: I2C client
 */
static void bh1750_remove(struct i2c_client *client)
{
	struct iio_dev *indio_dev = i2c_get_clientdata(client);
	struct bh1750_data *data = iio_priv(indio_dev);

	/* Stop periodic work before any resource is freed */
	if (data->continuous)
		cancel_delayed_work_sync(&data->work);

	/* Power down the sensor */
	mutex_lock(&data->lock);
	bh1750_send_cmd(data, BH1750_CMD_POWER_DOWN);
	mutex_unlock(&data->lock);

	dev_info(&client->dev, "BH1750 sensor removed\n");
}

/* Device Tree match table */
static const struct of_device_id bh1750_of_match[] = {
	{ .compatible = "rohm,bh1750" },
	{}
};
MODULE_DEVICE_TABLE(of, bh1750_of_match);

/* I2C device ID table (non-DT platforms) */
static const struct i2c_device_id bh1750_id[] = { { "bh1750", 0 }, {} };
MODULE_DEVICE_TABLE(i2c, bh1750_id);

static struct i2c_driver bh1750_driver = {
	.driver = {
		.name           = BH1750_DRIVER_NAME,
		.of_match_table = bh1750_of_match,
		.pm             = pm_ptr(&bh1750_pm_ops),
	},
	.probe    = bh1750_probe,
	.remove   = bh1750_remove,
	.id_table = bh1750_id,
};
module_i2c_driver(bh1750_driver);

MODULE_AUTHOR("nhat092005");
MODULE_DESCRIPTION("BH1750 Ambient Light Sensor Driver (IIO)");
MODULE_LICENSE("GPL");
MODULE_VERSION(BH1750_DRIVER_VERSION);
