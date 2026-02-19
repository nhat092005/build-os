# Makefile for GPIO Character Device Kernel Driver

# Target platform configuration
ARCH            	?= arm64

# Directory paths
BUILDROOT_DIR		?= $(shell pwd)/../../../buildroot
TOOLCHAIN_DIR		?= $(shell pwd)/toolchains/aarch64-buildroot-linux-gnu_sdk-buildroot

# Buildroot toolchain (must match kernel compiler)
CROSS_COMPILE 		?= $(TOOLCHAIN_DIR)/bin/aarch64-linux-

# Kernel directory (Buildroot kernel only)
KERNEL_DIR			?= $(BUILDROOT_DIR)/output/build/linux-custom

# Module name
obj-m := gpio-chardev.o

# Build output directory
BUILD_DIR := $(CURDIR)/../build/module

# Build flags - include paths for headers
ccflags-y := -I$(src)/../include

# PHONY Targets
.PHONY: all clean help
.PHONY: modules modules-clean

# Main Targets
all: modules

# Build Kernel Module
modules: 
	mkdir -p $(BUILD_DIR)
	$(MAKE) -C $(KERNEL_DIR) M=$(CURDIR) \
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

# Clean
clean: modules-clean

# Clean Kernel Module build artifacts
modules-clean:
	@if [ -d "$(KERNEL_DIR)" ]; then \
		$(MAKE) -C $(KERNEL_DIR) M=$(CURDIR) clean; \
	fi
	rm -f *.o *.ko *.mod *.mod.c *.symvers *.order .*.cmd
	rm -f .*.o
	rm -rf .tmp_versions
	rm -rf $(BUILD_DIR)

# Help
help:
	@echo "Targets:"
	@echo "  all             Build kernel module (default)"
	@echo "  clean           Clean build artifacts"
	@echo "  modules         Build kernel module"
	@echo "  modules-clean   Clean kernel module build artifacts"