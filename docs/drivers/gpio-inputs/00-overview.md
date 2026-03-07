# GPIO Inputs

## Hardware: Inputs

Kernel driver and userspace tool for handling GPIO input buttons. Uses
threaded IRQs and software debouncing inside the kernel, exposed
via the input subsystem (`/dev/input/eventX`).

## Stack

```
┌──────────────────────────────────┐
│ Button (GPIO 12, pull-up)        │ ← Hardware
└────────────┬─────────────────────┘
             │ IRQ on falling/rising edge
┌────────────▼─────────────────────┐
│ gpio_inputs.ko                   │ ← Kernel Driver
│ subsystem: input                 │
│ /dev/input/eventX (EV_KEY)       │
└────────────┬─────────────────────┘
             │ /dev/input/event* events
┌────────────▼─────────────────────┐
│ gpio-inputs-ctl                  │ ← Userspace tool
│ Monitors and decodes EV_KEY      │
└──────────────────────────────────┘
```

## Components

| Component      | Present | Path                                |
| -------------- | ------- | ----------------------------------- |
| Kernel module  | Yes     | `src/gpio_inputs.c`                 |
| DTS overlay    | Yes     | `dts/gpio-inputs-overlay.dts`       |
| Userspace tool | Yes     | `userspace/tools/gpio-inputs-ctl.c` |
