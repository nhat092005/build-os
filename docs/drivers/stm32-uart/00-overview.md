# STM32 UART — Userspace Communication Driver

Userspace library and CLI tool for communicating with an STM32
microcontroller over UART. Uses the shared `libuart-transport` framing
protocol. No kernel module required.

## Stack

```
┌──────────────────────────────────┐
│ STM32 (UART, /dev/ttyAMA0)       │ ← External MCU
└────────────┬─────────────────────┘
             │ UART (115200 8N1 default)
┌────────────▼─────────────────────┐
│ stm32-ctl                        │ ← Userspace tool
│ depends: libstm32 + libuart-transport │
│                                  │
│ Commands:                        │
│   ping, version, status          │
│   reset, gpio-set, gpio-get      │
│   adc, pwm                       │
└──────────────────────────────────┘
```

## Components

| Component       | Present | Path                             |
| --------------- | ------- | -------------------------------- |
| Kernel module   | No      | — (userspace-only)               |
| DTS overlay     | No      | —                                |
| Protocol header | Yes     | `userspace/lib/stm32_protocol.h` |
| Library header  | Yes     | `userspace/lib/stm32.h`          |
| Library impl    | Yes     | `userspace/lib/stm32.c`          |
| CLI tool        | Yes     | `userspace/tools/stm32-ctl.c`    |
| Common lib      | Yes     | `../common/libuart-transport/`   |

## Protocol

Same `libuart-transport` frame format as ESP32. STM32 uses CMD range
0x80–0xFE (ESP32 uses 0x01–0x7F — they share one UART bus without collision).

### STM32 Command IDs (0x80–0xFE)

| CMD    | Name        | Request Payload     | Response Payload         |
| ------ | ----------- | ------------------- | ------------------------ |
| `0x80` | PING        | —                   | —                        |
| `0x81` | GET_VERSION | —                   | version string (max 32B) |
| `0x82` | GET_STATUS  | —                   | `stm32_status` (8B)      |
| `0x83` | RESET       | —                   | —                        |
| `0x84` | SET_GPIO    | `stm32_gpio` (3B)   | —                        |
| `0x85` | GET_GPIO    | pin (1B)            | `stm32_gpio` (3B)        |
| `0x86` | GET_ADC     | channel (1B)        | `stm32_adc` (5B)         |
| `0x87` | SET_PWM     | `stm32_pwm` (5B)    | —                        |
| `0x88` | SET_CONFIG  | `stm32_config` (4B) | —                        |
| `0x89` | GET_CONFIG  | —                   | `stm32_config` (4B)      |
| `0x90` | FLASH_BEGIN | —                   | —                        |
| `0x91` | FLASH_DATA  | raw chunk           | —                        |
| `0x92` | FLASH_END   | —                   | —                        |

### Payload Structures

```c
struct stm32_status {     // 8 bytes, packed
	uint8_t  state;       // 0=idle, 1=running, 2=error
	uint32_t uptime_sec;  // seconds since boot (LE)
	uint16_t vcc_mv;      // supply voltage mV (LE)
	int8_t   mcu_temp;    // MCU junction temp °C
};

struct stm32_gpio {       // 3 bytes, packed
	uint8_t pin;          // GPIO pin number
	uint8_t direction;    // 0=input, 1=output
	uint8_t value;        // 0=low, 1=high
};

struct stm32_adc {        // 5 bytes, packed
	uint8_t  channel;
	uint16_t raw;         // raw ADC (LE)
	uint16_t voltage_mv;  // mV (LE)
};

struct stm32_pwm {        // 5 bytes, packed
	uint8_t  channel;
	uint16_t frequency;   // Hz (LE)
	uint16_t duty;        // 0-10000 (0.00%-100.00%, LE)
};
```

## Library API

```c
stm32_dev_t *stm32_open(const char *dev, int baud);
void         stm32_close(stm32_dev_t *d);
int          stm32_ping(stm32_dev_t *d);
int          stm32_get_version(stm32_dev_t *d, char *buf, size_t len);
int          stm32_get_status(stm32_dev_t *d, struct stm32_status *s);
int          stm32_reset(stm32_dev_t *d);
int          stm32_set_gpio(stm32_dev_t *d, const struct stm32_gpio *g);
int          stm32_get_gpio(stm32_dev_t *d, uint8_t pin, struct stm32_gpio *g);
int          stm32_get_adc(stm32_dev_t *d, uint8_t ch, struct stm32_adc *a);
int          stm32_set_pwm(stm32_dev_t *d, const struct stm32_pwm *p);
```

## Testing

```bash
make tools TOOLS=stm32-uart
# On target:
stm32-ctl /dev/ttyAMA0 115200 ping
stm32-ctl /dev/ttyAMA0 115200 version
stm32-ctl /dev/ttyAMA0 115200 status
stm32-ctl /dev/ttyAMA0 115200 adc 0
```
