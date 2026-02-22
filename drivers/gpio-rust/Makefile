# Makefile for GPIO Rust Driver - Safe GPIO Abstraction in Rust

# Configuration
SRC_DIR        := $(shell pwd)/src
DTS_DIR        := $(shell pwd)/dts
USERSPACE_DIR  := $(shell pwd)/userspace

# Export toolchain variables for sub-makes
export ARCH CROSS_COMPILE KERNEL_DIR

# PHONY Targets
.PHONY: all clean help
.PHONY: dtbo dtbo-clean
.PHONY: modules modules-clean
.PHONY: tools tools-clean

# Main Targets
all: dtbo modules tools

# Device Tree Blob Overlay Build
dtbo:
	$(MAKE) -C dts dtbo

# Clean Device Tree Blob Overlay
dtbo-clean:
	$(MAKE) -C dts dtbo-clean

# Kernel Module Build
modules:
	$(MAKE) -C src modules

# Clean Kernel Module
modules-clean:
	$(MAKE) -C src modules-clean

# Userspace Build
tools:
	$(MAKE) -C userspace tools

# Clean Userspace Tool
tools-clean:
	$(MAKE) -C userspace tools-clean

# Clean Targets
clean: dtbo-clean modules-clean tools-clean

# Help
help:
	@echo "Build:"
	@echo "  all              Build DTS overlay, kernel module, and userspace tool (default)"
	@echo "  dtbo             Build Device Tree Blob Overlay"
	@echo "  modules          Build Rust kernel module"
	@echo "  tools            Build userspace tool"
	@echo ""
	@echo "Clean:"
	@echo "  clean            Clean all build artifacts"
	@echo "  dtbo-clean       Clean Device Tree Blob Overlay artifacts"
	@echo "  modules-clean    Clean kernel module artifacts"
	@echo "  tools-clean      Clean userspace tool artifacts"
