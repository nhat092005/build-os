// SPDX-License-Identifier: GPL-2.0

//! Safe GPIO abstraction driver in Rust (kernel 6.12).
//!
//! This module uses a 4-layer mixed C-Rust architecture, designed around
//! the practical constraints of kernel 6.12's Rust API (which does not yet
//! provide `miscdev`, `FileOperations`, or character device abstractions).
//!
//! - **Layer 1 (C FFI)**: `extern "C"` declarations for C helper wrappers
//! - **Layer 2 (Safe Abstraction)**: [`GpioPin`] — RAII GPIO lifecycle manager
//! - **Layer 3 (Module Logic)**: [`GpioRustModule`] — init/drop orchestration
//! - **Layer 4 (Rust Handlers)**: `#[no_mangle] pub extern "C"` functions
//!   called by C `file_operations`, giving Rust control over all runtime
//!   GPIO operations while C handles only misc device registration and
//!   userspace↔kernel buffer copies.

use kernel::c_str;
use kernel::prelude::*;
use core::sync::atomic::{AtomicU32, Ordering};

// Layer 1: Raw C FFI — functions from <linux/gpio.h>.
// Declared here because <linux/gpio.h> is not in bindings_helper.h by default.
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

    // Misc character device helpers (implemented in gpio_helpers.c).
    // Registration only — all runtime file_ops delegate to Layer 4 Rust handlers.
    fn rust_helper_misc_register() -> core::ffi::c_int;
    fn rust_helper_misc_deregister();
}

// Layer 2: Safe abstraction — confines all `unsafe` to this struct.

/// Safe wrapper for a requested GPIO pin configured as output.
///
/// # Invariants
///
/// `self.pin` has been successfully acquired via `gpio_request()` and
/// configured via `gpio_direction_output()`. `gpio_free()` is called
/// automatically on drop.
struct GpioPin {
    pin: core::ffi::c_uint,
}

impl GpioPin {
    /// Requests `pin` and configures it as output with `initial_value`.
    ///
    /// Returns `Err` if the request or configuration fails; no cleanup needed
    /// in that case because no [`GpioPin`] is created.
    fn request(pin: u32, label: &'static kernel::str::CStr, initial_value: i32) -> Result<Self> {
        // SAFETY: `label` is a valid NUL-terminated C string. Return value is checked.
        let ret = unsafe { rust_helper_gpio_request(pin, label.as_char_ptr()) };
        if ret != 0 {
            pr_err!("gpio_rust: gpio_request({}) failed: {}\n", pin, ret);
            return Err(kernel::error::code::EBUSY);
        }

        // SAFETY: `pin` was successfully requested above.
        let ret = unsafe { rust_helper_gpio_direction_output(pin, initial_value) };
        if ret != 0 {
            pr_err!("gpio_rust: gpio_direction_output({}) failed: {}\n", pin, ret);
            // SAFETY: `pin` was successfully requested above; this is the error cleanup path.
            unsafe { rust_helper_gpio_free(pin) };
            return Err(kernel::error::code::EIO);
        }

        pr_info!("gpio_rust: GPIO {} requested and configured as output\n", pin);

        // INVARIANT: `pin` has been successfully requested and configured as output.
        Ok(GpioPin { pin })
    }

    /// Drives the pin high.
    fn set_high(&self) {
        // SAFETY: `self.pin` is valid per type invariant.
        unsafe { rust_helper_gpio_set_value(self.pin, 1) }
    }

    /// Drives the pin low.
    fn set_low(&self) {
        // SAFETY: `self.pin` is valid per type invariant.
        unsafe { rust_helper_gpio_set_value(self.pin, 0) }
    }

}

impl Drop for GpioPin {
    fn drop(&mut self) {
        pr_info!("gpio_rust: releasing GPIO {}\n", self.pin);
        // SAFETY: `self.pin` was successfully requested in `GpioPin::request()` per type invariant.
        unsafe { rust_helper_gpio_free(self.pin) }
    }
}

// Layer 3: Module logic — zero `unsafe` code.

/// BCM GPIO base offset on kernel 6.x (gpiochip0 starts at 512).
const GPIO_BASE: u32 = 512;

/// Hardware GPIO pin number (BCM GPIO22).
const GPIO_HW_PIN: u32 = 22;

/// Global GPIO number for `gpio_request()` = base + hardware pin.
const DEFAULT_GPIO_PIN: u32 = GPIO_BASE + GPIO_HW_PIN;

/// Active GPIO pin number, published during init for Layer 4 handlers.
/// Cleared to 0 during drop (after misc_deregister, so no in-flight callers).
static ACTIVE_PIN: AtomicU32 = AtomicU32::new(0);

/// Hardware BCM pin number, published during init for Layer 4 handlers.
static ACTIVE_HW_PIN: AtomicU32 = AtomicU32::new(0);

module! {
    type: GpioRustModule,
    name: "gpio_rust",
    author: "nhat092005",
    description: "Safe GPIO driver in Rust",
    license: "GPL",
}

/// Kernel module that owns a single GPIO pin driving an LED.
///
/// Dropping this struct turns off the LED and releases the pin automatically.
struct GpioRustModule {
    /// The GPIO pin controlling the LED.
    led: GpioPin,
}

impl kernel::Module for GpioRustModule {
    fn init(_module: &'static ThisModule) -> Result<Self> {
        pr_info!("gpio_rust: initializing\n");

        let led = GpioPin::request(DEFAULT_GPIO_PIN, c_str!("gpio_rust_led"), 0)?;

        // Publish pin state for Layer 4 handlers BEFORE registering the misc
        // device, because userspace may access /dev/gpio-rust immediately.
        ACTIVE_PIN.store(DEFAULT_GPIO_PIN, Ordering::Release);
        ACTIVE_HW_PIN.store(GPIO_HW_PIN, Ordering::Release);

        // Register misc character device (/dev/gpio-rust).
        // SAFETY: `rust_helper_misc_register` registers the miscdevice once.
        // The C file_operations delegate all GPIO logic back to Rust Layer 4.
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
        // Deregister misc device FIRST — this blocks until all in-flight
        // file_operations complete, so Layer 4 handlers won't be called after.
        unsafe { rust_helper_misc_deregister() };
        pr_info!("gpio_rust: /dev/gpio-rust removed\n");

        // Clear published state (Layer 4 handlers will return safe defaults).
        ACTIVE_PIN.store(0, Ordering::Release);
        ACTIVE_HW_PIN.store(0, Ordering::Release);

        self.led.set_low();
        pr_info!("gpio_rust: LED on GPIO {} is OFF\n", GPIO_HW_PIN);
        pr_info!("gpio_rust: module unloaded\n");
        // `self.led` dropped here → gpio_free() called automatically.
    }
}

// ---------------------------------------------------------------------------
// Layer 4: Exported Rust Handlers (called from C file_operations)
// ---------------------------------------------------------------------------
//
// These functions give Rust full control over GPIO operations at runtime.
// The C file_operations in gpio_helpers.c are thin shims that handle only
// userspace↔kernel buffer copies and mutex serialization, then delegate
// all GPIO logic here.
//
// Safety contract: The C caller holds gpio_rust_lock (DEFINE_MUTEX) before
// calling these functions, serializing all concurrent access.

/// Read current GPIO value. Called by C `gpio_rust_dev_read()` and
/// `ioctl(GPIO_RUST_IOC_GET_STATE)` / `ioctl(GPIO_RUST_IOC_TOGGLE)`.
#[no_mangle]
pub extern "C" fn rust_gpio_handle_get_value() -> core::ffi::c_int {
    let pin = ACTIVE_PIN.load(Ordering::Acquire);
    if pin == 0 {
        return 0; // Module not initialized — safe default
    }
    // SAFETY: `pin` was set during init after a successful `gpio_request()`
    // and is valid for the entire module lifetime. The C caller serializes
    // access via mutex.
    unsafe { rust_helper_gpio_get_value(pin) }
}

/// Set GPIO value (0 or 1). Called by C `gpio_rust_dev_write()` and
/// `ioctl(GPIO_RUST_IOC_SET_STATE)` / `ioctl(GPIO_RUST_IOC_TOGGLE)`.
///
/// The caller (C shim) validates that `value` is 0 or 1 before calling.
#[no_mangle]
pub extern "C" fn rust_gpio_handle_set_value(value: core::ffi::c_int) {
    let pin = ACTIVE_PIN.load(Ordering::Acquire);
    if pin == 0 {
        return; // Module not initialized — ignore silently
    }
    // SAFETY: same as `rust_gpio_handle_get_value`.
    unsafe { rust_helper_gpio_set_value(pin, value) }
}

/// Return hardware BCM pin number. Called by C `ioctl(GPIO_RUST_IOC_GET_GPIO)`.
#[no_mangle]
pub extern "C" fn rust_gpio_handle_get_hw_pin() -> core::ffi::c_uint {
    ACTIVE_HW_PIN.load(Ordering::Relaxed)
}