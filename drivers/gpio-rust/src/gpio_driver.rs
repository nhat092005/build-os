// SPDX-License-Identifier: GPL-2.0
//! Safe GPIO abstraction driver in Rust (kernel 6.12).
//!
//! Implements a 4-layer mixed C-Rust architecture to work within the
//! constraints of kernel 6.12's Rust API, which does not yet expose
//! `miscdev`, `FileOperations`, or character device abstractions.
//!
//! - **Layer 1 (C FFI)**: `extern "C"` declarations for C helper wrappers.
//! - **Layer 2 (Safe Abstraction)**: [`GpioPin`] — RAII GPIO lifecycle manager.
//! - **Layer 3 (Module Logic)**: [`GpioRustModule`] — init/drop orchestration.
//! - **Layer 4 (Rust Handlers)**: `#[no_mangle] pub extern "C"` functions
//!   invoked by C `file_operations`; Rust owns all runtime GPIO logic while
//!   C handles only misc device registration and userspace↔kernel copies.
use core::sync::atomic::{AtomicU32, Ordering};
use kernel::c_str;
use kernel::prelude::*;

// Layer 1: Raw C FFI — wrappers for <linux/gpio.h> and misc device helpers.
//
// These symbols are not in bindings_helper.h by default and must be declared
// manually. Implemented in gpio_helpers.c.
extern "C" {
    fn rust_helper_gpio_request(
        gpio: core::ffi::c_uint,
        label: *const core::ffi::c_char,
    ) -> core::ffi::c_int;
    fn rust_helper_gpio_free(gpio: core::ffi::c_uint);
    fn rust_helper_gpio_direction_output(
        gpio: core::ffi::c_uint,
        value: core::ffi::c_int,
    ) -> core::ffi::c_int;
    fn rust_helper_gpio_set_value(gpio: core::ffi::c_uint, value: core::ffi::c_int);
    fn rust_helper_gpio_get_value(gpio: core::ffi::c_uint) -> core::ffi::c_int;
    // Registration only — all runtime file_ops are delegated to Layer 4
    // Rust handlers; the C side handles only misc device bookkeeping.
    fn rust_helper_misc_register() -> core::ffi::c_int;
    fn rust_helper_misc_deregister();
}

// Layer 2: Safe abstraction — all `unsafe` is confined to this struct.

/// Safe wrapper for a requested GPIO pin configured as output.
///
/// # Invariants
///
/// `self.pin` has been successfully passed to `gpio_request()` and
/// `gpio_direction_output()`. The corresponding `gpio_free()` is called
/// exactly once, in [`Drop::drop`].
struct GpioPin {
    pin: core::ffi::c_uint,
}

impl GpioPin {
    /// Requests `pin` and configures it as an output with `initial_value`.
    ///
    /// Returns `Err` if either the request or direction configuration fails.
    /// No cleanup is needed on error because no [`GpioPin`] is constructed.
    fn request(pin: u32, label: &'static kernel::str::CStr, initial_value: i32) -> Result<Self> {
        // SAFETY: `label` is a valid NUL-terminated C string whose lifetime
        // exceeds this call. The return value is checked before proceeding.
        let ret = unsafe { rust_helper_gpio_request(pin, label.as_char_ptr()) };
        if ret != 0 {
            pr_err!("gpio_rust: gpio_request({}) failed: {}\n", pin, ret);
            return Err(kernel::error::code::EBUSY);
        }
        // SAFETY: `pin` was successfully acquired by `gpio_request()` above,
        // so it is valid to configure its direction.
        let ret = unsafe { rust_helper_gpio_direction_output(pin, initial_value) };
        if ret != 0 {
            pr_err!(
                "gpio_rust: gpio_direction_output({}) failed: {}\n",
                pin,
                ret
            );
            // SAFETY: `pin` was successfully acquired above; this releases it
            // on the error path before returning without constructing `Self`.
            unsafe { rust_helper_gpio_free(pin) };
            return Err(kernel::error::code::EIO);
        }
        pr_info!(
            "gpio_rust: GPIO {} requested and configured as output\n",
            pin
        );
        // INVARIANT: `pin` has been successfully acquired and configured as
        // output; `gpio_free()` will be called in `Drop::drop`.
        Ok(GpioPin { pin })
    }

    /// Drives the pin high.
    fn set_high(&self) {
        // SAFETY: `self.pin` is valid for the lifetime of `self` per the type invariant.
        unsafe { rust_helper_gpio_set_value(self.pin, 1) }
    }

    /// Drives the pin low.
    fn set_low(&self) {
        // SAFETY: `self.pin` is valid for the lifetime of `self` per the type invariant.
        unsafe { rust_helper_gpio_set_value(self.pin, 0) }
    }
}

impl Drop for GpioPin {
    fn drop(&mut self) {
        pr_info!("gpio_rust: releasing GPIO {}\n", self.pin);
        // SAFETY: `self.pin` was successfully acquired in `GpioPin::request()`
        // and has not been freed since, per the type invariant.
        unsafe { rust_helper_gpio_free(self.pin) }
    }
}

// Layer 3: Module logic — no `unsafe` code.

/// BCM GPIO base offset on kernel 6.x (`gpiochip0` starts at 512).
const GPIO_BASE: u32 = 512;
/// Hardware BCM GPIO pin number (GPIO22).
const GPIO_HW_PIN: u32 = 22;
/// Global GPIO number passed to `gpio_request()` (base + hardware pin).
const DEFAULT_GPIO_PIN: u32 = GPIO_BASE + GPIO_HW_PIN;

/// Global GPIO number of the active pin, published before misc device
/// registration so Layer 4 handlers can read it safely. Cleared to 0 after
/// `misc_deregister()` returns, guaranteeing no in-flight callers remain.
static ACTIVE_PIN: AtomicU32 = AtomicU32::new(0);

/// Hardware BCM pin number of the active pin, published for Layer 4 handlers.
static ACTIVE_HW_PIN: AtomicU32 = AtomicU32::new(0);

module! {
    type: GpioRustModule,
    name: "gpio_rust",
    author: "nhat092005",
    description: "Safe GPIO driver in Rust",
    license: "GPL",
}

/// Kernel module that owns a single GPIO output pin driving an LED.
///
/// Dropping this type turns off the LED and releases the GPIO pin
/// automatically via [`GpioPin`]'s [`Drop`] implementation.
struct GpioRustModule {
    /// The GPIO pin controlling the LED.
    led: GpioPin,
}

impl kernel::Module for GpioRustModule {
    fn init(_module: &'static ThisModule) -> Result<Self> {
        pr_info!("gpio_rust: initializing\n");
        let led = GpioPin::request(DEFAULT_GPIO_PIN, c_str!("gpio_rust_led"), 0)?;
        // Publish pin numbers before registering the misc device so that
        // Layer 4 handlers are ready the moment userspace can open the node.
        ACTIVE_PIN.store(DEFAULT_GPIO_PIN, Ordering::Release);
        ACTIVE_HW_PIN.store(GPIO_HW_PIN, Ordering::Release);
        // SAFETY: Called exactly once during module init. The C file_operations
        // registered here delegate all GPIO logic to Layer 4 Rust handlers.
        let ret = unsafe { rust_helper_misc_register() };
        if ret != 0 {
            pr_err!("gpio_rust: failed to register misc device: {}\n", ret);
            ACTIVE_PIN.store(0, Ordering::Release);
            ACTIVE_HW_PIN.store(0, Ordering::Release);
            return Err(kernel::error::code::EIO);
        }
        pr_info!("gpio_rust: /dev/gpio-rust created\n");
        led.set_high();
        pr_info!("gpio_rust: LED on GPIO {} is ON\n", GPIO_HW_PIN);
        pr_info!("gpio_rust: module loaded\n");
        Ok(GpioRustModule { led })
    }
}

impl Drop for GpioRustModule {
    fn drop(&mut self) {
        // Deregister first: this blocks until all in-flight file_operations
        // complete, ensuring no Layer 4 handler runs after this point.
        // SAFETY: `rust_helper_misc_register()` succeeded in `init()`, so
        // deregistration is valid and must be called exactly once.
        unsafe { rust_helper_misc_deregister() };
        pr_info!("gpio_rust: /dev/gpio-rust removed\n");
        // Clear published state after deregistration; Layer 4 handlers that
        // observe pin == 0 will return safe defaults.
        ACTIVE_PIN.store(0, Ordering::Release);
        ACTIVE_HW_PIN.store(0, Ordering::Release);
        self.led.set_low();
        pr_info!("gpio_rust: LED on GPIO {} is OFF\n", GPIO_HW_PIN);
        pr_info!("gpio_rust: module unloaded\n");
        // `self.led` is dropped here, which calls `gpio_free()` automatically.
    }
}

// Layer 4: Exported Rust handlers called from C file_operations.
//
// The C shims in gpio_helpers.c hold `gpio_rust_lock` (DEFINE_MUTEX) before
// calling these functions, serializing all concurrent access. The shims
// handle userspace↔kernel buffer copies; these functions contain GPIO logic only.

/// Returns the current GPIO output value (0 or 1), or 0 if the module is
/// not yet initialized.
///
/// Called by the C `read` handler and the `GPIO_RUST_IOC_GET_STATE` /
/// `GPIO_RUST_IOC_TOGGLE` ioctl shims.
#[no_mangle]
pub extern "C" fn rust_gpio_handle_get_value() -> core::ffi::c_int {
    let pin = ACTIVE_PIN.load(Ordering::Acquire);
    if pin == 0 {
        return 0; // Module not initialized — safe default.
    }
    // SAFETY: `pin` was stored after a successful `gpio_request()` in
    // `GpioRustModule::init()` and remains valid until `ACTIVE_PIN` is
    // cleared in `Drop::drop()`, which only occurs after `misc_deregister()`
    // returns. The C caller additionally holds `gpio_rust_lock`.
    unsafe { rust_helper_gpio_get_value(pin) }
}

/// Sets the GPIO output to `value` (0 or 1). No-ops if the module is not
/// yet initialized.
///
/// Called by the C `write` handler and the `GPIO_RUST_IOC_SET_STATE` /
/// `GPIO_RUST_IOC_TOGGLE` ioctl shims. The C caller validates that `value`
/// is 0 or 1 before invoking this function.
#[no_mangle]
pub extern "C" fn rust_gpio_handle_set_value(value: core::ffi::c_int) {
    let pin = ACTIVE_PIN.load(Ordering::Acquire);
    if pin == 0 {
        return; // Module not initialized — ignore silently.
    }
    // SAFETY: same as `rust_gpio_handle_get_value`.
    unsafe { rust_helper_gpio_set_value(pin, value) }
}

/// Returns the hardware BCM pin number, or 0 if the module is not initialized.
///
/// Called by the C `GPIO_RUST_IOC_GET_GPIO` ioctl shim.
#[no_mangle]
pub extern "C" fn rust_gpio_handle_get_hw_pin() -> core::ffi::c_uint {
    ACTIVE_HW_PIN.load(Ordering::Relaxed)
}
