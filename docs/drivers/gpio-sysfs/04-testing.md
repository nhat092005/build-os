# Testing: GPIO Sysfs

## Build Verification

```bash
make tools TOOLS=gpio-sysfs

# Verify
file drivers/gpio-sysfs/build/tools/gpio-sysfs-ctl
# Expected: ELF 64-bit LSB executable, ARM aarch64
```

## Functional Tests

### Test: export and set direction

```bash
gpio-sysfs-ctl export 21
# Expected: GPIO 21 (gpio533): Exported successfully

gpio-sysfs-ctl 21 set direction out
# Expected: GPIO 21: OUTPUT
```

### Test: set and read value

```bash
gpio-sysfs-ctl 21 set value 1
# Expected: GPIO 21: ON

gpio-sysfs-ctl 21 get value
# Expected: GPIO 21: value = ON
```

### Test: blink

```bash
gpio-sysfs-ctl 21 blink 5 500
# Expected: LED blinks 5 times with 500ms interval
```

### Test: info

```bash
gpio-sysfs-ctl 21 info
# Expected:
#   GPIO:       533
#   Direction:  OUTPUT
#   Edge:       NONE
#   Value:      1
#   Active Low: ACTIVE_HIGH
```

### Test: edge and active_low

```bash
gpio-sysfs-ctl 21 set edge rising
# Expected: GPIO 21: RISING

gpio-sysfs-ctl 21 set active_low 1
# Expected: GPIO 21: ACTIVE_LOW
```

### Test: list and unexport

```bash
gpio-sysfs-ctl list
# Expected: gpio533 (and any other exported GPIOs)

gpio-sysfs-ctl unexport 21
# Expected: GPIO 21 (gpio533): Unexported successfully
```

## Error Cases

| Scenario          | Expected behavior                                  |
| ----------------- | -------------------------------------------------- |
| Pin not exported  | `gpio_open`: "Failed to open GPIO: No such device" |
| Invalid pin       | `parse_int` error                                  |
| Permission denied | Need root privileges for export/unexport           |
