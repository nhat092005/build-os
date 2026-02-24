# SPDX-License-Identifier: GPL-2.0
# Makefile for Device Tree Overlays

BUILD_DIR 	:= $(shell pwd)/../build/dtbo

# Prefer kernel-built dtc when KERNEL_DIR is set, fall back to system dtc
ifndef KERNEL_DIR
    KERNEL_DIR := $(shell pwd)/../../buildroot/output/build/linux-custom
endif
KERNEL_DTC := $(KERNEL_DIR)/scripts/dtc/dtc
DTC         ?= $(shell test -x "$(KERNEL_DTC)" && echo "$(KERNEL_DTC)" || echo "dtc")
DTC_FLAGS   ?= -@ -I dts -O dtb -Wno-unit_address_vs_reg

# Source file
DTS := ds3231-rtc-overlay.dts

# Output file
DTBO := ds3231-rtc.dtbo

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
	@echo "Device Tree Overlay: $< -> $@"
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
