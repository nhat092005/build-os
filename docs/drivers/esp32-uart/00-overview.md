# ESP32 UART — Overview

Userspace library and CLI tool for communicating with an ESP32 microcontroller over UART. Uses the shared `libuart-transport` framing protocol. No kernel module required.

## Stack

```
┌──────────────────────────────────┐
│ ESP32 (UART, /dev/ttyAMA0)       │ ← External MCU
└────────────┬─────────────────────┘
             │ UART (115200 8N1 default)
┌────────────▼─────────────────────┐
│ esp32-ctl                        │ ← Userspace tool
│ depends: libesp32 + libuart-transport │
│                                  │
│ Commands:                        │
│   ping, version, status          │
│   reset, led, sensor             │
└──────────────────────────────────┘
```

## Components

| Component       | Present | Path                             |
| --------------- | ------- | -------------------------------- |
| Kernel module   | No      | — (userspace-only)               |
| DTS overlay     | No      | —                                |
| Protocol header | Yes     | `userspace/lib/esp32_protocol.h` |
| Library header  | Yes     | `userspace/lib/esp32.h`          |
| Library impl    | Yes     | `userspace/lib/esp32.c`          |
| CLI tool        | Yes     | `userspace/tools/esp32-ctl.c`    |
| Common lib      | Yes     | `../common/libuart-transport/`   |

## Quick Start

```bash
# 1. Build and install userspace tools
make tools TOOLS=esp32-uart
sudo make install-tools

# 2. Add UART overlay to /boot/config.txt
# enable_uart=1
# dtoverlay=disable-bt

# 3. Use the CLI tool
esp32-ctl /dev/ttyAMA0 115200 ping
esp32-ctl /dev/ttyAMA0 115200 version
esp32-ctl /dev/ttyAMA0 115200 status
esp32-ctl /dev/ttyAMA0 115200 sensor
```
