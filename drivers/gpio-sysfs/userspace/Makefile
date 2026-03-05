# SPDX-License-Identifier: GPL-2.0
# Makefile for GPIO Sysfs Userspace Tool and Library

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
AR            ?= $(CROSS_COMPILE)ar
CFLAGS        ?= -Wall -Wextra -O2 -std=gnu11 -fPIC
LDFLAGS       ?=

LIB_DIR := lib
TOOLS_DIR := tools
BUILD_DIR := ../build/tools

LIB_NAME := libio
LIB_STATIC := $(BUILD_DIR)/lib$(LIB_NAME).a
LIB_SHARED := $(BUILD_DIR)/lib$(LIB_NAME).so
LIB_HEADER := $(LIB_DIR)/libio.h
LIB_SOURCE := $(LIB_DIR)/libio.c
LIB_OBJECT := $(BUILD_DIR)/libio.o

TOOL_NAME := gpio-sysfs-ctl
TOOL_SOURCE := $(TOOLS_DIR)/$(TOOL_NAME).c
TOOL_OBJECT := $(BUILD_DIR)/$(TOOL_NAME).o
TOOL_BINARY := $(BUILD_DIR)/$(TOOL_NAME)

.PHONY: all clean
.PHONY: lib static shared
.PHONY: tools tools-clean

all: static tools

$(BUILD_DIR):
	$(RUN) mkdir -p $(BUILD_DIR)

static: $(LIB_STATIC)

$(LIB_STATIC): $(LIB_OBJECT) | $(BUILD_DIR)
	$(RUN) $(AR) rcs $@ $^

shared: $(LIB_SHARED)

$(LIB_SHARED): $(LIB_OBJECT) | $(BUILD_DIR)
	$(RUN) $(CC) -shared -o $@ $^ $(LDFLAGS)

$(LIB_OBJECT): $(LIB_SOURCE) $(LIB_HEADER) | $(BUILD_DIR)
	$(RUN) $(CC) $(CFLAGS) -I$(LIB_DIR) -c -o $@ $<

tools: $(TOOL_BINARY)

$(TOOL_BINARY): $(TOOL_OBJECT) $(LIB_STATIC) | $(BUILD_DIR)
	$(RUN) $(CC) $(CFLAGS) -o $@ $(TOOL_OBJECT) $(LIB_STATIC) $(LDFLAGS)

$(TOOL_OBJECT): $(TOOL_SOURCE) $(LIB_HEADER) | $(BUILD_DIR)
	$(RUN) $(CC) $(CFLAGS) -I$(LIB_DIR) -c -o $@ $<

lib: static

clean: tools-clean

tools-clean:
	$(RUN) rm -rf $(BUILD_DIR)
