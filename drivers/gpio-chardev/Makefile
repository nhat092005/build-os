# Makefile for GPIO Character Device Driver and Userspace Tool

# Configuration
DTS_DIR        := $(shell pwd)/dts
SRC_DIR        := $(shell pwd)/src
USERSPACE_DIR  := $(shell pwd)/userspace

# Export toolchain variables for sub-makes
export ARCH CROSS_COMPILE KERNEL_DIR

# PHONY Targets
.PHONY: all clean help
.PHONY: modules modules-clean
.PHONY: tools tools-clean

# Main Targets
all: modules tools

# Kernel Module Build
modules:
	$(MAKE) -C src modules

# Userspace Build
tools:
	$(MAKE) -C userspace tools

# Clean Targets
clean: modules-clean tools-clean

# Clean Kernel Module
modules-clean:
	$(MAKE) -C src modules-clean

# Clean Userspace Tool
tools-clean:
	$(MAKE) -C userspace tools-clean

# Help
help:
	@echo "Build:"
	@echo "  all              Build kernel module and userspace tool (default)"
	@echo "  modules          Build kernel module only"
	@echo "  tools            Build userspace tool only"
	@echo ""
	@echo "Clean:"
	@echo "  clean             Clean all build artifacts"
	@echo "  modules-clean     Clean kernel module artifacts"
	@echo "  tools-clean       Clean userspace tool artifacts"