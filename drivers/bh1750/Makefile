# SPDX-License-Identifier: GPL-2.0
# Makefile for BH1750 Ambient Light Sensor Driver

DTS_DIR        := $(shell pwd)/dts
SRC_DIR        := $(shell pwd)/src

export ARCH CROSS_COMPILE KERNEL_DIR

.PHONY: all clean
.PHONY: dtbo dtbo-clean
.PHONY: modules modules-clean
.PHONY: tools tools-clean

all: dtbo modules

dtbo:
	$(MAKE) -C dts dtbo

dtbo-clean:
	$(MAKE) -C dts dtbo-clean

modules:
	$(MAKE) -C src modules

modules-clean:
	$(MAKE) -C src modules-clean

tools:
	@:

tools-clean:
	@:

clean: dtbo-clean modules-clean
