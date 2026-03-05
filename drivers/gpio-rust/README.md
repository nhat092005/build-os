# gpio-rust — Rust+C Hybrid GPIO Driver

## Overview

| Field      | Value                                                     |
| ---------- | --------------------------------------------------------- |
| Module     | `gpio_rust.ko`                                            |
| Subsystem  | Misc device (`misc_register`)                             |
| GPIO       | GPIO16 (default, overridable via `module_param gpio_pin`) |
| Compatible | `gpio-rust`                                               |
| Device     | `/dev/gpio_rust`                                          |
| DTS        | `gpio-rust-overlay.dts`                                   |
| Language   | C (`gpio_helpers.c`) + Rust (`gpio_rust_driver.rs`)       |

## Build

Requires `CONFIG_RUST=y` in kernel config.

```bash
make modules MODULE=gpio-rust
make dtbo DTBO=gpio-rust
make tools TOOLS=gpio-rust
```

## Architecture

Kbuild composite module with two source files:

- `gpio_helpers.c` (C) — platform driver probe/remove, `module_param`, `misc_register`, GPIO operations via `gpiod_*`
- `gpio_rust_driver.rs` (Rust) — Rust module init/exit, calls C helpers via FFI

Uses `gpio_to_desc()` bridge because Rust gpiod bindings are not available in kernel 6.12.

## Usage

```bash
# Default GPIO16
modprobe gpio_rust

# Override pin
insmod gpio_rust.ko gpio_pin=23

# Control via misc device
gpio-rust-ctl --help
```
