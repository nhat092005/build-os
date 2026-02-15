# Makefile for GPIO Character Device Driver and Userspace Tool

# PHONY Targets
.PHONY: all clean help
.PHONY: modules modules-clean
.PHONY: userspace userspace-clean

# Main Targets
all: modules userspace

# Kernel Module Build
modules:
	$(MAKE) -C src modules

# Userspace Build
userspace:
	$(MAKE) -C userspace userspace

# Clean Targets
clean: modules-clean userspace-clean

# Clean Kernel Module
modules-clean:
	$(MAKE) -C src modules-clean

# Clean Userspace Tool
userspace-clean:
	$(MAKE) -C userspace userspace-clean

# Help
help:
	@echo "Build:"
	@echo "  all        Build kernel module and userspace tool"
	@echo "  modules    Build kernel module only"
	@echo "  userspace  Build userspace tool only"
	@echo ""
	@echo "Clean:"
	@echo "  clean      Clean all build artifacts"
	@echo "  modules-clean     Clean kernel module artifacts"
	@echo "  userspace-clean  Clean userspace tool artifacts"