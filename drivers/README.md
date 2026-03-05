# Drivers

Out-of-tree kernel drivers and userspace tools for the Raspberry Pi 4 (BCM2711).

## Driver List

| Driver       | Type                | Interface | Description                                       |
| ------------ | ------------------- | --------- | ------------------------------------------------- |
| bh1750       | Kernel (IIO)        | I2C       | BH1750 ambient light sensor                       |
| ds3231-rtc   | Kernel (RTC+hwmon)  | I2C       | DS3231 real-time clock with temperature and alarm |
| esp32-uart   | Userspace only      | UART      | ESP32 communication tool                          |
| gpio-chardev | Kernel (chrdev)     | GPIO      | GPIO LED character device with ioctl              |
| gpio-inputs  | Kernel (input)      | GPIO      | GPIO button input device                          |
| gpio-leds    | Kernel (LED class)  | GPIO      | GPIO LED with LED subsystem                       |
| gpio-rust    | Kernel (misc, Rust) | GPIO      | Rust+C hybrid GPIO control                        |
| gpio-sysfs   | Userspace only      | sysfs     | GPIO control via deprecated sysfs interface       |
| sht3x        | Kernel (hwmon)      | I2C       | SHT3x temperature & humidity sensor               |
| stm32-uart   | Userspace only      | UART      | STM32 communication tool                          |

## Common Libraries

| Library           | Location                    | Used By                |
| ----------------- | --------------------------- | ---------------------- |
| libuart-transport | `common/libuart-transport/` | esp32-uart, stm32-uart |

## Build

```bash
make build                    # Build all (dtbo + modules + tools)
make modules MODULE=<name>    # Build specific module
make dtbo DTBO=<name>         # Build specific overlay
make tools TOOLS=<name>       # Build specific tool
```
