// SPDX-License-Identifier: GPL-2.0-or-later
/*
 * STM32 Device Library — Implementation
 *
 * Wraps uart_transport_send_cmd() with STM32-specific command IDs
 * and payload structures.  All UART framing, CRC, retry logic lives
 * in libuart-transport — this file only knows about CMD semantics.
 */

#include "stm32.h"

#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "uart_transport.h"

struct stm32_dev {
	uart_transport_t *transport;
};

stm32_dev_t *stm32_open(const char *dev, int baud)
{
	stm32_dev_t *d = calloc(1, sizeof(*d));

	if (!d)
		return NULL;

	d->transport = uart_transport_open(dev, baud);
	if (!d->transport) {
		free(d);
		return NULL;
	}

	return d;
}

void stm32_close(stm32_dev_t *d)
{
	if (!d)
		return;

	uart_transport_close(d->transport);
	free(d);
}

void stm32_set_verbose(stm32_dev_t *d, bool verbose)
{
	if (d && d->transport)
		uart_transport_set_verbose(d->transport, verbose);
}

int stm32_send_cmd(stm32_dev_t *d, uint8_t cmd, const void *payload,
		   uint16_t payload_len, void *resp_buf, uint16_t *resp_len)
{
	if (!d || !d->transport)
		return UART_ERR_INVAL;

	return uart_transport_send_cmd(d->transport, cmd, payload, payload_len,
				       resp_buf, resp_len);
}

int stm32_ping(stm32_dev_t *d)
{
	return stm32_send_cmd(d, STM32_CMD_PING, NULL, 0, NULL, NULL);
}

int stm32_get_version(stm32_dev_t *d, char *buf, size_t buf_len)
{
	if (!buf || buf_len == 0)
		return UART_ERR_INVAL;

	uint8_t resp[STM32_VERSION_MAX_LEN];
	uint16_t resp_len = sizeof(resp);
	int ret = stm32_send_cmd(d, STM32_CMD_GET_VERSION, NULL, 0, resp,
				 &resp_len);

	if (ret)
		return ret;

	size_t copy_len = resp_len;

	if (copy_len >= buf_len)
		copy_len = buf_len - 1;
	memcpy(buf, resp, copy_len);
	buf[copy_len] = '\0';

	return 0;
}

int stm32_get_status(stm32_dev_t *d, struct stm32_status *status)
{
	if (!status)
		return UART_ERR_INVAL;

	uint16_t resp_len = sizeof(*status);

	return stm32_send_cmd(d, STM32_CMD_GET_STATUS, NULL, 0, status,
			      &resp_len);
}

int stm32_reset(stm32_dev_t *d)
{
	return stm32_send_cmd(d, STM32_CMD_RESET, NULL, 0, NULL, NULL);
}

int stm32_set_gpio(stm32_dev_t *d, const struct stm32_gpio *gpio)
{
	if (!gpio)
		return UART_ERR_INVAL;

	return stm32_send_cmd(d, STM32_CMD_SET_GPIO, gpio, sizeof(*gpio), NULL,
			      NULL);
}

int stm32_get_gpio(stm32_dev_t *d, uint8_t pin, struct stm32_gpio *gpio)
{
	if (!gpio)
		return UART_ERR_INVAL;

	uint16_t resp_len = sizeof(*gpio);

	return stm32_send_cmd(d, STM32_CMD_GET_GPIO, &pin, sizeof(pin), gpio,
			      &resp_len);
}

int stm32_get_adc(stm32_dev_t *d, uint8_t channel, struct stm32_adc *adc)
{
	if (!adc)
		return UART_ERR_INVAL;

	uint16_t resp_len = sizeof(*adc);

	return stm32_send_cmd(d, STM32_CMD_GET_ADC, &channel, sizeof(channel),
			      adc, &resp_len);
}

int stm32_set_pwm(stm32_dev_t *d, const struct stm32_pwm *pwm)
{
	if (!pwm)
		return UART_ERR_INVAL;

	return stm32_send_cmd(d, STM32_CMD_SET_PWM, pwm, sizeof(*pwm), NULL,
			      NULL);
}
