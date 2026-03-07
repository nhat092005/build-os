# TEST_PLAN.md — Verification & Test Plan

> How to verify correctness after any change.
> "Done" means ALL relevant checks in this file pass — not just "it compiles".

---

## CI Verification (automated)

```bash
# Local equivalent of ci.yml:
make ci-check
# This runs: kernel-prepare → dtbo → modules → tools → checkpatch
```

### Cross-compilation check

```bash
file drivers/*/build/module/*.ko
# Expected: ELF 64-bit LSB relocatable, ARM aarch64, version 1 (SYSV)

file drivers/*/build/tools/*
# Expected: ELF 64-bit LSB executable, ARM aarch64
```

---

## Per-Driver Test Plan

### bh1750

| Check              | Command                                                   | Expected                            |
| ------------------ | --------------------------------------------------------- | ----------------------------------- |
| Module loads       | `modprobe bh1750`                                         | dmesg: `Probing BH1750 driver v...` |
| IIO device appears | `ls /sys/bus/iio/devices/iio:device*`                     | Device present                      |
| Light reading      | `cat /sys/bus/iio/devices/iio:device*/in_illuminance_raw` | Integer value                       |
| Module unloads     | `rmmod bh1750`                                            | Clean, no errors in dmesg           |

### ds3231-rtc

| Check          | Command                                  | Expected                    |
| -------------- | ---------------------------------------- | --------------------------- |
| Module loads   | `modprobe ds3231-rtc`                    | dmesg: probe message        |
| RTC device     | `ls /dev/rtc0`                           | Present                     |
| Read time      | `hwclock -r -f /dev/rtc0`                | Plausible date/time         |
| Hwmon          | `ls /sys/class/hwmon/hwmon*/temp1_input` | Temperature in millidegrees |
| Alarm IRQ      | Check dmesg for alarm messages           | IRQ fires on GPIO4          |
| Module unloads | `rmmod ds3231-rtc`                       | Clean                       |

### gpio-chardev

| Check          | Command                  | Expected                 |
| -------------- | ------------------------ | ------------------------ |
| Module loads   | `modprobe gpio_chardev`  | dmesg: probe with GPIO21 |
| Device node    | `ls /dev/gpio_chardev`   | Present                  |
| LED on         | `gpio-chardev-ctl on`    | GPIO21 high              |
| LED off        | `gpio-chardev-ctl off`   | GPIO21 low               |
| Blink          | `gpio-chardev-ctl blink` | LED blinks               |
| Module unloads | `rmmod gpio_chardev`     | Clean                    |

### gpio-inputs

| Check          | Command                       | Expected                                      |
| -------------- | ----------------------------- | --------------------------------------------- |
| Module loads   | `modprobe gpio_inputs`        | dmesg: `gpio-inputs v...: probed 1 button(s)` |
| Input device   | `ls /dev/input/event*`        | New event device                              |
| Button press   | `gpio-inputs-ctl` or `evtest` | Key events on GPIO12 toggle                   |
| Module unloads | `rmmod gpio_inputs`           | Clean                                         |

### gpio-leds

| Check          | Command                                   | Expected                              |
| -------------- | ----------------------------------------- | ------------------------------------- |
| Module loads   | `modprobe gpio_leds`                      | dmesg: `Probing GPIO LED driver v...` |
| LED sysfs      | `ls /sys/class/leds/`                     | LED device appears                    |
| Brightness     | `echo 1 > /sys/class/leds/.../brightness` | GPIO20 high                           |
| Module unloads | `rmmod gpio_leds`                         | Clean                                 |

### gpio-rust

| Check          | Command                           | Expected                       |
| -------------- | --------------------------------- | ------------------------------ |
| Module loads   | `modprobe gpio_rust`              | dmesg: probe message           |
| Device node    | `ls /dev/gpio_rust`               | Present                        |
| GPIO control   | `gpio-rust-ctl`                   | Misc device responds           |
| Custom pin     | `insmod gpio_rust.ko gpio_pin=23` | Uses GPIO23 instead of default |
| Module unloads | `rmmod gpio_rust`                 | Clean                          |

### sht3x

| Check          | Command                                       | Expected                           |
| -------------- | --------------------------------------------- | ---------------------------------- |
| Module loads   | `modprobe sht3x`                              | dmesg: `Probing SHT3x driver v...` |
| Hwmon device   | `ls /sys/class/hwmon/hwmon*/`                 | Device present                     |
| Temperature    | `cat /sys/class/hwmon/hwmon*/temp1_input`     | Millidegrees Celsius               |
| Humidity       | `cat /sys/class/hwmon/hwmon*/humidity1_input` | Milli-percent                      |
| Module unloads | `rmmod sht3x`                                 | Clean                              |

### esp32-uart / stm32-uart (userspace only)

| Check       | Command                                         | Expected      |
| ----------- | ----------------------------------------------- | ------------- |
| Tool builds | `file drivers/esp32-uart/build/tools/esp32-ctl` | ELF aarch64   |
| Help output | `esp32-ctl --help`                              | Usage message |

### gpio-sysfs (userspace only)

| Check       | Command                                              | Expected      |
| ----------- | ---------------------------------------------------- | ------------- |
| Tool builds | `file drivers/gpio-sysfs/build/tools/gpio-sysfs-ctl` | ELF aarch64   |
| Help output | `gpio-sysfs-ctl --help`                              | Usage message |

---

## Deployment Verification

```bash
# After make deploy-sdcard:
# 1. Boot RPi with SD card
# 2. SSH in: ssh root@<ip>
# 3. Check kernel version:
uname -r    # Expected: 6.12.70-v8+

# 4. Check overlays loaded:
dmesg | grep -i overlay

# 5. Load and test each module:
modprobe gpio_chardev
modprobe gpio_leds
modprobe gpio_inputs
# etc.
```
