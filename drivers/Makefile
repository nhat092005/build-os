# Makefile for Kernel Drivers and Userspace Tools

# Auto-detect available drivers
DRIVERS_DIR          ?= $(shell pwd)
AVAILABLE_DRIVERS    := $(notdir $(wildcard $(DRIVERS_DIR)/*))

# Filter out Makefile from driver list
AVAILABLE_DRIVERS    := $(filter-out Makefile, $(AVAILABLE_DRIVERS))

# Default configuration
MODULE               ?= all
TOOLS                ?= all
DTBO                 ?= all

# PHONY Targets
.PHONY: all clean list help
.PHONY: modules modules-clean
.PHONY: tools tools-clean
.PHONY: dtbo dtbo-clean

# Main Targets
all: dtbo modules tools

# Build Device Tree Blob Overlays
dtbo:
ifeq ($(DTBO),all)
	@for drv in $(AVAILABLE_DRIVERS); do \
		if [ -f "$(DRIVERS_DIR)/$$drv/Makefile" ]; then \
			$(MAKE) -C $(DRIVERS_DIR)/$$drv dtbo DTC=$(DTC) DTC_FLAGS="$(DTC_FLAGS)" 2>/dev/null || true; \
		fi; \
	done
else
	@if [ -f "$(DRIVERS_DIR)/$(DTBO)/Makefile" ]; then \
		$(MAKE) -C $(DRIVERS_DIR)/$(DTBO) dtbo DTC=$(DTC) DTC_FLAGS="$(DTC_FLAGS)" 2>/dev/null || true; \
	fi
endif

# Build Modules
modules:
ifeq ($(MODULE),all)
	@for drv in $(AVAILABLE_DRIVERS); do \
		if [ -d "$(DRIVERS_DIR)/$$drv" ] && [ -f "$(DRIVERS_DIR)/$$drv/Makefile" ]; then \
			$(MAKE) -C $(DRIVERS_DIR)/$$drv modules 2>/dev/null || true; \
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
tools:
ifeq ($(TOOLS),all)
	@for drv in $(AVAILABLE_DRIVERS); do \
		if [ -d "$(DRIVERS_DIR)/$$drv" ] && [ -f "$(DRIVERS_DIR)/$$drv/Makefile" ]; then \
			$(MAKE) -C $(DRIVERS_DIR)/$$drv tools 2>/dev/null || true; \
		fi; \
	done
else
	@if [ ! -d "$(DRIVERS_DIR)/$(TOOLS)" ]; then \
		echo "Error: Tool '$(TOOLS)' not found"; \
		exit 1; \
	fi
	$(MAKE) -C $(DRIVERS_DIR)/$(TOOLS) tools
endif

clean: modules-clean tools-clean dtbo-clean

# Clean Device Tree Blob Overlays
dtbo-clean:
ifeq ($(DTBO),all)
	@for drv in $(AVAILABLE_DRIVERS); do \
		if [ -f "$(DRIVERS_DIR)/$$drv/Makefile" ]; then \
			$(MAKE) -C $(DRIVERS_DIR)/$$drv dtbo-clean 2>/dev/null || true; \
		fi; \
	done
else
	@if [ -f "$(DRIVERS_DIR)/$(DTBO)/Makefile" ]; then \
		$(MAKE) -C $(DRIVERS_DIR)/$(DTBO) dtbo-clean 2>/dev/null || true; \
	else \
		echo "Error: Driver '$(DTBO)' not found"; \
	fi
endif

# Clean Modules
modules-clean:
ifeq ($(MODULE),all)
	@for drv in $(AVAILABLE_DRIVERS); do \
		if [ -d "$(DRIVERS_DIR)/$$drv" ] && [ -f "$(DRIVERS_DIR)/$$drv/Makefile" ]; then \
			$(MAKE) -C $(DRIVERS_DIR)/$$drv modules-clean 2>/dev/null || true; \
		fi; \
	done
else
	@if [ ! -d "$(DRIVERS_DIR)/$(MODULE)" ]; then \
		echo "Error: Module '$(MODULE)' not found"; \
		exit 1; \
	fi
	$(MAKE) -C $(DRIVERS_DIR)/$(MODULE) modules-clean 2>/dev/null || true
endif

# Clean Userspace Tools
tools-clean:
ifeq ($(TOOLS),all)
	@for drv in $(AVAILABLE_DRIVERS); do \
		if [ -d "$(DRIVERS_DIR)/$$drv" ] && [ -f "$(DRIVERS_DIR)/$$drv/Makefile" ]; then \
			$(MAKE) -C $(DRIVERS_DIR)/$$drv tools-clean 2>/dev/null || true; \
		fi; \
	done
else
	@if [ ! -d "$(DRIVERS_DIR)/$(TOOLS)" ]; then \
		echo "Error: Tool '$(TOOLS)' not found"; \
		exit 1; \
	fi
	$(MAKE) -C $(DRIVERS_DIR)/$(TOOLS) tools-clean 2>/dev/null || true
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
	@echo "  all                     Build all drivers and tools (default)"
	@echo "  dtbo=DTBO               Build specific device tree blob overlay (e.g., dtbo=leds-gpio-custom)"
	@echo "  modules=MODULE          Build specific kernel module (e.g., modules=gpio-chardev)"
	@echo "  tools=TOOL              Build specific userspace tool (e.g., tools=gpio-chardev)"
	@echo "Clean:"
	@echo "  clean                   Clean all build artifacts"
	@echo "  modules-clean           Clean kernel module build artifacts"
	@echo "  tools-clean             Clean userspace tool build artifacts"
	@echo "Other:"
	@echo "  list                    List available drivers and tools"