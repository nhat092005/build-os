# SPDX-License-Identifier: GPL-2.0
# Makefile for DS3231 RTC Userspace Tool

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
DOCKER_WORKDIR := $(DOCKER_CONTAINER_ROOT)/userspace

ifeq ($(IN_DOCKER),1)
  RUN :=
else
  RUN := $(DOCKER_RUN_NO_TTY)
endif

CROSS_COMPILE ?= aarch64-linux-
CC            ?= $(CROSS_COMPILE)gcc
CFLAGS        ?= -Wall -Wextra -Wshadow -Wformat-security -O2 -std=gnu11
LDFLAGS       ?=

TOOLS_DIR := tools
BUILD_DIR := ../build/tools

TOOL_NAME   := ds3231-rtc-ctl
TOOL_SOURCE := $(TOOLS_DIR)/$(TOOL_NAME).c
TOOL_OBJECT := $(BUILD_DIR)/$(TOOL_NAME).o
TOOL_BINARY := $(BUILD_DIR)/$(TOOL_NAME)

.PHONY: all clean
.PHONY: tools tools-clean

all: tools

$(BUILD_DIR):
	$(RUN) mkdir -p $(BUILD_DIR)

tools: $(TOOL_BINARY)

$(TOOL_BINARY): $(TOOL_OBJECT) | $(BUILD_DIR)
	$(RUN) $(CC) $(CFLAGS) -o $@ $(TOOL_OBJECT) $(LDFLAGS)

$(TOOL_OBJECT): $(TOOL_SOURCE) | $(BUILD_DIR)
	$(RUN) $(CC) $(CFLAGS) -c -o $@ $<

clean: tools-clean

tools-clean:
	$(RUN) rm -rf $(BUILD_DIR)
