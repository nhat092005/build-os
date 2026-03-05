// SPDX-License-Identifier: GPL-2.0-or-later
/*
 * SHT3x Temperature & Humidity Sensor — Linux Kernel Driver
 *
 * Copyright (C) 2025 nhat092005
 *
 * This driver exposes a Sensirion SHT30/SHT31/SHT35 as a standard Linux
 * hwmon device.  It uses the I2C client + hwmon subsystem APIs so that
 * standard monitoring tools (lm-sensors, sysfs reads) work out of the box.
 *
 * Features:
 *   - I2C probe with Device Tree support
 *   - Single-shot measurement (high repeatability, 0x2C 0x06)
 *   - Periodic measurement mode (1 Hz MPS, high repeatability, 0x21 0x30)
 *   - Heater control via sysfs attribute (enable/disable)
 *   - CRC-8 integrity check on every read (poly 0x31, init 0xFF)
 *   - hwmon: temp1_input (milli-°C), humidity1_input (milli-%RH)
 *
 * Hardware notes:
 *   - I2C slave address: 0x44 (ADDR LOW) or 0x45 (ADDR HIGH)
 *   - Bus speed:         up to 1 MHz (I2C Fast Mode Plus)
 *   - Measurement time:  ~15 ms (high repeatability)
 *   - Temperature:       -40 to +125 °C, resolution 0.01 °C
 *   - Humidity:          0 to 100 %RH, resolution 0.01 %RH
 *
 * Command protocol:
 *   SHT3x uses 2-byte commands (MSB first), NOT standard SMBus registers.
 *   All I2C communication uses i2c_master_send() / i2c_master_recv().
 *
 * Target: Raspberry Pi 4B, Kernel 6.x, aarch64
 */

#include <linux/module.h>
#include <linux/kernel.h>
#include <linux/i2c.h>
#include <linux/hwmon.h>
#include <linux/mutex.h>
#include <linux/delay.h>
#include <linux/jiffies.h>
#include <linux/workqueue.h>

/* Driver information */
#define SHT3X_DRIVER_NAME	"sht3x"
#define SHT3X_DRIVER_VERSION	"1.0.0"

/* ================================================================
 * SHT3x I2C Commands (2-byte, MSB first)
 * ================================================================
 */

/* Single-shot measurement, high repeatability, clock stretching enabled */
#define SHT3X_CMD_MEAS_HIGH_CS_MSB	0x2C
#define SHT3X_CMD_MEAS_HIGH_CS_LSB	0x06

/* Periodic measurement, 1 MPS, high repeatability */
#define SHT3X_CMD_PERIODIC_1MPS_HIGH_MSB	0x21
#define SHT3X_CMD_PERIODIC_1MPS_HIGH_LSB	0x30

/* Fetch data (periodic mode) */
#define SHT3X_CMD_FETCH_DATA_MSB	0xE0
#define SHT3X_CMD_FETCH_DATA_LSB	0x00

/* Heater control */
#define SHT3X_CMD_HEATER_ENABLE_MSB	0x30
#define SHT3X_CMD_HEATER_ENABLE_LSB	0x6D
#define SHT3X_CMD_HEATER_DISABLE_MSB	0x30
#define SHT3X_CMD_HEATER_DISABLE_LSB	0x66

/* Soft reset */
#define SHT3X_CMD_SOFT_RESET_MSB	0x30
#define SHT3X_CMD_SOFT_RESET_LSB	0xA2

/* Break command — stop periodic measurement */
#define SHT3X_CMD_BREAK_MSB		0x30
#define SHT3X_CMD_BREAK_LSB		0x93

/* Read status register */
#define SHT3X_CMD_READ_STATUS_MSB	0xF3
#define SHT3X_CMD_READ_STATUS_LSB	0x2D

/* Timing */
#define SHT3X_MEAS_DELAY_US		20000 /* 20 ms — high repeatability */
#define SHT3X_RESET_DELAY_US		1000  /* 1 ms — soft reset recovery */
#define SHT3X_PERIODIC_INTERVAL_MS	1000  /* 1 Hz polling interval */
#define SHT3X_HEATER_WARN_JIFFIES	(30 * HZ) /* 30 seconds */

/* CRC-8 parameters */
#define SHT3X_CRC_POLYNOMIAL		0x31
#define SHT3X_CRC_INIT			0xFF

/* I2C retry configuration */
#define SHT3X_I2C_RETRIES		3
#define SHT3X_I2C_RETRY_DELAY_US	1000  /* µs */

/**
 * struct sht3x_data - SHT3x device private data
 * @client:           I2C client handle
 * @lock:             serializes all I2C transactions
 * @work:             periodic measurement delayed_work
 * @temperature:      cached temperature in milli-°C
 * @humidity:         cached humidity in milli-%RH
 * @last_update:      jiffies timestamp of last successful measurement
 * @valid:            true if cached data is valid
 * @heater_enabled:   current heater state
 * @heater_on_since:  jiffies when heater was last enabled
 * @periodic_running: true if periodic measurement mode is active
 */
struct sht3x_data {
	struct i2c_client *client;
	struct mutex lock;			/* serializes all I2C transactions */
	struct delayed_work work;
	s32 temperature;
	s32 humidity;
	unsigned long last_update;
	bool valid;
	bool heater_enabled;
	unsigned long heater_on_since;
	bool periodic_running;
};

/* ================================================================
 * CRC-8 — Sensirion polynomial 0x31, init 0xFF
 * ================================================================
 */

/**
 * sht3x_crc8() - Compute CRC-8 over a data buffer
 * @data:  input byte array
 * @len:   number of bytes
 *
 * Uses the Sensirion CRC-8 algorithm: polynomial 0x31, init 0xFF.
 *
 * Return: CRC-8 value
 */
static u8 sht3x_crc8(const u8 *data, size_t len)
{
	u8 crc = SHT3X_CRC_INIT;
	size_t i;
	int bit;

	for (i = 0; i < len; i++) {
		crc ^= data[i];
		for (bit = 0; bit < 8; bit++) {
			if (crc & 0x80)
				crc = (crc << 1) ^ SHT3X_CRC_POLYNOMIAL;
			else
				crc <<= 1;
		}
	}
	return crc;
}

/* ================================================================
 * Low-level I2C helpers
 * ================================================================
 */

/**
 * sht3x_send_cmd() - Send a 2-byte command to the sensor
 * @data:    driver private data
 * @cmd_msb: command byte (MSB)
 * @cmd_lsb: command byte (LSB)
 *
 * Caller MUST hold @data->lock.
 *
 * Return: 0 on success, negative errno on failure
 */
static int sht3x_send_cmd(struct sht3x_data *data, u8 cmd_msb, u8 cmd_lsb)
{
	struct i2c_client *client = data->client;
	u8 buf[2] = { cmd_msb, cmd_lsb };
	int ret, i;

	for (i = 0; i < SHT3X_I2C_RETRIES; i++) {
		ret = i2c_master_send(client, buf, sizeof(buf));
		if (ret == sizeof(buf))
			return 0;
		if (ret >= 0)
			ret = -EIO;
		if (i < SHT3X_I2C_RETRIES - 1)
			usleep_range(SHT3X_I2C_RETRY_DELAY_US,
				     SHT3X_I2C_RETRY_DELAY_US * 2);
	}
	dev_err(&client->dev,
		"I2C send cmd 0x%02x%02x failed after %d retries: %d\n",
		cmd_msb, cmd_lsb, SHT3X_I2C_RETRIES, ret);
	return ret;
}

/**
 * sht3x_read_data() - Read 6 bytes of measurement data from the sensor
 * @data:   driver private data
 * @buf:    output buffer (must be >= 6 bytes)
 *
 * Reads 6 bytes: [temp_msb, temp_lsb, temp_crc, hum_msb, hum_lsb, hum_crc].
 * Caller MUST hold @data->lock.
 *
 * Return: 0 on success, negative errno on failure
 */
static int sht3x_read_data(struct sht3x_data *data, u8 *buf)
{
	struct i2c_client *client = data->client;
	int ret, i;

	for (i = 0; i < SHT3X_I2C_RETRIES; i++) {
		ret = i2c_master_recv(client, buf, 6);
		if (ret == 6)
			return 0;
		if (ret >= 0)
			ret = -EIO;
		if (i < SHT3X_I2C_RETRIES - 1)
			usleep_range(SHT3X_I2C_RETRY_DELAY_US,
				     SHT3X_I2C_RETRY_DELAY_US * 2);
	}
	dev_err(&client->dev,
		"I2C recv measurement failed after %d retries: %d\n",
		SHT3X_I2C_RETRIES, ret);
	return ret;
}

/* ================================================================
 * Measurement functions
 * ================================================================
 */

/**
 * sht3x_parse_measurement() - Parse and CRC-check 6-byte measurement
 * @data:   driver private data
 * @buf:    6-byte raw measurement buffer
 *
 * Verifies CRC for both temperature and humidity words, then converts
 * raw sensor values to milli-°C and milli-%RH respectively.
 *
 * Conversion formulae (from SHT3x datasheet):
 *   T [°C]  = -45   + 175 × (raw_temp / 65535)
 *   RH [%]  = 100 × (raw_hum / 65535)
 *
 * Caller MUST hold @data->lock.
 *
 * Return: 0 on success, -EIO on CRC failure
 */
static int sht3x_parse_measurement(struct sht3x_data *data, const u8 *buf)
{
	struct device *dev = &data->client->dev;
	u16 raw_temp, raw_hum;

	/* CRC check — temperature word (bytes 0..1, CRC at byte 2) */
	if (sht3x_crc8(&buf[0], 2) != buf[2]) {
		dev_err_ratelimited(dev, "CRC mismatch on temperature word\n");
		return -EIO;
	}

	/* CRC check — humidity word (bytes 3..4, CRC at byte 5) */
	if (sht3x_crc8(&buf[3], 2) != buf[5]) {
		dev_err_ratelimited(dev, "CRC mismatch on humidity word\n");
		return -EIO;
	}

	raw_temp = (buf[0] << 8) | buf[1];
	raw_hum  = (buf[3] << 8) | buf[4];

	/*
	 * Convert to milli-°C:
	 *   T = -45 + 175 × raw / 65535
	 *   T_milli = -45000 + 175000 × raw / 65535
	 *
	 * Use 64-bit intermediate to avoid overflow (175000 × 65535 > 2^31).
	 */
	data->temperature = -45000 + (s32)div_u64((u64)175000 * raw_temp,
						  65535);

	/*
	 * Convert to milli-%RH:
	 *   RH = 100 × raw / 65535
	 *   RH_milli = 100000 × raw / 65535
	 */
	data->humidity = (s32)div_u64((u64)100000 * raw_hum, 65535);

	data->last_update = jiffies;
	data->valid = true;

	return 0;
}

/**
 * sht3x_measure_single_shot() - Trigger a single-shot measurement
 * @data: driver private data
 *
 * Sends the single-shot command (0x2C 0x06), waits for completion,
 * reads 6 bytes, and parses the result into @data->temperature
 * and @data->humidity.
 *
 * Caller MUST hold @data->lock.
 *
 * Return: 0 on success, negative errno on failure
 */
static int sht3x_measure_single_shot(struct sht3x_data *data)
{
	u8 buf[6];
	int ret;

	ret = sht3x_send_cmd(data, SHT3X_CMD_MEAS_HIGH_CS_MSB,
			     SHT3X_CMD_MEAS_HIGH_CS_LSB);
	if (ret)
		return ret;

	/* Wait for measurement completion — 20 ms for high repeatability */
	fsleep(SHT3X_MEAS_DELAY_US);

	ret = sht3x_read_data(data, buf);
	if (ret)
		return ret;

	return sht3x_parse_measurement(data, buf);
}

/**
 * sht3x_fetch_periodic() - Fetch data from periodic measurement mode
 * @data: driver private data
 *
 * Sends the fetch command (0xE0 0x00) and reads 6 bytes.
 * Only valid when periodic mode has been started.
 *
 * Caller MUST hold @data->lock.
 *
 * Return: 0 on success, negative errno on failure
 */
static int sht3x_fetch_periodic(struct sht3x_data *data)
{
	u8 buf[6];
	int ret;

	ret = sht3x_send_cmd(data, SHT3X_CMD_FETCH_DATA_MSB,
			     SHT3X_CMD_FETCH_DATA_LSB);
	if (ret)
		return ret;

	ret = sht3x_read_data(data, buf);
	if (ret)
		return ret;

	return sht3x_parse_measurement(data, buf);
}

/**
 * sht3x_start_periodic() - Start periodic measurement mode
 * @data: driver private data
 *
 * Sends the 1 MPS high-repeatability command (0x21 0x30).
 * Caller MUST hold @data->lock.
 *
 * Return: 0 on success, negative errno on failure
 */
static int sht3x_start_periodic(struct sht3x_data *data)
{
	return sht3x_send_cmd(data, SHT3X_CMD_PERIODIC_1MPS_HIGH_MSB,
			      SHT3X_CMD_PERIODIC_1MPS_HIGH_LSB);
}

/* ================================================================
 * Periodic work handler
 * ================================================================
 */

/**
 * sht3x_work_fn() - Periodic measurement work handler
 * @work: delayed_work embedded in struct sht3x_data
 *
 * Fetches data from periodic mode, updates cache, and reschedules.
 */
static void sht3x_work_fn(struct work_struct *work)
{
	struct sht3x_data *data = container_of(work, struct sht3x_data,
					       work.work);
	int ret;

	mutex_lock(&data->lock);
	ret = sht3x_fetch_periodic(data);
	if (ret)
		dev_dbg(&data->client->dev,
			"Periodic fetch failed: %d\n", ret);

	/* Heater safety warning */
	if (data->heater_enabled &&
	    time_after(jiffies, data->heater_on_since +
				SHT3X_HEATER_WARN_JIFFIES))
		WARN_ON_ONCE(1);

	mutex_unlock(&data->lock);

	schedule_delayed_work(&data->work,
			      msecs_to_jiffies(SHT3X_PERIODIC_INTERVAL_MS));
}

/* ================================================================
 * hwmon interface
 * ================================================================
 */

/**
 * sht3x_read_measurement() - Read measurement, preferring periodic cache
 * @data: driver private data
 *
 * If periodic mode is running and cached data is fresh (< 2 s),
 * returns cached values.  Otherwise falls back to single-shot.
 *
 * Caller MUST hold @data->lock.
 *
 * Return: 0 on success, negative errno on failure
 */
static int sht3x_read_measurement(struct sht3x_data *data)
{
	/* Use cached data if periodic mode is running and data is fresh */
	if (data->periodic_running && data->valid &&
	    time_before(jiffies, data->last_update + 2 * HZ))
		return 0;

	/* Fallback: single-shot measurement */
	return sht3x_measure_single_shot(data);
}

static umode_t sht3x_is_visible(const void *drvdata,
				enum hwmon_sensor_types type,
				u32 attr, int channel)
{
	switch (type) {
	case hwmon_temp:
		if (attr == hwmon_temp_input || attr == hwmon_temp_label)
			return 0444;
		break;
	case hwmon_humidity:
		if (attr == hwmon_humidity_input ||
		    attr == hwmon_humidity_label)
			return 0444;
		break;
	default:
		break;
	}
	return 0;
}

static int sht3x_hwmon_read(struct device *dev,
			    enum hwmon_sensor_types type,
			    u32 attr, int channel, long *val)
{
	struct sht3x_data *data = dev_get_drvdata(dev);
	int ret;

	if (mutex_lock_interruptible(&data->lock))
		return -ERESTARTSYS;

	ret = sht3x_read_measurement(data);
	if (ret) {
		mutex_unlock(&data->lock);
		return ret;
	}

	switch (type) {
	case hwmon_temp:
		*val = data->temperature;
		break;
	case hwmon_humidity:
		*val = data->humidity;
		break;
	default:
		mutex_unlock(&data->lock);
		return -EOPNOTSUPP;
	}

	mutex_unlock(&data->lock);
	return 0;
}

static int sht3x_hwmon_read_string(struct device *dev,
				   enum hwmon_sensor_types type,
				   u32 attr, int channel, const char **str)
{
	switch (type) {
	case hwmon_temp:
		*str = "SHT3x Temperature";
		break;
	case hwmon_humidity:
		*str = "SHT3x Humidity";
		break;
	default:
		return -EOPNOTSUPP;
	}
	return 0;
}

static const struct hwmon_channel_info * const sht3x_info[] = {
	HWMON_CHANNEL_INFO(temp, HWMON_T_INPUT | HWMON_T_LABEL),
	HWMON_CHANNEL_INFO(humidity, HWMON_H_INPUT | HWMON_H_LABEL),
	NULL
};

static const struct hwmon_ops sht3x_hwmon_ops = {
	.is_visible  = sht3x_is_visible,
	.read        = sht3x_hwmon_read,
	.read_string = sht3x_hwmon_read_string,
};

static const struct hwmon_chip_info sht3x_chip_info = {
	.ops  = &sht3x_hwmon_ops,
	.info = sht3x_info,
};

/* ================================================================
 * Heater control — sysfs attribute
 * ================================================================
 */

/**
 * heater_enable_show() - Read current heater state
 * @dev:  hwmon device
 * @attr: device attribute (unused)
 * @buf:  output buffer
 *
 * Return: number of bytes written
 */
static ssize_t heater_enable_show(struct device *dev,
				  struct device_attribute *attr, char *buf)
{
	struct sht3x_data *data = dev_get_drvdata(dev);
	bool enabled;

	if (mutex_lock_interruptible(&data->lock))
		return -ERESTARTSYS;
	enabled = data->heater_enabled;
	mutex_unlock(&data->lock);

	return sysfs_emit(buf, "%d\n", enabled);
}

/**
 * heater_enable_store() - Enable or disable the on-chip heater
 * @dev:   hwmon device
 * @attr:  device attribute (unused)
 * @buf:   input buffer ("0" or "1")
 * @count: input length
 *
 * Return: @count on success, negative errno on failure
 */
static ssize_t heater_enable_store(struct device *dev,
				   struct device_attribute *attr,
				   const char *buf, size_t count)
{
	struct sht3x_data *data = dev_get_drvdata(dev);
	bool enable;
	int ret;

	ret = kstrtobool(buf, &enable);
	if (ret)
		return ret;

	if (mutex_lock_interruptible(&data->lock))
		return -ERESTARTSYS;

	if (enable) {
		ret = sht3x_send_cmd(data, SHT3X_CMD_HEATER_ENABLE_MSB,
				     SHT3X_CMD_HEATER_ENABLE_LSB);
		if (!ret) {
			data->heater_enabled = true;
			data->heater_on_since = jiffies;
		}
	} else {
		ret = sht3x_send_cmd(data, SHT3X_CMD_HEATER_DISABLE_MSB,
				     SHT3X_CMD_HEATER_DISABLE_LSB);
		if (!ret)
			data->heater_enabled = false;
	}

	mutex_unlock(&data->lock);

	if (ret)
		return ret;
	return count;
}

static DEVICE_ATTR_RW(heater_enable);

static struct attribute *sht3x_attrs[] = {
	&dev_attr_heater_enable.attr,
	NULL,
};
ATTRIBUTE_GROUPS(sht3x);

/* ================================================================
 * Probe / Remove
 * ================================================================
 */

/**
 * sht3x_soft_reset() - Issue a soft reset to the sensor
 * @data: driver private data
 *
 * Caller MUST hold @data->lock.
 *
 * Return: 0 on success, negative errno on failure
 */
static int sht3x_soft_reset(struct sht3x_data *data)
{
	int ret;

	ret = sht3x_send_cmd(data, SHT3X_CMD_SOFT_RESET_MSB,
			     SHT3X_CMD_SOFT_RESET_LSB);
	if (ret)
		return ret;

	/* Sensor needs ~1 ms after soft reset */
	fsleep(SHT3X_RESET_DELAY_US);
	return 0;
}

/**
 * sht3x_probe() - Probe function for SHT3x I2C device
 * @client: I2C client
 *
 * Return: 0 on success, negative errno on failure
 */
static int sht3x_probe(struct i2c_client *client)
{
	struct device *dev = &client->dev;
	struct sht3x_data *data;
	struct device *hwmon_dev;
	int ret;

	dev_info(dev, "Probing SHT3x driver v%s\n", SHT3X_DRIVER_VERSION);

	if (!i2c_check_functionality(client->adapter,
				     I2C_FUNC_I2C)) {
		dev_err(dev, "I2C adapter does not support plain I2C\n");
		return -ENODEV;
	}

	data = devm_kzalloc(dev, sizeof(*data), GFP_KERNEL);
	if (!data)
		return -ENOMEM;

	data->client = client;
	i2c_set_clientdata(client, data);

	ret = devm_mutex_init(dev, &data->lock);
	if (ret)
		return ret;

	/* Soft reset — bring sensor to known state */
	mutex_lock(&data->lock);
	ret = sht3x_soft_reset(data);
	mutex_unlock(&data->lock);
	if (ret) {
		dev_err(dev, "Soft reset failed: %d\n", ret);
		return ret;
	}

	/* Start periodic measurement mode (1 Hz, high repeatability) */
	mutex_lock(&data->lock);
	ret = sht3x_start_periodic(data);
	if (ret) {
		mutex_unlock(&data->lock);
		dev_warn(dev, "Failed to start periodic mode: %d, using single-shot only\n",
			 ret);
	} else {
		data->periodic_running = true;
		mutex_unlock(&data->lock);
	}

	/* Register hwmon device */
	hwmon_dev = devm_hwmon_device_register_with_info(dev, SHT3X_DRIVER_NAME,
							 data,
							 &sht3x_chip_info,
							 sht3x_groups);
	if (IS_ERR(hwmon_dev)) {
		ret = PTR_ERR(hwmon_dev);
		dev_err(dev, "Failed to register hwmon device: %d\n", ret);
		return ret;
	}

	/* Start periodic work if periodic mode is active */
	if (data->periodic_running) {
		INIT_DELAYED_WORK(&data->work, sht3x_work_fn);
		schedule_delayed_work(&data->work,
				      msecs_to_jiffies(SHT3X_PERIODIC_INTERVAL_MS));
	}

	dev_info(dev, "SHT3x sensor registered at 0x%02x\n", client->addr);
	dev_dbg(dev, "  hwmon: /sys/class/hwmon/hwmonX/\n");
	dev_dbg(dev, "  periodic mode: %s\n",
		data->periodic_running ? "active" : "disabled");

	return 0;
}

/**
 * sht3x_remove() - Remove function for SHT3x I2C device
 * @client: I2C client
 */
static void sht3x_remove(struct i2c_client *client)
{
	struct sht3x_data *data = i2c_get_clientdata(client);

	/* Stop periodic work before any resource is freed */
	if (data->periodic_running)
		cancel_delayed_work_sync(&data->work);

	/* Disable heater if it was left on */
	mutex_lock(&data->lock);
	if (data->heater_enabled) {
		sht3x_send_cmd(data, SHT3X_CMD_HEATER_DISABLE_MSB,
			       SHT3X_CMD_HEATER_DISABLE_LSB);
		data->heater_enabled = false;
	}

	/* Stop periodic measurement on the sensor */
	if (data->periodic_running)
		sht3x_send_cmd(data, SHT3X_CMD_BREAK_MSB,
			       SHT3X_CMD_BREAK_LSB);
	mutex_unlock(&data->lock);

	dev_info(&client->dev, "SHT3x sensor removed\n");
}

/* Device Tree match table */
static const struct of_device_id sht3x_of_match[] = {
	{ .compatible = "sensirion,sht3x" },
	{ }
};
MODULE_DEVICE_TABLE(of, sht3x_of_match);

/* I2C device ID table (non-DT platforms) */
static const struct i2c_device_id sht3x_id[] = {
	{ "sht3x", 0 },
	{ }
};
MODULE_DEVICE_TABLE(i2c, sht3x_id);

static struct i2c_driver sht3x_driver = {
	.driver = {
		.name           = SHT3X_DRIVER_NAME,
		.of_match_table = sht3x_of_match,
	},
	.probe    = sht3x_probe,
	.remove   = sht3x_remove,
	.id_table = sht3x_id,
};
module_i2c_driver(sht3x_driver);

MODULE_AUTHOR("nhat092005");
MODULE_DESCRIPTION("SHT3x Temperature & Humidity Sensor Driver");
MODULE_LICENSE("GPL");
MODULE_VERSION(SHT3X_DRIVER_VERSION);
