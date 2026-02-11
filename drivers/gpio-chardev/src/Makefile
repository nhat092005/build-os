# Makefile for GPIO Character Device Kernel Driver

# Module name
obj-m := gpio-chardev.o

# Build output directory
BUILD_DIR := $(CURDIR)/../build/module

# Kernel source directory (set by parent Makefile)
KERNELDIR ?= /lib/modules/$(shell uname -r)/build

# Architecture and cross-compiler (inherit from parent Makefile)
# ARCH and CROSS_COMPILE should be set by parent Makefile

# Build flags - include paths for headers
ccflags-y := -I$(src)/../include

# PHONY Targets
.PHONY: all build clean help

# Main Targets
all: build

# Build
build: 
	@echo "Building GPIO Character Device kernel module"
	@mkdir -p $(BUILD_DIR)
	$(MAKE) -C $(KERNELDIR) M=$(CURDIR) \
	        ARCH=$(ARCH) \
	        CROSS_COMPILE=$(CROSS_COMPILE) \
	        modules
	@echo "Moving build artifacts to $(BUILD_DIR)/"
	@mv -f *.ko $(BUILD_DIR)/ 2>/dev/null || true
	@mv -f *.o $(BUILD_DIR)/ 2>/dev/null || true
	@mv -f .*.o $(BUILD_DIR)/ 2>/dev/null || true
	@mv -f *.mod $(BUILD_DIR)/ 2>/dev/null || true
	@mv -f *.mod.c $(BUILD_DIR)/ 2>/dev/null || true
	@mv -f Module.symvers $(BUILD_DIR)/ 2>/dev/null || true
	@mv -f modules.order $(BUILD_DIR)/ 2>/dev/null || true
	@mv -f .*.cmd $(BUILD_DIR)/ 2>/dev/null || true
	@mv -f .tmp_versions $(BUILD_DIR)/ 2>/dev/null || true
	@echo "Build complete: $(BUILD_DIR)/gpio-chardev.ko"

# Clean
clean:
	@echo "Cleaning build artifacts"
	$(MAKE) -C $(KERNELDIR) M=$(CURDIR) clean
	@rm -f *.o *.ko *.mod *.mod.c *.symvers *.order .*.cmd
	@rm -f .*.o
	@rm -rf .tmp_versions
	@rm -rf $(BUILD_DIR)
	@echo "Clean complete"

# Help
help:
	@echo "Targets:"
	@echo "  all      Build kernel module (default)"
	@echo "  clean    Clean build artifacts"
	@echo "  build    Build kernel module"
	@echo "  help     Show this help"