# Makefile for GPIO LED Class Driver with Custom GPIO Handling

# Configuration
USERSPACE_DIR  := $(shell pwd)/userspace

# Export toolchain variables for sub-makes
export ARCH CROSS_COMPILE KERNEL_DIR

# PHONY Targets
.PHONY: all clean help
.PHONY: tools tools-clean

# Main Targets
all: tools

# Userspace Build
tools:
	$(MAKE) -C userspace tools

# Clean Targets
clean: tools-clean

# Clean Userspace Tool
tools-clean:
	$(MAKE) -C userspace tools-clean

# Help
help:
	@echo "Build:"
	@echo "  all              Build user space tool"
	@echo "  tools            Build userspace tool only"
	@echo ""
	@echo "Clean:"
	@echo "  clean             Clean all build artifacts"
	@echo "  tools-clean       Clean userspace tool artifacts"