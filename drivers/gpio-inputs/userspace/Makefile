# SPDX-License-Identifier: GPL-2.0-only
# Makefile for GPIO Inputs Userspace Space Tool

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
CFLAGS        ?= -Wall -Wextra -O2 -std=gnu11
LDFLAGS       ?=

TOOLS_DIR := $(shell pwd)/tools
BUILD_DIR := $(shell pwd)/../build/tools

SRCS    := $(wildcard $(TOOLS_DIR)/*.c)
TARGETS := $(patsubst $(TOOLS_DIR)/%.c,%,$(SRCS))

.PHONY: all clean
.PHONY: tools tools-clean

all: tools

$(BUILD_DIR):
	$(RUN) mkdir -p $(BUILD_DIR)

tools: $(TARGETS)

%: $(TOOLS_DIR)/%.c | $(BUILD_DIR)
	$(RUN) $(CC) $(CFLAGS) -o $(BUILD_DIR)/$@ $< $(LDFLAGS)

clean: tools-clean

tools-clean:
	$(RUN) rm -rf $(BUILD_DIR)
