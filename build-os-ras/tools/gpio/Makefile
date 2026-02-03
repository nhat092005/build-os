# Makefile for GPIO toolkit

# Compiler
CC = gcc

# Compiler flags
CFLAGS = -Wall -Wextra -O2 -std=c99
LDFLAGS = 

# For static linking (recommended for embedded)
# Uncomment the line below for static binaries
LDFLAGS += -static

# Cross-compilation (uncomment if needed)
CC = aarch64-linux-gnu-gcc
CFLAGS += -march=armv8-a

# Source directory (current)
SRC_DIR := .

# Rootfs path (relative to gpio/ directory)
ROOTFS := ../../rootfs

# Installation directory in rootfs
INSTALL_DIR := $(ROOTFS)/usr/bin

# Build artifacts
BUILD_DIR := build

# Library
LIB_SRC := gpio_lib.c
LIB_HDR := gpio_lib.h
LIB_OBJ := $(BUILD_DIR)/gpio_lib.o

# Programs
PROGRAMS := gpio_control
SOURCES := gpio_control.c

# Object files
OBJS := $(patsubst %.c,$(BUILD_DIR)/%.o,$(SOURCES))

# Target binaries
TARGETS := $(BUILD_DIR)/$(PROGRAMS)

# Default target
all: $(BUILD_DIR) $(TARGETS)

# Create build directory
$(BUILD_DIR):
	@mkdir -p $(BUILD_DIR)

# Build library object
$(BUILD_DIR)/gpio_lib.o: $(LIB_SRC) $(LIB_HDR) | $(BUILD_DIR)
	@echo "[ CC ] $<"
	@$(CC) $(CFLAGS) -c $< -o $@

# Build gpio_control
$(BUILD_DIR)/gpio_control: gpio_control.c $(BUILD_DIR)/gpio_lib.o
	@echo "[ LD ] $@"
	@$(CC) $(CFLAGS) $^ $(LDFLAGS) -o $@

# Check if rootfs exists
check-rootfs:
	@test -d "$(ROOTFS)" || (echo "ROOTFS not found"; exit 1)
	@mkdir -p "$(INSTALL_DIR)"

# Install to custom rootfs
install-rootfs: all check-rootfs
	@for p in $(TARGETS); do \
		echo "Installing $$p -> $(INSTALL_DIR)/$$(basename $$p)"; \
		install -D -m 755 $$p $(INSTALL_DIR)/$$(basename $$p); \
	done

# Check binary architecture
check-arch: all
	@for prog in $(TARGETS); do file $$prog; done

# Clean build files
clean:
	rm -rf $(BUILD_DIR)
	rm -f $(TARGETS)

# Clean rootfs installations
clean-rootfs:
	@for prog in $(TARGETS); do \
		rm -f $(INSTALL_DIR)/$$(basename $$prog); \
	done
	@echo "Clean rootfs installations complete!"

# Distclean: clean build files and rootfs installations
distclean: clean clean-rootfs
	@echo "Distclean complete!"

# Clean and rebuild
rebuild: clean all

# Show help
help:
	@echo "GPIO Toolkit Makefile"
	@echo ""
	@echo "Common targets:"
	@echo "  make / make all	Build all targets"
	@echo "  make gpio_control	Build gpio_control only"
	@echo ""
	@echo "Installation:"
	@echo "  make install-rootfs	Install binaries into ROOTFS"
	@echo ""
	@echo "Checks:"
	@echo "  make check-arch       Show binary architecture"
	@echo ""
	@echo "Cleanup:"
	@echo "  make clean            Remove build artifacts"
	@echo "  make clean-rootfs     Remove binaries from rootfs"
	@echo "  make distclean        Clean build + rootfs"
	@echo "  make rebuild          Clean and rebuild"
	@echo ""
	@echo "Examples:"
	@echo "  make"
	@echo "  make install-rootfs ROOTFS=../../rootfs"
	@echo "  make clean-rootfs ROOTFS=../../rootfs"
	@echo "  make CC=aarch64-linux-gnu-gcc"

# Phony targets
.PHONY: all check-rootfs install-rootfs check-arch \
		clean clean-rootfs distclean rebuild help