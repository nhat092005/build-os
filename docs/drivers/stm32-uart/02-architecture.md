# Architecture: STM32 UART

## Layer Diagram

```
┌───────────────────────────────────────────┐
│ stm32-ctl (CLI tool)                      │
│ Parses argv, dispatches to libstm32 API   │
├───────────────────────────────────────────┤
│ libstm32 (device library)                 │
│ stm32_open() / stm32_close()              │
│ stm32_ping() / stm32_get_version()        │
│ stm32_get_status() / stm32_reset()        │
│ stm32_set_gpio() / stm32_get_gpio()       │
│ stm32_get_adc() / stm32_set_pwm()         │
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

## Design Decisions

### Common Transport Protocol

The driver relies on `libuart-transport` which provides a robust frame-based
serial protocol. It handles SOF byte detection, payload length, sequence
numbers, and CRC16 verification automatically.

### Separation of Concerns

The STM32 commands focus heavily on low-level hardware control (GPIO pins,
ADC channels, PWM outputs), whereas the ESP32 driver handles higher-level
IoT concepts (WiFi RSSI, JSON config). This reflects their typical usage
in the project.
