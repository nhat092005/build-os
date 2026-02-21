# Makefile for GPIO LED Driver - LED Class Interface with Device Tree Support

# Target platform configuration
ARCH				?= arm64

# Directory paths
BUILDROOT_DIR		?= $(shell pwd)/../../../buildroot
TOOLCHAIN_DIR		?= $(shell pwd)/../../../toolchains/aarch64-buildroot-linux-gnu_sdk-buildroot

# Buildroot toolchain (must match kernel compiler)
CROSS_COMPILE 		?= $(TOOLCHAIN_DIR)/bin/aarch64-linux-

# Kernel directory (Buildroot kernel only)
KERNEL_DIR			?= $(BUILDROOT_DIR)/output/build/linux-custom

# Build output directory (where install scripts look for .ko)
BUILD_DIR := $(CURDIR)/../build/module

# PHONY targets
.PHONY: all clean help
.PHONY: modules modules-clean

# Default target
all: modules

# Build kernel module
modules:
	mkdir -p $(BUILD_DIR)
	$(MAKE) -C $(KERNEL_DIR) \
		M=$(CURDIR) \
		ARCH=$(ARCH) \
		CROSS_COMPILE=$(CROSS_COMPILE) \
		modules
	cp -f $(CURDIR)/gpio-leds.ko $(BUILD_DIR)/gpio-leds.ko

# Clean build artifacts
clean: modules-clean

# Clean Modules
modules-clean:
	@if [ -d "$(KERNEL_DIR)" ]; then \
		$(MAKE) -C $(KERNEL_DIR) M=$(CURDIR) clean || true; \
	fi
	rm -rf $(BUILD_DIR)

# Show help information
help:
	@echo "Available targets:"
	@echo "  all                Build kernel module (default)"
	@echo "  modules            Build kernel module"
	@echo "  clean              Clean build artifacts"
	@echo "  modules-clean      Clean kernel module build artifacts"
