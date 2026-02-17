# Makefile for build operation system

# Target platform configuration
ARCH					:= arm64

# Directory paths
BR2_EXTERNAL			:= $(shell pwd)/external
BUILDROOT_DIR			:= $(shell pwd)/buildroot
DRIVERS_DIR				:= $(shell pwd)/drivers
SCRIPTS_DIR				:= $(shell pwd)/scripts
KERNEL_SRC_DIR			:= $(shell pwd)/kernel
KERNEL_DIR				:= $(BUILDROOT_DIR)/output/build/linux-custom
TOOLCHAIN_DIR 			:= $(shell pwd)/toolchains/aarch64-buildroot-linux-gnu_sdk-buildroot

# Output directories
IMAGE_DIR				:= $(BUILDROOT_DIR)/output/images
OUTPUT_DIR				:= $(shell pwd)/output

# Buildroot toolchain
CROSS_COMPILE 			:= $(TOOLCHAIN_DIR)/bin/aarch64-linux-

# Toolchain Configuration
CC						:= $(CROSS_COMPILE)gcc
CFLAGS					:= -Wall -Wextra -O2
AR						:= $(CROSS_COMPILE)ar
DTC						:= dtc
DTC_FLAGS				:= -@ -I dts -O dtb -Wno-unit_address_vs_reg

# Auto-detect available drivers
AVAILABLE_DRIVERS		:= $(notdir $(wildcard $(DRIVERS_DIR)/*))

# Default configuration
DTBO	  				?= all
MODULE					?= all
TOOLS					?= all
DRIVER					?= all
DEVICE					?= /dev/sda

# Export for sub-makefiles
export ARCH CROSS_COMPILE KERNEL_DIR DTBO MODULE TOOLS DEVICE

.PHONY: all
# Main Targets
#all: build-all stage-output deploy-sdcard
all: help

.PHONY: build-all
# Build all components
build-all: buildroot dtbo modules tools

.PHONY: buildroot buildroot-clean menuconfig
# Build Buildroot
buildroot:
	@if [ ! -d "$(BUILDROOT_DIR)" ]; then \
		echo "Error: Buildroot not found"; \
		echo "Run: git submodule update --init buildroot"; \
		exit 1; \
	fi
	$(MAKE) -C $(BUILDROOT_DIR) BR2_EXTERNAL=$(BR2_EXTERNAL) LINUX_OVERRIDE_SRCDIR=$(KERNEL_SRC_DIR)

# Clean Buildroot
buildroot-clean:
	$(MAKE) -C $(BUILDROOT_DIR) BR2_EXTERNAL=$(BR2_EXTERNAL) LINUX_OVERRIDE_SRCDIR=$(KERNEL_SRC_DIR) clean

# Configure Buildroot
menuconfig:
	@if [ ! -d "$(BUILDROOT_DIR)" ]; then \
		echo "Error: Buildroot not found"; \
		exit 1; \
	fi
	$(MAKE) -C $(BUILDROOT_DIR) BR2_EXTERNAL=$(BR2_EXTERNAL) LINUX_OVERRIDE_SRCDIR=$(KERNEL_SRC_DIR) menuconfig

# Load defconfig (supports both built-in and BR2_EXTERNAL defconfigs)
%_defconfig:
	@if [ ! -d "$(BUILDROOT_DIR)" ]; then \
		echo "Error: Buildroot not found"; \
		echo "Run: git submodule update --init buildroot"; \
		exit 1; \
	fi
	$(MAKE) -C $(BUILDROOT_DIR) BR2_EXTERNAL=$(BR2_EXTERNAL) LINUX_OVERRIDE_SRCDIR=$(KERNEL_SRC_DIR) $@

.PHONY: buildroot-distclean
# Distclean Buildroot
buildroot-distclean:
	@if [ ! -d "$(BUILDROOT_DIR)" ]; then \
		echo "Error: Buildroot not found"; \
		exit 1; \
	fi
	$(MAKE) -C $(BUILDROOT_DIR) distclean

.PHONY: dtbo dtbo-clean
# Build Device Tree Blob Overlays
dtbo:
	$(MAKE) -C $(DRIVERS_DIR) dtbo \
		DTC=$(DTC) \
		DTC_FLAGS="$(DTC_FLAGS)"

# Clean Device Tree Blob Overlays
dtbo-clean:
	$(MAKE) -C $(DRIVERS_DIR) dtbo-clean \
		DTBO=$(DTBO)

.PHONY: modules modules-clean 
# Build Modules
modules:
	$(MAKE) -C $(DRIVERS_DIR) modules \
		ARCH=$(ARCH) \
		CROSS_COMPILE=$(CROSS_COMPILE) \
		KERNEL_DIR=$(KERNEL_DIR) \
		MODULE=$(MODULE)

# Clean Modules
modules-clean:
	$(MAKE) -C $(DRIVERS_DIR) modules-clean \
		MODULE=$(MODULE)

.PHONY: tools tools-clean
# Build Userspace Tools
tools:
	$(MAKE) -C $(DRIVERS_DIR) tools \
		ARCH=$(ARCH) \
		CROSS_COMPILE=$(CROSS_COMPILE) \
		KERNEL_DIR=$(KERNEL_DIR) \
		TOOLS=$(TOOLS)

# Clean Userspace Tools
tools-clean:
	$(MAKE) -C $(DRIVERS_DIR) tools-clean \
		TOOLS=$(TOOLS)

.PHONY: driver driver-rebuild driver-reconfigure driver-clean driver-dirclean
# Build kernel driver using Buildroot
driver:
ifeq ($(DRIVER),all)
	@for drv in $(AVAILABLE_DRIVERS); do \
		if [ -d "$(DRIVERS_DIR)/$$drv" ]; then \
			$(MAKE) -C $(BUILDROOT_DIR) BR2_EXTERNAL=$(BR2_EXTERNAL) $$drv-driver || exit 1; \
		fi; \
	done
else
	@if [ ! -d "$(DRIVERS_DIR)/$(DRIVER)" ]; then \
		echo "Error: Driver '$(DRIVER)' not found in $(DRIVERS_DIR)"; \
		exit 1; \
	fi
	$(MAKE) -C $(BUILDROOT_DIR) BR2_EXTERNAL=$(BR2_EXTERNAL) $$DRIVER-driver
endif

# Rebuild kernel driver using Buildroot
driver-rebuild:
ifeq ($(DRIVER),all)
	@for drv in $(AVAILABLE_DRIVERS); do \
		if [ -d "$(DRIVERS_DIR)/$$drv" ]; then \
			$(MAKE) -C $(BUILDROOT_DIR) BR2_EXTERNAL=$(BR2_EXTERNAL) $$drv-driver-rebuild || exit 1; \
		fi; \
	done
else
	@if [ ! -d "$(DRIVERS_DIR)/$(DRIVER)" ]; then \
		echo "Error: Driver '$(DRIVER)' not found in $(DRIVERS_DIR)"; \
		exit 1; \
	fi
	$(MAKE) -C $(BUILDROOT_DIR) BR2_EXTERNAL=$(BR2_EXTERNAL) $$DRIVER-driver-rebuild
endif

# Reconfigure kernel driver using Buildroot
driver-reconfigure:
ifeq ($(DRIVER),all)
	@for drv in $(AVAILABLE_DRIVERS); do \
		if [ -d "$(DRIVERS_DIR)/$$drv" ]; then \
			$(MAKE) -C $(BUILDROOT_DIR) BR2_EXTERNAL=$(BR2_EXTERNAL) $$drv-driver-reconfigure || exit 1; \
		fi; \
	done
else
	@if [ ! -d "$(DRIVERS_DIR)/$(DRIVER)" ]; then \
		echo "Error: Driver '$(DRIVER)' not found in $(DRIVERS_DIR)"; \
		exit 1; \
	fi
	$(MAKE) -C $(BUILDROOT_DIR) BR2_EXTERNAL=$(BR2_EXTERNAL) $$DRIVER-driver-reconfigure
endif

# Clean kernel driver using Buildroot
driver-clean:
ifeq ($(DRIVER),all)
	@for drv in $(AVAILABLE_DRIVERS); do \
		if [ -d "$(DRIVERS_DIR)/$$drv" ]; then \
			$(MAKE) -C $(BUILDROOT_DIR) BR2_EXTERNAL=$(BR2_EXTERNAL) $$drv-driver-clean || exit 1; \
		fi; \
	done
else
	@if [ ! -d "$(DRIVERS_DIR)/$(DRIVER)" ]; then \
		echo "Error: Driver '$(DRIVER)' not found in $(DRIVERS_DIR)"; \
		exit 1; \
	fi
	$(MAKE) -C $(BUILDROOT_DIR) BR2_EXTERNAL=$(BR2_EXTERNAL) $$DRIVER-driver-clean
endif

# Clean driver build artifacts using Buildroot
driver-dirclean:
ifeq ($(DRIVER),all)
	@for drv in $(AVAILABLE_DRIVERS); do \
		if [ -d "$(DRIVERS_DIR)/$$drv" ]; then \
			$(MAKE) -C $(BUILDROOT_DIR) BR2_EXTERNAL=$(BR2_EXTERNAL) $$drv-driver-dirclean || exit 1; \
		fi; \
	done
else
	@if [ ! -d "$(DRIVERS_DIR)/$(DRIVER)" ]; then \
		echo "Error: Driver '$(DRIVER)' not found in $(DRIVERS_DIR)"; \
		exit 1; \
	fi
	$(MAKE) -C $(BUILDROOT_DIR) BR2_EXTERNAL=$(BR2_EXTERNAL) $$DRIVER-driver-dirclean
endif

.PHONY: image identify-sdcard deploy-sdcard
# Image deployment
image: identify-sdcard deploy-sdcard

# Identify SD card device
identify-sdcard:
	$(MAKE) -C $(SCRIPTS_DIR) identify-sdcard

# Deploy SD card
deploy-sdcard:
	$(MAKE) -C $(SCRIPTS_DIR) deploy-sdcard

.PHONY: stage-output
# Stage output files
stage-output:
	$(MAKE) -C $(SCRIPTS_DIR) stage-output

.PHONY: install-overlays remove-overlays
# Install Device Tree overlays
install-overlays:
	$(MAKE) -C $(SCRIPTS_DIR) install-overlays

# Remove Device Tree overlays
remove-overlays:
	$(MAKE) -C $(SCRIPTS_DIR) remove-overlays

.PHONY: install-modules remove-modules
# Install kernel modules
install-modules:
	$(MAKE) -C $(SCRIPTS_DIR) install-modules

# Remove kernel modules
remove-modules:
	$(MAKE) -C $(SCRIPTS_DIR) remove-modules

.PHONY: install-tools remove-tools 
# Install tools
install-tools:
	$(MAKE) -C $(SCRIPTS_DIR) install-tools

# Remove tools
remove-tools:
	$(MAKE) -C $(SCRIPTS_DIR) remove-tools

.PHONY: clean
# Clean all build artifacts
clean: buildroot-clean dtbo-clean modules-clean tools-clean output-clean

.PHONY: output-clean
# Clean staged output files
output-clean:
	@if [ "$$(id -u)" -ne 0 ]; then \
		echo "Error: Staging output requires root privileges"; \
		exit 1; \
	fi
	rm -rf $(OUTPUT_DIR)

.PHONY: list
# List available drivers and tools
list:
	$(MAKE) -C $(DRIVERS_DIR) list

.PHONY: help
# Help
help:
	@echo "Main Targets:"
	@echo "  all                      Build all components, stage output, and deploy to SD card (default)"
	@echo "Build:"
	@echo "  build-all                Build Buildroot, modules, and userspace tools"
	@echo "  buildroot                Build kernel + rootfs with Buildroot"
	@echo "  dtbo                     Build device tree blob overlays"
	@echo "  modules                  Build kernel module(s)"
	@echo "  tools                    Build userspace tools"
	@echo "Configuration:"
	@echo "  menuconfig               Configure Buildroot (interactive)"
	@echo "  <name>_defconfig         Load a defconfig (built-in or custom)"
	@echo "Driver:"
	@echo "  driver                   Build kernel driver(s)"
	@echo "  driver-rebuild           Rebuild kernel driver(s)"
	@echo "  driver-reconfigure       Reconfigure kernel driver(s)"
	@echo "  driver-clean             Clean kernel driver(s)"
	@echo "  driver-dirclean          Clean kernel driver build artifacts"
	@echo "Clean:"
	@echo "  clean                    Clean all build artifacts"
	@echo "  buildroot-clean          Clean Buildroot output"
	@echo "  dtbo-clean               Clean device tree blob overlays"
	@echo "  modules-clean            Clean module(s)"
	@echo "  tools-clean              Clean tools"
	@echo "  buildroot-distclean      Distclean Buildroot (resets to pristine state)"
	@echo "Deployment:"
	@echo "  stage-output             Stage buildroot output to output/ (requires root)"
	@echo "  image                    Identify SD card, and deploy (requires root)"
	@echo "  identify-sdcard          Identify SD card device"
	@echo "  deploy-sdcard            Deploy to SD card (requires root)"
	@echo "  output-clean             Clean staged output files (requires root)"
	@echo "Install:" 
	@echo "  install-overlays         Install device tree overlays to staged rootfs (requires root)"
	@echo "  install-modules          Install kernel modules to staged rootfs"
	@echo "  install-tools            Install userspace tools to staged rootfs"
	@echo "Remove:"
	@echo "  remove-overlays          Remove device tree overlays from staged rootfs (requires root)"
	@echo "  remove-modules           Remove kernel modules from staged rootfs"
	@echo "  remove-tools             Remove userspace tools from staged rootfs"
	@echo "Others:"
	@echo "  list                     List available drivers and tools"
	@echo "Build Options:"
	@echo "  DTBO=<name|all>          Build specific device tree blob overlay (default: all)"
	@echo "  MODULE=<name|all>        Build specific module (default: all)"
	@echo "  TOOLS=<name|all>         Build specific userspace tool (default: all)"
	@echo "  DRIVER=<name|all>        Build specific driver using Buildroot (default: all)"
	@echo "  DEVICE=<device>          SD card device (default: /dev/sda)"