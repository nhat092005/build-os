# Makefile for GPIO LED userspace tools

# Toolchain Configuration
CC              ?= gcc
CFLAGS          ?= -Wall -Wextra -O2

# Directory Configuration
BUILD_DIR       := ../../build/tools
UAPI_DIR        := ../../include/uapi
INCLUDES        := -I$(UAPI_DIR)

# Target Binaries
TARGETS         := led_ioctl

# PHONY Targets
.PHONY: all clean install help

# Main Targets
all: $(BUILD_DIR) $(TARGETS)

# Directory Creation
$(BUILD_DIR):
	@mkdir -p $(BUILD_DIR)

# Target Builds
led_ioctl: led_ioctl.c
	@echo "Building led_ioctl tool"
	@$(CC) $(CFLAGS) $(INCLUDES) -o $(BUILD_DIR)/$@ $<

# Clean Targets
clean:
	@echo "Cleaning tools build artifacts"
	@rm -rf $(BUILD_DIR)

# Help
help:
	@echo "Targets:"
	@echo "  all            Build LED control tool (default)"
	@echo "  led_ioctl      Build GPIO LED control tool"
	@echo "  clean          Remove build artifacts"
	@echo ""
	@echo "Tool Description:"
	@echo "  led_ioctl      Controls /dev/gpio_led via ioctl (requires driver)"
	@echo ""
	@echo "Usage:"
	@echo "  led_ioctl on               # Turn LED on"
	@echo "  led_ioctl off              # Turn LED off"
	@echo "  led_ioctl toggle           # Toggle LED"
	@echo "  led_ioctl get              # Get LED state"
	@echo "  led_ioctl gpio             # Get GPIO pin number"
	@echo "  led_ioctl blink 20 300 300 # Blink 20 times (300ms on/off)"