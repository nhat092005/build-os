# Common Libraries

Shared code used by multiple drivers.

## libuart-transport

UART framing protocol shared between `esp32-uart` and `stm32-uart` userspace tools.

### Frame Format

```
+------+-----+-----+-----+---------+-------+
| SOF  | CMD | LEN | SEQ | PAYLOAD | CRC16 |
| 1B   | 1B  | 2B  | 1B  | N bytes | 2B    |
+------+-----+-----+-----+---------+-------+
```

- SOF: `0xAA`
- CRC: CRC-16/CCITT-FALSE
- Max payload: 255 bytes
- Default baud: 115200

### Files

| File               | Purpose                                       |
| ------------------ | --------------------------------------------- |
| `uart_transport.h` | Public API                                    |
| `uart_transport.c` | UART I/O, framing, SOF sync, CRC, retry logic |
| `uart_crc.c`       | CRC-16 lookup table                           |

### Build

```bash
make -C drivers/common/libuart-transport clean all CC=aarch64-linux-gcc
```

**Important:** Must clean before cross-compile if previously built for host. Stale `.o` files cause ELF class mismatch.
