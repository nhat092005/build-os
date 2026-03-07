# Testing: SHT3x

## Build Verification

```bash
# Build
make modules MODULE=sht3x
make dtbo    DTBO=sht3x

# Verify cross-compilation
file drivers/sht3x/build/module/sht3x.ko
# Expected: ELF 64-bit LSB relocatable, ARM aarch64, version 1 (SYSV), not stripped
```

## On-Target Setup

```bash
# 1. Enable overlay
# Add to /boot/config.txt:
#   dtparam=i2c_arm=on
#   dtoverlay=sht3x
reboot

# 2. Copy module to target
scp drivers/sht3x/build/module/sht3x.ko pi@<ip>:~

# 3. Load module
sudo insmod sht3x.ko

# 4. Verify load
dmesg | tail -5
# Expected:
#   sht3x 1-0044: Probing SHT3x driver v1.0.0
#   sht3x 1-0044: SHT3x sensor registered at 0x44

# 5. Check hwmon sysfs
ls /sys/class/hwmon/
# Expected: hwmonX directory (find the SHT3x one)
cat /sys/class/hwmon/hwmonX/name
# Expected: sht3x
```

## Functional Tests

### Test: read temperature

```bash
cat /sys/class/hwmon/hwmonX/temp1_input
# Expected: integer value in milli-°C (e.g. 25340 = 25.34 °C)
# Range: -40000 to 125000
```

### Test: read humidity

```bash
cat /sys/class/hwmon/hwmonX/humidity1_input
# Expected: integer value in milli-%RH (e.g. 45200 = 45.2 %RH)
# Range: 0 to 100000
```

### Test: read labels

```bash
cat /sys/class/hwmon/hwmonX/temp1_label
# Expected: SHT3x Temperature

cat /sys/class/hwmon/hwmonX/humidity1_label
# Expected: SHT3x Humidity
```

### Test: heater control

```bash
# Read current heater state
cat /sys/class/hwmon/hwmonX/heater_enable
# Expected: 0

# Enable heater
echo 1 > /sys/class/hwmon/hwmonX/heater_enable
cat /sys/class/hwmon/hwmonX/heater_enable
# Expected: 1

# Disable heater (IMPORTANT: do not leave on >30 seconds)
echo 0 > /sys/class/hwmon/hwmonX/heater_enable
cat /sys/class/hwmon/hwmonX/heater_enable
# Expected: 0
```

### Test: repeated reads (periodic mode)

```bash
# Read 5 times with 1-second intervals — should return slightly different values
for i in $(seq 1 5); do
    cat /sys/class/hwmon/hwmonX/temp1_input
    sleep 1
done
# Expected: values within ~100 milli-°C of each other (measurement noise)
```

## sysfs / procfs Verification

```bash
# Check module is loaded
lsmod | grep sht3x
cat /proc/modules | grep sht3x

# Check hwmon entries
ls /sys/class/hwmon/hwmonX/
# Expected files include:
#   temp1_input humidity1_input temp1_label humidity1_label
#   heater_enable name

# Verify module info
modinfo sht3x.ko
# Expected: description = "SHT3x Temperature & Humidity Sensor Driver"
```

## Error Cases

| Scenario             | How to trigger              | Expected behavior                      |
| -------------------- | --------------------------- | -------------------------------------- |
| Device not connected | Remove I2C wiring           | probe fails: "I2C send cmd ... failed" |
| Wrong I2C address    | Use addr=0x45 w/o ADDR HIGH | probe fails: no response on I2C        |
| I2C bus not enabled  | Omit dtparam=i2c_arm=on     | No probe attempt: bus not present      |
| CRC failure          | Corrupted data              | "CRC mismatch on temperature/humidity" |
| Heater timeout       | Leave heater on >30s        | WARN_ON_ONCE in kernel log             |

## Unload

```bash
sudo rmmod sht3x
dmesg | tail -3
# Expected: sht3x 1-0044: SHT3x sensor removed

ls /sys/class/hwmon/hwmonX/
# Expected: directory gone (No such file or directory)
```
