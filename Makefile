# Makefile for build operation system

# Target platform configuration
ARCH            := arm64

# Directory paths
BR2_EXTERNAL    := $(shell pwd)/external
BUILDROOT_DIR   := $(shell pwd)/buildroot
DRIVERS_DIR     := $(shell pwd)/drivers
SCRIPTS_DIR     := $(shell pwd)/scripts
IMAGE_DIR       := $(BUILDROOT_DIR)/output/images
OUTPUT_DIR      := $(shell pwd)/output

# Buildroot toolchain
CROSS_COMPILE   := $(BUILDROOT_DIR)/output/host/bin/aarch64-linux-

# Toolchain Configuration
CC              := $(CROSS_COMPILE)gcc
CFLAGS          := -Wall -Wextra -O2
AR              := $(CROSS_COMPILE)ar
DTC             := dtc
DTC_FLAGS       := -@ -I dts -O dtb -Wno-unit_address_vs_reg

# Kernel directory (Buildroot kernel only)
KERNELDIR       := $(BUILDROOT_DIR)/output/build/linux-custom

# Default configuration
DTBO			?= all
MODULE          ?= all
TOOLS           ?= all
DEVICE          ?= /dev/sda

# Export for sub-makefiles
export ARCH CROSS_COMPILE KERNELDIR DTBO MODULE TOOLS DEVICE

# PHONY Targets
.PHONY: all clean help
.PHONY: output-clean build-all

# Main Targets
all: help

# Clean all build artifacts
clean: buildroot-clean modules-clean tools-clean output-clean

# Clean staged output files
output-clean:
	@if [ "$$(id -u)" -ne 0 ]; then \
		echo "Error: Staging output requires root privileges"; \
		exit 1; \
	fi
	rm -rf $(OUTPUT_DIR)

# Build all components
build-all: buildroot dtbo modules tools

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
		KERNELDIR=$(KERNELDIR) \
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
		KERNELDIR=$(KERNELDIR) \
		TOOLS=$(TOOLS)

# Clean Userspace Tools
tools-clean:
	$(MAKE) -C $(DRIVERS_DIR) tools-clean \
		TOOLS=$(TOOLS)

.PHONY: buildroot buildroot-clean menuconfig

# Build Buildroot
buildroot:
	@if [ ! -d "$(BUILDROOT_DIR)" ]; then \
		echo "Error: Buildroot not found"; \
		echo "Run: git submodule update --init buildroot"; \
		exit 1; \
	fi
	$(MAKE) -C $(BUILDROOT_DIR) BR2_EXTERNAL=$(BR2_EXTERNAL)

# Clean Buildroot
buildroot-clean:
	$(MAKE) -C $(BUILDROOT_DIR) clean

# Configure Buildroot
menuconfig:
	@if [ ! -d "$(BUILDROOT_DIR)" ]; then \
		echo "Error: Buildroot not found"; \
		exit 1; \
	fi
	$(MAKE) -C $(BUILDROOT_DIR) BR2_EXTERNAL=$(BR2_EXTERNAL) menuconfig

# Load defconfig (supports both built-in and BR2_EXTERNAL defconfigs)
%_defconfig:
	@if [ ! -d "$(BUILDROOT_DIR)" ]; then \
		echo "Error: Buildroot not found"; \
		echo "Run: git submodule update --init buildroot"; \
		exit 1; \
	fi
	$(MAKE) -C $(BUILDROOT_DIR) BR2_EXTERNAL=$(BR2_EXTERNAL) $@

.PHONY: image stage-output identify-sdcard deploy-sdcard

# Image deployment
image: stage-output install-tools deploy-sdcard

# Stage output files
stage-output:
	$(MAKE) -C $(SCRIPTS_DIR) stage-output

# Identify SD card device
identify-sdcard:
	$(MAKE) -C $(SCRIPTS_DIR) identify-sdcard

# Deploy SD card
deploy-sdcard:
	$(MAKE) -C $(SCRIPTS_DIR) deploy-sdcard

.PHONY: install-tools remove-tools 

# Install tools
install-tools:
	$(MAKE) -C $(SCRIPTS_DIR) install-tools

# Remove tools
remove-tools:
	$(MAKE) -C $(SCRIPTS_DIR) remove-tools

.PHONY: install-overlays remove-overlays

# Install Device Tree overlays
install-overlays:
	$(MAKE) -C $(SCRIPTS_DIR) install-overlays

# Remove Device Tree overlays
remove-overlays:
	$(MAKE) -C $(SCRIPTS_DIR) remove-overlays

.PHONY: list

# List available drivers and tools
list:
	$(MAKE) -C $(DRIVERS_DIR) list

help:
	@echo "Build:"
	@echo "  build-all                Build Buildroot, modules, and userspace tools"
	@echo "  buildroot                Build kernel + rootfs with Buildroot"
	@echo "  modules                  Build kernel module(s)"
	@echo "  tools                    Build userspace tools"
	@echo ""
	@echo "Configuration:"
	@echo "  menuconfig               Configure Buildroot (interactive)"
	@echo "  <name>_defconfig         Load a defconfig (built-in or custom)"
	@echo ""
	@echo "Clean:"
	@echo "  clean                    Clean all build artifacts"
	@echo "  modules-clean            Clean module(s)"
	@echo "  buildroot-clean          Clean Buildroot output"
	@echo "  tools-clean              Clean tools"
	@echo ""
	@echo "Deployment:"
	@echo "  identify-sdcard          Identify SD card device"
	@echo "  stage-output             Stage buildroot output to output/ (requires root)"
	@echo "  install-tools            Install tools to staged rootfs (requires root)"
	@echo "  deploy-sdcard            Deploy to SD card (requires root, DEVICE=/dev/sdX)"
	@echo "  image                    Stage output, install tools, and deploy to SD card (requires root)"
	@echo "Others:"
	@echo "  list                     List available drivers and tools"
	@echo ""
	@echo "Build Options:"
	@echo "  DTBO=<name|all>          Build specific device tree blob overlay (default: all)"
	@echo "  MODULE=<name|all>        Build specific module (default: all)"
	@echo "  TOOLS=<name|all>         Build specific userspace tool (default: all)"
	@echo "  DEVICE=<device>          SD card device (default: /dev/sda)"