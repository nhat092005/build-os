# SPDX-License-Identifier: GPL-2.0
# Makefile for libuart-transport library

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
DOCKER_WORKDIR := $(DOCKER_CONTAINER_ROOT)/libuart-transport

ifeq ($(IN_DOCKER),1)
  RUN :=
else
  RUN := $(DOCKER_RUN_NO_TTY)
endif

CROSS_COMPILE   ?= aarch64-linux-
CC              ?= $(CROSS_COMPILE)gcc
AR              ?= $(CROSS_COMPILE)ar
CFLAGS          ?= -Wall -Wextra -Werror -Wshadow -Wformat-security -O2 -std=gnu11 -fPIC

# Output
BUILD_DIR       := build
LIB_NAME        := libuart-transport.a
LIB_OUT         := $(BUILD_DIR)/$(LIB_NAME)

# Sources
SRCS            := uart_transport.c uart_crc.c
OBJS            := $(patsubst %.c,$(BUILD_DIR)/%.o,$(SRCS))

.PHONY: all clean

all: $(LIB_OUT)

$(BUILD_DIR):
	$(RUN) mkdir -p $(BUILD_DIR)

$(BUILD_DIR)/%.o: %.c uart_transport.h | $(BUILD_DIR)
	$(RUN) $(CC) $(CFLAGS) -c -o $@ $<

$(LIB_OUT): $(OBJS)
	$(RUN) $(AR) rcs $@ $(OBJS)

clean:
	$(RUN) rm -rf $(BUILD_DIR)

