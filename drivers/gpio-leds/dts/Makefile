# SPDX-License-Identifier: GPL-2.0
# Makefile for Device Tree Overlays

BUILD_DIR 	:= $(shell pwd)/../build/dtbo
DTC         ?= dtc
DTC_FLAGS   ?= -@ -I dts -O dtb -Wno-unit_address_vs_reg

# Source file
DTS := gpio-leds-overlay.dts

# Output file
DTBO := gpio-leds.dtbo

.PHONY: all dtbo clean dtbo-clean help

# Default target
all: dtbo

# Build Device Tree overlay
dtbo: $(BUILD_DIR) $(DTBO)

# Create build directory
$(BUILD_DIR):
	mkdir -p $(BUILD_DIR)

# Compile DTS to DTBO
$(DTBO): $(DTS)
	@echo "Compiling Device Tree Overlay: $< -> $@"
	$(DTC) $(DTC_FLAGS) -o $(BUILD_DIR)/$@ $<

# Clean build artifacts
clean: dtbo-clean

# Clean compiled DTS artifacts
dtbo-clean:
	rm -rf $(BUILD_DIR)

# help
help:
	@echo "Targets:"
	@echo "  all              Compile DTS to DTBO (default)"
	@echo "  dtbo             Compile DTS to DTBO"
	@echo "  clean            Remove compiled overlay"
	@echo "  dtbo-clean       Remove compiled DTS artifacts"