# Architecture: GPIO Inputs

## System Diagram

```
┌────────────────────────────────────────────────┐
│ HARDWARE                                       │
│ Buttons → BCM GPIOs (active-low, pull-up)      │
└───────────────────┬────────────────────────────┘
                    │ IRQ (rising + falling + ONESHOT)
┌───────────────────▼────────────────────────────┐
│ gpio_inputs.ko                                 │
│                                                │
│ Per button:                                    │
│   1. devm_gpiod_get_index() → GPIO desc       │
│   2. gpiod_to_irq() → IRQ number              │
│   3. devm_request_threaded_irq()               │
│   4. Try gpiod_set_debounce() (HW debounce)   │
│   5. Fallback: delayed_work (SW debounce 20ms) │
│                                                │
│ Input subsystem:                               │
│   input_report_key(EV_KEY, code, value)        │
│   input_sync()                                 │
│                                                │
│ /dev/input/eventX                              │
└────────────────────────────────────────────────┘
```

## Design Decisions

### Why Input subsystem?

Buttons generate discrete press/release events, making the Input subsystem
the natural fit. This gives us:

- Standard `/dev/input/eventX` interface
- Compatibility with `evtest`, `libinput`, `udev`
- Standardized key codes (`KEY_*`, `BTN_*`)

### Debounce Strategy

1. **Hardware debounce (preferred):** `gpiod_set_debounce(desc, 20000)` — 20ms
   - If the GPIO controller supports it, this is used first
2. **Software debounce (fallback):** `delayed_work` with 20ms delay
   - Used when `gpiod_set_debounce()` returns `-ENOSYS`

### Concurrency

- IRQ handler is a **threaded IRQ** (`IRQF_ONESHOT`) — runs in process context
- Software debounce uses `delayed_work` — scheduled by IRQ thread
- No explicit locking needed:
  - Hardware debounce: IRQ thread reads GPIO directly
  - Software debounce: only the work handler reads/reports
