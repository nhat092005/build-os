# SPDX-License-Identifier: GPL-2.0
# Makefile for GPIO Character Device Tree Overlay

DRIVER_ROOT := $(abspath $(dir $(lastword $(MAKEFILE_LIST)))/..)

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

DOCKER_MOUNT   := $(DRIVER_ROOT):$(DOCKER_CONTAINER_ROOT)
DOCKER_WORKDIR := $(DOCKER_CONTAINER_ROOT)/dts

ifeq ($(IN_DOCKER),1)
	RUN :=
else
	RUN := $(DOCKER_RUN_NO_TTY)
endif

DTC       ?= dtc
DTC_FLAGS ?= -@ -I dts -O dtb -Wno-unit_address_vs_reg

BUILD_DIR := ../build/dtbo
DTS       := gpio-chardev-overlay.dts
DTBO_OUT  := gpio-chardev.dtbo

.PHONY: all clean dtbo dtbo-clean

all: dtbo

dtbo: $(BUILD_DIR) $(DTBO_OUT)

$(BUILD_DIR):
	$(RUN) mkdir -p $(BUILD_DIR)

$(DTBO_OUT): $(DTS)
	@echo "Device Tree Overlay: $< -> $@"
	$(RUN) $(DTC) $(DTC_FLAGS) -o $(BUILD_DIR)/$@ $<

clean: dtbo-clean

dtbo-clean:
	$(RUN) rm -rf $(BUILD_DIR)
