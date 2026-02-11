# Makefile for GPIO Character Device userspace tools

# Toolchain Configuration
CC              ?= gcc
CFLAGS          ?= -Wall -Wextra -O2

# Directory Configuration
BUILD_DIR       := ../../build/tools
UAPI_DIR        := ../../include/uapi
INCLUDES        := -I$(UAPI_DIR)

# Target Binaries
TARGETS         := gpio-chardev-ioctl

# PHONY Targets
.PHONY: all clean install help

# Main Targets
all: $(BUILD_DIR) $(TARGETS)

# Directory Creation
$(BUILD_DIR):
	@mkdir -p $(BUILD_DIR)

# Target Builds
gpio-chardev-ioctl: gpio-chardev-ioctl.c
	@echo "Building gpio-chardev-ioctl tool"
	@$(CC) $(CFLAGS) $(INCLUDES) -o $(BUILD_DIR)/$@ $<

# Clean Targets
clean:
	@echo "Cleaning tools build artifacts"
	@rm -rf $(BUILD_DIR)

# Help
help:
	@echo "Targets:"
	@echo "  all            Build GPIO Character Device control tool (default)"
	@echo "  gpio-chardev-ioctl      Build GPIO Character Device control tool"
	@echo "  clean          Remove build artifacts"
	@echo ""
	@echo "Tool Description:"
	@echo "  gpio-chardev-ioctl      Controls /dev/gpio-chardev via ioctl (requires driver)"
	@echo ""
	@echo "Usage:"
	@echo "  gpio-chardev-ioctl on               # Turn GPIO on"
	@echo "  gpio-chardev-ioctl off              # Turn GPIO off"
	@echo "  gpio-chardev-ioctl toggle           # Toggle GPIO"
	@echo "  gpio-chardev-ioctl get              # Get GPIO state"
	@echo "  gpio-chardev-ioctl gpio             # Get GPIO pin number"
	@echo "  gpio-chardev-ioctl blink 20 300 300 # Blink 20 times (300ms on/off)"