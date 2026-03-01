# SPDX-License-Identifier: GPL-2.0
# Makefile for GPIO Inputs Kernel Module

ARCH ?= arm64

BUILDROOT_DIR ?= $(shell pwd)/../../../buildroot
KERNEL_DIR ?= $(BUILDROOT_DIR)/output/build/linux-custom

CROSS_COMPILE ?= aarch64-linux-

BUILD_DIR := $(CURDIR)/../build/module

.PHONY: all clean
.PHONY: modules modules-clean

all: modules

modules:
	mkdir -p $(BUILD_DIR)
	$(MAKE) -C $(KERNEL_DIR) \
		M=$(CURDIR) \
		ARCH=$(ARCH) \
		CROSS_COMPILE=$(CROSS_COMPILE) \
		modules
	cp -f $(CURDIR)/gpio_inputs.ko $(BUILD_DIR)/gpio_inputs.ko

clean: modules-clean

modules-clean:
	@if [ -d "$(KERNEL_DIR)" ]; then \
		$(MAKE) -C $(KERNEL_DIR) M=$(CURDIR) clean 2>/dev/null || true; \
	fi
	# Remove kbuild artifacts directly from src/ (no KERNEL_DIR required)
	rm -f  $(CURDIR)/*.ko $(CURDIR)/*.o $(CURDIR)/*.mod $(CURDIR)/*.mod.c \
	       $(CURDIR)/modules.order $(CURDIR)/Module.symvers
	rm -f  $(CURDIR)/.*.cmd $(CURDIR)/..*.cmd
	rm -f  $(CURDIR)/.module-common.o
	rm -rf $(CURDIR)/.tmp_versions
	rm -rf $(BUILD_DIR)
