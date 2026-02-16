# Makefile for GPIO LED Driver - LED Class Interface with Device Tree Support

# Target platform configuration
ARCH            ?= arm64

# Directory paths
BUILDROOT_DIR   ?= $(shell pwd)/../../../buildroot

# Buildroot toolchain (must match kernel compiler)
CROSS_COMPILE   ?= $(BUILDROOT_DIR)/output/host/bin/aarch64-linux-

# Kernel directory (Buildroot kernel only)
KERNELDIR       ?= $(BUILDROOT_DIR)/output/build/linux-custom

# Module name (creates leds-gpio-custom.ko)
obj-m := leds-gpio-custom.o

# Build output directory
BUILD_DIR := $(CURDIR)/../build/module

# Build flags - include paths for headers
ccflags-y := -I$(src)/../include

# PHONY targets
.PHONY: all clean help
.PHONY: modules modules-clean

# Default target
all: modules

# Build kernel module
modules:
	mkdir -p $(BUILD_DIR)
	$(MAKE) -C $(KERNELDIR) M=$(CURDIR) \
		ARCH=$(ARCH) \
		CROSS_COMPILE=$(CROSS_COMPILE) \
		modules
	mv -f *.ko $(BUILD_DIR)/ 2>/dev/null || true
	mv -f *.o $(BUILD_DIR)/ 2>/dev/null || true
	mv -f .*.o $(BUILD_DIR)/ 2>/dev/null || true
	mv -f *.mod $(BUILD_DIR)/ 2>/dev/null || true
	mv -f *.mod.c $(BUILD_DIR)/ 2>/dev/null || true
	mv -f Module.symvers $(BUILD_DIR)/ 2>/dev/null || true
	mv -f modules.order $(BUILD_DIR)/ 2>/dev/null || true
	mv -f .*.cmd $(BUILD_DIR)/ 2>/dev/null || true
	mv -f .tmp_versions $(BUILD_DIR)/ 2>/dev/null || true

# Clean build artifacts
clean: modules-clean

# Clean Modules
modules-clean:
	@if [ -d "$(KERNELDIR)" ]; then \
		$(MAKE) -C $(KERNELDIR) M=$(CURDIR) clean; \
	fi
	rm -rf *.o *.ko *.mod.c *.mod *.order *.symvers .*.cmd .tmp_versions
	rm -f .*.o
	rm -rf $(BUILD_DIR)

# Show help information
help:
	@echo "Available targets:"
	@echo "  all                Build kernel module (default)"
	@echo "  modules            Build kernel module"
	@echo "  clean              Clean build artifacts"
	@echo "  modules-clean      Clean kernel module build artifacts"
