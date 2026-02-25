# SPDX-License-Identifier: GPL-2.0
# Makefile for GPIO Character Device DTS Overlay

BUILD_DIR	:= $(shell pwd)/../build/dtbo
DTC			?= dtc
DTC_FLAGS	?= -@ -I dts -O dtb -Wno-unit_address_vs_reg

# Source file
DTS := gpio-chardev-overlay.dts

# Output file
DTBO_OUT := gpio-chardev.dtbo

.PHONY: all dtbo clean dtbo-clean help

# Default target
all: dtbo

# Build Device Tree overlay
dtbo: $(BUILD_DIR) $(DTBO_OUT)

# Create build directory
$(BUILD_DIR):
	mkdir -p $(BUILD_DIR)

# Compile DTS to DTBO
$(DTBO_OUT): $(DTS)
	@echo "Device Tree Overlay: $< -> $@"
	$(DTC) $(DTC_FLAGS) -o $(BUILD_DIR)/$@ $<

# Clean build artifacts
clean: dtbo-clean

# Clean compiled DTS artifacts
dtbo-clean:
	rm -rf $(BUILD_DIR)

# Help
help:
	@echo "Targets:"
	@echo "  all / dtbo    Compile gpio-chardev.dtbo"
	@echo "  clean         Remove build artifacts"
