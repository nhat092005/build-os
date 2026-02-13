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

# Kernel directory (Buildroot kernel only)
KERNELDIR       := $(BUILDROOT_DIR)/output/build/linux-custom

# Default configuration
DRIVER          ?= all
USERSPACE       ?= all
DEVICE          ?= /dev/sda

# Export for sub-makefiles
export ARCH CROSS_COMPILE KERNELDIR

# PHONY Targets
.PHONY: all clean help
.PHONY: driver driver-clean 
.PHONY: userspace userspace-clean
.PHONY: buildroot buildroot-clean menuconfig
.PHONY: stage-output install-tools identify-sdcard deploy-sdcard
.PHONY: image output-clean build-all

# Main Targets
all: help

# Build all components
build-all: buildroot driver userspace

# Build Drivers
driver:
	$(MAKE) -C $(DRIVERS_DIR) driver\
		ARCH=$(ARCH) \
		CROSS_COMPILE=$(CROSS_COMPILE) \
		KERNELDIR=$(KERNELDIR) \
		DRIVER=$(DRIVER)

# Clean Drivers
driver-clean:
	$(MAKE) -C $(DRIVERS_DIR) driver-clean \
		DRIVER=$(DRIVER)

# Build Userspace Tools
userspace:
	$(MAKE) -C $(DRIVERS_DIR) userspace \
		ARCH=$(ARCH) \
		CROSS_COMPILE=$(CROSS_COMPILE) \
		KERNELDIR=$(KERNELDIR) \
		USERSPACE=$(USERSPACE)

# Clean Userspace Tools
userspace-clean:
	$(MAKE) -C $(DRIVERS_DIR) userspace-clean \
		USERSPACE=$(USERSPACE)

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

# Image deployment
image: stage-output install-tools deploy-sdcard

# Stage output files
stage-output:
	$(MAKE) -C $(SCRIPTS_DIR) stage-output

# Install userspace tools
install-tools:
	bash $(SCRIPTS_DIR)/install-tools.sh

# Identify SD card device
identify-sdcard:
	$(MAKE) -C $(SCRIPTS_DIR) identify-sdcard

# Deploy SD card
deploy-sdcard:
	$(MAKE) -C $(SCRIPTS_DIR) deploy-sdcard

output-clean:
	@if [ "$$(id -u)" -ne 0 ]; then \
		echo "Error: Staging output requires root privileges"; \
		exit 1; \
	fi
	rm -rf $(OUTPUT_DIR)/*

clean: driver-clean buildroot-clean userspace-clean output-clean

help:
	@echo "Build:"
	@echo "  build-all                Build Buildroot, drivers, and userspace tools"
	@echo "  buildroot                Build kernel + rootfs with Buildroot"
	@echo "  driver                   Build kernel driver(s)"
	@echo "  userspace                Build userspace tools"
	@echo ""
	@echo "Configuration:"
	@echo "  menuconfig               Configure Buildroot (interactive)"
	@echo "  <name>_defconfig         Load a defconfig (built-in or custom)"
	@echo ""
	@echo "Clean:"
	@echo "  clean                    Clean all build artifacts"
	@echo "  driver-clean             Clean driver(s)"
	@echo "  buildroot-clean          Clean Buildroot output"
	@echo "  userspace-clean          Clean userspace tools"
	@echo ""
	@echo "Deployment:"
	@echo "  identify-sdcard          Identify SD card device"
	@echo "  stage-output             Stage buildroot output to output/ (requires root)"
	@echo "  install-tools            Install userspace tools to staged rootfs (requires root)"
	@echo "  deploy-sdcard            Deploy to SD card (requires root, DEVICE=/dev/sdX)"
	@echo "  image                    Stage output, install tools, and deploy to SD card (requires root)"
	@echo ""
	@echo "Build Options:"
	@echo "  DRIVER=<name|all>        Build specific driver (default: all)"
	@echo "  USERSPACE=<name|all>     Build specific userspace tool (default: all)"
	@echo "  DEVICE=<device>          SD card device (default: /dev/sda)"