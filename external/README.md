# External

Buildroot external tree (`BR2_EXTERNAL`) named `NHAT092005`. Provides board configuration, custom packages, and build hooks for the Raspberry Pi 4 (64-bit) target.

## Directory Structure

```
external/
├── Config.in                              # Top-level package menu
├── external.desc                          # BR2_EXTERNAL name: NHAT092005
├── external.mk                            # Top-level package includes
├── board/raspberrypi/
│   ├── config.txt                         # RPi boot config (dtoverlays, I2C, etc.)
│   ├── linux-rust.config                  # Kernel fragment: CONFIG_RUST=y
│   ├── cmdline.txt                        # Kernel command line
│   ├── genimage.cfg.in                    # Genimage template (SD card layout)
│   ├── post-build.sh                      # Buildroot post-build hook
│   ├── post-fakeroot.sh                   # Buildroot post-fakeroot hook
│   ├── post-image.sh                      # Buildroot post-image hook
│   ├── rootfs-overlay/                    # Files overlaid on rootfs
│   ├── dts/                               # Extra device tree files
│   ├── overlays/                          # Built overlay storage
│   └── patches/                           # Kernel patches
├── configs/
│   └── raspberrypi4_64_custom_defconfig   # Main Buildroot defconfig
└── package/
    ├── Config.in                          # Package menu root
    ├── bh1750-driver/                     # Buildroot package for bh1750
    ├── ds3231-rtc-driver/                 # Buildroot package for ds3231-rtc
    ├── esp32-uart-driver/                 # Buildroot package for esp32-uart
    ├── gpio-chardev-driver/               # Buildroot package for gpio-chardev
    ├── gpio-inputs-driver/                # Buildroot package for gpio-inputs
    ├── gpio-leds-driver/                  # Buildroot package for gpio-leds
    ├── gpio-rust-driver/                  # Buildroot package for gpio-rust
    ├── gpio-sysfs-driver/                 # Buildroot package for gpio-sysfs
    ├── libopenssl/                        # OpenSSL override
    ├── sht3x-driver/                      # Buildroot package for sht3x
    └── stm32-uart-driver/                 # Buildroot package for stm32-uart
```

## Key Configuration

| Defconfig Setting | Value                                    |
| ----------------- | ---------------------------------------- |
| Architecture      | `BR2_aarch64=y`, `BR2_cortex_a72=y`      |
| Toolchain         | External, GCC 14, glibc                  |
| Kernel defconfig  | `bcm2711` + `linux-rust.config` fragment |
| Rootfs type       | ext4, 120MB                              |
| Firmware          | RPi4 variant                             |
| WiFi              | brcmfmac + wpa_supplicant                |
| SSH               | OpenSSH server/client                    |
