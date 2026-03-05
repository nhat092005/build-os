# SPDX-License-Identifier: GPL-2.0
# Makefile for BH1750 Ambient Light Sensor Driver

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
DOCKER_WORKDIR := $(DOCKER_CONTAINER_ROOT)/drivers/bh1750

ifeq ($(IN_DOCKER),1)
  RUN :=
else
  RUN := $(DOCKER_RUN_NO_TTY)
endif

DTC       ?= dtc
DTC_FLAGS ?= -@ -I dts -O dtb -Wno-unit_address_vs_reg

ARCH          ?= arm64
CROSS_COMPILE ?= aarch64-linux-
KERNEL_DIR    ?= $(CONTAINER_ROOT)/buildroot/output/build/linux-custom

.PHONY: all clean
.PHONY: dtbo dtbo-clean
.PHONY: modules modules-clean
.PHONY: tools tools-clean

all: dtbo modules tools

dtbo:
	$(RUN) $(MAKE) -C dts dtbo \
		DTC=$(DTC) \
		DTC_FLAGS="$(DTC_FLAGS)"

modules:
	$(RUN) $(MAKE) -C src modules \
		ARCH=$(ARCH) \
		CROSS_COMPILE=$(CROSS_COMPILE) \
		KERNEL_DIR=$(KERNEL_DIR)

tools:
	@:

clean: dtbo-clean modules-clean tools-clean

dtbo-clean:
	$(RUN) $(MAKE) -C dts dtbo-clean

modules-clean:
	$(RUN) $(MAKE) -C src modules-clean

tools-clean:
	@:
