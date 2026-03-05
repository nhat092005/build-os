# Scripts

Shell scripts for deploying build artifacts to SD cards and managing toolchains.

## Scripts

| Script                  | Purpose                                      | Requires Root |
| ----------------------- | -------------------------------------------- | ------------- |
| `deploy-sdcard.sh`      | Flash staged output to SD card               | Yes           |
| `identify-sdcard.sh`    | Identify SD card device                      | No            |
| `install-modules.sh`    | Install `.ko` to staged rootfs               | Yes           |
| `install-overlays.sh`   | Install `.dtbo` to staged BOOT               | Yes           |
| `install-tools.sh`      | Install binaries to staged rootfs            | Yes           |
| `install-toolchains.sh` | Install cross-compiler locally               | No            |
| `remove-modules.sh`     | Remove installed modules                     | Yes           |
| `remove-overlays.sh`    | Remove installed overlays                    | Yes           |
| `remove-tools.sh`       | Remove installed tools                       | Yes           |
| `remove-toolchains.sh`  | Remove local toolchain                       | No            |
| `setup-rust.sh`         | Setup Rust toolchain for kernel build        | No            |
| `stage-output.sh`       | Extract boot.vfat + rootfs.ext4 to `output/` | Yes           |

## Usage

All scripts are invoked through the root Makefile:

```bash
sudo make stage-output
make install-modules
make install-overlays
make install-tools
sudo make deploy-sdcard DEVICE=/dev/sdX
```

## Notes

- `stage-output.sh` requires `mtools` (`mcopy`) for FAT extraction
- `stage-output.sh` overlays `external/board/raspberrypi/config.txt` over extracted boot partition
- All install scripts operate on `output/BOOT/` and `output/rootfs/`
