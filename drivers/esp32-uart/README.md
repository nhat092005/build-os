# esp32-uart

A userspace-only CLI tool for communicating with an ESP32 microcontroller over UART. No kernel module required.

## Architecture

```
esp32-ctl
└── libesp32        ← ESP32-specific command protocol (CMD 0x01–0x7F)
    └── libuart-transport  ← shared from drivers/common/ (framing + CRC-16)
```

## Hardware

| Signal | RPi Pin | GPIO   | Description          |
|--------|---------|--------|----------------------|
| TX     | 8       | GPIO14 | RPi UART TX → ESP32 RX |
| RX     | 10      | GPIO15 | RPi UART RX ← ESP32 TX |
| GND    | 6       | —      | Common ground        |

Default baud rate: 115200. Default port: `/dev/ttyAMA0`.

## Directory Structure

```
esp32-uart/
├── Makefile
└── userspace/
    ├── Makefile
    ├── lib/
    │   └── libesp32/
    │       ├── esp32.c
    │       ├── esp32.h
    │       └── esp32_protocol.h
    └── tools/
        └── esp32-ctl.c
```

Depends on `drivers/common/libuart-transport/` at build time.

## Quick Start

```bash
# Build
make tools DRIVER=esp32-uart

# Install
make install-tools
sudo make deploy-sdcard DEVICE=/dev/sdX
```

## Verify on Target

```bash
esp32-ctl --help
esp32-ctl -d /dev/ttyAMA0 ping    # expect: PONG response from ESP32
esp32-ctl -d /dev/ttyAMA0 version # firmware version string
```

## Available Commands

| Command                            | Description             |
|------------------------------------|-------------------------|
| `ping`                             | Verify comms link       |
| `version`                          | Get firmware version    |
| `status`                           | Get device status       |
| `reset`                            | Reset the ESP32         |
| `led <id> <on\|off> [brightness]`  | Set LED state           |
| `sensor`                           | Read sensor data        |
