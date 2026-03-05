# stm32-uart — STM32 UART Communication Tool

## Overview

| Field     | Value                             |
| --------- | --------------------------------- |
| Type      | Userspace only (no kernel module) |
| Interface | UART (GPIO14 TX, GPIO15 RX)       |
| Library   | `common/libuart-transport`        |
| Tool      | `stm32-ctl`                       |

## Build

```bash
make tools TOOLS=stm32-uart
```

## Usage

```bash
stm32-ctl --help
```
