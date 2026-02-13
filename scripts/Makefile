# Makefile for scripts 

# Configuration
SCRIPTS_DIR     := $(shell pwd)

# Deployment settings
DEVICE          ?= /dev/sda

# PHONY Targets
.PHONY: all help
.PHONY: stage-output install-tools identify-sdcard deploy-sdcard 

# Main Targets
all: stage-output install-tools identify-sdcard deploy-sdcard 

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
	@if [ "$$(id -u)" -ne 0 ]; then \
		echo "Error: Installing tools requires root privileges"; \
		exit 1; \
	fi
	bash $(SCRIPTS_DIR)/install-tools.sh

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
	@echo "  stage-output            Stage build output to rootfs (requires root)"
	@echo "  install-tools           Install userspace tools to rootfs (requires root)"
	@echo "  identify-sdcard         Identify SD card device"
	@echo "  deploy-sdcard           Deploy to SD card (requires root)"