/* SPDX-License-Identifier: GPL-2.0-or-later */
/*
 * DS3231 RTC Driver - Internal Header
 *
 * Definitions for the DS3231 I2C RTC kernel driver.
 * This header is for kernel-internal use only.
 *
 * Hardware: Maxim DS3231 Extremely Accurate I2C-Integrated RTC/TCXO/Crystal
 * I2C Address: 0x68 (fixed, no address pins)
 * Datasheet: https://datasheets.maximintegrated.com/en/ds/DS3231.pdf
 */

#ifndef _DS3231_RTC_H
#define _DS3231_RTC_H

#ifdef __KERNEL__

#include <linux/i2c.h>
#include <linux/rtc.h>
#include <linux/mutex.h>

#include "uapi/ds3231-rtc.h"

/* ================================================================
 * Driver Metadata
 * ================================================================ */
#define DRIVER_NAME			"ds3231-rtc"
#define DRIVER_VERSION		"1.0.0"

/* ================================================================
 * Register Map (DS3231 Datasheet Table 1)
 *
 * All time registers use BCD encoding.
 * Use bcd2bin() / bin2bcd() from <linux/bcd.h> for conversion.
 * ================================================================ */

/* Timekeeping registers (0x00 - 0x06): 7-byte block, auto-increment */
#define DS3231_REG_SECONDS		0x00	/* BCD 00-59                        */
#define DS3231_REG_MINUTES		0x01	/* BCD 00-59                        */
#define DS3231_REG_HOURS		0x02	/* BCD 00-23 (24h) or 1-12 (12h)   */
#define DS3231_REG_DAY			0x03	/* BCD 1-7 (user-assigned weekday)  */
#define DS3231_REG_DATE			0x04	/* BCD 01-31                        */
#define DS3231_REG_MONTH		0x05	/* BCD 01-12, bit7=century          */
#define DS3231_REG_YEAR			0x06	/* BCD 00-99                        */
#define DS3231_TIME_REG_COUNT	7		/* Total timekeeping registers      */

/* Alarm 1 registers (0x07 - 0x0A): second-level precision */
#define DS3231_REG_ALARM1_SEC	0x07
#define DS3231_REG_ALARM1_MIN	0x08
#define DS3231_REG_ALARM1_HOUR	0x09
#define DS3231_REG_ALARM1_DAY	0x0A
#define DS3231_ALARM1_REG_COUNT	4

/* Alarm 2 registers (0x0B - 0x0D): minute-level precision only */
#define DS3231_REG_ALARM2_MIN	0x0B
#define DS3231_REG_ALARM2_HOUR	0x0C
#define DS3231_REG_ALARM2_DAY	0x0D
#define DS3231_ALARM2_REG_COUNT	3

/* Configuration registers */
#define DS3231_REG_CONTROL		0x0E
#define DS3231_REG_STATUS		0x0F
#define DS3231_REG_AGING		0x10

/* Temperature registers (read-only, chip updates every 64 seconds) */
#define DS3231_REG_TEMP_MSB		0x11	/* Signed integer part (°C)        */
#define DS3231_REG_TEMP_LSB		0x12	/* Bits 7:6 = fractional (0.25°C)  */

/* ================================================================
 * Control Register (0x0E) Bit Definitions
 *
 * EOSC is active LOW: writing 0 = oscillator runs.
 * ================================================================ */
#define DS3231_CTRL_EOSC		BIT(7)	/* Enable Oscillator (0=run, 1=stop on VBAT) */
#define DS3231_CTRL_BBSQW		BIT(6)	/* Battery-backed square-wave enable          */
#define DS3231_CTRL_CONV		BIT(5)	/* Force temperature conversion               */
#define DS3231_CTRL_RS2			BIT(4)	/* Rate select bit 2                          */
#define DS3231_CTRL_RS1			BIT(3)	/* Rate select bit 1                          */
#define DS3231_CTRL_INTCN		BIT(2)	/* Interrupt control (1=INT/SQW→alarm)        */
#define DS3231_CTRL_A2IE		BIT(1)	/* Alarm 2 interrupt enable                   */
#define DS3231_CTRL_A1IE		BIT(0)	/* Alarm 1 interrupt enable                   */

/* ================================================================
 * Status Register (0x0F) Bit Definitions
 * ================================================================ */
#define DS3231_STAT_OSF			BIT(7)	/* Oscillator Stop Flag (1=stopped) */
#define DS3231_STAT_EN32KHZ		BIT(3)	/* 32kHz output enable              */
#define DS3231_STAT_BSY			BIT(2)	/* Temperature conversion busy      */
#define DS3231_STAT_A2F			BIT(1)	/* Alarm 2 flag                     */
#define DS3231_STAT_A1F			BIT(0)	/* Alarm 1 flag                     */

/* ================================================================
 * Hours Register (0x02) Bit Definitions
 * ================================================================ */
#define DS3231_HOURS_12H_MODE	BIT(6)	/* 1=12-hour mode, 0=24-hour mode */
#define DS3231_HOURS_PM			BIT(5)	/* PM indicator in 12-hour mode   */
#define DS3231_HOURS_MASK_24H	0x3F	/* BCD mask for 24-hour value     */
#define DS3231_HOURS_MASK_12H	0x1F	/* BCD mask for 12-hour value     */

/* ================================================================
 * Month Register (0x05) Bit Definitions
 * ================================================================ */
#define DS3231_MONTH_CENTURY	BIT(7)	/* Century rollover flag  */
#define DS3231_MONTH_MASK		0x1F	/* BCD month value mask   */

/* Alarm AxMx mask bits (bit 7 of each alarm register) */
#define DS3231_ALARM_MASK_BIT	BIT(7)

/* Alarm day/date selector (bit 6 of alarm day/date register) */
#define DS3231_ALARM_DY_DT		BIT(6)	/* 1=day-of-week, 0=date */

/* ================================================================
 * Per-Device Private Data
 * ================================================================ */

/**
 * struct ds3231_data - Per-instance driver state
 * @client:     I2C client handle provided by the I2C core during probe
 * @rtc:        RTC class device registered with the RTC subsystem
 * @lock:       Mutex serialising all I2C transactions within this driver
 * @osf_seen:   true when OSF was set at probe time (time not reliable)
 *
 * Allocated with devm_kzalloc() in probe(); freed automatically on removal.
 * Stored in i2c_client->dev.driver_data via i2c_set_clientdata().
 */
struct ds3231_data {
	struct i2c_client	*client;
	struct rtc_device	*rtc;
	struct mutex		lock;
	bool				osf_seen;
};

#endif /* __KERNEL__ */
#endif /* _DS3231_RTC_H */
