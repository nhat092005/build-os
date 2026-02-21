# Makefile for GPIO Character Device Kernel Driver

# Target platform configuration
ARCH            	?= arm64

# Directory paths
BUILDROOT_DIR		?= $(shell pwd)/../../../buildroot
TOOLCHAIN_DIR		?= $(shell pwd)/../../../toolchains/aarch64-buildroot-linux-gnu_sdk-buildroot

# Buildroot toolchain (must match kernel compiler)
CROSS_COMPILE 		?= $(TOOLCHAIN_DIR)/bin/aarch64-linux-

# Kernel directory (Buildroot kernel only)
KERNEL_DIR			?= $(BUILDROOT_DIR)/output/build/linux-custom

# Build output directory (where install scripts look for .ko)
BUILD_DIR := $(CURDIR)/../build/module

# PHONY Targets
.PHONY: all clean help
.PHONY: modules modules-clean

# Main Targets
all: modules

# Build Kernel Module
modules:
	mkdir -p $(BUILD_DIR)
	$(MAKE) -C $(KERNEL_DIR) \
		M=$(CURDIR) \
		ARCH=$(ARCH) \
		CROSS_COMPILE=$(CROSS_COMPILE) \
		modules
	cp -f $(CURDIR)/gpio-chardev.ko $(BUILD_DIR)/gpio-chardev.ko

# Clean
clean: modules-clean

# Clean Kernel Module build artifacts
modules-clean:
	@if [ -d "$(KERNEL_DIR)" ]; then \
		$(MAKE) -C $(KERNEL_DIR) M=$(CURDIR) clean || true; \
	fi
	rm -rf $(BUILD_DIR)

# Help
help:
	@echo "Targets:"
	@echo "  all             Build kernel module (default)"
	@echo "  clean           Clean build artifacts"
	@echo "  modules         Build kernel module"
	@echo "  modules-clean   Clean kernel module build artifacts"