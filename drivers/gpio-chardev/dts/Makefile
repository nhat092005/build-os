# SPDX-License-Identifier: GPL-2.0
# Makefile for GPIO Character Device Tree Overlay

DTC ?= dtc
DTC_FLAGS ?= -@ -I dts -O dtb -Wno-unit_address_vs_reg

BUILD_DIR := $(shell pwd)/../build/dtbo

DTS := gpio-chardev-overlay.dts

DTBO_OUT := gpio-chardev.dtbo

.PHONY: all clean
.PHONY: dtbo dtbo-clean

all: dtbo

dtbo: $(BUILD_DIR) $(DTBO_OUT)

$(BUILD_DIR):
	mkdir -p $(BUILD_DIR)

$(DTBO_OUT): $(DTS)
	@echo "Device Tree Overlay: $< -> $@"
	$(DTC) $(DTC_FLAGS) -o $(BUILD_DIR)/$@ $<

clean: dtbo-clean

dtbo-clean:
	rm -rf $(BUILD_DIR)
