# SPDX-License-Identifier: SPDX-2.0
# Makefile Docker wrapper for build-os project.

DOCKER_IMAGE		  := build-os-builder
DOCKER_CONTAINER_ROOT := /root

PROJ_ROOT := $(abspath $(dir $(lastword $(MAKEFILE_LIST))))

include $(PROJ_ROOT)/mk/docker.mk

IN_DOCKER := $(shell test -f /.dockerenv && echo 1)

ifeq ($(IN_DOCKER),1)
	RUSTC 	?= /usr/local/cargo/bin/rustc
	BINDGEN ?= /usr/local/cargo/bin/bindgen
	RUN 	:=
	RUN_TTY :=
else
	RUSTC 	?= $(HOME)/.cargo/bin/rustc
	BINDGEN ?= $(HOME)/.cargo/bin/bindgen
	RUN 	:= $(DOCKER_RUN_NO_TTY)
	RUN_TTY := $(DOCKER_RUN_TTY)
endif

SDK_IMAGE 		:= ghcr.io/nhat092005/build-os-sdk:gcc14.3-glibc
DOCKERFILE 		:= docker/Dockerfile
SDK_DOCKERFILE 	:= docker/sdk.Dockerfile

CONTAINER_ROOT := $(DOCKER_CONTAINER_ROOT)

ARCH := arm64
export ARCH

BUILDROOT_DIR 	:= $(PROJ_ROOT)/buildroot
DRIVERS_DIR 	:= $(PROJ_ROOT)/drivers
SCRIPTS_DIR		:= $(PROJ_ROOT)/scripts
KERNEL_SRC_DIR 	:= $(PROJ_ROOT)/kernel
OUTPUT_DIR 		:= $(PROJ_ROOT)/output

KERNEL_DIR := $(BUILDROOT_DIR)/output/build/linux-custom

CROSS_COMPILE := aarch64-linux-

export KERNEL_DIR CROSS_COMPILE

CC 		:= $(CROSS_COMPILE)gcc
AR 		:= $(CROSS_COMPILE)ar
CFLAGS 	:= -Wall -Wextra -Werror -Wshadow -Wformat-security -O2 -std=gnu11
LDFLAGS := 

DTC 	  := dtc
DTC_FLAGS := -@ -I dts -O dtb -Wno-unit_address_vs_reg

AVAILABLE_DRIVERS := $(filter-out README.md common, $(notdir $(wildcard $(DRIVERS_DIR)/*)))

.PHONY: all help

all: help

help:
	@echo "build-os — Hermetic Docker Build System"
	@echo ""
	@echo "Setup (once):"
	@echo "  make docker-build                   - Build Docker image (~2 min)"
	@echo "  make buildroot                      - Full Buildroot build (~60 min first time)"
	@echo ""
	@echo "Docker:"
	@echo "  make docker-shell                   - Interactive shell in container"
	@echo "  make ci-check                       - Full driver build + checkpatch (Docker)"
	@echo "  make kernel-prepare                 - Prepare kernel/ source tree (~2-3 min)"
	@echo "  make sdk-image-build                - Build SDK image (~2 min)"
	@echo "  make sdk-image-push                 - Push SDK image to registry"
	@echo "  make sdk-image-release              - Build + push SDK image"
	@echo ""
	@echo "Build (after buildroot):"
	@echo "  make build                          - Build dtbo + modules + tools"
	@echo "  make dtbo [DTBO=<n>]                - Build DTS overlays"
	@echo "  make modules [MODULE=<n>]           - Build kernel module(s)"
	@echo "  make tools [TOOLS=<n>]              - Build userspace tools"
	@echo ""
	@echo "Clean:"
	@echo "  make clean                          - Clean dtbo + modules + tools"
	@echo "  make dtbo-clean [DTBO=<n>]          - Clean DTS overlays build artifacts"
	@echo "  make modules-clean [MODULE=<n>]     - Clean kernel module build artifacts"
	@echo "  make tools-clean [TOOLS=<n>]        - Clean userspace tool build artifacts"
	@echo ""
	@echo "Buildroot:"
	@echo "  make buildroot                      - Full build (kernel + rootfs + drivers)"
	@echo "  make buildroot-toolchain            - Build Buildroot SDK toolchain"
	@echo "  make buildroot-sdk                  - Build Buildroot SDK tarball"
	@echo "  make buildroot-custom               - Apply custom defconfig"
	@echo "  make buildroot-config               - Interactive menuconfig"
	@echo "  make buildroot-clean                - Clean output (full rebuild needed after)"
	@echo "  make buildroot-distclean            - Clean output + configs (full rebuild needed after)"
	@echo ""
	@echo "Driver-specific Buildroot targets:"
	@echo "  make buildroot-driver DRIVER=<n>"
	@echo "                                      - Build and install and all its dependencies"
	@echo "  make buildroot-driver-dirclean DRIVER=<n>"
	@echo "                                      - Remove build directory"
	@echo "  make buildroot-driver-reconfigure DRIVER=<n>"
	@echo "                                      - Restart the build from the configure step"
	@echo "  make buildroot-driver-rebuild DRIVER=<n>"
	@echo "                                      - Restart the build from the build step"
	@echo "  make buildroot-driver-reinstall DRIVER=<n>"
	@echo "                                      - Restart the build from the install step"
	@echo ""
	@echo "Deployment (host only):"
	@echo "  make identify-sdcard                - Identify SD card device (prints to stdout)"
	@echo "  make stage-output                   - Stage files to output/"
	@echo "  make deploy-sdcard                  - Write image to SD card"
	@echo ""
	@echo "Install output to staged rootfs (host only):"
	@echo "  make install-overlays               - Install .dtbo to staged rootfs"
	@echo "  make install-modules                - Install .ko to staged rootfs"
	@echo "  make install-tools                  - Install tools to staged rootfs"
	@echo ""
	@echo "Remove from staged rootfs (host only):"
	@echo "  make remove-overlays                - Remove .dtbo from staged rootfs"
	@echo "  make remove-modules                 - Remove .ko from staged rootfs"
	@echo "  make remove-tools                   - Remove tools from staged rootfs"
	@echo ""
	@echo "Others:"
	@echo "  make build-all                      - Buildroot + dtbo + modules + tools"
	@echo "  make clean-all                      - Clean buildroot + dtbo + modules + tools + output"
	@echo "  make driver-list                    - List available drivers"
	@echo "  make setup-rust                     - Install Rust toolchain locally for development"
	@echo "  make install-toolchains             - Install Buildroot SDK toolchain locally"
	@echo "  make remove-toolchains              - Remove locally installed Buildroot SDK toolchain"
	@echo ""	
	@echo "Options:"
	@echo "  DRIVER=<name|all>                   - Target driver (default: all)"
	@echo "  DTBO=<name|all>                     - Target overlay (default: all)"	
	@echo "  MODULE=<name|all>                   - Alias for DRIVER (default: all)"
	@echo "  TOOLS=<name|all>                    - Target tool (default: all)"
	@echo "  KERNEL_DIR=<path>                   - Override kernel tree (host path)"
	@echo "  DEVICE=<dev>                        - SD card device (default: /dev/sda)"

# =======================================================================
# DOCKER BUILD TARGETS (run inside Docker)
# =======================================================================

.PHONY: docker-build docker-shell

docker-build:
	DOCKER_BUILDKIT=1 docker build \
		--build-arg SDK_IMAGE=$(SDK_IMAGE) \
		-t $(DOCKER_IMAGE) \
		-f $(DOCKERFILE) .

docker-shell:
	$(RUN_TTY) bash

.PHONY: kernel-prepare

kernel-prepare:
	@if [ ! -f "$(KERNEL_SRC_DIR)/Makefile" ]; then \
		echo "Error: kernel/ submodule not found."; \
		echo "Run: git submodule update --init kernel"; \
		exit 1; \
	fi
	$(RUN) $(MAKE) -C $(CONTAINER_ROOT)/kernel \
		ARCH=$(ARCH) \
		CROSS_COMPILE=$(CROSS_COMPILE) \
		bcm2711_defconfig
	$(RUN) $(MAKE) -C $(CONTAINER_ROOT)/kernel \
		ARCH=$(ARCH) \
		CROSS_COMPILE=$(CROSS_COMPILE) \
		modules_prepare

.PHONY: ci-check

ci-check: kernel-prepare dtbo modules tools 
	$(RUN) bash -c 'find drivers -name "*.c" -o -name "*.h" | \
		xargs kernel/scripts/checkpatch.pl --strict --no-tree -f'

.PHONY: sdk-image-build sdk-image-push sdk-image-release

sdk-image-release: sdk-image-build sdk-image-push

sdk-image-build:
	DOCKER_BUILDKIT=1 docker build \
		-t $(SDK_IMAGE) \
		-f $(SDK_DOCKERFILE) .

sdk-image-push:
	docker push $(SDK_IMAGE)

# =======================================================================
# BUILDROOT BUILD TARGETS (run inside Docker)
# =======================================================================

.PHONY: buildroot buildroot-toolchain buildroot-sdk
.PHONY: buildroot-custom buildroot-config 
.PHONY: buildroot-clean buildroot-distclean

BUILDROOT_MAKE = $(MAKE) -C $(CONTAINER_ROOT)/buildroot \
					BR2_EXTERNAL=$(CONTAINER_ROOT)/external \
					LINUX_OVERRIDE_SRCDIR=$(CONTAINER_ROOT)/kernel

buildroot:
	$(RUN) $(BUILDROOT_MAKE) -j$(shell nproc)

buildroot-toolchain:
	$(RUN) $(BUILDROOT_MAKE) toolchain

buildroot-sdk:
	$(RUN) $(BUILDROOT_MAKE) sdk

buildroot-custom:
	$(RUN) $(BUILDROOT_MAKE) raspberrypi4_64_custom_defconfig

buildroot-config:
	$(RUN_TTY) $(BUILDROOT_MAKE) menuconfig

buildroot-clean:
	$(RUN) $(BUILDROOT_MAKE) clean

buildroot-distclean:
	$(RUN) $(BUILDROOT_MAKE) distclean

.PHONY: buildroot-driver buildroot-driver-dirclean 
.PHONY: buildroot-driver-reconfigure buildroot-driver-rebuild buildroot-driver-reinstall

DRIVER ?= all

buildroot-driver:
ifeq ($(DRIVER),all)
	@for drv in $(AVAILABLE_DRIVERS); do \
		if [ -d "$(DRIVERS_DIR)/$$drv" ]; then \
			$(RUN) $(BUILDROOT_MAKE) $${drv}-driver || exit 1; \
		fi; \
	done
else
	$(RUN) $(BUILDROOT_MAKE) $(DRIVER)-driver
endif

buildroot-driver-dirclean:
ifeq ($(DRIVER),all)
	@for drv in $(AVAILABLE_DRIVERS); do \
		if [ -d "$(DRIVERS_DIR)/$$drv" ]; then \
			$(RUN) $(BUILDROOT_MAKE) $${drv}-driver-dirclean || exit 1; \
		fi; \
	done
else
	$(RUN) $(BUILDROOT_MAKE) $(DRIVER)-driver-dirclean
endif

buildroot-driver-reconfigure:
ifeq ($(DRIVER),all)
	@for drv in $(AVAILABLE_DRIVERS); do \
		$(RUN) $(BUILDROOT_MAKE) $${drv}-driver-reconfigure || exit 1; \
	done
else
	$(RUN) $(BUILDROOT_MAKE) $(DRIVER)-driver-reconfigure
endif

buildroot-driver-rebuild:
ifeq ($(DRIVER),all)
	@for drv in $(AVAILABLE_DRIVERS); do \
		$(RUN) $(BUILDROOT_MAKE) $${drv}-driver-rebuild || exit 1; \
	done
else
	$(RUN) $(BUILDROOT_MAKE) $(DRIVER)-driver-rebuild
endif

buildroot-driver-reinstall:
ifeq ($(DRIVER),all)
	@for drv in $(AVAILABLE_DRIVERS); do \
		$(RUN) $(BUILDROOT_MAKE) $${drv}-driver-reinstall || exit 1; \
	done
else
	$(RUN) $(BUILDROOT_MAKE) $(DRIVER)-driver-reinstall
endif

# =======================================================================
# DRIVER-SPECIFIC BUILD TARGETS (run inside Docker)
# =======================================================================

.PHONY: build clean

build: dtbo modules tools

clean: dtbo-clean modules-clean tools-clean

.PHONY: dtbo dtbo-clean

DTBO ?= all

dtbo:
ifeq ($(DTBO),all)
	@for drv in $(AVAILABLE_DRIVERS); do \
		if [ -d "$(DRIVERS_DIR)/$$drv" ]; then \
			$(RUN) $(MAKE) -C $(CONTAINER_ROOT)/drivers/$$drv dtbo \
				DTC=$(DTC) \
				DTC_FLAGS="$(DTC_FLAGS)" || true; \
		fi; \
	done
else
	@if [ ! -d "$(DRIVERS_DIR)/$(DTBO)" ]; then \
		echo "Error: Driver '$(DTBO)' not found"; \
		exit 1; \
	fi
	$(RUN) $(MAKE) -C $(CONTAINER_ROOT)/drivers/$(DTBO) dtbo \
		DTC=$(DTC) \
		DTC_FLAGS="$(DTC_FLAGS)"
endif

dtbo-clean:
ifeq ($(DTBO),all)
	@for drv in $(AVAILABLE_DRIVERS); do \
		if [ -d "$(DRIVERS_DIR)/$$drv" ]; then \
			$(RUN) $(MAKE) -C $(CONTAINER_ROOT)/drivers/$$drv dtbo-clean || true; \
		fi; \
	done
else
	@if [ ! -d "$(DRIVERS_DIR)/$(DTBO)" ]; then \
		echo "Error: Driver '$(DTBO)' not found"; \
		exit 1; \
	fi
	$(RUN) $(MAKE) -C $(CONTAINER_ROOT)/drivers/$(DTBO) dtbo-clean
endif

.PHONY: modules modules-clean

MODULE ?= all

modules:
ifeq ($(MODULE),all)
	@for drv in $(AVAILABLE_DRIVERS); do \
		if [ -d "$(DRIVERS_DIR)/$$drv" ]; then \
			$(RUN) $(MAKE) -C $(CONTAINER_ROOT)/drivers/$$drv modules \
				ARCH=$(ARCH) \
				CROSS_COMPILE=$(CROSS_COMPILE) || true; \
		fi; \
	done
else
	@if [ ! -d "$(DRIVERS_DIR)/$(MODULE)" ]; then \
		echo "Error: Module '$(MODULE)' not found"; \
		exit 1; \
	fi
	$(RUN) $(MAKE) -C $(CONTAINER_ROOT)/drivers/$(MODULE) modules \
		ARCH=$(ARCH) \
		CROSS_COMPILE=$(CROSS_COMPILE)
endif

modules-clean:
ifeq ($(MODULE),all)
	@for drv in $(AVAILABLE_DRIVERS); do \
		if [ -d "$(DRIVERS_DIR)/$$drv" ]; then \
			$(RUN) $(MAKE) -C $(CONTAINER_ROOT)/drivers/$$drv modules-clean || true; \
		fi; \
	done
else
	@if [ ! -d "$(DRIVERS_DIR)/$(MODULE)" ]; then \
		echo "Error: Module '$(MODULE)' not found"; \
		exit 1; \
	fi
	$(RUN) $(MAKE) -C $(CONTAINER_ROOT)/drivers/$(MODULE) modules-clean
endif

.PHONY: tools tools-clean

TOOLS ?= all

tools:
ifeq ($(TOOLS),all)
	@for drv in $(AVAILABLE_DRIVERS); do \
		if [ -d "$(DRIVERS_DIR)/$$drv" ]; then \
			$(RUN) $(MAKE) -C $(CONTAINER_ROOT)/drivers/$$drv tools \
				CROSS_COMPILE=$(CROSS_COMPILE) \
				CC=$(CC) \
				AR=$(AR) \
				CFLAGS="$(CFLAGS)" \
				LDFLAGS="$(LDFLAGS)" || true; \
		fi; \
	done
else
	@if [ ! -d "$(DRIVERS_DIR)/$(TOOLS)" ]; then \
		echo "Error: Tool '$(TOOLS)' not found"; \
		exit 1; \
	fi
	$(RUN) $(MAKE) -C $(CONTAINER_ROOT)/drivers/$(TOOLS) tools \
		CROSS_COMPILE=$(CROSS_COMPILE) \
		CC=$(CC) \
		AR=$(AR) \
		CFLAGS="$(CFLAGS)" \
		LDFLAGS="$(LDFLAGS)"
endif

tools-clean:
ifeq ($(TOOLS),all)
	@for drv in $(AVAILABLE_DRIVERS); do \
		if [ -d "$(DRIVERS_DIR)/$$drv" ]; then \
			$(RUN) $(MAKE) -C $(CONTAINER_ROOT)/drivers/$$drv tools-clean || true; \
		fi; \
	done
else
	@if [ ! -d "$(DRIVERS_DIR)/$(TOOLS)" ]; then \
		echo "Error: Tool '$(TOOLS)' not found"; \
		exit 1; \
	fi
	$(RUN) $(MAKE) -C $(CONTAINER_ROOT)/drivers/$(TOOLS) tools-clean
endif

.PHONY: driver-list

driver-list:
	@echo "Available drivers:"
	@for drv in $(AVAILABLE_DRIVERS); do \
		if [ -d "$(DRIVERS_DIR)/$$drv" ]; then \
			echo "  - $$drv"; \
		fi; \
	done

# =======================================================================
# SCRIPTS FOR INSTALLING / REMOVE / STAGING / DEPLOYMENT (host only)
# =======================================================================

.PHONY: identify-sdcard setup-rust
.PHONY: install-toolchains remove-toolchains

DEVICE ?= /dev/sda

identify-sdcard:
	$(MAKE) -C $(SCRIPTS_DIR) identify-sdcard

setup-rust:
	$(MAKE) -C $(SCRIPTS_DIR) setup-rust

install-toolchains:
	$(MAKE) -C $(SCRIPTS_DIR) install-toolchains

remove-toolchains:
	$(MAKE) -C $(SCRIPTS_DIR) remove-toolchains

.PHONY: install-overlays install-modules install-tools

install-overlays:
	$(MAKE) -C $(SCRIPTS_DIR) install-overlays

install-modules:
	$(MAKE) -C $(SCRIPTS_DIR) install-modules

install-tools:
	$(MAKE) -C $(SCRIPTS_DIR) install-tools

.PHONY: remove-overlays remove-modules remove-tools

remove-overlays:
	$(MAKE) -C $(SCRIPTS_DIR) remove-overlays

remove-modules:
	$(MAKE) -C $(SCRIPTS_DIR) remove-modules

remove-tools:
	$(MAKE) -C $(SCRIPTS_DIR) remove-tools

.PHONY: stage-output deploy-sdcard

stage-output:
	$(MAKE) -C $(SCRIPTS_DIR) stage-output

deploy-sdcard:
	$(MAKE) -C $(SCRIPTS_DIR) deploy-sdcard DEVICE=$(DEVICE)

output-clean:
	@if [ "$$(id -u)" -ne 0 ]; then \
		echo "Error: Output-clean requires root privileges"; \
		exit 1; \
	fi
	@if [ -d "$(OUTPUT_DIR)" ]; then \
		rm -rf $(OUTPUT_DIR); \
	fi

build-all: buildroot build 

clean-all: output-clean clean buildroot-clean
