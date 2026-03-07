# Hardware: STM32 UART

## Connection

| Signal | RPi4 Pin | BCM    | STM32 Pin | Notes             |
| ------ | -------- | ------ | --------- | ----------------- |
| TX     | Pin 8    | GPIO14 | RX        | RPi TX → STM32 RX |
| RX     | Pin 10   | GPIO15 | TX        | RPi RX → STM32 TX |
| GND    | Pin 6    | —      | GND       | Common ground     |

UART device: `/dev/ttyAMA0`
Default baud: 115200, 8N1 (8 data bits, no parity, 1 stop bit)

## Shared Bus

The RPi4 PL011 UART is used for this connection. If both ESP32 and STM32
are connected to the same UART pins on the Raspberry Pi, they must be
configured in a multi-drop setup (e.g., using RS-485 transceivers) to
prevent TX bus contention, or the RPi4 must use separate UART peripherals
(e.g., UART0 for ESP32, UART3 for STM32), but this project assumes
a shared command protocol space.

## Enable UART

```bash
# In /boot/config.txt:
enable_uart=1
dtoverlay=disable-bt          # free PL011 from Bluetooth
```
