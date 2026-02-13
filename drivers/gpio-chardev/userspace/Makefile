# Makefile for GPIO Character Device Userspace Tool

# Toolchain Configuration
CC              ?= gcc
CFLAGS          ?= -Wall -Wextra -O2

# Directory Configuration
TOOLS_DIR       := tools
BUILD_DIR       := ../build/tools
UAPI_DIR        := ../include/uapi
INCLUDES        := -I$(UAPI_DIR)

# Auto detect source files
SRCS            := $(wildcard $(TOOLS_DIR)/*.c)

# Target Binaries
TARGETS         := $(patsubst $(TOOLS_DIR)/%.c,%,$(SRCS))

# PHONY Targets
.PHONY: all clean help
.PHONY: userspace userspace-clean

# Main Targets
all: userspace 

userspace: $(BUILD_DIR) $(TARGETS)

# Directory Creation
$(BUILD_DIR):
	@mkdir -p $(BUILD_DIR)

# Build Userspace Tool
%: $(TOOLS_DIR)/%.c
	@$(CC) $(CFLAGS) $(INCLUDES) -o $(BUILD_DIR)/$@ $<

# Clean Targets
clean: userspace-clean

# Clean Userspace Tool
userspace-clean:
	@rm -rf $(BUILD_DIR)

# Help
help:
	@echo "Targets:"
	@echo "  all                     Build GPIO Character Device control tool (default)"
	@echo "  userspace-clean         Clean userspace tool build artifacts"
	@echo "  clean                   Remove build artifacts"