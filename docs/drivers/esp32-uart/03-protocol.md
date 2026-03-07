# Protocol: ESP32 UART

## Frame Format (libuart-transport)

```
┌──────┬─────┬──────┬─────┬───────────┬───────────┐
│ SOF  │ CMD │ LEN  │ SEQ │ PAYLOAD   │ CRC16     │
│ 0xAA │ 1B  │ 2B   │ 1B  │ 0–N bytes │ 2B CCITT  │
│      │     │ (LE) │     │           │ (LE)      │
└──────┴─────┴──────┴─────┴───────────┴───────────┘
```

| Field   | Size | Description                                 |
| ------- | ---- | ------------------------------------------- |
| SOF     | 1    | Start-of-frame marker: `0xAA`               |
| CMD     | 1    | Command ID (0x01–0x7F for ESP32)            |
| LEN     | 2    | Payload length, little-endian               |
| SEQ     | 1    | Sequence number (wraps 0–255)               |
| PAYLOAD | 0–N  | Command-specific data                       |
| CRC16   | 2    | CRC-16/CCITT-FALSE over CMD+LEN+SEQ+PAYLOAD |

## ESP32 Command Table

| CMD    | Name        | Request Payload     | Response Payload      |
| ------ | ----------- | ------------------- | --------------------- |
| `0x01` | PING        | —                   | —                     |
| `0x02` | GET_VERSION | —                   | version string (≤32B) |
| `0x03` | GET_STATUS  | —                   | `esp32_status` (8B)   |
| `0x04` | RESET       | —                   | —                     |
| `0x05` | SET_LED     | `esp32_led` (3B)    | —                     |
| `0x06` | GET_SENSOR  | —                   | `esp32_sensor` (6B)   |
| `0x07` | SET_CONFIG  | `esp32_config` (4B) | —                     |
| `0x08` | GET_CONFIG  | —                   | `esp32_config` (4B)   |
| `0x10` | OTA_BEGIN   | —                   | —                     |
| `0x11` | OTA_DATA    | raw chunk           | —                     |
| `0x12` | OTA_END     | —                   | —                     |

## Payload Structures

```c
struct esp32_status {     // 8 bytes
	uint8_t  state;       // 0=idle, 1=running, 2=error
	uint8_t  wifi_rssi;   // WiFi RSSI (signed)
	uint32_t uptime_sec;  // seconds since boot (LE)
	uint16_t free_heap;   // free heap bytes (LE)
};

struct esp32_led {        // 3 bytes
	uint8_t led_id;       // LED index 0–N
	uint8_t state;        // 0=off, 1=on
	uint8_t brightness;   // 0–255
};

struct esp32_sensor {     // 6 bytes
	int16_t  temperature; // centi-°C (LE)
	uint16_t humidity;    // centi-%RH (LE)
	uint16_t light_lux;   // lux (LE)
};

struct esp32_config {     // 4 bytes
	uint8_t  wifi_enabled;
	uint8_t  led_mode;    // 0=manual, 1=auto
	uint16_t poll_ms;     // sensor poll interval (LE)
};
```

## CRC-16

Algorithm: CRC-16/CCITT-FALSE

- Polynomial: 0x1021
- Initial: 0xFFFF
- No final XOR
- Computed over CMD + LEN + SEQ + PAYLOAD (excludes SOF)

## Error Handling

| Status Byte | Meaning           |
| ----------- | ----------------- |
| `0x00`      | OK                |
| `0x01`      | Unknown command   |
| `0x02`      | Invalid parameter |
| `0x03`      | Busy              |
| `0xFF`      | Internal error    |
