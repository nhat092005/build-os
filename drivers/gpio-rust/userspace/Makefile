# Makefile for GPIO Rust Driver - Userspace Library and Tools
#
# Builds:
#   1. libgpio-rust (static library) — sysfs wrapper for gpio-rust driver
#   2. gpio-rust-ctl (CLI tool) — command-line control for GPIO22

# Toolchain Configuration
CROSS_COMPILE   ?=
CC              := $(CROSS_COMPILE)gcc
AR              := $(CROSS_COMPILE)ar
CFLAGS          := -Wall -Wextra -O2 -std=gnu11 -fPIC
LDFLAGS         :=

# Directory Configuration
USERSPACE_DIR   := $(shell pwd)
LIB_DIR         := $(USERSPACE_DIR)/lib/
TOOLS_DIR       := $(USERSPACE_DIR)/tools
BUILD_DIR       := $(USERSPACE_DIR)/../build/tools

# Library Configuration
LIB_NAME        := libgpio-rust
LIB_STATIC      := $(BUILD_DIR)/lib$(LIB_NAME).a
LIB_SHARED      := $(BUILD_DIR)/lib$(LIB_NAME).so
LIB_HEADER      := $(LIB_DIR)/libgpio-rust.h
LIB_SOURCE      := $(LIB_DIR)/libgpio-rust.c
LIB_OBJECT      := $(BUILD_DIR)/libgpio-rust.o

# Tool Configuration
TOOL_NAME       := gpio-rust-ctl
TOOL_SOURCE     := $(TOOLS_DIR)/$(TOOL_NAME).c
TOOL_OBJECT     := $(BUILD_DIR)/$(TOOL_NAME).o
TOOL_BINARY     := $(BUILD_DIR)/$(TOOL_NAME)

# PHONY Targets
.PHONY: all clean help lib static shared tools tools-clean

# Default Target
all: static tools

# Create build directory
$(BUILD_DIR):
	mkdir -p $(BUILD_DIR)

# Build static library
static: $(LIB_STATIC)

$(LIB_STATIC): $(LIB_OBJECT) | $(BUILD_DIR)
	$(AR) rcs $@ $^

# Build shared library
shared: $(LIB_SHARED)

$(LIB_SHARED): $(LIB_OBJECT) | $(BUILD_DIR)
	$(CC) -shared -o $@ $^ $(LDFLAGS)

# Compile library object
$(LIB_OBJECT): $(LIB_SOURCE) $(LIB_HEADER) | $(BUILD_DIR)
	$(CC) $(CFLAGS) -I$(LIB_DIR) -c -o $@ $<

# Build tools
tools: $(TOOL_BINARY)

$(TOOL_BINARY): $(TOOL_OBJECT) $(LIB_STATIC) | $(BUILD_DIR)
	$(CC) $(CFLAGS) -o $@ $(TOOL_OBJECT) $(LIB_STATIC) $(LDFLAGS)

# Compile tool object
$(TOOL_OBJECT): $(TOOL_SOURCE) $(LIB_HEADER) | $(BUILD_DIR)
	$(CC) $(CFLAGS) -I$(LIB_DIR) -c -o $@ $<

# Alias for library
lib: static

# Clean all
clean: tools-clean

# Clean tools build artifacts
tools-clean:
	rm -rf $(BUILD_DIR)

# Help
help:
	@echo "Build targets:"
	@echo "  all           - Build static library and CLI tool (default)"
	@echo "  static        - Build static library only"
	@echo "  shared        - Build shared library only"
	@echo "  lib           - Alias for 'static'"
	@echo "  tools         - Build CLI tool with static library"
	@echo "  clean         - Remove all build artifacts"
	@echo "  tools-clean   - Remove build directory"
