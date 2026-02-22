# External

Buildroot external tree (`BR2_EXTERNAL`) named `NHAT092005`. Provides board configuration, custom packages, and build hooks for the Raspberry Pi 4 (64-bit) target.

## Directory Structure

```
external/
├── Config.in                 # Sources package/Config.in
├── external.desc             # External tree name and description
├── external.mk               # Kernel source override and package includes
├── board/
│   └── raspberrypi/
│       ├── cmdline.txt                       # Kernel command line
│       ├── config.txt                        # Raspberry Pi boot configuration
│       ├── genimage.cfg.in                   # Disk image layout (boot.vfat + rootfs.ext4)
│       ├── post-build.sh                     # Post-build: HDMI console, sshd setup
│       ├── post-fakeroot.sh                  # Post-fakeroot hooks
│       ├── post-image.sh                     # Post-image: generates sdcard.img
│       └── rootfs-overlay/
│           └── etc/
│               ├── group, passwd, shadow     # System user accounts
│               ├── os-release                # OS identification
│               ├── init.d/S45wifi            # WiFi init script
│               ├── modules-load.d/brcmfmac.conf
│               ├── ssh/                      # SSH server configuration
│               └── wpa_supplicant.conf       # WiFi credentials
├── configs/
│   └── raspberrypi4_64_custom_defconfig      # Buildroot defconfig
└── package/
    ├── Config.in                             # Package menu entries
    ├── gpio-chardev-driver/                  # Buildroot package for gpio-chardev
    ├── gpio-leds-driver/                     # Buildroot package for gpio-leds
    ├── gpio-rust-driver/                     # Buildroot package for gpio-rust
    ├── gpio-sysfs-driver/                    # Buildroot package for gpio-sysfs
    └── libopenssl/                           # Host libopenssl build fix
```

## External Tree Configuration

### external.desc

Registers the external tree name as `NHAT092005`. Buildroot exposes this as the variable `BR2_EXTERNAL_NHAT092005_PATH`.

### external.mk

- Overrides `LINUX_OVERRIDE_SRCDIR` to point to the local `kernel/` directory, so Buildroot builds the kernel from local source instead of downloading a tarball.
- Includes all package `.mk` files from `package/*/`.

### Config.in

Sources the `Config.in` files for `gpio-chardev-driver` and `gpio-leds-driver` packages.

## Board Configuration

### board/raspberrypi/

Board support files for Raspberry Pi 4 (64-bit):

- **cmdline.txt**: Kernel boot command line.
- **config.txt**: Raspberry Pi firmware configuration.
- **genimage.cfg.in**: Defines the SD card image layout with a FAT boot partition and an ext4 rootfs partition.
- **post-build.sh**: Adds an HDMI console (`tty1`) to `/etc/inittab` and ensures the sshd privilege separation directory exists.
- **post-image.sh**: Generates the final `sdcard.img` from built images.
- **rootfs-overlay/**: Files overlaid onto the root filesystem, including SSH server config, WiFi configuration (`wpa_supplicant.conf`, init script `S45wifi`), system accounts, and kernel module auto-load for `brcmfmac`.

### configs/

Contains `raspberrypi4_64_custom_defconfig`, the Buildroot defconfig for this project.

## Packages

### gpio-chardev-driver

Buildroot package that builds the `gpio-chardev` kernel module and userspace tool. Uses the `kernel-module` and `generic-package` infrastructure. Installs:

- Kernel module via the kernel module build system.
- Module auto-load config to `/etc/modules-load.d/gpio-chardev.conf`.
- `gpio-chardev-ctl` to `/usr/bin/`.
- UAPI header to staging for userspace compilation.

### gpio-leds-driver

Buildroot package that builds the `gpio-leds` kernel module, userspace tools, and device tree overlay. Uses a post-build hook to compile the DTS. Installs:

- Kernel module via `modules_install`.
- Module auto-load config to `/etc/modules-load.d/gpio-leds.conf`.
- Userspace tools to `/usr/bin/`.
- UAPI header to staging.
- Device tree overlay (`gpio-leds.dtbo`) to `rpi-firmware/overlays/`.
- Documentation and module config files to `/usr/share/doc/gpio-leds-driver/`.

### gpio-rust-driver

Buildroot package that builds the `gpio-rust` kernel module and its userspace tools, using the Rust out-of-tree capabilities and standard Makefiles. Installs:

- Kernel module via `modules_install`.
- `gpio-rust-ctl` client tool to `/usr/bin/`.

### gpio-sysfs-driver

Buildroot package that builds the `gpio-sysfs` library and userspace command-line application (since no kernel module is required). Installs:

- `gpio-sysfs-ctl` to `/usr/bin/`.
- Static link library component properties if required.

### libopenssl

Overrides the host `libopenssl` configure step to add the `no-asm` flag. This fixes an AVX512 assembly error (`crypto/modes/aes-gcm-avx512.s: Error: open CFI at the end of file`) that occurs during host toolchain builds on certain systems.
