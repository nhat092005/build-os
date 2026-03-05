/* SPDX-License-Identifier: GPL-2.0-or-later */
/*
 * STM32 Device Library — Public API
 *
 * Wraps uart_transport with STM32-specific command IDs and payload structures.
 * Callers (stm32-ctl) use this API — never touch transport directly.
 */

#ifndef STM32_H
#define STM32_H

#include <stdbool.h>
#include <stddef.h>
#include <stdint.h>

#include "stm32_protocol.h"

/* Opaque device handle */
typedef struct stm32_dev stm32_dev_t;

/**
 * stm32_open() - Open connection to STM32 over UART
 * @dev:   UART device path (e.g. "/dev/ttyAMA0")
 * @baud:  baud rate (e.g. 115200)
 *
 * Returns device handle on success, NULL on failure.
 */
stm32_dev_t *stm32_open(const char *dev, int baud);

/**
 * stm32_close() - Close STM32 connection and free resources
 * @d:  device handle (safe to pass NULL)
 */
void stm32_close(stm32_dev_t *d);

/**
 * stm32_set_verbose() - Enable/disable debug logging
 * @d:       device handle
 * @verbose: true for verbose output
 */
void stm32_set_verbose(stm32_dev_t *d, bool verbose);

/**
 * stm32_send_cmd() - Send raw command with payload
 * @d:            device handle
 * @cmd:          STM32 command byte (0x80–0xFE)
 * @payload:      payload data (may be NULL)
 * @payload_len:  payload length
 * @resp_buf:     response buffer (may be NULL)
 * @resp_len:     [in] buffer capacity; [out] actual response length
 *
 * Returns 0 on success, negative error code on failure.
 */
int stm32_send_cmd(stm32_dev_t *d, uint8_t cmd, const void *payload,
		   uint16_t payload_len, void *resp_buf, uint16_t *resp_len);

/**
 * stm32_ping() - Ping STM32 — verify communication link
 * @d:  device handle
 *
 * Returns 0 on success, negative on failure.
 */
int stm32_ping(stm32_dev_t *d);

/**
 * stm32_get_version() - Get STM32 firmware version string
 * @d:       device handle
 * @buf:     output buffer (NUL-terminated)
 * @buf_len: buffer size (should be >= STM32_VERSION_MAX_LEN)
 *
 * Returns 0 on success, negative on failure.
 */
int stm32_get_version(stm32_dev_t *d, char *buf, size_t buf_len);

/**
 * stm32_get_status() - Get STM32 status
 * @d:      device handle
 * @status: output status structure
 *
 * Returns 0 on success, negative on failure.
 */
int stm32_get_status(stm32_dev_t *d, struct stm32_status *status);

/**
 * stm32_reset() - Reset STM32
 * @d:  device handle
 *
 * Returns 0 on success, negative on failure.
 */
int stm32_reset(stm32_dev_t *d);

/**
 * stm32_set_gpio() - Set GPIO pin on STM32
 * @d:    device handle
 * @gpio: GPIO parameters
 *
 * Returns 0 on success, negative on failure.
 */
int stm32_set_gpio(stm32_dev_t *d, const struct stm32_gpio *gpio);

/**
 * stm32_get_gpio() - Read GPIO pin state from STM32
 * @d:    device handle
 * @pin:  pin number to read
 * @gpio: output GPIO state
 *
 * Returns 0 on success, negative on failure.
 */
int stm32_get_gpio(stm32_dev_t *d, uint8_t pin, struct stm32_gpio *gpio);

/**
 * stm32_get_adc() - Read ADC channel from STM32
 * @d:       device handle
 * @channel: ADC channel number
 * @adc:     output ADC data
 *
 * Returns 0 on success, negative on failure.
 */
int stm32_get_adc(stm32_dev_t *d, uint8_t channel, struct stm32_adc *adc);

/**
 * stm32_set_pwm() - Set PWM output on STM32
 * @d:   device handle
 * @pwm: PWM parameters
 *
 * Returns 0 on success, negative on failure.
 */
int stm32_set_pwm(stm32_dev_t *d, const struct stm32_pwm *pwm);

#endif /* STM32_H */
