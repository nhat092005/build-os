# Protocol: STM32 UART

## Frame Format (libuart-transport)

```
┌──────┬─────┬──────┬─────┬───────────┬───────────┐
│ SOF  │ CMD │ LEN  │ SEQ │ PAYLOAD   │ CRC16     │
│ 0xAA │ 1B  │ 2B   │ 1B  │ 0–N bytes │ 2B CCITT  │
│      │     │ (LE) │     │           │ (LE)      │
└──────┴─────┴──────┴─────┴───────────┴───────────┘
```

## STM32 Command Table

STM32 uses command IDs from `0x80` to `0xFE`. ESP32 uses `0x01` to `0x7F`.

| CMD    | Name        | Request Payload     | Response Payload      |
| ------ | ----------- | ------------------- | --------------------- |
| `0x80` | PING        | —                   | —                     |
| `0x81` | GET_VERSION | —                   | version string (≤32B) |
| `0x82` | GET_STATUS  | —                   | `stm32_status` (8B)   |
| `0x83` | RESET       | —                   | —                     |
| `0x84` | SET_GPIO    | `stm32_gpio` (3B)   | —                     |
| `0x85` | GET_GPIO    | pin (1B)            | `stm32_gpio` (3B)     |
| `0x86` | GET_ADC     | channel (1B)        | `stm32_adc` (5B)      |
| `0x87` | SET_PWM     | `stm32_pwm` (5B)    | —                     |
| `0x88` | SET_CONFIG  | `stm32_config` (4B) | —                     |
| `0x89` | GET_CONFIG  | —                   | `stm32_config` (4B)   |
| `0x90` | FLASH_BEGIN | —                   | —                     |
| `0x91` | FLASH_DATA  | raw chunk           | —                     |
| `0x92` | FLASH_END   | —                   | —                     |

## Payload Structures

```c
struct stm32_status {     // 8 bytes
	uint8_t  state;       // 0=idle, 1=running, 2=error
	uint32_t uptime_sec;  // seconds since boot (LE)
	uint16_t vcc_mv;      // supply voltage mV (LE)
	int8_t   mcu_temp;    // MCU junction temp °C
};

struct stm32_gpio {       // 3 bytes
	uint8_t pin;          // GPIO pin number
	uint8_t direction;    // 0=input, 1=output
	uint8_t value;        // 0=low, 1=high
};

struct stm32_adc {        // 5 bytes
	uint8_t  channel;
	uint16_t raw;         // raw ADC value (LE)
	uint16_t voltage_mv;  // computed voltage mV (LE)
};

struct stm32_pwm {        // 5 bytes
	uint8_t  channel;
	uint16_t frequency;   // Hz (LE)
	uint16_t duty;        // 0-10000 (0.00% - 100.00%) (LE)
};

struct stm32_config {     // 4 bytes
	uint8_t  mode;
	uint8_t  reserved1;
	uint16_t reserved2;
};
```
