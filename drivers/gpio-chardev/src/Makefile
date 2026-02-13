# Makefile for GPIO Character Device Kernel Driver

# Target platform configuration
ARCH            ?= arm64

# Directory paths
BUILDROOT_DIR   ?= $(shell pwd)/../../../buildroot

# Buildroot toolchain (must match kernel compiler)
CROSS_COMPILE   ?= $(BUILDROOT_DIR)/output/host/bin/aarch64-linux-

# Kernel directory (Buildroot kernel only)
KERNELDIR       ?= $(BUILDROOT_DIR)/output/build/linux-custom

# Module name
obj-m := gpio-chardev.o

# Build output directory
BUILD_DIR := $(CURDIR)/../build/module

# Build flags - include paths for headers
ccflags-y := -I$(src)/../include

# PHONY Targets
.PHONY: all clean help
.PHONY: driver driver-clean

# Main Targets
all: driver

# Build Driver
driver: 
	@mkdir -p $(BUILD_DIR)
	$(MAKE) -C $(KERNELDIR) M=$(CURDIR) \
	        ARCH=$(ARCH) \
	        CROSS_COMPILE=$(CROSS_COMPILE) \
	        modules
	@mv -f *.ko $(BUILD_DIR)/ 2>/dev/null || true
	@mv -f *.o $(BUILD_DIR)/ 2>/dev/null || true
	@mv -f .*.o $(BUILD_DIR)/ 2>/dev/null || true
	@mv -f *.mod $(BUILD_DIR)/ 2>/dev/null || true
	@mv -f *.mod.c $(BUILD_DIR)/ 2>/dev/null || true
	@mv -f Module.symvers $(BUILD_DIR)/ 2>/dev/null || true
	@mv -f modules.order $(BUILD_DIR)/ 2>/dev/null || true
	@mv -f .*.cmd $(BUILD_DIR)/ 2>/dev/null || true
	@mv -f .tmp_versions $(BUILD_DIR)/ 2>/dev/null || true

# Clean
clean: driver-clean

# Clean Driver
driver-clean:
	$(MAKE) -C $(KERNELDIR) M=$(CURDIR) clean
	@rm -f *.o *.ko *.mod *.mod.c *.symvers *.order .*.cmd
	@rm -f .*.o
	@rm -rf .tmp_versions
	@rm -rf $(BUILD_DIR)

# Help
help:
	@echo "Targets:"
	@echo "  all             Build kernel module (default)"
	@echo "  clean           Clean build artifacts"
	@echo "  driver          Build kernel module"
	@echo "  driver-clean    Clean kernel module build artifacts"