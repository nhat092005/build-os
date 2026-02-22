# gpio-rust

A safe Rust kernel module that demonstrates a "Mixed C-Rust" architecture applied to GPIO control. It uses a C wrapper (`gpio_helpers.c`) to bridge static inline kernel functions and expose a `miscdevice` (`/dev/gpio-rust`), while the Rust logic (`gpio_driver.rs`) safely manages the lifecycle and initialization via RAII.

This driver provides a full userspace `ioctl`, `read`, and `write` interface to control a GPIO LED, showing how Rust's strict memory and lifecycle safety (via the `Drop` trait) can interact with C-based system resources effortlessly.

## Directory Structure

```
gpio-rust/
├── Makefile
├── README.md
├── build/                      # Build output artifacts
├── dts/
│   └── gpio-rust-overlay.dts   # Device Tree overlay (optional)
├── include/
│   ├── gpio-rust.h             # Internal C header
│   └── uapi/
│       └── gpio-rust.h         # Userspace-kernel shared ioctl/flag definitions
├── src/
│   ├── Makefile                # Kbuild for compiling Rust into .ko
│   ├── gpio_driver.rs          # Main Rust driver logic & wrapper initialization
│   ├── gpio_helpers.c          # C inline function wrappers & miscdevice handler
│   └── gpio_rust.rs            # (Deprecated tech demo code)
└── userspace/
    ├── Makefile
    ├── lib/
    │   └── libgpio-rust/       # Userspace connection library
    └── tools/
        └── gpio-rust-ctl.c     # CLI tool
```

## Kernel Module

### Architecture
- **Layer 1 (C FFI)**: `gpio_helpers.c` provides non-inline functions (`rust_helper_gpio_*`) and handles the userspace interaction by creating `/dev/gpio-rust`.
- **Layer 2 (Safe Abstraction)**: `GpioPin` encapsulates the underlying raw integer ID and safely manages `request` and `free` operations.
- **Layer 3 (Module Logic)**: Manages initialization. On unload, Rust's `Drop` trait destroys the device node and frees the pin automatically without explicit manual cleanup code.

### Sysfs and Hardware Config
- Controls a single hardcoded LED pin (Default BCM hardware pin 22, offset 512 = sysfs GPIO pin 534).

### File Operations (`/dev/gpio-rust`)
- **read**: Return LED state as string.
- **write**: `"0"` or `"1"` to toggle standard state.
- **ioctl**: `SET_STATE`, `GET_STATE`, `TOGGLE`, `GET_GPIO`.

## Userspace Tool: gpio-rust-ctl

A command-line tool built to interface with `/dev/gpio-rust`. 

### Commands

```bash
gpio-rust-ctl status              # Show GPIO status
gpio-rust-ctl on                  # Turn LED on
gpio-rust-ctl off                 # Turn LED off
gpio-rust-ctl toggle              # Toggle LED state
gpio-rust-ctl blink <cnt> <ms>    # Blink LED a specific number of times
```

## Build

```bash
make modules   # Build the Rust kernel module (.ko)  
make tools     # Build the CLI application
make dtbo      # Optional: Compile DT overaly
make clean     # Clean all build outputs
```
