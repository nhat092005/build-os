# Testing: DS3231 RTC

## Build Verification

```bash
make modules MODULE=ds3231-rtc
make dtbo    DTBO=ds3231-rtc
make tools   TOOLS=ds3231-rtc
```

## Functional Tests

```bash
sudo insmod ds3231-rtc.ko
# Expected: DS3231 registered as rtc0

# Read time
ds3231-rtc-ctl read
hwclock -r -f /dev/rtc0

# Set time
ds3231-rtc-ctl set 2026-03-06 14:00:00

# Read temperature
ds3231-rtc-ctl temp
cat /sys/class/hwmon/hwmonN/temp1_input

# Alarm
ds3231-rtc-ctl alarm-set 06 15:00:00
ds3231-rtc-ctl alarm-read
ds3231-rtc-ctl alarm-on
# Wait for alarm → dmesg shows IRQ fired
ds3231-rtc-ctl alarm-off

sudo rmmod ds3231-rtc
```

## Error Cases

| Scenario               | Expected behavior                                         |
| ---------------------- | --------------------------------------------------------- |
| OSF set (battery dead) | `read` returns: "time not valid (oscillator was stopped)" |
| I2C not connected      | probe fails                                               |
| No SQW wired           | Alarm works but no IRQ notification                       |
