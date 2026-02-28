# SPDX-License-Identifier: GPL-2.0
# Makefile for GPIO Character Device Driver

DTS_DIR := $(shell pwd)/dts
SRC_DIR := $(shell pwd)/src
USERSPACE_DIR := $(shell pwd)/userspace

export ARCH CROSS_COMPILE KERNEL_DIR

.PHONY: all clean
.PHONY: dtbo dtbo-clean
.PHONY: modules modules-clean
.PHONY: tools tools-clean

all: dtbo modules tools

dtbo:
	$(MAKE) -C dts dtbo

dtbo-clean:
	$(MAKE) -C dts dtbo-clean

modules:
	$(MAKE) -C src modules

tools:
	$(MAKE) -C userspace tools

clean: dtbo-clean modules-clean tools-clean

modules-clean:
	$(MAKE) -C src modules-clean

tools-clean:
	$(MAKE) -C userspace tools-clean
