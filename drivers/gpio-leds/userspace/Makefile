# SPDX-License-Identifier: GPL-2.0
# Makefile for GPIO LEDS Driver Userspace Tool and Library

CROSS_COMPILE ?= aarch64-linux-
CC := $(CROSS_COMPILE)gcc
AR := $(CROSS_COMPILE)ar
CFLAGS := -Wall -Wextra -O2 -std=gnu11 -fPIC
LDFLAGS :=

USERSPACE_DIR := $(shell pwd)
LIB_DIR := $(USERSPACE_DIR)/lib/libled
TOOLS_DIR := $(USERSPACE_DIR)/tools
BUILD_DIR := $(USERSPACE_DIR)/../build/tools

LIB_NAME := libled
LIB_STATIC := $(BUILD_DIR)/lib$(LIB_NAME).a
LIB_SHARED := $(BUILD_DIR)/lib$(LIB_NAME).so
LIB_HEADER := $(LIB_DIR)/libled.h
LIB_SOURCE := $(LIB_DIR)/libled.c
LIB_OBJECT := $(BUILD_DIR)/libled.o

TOOL_NAME := gpio-leds-ctl
TOOL_SOURCE := $(TOOLS_DIR)/$(TOOL_NAME).c
TOOL_OBJECT := $(BUILD_DIR)/$(TOOL_NAME).o
TOOL_BINARY := $(BUILD_DIR)/$(TOOL_NAME)

.PHONY: all clean 
.PHONY: lib static shared 
.PHONY: tools tools-clean

all: static tools

$(BUILD_DIR):
	mkdir -p $(BUILD_DIR)

static: $(LIB_STATIC)

$(LIB_STATIC): $(LIB_OBJECT) | $(BUILD_DIR)
	$(AR) rcs $@ $^

shared: $(LIB_SHARED)

$(LIB_SHARED): $(LIB_OBJECT) | $(BUILD_DIR)
	$(CC) -shared -o $@ $^ $(LDFLAGS)

$(LIB_OBJECT): $(LIB_SOURCE) $(LIB_HEADER) | $(BUILD_DIR)
	$(CC) $(CFLAGS) -I$(LIB_DIR) -c -o $@ $<

tools: $(TOOL_BINARY)

$(TOOL_BINARY): $(TOOL_OBJECT) $(LIB_STATIC) | $(BUILD_DIR)
	$(CC) $(CFLAGS) -o $@ $(TOOL_OBJECT) $(LIB_STATIC) $(LDFLAGS)

$(TOOL_OBJECT): $(TOOL_SOURCE) $(LIB_HEADER) | $(BUILD_DIR)
	$(CC) $(CFLAGS) -I$(LIB_DIR) -c -o $@ $<

lib: static

clean: tools-clean

tools-clean:
	rm -rf $(BUILD_DIR)
