# Makefile for DS3231 RTC Userspace Tool

# Toolchain Configuration
CROSS_COMPILE   ?=
CC              := $(CROSS_COMPILE)gcc
CFLAGS          := -Wall -Wextra -Wshadow -Wformat-security -O2 -std=gnu11
LDFLAGS         :=

# Directory Configuration
USERSPACE_DIR   := $(shell pwd)
TOOLS_DIR       := $(USERSPACE_DIR)/tools
BUILD_DIR       := $(USERSPACE_DIR)/../build/tools

# Tool Configuration
TOOL_NAME       := ds3231-rtc-ctl
TOOL_SOURCE     := $(TOOLS_DIR)/$(TOOL_NAME).c
TOOL_OBJECT     := $(BUILD_DIR)/$(TOOL_NAME).o
TOOL_BINARY     := $(BUILD_DIR)/$(TOOL_NAME)

# PHONY Targets
.PHONY: all clean help tools tools-clean

# Default Target
all: tools

# Create build directory
$(BUILD_DIR):
	mkdir -p $(BUILD_DIR)

# Build tools
tools: $(TOOL_BINARY)

$(TOOL_BINARY): $(TOOL_OBJECT) | $(BUILD_DIR)
	$(CC) $(CFLAGS) -o $@ $(TOOL_OBJECT) $(LDFLAGS)

# Compile tool object
$(TOOL_OBJECT): $(TOOL_SOURCE) | $(BUILD_DIR)
	$(CC) $(CFLAGS) -c -o $@ $<

# Clean all
clean: tools-clean

# Clean tools build artifacts
tools-clean:
	rm -rf $(BUILD_DIR)

# Help
help:
	@echo "Build targets:"
	@echo "  all           - Build CLI tool (default)"
	@echo "  tools         - Build CLI tool"
	@echo "  clean         - Remove build artifacts"
	@echo "  tools-clean   - Remove build artifacts"
