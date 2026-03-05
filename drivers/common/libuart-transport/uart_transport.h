/* SPDX-License-Identifier: GPL-2.0-or-later */
/*
 * UART Transport Layer — Public API
 *
 * Shared framing protocol for ESP32 and STM32 communication over UART.
 *
 * Frame format:
 *   +------+-----+-----+-----+---------+-------+
 *   | SOF  | CMD | LEN | SEQ | PAYLOAD | CRC16 |
 *   | 1B   | 1B  | 2B  | 1B  | N bytes | 2B    |
 *   +------+-----+-----+-----+---------+-------+
 *
 * - SOF:     0xAA (start of frame)
 * - CMD:     command ID (ESP32: 0x01–0x7F, STM32: 0x80–0xFE)
 * - LEN:     payload length, little-endian uint16_t, max 255
 * - SEQ:     sequence number, echoed in response
 * - PAYLOAD: N bytes (0–255)
 * - CRC16:   CRC-16/CCITT-FALSE over SOF -> PAYLOAD (inclusive)
 */

#ifndef UART_TRANSPORT_H
#define UART_TRANSPORT_H

#include <stdbool.h>
#include <stddef.h>
#include <stdint.h>

/* Frame constants */
#define UART_SOF 0xAA
#define UART_MAX_PAYLOAD 255
#define UART_HEADER_SIZE 5 /* SOF + CMD + LEN(2) + SEQ */
#define UART_CRC_SIZE 2
#define UART_MAX_FRAME_SIZE \
	(UART_HEADER_SIZE + UART_MAX_PAYLOAD + UART_CRC_SIZE)

/* Transport defaults */
#define UART_DEFAULT_BAUD 115200
#define UART_TIMEOUT_MS 500 /* per-attempt timeout */
#define UART_MAX_RETRIES 3

/* Error codes (negative errno-style) */
#define UART_OK 0
#define UART_ERR_TIMEOUT (-110) /* -ETIMEDOUT */
#define UART_ERR_BADMSG (-74) /* -EBADMSG (CRC fail) */
#define UART_ERR_PROTO (-71) /* -EPROTO (SEQ mismatch) */
#define UART_ERR_IO (-5) /* -EIO */
#define UART_ERR_INVAL (-22) /* -EINVAL */
#define UART_ERR_NOMEM (-12) /* -ENOMEM */

/* Opaque transport handle */
typedef struct uart_transport uart_transport_t;

/**
 * uart_transport_open() - Open UART device and configure for raw framing
 * @dev:   device path (e.g. "/dev/ttyAMA0")
 * @baud:  baud rate (e.g. 115200)
 *
 * Returns transport handle on success, NULL on failure (errno set).
 */
uart_transport_t *uart_transport_open(const char *dev, int baud);

/**
 * uart_transport_close() - Close transport and release resources
 * @t:  transport handle (safe to pass NULL)
 */
void uart_transport_close(uart_transport_t *t);

/**
 * uart_transport_set_verbose() - Enable/disable debug logging to stderr
 * @t:       transport handle
 * @verbose: true to enable verbose logging
 */
void uart_transport_set_verbose(uart_transport_t *t, bool verbose);

/**
 * uart_transport_send_cmd() - Send command and wait for response
 * @t:            transport handle
 * @cmd:          command byte
 * @payload:      payload data (may be NULL if payload_len == 0)
 * @payload_len:  payload length (0–255)
 * @resp_buf:     buffer to receive response payload (may be NULL)
 * @resp_len:     [in] buffer capacity; [out] actual response payload length
 *
 * Assembles frame, sends over UART, waits for response with timeout + retry.
 *
 * Returns:
 *   UART_OK          success
 *   UART_ERR_TIMEOUT no response after all retries
 *   UART_ERR_BADMSG  CRC mismatch in response
 *   UART_ERR_PROTO   SEQ mismatch in response
 *   UART_ERR_IO      I/O error
 *   UART_ERR_INVAL   invalid argument
 */
int uart_transport_send_cmd(uart_transport_t *t, uint8_t cmd,
			    const void *payload, uint16_t payload_len,
			    void *resp_buf, uint16_t *resp_len);

/**
 * uart_crc16() - Compute CRC-16/CCITT-FALSE
 * @data: input buffer
 * @len:  input length
 *
 * Returns CRC-16 value.
 */
uint16_t uart_crc16(const void *data, size_t len);

#endif /* UART_TRANSPORT_H */
