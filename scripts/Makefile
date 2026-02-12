# Makefile for scripts

# Configuration
SCRIPTS_DIR     := $(shell pwd)
BUILDROOT_DIR   := $(SCRIPTS_DIR)/../buildroot
IMAGE_DIR       := $(BUILDROOT_DIR)/output/images
DRIVERS_DIR     := $(SCRIPTS_DIR)/../drivers

# Deployment settings
DEVICE          ?= /dev/sda
METHOD          ?= auto

# Auto-detect userspace tools
AVAILABLE_USERSPACE_TOOLS := $(notdir $(wildcard $(DRIVERS_DIR)/*/userspace))

# PHONY Targets
.PHONY: all help
.PHONY: identify-sdcard deploy install-tools

# Main Targets
all: identify-sdcard deploy install-tools

# Identify SD card device
identify-sdcard:
	@if [ ! -f "$(SCRIPTS_DIR)/identify-sdcard.sh" ]; then \
		echo "Error: identify-sdcard.sh not found"; \
		exit 1; \
	fi
	@bash $(SCRIPTS_DIR)/identify-sdcard.sh

# Deploy SD card image
deploy:
	@if [ ! -f "$(SCRIPTS_DIR)/deploy-to-sdcard.sh" ]; then \
		echo "Error: deploy-to-sdcard.sh not found"; \
		exit 1; \
	fi
	@if [ ! -f "$(IMAGE_DIR)/sdcard.img" ]; then \
		echo "Error: Image not found at $(IMAGE_DIR)/sdcard.img"; \
		exit 1; \
	fi
	@if [ "$$(id -u)" -ne 0 ]; then \
		echo "Error: Deployment requires root privileges"; \
		exit 1; \
	fi
	@bash $(SCRIPTS_DIR)/deploy-to-sdcard.sh $(DEVICE) $(METHOD)

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
	@bash $(SCRIPTS_DIR)/install-tools.sh

# Help
help:
	@echo "Targets:"
	@echo "  all                     Build complete system and deploy (requires root)"
	@echo "  identify-sdcard         Identify SD card device"
	@echo "  deploy                  Flash image to SD card (requires root)"
	@echo "  install-tools           Install userspace tools to rootfs (requires root)"
	@echo ""
	@echo "Options:"
	@echo "  DEVICE=$(DEVICE)        SD card device"
	@echo "  METHOD=$(METHOD)        Deployment method (auto|manual)"