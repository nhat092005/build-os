# Makefile for SHT3x sensor driver package
SHT3X_DRIVER_VERSION = 1.0.0
SHT3X_DRIVER_SITE = $(BR2_EXTERNAL_NHAT092005_PATH)/../drivers/sht3x
SHT3X_DRIVER_SITE_METHOD = local
SHT3X_DRIVER_LICENSE = GPL-2.0
SHT3X_DRIVER_LICENSE_FILES = LICENSE

# This is a kernel module package
$(eval $(kernel-module))

# Define build commands for the kernel module
define SHT3X_DRIVER_BUILD_CMDS
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
define SHT3X_DRIVER_INSTALL_TARGET_CMDS
	$(MAKE) -C $(LINUX_DIR) \
		M=$(@D)/src \
		$(LINUX_MAKE_FLAGS) \
		ARCH=$(KERNEL_ARCH) \
		CROSS_COMPILE=$(TARGET_CROSS) \
		INSTALL_MOD_PATH=$(TARGET_DIR) \
		modules_install
	
	# Install module auto-load configuration
	$(INSTALL) -D -m 0644 $(BR2_EXTERNAL_NHAT092005_PATH)/package/sht3x-driver/sht3x.modules-load \
		$(TARGET_DIR)/etc/modules-load.d/sht3x.conf
	
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
	if [ -f $(@D)/build/dtbo/sht3x.dtbo ]; then \
		$(INSTALL) -D -m 0644 $(@D)/build/dtbo/sht3x.dtbo \
			$(BINARIES_DIR)/rpi-firmware/overlays/sht3x.dtbo; \
	fi
endef

# Build Device Tree overlay
define SHT3X_DRIVER_BUILD_DTS
	if [ -f $(@D)/dts/sht3x-overlay.dts ]; then \
		$(MAKE) -C $(@D)/dts \
			DTC=$(LINUX_DIR)/scripts/dtc/dtc \
			KERNEL_DIR=$(LINUX_DIR) \
			all; \
	fi
endef

# Hook to build DTS after kernel module
SHT3X_DRIVER_POST_BUILD_HOOKS += SHT3X_DRIVER_BUILD_DTS

# Ensure kernel is built before this module
SHT3X_DRIVER_DEPENDENCIES = linux

$(eval $(generic-package))
