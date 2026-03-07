# Testing: GPIO Rust

## Build Verification

Building this driver requires `rustc`, `bindgen`, and the kernel Rust support
configured correctly.

```bash
make modules MODULE=gpio-rust
make dtbo    DTBO=gpio-rust
make tools   TOOLS=gpio-rust

file drivers/gpio-rust/build/module/gpio_rust.ko
# Expected: ELF 64-bit LSB relocatable, ARM aarch64
file drivers/gpio-rust/build/tools/gpio-rust-ctl
# Expected: ELF 64-bit LSB executable, ARM aarch64
```

## Functional Tests

```bash
sudo insmod gpio_rust.ko
# Expected: device /dev/gpio-rust created

# read/write standard char device
echo 1 > /dev/gpio-rust   # turns on
cat /dev/gpio-rust        # output: 1

# Tool usage (ioctl)
gpio-rust-ctl toggle
gpio-rust-ctl status
gpio-rust-ctl blink 3 500

sudo rmmod gpio_rust
```

## Error Cases

| Scenario           | Expected behavior                                                   |
| ------------------ | ------------------------------------------------------------------- |
| Module not loaded  | `gpio_rust_open` fails: No such file or directory                   |
| Concurrent access  | Mutex serializes file operations (only one caller runs at a time)   |
| Invalid module arg | Probe fails if `gpio_pin` parameter is invalid (e.g. out of bounds) |
