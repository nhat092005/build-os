# Userspace: GPIO Inputs

## CLI Tool: gpio-inputs-ctl

Event monitor for the gpio-inputs driver. Scans `/sys/class/input/` for
a device named `"gpio-inputs"`, opens the corresponding `/dev/input/eventX`,
and prints EV_KEY events (press/release).

### Usage

```
gpio-inputs-ctl [device_name]
```

Default device name: `"gpio-inputs"`. Press Ctrl+C to exit.

### Example

```bash
gpio-inputs-ctl
# Output:
#   Opening /dev/input/event0 (gpio-inputs)
#   Press Ctrl+C to exit
#
#   BTN_0        pressed
#   BTN_0        released
```

### Supported Key Codes

The tool maps common codes to names:
`BTN_0`, `BTN_1`, `BTN_2`, `BTN_3`, `BTN_SOUTH`, `BTN_EAST`,
`KEY_ENTER`, `KEY_1`, `KEY_2`, `KEY_SPACE`. Others: `KEY_<code>`.

### How It Works

1. Scans `/sys/class/input/event*/device/name` for matching name
2. Opens `/dev/input/eventX` (O_RDONLY)
3. Reads `struct input_event` in a loop
4. Filters for `ev.type == EV_KEY` (ignores EV_SYN)
5. Prints key name + "pressed" or "released"
6. SIGINT handler sets `running = 0` for clean exit

### No Library

Unlike other drivers, gpio-inputs-ctl directly reads from the Input
subsystem — no userspace library needed. The `/dev/input/eventX`
interface is standard Linux.
