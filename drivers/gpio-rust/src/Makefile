# Makefile for GPIO Rust Driver - Rust Kernel Module Build

# Target platform configuration
ARCH			?= arm64

# Directory paths
BUILDROOT_DIR	?= $(shell pwd)/../../../buildroot
TOOLCHAIN_DIR	?= $(shell pwd)/../../../toolchains/aarch64-buildroot-linux-gnu_sdk-buildroot

# Buildroot toolchain (must match kernel compiler)
CROSS_COMPILE	?= $(TOOLCHAIN_DIR)/bin/aarch64-linux-

# Kernel directory (Buildroot kernel only)
KERNEL_DIR		?= $(BUILDROOT_DIR)/output/build/linux-custom

# Rust toolchain (may be set via environment from parent make, or default to ~/.cargo/bin)
RUSTC		?= $(HOME)/.cargo/bin/rustc
BINDGEN		?= $(HOME)/.cargo/bin/bindgen

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
		RUSTC=$(RUSTC) \
		BINDGEN=$(BINDGEN) \
		modules
	cp -f $(CURDIR)/gpio_rust.ko $(BUILD_DIR)/gpio_rust.ko

# Clean build artifacts
clean: modules-clean

# Clean Modules
modules-clean:
	@if [ -d "$(KERNEL_DIR)" ]; then \
		$(MAKE) -C $(KERNEL_DIR) M=$(CURDIR) clean 2>/dev/null || true; \
	fi
	# Remove kbuild artifacts directly from src/ (no KERNEL_DIR required)
	rm -f  $(CURDIR)/*.ko $(CURDIR)/*.o $(CURDIR)/*.mod $(CURDIR)/*.mod.c \
	       $(CURDIR)/modules.order $(CURDIR)/Module.symvers
	rm -f  $(CURDIR)/.*.cmd $(CURDIR)/..*.cmd
	rm -f  $(CURDIR)/.module-common.o
	rm -rf $(CURDIR)/.tmp_versions
	rm -rf $(BUILD_DIR)

# Show help information
help:
	@echo "Available targets:"
	@echo "  all                Build Rust kernel module (default)"
	@echo "  modules            Build Rust kernel module"
	@echo "  clean              Clean build artifacts"
	@echo "  modules-clean      Clean kernel module build artifacts"
