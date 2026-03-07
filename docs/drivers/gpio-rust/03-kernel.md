# Kernel (C layer): GPIO Rust

## C Helpers (`gpio_helpers.c`)

This file provides the boilerplate to bridge C subsystems with Rust.

### Module Init / Exit

```c
module_init(gpio_rust_init);
module_exit(gpio_rust_exit);
```

Init workflow:

1. `rust_helper_gpio_request(gpio_pin, ...)` — wrap `gpiod_get` or similar
2. `gpio_rust_module_init(gpio_pin)` — call into Rust to initialize state
3. `misc_register(&gpio_rust_misc_device)` — register /dev/gpio-rust

### File Operations

The `file_operations` structure is defined in C:

```c
static const struct file_operations gpio_rust_fops = {
	.owner          = THIS_MODULE,
	.read           = gpio_rust_read,
	.write          = gpio_rust_write,
	.unlocked_ioctl = gpio_rust_ioctl,
	.open           = gpio_rust_open,
	.release        = gpio_rust_release,
};
```

Each operation acquires `gpio_rust_lock` (a standard C mutex), copies data
from/to userspace if needed, and calls the corresponding Rust `handle_*` function.

### ioctl Interface (UAPI)

Defined in `include/uapi/gpio_rust.h`:

| Command                   | Nr  | Direction | Type    | Description        |
| ------------------------- | --- | --------- | ------- | ------------------ |
| `GPIO_RUST_IOC_SET_STATE` | 1   | `_IOW`    | `__u32` | Set 0 or 1         |
| `GPIO_RUST_IOC_GET_STATE` | 2   | `_IOR`    | `__u32` | Get current state  |
| `GPIO_RUST_IOC_TOGGLE`    | 3   | `_IO`     | —       | Toggle state       |
| `GPIO_RUST_IOC_GET_GPIO`  | 4   | `_IOR`    | `__u32` | Get BCM pin number |

## Build System (Kbuild)

Rust must be enabled in the kernel config.

```makefile
obj-m += gpio_rust.o
gpio_rust-y := src/gpio_helpers.o src/gpio_rust_driver.o
```
