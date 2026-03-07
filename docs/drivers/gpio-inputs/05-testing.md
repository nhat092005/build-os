# Testing: GPIO Inputs

## Build Verification

```bash
make modules MODULE=gpio-inputs
make dtbo    DTBO=gpio-inputs
make tools   TOOLS=gpio-inputs

file drivers/gpio-inputs/build/module/gpio_inputs.ko
# Expected: ELF 64-bit LSB relocatable, ARM aarch64
file drivers/gpio-inputs/build/tools/gpio-inputs-ctl
# Expected: ELF 64-bit LSB executable, ARM aarch64
```

## On-Target Setup

```bash
# Add to /boot/config.txt:
#   dtoverlay=gpio-inputs
sudo insmod gpio_inputs.ko

dmesg | grep gpio-inputs
# Expected:
#   gpio-inputs gpio-inputs: Probing GPIO inputs driver v1.0.0
#   gpio-inputs gpio-inputs: GPIO inputs driver registered with 1 button(s)
```

## Functional Tests

### Test: button press detection

```bash
gpio-inputs-ctl
# Press and release the button connected to GPIO12
# Expected output:
#   BTN_0        pressed
#   BTN_0        released
```

### Test: evtest (alternative)

```bash
evtest /dev/input/eventX
# Press button
# Expected:
#   Event: type 1 (EV_KEY), code 256 (BTN_0), value 1
#   Event: type 1 (EV_KEY), code 256 (BTN_0), value 0
```

### Test: debounce

Press button rapidly — should not produce spurious events.
20ms debounce window filters mechanical bounce.

## Error Cases

| Scenario          | Expected behavior                                 |
| ----------------- | ------------------------------------------------- |
| No button wired   | Module loads, no events generated                 |
| Wrong GPIO in DTS | IRQ fires but no physical correlation             |
| Module not loaded | gpio-inputs-ctl: "Device 'gpio-inputs' not found" |

## Unload

```bash
sudo rmmod gpio_inputs
dmesg | tail -2
# Expected: gpio-inputs gpio-inputs: GPIO inputs driver removed
```
