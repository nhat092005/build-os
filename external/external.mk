# Add external packages and override kernel source directory.

# Use the Linux kernel sources located in the parent directory
# of this external tree.
LINUX_OVERRIDE_SRCDIR = $(BR2_EXTERNAL_NHAT092005_PATH)/../kernel

# Check for the presence of rustc and bindgen in the system
SYSTEM_RUSTC := $(shell command -v rustc)
SYSTEM_BINDGEN := $(shell command -v bindgen)

# If rustc and bindgen are available, enable Rust support in 
# the kernel build and set the appropriate flags.
ifneq ($(SYSTEM_RUSTC),)
ifneq ($(SYSTEM_BINDGEN),)
LINUX_MAKE_FLAGS += RUSTC=$(SYSTEM_RUSTC) BINDGEN=$(SYSTEM_BINDGEN)
LINUX_MAKE_FLAGS += HOSTRUSTC=$(SYSTEM_RUSTC)

# Sanitize HOSTCC flags to prevent rustc -Clinker parsing errors.
LINUX_MAKE_FLAGS += HOSTCC="$(HOSTCC_NOCCACHE)"
LINUX_MAKE_FLAGS += HOSTCFLAGS="$(subst -I/,-isystem /,$(subst -I /,-isystem /,$(HOST_CFLAGS)))"
LINUX_MAKE_FLAGS += HOSTLDFLAGS="$(HOST_LDFLAGS)"
endif
endif

include $(sort $(wildcard $(BR2_EXTERNAL_NHAT092005_PATH)/package/*/*.mk))
