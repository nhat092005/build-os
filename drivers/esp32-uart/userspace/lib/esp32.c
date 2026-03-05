// SPDX-License-Identifier: GPL-2.0-or-later
/*
 * ESP32 Device Library — Implementation
 *
 * Wraps uart_transport_send_cmd() with ESP32-specific command IDs
 * and payload structures.  All UART framing, CRC, retry logic lives
 * in libuart-transport — this file only knows about CMD semantics.
 */

#include "esp32.h"

#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "uart_transport.h"

struct esp32_dev {
	uart_transport_t *transport;
};

esp32_dev_t *esp32_open(const char *dev, int baud)
{
	esp32_dev_t *d = calloc(1, sizeof(*d));

	if (!d)
		return NULL;

	d->transport = uart_transport_open(dev, baud);
	if (!d->transport) {
		free(d);
		return NULL;
	}

	return d;
}

void esp32_close(esp32_dev_t *d)
{
	if (!d)
		return;

	uart_transport_close(d->transport);
	free(d);
}

void esp32_set_verbose(esp32_dev_t *d, bool verbose)
{
	if (d && d->transport)
		uart_transport_set_verbose(d->transport, verbose);
}

int esp32_send_cmd(esp32_dev_t *d, uint8_t cmd, const void *payload,
		   uint16_t payload_len, void *resp_buf, uint16_t *resp_len)
{
	if (!d || !d->transport)
		return UART_ERR_INVAL;

	return uart_transport_send_cmd(d->transport, cmd, payload, payload_len,
				       resp_buf, resp_len);
}

int esp32_ping(esp32_dev_t *d)
{
	return esp32_send_cmd(d, ESP32_CMD_PING, NULL, 0, NULL, NULL);
}

int esp32_get_version(esp32_dev_t *d, char *buf, size_t buf_len)
{
	if (!buf || buf_len == 0)
		return UART_ERR_INVAL;

	uint8_t resp[ESP32_VERSION_MAX_LEN];
	uint16_t resp_len = sizeof(resp);
	int ret = esp32_send_cmd(d, ESP32_CMD_GET_VERSION, NULL, 0, resp,
				 &resp_len);

	if (ret)
		return ret;

	/* Copy as NUL-terminated string — truncate if needed */
	size_t copy_len = resp_len;

	if (copy_len >= buf_len)
		copy_len = buf_len - 1;
	memcpy(buf, resp, copy_len);
	buf[copy_len] = '\0';

	return 0;
}

int esp32_get_status(esp32_dev_t *d, struct esp32_status *status)
{
	if (!status)
		return UART_ERR_INVAL;

	uint16_t resp_len = sizeof(*status);

	return esp32_send_cmd(d, ESP32_CMD_GET_STATUS, NULL, 0, status,
			      &resp_len);
}

int esp32_reset(esp32_dev_t *d)
{
	return esp32_send_cmd(d, ESP32_CMD_RESET, NULL, 0, NULL, NULL);
}

int esp32_set_led(esp32_dev_t *d, const struct esp32_led *led)
{
	if (!led)
		return UART_ERR_INVAL;

	return esp32_send_cmd(d, ESP32_CMD_SET_LED, led, sizeof(*led), NULL,
			      NULL);
}

int esp32_get_sensor(esp32_dev_t *d, struct esp32_sensor *sensor)
{
	if (!sensor)
		return UART_ERR_INVAL;

	uint16_t resp_len = sizeof(*sensor);

	return esp32_send_cmd(d, ESP32_CMD_GET_SENSOR, NULL, 0, sensor,
			      &resp_len);
}
