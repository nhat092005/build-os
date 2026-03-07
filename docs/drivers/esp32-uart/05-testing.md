# Testing: ESP32 UART

## Build Verification

```bash
make tools TOOLS=esp32-uart

file drivers/esp32-uart/build/tools/esp32-ctl
# Expected: ELF 64-bit LSB executable, ARM aarch64
```

## Functional Tests

### Test: connection and ping

```bash
esp32-ctl /dev/ttyAMA0 115200 ping
# Expected: PING OK
```

### Test: read data

```bash
esp32-ctl /dev/ttyAMA0 115200 status
# Expected: status variables populated with valid numbers

esp32-ctl /dev/ttyAMA0 115200 sensor
# Expected: realistic temperature/humidity/lux
```

### Test: control

```bash
esp32-ctl /dev/ttyAMA0 115200 led 0 1 255
# Expected: LED turns on (max brightness)
# Verify visually on hardware
```

## Error Cases

| Scenario                    | Expected behavior                           |
| --------------------------- | ------------------------------------------- |
| Device absent / wire cut    | `uart_send_cmd` timeout after N retries     |
| Baud rate mismatch          | CRC failures or framing errors              |
| Wrong tty device            | `esp32_open` fails: No such file or device  |
| Invalid parameters to `led` | Tool rejects invalid numbers before sending |
