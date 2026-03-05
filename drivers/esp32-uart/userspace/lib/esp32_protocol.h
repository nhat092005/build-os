/* SPDX-License-Identifier: GPL-2.0-or-later */
/*
 * ESP32 Protocol — Command IDs and Payload Structures
 *
 * ESP32 uses CMD range 0x01–0x7F.
 * STM32 uses CMD range 0x80–0xFE.
 */

#ifndef ESP32_PROTOCOL_H
#define ESP32_PROTOCOL_H

#include <stdint.h>

/* ---------- Command IDs (0x01–0x7F) ---------- */

#define ESP32_CMD_PING 0x01 /* No payload; response: no payload */
#define ESP32_CMD_GET_VERSION 0x02 /* No payload; response: version string */
#define ESP32_CMD_GET_STATUS 0x03 /* No payload; response: esp32_status_t */
#define ESP32_CMD_RESET 0x04 /* No payload; response: no payload */
#define ESP32_CMD_SET_LED 0x05 /* Payload: esp32_led_t; response: no payload */
#define ESP32_CMD_GET_SENSOR 0x06 /* No payload; response: esp32_sensor_t */
#define ESP32_CMD_SET_CONFIG \
	0x07 /* Payload: esp32_config_t; response: no payload */
#define ESP32_CMD_GET_CONFIG 0x08 /* No payload; response: esp32_config_t */
#define ESP32_CMD_OTA_BEGIN 0x10 /* No payload; response: no payload (ACK) */
#define ESP32_CMD_OTA_DATA 0x11 /* Payload: raw chunk; response: no payload */
#define ESP32_CMD_OTA_END 0x12 /* No payload; response: no payload */

/* Response status byte (first byte of response payload for commands that ack) */
#define ESP32_STATUS_OK 0x00
#define ESP32_STATUS_ERR_UNKNOWN_CMD 0x01
#define ESP32_STATUS_ERR_INVALID_PARAM 0x02
#define ESP32_STATUS_ERR_BUSY 0x03
#define ESP32_STATUS_ERR_INTERNAL 0xFF

/* ---------- Payload Structures ---------- */

struct esp32_status {
	uint8_t state; /* 0=idle, 1=running, 2=error */
	uint8_t wifi_rssi; /* WiFi RSSI (signed, cast to int8_t) */
	uint32_t uptime_sec; /* seconds since boot, little-endian */
	uint16_t free_heap; /* free heap in bytes, little-endian */
} __attribute__((packed));

struct esp32_led {
	uint8_t led_id; /* LED index (0–N) */
	uint8_t state; /* 0=off, 1=on */
	uint8_t brightness; /* 0–255 */
} __attribute__((packed));

struct esp32_sensor {
	int16_t temperature; /* centi-degrees C (val/100 = °C), LE */
	uint16_t humidity; /* centi-percent (val/100 = %RH), LE */
	uint16_t light_lux; /* lux, LE */
} __attribute__((packed));

struct esp32_config {
	uint8_t wifi_enabled; /* 0=disabled, 1=enabled */
	uint8_t led_mode; /* 0=manual, 1=auto */
	uint16_t poll_ms; /* sensor poll interval in ms, LE */
} __attribute__((packed));

#define ESP32_VERSION_MAX_LEN 32

#endif /* ESP32_PROTOCOL_H */
