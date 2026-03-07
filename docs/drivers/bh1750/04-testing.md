# Testing: BH1750

## Build Verification

```bash
# Build
make modules MODULE=bh1750
make dtbo    DTBO=bh1750

# Verify cross-compilation
file drivers/bh1750/build/module/bh1750.ko
# Expected: ELF 64-bit LSB relocatable, ARM aarch64, version 1 (SYSV), not stripped
```

## On-Target Setup

```bash
# 1. Enable overlay (add to /boot/config.txt)
#   dtparam=i2c_arm=on
#   dtoverlay=bh1750
reboot

# 2. Load module
sudo insmod bh1750.ko

# 3. Verify load
dmesg | tail -5
# Expected:
#   bh1750 1-0023: Probing BH1750 driver v1.0.0
#   bh1750 1-0023: BH1750 sensor registered at 0x23 (resolution=0)

# 4. Find IIO device
ls /sys/bus/iio/devices/
# Expected: iio:deviceX
cat /sys/bus/iio/devices/iio:deviceX/name
# Expected: bh1750
```

## Functional Tests

### Test: read raw value

```bash
cat /sys/bus/iio/devices/iio:deviceX/in_illuminance_raw
# Expected: integer 0-65535 (ADC counts)
```

### Test: read scale factor

```bash
cat /sys/bus/iio/devices/iio:deviceX/in_illuminance_scale
# Expected: "0.833333" (H-res) or "0.416667" (H-res2)
```

### Test: read processed lux

```bash
cat /sys/bus/iio/devices/iio:deviceX/in_illuminance_input
# Expected: integer in milli-lux (e.g. 25000 = 25 lux)
```

### Test: resolution module parameter

```bash
# Load with high-resolution mode 2 (0.5 lux)
sudo insmod bh1750.ko resolution=1

# Verify
cat /sys/module/bh1750/parameters/resolution
# Expected: 1
```

## sysfs / procfs Verification

```bash
lsmod | grep bh1750

# Check IIO device
ls /sys/bus/iio/devices/iio:deviceX/
# Expected files include:
#   in_illuminance_raw in_illuminance_scale in_illuminance_input name

modinfo bh1750.ko
# Expected: description = "BH1750 Ambient Light Sensor Driver (IIO)"
```

## Error Cases

| Scenario             | How to trigger        | Expected behavior                 |
| -------------------- | --------------------- | --------------------------------- |
| Device not connected | Remove I2C wiring     | probe fails: "Failed to power on" |
| Wrong I2C address    | Use addr=0x5c w/o pin | probe fails: no response on I2C   |
| Invalid resolution   | `resolution=5`        | WARNING + default to H-res (0)    |

## Unload

```bash
sudo rmmod bh1750
dmesg | tail -3
# Expected: bh1750 1-0023: BH1750 sensor removed

ls /sys/bus/iio/devices/iio:deviceX/
# Expected: No such file or directory
```
