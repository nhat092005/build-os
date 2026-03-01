# SPDX-License-Identifier: GPL-2.0
# Makefile for BH1750 Device Tree Overlays

DTC ?= dtc
DTC_FLAGS ?= -@ -I dts -O dtb -Wno-unit_address_vs_reg -Wno-label_is_string

BUILD_DIR := $(shell pwd)/../build/dtbo

DTS := bh1750-overlay.dts

DTBO_OUT := bh1750.dtbo

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
