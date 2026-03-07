# Architecture: DS3231 RTC

## System Diagram

```
┌──────────────────────────────────────────────┐
│ DS3231 (I2C, 0x68) + CR2032 battery          │
│ Temp sensor + RTC + Alarm 1 + SQW/INT        │
└──────────┬──────────────────┬────────────────┘
           │ I2C              │ SQW/INT → GPIO4
┌──────────▼──────────────────▼────────────────┐
│ ds3231-rtc.ko                                │
│                                              │
│ RTC subsystem:                               │
│   /dev/rtcN — read_time, set_time, alarm     │
│   Standard RTC ioctls (RTC_RD_TIME, etc.)    │
│                                              │
│ hwmon subsystem:                             │
│   /sys/class/hwmon/hwmonN/temp1_input        │
│   (milli-°C from on-chip temperature)        │
│                                              │
│ Alarm IRQ: threaded IRQ on GPIO4             │
│   → clears A1F flag → rtc_update_irq()       │
└──────────────────────────────────────────────┘
```

## Key Design Decisions

- **24-hour mode enforced:** Detects 12h mode in probe, converts to 24h
- **OSF detection:** On probe, if `OSF` set → `WARN` + time reads return `-ENODATA`
- **I2C block transfers:** 7-byte block read/write for time, 4-byte for alarm
- **BCD ↔ binary:** All time registers are BCD; driver converts both directions
- **hwmon registration:** Separate from RTC, reports chip junction temperature
