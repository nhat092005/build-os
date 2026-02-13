################################################################################
#
# leds-gpio-custom-driver
#
################################################################################

LEDS_GPIO_CUSTOM_DRIVER_VERSION = 1.0.0
LEDS_GPIO_CUSTOM_DRIVER_SITE = $(BR2_EXTERNAL_GPIO_DRIVERS_PATH)/../drivers/leds-gpio-custom
LEDS_GPIO_CUSTOM_DRIVER_SITE_METHOD = local
LEDS_GPIO_CUSTOM_DRIVER_LICENSE = GPL-2.0
LEDS_GPIO_CUSTOM_DRIVER_LICENSE_FILES = LICENSE

# This is a kernel module package
$(eval $(kernel-module))

# Define build commands for the kernel module
define LEDS_GPIO_CUSTOM_DRIVER_BUILD_CMDS
	$(MAKE) -C $(LINUX_DIR) \
		M=$(@D)/src \
		$(LINUX_MAKE_FLAGS) \
		ARCH=$(KERNEL_ARCH) \
		CROSS_COMPILE=$(TARGET_CROSS) \
		modules
endef

# Install kernel module
define LEDS_GPIO_CUSTOM_DRIVER_INSTALL_TARGET_CMDS
	$(MAKE) -C $(LINUX_DIR) \
		M=$(@D)/src \
		$(LINUX_MAKE_FLAGS) \
		ARCH=$(KERNEL_ARCH) \
		CROSS_COMPILE=$(TARGET_CROSS) \
		INSTALL_MOD_PATH=$(TARGET_DIR) \
		modules_install
	
	# Install UAPI header for userspace applications
	$(INSTALL) -D -m 0644 $(@D)/include/uapi/leds-gpio-custom.h \
		$(STAGING_DIR)/usr/include/linux/leds-gpio-custom.h
	
	# Install Device Tree overlay if available
	if [ -f $(@D)/dts/leds-gpio-custom-overlay.dtbo ]; then \
		$(INSTALL) -D -m 0644 $(@D)/dts/leds-gpio-custom-overlay.dtbo \
			$(TARGET_DIR)/boot/overlays/leds-gpio-custom.dtbo; \
	fi
	
	# Install documentation if available
	if [ -f $(@D)/docs/README.md ]; then \
		$(INSTALL) -D -m 0644 $(@D)/docs/README.md \
			$(TARGET_DIR)/usr/share/doc/leds-gpio-custom-driver/README.md; \
	fi
	
	# Install test scripts if available
	if [ -d $(@D)/tests ] && [ -n "$$(ls -A $(@D)/tests/*.sh 2>/dev/null)" ]; then \
		$(INSTALL) -d $(TARGET_DIR)/usr/share/leds-gpio-custom-driver/tests; \
		$(INSTALL) -D -m 0755 $(@D)/tests/*.sh \
			$(TARGET_DIR)/usr/share/leds-gpio-custom-driver/tests/ || true; \
	fi
	
	# Install module configuration files (for reference)
	$(INSTALL) -D -m 0644 $(BR2_EXTERNAL_GPIO_DRIVERS_PATH)/package/leds-gpio-custom-driver/leds-gpio-custom.modules-load \
		$(TARGET_DIR)/usr/share/doc/leds-gpio-custom-driver/leds-gpio-custom.modules-load
	$(INSTALL) -D -m 0644 $(BR2_EXTERNAL_GPIO_DRIVERS_PATH)/package/leds-gpio-custom-driver/leds-gpio-custom.modprobe \
		$(TARGET_DIR)/usr/share/doc/leds-gpio-custom-driver/leds-gpio-custom.modprobe
endef

# Build Device Tree overlay
define LEDS_GPIO_CUSTOM_DRIVER_BUILD_DTS
	if [ -f $(@D)/dts/leds-gpio-custom-overlay.dts ]; then \
		$(MAKE) -C $(@D)/dts \
			DTC=$(LINUX_DIR)/scripts/dtc/dtc \
			KERNEL_DIR=$(LINUX_DIR) \
			all; \
	fi
endef

# Hook to build DTS after kernel module
LEDS_GPIO_CUSTOM_DRIVER_POST_BUILD_HOOKS += LEDS_GPIO_CUSTOM_DRIVER_BUILD_DTS

# Ensure kernel is built before this module
LEDS_GPIO_CUSTOM_DRIVER_DEPENDENCIES = linux

$(eval $(generic-package))
