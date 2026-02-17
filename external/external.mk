# Override Linux kernel source to use local git repository
# This allows building kernel without downloading tarball
LINUX_OVERRIDE_SRCDIR = $(BR2_EXTERNAL_NHAT092005_PATH)/../kernel

include $(sort $(wildcard $(BR2_EXTERNAL_NHAT092005_PATH)/package/*/*.mk))
