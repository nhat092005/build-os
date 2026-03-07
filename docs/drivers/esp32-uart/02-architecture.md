# Architecture: ESP32 UART

## Layer Diagram

```
┌───────────────────────────────────────────┐
│ esp32-ctl (CLI tool)                      │
│ Parses argv, dispatches to libesp32 API   │
├───────────────────────────────────────────┤
│ libesp32 (device library)                 │
│ esp32_open() / esp32_close()              │
│ esp32_ping() / esp32_get_version()        │
│ esp32_get_status() / esp32_reset()        │
│ esp32_set_led() / esp32_get_sensor()      │
├───────────────────────────────────────────┤
│ libuart-transport (common library)        │
│ Frame assembly: SOF + CMD + LEN + SEQ +   │
│   PAYLOAD + CRC16                         │
│ SOF sync, CRC verify, timeout, retry      │
├───────────────────────────────────────────┤
│ /dev/ttyAMA0 (PL011 UART)                 │
│ 115200 8N1                                │
└───────────────────────────────────────────┘
```

## Shared Bus

ESP32 and STM32 can share one UART bus because command IDs don't overlap:

- ESP32: `0x01–0x7F`
- STM32: `0x80–0xFE`

Each MCU ignores commands outside its range.
