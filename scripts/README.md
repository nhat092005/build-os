# Scripts

Shell scripts and a Makefile for deploying build artifacts to the staged output directory and to SD cards. These scripts operate on the `output/` directory, which contains extracted boot and rootfs partitions from the Buildroot images.

## Directory Structure

```
scripts/
├── Makefile
├── deploy-sdcard.sh
├── identify-sdcard.sh
├── install-modules.sh
├── install-overlays.sh
├── install-toolchains.sh
├── install-tools.sh
├── remove-modules.sh
├── remove-overlays.sh
├── remove-toolchains.sh
├── remove-tools.sh
├── setup-rust.sh
└── stage-output.sh
```

## Makefile Targets

| Target               | Root Required | Description                                |
| -------------------- | ------------- | ------------------------------------------ |
| `all`                | Yes           | Stage output, identify SD card, and deploy |
| `stage-output`       | Yes           | Extract boot and rootfs from Buildroot     |
| `identify-sdcard`    | No            | List block devices and detect SD cards     |
| `deploy-sdcard`      | Yes           | Flash and deploy to SD card                |
| `setup-rust.sh`      | No            | Verify and configure Rust toolchain        |
| `install-overlays`   | Yes           | Copy DT overlays to staged boot partition  |
| `remove-overlays`    | Yes           | Remove DT overlays from staged boot        |
| `install-modules`    | Yes           | Copy kernel modules to staged rootfs       |
| `remove-modules`     | Yes           | Remove kernel modules from staged rootfs   |
| `install-tools`      | Yes           | Copy userspace tools to staged rootfs      |
| `remove-tools`       | Yes           | Remove userspace tools from staged rootfs  |
| `install-toolchains` | No            | Extract and install Buildroot SDK          |
| `remove-toolchains`  | No            | Delete installed toolchain directory       |

The `DEVICE` variable specifies the target block device (default: `/dev/sda`).

## Script Descriptions

### stage-output.sh

Extracts the Buildroot-generated `boot.vfat` and `rootfs.ext4` images into `output/BOOT/` and `output/rootfs/` respectively. Uses `mcopy` for the FAT partition and loop-mounts the ext4 image with `rsync` to preserve permissions and extended attributes. Requires root.

### identify-sdcard.sh

Lists all block devices using `lsblk` and detects removable devices (USB drives) and MMC/SD cards by checking `/sys/block/*/removable` and `/sys/block/mmcblk*`.

### deploy-sdcard.sh

Deploys the complete system to an SD card. Handles partition naming for both `/dev/sdX` and `/dev/mmcblkX` style devices. Includes a cleanup trap for error handling. Requires root.

### install-modules.sh

Finds `.ko` files under `drivers/*/build/module/` and copies them to the staged rootfs at `output/rootfs/lib/modules/<version>/extra/`. Auto-detects the kernel version from the existing modules directory.

### remove-modules.sh

Removes `.ko` and `.ko.xz` files from the `extra/` directory under the auto-detected kernel version in the staged rootfs.

### install-overlays.sh

Finds `.dtbo` files under `drivers/*/build/dtbo/` and copies them to `output/BOOT/overlays/`.

### remove-overlays.sh

Removes overlay files from `output/BOOT/overlays/` that have corresponding built `.dtbo` files in the drivers directory.

### install-tools.sh

Finds ELF executables under `drivers/*/build/tools/` and copies them to `output/rootfs/usr/bin/`. Verifies each file is an ELF executable using the `file` command or by checking the ELF magic number as a fallback.

### remove-tools.sh

Removes previously installed userspace tools from `output/rootfs/usr/bin/`. Identifies tools by scanning `drivers/*/build/tools/` for ELF executables and removing matching files. Skips object files, archives, shared libraries, and source files.

### install-toolchains.sh

Builds the Buildroot SDK (if the tarball does not already exist), extracts the `aarch64-buildroot-linux-gnu_sdk-buildroot` tarball to `toolchains/`, and runs `relocate-sdk.sh` to fix embedded absolute paths. Verifies the resulting cross-compiler is executable.

### remove-toolchains.sh

Deletes the entire `toolchains/` directory.

### setup-rust.sh

Verifies and configures the Rust toolchain required for building kernel Rust modules. Checks that `rustc` and `bindgen` meet minimum version requirements (`rustc >= 1.78.0`, `bindgen >= 0.65.1`), installs missing components (`rust-src`, `aarch64-unknown-none` target) via `rustup` if needed, and validates that `libclang-dev` is present. Optionally cross-checks version requirements against the kernel's own `min-tool-version.sh` script. Prints an environment summary on success.