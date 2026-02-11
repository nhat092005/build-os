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
gpio_chardev_ioctl: gpio_chardev_ioctl.c
	@echo "Building gpio_chardev_ioctl tool"
	@$(CC) $(CFLAGS) $(INCLUDES) -o $(BUILD_DIR)/$@ $<

# Clean Targets
clean:
	@echo "Cleaning tools build artifacts"
	@rm -rf $(BUILD_DIR)

# Help
help:
	@echo "Targets:"
	@echo "  all            Build LED control tool (default)"
	@echo "  gpio_chardev_ioctl      Build GPIO Character Device control tool"
	@echo "  clean          Remove build artifacts"
	@echo ""
	@echo "Tool Description:"
	@echo "  gpio_chardev_ioctl      Controls /dev/gpio_led via ioctl (requires driver)"
	@echo ""
	@echo "Usage:"
	@echo "  gpio_chardev_ioctl on               # Turn LED on"
	@echo "  gpio_chardev_ioctl off              # Turn LED off"
	@echo "  gpio_chardev_ioctl toggle           # Toggle LED"
	@echo "  gpio_chardev_ioctl get              # Get LED state"
	@echo "  gpio_chardev_ioctl gpio             # Get GPIO pin number"
	@echo "  gpio_chardev_ioctl blink 20 300 300 # Blink 20 times (300ms on/off)"