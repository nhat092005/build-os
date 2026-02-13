# Makefile for GPIO Character Device Driver and Userspace Tool

# PHONY Targets
.PHONY: all clean help
.PHONY: driver driver-clean
.PHONY: userspace userspace-clean

# Main Targets
all: driver userspace

# Driver Build
driver:
	@$(MAKE) -C src driver

# Userspace Build
userspace:
	@$(MAKE) -C userspace userspace

# Clean Targets
clean: driver-clean userspace-clean

# Clean Kernel Module
driver-clean:
	@$(MAKE) -C src driver-clean

# Clean Userspace Tool
userspace-clean:
	@$(MAKE) -C userspace userspace-clean

# Help
help:
	@echo "Build:"
	@echo "  all        Build kernel module and userspace tool"
	@echo "  driver     Build kernel module only"
	@echo "  userspace  Build userspace tool only"
	@echo ""
	@echo "Clean:"
	@echo "  clean      Clean all build artifacts"
	@echo "  driver-clean     Clean kernel module artifacts"
	@echo "  userspace-clean  Clean userspace tool artifacts"