# SPDX-License-Identifier: GPL-2.0
# Makefile for BH1750 Ambient Light Sensor Kernel Module

_MK_DIR := $(dir $(abspath $(lastword $(MAKEFILE_LIST))))
_FIND_ROOT := $(firstword $(foreach d,\
    $(_MK_DIR) \
    $(abspath $(_MK_DIR)/..) \
    $(abspath $(_MK_DIR)/../..) \
    $(abspath $(_MK_DIR)/../../..) \
    $(abspath $(_MK_DIR)/../../../..) \
  ,$(if $(wildcard $(d)/mk/docker.mk),$(d))))

ifneq ($(_FIND_ROOT),)
  include $(_FIND_ROOT)/mk/docker.mk
endif

IN_DOCKER := $(shell test -f /.dockerenv && echo 1)

ifeq ($(IN_DOCKER),1)
  CONTAINER_ROOT := $(_FIND_ROOT)
else
  CONTAINER_ROOT := $(DOCKER_CONTAINER_ROOT)
endif

DOCKER_MOUNT   := $(_FIND_ROOT):$(DOCKER_CONTAINER_ROOT)
DOCKER_WORKDIR := $(DOCKER_CONTAINER_ROOT)/drivers/bh1750/src

ifeq ($(IN_DOCKER),1)
  RUN :=
else
  RUN := $(DOCKER_RUN_NO_TTY)
endif

ARCH          ?= arm64
CROSS_COMPILE ?= aarch64-linux-
KERNEL_DIR    ?= $(CONTAINER_ROOT)/buildroot/output/build/linux-custom

BUILD_DIR := ../build/module

.PHONY: all clean 
.PHONY: modules modules-clean

all: modules

modules:
	$(RUN) mkdir -p $(BUILD_DIR)
	$(RUN) $(MAKE) -C $(KERNEL_DIR) \
		M=$(if $(filter 1,$(IN_DOCKER)),$(CURDIR),$(DOCKER_CONTAINER_ROOT)/drivers/bh1750/src) \
		ARCH=$(ARCH) \
		CROSS_COMPILE=$(CROSS_COMPILE) \
		modules
	$(RUN) cp -f *.ko $(BUILD_DIR)/

clean: modules-clean

modules-clean:
	@if [ -d "$(KERNEL_DIR)" ]; then \
	    $(RUN) $(MAKE) -C $(KERNEL_DIR) \
	        M=$(if $(filter 1,$(IN_DOCKER)),$(CURDIR),$(DOCKER_CONTAINER_ROOT)/drivers/bh1750/src) \
	        clean 2>/dev/null || true; \
	fi
	# Remove kbuild artifacts directly from src/ (no KERNEL_DIR required)
	$(RUN) rm -f  *.ko *.o *.mod *.mod.c \
	              modules.order Module.symvers
	$(RUN) rm -f  .*.cmd ..*.cmd .module-common.o
	$(RUN) rm -rf .tmp_versions $(BUILD_DIR)
