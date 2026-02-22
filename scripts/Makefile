# Makefile for scripts 

# Configuration
SCRIPTS_DIR     := $(shell pwd)

# Deployment settings
DEVICE          ?= /dev/sda

.PHONY: all
# Main Targets
all: stage-output identify-sdcard deploy-sdcard 

.PHONY: stage-output identify-sdcard deploy-sdcard
# Stage output files for deployment
stage-output:
	@if [ ! -f "$(SCRIPTS_DIR)/stage-output.sh" ]; then \
		echo "Error: stage-output.sh not found"; \
		exit 1; \
	fi
	@if [ "$$(id -u)" -ne 0 ]; then \
		echo "Error: Staging output requires root privileges"; \
		exit 1; \
	fi
	bash $(SCRIPTS_DIR)/stage-output.sh $(DEVICE) $(METHOD)

# Identify SD card device
identify-sdcard:
	@if [ ! -f "$(SCRIPTS_DIR)/identify-sdcard.sh" ]; then \
		echo "Error: identify-sdcard.sh not found"; \
		exit 1; \
	fi
	bash $(SCRIPTS_DIR)/identify-sdcard.sh

# Deploy SD card image
deploy-sdcard:
	@if [ ! -f "$(SCRIPTS_DIR)/deploy-sdcard.sh" ]; then \
		echo "Error: deploy-sdcard.sh not found"; \
		exit 1; \
	fi
	@if [ "$$(id -u)" -ne 0 ]; then \
		echo "Error: Deployment requires root privileges"; \
		exit 1; \
	fi
	bash $(SCRIPTS_DIR)/deploy-sdcard.sh $(DEVICE)

.PHONY: install-overlays remove-overlays
# Install Device Tree overlays to system
install-overlays:
	@if [ ! -f "$(SCRIPTS_DIR)/install-overlays.sh" ]; then \
		echo "Error: install-overlays.sh not found"; \
		exit 1; \
	fi
	@if [ "$$(id -u)" -ne 0 ]; then \
		echo "Error: Deployment requires root privileges"; \
		exit 1; \
	fi
	bash $(SCRIPTS_DIR)/install-overlays.sh

# Remove Device Tree overlays from system
remove-overlays:
	@if [ ! -f "$(SCRIPTS_DIR)/remove-overlays.sh" ]; then \
		echo "Error: remove-overlays.sh not found"; \
		exit 1; \
	fi
	@if [ "$$(id -u)" -ne 0 ]; then \
		echo "Error: Deployment requires root privileges"; \
		exit 1; \
	fi
	bash $(SCRIPTS_DIR)/remove-overlays.sh

.PHONY: install-modules remove-modules
# Install kernel modules to rootfs
install-modules:
	@if [ ! -f "$(SCRIPTS_DIR)/install-modules.sh" ]; then \
		echo "Error: install-modules.sh not found"; \
		exit 1; \
	fi
	bash $(SCRIPTS_DIR)/install-modules.sh

# Remove kernel modules from rootfs
remove-modules:
	@if [ ! -f "$(SCRIPTS_DIR)/remove-modules.sh" ]; then \
		echo "Error: remove-modules.sh not found"; \
		exit 1; \
	fi
	bash $(SCRIPTS_DIR)/remove-modules.sh

.PHONY: install-tools remove-tools
# Install userspace tools to root filesystem
install-tools:
	@if [ ! -f "$(SCRIPTS_DIR)/install-tools.sh" ]; then \
		echo "Error: install-tools.sh not found"; \
		exit 1; \
	fi
	bash $(SCRIPTS_DIR)/install-tools.sh

# Remove userspace tools from root filesystem
remove-tools:
	@if [ ! -f "$(SCRIPTS_DIR)/remove-tools.sh" ]; then \
		echo "Error: remove-tools.sh not found"; \
		exit 1; \
	fi
	bash $(SCRIPTS_DIR)/remove-tools.sh

.PHONY: install-toolchains remove-toolchains
# Install toolchain to system
install-toolchains:
	@if [ ! -f "$(SCRIPTS_DIR)/install-toolchains.sh" ]; then \
		echo "Error: install-toolchains.sh not found"; \
		exit 1; \
	fi
	bash $(SCRIPTS_DIR)/install-toolchains.sh

# Remove toolchain from system
remove-toolchains:
	@if [ ! -f "$(SCRIPTS_DIR)/remove-toolchains.sh" ]; then \
		echo "Error: remove-toolchains.sh not found"; \
		exit 1; \
	fi
	bash $(SCRIPTS_DIR)/remove-toolchains.sh

.PHONY: setup-rust-kernel
# Setup Rust for kernel development
setup-rust-kernel:
	@if [ ! -f "$(SCRIPTS_DIR)/setup-rust-kernel.sh" ]; then \
		echo "Error: setup-rust-kernel.sh not found"; \
		exit 1; \
	fi
	bash $(SCRIPTS_DIR)/setup-rust-kernel.sh

.PHONY: help
# Help
help:
	@echo "Targets:"
	@echo "  all                     Build complete system and deploy (requires root)"
	@echo "  stage-output            Stage build output to rootfs (requires root)"
	@echo "  identify-sdcard         Identify SD card device"
	@echo "  deploy-sdcard           Deploy to SD card (requires root)"
	@echo "Install:"
	@echo "  install-overlays        Install Device Tree overlays to system (requires root)"
	@echo "  install-modules         Install kernel modules to rootfs"
	@echo "  install-tools           Install userspace tools to rootfs"
	@echo "  install-toolchains      Install toolchains to project"
	@echo "  setup-rust-kernel       Setup Rust for kernel development"
	@echo "Remove:"
	@echo "  remove-overlays         Remove Device Tree overlays from system(requires root)"
	@echo "  remove-modules          Remove kernel modules from rootfs"
	@echo "  remove-tools            Remove userspace tools from rootfs"
	@echo "  remove-toolchains       Remove toolchains from project"