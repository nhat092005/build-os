# BH1750 Ambient Light Sensor

BH1750 Ambient Light Sensor Driver (IIO)

Kernel driver for the ROHM BH1750 I2C ambient light sensor, exposing raw ADC
and processed lux measurements via the IIO (Industrial I/O) subsystem. Supports
three resolution modes, continuous measurement, runtime power management, and
one-time fallback mode.

## Stack

```
┌──────────────────────────────────┐
│ BH1750 (I2C, 0x23)               │ ← Hardware
└────────────┬─────────────────────┘
             │ I2C1 (GPIO2/3, 100 kHz)
┌────────────▼─────────────────────┐
│ bh1750.ko                        │ ← Kernel Driver
│ subsystem: IIO (indio_dev)       │
│ sysfs: /sys/bus/iio/devices/     │
│   iio:deviceX/                   │
│     in_illuminance_raw           │
│     in_illuminance_scale         │
│     in_illuminance_input (lux)   │
└──────────────────────────────────┘
```

## Components

| Component      | Present | Path                     |
| -------------- | ------- | ------------------------ |
| Kernel module  | Yes     | `src/bh1750.c`           |
| DTS overlay    | Yes     | `dts/bh1750-overlay.dts` |
| Public header  | Yes     | `include/bh1750.h`       |
| UAPI header    | No      | —                        |
| Userspace lib  | No      | —                        |
| Userspace tool | No      | —                        |

## Quick Start

```bash
make modules MODULE=bh1750
make dtbo    DTBO=bh1750
# On target:
modprobe bh1750
cat /sys/bus/iio/devices/iio:deviceX/in_illuminance_input
```

## File Map

| File                     | Description                                   |
| ------------------------ | --------------------------------------------- |
| `src/bh1750.c`           | IIO driver: continuous + one-time, PM runtime |
| `src/Kbuild`             | Kernel build file for bh1750.ko               |
| `include/bh1750.h`       | Internal header: commands, resolution modes   |
| `dts/bh1750-overlay.dts` | I2C1 overlay, address 0x23, 100 kHz           |
| `Makefile`               | Build orchestration (module + dtbo)           |
