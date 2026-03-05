# gpio-inputs — GPIO Button Input Driver

## Overview

| Field      | Value                                 |
| ---------- | ------------------------------------- |
| Module     | `gpio_inputs.ko`                      |
| Subsystem  | Linux Input (`input_register_device`) |
| GPIO       | GPIO12 (active low)                   |
| Compatible | `bos,gpio-inputs`                     |
| Device     | `/dev/input/event*`                   |
| DTS        | `gpio-inputs-overlay.dts`             |

## Build

```bash
make modules MODULE=gpio-inputs
make dtbo DTBO=gpio-inputs
make tools TOOLS=gpio-inputs
```

## DTS Configuration

```dts
gpio_inputs: gpio-inputs {
    compatible = "bos,gpio-inputs";
    gpios = <&gpio 12 1>;  /* GPIO12, active low */
};
```

## Usage

```bash
# Monitor button events
gpio-inputs-ctl

# Or use standard Linux input tools
evtest /dev/input/event*
```

## Features

- Supports multiple buttons via DTS `gpios` array
- Uses `gpiod_count()` + `struct_size()` flexible array
- Threaded IRQ for debouncing
