/* SPDX-License-Identifier: GPL-2.0-or-later */
/*
 * ESP32 Device Library — Public API
 *
 * Wraps uart_transport with ESP32-specific command IDs and payload structures.
 * Callers (esp32-ctl) use this API — never touch transport directly.
 */

#ifndef ESP32_H
#define ESP32_H

#include <stdbool.h>
#include <stddef.h>
#include <stdint.h>

#include "esp32_protocol.h"

/* Opaque device handle */
typedef struct esp32_dev esp32_dev_t;

/**
 * esp32_open() - Open connection to ESP32 over UART
 * @dev:   UART device path (e.g. "/dev/ttyAMA0")
 * @baud:  baud rate (e.g. 115200)
 *
 * Returns device handle on success, NULL on failure.
 */
esp32_dev_t *esp32_open(const char *dev, int baud);

/**
 * esp32_close() - Close ESP32 connection and free resources
 * @d:  device handle (safe to pass NULL)
 */
void esp32_close(esp32_dev_t *d);

/**
 * esp32_set_verbose() - Enable/disable debug logging
 * @d:       device handle
 * @verbose: true for verbose output
 */
void esp32_set_verbose(esp32_dev_t *d, bool verbose);

/**
 * esp32_send_cmd() - Send raw command with payload
 * @d:            device handle
 * @cmd:          ESP32 command byte (0x01–0x7F)
 * @payload:      payload data (may be NULL)
 * @payload_len:  payload length
 * @resp_buf:     response buffer (may be NULL)
 * @resp_len:     [in] buffer capacity; [out] actual response length
 *
 * Returns 0 on success, negative error code on failure.
 */
int esp32_send_cmd(esp32_dev_t *d, uint8_t cmd, const void *payload,
		   uint16_t payload_len, void *resp_buf, uint16_t *resp_len);

/**
 * esp32_ping() - Ping ESP32 — verify communication link
 * @d:  device handle
 *
 * Returns 0 on success, negative on failure.
 */
int esp32_ping(esp32_dev_t *d);

/**
 * esp32_get_version() - Get ESP32 firmware version string
 * @d:       device handle
 * @buf:     output buffer (NUL-terminated)
 * @buf_len: buffer size (should be >= ESP32_VERSION_MAX_LEN)
 *
 * Returns 0 on success, negative on failure.
 */
int esp32_get_version(esp32_dev_t *d, char *buf, size_t buf_len);

/**
 * esp32_get_status() - Get ESP32 status
 * @d:      device handle
 * @status: output status structure
 *
 * Returns 0 on success, negative on failure.
 */
int esp32_get_status(esp32_dev_t *d, struct esp32_status *status);

/**
 * esp32_reset() - Reset ESP32
 * @d:  device handle
 *
 * Returns 0 on success, negative on failure.
 */
int esp32_reset(esp32_dev_t *d);

/**
 * esp32_set_led() - Set LED state on ESP32
 * @d:    device handle
 * @led:  LED parameters
 *
 * Returns 0 on success, negative on failure.
 */
int esp32_set_led(esp32_dev_t *d, const struct esp32_led *led);

/**
 * esp32_get_sensor() - Read sensor data from ESP32
 * @d:      device handle
 * @sensor: output sensor data
 *
 * Returns 0 on success, negative on failure.
 */
int esp32_get_sensor(esp32_dev_t *d, struct esp32_sensor *sensor);

#endif /* ESP32_H */
