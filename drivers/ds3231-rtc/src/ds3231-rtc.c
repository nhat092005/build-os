// SPDX-License-Identifier: GPL-2.0-or-later
/*
 * DS3231 Extremely Accurate I2C-Integrated RTC — Linux Kernel Driver
 *
 * Copyright (C) 2025 nhat092005
 *
 * This driver exposes a Maxim/Analog Devices DS3231 as a standard Linux
 * RTC device (/dev/rtcN).  It uses the I2C client + RTC subsystem APIs so
 * that all generic user-space tools (hwclock, timedatectl, etc.) work out
 * of the box without any custom ioctls.
 *
 * Features (Phase 1 — production baseline):
 *   - I2C probe with Device Tree support
 *   - OSF (Oscillator Stop Flag) detection and automatic clear
 *   - read_time / set_time via 7-byte atomic I2C block transfer
 *   - BCD <-> binary via <linux/bcd.h>
 *   - Mutex-serialised I2C access
 *   - On-chip temperature sensor exposed via sysfs (milli-°C)
 *   - /dev/rtcN device node compatible with hwclock
 *
 * Hardware notes:
 *   - I2C slave address:  0x68 (fixed, no address pins)
 *   - Bus speed:          up to 400 kHz (I2C Fast Mode)
 *   - Battery backup:     CR2032 coin cell for timekeeping without VCC
 *   - Time format:        BCD, 24-hour mode enforced by this driver
 *   - Temperature:        updated internally every 64 s, resolution 0.25 °C
 *
 * Target: Raspberry Pi 4B, Kernel 6.x, aarch64
 */

#include <linux/module.h>
#include <linux/kernel.h>
#include <linux/i2c.h>
#include <linux/rtc.h>
#include <linux/bcd.h>
#include <linux/mutex.h>
#include <linux/of.h>
#include <linux/slab.h>
#include <linux/delay.h>

#include "../include/ds3231-rtc.h"

/* I2C retry configuration */
#define DS3231_I2C_RETRIES     3
#define DS3231_I2C_RETRY_DELAY 1000  /* µs */

/* ================================================================
 * Low-level I2C helpers
 * ================================================================ */

/**
 * ds3231_read_reg() - Read a single register
 * @data: driver private data (contains @client and @lock)
 * @reg:  register address (0x00 – 0x12)
 *
 * Caller MUST hold @data->lock.
 *
 * Return: register value (>= 0) or negative errno
 */
static int ds3231_read_reg(struct ds3231_data *data, u8 reg)
{
	int ret, i;

	for (i = 0; i < DS3231_I2C_RETRIES; i++) {
		ret = i2c_smbus_read_byte_data(data->client, reg);
		if (ret >= 0)
			return ret;
		if (i < DS3231_I2C_RETRIES - 1)
			usleep_range(DS3231_I2C_RETRY_DELAY,
				     DS3231_I2C_RETRY_DELAY * 2);
	}
	dev_err(&data->client->dev,
		"I2C read reg 0x%02x failed after %d retries: %d\n",
		reg, DS3231_I2C_RETRIES, ret);
	return ret;
}

/**
 * ds3231_write_reg() - Write a single register
 * @data:  driver private data
 * @reg:   register address
 * @value: byte to write
 *
 * Caller MUST hold @data->lock.
 *
 * Return: 0 on success, negative errno on failure
 */
static int ds3231_write_reg(struct ds3231_data *data, u8 reg, u8 value)
{
	int ret, i;

	for (i = 0; i < DS3231_I2C_RETRIES; i++) {
		ret = i2c_smbus_write_byte_data(data->client, reg, value);
		if (ret == 0)
			return 0;
		if (i < DS3231_I2C_RETRIES - 1)
			usleep_range(DS3231_I2C_RETRY_DELAY,
				     DS3231_I2C_RETRY_DELAY * 2);
	}
	dev_err(&data->client->dev,
		"I2C write reg 0x%02x failed after %d retries: %d\n",
		reg, DS3231_I2C_RETRIES, ret);
	return ret;
}

/**
 * ds3231_read_block() - Read a contiguous block of registers
 * @data:   driver private data
 * @reg:    starting register address
 * @count:  number of bytes to read
 * @buf:    output buffer (must be at least @count bytes)
 *
 * Uses i2c_smbus_read_i2c_block_data() which reads all bytes in a single
 * I2C transaction (one START/STOP pair), preventing mid-read corruption.
 *
 * Caller MUST hold @data->lock.
 *
 * Return: number of bytes read on success, negative errno on failure
 */
static int ds3231_read_block(struct ds3231_data *data,
			     u8 reg, u8 count, u8 *buf)
{
	int ret, i;

	for (i = 0; i < DS3231_I2C_RETRIES; i++) {
		ret = i2c_smbus_read_i2c_block_data(data->client, reg,
						    count, buf);
		if (ret == count)
			return ret;
		if (ret >= 0)
			ret = -EIO; /* partial read */
		if (i < DS3231_I2C_RETRIES - 1)
			usleep_range(DS3231_I2C_RETRY_DELAY,
				     DS3231_I2C_RETRY_DELAY * 2);
	}
	dev_err(&data->client->dev,
		"I2C block read reg 0x%02x (%u bytes) failed after %d retries: %d\n",
		reg, count, DS3231_I2C_RETRIES, ret);
	return ret;
}

/**
 * ds3231_write_block() - Write a contiguous block of registers
 * @data:   driver private data
 * @reg:    starting register address
 * @count:  number of bytes to write
 * @buf:    data to write
 *
 * Caller MUST hold @data->lock.
 *
 * Return: 0 on success, negative errno on failure
 */
static int ds3231_write_block(struct ds3231_data *data,
			      u8 reg, u8 count, const u8 *buf)
{
	int ret, i;

	for (i = 0; i < DS3231_I2C_RETRIES; i++) {
		ret = i2c_smbus_write_i2c_block_data(data->client, reg,
						     count, buf);
		if (ret == 0)
			return 0;
		if (i < DS3231_I2C_RETRIES - 1)
			usleep_range(DS3231_I2C_RETRY_DELAY,
				     DS3231_I2C_RETRY_DELAY * 2);
	}
	dev_err(&data->client->dev,
		"I2C block write reg 0x%02x (%u bytes) failed after %d retries: %d\n",
		reg, count, DS3231_I2C_RETRIES, ret);
	return ret;
}

/* ================================================================
 * Chip initialisation helpers (called from probe only)
 * ================================================================ */

/**
 * ds3231_init_control_reg() - Configure the DS3231 control register
 * @data: driver private data
 *
 * Sets register 0x0E to a known-safe state:
 *   EOSC  = 0  oscillator always runs, even on VBAT
 *   BBSQW = 0  no square-wave output while on battery
 *   CONV  = 0  no forced temperature conversion
 *   INTCN = 1  INT/SQW pin is alarm interrupt, not square-wave output
 *   A2IE, A1IE = 0  both alarms disabled (Phase 1 baseline)
 *
 * Holds @data->lock as required by I2C helper contract.
 *
 * Return: 0 on success, negative errno on failure
 */
static int ds3231_init_control_reg(struct ds3231_data *data)
{
	struct device *dev = &data->client->dev;
	int ret;

	mutex_lock(&data->lock);
	ret = ds3231_write_reg(data, DS3231_REG_CONTROL, DS3231_CTRL_INTCN);
	mutex_unlock(&data->lock);

	if (ret < 0)
		dev_err(dev, "Failed to init control register: %d\n", ret);
	else
		dev_dbg(dev, "Control register set: INTCN=1, alarms disabled\n");

	return ret;
}

/**
 * ds3231_ensure_24h_mode() - Guarantee the chip uses 24-hour time format
 * @data: driver private data
 *
 * DS3231 ships in 24-hour mode but could be in 12-hour mode if previously
 * configured by another driver or firmware.  Bit 6 of register 0x02 is the
 * 12h/24h select flag (1 = 12h).  If detected, this function converts the
 * stored time to 24-hour BCD and re-writes the register.
 *
 * Holds @data->lock as required by I2C helper contract.
 *
 * Return: 0 on success (or already 24h), negative errno on failure
 */
static int ds3231_ensure_24h_mode(struct ds3231_data *data)
{
	struct device *dev = &data->client->dev;
	u8 hour12, hour24;
	bool is_pm;
	int hours_reg, ret;

	mutex_lock(&data->lock);
	hours_reg = ds3231_read_reg(data, DS3231_REG_HOURS);
	if (hours_reg < 0) {
		mutex_unlock(&data->lock);
		dev_err(dev, "Failed to read hours register: %d\n", hours_reg);
		return hours_reg;
	}

	if (!(hours_reg & DS3231_HOURS_12H_MODE)) {
		mutex_unlock(&data->lock);
		dev_dbg(dev, "24-hour mode confirmed\n");
		return 0;
	}

	dev_info(dev, "12-hour mode detected — converting to 24-hour mode\n");

	/*
	 * 12h register layout: bit5=PM, bits[4:0]=BCD hour (1–12)
	 * Convert to 24h: 12 AM = 0, 12 PM = 12, 1-11 PM = 13-23
	 */
	hour12 = bcd2bin(hours_reg & DS3231_HOURS_MASK_12H);
	is_pm   = !!(hours_reg & DS3231_HOURS_PM);

	if (hour12 == 12)
		hour24 = is_pm ? 12 : 0;	/* 12 PM = noon, 12 AM = midnight */
	else
		hour24 = is_pm ? (hour12 + 12) : hour12;

	/* Write back with bit 6 = 0 (24-hour mode), preserve other bits */
	ret = ds3231_write_reg(data, DS3231_REG_HOURS, bin2bcd(hour24));
	mutex_unlock(&data->lock);

	if (ret < 0)
		dev_err(dev, "Failed to enforce 24-hour mode: %d\n", ret);

	return ret;
}

/* ================================================================
 * OSF (Oscillator Stop Flag) handling
 * ================================================================ */

/**
 * ds3231_check_osf() - Detect and clear the Oscillator Stop Flag
 * @data: driver private data
 *
 * The DS3231 sets bit 7 (OSF) in the status register (0x0F) when its
 * oscillator has stopped — typically because both VCC and VBAT were
 * removed.  When OSF = 1 the stored time is unreliable.
 *
 * This function:
 *   1. Reads the status register (with mutex held)
 *   2. If OSF=1: logs a warning, records osf_seen=true, clears OSF bit
 *   3. In both cases: disables the 32 kHz output pin to save battery power
 *
 * Called once during probe() — holds @data->lock.
 *
 * Return: 0 on success, negative errno on I2C failure
 */
static int ds3231_check_osf(struct ds3231_data *data)
{
	struct device *dev = &data->client->dev;
	int status, ret;

	/*
	 * Probe is single-threaded, but I2C helpers require the lock
	 * to be held — honour that contract here.
	 */
	mutex_lock(&data->lock);
	status = ds3231_read_reg(data, DS3231_REG_STATUS);
	if (status < 0) {
		mutex_unlock(&data->lock);
		dev_err(dev, "Failed to read status register: %d\n", status);
		return status;
	}

	if (status & DS3231_STAT_OSF) {
		dev_warn(dev, "Oscillator was stopped (OSF=1). "
			 "Stored time may be invalid — please set the clock\n");
		data->osf_seen = true;

		/* Clear OSF (bit 7) and disable 32 kHz output (bit 3) */
		status &= ~(DS3231_STAT_OSF | DS3231_STAT_EN32KHZ);
		ret = ds3231_write_reg(data, DS3231_REG_STATUS, (u8)status);
		if (ret < 0)
			dev_warn(dev, "Failed to clear OSF in status register: %d\n",
				 ret);
	} else {
		data->osf_seen = false;
		dev_dbg(dev, "Oscillator running normally\n");

		/* Disable 32 kHz output pin if not already off (saves power) */
		if (status & DS3231_STAT_EN32KHZ) {
			status &= ~DS3231_STAT_EN32KHZ;
			ret = ds3231_write_reg(data, DS3231_REG_STATUS, (u8)status);
			if (ret < 0)
				dev_warn(dev, "Failed to disable 32 kHz output: %d\n",
					 ret);
		}
	}

	mutex_unlock(&data->lock);
	return 0;
}

/* ================================================================
 * RTC class operations — read_time / set_time
 * ================================================================ */

/**
 * ds3231_read_time() - Read the current time from the DS3231 chip
 * @dev: device pointer (from RTC core callback)
 * @tm:  output — kernel struct rtc_time
 *
 * Reads 7 bytes (registers 0x00–0x06) in a single I2C block transaction,
 * converts each BCD field to binary and fills @tm.
 *
 * If osf_seen is true (oscillator had stopped and user has not yet called
 * set_time), returns -ENODATA to signal that the time is unreliable.
 *
 * Return: 0 on success, negative errno on failure
 */
static int ds3231_read_time(struct device *dev, struct rtc_time *tm)
{
	struct ds3231_data *data = dev_get_drvdata(dev);
	u8 regs[DS3231_TIME_REG_COUNT];
	int ret;

	/*
	 * Acquire lock before checking osf_seen to avoid a race where
	 * set_time() completes on another CPU between the flag read and
	 * the actual I2C transaction.
	 */
	if (mutex_lock_interruptible(&data->lock))
		return -ERESTARTSYS;

	if (data->osf_seen) {
		mutex_unlock(&data->lock);
		dev_dbg(dev, "Time not reliable (OSF was set). "
			"Set the time first with hwclock -w\n");
		return -ENODATA;
	}

	ret = ds3231_read_block(data, DS3231_REG_SECONDS,
				DS3231_TIME_REG_COUNT, regs);

	mutex_unlock(&data->lock);

	if (ret < 0) {
		dev_err(dev, "I2C block read failed: %d\n", ret);
		return ret;
	}

	/*
	 * BCD -> binary conversion.
	 *
	 * Seconds  [0x00]: bits 6:0 valid (bit 7 don't-care on DS3231)
	 * Minutes  [0x01]: bits 6:0 valid
	 * Hours    [0x02]: bits 5:0 in 24-h mode (bit 6 = 0)
	 * Day      [0x03]: bits 2:0 (1-7, user-defined weekday)
	 * Date     [0x04]: bits 5:0
	 * Month    [0x05]: bits 4:0 month BCD, bit 7 = century
	 * Year     [0x06]: bits 7:0 (00-99 BCD)
	 *
	 * struct rtc_time conventions (POSIX):
	 *   tm_sec   0-59
	 *   tm_min   0-59
	 *   tm_hour  0-23
	 *   tm_wday  0-6  (0 = Sunday)
	 *   tm_mday  1-31
	 *   tm_mon   0-11 (0 = January)
	 *   tm_year  years since 1900
	 */
	tm->tm_sec  = bcd2bin(regs[0] & 0x7F);
	tm->tm_min  = bcd2bin(regs[1] & 0x7F);
	tm->tm_hour = bcd2bin(regs[2] & DS3231_HOURS_MASK_24H);
	tm->tm_wday = bcd2bin(regs[3] & 0x07) - 1; /* chip 1-7 → POSIX 0-6 */
	if (tm->tm_wday < 0 || tm->tm_wday > 6)
		tm->tm_wday = 0; /* defensive: treat invalid as Sunday */
	tm->tm_mday = bcd2bin(regs[4] & 0x3F);
	tm->tm_mon  = bcd2bin(regs[5] & DS3231_MONTH_MASK) - 1;

	/*
	 * Year calculation:
	 *   DS3231 stores 00-99 representing 2000-2099.
	 *   Century bit (reg[5] bit 7) flips at rollover into 2100+.
	 *   tm_year is years since 1900, so 2000 = 100, 2100 = 200.
	 */
	if (regs[5] & DS3231_MONTH_CENTURY)
		tm->tm_year = bcd2bin(regs[6]) + 200; /* 2100-2199 */
	else
		tm->tm_year = bcd2bin(regs[6]) + 100; /* 2000-2099 */

	return rtc_valid_tm(tm);
}

/**
 * ds3231_set_time() - Write a new time to the DS3231 chip
 * @dev: device pointer
 * @tm:  time to set
 *
 * Converts @tm from binary to BCD and writes 7 bytes starting at register
 * 0x00 in a single I2C block transaction.  The chip is always kept in
 * 24-hour mode (bit 6 of hours register = 0).
 *
 * After a successful write, osf_seen is cleared so that read_time works.
 *
 * Return: 0 on success, negative errno on failure
 */
static int ds3231_set_time(struct device *dev, struct rtc_time *tm)
{
	struct ds3231_data *data = dev_get_drvdata(dev);
	u8 regs[DS3231_TIME_REG_COUNT];
	int ret;

	/* Validate year range supported by DS3231 hardware (2000–2199) */
	if (tm->tm_year < 100 || tm->tm_year >= 300) {
		dev_err(dev, "Year %d out of DS3231 range (2000-2199)\n",
			tm->tm_year + 1900);
		return -EINVAL;
	}

	/* Binary → BCD, respecting DS3231 register layout */
	regs[0] = bin2bcd(tm->tm_sec);
	regs[1] = bin2bcd(tm->tm_min);
	regs[2] = bin2bcd(tm->tm_hour);           /* bit 6 = 0 → 24h mode */
	regs[3] = bin2bcd((tm->tm_wday % 7) + 1); /* POSIX 0-6 → chip 1-7 */
	regs[4] = bin2bcd(tm->tm_mday);
	regs[5] = bin2bcd(tm->tm_mon + 1);        /* POSIX 0-11 → chip 1-12 */

	/*
	 * Century handling:
	 *   tm_year 100-199 → chip year 00-99, century bit clear (2000-2099)
	 *   tm_year 200-299 → chip year 00-99, century bit set   (2100-2199)
	 */
	if (tm->tm_year >= 200) {
		regs[5] |= DS3231_MONTH_CENTURY;
		regs[6] = bin2bcd(tm->tm_year - 200);
	} else {
		regs[6] = bin2bcd(tm->tm_year - 100);
	}

	if (mutex_lock_interruptible(&data->lock))
		return -ERESTARTSYS;

	ret = ds3231_write_block(data, DS3231_REG_SECONDS,
				 DS3231_TIME_REG_COUNT, regs);

	/*
	 * Clear osf_seen inside the lock so that a concurrent read_time()
	 * cannot slip in and see osf_seen=true after we have set the time.
	 */
	if (ret == 0)
		data->osf_seen = false;

	mutex_unlock(&data->lock);

	if (ret < 0) {
		dev_err(dev, "I2C block write failed: %d\n", ret);
		return ret;
	}

	dev_dbg(dev, "Time set to %04d-%02d-%02d %02d:%02d:%02d\n",
		 tm->tm_year + 1900, tm->tm_mon + 1, tm->tm_mday,
		 tm->tm_hour, tm->tm_min, tm->tm_sec);

	return 0;
}

/* RTC subsystem operations table */
static const struct rtc_class_ops ds3231_rtc_ops = {
	.read_time = ds3231_read_time,
	.set_time  = ds3231_set_time,
};

/* ================================================================
 * Temperature sensor — sysfs attribute
 * ================================================================ */

/**
 * temperature_show() - Read on-chip temperature via sysfs
 * @dev:  device pointer (i2c_client->dev)
 * @attr: device attribute (unused)
 * @buf:  output buffer
 *
 * DS3231 contains an on-die temperature sensor whose reading is used
 * internally for crystal compensation.  We expose it as a convenience.
 *
 * Register 0x11: signed integer degrees Celsius
 * Register 0x12: bits 7:6 = fractional part in 0.25 °C increments
 *
 * Output format: milli-degrees Celsius (e.g. "25250\n" for 25.25 °C).
 *
 * Return: number of bytes written to @buf, or negative errno
 */
static ssize_t temperature_show(struct device *dev,
				struct device_attribute *attr, char *buf)
{
	struct ds3231_data *data = dev_get_drvdata(dev);
	u8 temp_buf[2];
	int ret, i;
	s16 integer_part;
	u8 frac_part;
	long millideg;

	if (mutex_lock_interruptible(&data->lock))
		return -ERESTARTSYS;

	/*
	 * Wait for any in-progress temperature conversion to complete.
	 * The BSY bit is set during TCXO compensation (up to ~200 ms).
	 * Polling avoids reading stale register values.
	 */
	for (i = 0; i < 10; i++) {
		ret = ds3231_read_reg(data, DS3231_REG_STATUS);
		if (ret < 0)
			goto unlock;
		if (!(ret & DS3231_STAT_BSY))
			break;
		mutex_unlock(&data->lock);
		usleep_range(20000, 25000); /* ~20 ms per poll */
		if (mutex_lock_interruptible(&data->lock))
			return -ERESTARTSYS;
	}

	ret = ds3231_read_block(data, DS3231_REG_TEMP_MSB, 2, temp_buf);

unlock:
	mutex_unlock(&data->lock);

	if (ret < 0)
		return ret;

	/*
	 * temp_buf[0] is a signed byte (integer part, -128 to +127 °C).
	 * temp_buf[1] bits 7:6 are the fractional part (0, 0.25, 0.5, 0.75).
	 */
	integer_part = (s8)temp_buf[0];
	frac_part = (temp_buf[1] >> 6) & 0x03;
	millideg = (long)integer_part * 1000 + (long)frac_part * 250;

	return sysfs_emit(buf, "%ld\n", millideg);
}
static DEVICE_ATTR_RO(temperature);

/* Sysfs attribute group for the I2C device node */
static struct attribute *ds3231_attrs[] = {
	&dev_attr_temperature.attr,
	NULL,
};

static const struct attribute_group ds3231_attr_group = {
	.attrs = ds3231_attrs,
};

static const struct attribute_group *ds3231_dev_groups[] = {
	&ds3231_attr_group,
	NULL,
};

/* ================================================================
 * I2C probe / remove
 * ================================================================ */

/**
 * ds3231_probe() - Called by I2C core when a matching Device Tree node is found
 * @client: I2C client allocated and configured by the kernel
 *
 * Initialisation sequence:
 *   1. Allocate per-device data (devm — auto-freed)
 *   2. Verify hardware presence by reading status register
 *   3. Initialise control register to known-safe state
 *   4. Ensure 24-hour mode (convert stored time if chip was in 12h mode)
 *   5. Check and clear OSF; disable unused 32 kHz output pin
 *   6. Allocate RTC device, set valid range, register with RTC core
 *   7. Register custom sysfs attribute (temperature)
 *
 * Return: 0 on success, negative errno on failure
 */
static int ds3231_probe(struct i2c_client *client)
{
	struct device *dev = &client->dev;
	struct ds3231_data *data;
	int ret;

	dev_dbg(dev, "Probing DS3231 RTC v%s at 0x%02x\n",
		 DRIVER_VERSION, client->addr);

	/* ---- Step 1: allocate private data ---- */
	data = devm_kzalloc(dev, sizeof(*data), GFP_KERNEL);
	if (!data)
		return -ENOMEM;

	data->client = client;
	mutex_init(&data->lock);
	i2c_set_clientdata(client, data);

	/* ---- Step 2: verify chip is present (use retry for robustness) ---- */
	mutex_lock(&data->lock);
	ret = ds3231_read_reg(data, DS3231_REG_STATUS);
	mutex_unlock(&data->lock);
	if (ret < 0) {
		dev_err(dev, "DS3231 not responding — check wiring "
			"(SDA=GPIO2, SCL=GPIO3) and power supply\n");
		return -ENODEV;
	}

	/* ---- Step 3: initialise control register to known state ---- */
	ret = ds3231_init_control_reg(data);
	if (ret)
		return ret;

	/* ---- Step 4: ensure 24-hour time mode ---- */
	ret = ds3231_ensure_24h_mode(data);
	if (ret)
		return ret;

	/* ---- Step 5: handle oscillator stop flag ---- */
	ret = ds3231_check_osf(data);
	if (ret)
		return ret;

	/* ---- Step 6: register with RTC subsystem ---- */
	data->rtc = devm_rtc_allocate_device(dev);
	if (IS_ERR(data->rtc)) {
		dev_err(dev, "Failed to allocate RTC device\n");
		return PTR_ERR(data->rtc);
	}

	data->rtc->ops       = &ds3231_rtc_ops;
	data->rtc->range_min = RTC_TIMESTAMP_BEGIN_2000;  /* 2000-01-01 */
	data->rtc->range_max = mktime64(2199, 12, 31, 23, 59, 59);

	ret = devm_rtc_register_device(data->rtc);
	if (ret) {
		dev_err(dev, "Failed to register RTC device: %d\n", ret);
		return ret;
	}

	/* ---- Step 7: temperature sysfs attribute ---- */
	/* Sysfs group registered via .dev_groups in i2c_driver struct */

	dev_info(dev, "DS3231 registered as %s (OSF=%s)\n",
		 dev_name(&data->rtc->dev),
		 data->osf_seen ? "was-set" : "clear");

	return 0;
}

/**
 * ds3231_remove() - Cleanup on driver removal
 * @client: I2C client
 *
 * All resources were allocated with devm_* — the kernel frees them
 * automatically.  We only destroy the mutex explicitly.
 */
static void ds3231_remove(struct i2c_client *client)
{
	struct ds3231_data *data = i2c_get_clientdata(client);

	mutex_destroy(&data->lock);
	dev_info(&client->dev, "DS3231 driver removed\n");
}

/* ================================================================
 * Device Tree / I2C match tables
 * ================================================================ */

static const struct of_device_id ds3231_of_match[] = {
	{ .compatible = "maxim,ds3231" },
	{ /* sentinel */ }
};
MODULE_DEVICE_TABLE(of, ds3231_of_match);

static const struct i2c_device_id ds3231_id_table[] = {
	{ "ds3231", 0 },
	{ /* sentinel */ }
};
MODULE_DEVICE_TABLE(i2c, ds3231_id_table);

static struct i2c_driver ds3231_driver = {
	.driver = {
		.name           = DRIVER_NAME,
		.of_match_table = ds3231_of_match,
		.dev_groups     = ds3231_dev_groups,
	},
	.probe    = ds3231_probe,
	.remove   = ds3231_remove,
	.id_table = ds3231_id_table,
};

module_i2c_driver(ds3231_driver);

MODULE_AUTHOR("nhat092005");
MODULE_DESCRIPTION("DS3231 I2C RTC Driver — Linux RTC Subsystem Integration");
MODULE_LICENSE("GPL");
MODULE_VERSION(DRIVER_VERSION);
MODULE_ALIAS("i2c:ds3231");
