# Changelog

All notable changes to this project will be documented in this file.

## [1.1.0] - 2026-03-05

### Features

- Add README files for gpio-chardev and gpio-leds drivers
- Update README files for build-os and add external and scripts documentation
- Add gpio sysfs control library and utility tool
- Enhance GPIO LED driver Makefile and update gpio-led-ctl utility documentation
- Update LED device name from custom-led to gpio-led in overlay and utility
- Refactor GPIO sysfs library and enhance function documentation
- Update Makefile and gpio-sysfs-ctl utility for GPIO sysfs control
- Update GPIO sysfs driver Makefile for build and installation paths
- Suppress error messages in Makefile for module and tool builds
- Add GPIO sysfs driver package to Raspberry Pi 4 custom defconfig
- Update Makefile and Kbuild for GPIO character device driver
- Update Makefiles and Kbuild for GPIO LED driver enhancements
- Enhance Makefiles for GPIO sysfs driver and userspace tools
- Improve Makefile by removing redundant error suppression in build commands
- Remove installation of test scripts and documentation reference in GPIO LEDs driver
- Refactor overlay installation scripts for improved readability and functionality
- Update documentation and improve GPIO control messages in userspace tool
- Improve Makefile by suppressing error output during clean process
- Enhance GPIO LED driver and userspace tools with GPIO pin support
- Enhance device verification to auto-fix regular files as block devices
- Enhance documentation and improve output messages in GPIO control utility
- Add Device Tree Overlay for GPIO Rust Driver
- Add user API and shared constants for GPIO Rust driver
- Implement GPIO Rust driver with C FFI and misc device support
- Add libgpio-rust C API for GPIO Rust driver control
- Add Makefile and userspace tool for GPIO Rust driver control
- Update README to include gpio-rust driver description
- Add gpio-rust driver package and integration for Buildroot
- Enhance GPIO Rust driver with detailed module documentation and atomic state management
- Add usage information for GPIO control tools
- Add setup script for Rust toolchain support in kernel development
- Enhance GPIO control library and utility with improved error handling and parsing
- Implement delayed workqueue for LED blinking and enhance user input parsing
- Refactor GPIO LED driver for improved active-low handling and enhance userspace library with safe integer parsing
- Improve path buffer size calculation in gpio_list function
- Enhance GPIO Rust driver with additional API wrappers and user-space utility improvements
- Add Device Tree Overlay for DS3231 RTC on Raspberry Pi I2C1
- Add DS3231 RTC driver with I2C support and sysfs temperature attribute
- Add userspace control tool for DS3231 RTC with time and temperature functionalities
- Add Makefile and README for DS3231 RTC driver with build instructions and usage examples
- Enable I2C for DS3231 RTC and add device tree overlay in config.txt
- Add DS3231 RTC driver package with configuration and build files
- Update .gitignore to include CLAUDE.md and ensure proper newline at end of file
- Add Device Tree Overlay support for GPIO Character Device Driver
- Add setup script for verifying and configuring Rust toolchain
- Implement GPIO character device driver with user API and control interface
- Implement GPIO LED driver with Device Tree support and sysfs interface
- Update GPIO Rust driver with new user API and control library
- Update GPIO character device driver Makefile and module loading configuration
- Add clang-format configuration file for consistent code styling
- Enhance GPIO character device driver with improved structure and initialization
- Add git-cliff configuration for changelog generation
- Add Dockerfile, entrypoint script, and .dockerignore for SDK and builder images
- Implement GPIO inputs driver with Device Tree support and userspace tool
- Add BH1750 ambient light sensor driver with Device Tree support
- Restructure Makefile for Docker integration and remove obsolete driver Makefile
- Enhance Makefiles for Docker integration and improve build process for GPIO drivers
- Enhance Makefiles for Docker (gpio-inputs)
- Enhance Makefiles for Docker (gpio-inputs)
- Enhance Makefiles for Docker integration and improve build process for GPIO sysfs driver and userspace tools
- Update Dockerfile and entrypoint.sh for improved build environment and directory structure
- Enhance Makefiles for Docker integration across GPIO Rust driver components
- Add UART transport layer implementation with CRC support and public API
- Implement ESP32 UART driver and userspace tool with command support
- Add STM32 UART driver and userspace tool with command support
- Add README for common UART library with framing protocol details
- Add ESP32 and STM32 UART driver configurations and Makefiles
- Add GPIO input driver package with Makefile and auto-load configuration
- Add DS3231 driver
- Add SHT3X driver
- Add support for BH1750 and SHT3x drivers, update DS3231 configuration, and enhance Raspberry Pi setup
- Implement CI/CD workflows for building, publishing, and releasing Docker images and artifacts
- Add Docker Buildx setup step and update kernel configuration for Rust support
- Enhance checkpatch step to report individual file errors
- Optimize checkpatch step to exclude specific files and directories
- Add step to collect build outputs and update artifact upload path
- Update CI and Docker publish workflows to include paths for workflow files
- Update CI and release workflows to improve artifact collection and build process
- Update .gitignore to include additional generated and temporary files

### Bug Fixes

- Update toolchain and cross-compile paths in GPIO Makefile
- Update toolchain directory path in Makefile for GPIO LED driver
- Update GPIO driver package names and installation commands
- Add missing newline at end of .gitignore file
- Remove  .gitignore and ensure proper newline at end of file
- Update driver version logging in gpio_led_probe function
- Add no-op targets for compatibility with top-level drivers/Makefile
- Correct naming conventions in GPIO LEDs driver installation scripts
- Correct GPIO Rust module name in auto-load configuration
- Update Rust compiler and bindgen paths for Docker and local environments
- Release workflow trigger and docker build
- Configure buildroot before build
- Rename Makefiles for ESP32 and STM32 UART drivers and fix path COMMON_DIR

### Refactor

- Rename led-gpio-custom to gpio-leds
- Clean up Kbuild, Makefile, and gpio_helpers.c comments for clarity
- Replace strncpy with snprintf for safer string handling in GPIO functions
- Update GPIO LED driver to improve code structure and maintainability
- Rename command-line tool to gpio-leds-ctl and update default LED device name
- Simplify Makefile structure and remove unused help target
- Clean up Makefile and improve code formatting in gpio-chardev-ctl.c
- Streamline Makefile and remove help target from README
- Update Makefile description to reflect kernel module context
- Update Makefile to improve clarity and remove unused help target
- Reorganize Makefile by moving dtbo-clean target for better structure
- Clean up Makefile and improve code formatting in gpio_leds.c
- Improve code formatting and structure in Makefile and source files
- Simplify Makefile and update README for clarity
- Update Makefile comments for clarity and consistency
- Update Makefile headers for consistency in GPIO LEDS module and userspace tool
- Enhance GPIO Rust driver with new callback functions and improve Makefile structure
- Streamline Makefile and remove redundant comments from README
- Clean up Makefiles and improve formatting in GPIO drivers and tools
- Move libled to include
- Mov libio to include
- Enhance Makefiles for BH1750 driver with Docker support and improved structure
- Streamline CI workflow by removing unnecessary Docker login and pull steps

### Documentation

- Update README to include descriptions for gpio-sysfs and gpio-rust drivers
- Update header comment for GPIO LED control utility
- Refine header comments for LED control library
- Update comments in GPIO Rust driver headers for clarity and consistency
- Refine comments in GPIO Rust driver library and control tool for clarity
- Enhance README for clarity on GPIO Rust architecture and functionality
- Update post-build, post-fakeroot, and post-image scripts for clarity and consistency
- Update README.md for this current project
- Update links in README for external drivers documentation

## [1.0.0] - 2026-02-18

### Features

- Log in with root
- Add ssh
- Add GPIO control script with various commands by shell
- Add SD card deploy script for Pi4 with file syncing and verification
- Add new SD card deploy script for BOOT and rootfs with full sync and permissions setup
- Add GPIO control utility with support for various commands and library functions
- Enhance GPIO control with PID file management and direction checks
- Add GPIO export, unexport, and direction commands to gpio_control utility
- Add LED blink service script for Raspberry Pi
- Add initial Makefile and configure buildroot submodule
- Add scripts for SD card deployment and identification
- Add GPIO LED driver and Raspberry Pi configuration files
- Implement GPIO LED character device driver and userspace tools
- Add install-tools target and script for userspace tool installation
- Add GPIO character device driver and userspace tools
- Add Makefile for script management and deployment tasks
- Implement new deploy-sdcard script and remove deprecated deploy-to-sdcard script
- Add new Makefile for GPIO Character Device userspace tool and remove old tools Makefile
- Add Makefile for managing kernel drivers and userspace tools
- Add stage-output script for extracting boot and rootfs images
- Add .gitignore file to exclude build outputs and generated files
- Refactor GPIO drivers and add custom LED driver support
- Add device tree binding for custom GPIO-controlled LED
- Add device tree overlay for custom GPIO LED driver
- Add script to install device tree overlays to root filesystem
- Add install-overlays target to Makefile for Device Tree overlays
- Add install-overlay target to Makefile for custom GPIO LED driver
- Add script to remove Device Tree overlays from BOOT directory
- Add script to remove built userspace tools from rootfs
- Add remove-tools and remove-overlays targets to Makefile
- Enhance Makefile with install and remove targets for userspace tools and overlays
- Enforce root privileges for staging output and script execution
- Add build and install commands for userspace tools in gpio-chardev-driver
- Rename driver targets to module targets in Makefiles
- Add detailed function documentation for gpio-chardev-ioctl.c
- Add Makefile for Device Tree Overlays in leds-gpio-custom
- Add internal and user API headers for GPIO LED driver
- Enhance ELF executable checks and improve tool removal feedback
- Add LED control library implementation with core and utility functions
- Enhance LED device handling with name length validation and safe path construction
- Add LED control utility with command handling and verbose options
- Update Makefile for GPIO Character Device to streamline build targets and improve directory handling
- Add GPIO LED driver with Device Tree support and brightness control
- Update Makefiles for GPIO LED driver and userspace tools with Device Tree support
- Enhance Makefile to support Device Tree Blob Overlays and streamline userspace tools build process
- Add brcmfmac WiFi module configuration and enhance LEDs GPIO custom driver with userspace tools installation
- Implement scripts for installing and removing Device Tree overlays
- Add install and remove modules scripts for kernel module management
- Add install and remove modules targets to Makefile for kernel module management
- Add MIT License to the project
- Add initial README.md with project description and requirements
- Enhance Raspberry Pi 4 build support with new scripts and configurations
- Allow root login via SSH by changing PermitRootLogin to yes in sshd_config
- Add initial group, passwd, and shadow files for Raspberry Pi root filesystem
- Add os-release file for NhatOS configuration
- Add install and remove toolchain scripts and update Makefile
- Add CI and release workflows for automated builds and releases
- Add toolchains to project for CI yml

### Bug Fixes

- Fix invalid ELF
- Fix wpa wifi conect
- Fix error dhcp wlan0
- Fix job control
- Fix PTY allocation request failed on channel 0
- Update root home directory in passwd file
- Update ROOTFS path and enhance clean target output in Makefile
- Add missing newline in gpio-chardev.h for improved readability
- Move MODULE_LICENSE declaration to the correct position in gpio-chardev.c
- Correct DTC_FLAGS assignment syntax in dtbo target
- Add root privilege checks for install and remove Device Tree overlays
- Add conditional check for KERNELDIR in modules-clean target
- Correct syntax for install-overlays target in Makefile
- Remove redundant install-tools target from image deployment
- Update paths to use NHAT092005 for GPIO and LED drivers
- Remove unnecessary file cleanup in extract_rootfs function
- Update rootfs checks and paths to use USR_BIN_DIR in install-tools and remove-tools scripts
- Enhance output messages in install-tools and remove-tools scripts
- Improve error messages for rootfs and usr/bin directory checks in install-tools and remove-tools scripts
- Enhance Makefile structure and add driver build targets
- Update GPIO usage in device tree overlay and adjust kernel config path
- Add missing newline for better readability in install-tools and remove-tools scripts
- Improve error handling and structure in Makefile for script targets
- Standardize KERNELDIR variable naming in Makefiles for consistency
- Correct wpa_supplicant configuration path in S45wifi script
- Remove deprecated SSH authorized_keys and example files
- Remove redundant SSH user and group creation in post-build scripts
- Update S45wifi script comments and reduce sleep duration for DHCP
- Change permissions of /var/empty to 0700 for sshd privilege separation
- Pass DEVICE variable to deploy-sdcard target in Makefile
- Improve error handling and structure in stage-output.sh
- Refactor variable assignments for clarity in install-tools.sh and remove-tools.sh
- Improve variable assignment clarity in install-overlays.sh
- Refactor variable assignments for clarity in deploy-sdcard.sh
- Improve variable assignment clarity in identify-sdcard.sh
- Refactor variable assignments for clarity in deploy-sdcard.sh
- Refactor variable assignments for clarity and improve error handling in deploy-sdcard.sh
- Remove kernel/Makefile from project structure validation in CI workflow
- Update toolchain permissions in release workflow
- Update toolchain installation process in release workflow
- Update toolchain installation command in release workflow
- Update toolchain installation and removal targets in Makefiles
- Enhance toolchain installation process in CI workflow and script
- Improve toolchain installation process with enhanced logging and relocation
- Update toolchain installation process in CI and release workflows
- Remove caching of Buildroot host tools in CI and release workflows

### Other

- Init my os for raspberry
- Remove toolchains from repo

### Refactor

- Remove deprecated gpio_control.sh script
- Remove obsolete build symlink from kernel modules directory
- Remove legacy structure and introduce new driver layout
- Rename from gpio_led to gpio_chardev
- Rename gpio_chardev_ioctl to gpio-chardev-ioctl and update Makefile targets
- Streamline output messages and remove unnecessary prompts in deploy-to-sdcard script
- Remove unnecessary output messages in install-tools script
- Remove unnecessary output message in identify-sdcard script
- Separate PHONY targets for clarity in Makefile
- Remove unnecessary output messages in identify-sdcard script
- Streamline install-tools script by removing unused functions and improving tool detection
- Reorganize Makefile targets and improve stage-output handling
- Reorganize Makefile structure and enhance build targets for userspace tools
- Update Makefile structure for GPIO driver and clarify build targets
- Simplify Makefile for GPIO driver and userspace tool
- Remove unnecessary '@' from Makefile commands for improved readability
- Update toolchain configuration in Makefiles for consistency
- Correct comments and improve usage output in GPIO CHARDEV IOCTL tool
- Update BUILD_DIR and UAPI_DIR to use absolute paths in Makefile
- Improve error handling in install_tools function
- Streamline rootfs extraction process by copying directly from buildroot target
- Wpa_supplicant configuration for Wi-Fi network setup

### Documentation

- Improve formatting of help messages in Makefile
- Update README.md to enhance project description, requirements, and features

### Miscellaneous

- Update external.desc with personal information

<!-- generated by git-cliff -->
