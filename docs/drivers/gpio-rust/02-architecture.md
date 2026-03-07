# Architecture: GPIO Rust

## System Diagram

```
┌────────────────────────────────────────────────┐
│ HARDWARE: LED → GPIO16                         │
└───────────────────┬────────────────────────────┘
                    │ C: gpiod_set_value / _get_value
┌───────────────────▼────────────────────────────┐
│ gpio_rust.ko (C + Rust hybrid module)          │
│                                                │
│ /dev/gpio-rust (misc device, created by C)     │
│                                                │
│ ┌──────────────────────┐   ┌───────────────┐   │
│ │ C file_ops           │   │ Rust FFI      │   │
│ │ gpio_rust_ioctl()  ──┼─► │ handle_set()  │   │
│ │ gpio_rust_read()   ──┼─► │ handle_get()  │   │
│ │ gpio_rust_write()  ──┼─► │ handle_toggle()│  │
│ └──────────────────────┘   └──────┬────────┘   │
│                                   │            │
│                            ┌──────▼────────┐   │
│                            │ Rust Safe API │   │
│                            │ GpioPin struct│   │
│                            └──────┬────────┘   │
│                                   │            │
│ ┌──────────────────────┐          │            │
│ │ C gpiod API helpers  │ ◄────────┘            │
│ │ rust_helper_gpio_*() │                       │
│ └──────────────────────┘                       │
└────────────────────────────────────────────────┘
```

## 4-Layer Architecture Explained

Because the Rust `kernel` crate in Linux 6.12 is incomplete for many
subsystems (e.g., no `devm_gpiod_get`, no `misc_register`, no `module_param`),
this driver uses a 4-layer hybrid approach:

1. **Layer 1: C Helpers (`gpio_helpers.c`)**
   Wraps inline C functions and complex macros into standard C functions
   that Rust can easily call via FFI.

2. **Layer 2: Safe Rust Abstraction (`gpio_rust_driver.rs`)**
   Wraps the unsafe C helpers into safe Rust types (e.g., `GpioPin`)
   that provide RAII semantics using the `Drop` trait.

3. **Layer 3: Rust Module Logic**
   Manages atomic state (`ACTIVE_PIN`, `ACTIVE_HW_PIN`) and implements
   the core business logic without `unsafe` blocks.

4. **Layer 4: Rust Top-Level Handlers (FFI Exports)**
   Functions marked `#[no_mangle] pub extern "C"` that are called by
   the C side (e.g., from `file_operations` handlers).

## Concurrency

- **C side:** `DEFINE_MUTEX(gpio_rust_lock)` serializes all `file_operations`.
  This guarantees that only one userspace process can execute an ioctl/read/write
  at a time.
- **Rust side:** Uses `core::sync::atomic::AtomicU32` to store the active
  pin number sharing state between C init and file_ops.
- This design completely avoids Rust `Mutex` or `SpinLock` since the
  subsystem (misc device + single pin) is fundamentally single-threaded
  via the C mutex.
