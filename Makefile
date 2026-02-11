# Makefile for build operation system

# Target platform configuration
ARCH            := arm64

# Buildroot paths
BR2_EXTERNAL    := $(shell pwd)/external
BUILDROOT_DIR   := $(shell pwd)/buildroot
DRIVERS_DIR     := $(shell pwd)/drivers
SCRIPTS_DIR     := $(shell pwd)/scripts
IMAGE_DIR       := $(BUILDROOT_DIR)/output/images

# Buildroot toolchain (must match kernel compiler)
CROSS_COMPILE   := $(BUILDROOT_DIR)/output/host/bin/aarch64-linux-

# Kernel directory (Buildroot kernel only)
KERNELDIR       := $(BUILDROOT_DIR)/output/build/linux-custom

# Deployment settings
DEVICE          ?= /dev/sda
METHOD          ?= auto

# Driver selection
DRIVER          ?= all

# Auto-detect available drivers
AVAILABLE_DRIVERS := $(notdir $(wildcard $(DRIVERS_DIR)/*))

# Toolchain binaries
CC              := $(CROSS_COMPILE)gcc
AR              := $(CROSS_COMPILE)ar

# Export for sub-makefiles (kernel + userspace)
export ARCH CROSS_COMPILE KERNELDIR CC AR

# PHONY Targets
.PHONY: all clean help
.PHONY: driver driver-clean
.PHONY: buildroot buildroot-clean menuconfig
.PHONY: deploy identify-sdcard install-tools

# Main Targets
all: buildroot driver

# Driver Build
driver:
	@if [ ! -d "$(KERNELDIR)" ]; then \
		echo "Error: Kernel source not found at $(KERNELDIR)"; \
		echo "Run 'make buildroot' first to build the kernel"; \
		exit 1; \
	fi
ifeq ($(DRIVER),all)
	@echo "Building all drivers"
	@for drv in $(AVAILABLE_DRIVERS); do \
		if [ -d "$(DRIVERS_DIR)/$$drv" ]; then \
			echo "  Building $$drv"; \
			$(MAKE) -C $(DRIVERS_DIR)/$$drv \
				ARCH=$(ARCH) \
				CROSS_COMPILE=$(CROSS_COMPILE) \
				KERNELDIR=$(KERNELDIR) || exit 1; \
		fi; \
	done
	@echo "All drivers built successfully"
else
	@if [ ! -d "$(DRIVERS_DIR)/$(DRIVER)" ]; then \
		echo "Error: Driver '$(DRIVER)' not found"; \
		echo "Available drivers: $(AVAILABLE_DRIVERS)"; \
		exit 1; \
	fi
	@echo "Building $(DRIVER) driver"
	@$(MAKE) -C $(DRIVERS_DIR)/$(DRIVER) \
		ARCH=$(ARCH) \
		CROSS_COMPILE=$(CROSS_COMPILE) \
		KERNELDIR=$(KERNELDIR)
endif

# Clean Driver Build
driver-clean:
ifeq ($(DRIVER),all)
	@echo "Cleaning all drivers"
	@for drv in $(AVAILABLE_DRIVERS); do \
		if [ -d "$(DRIVERS_DIR)/$$drv" ]; then \
			echo "  Cleaning $$drv"; \
			$(MAKE) -C $(DRIVERS_DIR)/$$drv clean; \
		fi; \
	done
	@echo "All drivers cleaned"
else
	@if [ ! -d "$(DRIVERS_DIR)/$(DRIVER)" ]; then \
		echo "Error: Driver '$(DRIVER)' not found"; \
		exit 1; \
	fi
	@echo "Cleaning $(DRIVER) driver"
	@$(MAKE) -C $(DRIVERS_DIR)/$(DRIVER) clean
endif

# Buildroot Build
buildroot:
	@if [ ! -d "$(BUILDROOT_DIR)" ]; then \
		echo "Error: Buildroot not found"; \
		echo "Run: git submodule update --init buildroot"; \
		exit 1; \
	fi
	@echo "Building complete system with Buildroot"
	@$(MAKE) -C $(BUILDROOT_DIR) BR2_EXTERNAL=$(BR2_EXTERNAL)

# Clean Buildroot Output
buildroot-clean:
	@echo "Cleaning Buildroot output"
	@$(MAKE) -C $(BUILDROOT_DIR) clean

# Buildroot Configuration
menuconfig:
	@if [ ! -d "$(BUILDROOT_DIR)" ]; then \
		echo "Error: Buildroot not found"; \
		exit 1; \
	fi
	@echo "Launching Buildroot configuration menu"
	@$(MAKE) -C $(BUILDROOT_DIR) BR2_EXTERNAL=$(BR2_EXTERNAL) menuconfig

# Load defconfig (supports both built-in and BR2_EXTERNAL defconfigs)
%_defconfig:
	@if [ ! -d "$(BUILDROOT_DIR)" ]; then \
		echo "Error: Buildroot not found"; \
		echo "Run: git submodule update --init buildroot"; \
		exit 1; \
	fi
	@echo "Loading defconfig: $@"
	@$(MAKE) -C $(BUILDROOT_DIR) BR2_EXTERNAL=$(BR2_EXTERNAL) $@

# Identify SD card device
identify-sdcard:
	@echo "Identifying SD card device"
	@if [ ! -f "$(SCRIPTS_DIR)/identify-sdcard.sh" ]; then \
		echo "Error: identify-sdcard.sh not found"; \
		exit 1; \
	fi
	@bash $(SCRIPTS_DIR)/identify-sdcard.sh

# Deploy SD card image
deploy:
	@if [ ! -f "$(SCRIPTS_DIR)/deploy-to-sdcard.sh" ]; then \
		echo "Error: deploy-to-sdcard.sh not found"; \
		exit 1; \
	fi
	@if [ ! -f "$(IMAGE_DIR)/sdcard.img" ]; then \
		echo "Error: Image not found at $(IMAGE_DIR)/sdcard.img"; \
		echo "Run 'make all' first to build the image"; \
		exit 1; \
	fi
	@if [ "$$(id -u)" -ne 0 ]; then \
		echo "Error: Deployment requires root privileges"; \
		echo "Usage: sudo make deploy DEVICE=$(DEVICE) METHOD=$(METHOD)"; \
		exit 1; \
	fi
	@echo "Deploying image to $(DEVICE)"
	@bash $(SCRIPTS_DIR)/deploy-to-sdcard.sh $(DEVICE) $(METHOD)

# Install userspace tools to root filesystem
install-tools:
	@if [ ! -f "$(SCRIPTS_DIR)/install-tools.sh" ]; then \
		echo "Error: install-tools.sh not found"; \
		exit 1; \
	fi
	@echo "Installing userspace tools to root filesystem"
	@bash $(SCRIPTS_DIR)/install-tools.sh

# Clean 
clean: driver-clean buildroot-clean
	@echo "Clean complete"

# Help
help:
	@echo "Build:"
	@echo "  all                      Build complete system (buildroot + drivers)"
	@echo "  buildroot                Build kernel + rootfs with Buildroot"
	@echo "  driver                   Build kernel module(s)"
	@echo ""
	@echo "Deployment:"
	@echo "  identify-sdcard          Identify SD card device"
	@echo "  deploy                   Flash image to SD card"
	@echo "  install-tools            Install userspace tools to root filesystem"
	@echo ""
	@echo "Configuration:"
	@echo "  menuconfig               Configure Buildroot (interactive)"
	@echo "  <name>_defconfig         Load a defconfig (built-in or custom)"
	@echo ""
	@echo "Clean:"
	@echo "  clean                    Clean all build artifacts"
	@echo "  driver-clean             Clean driver build artifacts"
	@echo "  buildroot-clean          Clean Buildroot output"
	@echo ""
	@echo "Configuration:"
	@echo "  ARCH                     = $(ARCH)"
	@echo "  CROSS_COMPILE            = $(CROSS_COMPILE)"
	@echo "  CC                       = $(CC)"
	@echo "  AR                       = $(AR)"
	@echo "  KERNELDIR                = $(KERNELDIR)"
	@echo ""
	@echo "Build Output:"
	@echo "  Image:                   $(IMAGE_DIR)/sdcard.img"
	@echo "  Drivers:                 drivers/*/build/{module,lib,tools}/"
	@echo ""
	@echo "Options:"
	@echo "  DRIVER=<name>            Build specific driver (default: all)"
	@echo "  DEVICE=<device>          SD card device (default: /dev/sda)"
	@echo "  METHOD=<auto|manual>     Deploy method (default: auto)"
	@echo ""
	@echo "Examples:"
	@echo "  make all"
	@echo "  make menuconfig"
	@echo "  make raspberrypi4_64_defconfig"
	@echo "  make raspberrypi4_64_custom_defconfig BR2_EXTERNAL=../external"
	@echo "  make driver DRIVER=gpio-led"
	@echo "  sudo make deploy DEVICE=/dev/sda METHOD=auto"
	@echo "  sudo make deploy DEVICE=/dev/sda METHOD=manual"
	@echo "  sudo make install-tools"
	@echo ""
	@echo "Available Drivers:"
	@for drv in $(AVAILABLE_DRIVERS); do \
		echo "  - $$drv"; \
	done