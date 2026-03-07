# Kernel Driver: DS3231 RTC

## Module Registration

```c
module_i2c_driver(ds3231_driver);
```

**Driver ID tables:**

```c
static const struct of_device_id ds3231_of_match[] = {
	{ .compatible = "maxim,ds3231" },
	{ }
};
```

## Register Map

| Register | Addr      | Purpose                    |
| -------- | --------- | -------------------------- |
| Seconds  | 0x00      | BCD 00-59                  |
| Minutes  | 0x01      | BCD 00-59                  |
| Hours    | 0x02      | BCD 00-23 (24h enforced)   |
| Day      | 0x03      | 1-7 weekday                |
| Date     | 0x04      | BCD 01-31                  |
| Month    | 0x05      | BCD 01-12, bit7=century    |
| Year     | 0x06      | BCD 00-99                  |
| Alarm 1  | 0x07-0x0A | Second-level alarm         |
| Control  | 0x0E      | INTCN, BBSQW, A1IE, A2IE   |
| Status   | 0x0F      | OSF, BSY, A1F, A2F         |
| Temp MSB | 0x11      | Signed integer °C          |
| Temp LSB | 0x12      | bits 7:6 = 0.25°C fraction |

## probe()

1. Allocate `struct ds3231_data` (devm)
2. Verify chip: read status register
3. Init control: `INTCN=1`, enable `BBSQW` if IRQ wired
4. Detect/convert 12h → 24h mode
5. Check OSF (Oscillator Stop Flag) → warn if set
6. `devm_rtc_allocate_device()` + set ops + `devm_rtc_register_device()`
7. `devm_request_threaded_irq()` for alarm (if DT wires interrupt)
8. `devm_hwmon_device_register_with_info()` for temperature

## RTC Operations

| Op                 | ioctl            | Description                   |
| ------------------ | ---------------- | ----------------------------- |
| `read_time`        | `RTC_RD_TIME`    | 7-byte block read, BCD→binary |
| `set_time`         | `RTC_SET_TIME`   | binary→BCD, 7-byte write      |
| `read_alarm`       | `RTC_WKALM_RD`   | Alarm 1 registers + enabled   |
| `set_alarm`        | `RTC_WKALM_SET`  | Write Alarm 1 + clear A1F     |
| `alarm_irq_enable` | `RTC_AIE_ON/OFF` | Enable/disable A1IE           |

## Kbuild

```makefile
obj-m += ds3231-rtc.o
```
