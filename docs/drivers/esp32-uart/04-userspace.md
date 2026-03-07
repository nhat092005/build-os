# Userspace: ESP32 UART

## Library: libesp32

Provides high-level C functions that construct payloads and use the
shared `libuart-transport` to send commands and receive responses.

### API

```c
esp32_dev_t *esp32_open(const char *dev, int baud);
void         esp32_close(esp32_dev_t *d);

int esp32_ping(esp32_dev_t *d);
int esp32_get_version(esp32_dev_t *d, char *buf, size_t len);
int esp32_get_status(esp32_dev_t *d, struct esp32_status *s);
int esp32_reset(esp32_dev_t *d);
int esp32_set_led(esp32_dev_t *d, const struct esp32_led *led);
int esp32_get_sensor(esp32_dev_t *d, struct esp32_sensor *s);
```

**`esp32_dev_t`** structure maintains the UART transport state (file descriptor,
timeouts, sequence numbers).

## CLI Tool: esp32-ctl

Command-line interface to the `libesp32` functions.

### Usage

```
esp32-ctl <device> <baud> <command> [args...]
```

Normally: `esp32-ctl /dev/ttyAMA0 115200 <command>`

### Commands

| Command   | Arguments               | Description                         |
| --------- | ----------------------- | ----------------------------------- |
| `ping`    | —                       | Checks if ESP32 is responsive       |
| `version` | —                       | Prints firmware version string      |
| `status`  | —                       | Prints uptime, heap, WiFi RSSI      |
| `reset`   | —                       | Triggers soft reset on ESP32        |
| `led`     | `<id> <state> <bright>` | Sets LED state (e.g. `led 0 1 255`) |
| `sensor`  | —                       | Reads temp, humidity, lux           |

### Examples

```bash
esp32-ctl /dev/ttyAMA0 115200 version
# Output: ESP32 Firmware v1.2.3

esp32-ctl /dev/ttyAMA0 115200 status
# Output:
#   State:  Running
#   Uptime: 3600 sec
#   Heap:   154000 bytes
#   WiFi:   -65 dBm

esp32-ctl /dev/ttyAMA0 115200 sensor
# Output:
#   Temp:   24.5 °C
#   Hum:    45.2 %
#   Light:  320 lux
```
