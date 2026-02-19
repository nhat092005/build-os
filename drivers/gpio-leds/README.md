# gpio-leds

A Linux kernel platform driver that controls GPIO-based LEDs through the standard LED class subsystem. Devices are configured via Device Tree and exposed through the sysfs interface at `/sys/class/leds/<led-name>/`.

## Directory Structure

```
gpio-leds/
├── Makefile
├── docs/
│   └── device-tree-binding.yaml    # DT binding documentation
├── dts/
│   ├── Makefile
│   └── gpio-leds-overlay.dts       # Device Tree overlay for Raspberry Pi
├── include/
│   ├── gpio-leds.h                 # Internal kernel header (device struct)
│   └── uapi/
│       └── gpio-leds.h             # User-kernel shared header (LED state constants)
├── src/
│   ├── Makefile
│   └── gpio-leds.c                 # Kernel module source
└── userspace/
    ├── Makefile
    ├── lib/
    │   └── libled/
    │       ├── libled.c            # LED control library (sysfs-based)
    │       └── libled.h            # Library API header
    └── tools/
        └── gpio-led-ctl.c          # Command-line tool using libled
```

## Kernel Module

### Device Tree Matching

The driver matches devices with compatible string `"custom,gpio-led"`. It uses `module_platform_driver` for registration.

### Probe Sequence

When a matching device is found, the probe function:

1. Parses Device Tree properties (label, default-trigger, default-state, active-low, retain-state-suspended).
2. Requests the GPIO descriptor from Device Tree using `devm_gpiod_get`.
3. Sets GPIO direction to output with the configured initial state.
4. Registers a `led_classdev` with the LED subsystem using `devm_led_classdev_register`.

### Device Tree Properties

| Property                 | Required | Description                                                       |
| ------------------------ | -------- | ----------------------------------------------------------------- |
| `compatible`             | Yes      | Must be `"custom,gpio-led"`                                       |
| `gpios`                  | Yes      | GPIO specifier for the LED pin                                    |
| `label`                  | No       | LED name in sysfs (defaults to device name)                       |
| `linux,default-trigger`  | No       | Initial trigger (e.g., `"none"`, `"heartbeat"`, `"timer"`)        |
| `default-state`          | No       | Initial state: `"on"`, `"off"`, or `"keep"` (defaults to `"off"`) |
| `active-low`             | No       | Boolean; inverts GPIO logic                                       |
| `retain-state-suspended` | No       | Boolean; preserves LED state across suspend/resume                |

### LED Operations

- **brightness_set_blocking**: Sets GPIO value based on brightness (0 = off, >0 = on). Handles active-low inversion and sleep-capable GPIOs.
- **brightness_get**: Reads current GPIO value and returns `LED_OFF` or `LED_FULL`.

### Power Management

The driver implements suspend and resume callbacks via `SIMPLE_DEV_PM_OPS`:

- **Suspend**: Turns off the LED unless `retain-state-suspended` is set.
- **Resume**: Restores the previous brightness unless `retain-state-suspended` is set.

## Device Tree Overlay

The file `dts/gpio-leds-overlay.dts` provides an overlay for Raspberry Pi (BCM2711/BCM2835). It configures GPIO27 as an output pin and creates a `custom,gpio-led` device with label `"custom-led"`.

### Runtime Override Parameters

The overlay supports runtime overrides via `__overrides__`:

| Parameter      | Description                   |
| -------------- | ----------------------------- |
| `gpio`         | Change GPIO pin number        |
| `label`        | Change LED label              |
| `trigger`      | Change default trigger        |
| `active_low`   | Enable active-low mode        |
| `retain_state` | Enable retain-state-suspended |

## Userspace Library: libled

A C library for controlling Linux LED class devices through sysfs. Located in `userspace/lib/libled/`.

### API

| Function                 | Description                                                                   |
| ------------------------ | ----------------------------------------------------------------------------- |
| `led_open`               | Open an LED device by name under `/sys/class/leds/`                           |
| `led_close`              | Close LED device handle                                                       |
| `led_set_brightness`     | Write a brightness value                                                      |
| `led_get_brightness`     | Read current brightness                                                       |
| `led_get_max_brightness` | Read maximum brightness                                                       |
| `led_on`                 | Set brightness to maximum                                                     |
| `led_off`                | Set brightness to 0                                                           |
| `led_set_trigger`        | Write to the trigger sysfs attribute                                          |
| `led_get_trigger`        | Read current trigger                                                          |
| `led_set_timer`          | Activate the `"timer"` trigger and set delay_on/delay_off                     |
| `led_blink`              | Manual blink loop (sets trigger to `"none"`, toggles brightness in userspace) |
| `led_pulse`              | Fade in/out effect by stepping through brightness values                      |
| `led_list`               | Enumerate LED devices in `/sys/class/leds/` via callback                      |
| `led_get_info`           | Retrieve name, brightness, max brightness, and trigger                        |
| `led_exists`             | Check if a named LED device exists                                            |
| `led_strerror`           | Convert error code to string                                                  |

All functions return 0 on success or a negative errno value on failure.

## Userspace Tool: gpio-led-ctl

A command-line tool built on top of `libled`. Default LED device name is `"custom-led"`.

### Options

| Option              | Description                             |
| ------------------- | --------------------------------------- |
| `-d, --device NAME` | LED device name (default: `custom-led`) |
| `-v, --verbose`     | Enable verbose output                   |
| `-h, --help`        | Show help                               |

### Commands

```
gpio-led-ctl on                                # Turn LED on
gpio-led-ctl off                               # Turn LED off
gpio-led-ctl set <brightness>                  # Set brightness (0 to max)
gpio-led-ctl get                               # Get current brightness
gpio-led-ctl trigger [name]                    # Get or set trigger
gpio-led-ctl blink [count] [delay_ms]          # Blink (default: 10 times, 500ms)
gpio-led-ctl timer [on_ms] [off_ms]            # Set timer trigger (default: 500/500ms)
gpio-led-ctl pulse [duration_ms] [steps]       # Fade in/out (default: 3000ms, 50 steps)
gpio-led-ctl list                              # List available LED devices
gpio-led-ctl info                              # Show LED device information
```

## Build

```
make all             # Build device tree overlay, kernel module, and userspace tools
make dtbo            # Build device tree overlay only
make modules         # Build kernel module only
make tools           # Build userspace tool and library only
make clean           # Clean all build artifacts
```
