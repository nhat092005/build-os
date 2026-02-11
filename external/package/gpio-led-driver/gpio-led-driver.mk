# GPIO LED Driver Makefile
GPIO_LED_DRIVER_VERSION = 1.0.0
GPIO_LED_DRIVER_SITE = $(BR2_EXTERNAL_GPIO_LED_PATH)/../drivers/gpio-led
GPIO_LED_DRIVER_SITE_METHOD = local
GPIO_LED_DRIVER_LICENSE = GPL-2.0
GPIO_LED_DRIVER_LICENSE_FILES = LICENSE

# Define the kernel module subdirectory containing the module source
GPIO_LED_DRIVER_MODULE_SUBDIRS = src

# Module configuration: auto-load at boot via modules-load.d
define GPIO_LED_DRIVER_INSTALL_TARGET_CMDS
	$(INSTALL) -D -m 0644 $(BR2_EXTERNAL_GPIO_LED_PATH)/package/gpio-led-driver/gpio-led.modules-load \
		$(TARGET_DIR)/etc/modules-load.d/gpio-led.conf
endef

# Use kernel-module infrastructure for building
$(eval $(kernel-module))
$(eval $(generic-package))

