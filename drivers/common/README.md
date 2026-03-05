# common

Shared userspace library directory. Not a kernel driver.

## Contents

### `libuart-transport/`

A portable UART framing library used by both `esp32-uart` and `stm32-uart`. Provides a lightweight binary framing protocol over serial ports.

**Frame format:**
```
+------+-----+-----+-----+---------+-------+
| SOF  | CMD | LEN | SEQ | PAYLOAD | CRC16 |
| 1B   | 1B  | 2B  | 1B  | N bytes | 2B    |
+------+-----+-----+-----+---------+-------+
```
- `SOF`: 0xAA (start of frame)
- `CMD`: command ID (ESP32: 0x01–0x7F, STM32: 0x80–0xFE)
- `LEN`: payload length, little-endian `uint16_t`, max 255
- `SEQ`: sequence number, echoed in response
- `CRC16`: CRC-16/CCITT-FALSE over SOF→PAYLOAD

**Public API** (`uart_transport.h`):
- `uart_transport_open(dev, baud)` — open serial port
- `uart_transport_send_cmd(t, cmd, payload, len)` — send framed command
- `uart_transport_recv(t, buf, len)` — receive and validate frame
- `uart_transport_close(t)` — close serial port

**Files:**
```
common/
└── libuart-transport/
    ├── Makefile
    ├── uart_transport.h    # Public API
    ├── uart_transport.c    # Transport implementation
    └── uart_crc.c          # CRC-16 implementation
```

## Usage

Drivers that use this library link against `build/libuart-transport.a` and include `uart_transport.h`. See `esp32-uart/` and `stm32-uart/` for usage examples.
