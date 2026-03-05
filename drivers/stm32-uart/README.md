# stm32-uart

A userspace-only CLI tool for communicating with an STM32 microcontroller over UART. No kernel module required.

## Architecture

```
stm32-ctl
└── libstm32        ← STM32-specific command protocol (CMD 0x80–0xFE)
    └── libuart-transport  ← shared from drivers/common/ (framing + CRC-16)
```

## Hardware

| Signal | RPi Pin | GPIO   | Description           |
|--------|---------|--------|-----------------------|
| TX     | 8       | GPIO14 | RPi UART TX → STM32 RX |
| RX     | 10      | GPIO15 | RPi UART RX ← STM32 TX |
| GND    | 6       | —      | Common ground         |

Default baud rate: 115200. Default port: `/dev/ttyAMA0`.

## Directory Structure

```
stm32-uart/
├── Makefile
└── userspace/
    ├── Makefile
    ├── lib/
    │   └── libstm32/
    │       ├── stm32.c
    │       ├── stm32.h
    │       └── stm32_protocol.h
    └── tools/
        └── stm32-ctl.c
```

Depends on `drivers/common/libuart-transport/` at build time.

## Quick Start

```bash
# Build
make tools DRIVER=stm32-uart

# Install
make install-tools
sudo make deploy-sdcard DEVICE=/dev/sdX
```

## Verify on Target

```bash
stm32-ctl --help
stm32-ctl -d /dev/ttyAMA0 ping    # expect: PONG response from STM32
stm32-ctl -d /dev/ttyAMA0 version # firmware version string
```

## Available Commands

| Command                              | Description              |
|--------------------------------------|--------------------------|
| `ping`                               | Verify comms link        |
| `version`                            | Get firmware version     |
| `status`                             | Get device status        |
| `reset`                              | Reset the STM32          |
| `gpio-set <pin> <in\|out> <0\|1>`   | Set GPIO pin state       |
| `gpio-get <pin>`                     | Read GPIO pin state      |
| `adc <channel>`                      | Read ADC channel         |
| `pwm <channel> <freq> <duty>`        | Set PWM output           |
