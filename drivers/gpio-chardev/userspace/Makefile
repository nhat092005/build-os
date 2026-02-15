# Makefile for GPIO Character Device Userspace Tool

# Toolchain Configuration
CROSS_COMPILE   ?=
CC              := $(CROSS_COMPILE)gcc
CFLAGS          := -Wall -Wextra -O2

# Directory Configuration
TOOLS_DIR       := $(shell pwd)/tools
BUILD_DIR       := $(shell pwd)/../build/tools
UAPI_DIR        := $(shell pwd)/../include/uapi
INCLUDES        := -I$(UAPI_DIR)

# Auto detect source files
SRCS            := $(wildcard $(TOOLS_DIR)/*.c)

# Target Binaries
TARGETS         := $(patsubst $(TOOLS_DIR)/%.c,%,$(SRCS))

# PHONY Targets
.PHONY: all clean help
.PHONY: tools tools-clean

# Main Targets
all: tools 

tools: $(BUILD_DIR) $(TARGETS)

# Directory Creation
$(BUILD_DIR):
	mkdir -p $(BUILD_DIR)

# Build Userspace Tool
%: $(TOOLS_DIR)/%.c
	$(CC) $(CFLAGS) $(INCLUDES) -o $(BUILD_DIR)/$@ $<

# Clean Targets
clean: tools-clean

# Clean Userspace Tool
tools-clean:
	rm -rf $(BUILD_DIR)

# Help
help:
	@echo "Targets:"
	@echo "  all              Build GPIO Character Device control tool (default)"
	@echo "  tools            Build userspace tools" 
	@echo "  clean            Remove build artifacts"
	@echo "  tools-clean      Clean tools build artifacts"