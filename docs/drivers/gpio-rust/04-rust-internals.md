# Rust Internals: GPIO Rust

The Rust code (`src/gpio_rust_driver.rs`) implements the core business logic
and safe abstractions over the C helpers.

## Safe Abstraction: `GpioPin`

```rust
pub struct GpioPin {
    pin: u32,
}
```

This struct provides the core RAII (Resource Acquisition Is Initialization) pattern.

- `GpioPin::request(pin)` calls C `rust_helper_gpio_request`. Returns `Result<GpioPin, Error>`.
- `impl Drop for GpioPin`: Automatically calls `rust_helper_gpio_free` when
  the object goes out of scope.
- Provides safe `.set_value()` and `.get_value()` methods.

## Module Logic

The driver stores state in atomic variables rather than relying on a Rust
`Mutex`:

```rust
static ACTIVE_PIN: AtomicU32 = AtomicU32::new(0);
static ACTIVE_HW_PIN: AtomicU32 = AtomicU32::new(0);
```

### Initialization

`gpio_rust_module_init(pin: u32) -> i32`

1. Validates the pin number.
2. Calls `rust_helper_gpio_request()`.
3. If successful, stores the pin in `ACTIVE_PIN`.

### De-initialization

`gpio_rust_module_exit()`

1. Retrieves the active pin.
2. Zeroes the atomic state safely.
3. Sets the pin LOW.
4. Calls `rust_helper_gpio_free()`.

## FFI Exports (`#[no_mangle]`)

These functions are called by the C file operations.

- `rust_gpio_handle_set_value(val: u32) -> i32`
- `rust_gpio_handle_get_value(val_out: *mut u32) -> i32`
- `rust_gpio_handle_get_hw_pin(pin_out: *mut u32) -> i32`

They read the `ACTIVE_PIN` atomic. If 0 (uninitialized), they return `-19` (`-ENODEV`).
Otherwise, they invoke the C `rust_helper_gpio_*` functions to perform operations.
