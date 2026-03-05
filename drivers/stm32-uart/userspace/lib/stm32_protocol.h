/* SPDX-License-Identifier: GPL-2.0-or-later */
/*
 * STM32 Protocol — Command IDs and Payload Structures
 *
 * STM32 uses CMD range 0x80–0xFE.
 * ESP32 uses CMD range 0x01–0x7F.
 */

#ifndef STM32_PROTOCOL_H
#define STM32_PROTOCOL_H

#include <stdint.h>

/* ---------- Command IDs (0x80–0xFE) ---------- */

#define STM32_CMD_PING 0x80 /* No payload; response: no payload */
#define STM32_CMD_GET_VERSION 0x81 /* No payload; response: version string */
#define STM32_CMD_GET_STATUS 0x82 /* No payload; response: stm32_status_t */
#define STM32_CMD_RESET 0x83 /* No payload; response: no payload */
#define STM32_CMD_SET_GPIO \
	0x84 /* Payload: stm32_gpio_t; response: no payload */
#define STM32_CMD_GET_GPIO 0x85 /* Payload: pin(1B); response: stm32_gpio_t */
#define STM32_CMD_GET_ADC 0x86 /* Payload: channel(1B); response: stm32_adc_t */
#define STM32_CMD_SET_PWM 0x87 /* Payload: stm32_pwm_t; response: no payload */
#define STM32_CMD_SET_CONFIG \
	0x88 /* Payload: stm32_config_t; response: no payload */
#define STM32_CMD_GET_CONFIG 0x89 /* No payload; response: stm32_config_t */
#define STM32_CMD_FLASH_BEGIN 0x90 /* No payload; response: no payload (ACK) */
#define STM32_CMD_FLASH_DATA 0x91 /* Payload: raw chunk; response: no payload */
#define STM32_CMD_FLASH_END 0x92 /* No payload; response: no payload */

/* Response status byte */
#define STM32_STATUS_OK 0x00
#define STM32_STATUS_ERR_UNKNOWN_CMD 0x01
#define STM32_STATUS_ERR_INVALID_PARAM 0x02
#define STM32_STATUS_ERR_BUSY 0x03
#define STM32_STATUS_ERR_INTERNAL 0xFF

/* ---------- Payload Structures ---------- */

struct stm32_status {
	uint8_t state; /* 0=idle, 1=running, 2=error */
	uint32_t uptime_sec; /* seconds since boot, little-endian */
	uint16_t vcc_mv; /* supply voltage in mV, little-endian */
	int8_t mcu_temp; /* MCU junction temperature in °C */
} __attribute__((packed));

struct stm32_gpio {
	uint8_t pin; /* GPIO pin number */
	uint8_t direction; /* 0=input, 1=output */
	uint8_t value; /* 0=low, 1=high */
} __attribute__((packed));

struct stm32_adc {
	uint8_t channel; /* ADC channel number */
	uint16_t raw; /* raw ADC value, little-endian */
	uint16_t voltage_mv; /* converted voltage in mV, little-endian */
} __attribute__((packed));

struct stm32_pwm {
	uint8_t channel; /* PWM channel number */
	uint16_t frequency; /* frequency in Hz, little-endian */
	uint16_t duty; /* duty cycle 0–10000 (0.00%–100.00%), LE */
} __attribute__((packed));

struct stm32_config {
	uint8_t uart_echo; /* 0=disabled, 1=enabled */
	uint16_t adc_rate_ms; /* ADC conversion rate in ms, LE */
	uint8_t watchdog_sec; /* watchdog timeout in seconds (0=disabled) */
} __attribute__((packed));

#define STM32_VERSION_MAX_LEN 32

#endif /* STM32_PROTOCOL_H */
