# Makefile for DS3231 RTC driver package
DS3231_RTC_DRIVER_VERSION = 1.0.0
DS3231_RTC_DRIVER_SITE = $(BR2_EXTERNAL_NHAT092005_PATH)/../drivers/ds3231-rtc
DS3231_RTC_DRIVER_SITE_METHOD = local
DS3231_RTC_DRIVER_LICENSE = GPL-2.0
DS3231_RTC_DRIVER_LICENSE_FILES = LICENSE

# This is a kernel module package
$(eval $(kernel-module))

# Define build commands for the kernel module
define DS3231_RTC_DRIVER_BUILD_CMDS
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
define DS3231_RTC_DRIVER_INSTALL_TARGET_CMDS
	$(MAKE) -C $(LINUX_DIR) \
		M=$(@D)/src \
		$(LINUX_MAKE_FLAGS) \
		ARCH=$(KERNEL_ARCH) \
		CROSS_COMPILE=$(TARGET_CROSS) \
		INSTALL_MOD_PATH=$(TARGET_DIR) \
		modules_install
	
	# Install module auto-load configuration
	$(INSTALL) -D -m 0644 $(BR2_EXTERNAL_NHAT092005_PATH)/package/ds3231-rtc-driver/ds3231-rtc.modules-load \
		$(TARGET_DIR)/etc/modules-load.d/ds3231-rtc.conf
	
	# Install UAPI header for userspace applications
	$(INSTALL) -D -m 0644 $(@D)/include/uapi/ds3231-rtc.h \
		$(STAGING_DIR)/usr/include/linux/ds3231-rtc.h
	
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
	if [ -f $(@D)/build/dtbo/ds3231-rtc.dtbo ]; then \
		$(INSTALL) -D -m 0644 $(@D)/build/dtbo/ds3231-rtc.dtbo \
			$(BINARIES_DIR)/rpi-firmware/overlays/ds3231-rtc.dtbo; \
	fi
	
	# Install documentation if available
	if [ -f $(@D)/README.md ]; then \
		$(INSTALL) -D -m 0644 $(@D)/README.md \
			$(TARGET_DIR)/usr/share/doc/ds3231-rtc-driver/README.md; \
	fi
	
	# Install module configuration files (for reference)
	$(INSTALL) -D -m 0644 $(BR2_EXTERNAL_NHAT092005_PATH)/package/ds3231-rtc-driver/ds3231-rtc.modules-load \
		$(TARGET_DIR)/usr/share/doc/ds3231-rtc-driver/ds3231-rtc.modules-load
	$(INSTALL) -D -m 0644 $(BR2_EXTERNAL_NHAT092005_PATH)/package/ds3231-rtc-driver/ds3231-rtc.modprobe \
		$(TARGET_DIR)/usr/share/doc/ds3231-rtc-driver/ds3231-rtc.modprobe
endef

# Build Device Tree overlay
define DS3231_RTC_DRIVER_BUILD_DTS
	if [ -f $(@D)/dts/ds3231-rtc-overlay.dts ]; then \
		$(MAKE) -C $(@D)/dts \
			DTC=$(LINUX_DIR)/scripts/dtc/dtc \
			KERNEL_DIR=$(LINUX_DIR) \
			all; \
	fi
endef

# Hook to build DTS after kernel module
DS3231_RTC_DRIVER_POST_BUILD_HOOKS += DS3231_RTC_DRIVER_BUILD_DTS

# Ensure kernel is built before this module
DS3231_RTC_DRIVER_DEPENDENCIES = linux

$(eval $(generic-package))
