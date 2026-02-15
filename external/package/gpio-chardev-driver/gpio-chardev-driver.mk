# GPIO Character Device Driver Makefile
GPIO_CHARDEV_DRIVER_VERSION = 1.0.0
GPIO_CHARDEV_DRIVER_SITE = $(BR2_EXTERNAL_GPIO_DRIVERS_PATH)/../drivers/gpio-chardev
GPIO_CHARDEV_DRIVER_SITE_METHOD = local
GPIO_CHARDEV_DRIVER_LICENSE = GPL-2.0
GPIO_CHARDEV_DRIVER_LICENSE_FILES = LICENSE

# Define the kernel module subdirectory containing the module source
GPIO_CHARDEV_DRIVER_MODULE_SUBDIRS = src

# Build userspace tools after kernel module
define GPIO_CHARDEV_DRIVER_BUILD_CMDS
	$(TARGET_MAKE_ENV) $(MAKE) -C $(@D)/userspace \
		CC=$(TARGET_CC) \
		CFLAGS="$(TARGET_CFLAGS)" \
		LDFLAGS="$(TARGET_LDFLAGS)" \
		KERNELDIR=$(LINUX_DIR) \
		all
endef

# Install userspace tools to /usr/bin
define GPIO_CHARDEV_DRIVER_INSTALL_TARGET_CMDS
	$(INSTALL) -D -m 0644 $(BR2_EXTERNAL_GPIO_DRIVERS_PATH)/package/gpio-chardev-driver/gpio-chardev.modules-load \
		$(TARGET_DIR)/etc/modules-load.d/gpio-chardev.conf
	
	# Install userspace tools
	if [ -f $(@D)/build/tools/gpio-chardev-ioctl ]; then \
		$(INSTALL) -D -m 0755 $(@D)/build/tools/gpio-chardev-ioctl \
			$(TARGET_DIR)/usr/bin/gpio-chardev-ioctl; \
	fi
	
	# Install UAPI header for userspace applications
	$(INSTALL) -D -m 0644 $(@D)/include/uapi/gpio-chardev.h \
		$(STAGING_DIR)/usr/include/linux/gpio-chardev.h
endef

# Use kernel-module infrastructure for building
$(eval $(kernel-module))
$(eval $(generic-package))

