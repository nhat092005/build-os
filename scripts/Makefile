# Makefile for scripts 

# Configuration
SCRIPTS_DIR     := $(shell pwd)

# Deployment settings
DEVICE          ?= /dev/sda

# PHONY Targets
.PHONY: all help
.PHONY: stage-output identify-sdcard deploy-sdcard
.PHONY: install-tools remove-tools
.PHONY: install-overlays remove-overlays

# Main Targets
all: stage-output identify-sdcard deploy-sdcard 

# Stage output files for deployment
stage-output:
	@if [ ! -f "$(SCRIPTS_DIR)/stage-output.sh" ]; then \
		echo "Error: stage-output.sh not found"; \
		exit 1; \
	fi
	bash $(SCRIPTS_DIR)/stage-output.sh $(DEVICE) $(METHOD)

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

# Install Device Tree overlays to system
install-overlays:
	@if [ ! -f "$(SCRIPTS_DIR)/install-overlays.sh" ]; then \
		echo "Error: install-overlays.sh not found"; \
		exit 1; \
	fi
	bash $(SCRIPTS_DIR)/install-overlays.sh

# Remove Device Tree overlays from system
remove-overlays:
	@if [ ! -f "$(SCRIPTS_DIR)/remove-overlays.sh" ]; then \
		echo "Error: remove-overlays.sh not found"; \
		exit 1; \
	fi
	bash $(SCRIPTS_DIR)/remove-overlays.sh

# Identify SD card device
identify-sdcard:
	@if [ ! -f "$(SCRIPTS_DIR)/identify-sdcard.sh" ]; then \
		echo "Error: identify-sdcard.sh not found"; \
		exit 1; \
	fi
	bash $(SCRIPTS_DIR)/identify-sdcard.sh

# Help
help:
	@echo "Targets:"
	@echo "  all                     Build complete system and deploy (requires root)"
	@echo "  stage-output            Stage build output to rootfs"
	@echo "  identify-sdcard         Identify SD card device"
	@echo "  deploy-sdcard           Deploy to SD card (requires root)"
	@echo "Install:"
	@echo "  install-overlays        Install Device Tree overlays to system"
	@echo "  install-tools           Install userspace tools to rootfs"
	@echo "Remove:"
	@echo "  remove-overlays         Remove Device Tree overlays from system"
	@echo "  remove-tools            Remove userspace tools from rootfs"