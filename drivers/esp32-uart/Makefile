# SPDX-License-Identifier: GPL-2.0
# Makefile for ESP32 UART Driver

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
DOCKER_WORKDIR := $(DOCKER_CONTAINER_ROOT)/drivers/esp32-uart

ifeq ($(IN_DOCKER),1)
  RUN :=
else
  RUN := $(DOCKER_RUN_NO_TTY)
endif

CROSS_COMPILE ?= aarch64-linux-

CC 		?= $(CROSS_COMPILE)gcc
AR 		?= $(CROSS_COMPILE)ar
CFLAGS  ?= -Wall -Wextra -Werror -Wshadow -Wformat-security -O2 -std=gnu11

.PHONY: all clean
.PHONY: dtbo dtbo-clean
.PHONY: modules modules-clean 
.PHONY: tools tools-clean

all: dtbo modules tools

dtbo:
	@:

modules:
	@:

tools:
	$(RUN) $(MAKE) -C userspace tools \
		CROSS_COMPILE=$(CROSS_COMPILE) \
		CC=$(CC) \
		AR=$(AR) \
		CFLAGS="$(CFLAGS)" \

clean: dtbo-clean modules-clean tools-clean

dtbo-clean:
	@:

modules-clean:
	@:

tools-clean:
	$(RUN) $(MAKE) -C userspace tools-clean
