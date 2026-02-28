# SPDX-License-Identifier: GPL-2.0
# Makefile for GPIO Character Device Userspace Tool

CROSS_COMPILE ?= aarch64-linux-
CC := $(CROSS_COMPILE)gcc
CFLAGS := -Wall -Wextra -O2

TOOLS_DIR := $(shell pwd)/tools
BUILD_DIR := $(shell pwd)/../build/tools
UAPI_DIR := $(shell pwd)/../include/uapi
INCLUDES := -I$(UAPI_DIR)

SRCS := $(wildcard $(TOOLS_DIR)/*.c)

TARGETS := $(patsubst $(TOOLS_DIR)/%.c,%,$(SRCS))

.PHONY: all clean
.PHONY: tools tools-clean

all: tools 

tools: $(BUILD_DIR) $(TARGETS)

$(BUILD_DIR):
	mkdir -p $(BUILD_DIR)

%: $(TOOLS_DIR)/%.c
	$(CC) $(CFLAGS) $(INCLUDES) -o $(BUILD_DIR)/$@ $<

clean: tools-clean

tools-clean:
	rm -rf $(BUILD_DIR)
