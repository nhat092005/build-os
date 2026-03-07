# Userspace: DS3231 RTC

## CLI Tool: ds3231-rtc-ctl

Control tool using standard Linux RTC ioctls + hwmon sysfs for temperature.
Auto-detects `/dev/rtcN` by scanning `/sys/class/rtc/*/name` for `"ds3231-rtc"`.

### Usage

```
ds3231-rtc-ctl read                        Read current time
ds3231-rtc-ctl set YYYY-MM-DD HH:MM:SS    Set time
ds3231-rtc-ctl temp                        Read chip temperature
ds3231-rtc-ctl alarm-read                  Read alarm 1 setting
ds3231-rtc-ctl alarm-set DD HH:MM:SS      Set alarm 1
ds3231-rtc-ctl alarm-on                    Enable alarm IRQ
ds3231-rtc-ctl alarm-off                   Disable alarm IRQ
ds3231-rtc-ctl info                        Show driver info
```

### Examples

```bash
ds3231-rtc-ctl read
# Output: 2026-03-06 13:45:30 (Thu)

ds3231-rtc-ctl set 2026-03-06 14:00:00
# Output: Time set: 2026-03-06 14:00:00 (Thu)

ds3231-rtc-ctl temp
# Output: 25.25 °C

ds3231-rtc-ctl alarm-set 07 06:30:00
# Output: Alarm 1 set: day=07 06:30:00 (enabled)

ds3231-rtc-ctl alarm-read
# Output: Alarm 1: day=07 06:30:00  enabled=yes  pending=no

ds3231-rtc-ctl info
# Output: DS3231 RTC Driver — Information
#   Device:        /dev/rtc0
#   Driver:        ds3231-rtc (maxim,ds3231)
#   Bus:           I2C1 @ address 0x68
#   ...
```

### Standard hwclock Integration

```bash
hwclock -r                    # Read RTC
hwclock -w                    # Write system time to RTC
hwclock -s                    # Set system clock from RTC
hwclock --verbose             # Diagnostics
```

### Weekday Computation

The `set` command uses the Tomohiko Sakamoto algorithm to compute
weekday from date — no `mktime()`, no timezone dependency.
