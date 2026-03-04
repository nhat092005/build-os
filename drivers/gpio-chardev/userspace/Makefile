# SPDX-License-Identifier: GPL-2.0
# Makefile for GPIO Character Device Userspace Tool

DRIVER_ROOT := $(abspath $(dir $(lastword $(MAKEFILE_LIST)))/..)

# Walk-up: find project root containing mk/docker.mk
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

# Mount driver root: ../include/uapi and ../build/tools are accessible.
# -w .../userspace so relative paths (tools/, ../build/) resolve correctly.
DOCKER_MOUNT   := $(DRIVER_ROOT):$(DOCKER_CONTAINER_ROOT)
DOCKER_WORKDIR := $(DOCKER_CONTAINER_ROOT)/userspace

ifeq ($(IN_DOCKER),1)
	RUN :=
else
	RUN := $(DOCKER_RUN_NO_TTY)
endif

CROSS_COMPILE ?= aarch64-linux-
CC    ?= $(CROSS_COMPILE)gcc
CFLAGS ?= -Wall -Wextra -O2

# Relative paths — resolved relative to workdir $(DOCKER_CONTAINER_ROOT)/userspace
TOOLS_DIR := tools
BUILD_DIR := ../build/tools
UAPI_DIR  := ../include/uapi
INCLUDES  := -I$(UAPI_DIR)

SRCS    := $(wildcard $(TOOLS_DIR)/*.c)
TARGETS := $(patsubst $(TOOLS_DIR)/%.c,%,$(SRCS))

.PHONY: all clean tools tools-clean

all: tools

tools: $(BUILD_DIR) $(TARGETS)

$(BUILD_DIR):
	$(RUN) mkdir -p $(BUILD_DIR)

%: $(TOOLS_DIR)/%.c
	$(RUN) $(CC) $(CFLAGS) $(INCLUDES) -o $(BUILD_DIR)/$@ $<

clean: tools-clean

tools-clean:
	$(RUN) rm -rf $(BUILD_DIR)
