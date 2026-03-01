/* SPDX-License-Identifier: GPL-2.0-or-later */
/**
 * BH1750 Ambient Light Sensor Driver - Internal Header
 * 
 * This header defines internal structures, constants, and helper functions
 * for the BH1750 I2C ambient light sensor driver. It is intended for 
 * kernel-internal use only
 */

#ifndef _BH1750_H
#define _BH1750_H

#ifdef __KERNEL__

#include <linux/i2c.h>
#include <linux/iio/iio.h>
#include <linux/mutex.h>

/* Driver information */
#define BH1750_DRIVER_NAME "bh1750"
#define BH1750_DRIVER_VERSION "1.0.0"

/**
 * BH1750 I2C Commands (single-byte, no register address)
 */
#define BH1750_CMD_POWER_DOWN 0x00
#define BH1750_CMD_POWER_ON 0x01
#define BH1750_CMD_RESET 0x07

/**
 * BH1750 Measurement Commands
 */
#define BH1750_CMD_CONT_H_RES 0x10 /* 1 lx, 120 ms */
#define BH1750_CMD_CONT_H_RES2 0x11 /* 0.5 lx, 120 ms */
#define BH1750_CMD_CONT_L_RES 0x13 /* 4 lx, 16 ms */

/**
 * One-time measurement commands
 */
#define BH1750_CMD_OT_H_RES 0x20 /* 1 lx, 120 ms */
#define BH1750_CMD_OT_H_RES2 0x21 /* 0.5 lx, 120 ms */
#define BH1750_CMD_OT_L_RES 0x23 /* 4 lx, 16 ms */

/**
 * Timing constants (must exceed measurement time for reliable operation)
 */
#define BH1750_MEAS_DELAY_H_US 180000 /* 180 ms — H-res / H-res2 */
#define BH1750_MEAS_DELAY_L_US 24000 /* 24 ms — L-res */
#define BH1750_POWER_ON_DELAY_US 10000 /* 10 ms — after power on */

/**
 * Polling intervals for continuous mode (must exceed measurement time)
 */
#define BH1750_POLL_INTERVAL_H_MS 200 /* ms — H-res / H-res2 */
#define BH1750_POLL_INTERVAL_L_MS 50 /* ms — L-res */

/**
 * Autosuspend delay for runtime PM (must exceed measurement time)
 */
#define BH1750_AUTOSUSPEND_DELAY_MS 2000 /* ms */

/**
 * Measurement resolution modes
 */
enum bh1750_resolution {
	BH1750_RES_H = 0, /* High resolution: 1 lx */
	BH1750_RES_H2, /* High resolution 2: 0.5 lx */
	BH1750_RES_L, /* Low resolution: 4 lx */
	BH1750_RES_MAX,
};

/**
 * Continuous mode command lookup indexed by enum bh1750_resolution
 */
static const u8 bh1750_cont_cmd[] = {
	[BH1750_RES_H] = BH1750_CMD_CONT_H_RES,
	[BH1750_RES_H2] = BH1750_CMD_CONT_H_RES2,
	[BH1750_RES_L] = BH1750_CMD_CONT_L_RES,
};

/**
 * One-time mode command lookup indexed by enum bh1750_resolution
 */
static const u8 bh1750_ot_cmd[] = {
	[BH1750_RES_H] = BH1750_CMD_OT_H_RES,
	[BH1750_RES_H2] = BH1750_CMD_OT_H_RES2,
	[BH1750_RES_L] = BH1750_CMD_OT_L_RES,
};

/**
 * Measurement delay values indexed by enum bh1750_resolution
 */
static const unsigned long bh1750_meas_delay_us[] = {
	[BH1750_RES_H] = BH1750_MEAS_DELAY_H_US,
	[BH1750_RES_H2] = BH1750_MEAS_DELAY_H_US,
	[BH1750_RES_L] = BH1750_MEAS_DELAY_L_US,
};

/**
 * Polling intervals (ms) indexed by enum bh1750_resolution
 */
static const unsigned int bh1750_poll_ms[] = {
	[BH1750_RES_H] = BH1750_POLL_INTERVAL_H_MS,
	[BH1750_RES_H2] = BH1750_POLL_INTERVAL_H_MS,
	[BH1750_RES_L] = BH1750_POLL_INTERVAL_L_MS,
};

/**
 * Scale factors for converting raw ADC values to lux
 */
static const int bh1750_scale_int[] = {
	[BH1750_RES_H] = 0,
	[BH1750_RES_H2] = 0,
	[BH1750_RES_L] = 0,
};

/**
 * Scale factors for converting raw ADC values to lux (fractional part in micro)
 */
static const int bh1750_scale_micro[] = {
	[BH1750_RES_H] = 833333,
	[BH1750_RES_H2] = 416667,
	[BH1750_RES_L] = 833333,
};

#endif /* __KERNEL__ */
#endif /* _BH1750_H */