# gpio-inputs

A Linux kernel input subsystem driver for GPIO push buttons. Reports button press and release as `EV_KEY` events on `/dev/input/eventX`.

## Hardware

| Signal | RPi Pin | GPIO   | Description                       |
| ------ | ------- | ------ | --------------------------------- |
| BTN0   | 32      | GPIO12 | Push button, active-low (pull-up) |
| GND    | 34      | —      | Button pull-down terminal         |

Default DT overlay binds one button to GPIO12 with `GPIO_ACTIVE_LOW` polarity and key code `BTN_0` (0x100).

## Kernel Subsystem

- `platform_driver` + `input_dev` + threaded IRQ
- `compatible = "bos,gpio-inputs"` in DTS
- IRQ-driven: `IRQF_TRIGGER_RISING | IRQF_TRIGGER_FALLING` (not `IRQF_TRIGGER_BOTH` — not defined in kernel 6.12)
- Software debounce: 20 ms `delayed_work` fallback if hardware debounce unavailable
- Suspend/resume: IRQ disabled on suspend, re-enabled and state refreshed on resume

## Directory Structure

```
gpio-inputs/
├── Makefile
├── include/
│   └── gpio_inputs.h
├── dts/
│   ├── Makefile
│   └── gpio-inputs-overlay.dts
├── src/
│   ├── Kbuild
│   ├── Makefile
│   └── gpio_inputs.c
└── userspace/
    ├── Makefile
    └── tools/
        └── gpio-inputs-test.c
```

## Quick Start

```bash
# Build
make modules DRIVER=gpio-inputs
make dtbo DTBO=gpio-inputs
make tools DRIVER=gpio-inputs

# Install
make install-modules
make install-overlays
make install-tools
sudo make deploy-sdcard DEVICE=/dev/sdX
```

Add to `/boot/config.txt`:
```
dtoverlay=gpio-inputs
```

## Verify on Target

```bash
dmesg | grep gpio-inputs       # expect: probe success, input device registered
ls /dev/input/                 # new eventX device appears
evtest /dev/input/eventX       # press button on GPIO12 — expect EV_KEY BTN_0
# Or use the test tool:
gpio-inputs-test /dev/input/eventX
```
