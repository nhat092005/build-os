# esp32-uart — ESP32 UART Communication Tool

## Overview

| Field     | Value                             |
| --------- | --------------------------------- |
| Type      | Userspace only (no kernel module) |
| Interface | UART (GPIO14 TX, GPIO15 RX)       |
| Library   | `common/libuart-transport`        |
| Tool      | `esp32-ctl`                       |

## Build

```bash
make tools TOOLS=esp32-uart
```

## Usage

```bash
esp32-ctl --help
```
