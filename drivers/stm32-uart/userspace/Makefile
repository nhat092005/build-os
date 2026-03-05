# SPDX-License-Identifier: GPL-2.0 
# Makefile for STM32 UART Userspace Tool and Library

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

CROSS_COMPILE ?=
CC            ?= $(CROSS_COMPILE)gcc
AR            ?= $(CROSS_COMPILE)ar
CFLAGS        ?= -Wall -Wextra -Werror -Wshadow -Wformat-security -O2 -std=gnu11

COMMON_DIR    := $(_FIND_ROOT)/drivers/common
TRANSPORT_DIR := $(COMMON_DIR)/libuart-transport
TRANSPORT_LIB := $(TRANSPORT_DIR)/build/libuart-transport.a

LIB_DIR   := lib
TOOLS_DIR := tools
BUILD_DIR := ../build/tools

LIB_SRCS := $(LIB_DIR)/stm32.c
LIB_OBJS := $(patsubst $(LIB_DIR)/%.c,$(BUILD_DIR)/%.o,$(LIB_SRCS))
LIB_OUT  := $(BUILD_DIR)/libstm32.a

TOOL_NAME := stm32-ctl
TOOL_SRC  := $(TOOLS_DIR)/$(TOOL_NAME).c
TOOL_OBJ  := $(BUILD_DIR)/$(TOOL_NAME).o
TOOL_BIN  := $(BUILD_DIR)/$(TOOL_NAME)

INCLUDES := -I$(LIB_DIR) -I$(TRANSPORT_DIR)

.PHONY: all clean transport
.PHONY: tools tools-clean

all: tools

transport:
	$(RUN) $(MAKE) -C $(TRANSPORT_DIR) CC=$(CC) AR=$(AR) clean all

$(TRANSPORT_LIB): transport
	@:

$(BUILD_DIR):
	$(RUN) mkdir -p $(BUILD_DIR)

$(BUILD_DIR)/%.o: $(LIB_DIR)/%.c | $(BUILD_DIR)
	$(RUN) $(CC) $(CFLAGS) $(INCLUDES) -c -o $@ $<

$(LIB_OUT): $(LIB_OBJS)
	$(RUN) $(AR) rcs $@ $(LIB_OBJS)

$(TOOL_OBJ): $(TOOL_SRC) | $(BUILD_DIR)
	$(RUN) $(CC) $(CFLAGS) $(INCLUDES) -c -o $@ $<

$(TOOL_BIN): $(TOOL_OBJ) $(LIB_OUT) $(TRANSPORT_LIB)
	$(RUN) $(CC) $(CFLAGS) -o $@ $(TOOL_OBJ) $(LIB_OUT) $(TRANSPORT_LIB)

tools: $(TRANSPORT_LIB) $(TOOL_BIN)

clean: tools-clean
	$(RUN) $(MAKE) -C $(TRANSPORT_DIR) clean

tools-clean:
	$(RUN) rm -rf $(BUILD_DIR)
