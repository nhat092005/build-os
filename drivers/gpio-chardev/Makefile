# Makefile for GPIO LED Driver

# Cross-compilation settings (inherited from root Makefile)
ARCH            ?= arm64
CROSS_COMPILE   ?= aarch64-linux-gnu-
KERNELDIR       ?= /lib/modules/$(shell uname -r)/build

# PHONY Targets
.PHONY: all driver userspace help
.PHONY: clean clean-driver clean-userspace 

# Main Targets
all: driver userspace
	@echo "Build complete"

# Driver Build
driver:
	@echo "Building kernel module"
	@$(MAKE) -C src

# Userspace Build
userspace:
	@echo "Building userspace tool"
	@$(MAKE) -C userspace/tools

# Clean Targets
clean: clean-driver clean-userspace
	@echo "Clean complete"

# Clean Kernel Module
clean-driver:
	@echo "Cleaning kernel module"
	@$(MAKE) -C src clean

# Clean Userspace Tool
clean-userspace:
	@echo "Cleaning userspace tool"
	@$(MAKE) -C userspace/tools clean

# Help
help:
	@echo "Build:"
	@echo "  all        Build kernel module and userspace tool"
	@echo "  driver     Build kernel module only"
	@echo "  userspace  Build userspace tool only"
	@echo ""
	@echo "Clean:"
	@echo "  clean      Clean all build artifacts"
	@echo "  clean-driver     Clean kernel module artifacts"
	@echo "  clean-userspace  Clean userspace tool artifacts"