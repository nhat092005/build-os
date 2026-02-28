# gpio-rust

A safe Rust kernel module that demonstrates a **4-layer mixed C-Rust architecture** for GPIO control on Linux kernel 6.12. Rust controls all GPIO logic (initialization, runtime operations, and cleanup) while C provides the thinnest possible glue layer for `miscdevice` registration and `static inline` GPIO function wrappers.

This driver exposes a full userspace `ioctl`, `read`, and `write` interface via `/dev/gpio-rust` to control a GPIO LED, showcasing how Rust's strict memory and lifecycle safety (via the `Drop` trait and atomic state) can govern all hardware operations even when kernel 6.12 does not yet provide native Rust abstractions for `miscdevice` or `file_operations`.

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
│   ├── Kbuild                  # Kbuild: links gpio_helpers.o + gpio_driver.o
│   ├── Makefile                # Build configuration for kernel module
│   ├── gpio_driver.rs          # Rust: RAII lifecycle + Layer 4 runtime handlers
│   └── gpio_helpers.c          # C: GPIO API wrappers + thin miscdevice shim
└── userspace/
    ├── Makefile
    ├── lib/
    │   └── libgpio-rust/       # Userspace connection library
    └── tools/
        └── gpio-rust-ctl.c     # CLI tool
```

## Kernel Module

### Architecture
- **Layer 1 (C FFI)**: `extern "C"` declarations in Rust for the C helper wrappers.
- **Layer 2 (Safe Abstraction)**: `GpioPin` — RAII wrapper that safely manages `gpio_request` / `gpio_free` lifecycle with automatic cleanup via `Drop`.
- **Layer 3 (Module Logic)**: `GpioRustModule` — orchestrates init/drop, publishes atomic state for runtime handlers.
- **Layer 4 (Rust Handlers)**: `#[no_mangle] pub extern "C"` functions exported from Rust and called by C `file_operations`. All GPIO reads/writes/toggles route through Rust, giving it full control over runtime operations.

> **Note**: Kernel 6.12 does not provide Rust abstractions for `miscdevice` or `FileOperations`. The C layer (`gpio_helpers.c`) handles misc device registration and userspace buffer copies as the thinnest possible shim, while ALL GPIO logic is delegated to Rust via bidirectional FFI.

### Sysfs and Hardware Config
- Controls a single hardcoded LED pin (Default BCM hardware pin 16, offset 512 = sysfs GPIO pin 528).

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
