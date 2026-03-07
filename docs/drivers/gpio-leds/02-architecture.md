# Architecture: GPIO LEDs

## System Diagram

```
┌────────────────────────────────────────────────┐
│ HARDWARE                                       │
│ LED → BCM GPIO20 (active-high, 330Ω resistor)  │
└───────────────────┬────────────────────────────┘
                    │ gpiod_set_value / gpiod_get_value
┌───────────────────▼────────────────────────────┐
│ gpio_leds.ko                                   │
│                                                │
│ LED class subsystem:                           │
│   led_classdev.brightness_set_blocking()       │
│   → gpiod_set_value(desc, value)               │
│                                                │
│ /sys/class/leds/<label>/                       │
│   brightness (0/255), trigger, max_brightness  │
│   gpio_state (custom), gpio_pin (custom)       │
└────────────────────────────────────────────────┘
```

## Design Decisions

### Why LED class?

The LED class provides a standard interface for LED control:

- `brightness` (0 = off, max = on)
- `trigger` (none, heartbeat, timer, etc.)
- Compatible with `ledtrig-*` kernel modules

### Resource management

All devm\_\*:

- `devm_gpiod_get()` — GPIO descriptor
- `devm_led_classdev_register()` — LED class device
- No manual cleanup needed for GPIO or LED class on remove

### Power Management

- **Suspend:** Turn LED off (unless `retain-state-suspend` set in DTS)
- **Resume:** Restore previous brightness
