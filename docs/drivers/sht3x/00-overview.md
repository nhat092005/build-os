# SHT3x Temperature & Humidity Sensor

SHT3x Temperature & Humidity Sensor Driver

Kernel driver for the Sensirion SHT30/SHT31/SHT35 I2C sensor, exposing
temperature and humidity as standard Linux hwmon attributes. Supports
single-shot and periodic measurement modes with CRC-8 integrity checks.

## Stack

```
┌──────────────────────────────────┐
│ SHT3x (I2C, 0x44)                │ ← Hardware
└────────────┬─────────────────────┘
             │ I2C1 (GPIO2/3, 100 kHz)
┌────────────▼─────────────────────┐
│ sht3x.ko                         │ ← Kernel Driver
│ subsystem: hwmon                 │
│ sysfs: /sys/class/hwmon/hwmonX/  │
│   temp1_input   (milli-°C)      │
│   humidity1_input (milli-%RH)    │
│   heater_enable (0/1)           │
└──────────────────────────────────┘
```

## Components

| Component      | Present | Path                    |
| -------------- | ------- | ----------------------- |
| Kernel module  | Yes     | `src/sht3x.c`           |
| DTS overlay    | Yes     | `dts/sht3x-overlay.dts` |
| Public header  | No      | —                       |
| UAPI header    | No      | —                       |
| Userspace lib  | No      | —                       |
| Userspace tool | No      | —                       |

## Quick Start

```bash
make modules MODULE=sht3x
make dtbo    DTBO=sht3x
# On target:
modprobe sht3x
cat /sys/class/hwmon/hwmonX/temp1_input
cat /sys/class/hwmon/hwmonX/humidity1_input
```

## File Map

| File                    | Description                                      |
| ----------------------- | ------------------------------------------------ |
| `src/sht3x.c`           | hwmon driver: I2C, CRC-8, periodic + single-shot |
| `src/Kbuild`            | Kernel build file for sht3x.ko                   |
| `dts/sht3x-overlay.dts` | I2C1 overlay, address 0x44, 100 kHz              |
| `Makefile`              | Build orchestration (module + dtbo)              |
| `README.md`             | Driver summary                                   |
