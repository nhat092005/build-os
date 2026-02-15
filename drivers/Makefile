# Makefile for Kernel Drivers and Userspace Tools

# Auto-detect available drivers
DRIVERS_DIR          ?= $(shell pwd)
AVAILABLE_DRIVERS    := $(notdir $(wildcard $(DRIVERS_DIR)/*))

# Filter out Makefile from driver list
AVAILABLE_DRIVERS    := $(filter-out Makefile, $(AVAILABLE_DRIVERS))

# Default configuration
MODULE               ?= all
USERSPACE            ?= all

# PHONY Targets
.PHONY: all clean list help
.PHONY: modules modules-clean
.PHONY: userspace userspace-clean

# Main Targets
all: modules userspace

# Build Modules
modules:
ifeq ($(MODULE),all)
	@for drv in $(AVAILABLE_DRIVERS); do \
		if [ -d "$(DRIVERS_DIR)/$$drv" ] && [ -f "$(DRIVERS_DIR)/$$drv/Makefile" ]; then \
			$(MAKE) -C $(DRIVERS_DIR)/$$drv modules || exit 1; \
		fi; \
	done
else
	@if [ ! -d "$(DRIVERS_DIR)/$(MODULE)" ]; then \
		echo "Error: Module '$(MODULE)' not found"; \
		exit 1; \
	fi
	$(MAKE) -C $(DRIVERS_DIR)/$(MODULE) modules
endif

# Build Userspace Tools
userspace:
ifeq ($(USERSPACE),all)
	@for drv in $(AVAILABLE_DRIVERS); do \
		if [ -d "$(DRIVERS_DIR)/$$drv" ] && [ -f "$(DRIVERS_DIR)/$$drv/Makefile" ]; then \
			$(MAKE) -C $(DRIVERS_DIR)/$$drv userspace || exit 1; \
		fi; \
	done
else
	@if [ ! -d "$(DRIVERS_DIR)/$(USERSPACE)" ]; then \
		echo "Error: Userspace tool '$(USERSPACE)' not found"; \
		exit 1; \
	fi
	$(MAKE) -C $(DRIVERS_DIR)/$(USERSPACE) userspace
endif

clean: modules-clean userspace-clean

# Clean Modules
modules-clean:
ifeq ($(MODULE),all)
	@for drv in $(AVAILABLE_DRIVERS); do \
		if [ -d "$(DRIVERS_DIR)/$$drv" ] && [ -f "$(DRIVERS_DIR)/$$drv/Makefile" ]; then \
			$(MAKE) -C $(DRIVERS_DIR)/$$drv modules-clean|| exit 1; \
		fi; \
	done
else
	@if [ ! -d "$(DRIVERS_DIR)/$(MODULE)" ]; then \
		echo "Error: Module '$(MODULE)' not found"; \
		exit 1; \
	fi
	$(MAKE) -C $(DRIVERS_DIR)/$(MODULE) modules-clean
endif

# Clean Userspace Tools
userspace-clean:
ifeq ($(USERSPACE),all)
	@for drv in $(AVAILABLE_DRIVERS); do \
		if [ -d "$(DRIVERS_DIR)/$$drv" ] && [ -f "$(DRIVERS_DIR)/$$drv/Makefile" ]; then \
			$(MAKE) -C $(DRIVERS_DIR)/$$drv userspace-clean || exit 1; \
		fi; \
	done
else
	@if [ ! -d "$(DRIVERS_DIR)/$(USERSPACE)" ]; then \
		echo "Error: Userspace tool '$(USERSPACE)' not found"; \
		exit 1; \
	fi
	$(MAKE) -C $(DRIVERS_DIR)/$(USERSPACE) userspace-clean
endif

# List Available Drivers
list:
	@for drv in $(AVAILABLE_DRIVERS); do \
		if [ -d "$(DRIVERS_DIR)/$$drv" ]; then \
			echo "  - $$drv"; \
		fi; \
	done

# Help
help:
	@echo "Build:"
	@echo "  all                     Build all drivers and userspace tools (default)"
	@echo "  modules=MODULE          Build specific kernel module (e.g., modules=gpio-chardev)"
	@echo "  userspace=TOOL          Build specific userspace tool (e.g., userspace=gpio-chardev)"
	@echo "Clean:"
	@echo "  clean                   Clean all build artifacts"
	@echo "  modules-clean           Clean kernel module build artifacts"
	@echo "  userspace-clean         Clean userspace tool build artifacts"
	@echo "Other:"
	@echo "  list                    List available drivers and userspace tools"