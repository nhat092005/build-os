# Testing: GPIO LEDs

## Build Verification

```bash
make modules MODULE=gpio-leds
make dtbo    DTBO=gpio-leds
make tools   TOOLS=gpio-leds

file drivers/gpio-leds/build/module/gpio_leds.ko
file drivers/gpio-leds/build/tools/gpio-leds-ctl
```

## Functional Tests

### Test: on/off

```bash
gpio-leds-ctl on     # LED turns on
gpio-leds-ctl off    # LED turns off
```

### Test: sysfs direct

```bash
echo 255 > /sys/class/leds/gpio-led/brightness  # ON
echo 0   > /sys/class/leds/gpio-led/brightness  # OFF
cat /sys/class/leds/gpio-led/gpio_state          # 0 or 1
cat /sys/class/leds/gpio-led/gpio_pin            # 532 (20+512)
```

### Test: trigger

```bash
gpio-leds-ctl trigger heartbeat   # LED blinks in heartbeat pattern
gpio-leds-ctl trigger none        # Stop
```

### Test: blink/pulse

```bash
gpio-leds-ctl blink 5 300         # 5 blinks, 300ms
gpio-leds-ctl pulse 2000 20       # 2s fade, 20 steps
```

## Unload

```bash
sudo rmmod gpio_leds
# Expected: gpio-leds gpio-leds: GPIO LED driver removed
```
