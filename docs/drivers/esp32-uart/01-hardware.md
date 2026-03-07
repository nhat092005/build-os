# Hardware: ESP32 UART

## Connection

| Signal | RPi4 Pin | BCM    | ESP32 Pin | Notes             |
| ------ | -------- | ------ | --------- | ----------------- |
| TX     | Pin 8    | GPIO14 | RX        | RPi TX → ESP32 RX |
| RX     | Pin 10   | GPIO15 | TX        | RPi RX → ESP32 TX |
| GND    | Pin 6    | —      | GND       | Common ground     |

UART device: `/dev/ttyAMA0`
Default baud: 115200, 8N1 (8 data bits, no parity, 1 stop bit)

> **Note:** The RPi4 UART mini UART (`/dev/ttyS0`) is NOT used.
> The PL011 UART (`/dev/ttyAMA0`) provides reliable timing.

## Enable UART

```bash
# In /boot/config.txt:
enable_uart=1
dtoverlay=disable-bt          # free PL011 from Bluetooth
```
