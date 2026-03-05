# Makefile for GPIO INPUTS driver package
GPIO_INPUTS_DRIVER_VERSION = 1.0.0
GPIO_INPUTS_DRIVER_SITE = $(BR2_EXTERNAL_NHAT092005_PATH)/../drivers/gpio-inputs
GPIO_INPUTS_DRIVER_SITE_METHOD = local
GPIO_INPUTS_DRIVER_LICENSE = GPL-2.0
GPIO_INPUTS_DRIVER_LICENSE_FILES = LICENSE

# This is a kernel module package
$(eval $(kernel-module))

# Define build commands for the kernel module
define GPIO_INPUTS_DRIVER_BUILD_CMDS
	$(MAKE) -C $(LINUX_DIR) \
		M=$(@D)/src \
		$(LINUX_MAKE_FLAGS) \
		ARCH=$(KERNEL_ARCH) \
		CROSS_COMPILE=$(TARGET_CROSS) \
		modules
	
	# Build userspace tools
	if [ -d $(@D)/userspace ] && [ -f $(@D)/userspace/Makefile ]; then \
		$(TARGET_MAKE_ENV) $(MAKE) -C $(@D)/userspace \
			CC=$(TARGET_CC) \
			CFLAGS="$(TARGET_CFLAGS)" \
			LDFLAGS="$(TARGET_LDFLAGS)" \
			KERNELDIR=$(LINUX_DIR) \
			all; \
	fi
endef

# Install kernel module
define GPIO_INPUTS_DRIVER_INSTALL_TARGET_CMDS
	$(MAKE) -C $(LINUX_DIR) \
		M=$(@D)/src \
		$(LINUX_MAKE_FLAGS) \
		ARCH=$(KERNEL_ARCH) \
		CROSS_COMPILE=$(TARGET_CROSS) \
		INSTALL_MOD_PATH=$(TARGET_DIR) \
		modules_install
	
	# Install module auto-load configuration
	$(INSTALL) -D -m 0644 $(BR2_EXTERNAL_NHAT092005_PATH)/package/gpio-inputs-driver/gpio-inputs.modules-load \
		$(TARGET_DIR)/etc/modules-load.d/gpio-inputs.conf
	
	# Install userspace tools to /usr/bin
	if [ -d $(@D)/build/tools ]; then \
		for tool in $(@D)/build/tools/*; do \
			if [ -f "$$tool" ] && [ -x "$$tool" ]; then \
				$(INSTALL) -D -m 0755 "$$tool" $(TARGET_DIR)/usr/bin/$$(basename "$$tool"); \
			fi; \
		done; \
	fi
	
	# Install Device Tree overlay to rpi-firmware directory
	# This will be included in boot.vfat by post-image script
	if [ -f $(@D)/build/dtbo/gpio-inputs.dtbo ]; then \
		$(INSTALL) -D -m 0644 $(@D)/build/dtbo/gpio-inputs.dtbo \
			$(BINARIES_DIR)/rpi-firmware/overlays/gpio-inputs.dtbo; \
	fi
endef

# Build Device Tree overlay
define GPIO_INPUTS_DRIVER_BUILD_DTS
	if [ -f $(@D)/dts/gpio-inputs-overlay.dts ]; then \
		$(MAKE) -C $(@D)/dts \
			DTC=$(LINUX_DIR)/scripts/dtc/dtc \
			KERNEL_DIR=$(LINUX_DIR) \
			all; \
	fi
endef

# Hook to build DTS after kernel module
GPIO_INPUTS_DRIVER_POST_BUILD_HOOKS += GPIO_INPUTS_DRIVER_BUILD_DTS

# Ensure kernel is built before this module
GPIO_INPUTS_DRIVER_DEPENDENCIES = linux

$(eval $(generic-package))
