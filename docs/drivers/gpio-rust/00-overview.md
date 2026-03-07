# GPIO Rust — Rust Kernel Driver

Mixed C/Rust kernel module controlling a GPIO pin as an LED via
`/dev/gpio-rust`. Demonstrates safe Rust abstractions over kernel GPIO APIs
with a 4-layer C/Rust architecture.

## Stack

```
┌──────────────────────────────────┐
│ LED on BCM GPIO16 (active-high)  │ ← Hardware
└────────────┬─────────────────────┘
             │ gpiod_set_value → rust_gpio_desc
┌────────────▼─────────────────────┐
│ gpio_rust.ko (Rust + C)          │ ← Kernel Driver
│ subsystem: misc char device      │
│ /dev/gpio-rust                   │
│                                  │
│ file_ops: read, write, ioctl     │
│ ioctl: SET_STATE, GET_STATE,     │
│        TOGGLE, GET_GPIO          │
└──────────────────────────────────┘
```

## Components

| Component       | Present | Path                               |
| --------------- | ------- | ---------------------------------- |
| Rust source     | Yes     | `src/gpio_rust_driver.rs`          |
| C helpers       | Yes     | `src/gpio_helpers.c`               |
| DTS overlay     | Yes     | `dts/gpio-rust-overlay.dts`        |
| Internal header | Yes     | `include/gpio_rust.h`              |
| UAPI header     | Yes     | `include/uapi/gpio_rust.h`         |
| Userspace lib   | Yes     | `userspace/lib/libgpio-rust.{h,c}` |
| Userspace tool  | Yes     | `userspace/tools/gpio-rust-ctl.c`  |

## 4-Layer Architecture

```
┌─────────────────────────────────────────────────┐
│ Layer 4: Rust Handlers (#[no_mangle])           │
│ rust_gpio_handle_get_value()                    │
│ rust_gpio_handle_set_value()                    │
│ rust_gpio_handle_get_hw_pin()                   │
│ ─ Exported to C, called from file_operations ─  │
├─────────────────────────────────────────────────┤
│ Layer 3: Module Logic (Rust, no unsafe)         │
│ GpioRustModule { led: GpioPin }                 │
│ init(): get pin → GpioPin::request → misc_reg  │
│ drop(): misc_dereg → set_low → GpioPin::drop   │
├─────────────────────────────────────────────────┤
│ Layer 2: Safe Abstraction (Rust)                │
│ GpioPin { pin } — RAII: gpio_request + Drop     │
├─────────────────────────────────────────────────┤
│ Layer 1: C FFI (extern "C" declarations)        │
│ rust_helper_gpio_request/free/set/get_value     │
│ rust_helper_misc_register/deregister            │
│ Implemented in gpio_helpers.c using gpiod_* API │
└─────────────────────────────────────────────────┘
```

### Why this architecture?

Kernel 6.12 Rust bindings do NOT expose: `miscdev`, `FileOperations`,
or `devm_gpiod_get()`. Therefore:

- C handles: misc device registration, file_ops, userspace copies, module_param
- Rust handles: GPIO lifecycle (RAII), read/write/toggle logic
- C calls Rust via `#[no_mangle] pub extern "C"` functions
- Rust calls C via `extern "C"` FFI declarations

## DTS Overlay

- **Default GPIO:** BCM GPIO16, output, no pull
- **Compatible:** `"gpio-rust"`
- Module parameter: `gpio_pin` (uint, 0444, default 16)
- GPIO_RUST_BASE + gpio_pin = global GPIO number

## ioctl Interface

| Command                   | Direction | Type    | Description        |
| ------------------------- | --------- | ------- | ------------------ |
| `GPIO_RUST_IOC_SET_STATE` | `_IOW`    | `__u32` | Set 0 or 1         |
| `GPIO_RUST_IOC_GET_STATE` | `_IOR`    | `__u32` | Get current state  |
| `GPIO_RUST_IOC_TOGGLE`    | `_IO`     | —       | Toggle state       |
| `GPIO_RUST_IOC_GET_GPIO`  | `_IOR`    | `__u32` | Get BCM pin number |

## Concurrency

- C-side `DEFINE_MUTEX(gpio_rust_lock)` serializes all file_ops
- Rust uses `AtomicU32` (`ACTIVE_PIN`, `ACTIVE_HW_PIN`) for pin state sharing
- `misc_deregister()` called before clearing atomics — ensures no in-flight handlers

## Testing

```bash
make modules MODULE=gpio-rust
make dtbo    DTBO=gpio-rust
# On target:
sudo insmod gpio_rust.ko
# Expected: gpio_rust: /dev/gpio-rust created

cat /dev/gpio-rust          # Read state
echo 1 > /dev/gpio-rust     # Turn on

sudo rmmod gpio_rust
```
