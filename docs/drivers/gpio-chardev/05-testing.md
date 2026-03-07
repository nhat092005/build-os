# Testing: GPIO Chardev

## Build Verification

```bash
make modules MODULE=gpio-chardev
make dtbo    DTBO=gpio-chardev
make tools   TOOLS=gpio-chardev
```

## Functional Tests

```bash
sudo insmod gpio_chardev.ko
# Expected: gpio-chardev gpio-chardev: device /dev/gpio-chardev created (GPIO21)

# read/write interface
cat /dev/gpio-chardev           # "0"
echo 1 > /dev/gpio-chardev      # Turn on
echo 0 > /dev/gpio-chardev      # Turn off

# ioctl via tool
gpio-chardev-ctl on
gpio-chardev-ctl get
gpio-chardev-ctl toggle
gpio-chardev-ctl blink 3 500 500

sudo rmmod gpio_chardev
```

## Error Cases

| Scenario          | Expected behavior                      |
| ----------------- | -------------------------------------- |
| Module not loaded | open() fails: "No such device"         |
| Invalid ioctl     | Returns -ENOTTY                        |
| Concurrent access | Mutex serializes — second caller waits |
