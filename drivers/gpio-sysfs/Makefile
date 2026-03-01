# SPDX-License-Identifier: GPL-2.0
# Makefile for GPIO Sysfs Driver 

USERSPACE_DIR  := $(shell pwd)/userspace

export ARCH CROSS_COMPILE KERNEL_DIR

.PHONY: all clean
.PHONY: tools tools-clean
.PHONY: modules modules-clean dtbo dtbo-clean

all: tools

tools:
	$(MAKE) -C userspace tools

clean: tools-clean

tools-clean:
	$(MAKE) -C userspace tools-clean

modules:
	@:

modules-clean:
	@:

dtbo:
	@:

dtbo-clean:
	@:
