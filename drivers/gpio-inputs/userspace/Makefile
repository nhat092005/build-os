# SPDX-License-Identifier: GPL-2.0-only
# Makefile for GPIO Inputs Userspace Space Tool

CROSS_COMPILE ?= aarch64-linux-
CC := $(CROSS_COMPILE)gcc
CFLAGS := -Wall -Wextra -O2 -std=gnu11
LDFLAGS :=

TOOLS_DIR := $(shell pwd)/tools
BUILD_DIR := $(shell pwd)/../build/tools

TOOL_NAME := gpio-inputs-test
TOOL_SOURCE := $(TOOLS_DIR)/$(TOOL_NAME).c
TOOL_BINARY := $(BUILD_DIR)/$(TOOL_NAME)

.PHONY: all clean
.PHONY: tools tools-clean

all: tools

$(BUILD_DIR):
	mkdir -p $(BUILD_DIR)

tools: $(TOOL_BINARY)

$(TOOL_BINARY): $(TOOL_SOURCE) | $(BUILD_DIR)
	$(CC) $(CFLAGS) -o $@ $< $(LDFLAGS)

clean: tools-clean

tools-clean:
	rm -rf $(BUILD_DIR)
