# Override Linux kernel source to use local git repository
# This allows building kernel without downloading tarball
LINUX_OVERRIDE_SRCDIR = $(BR2_EXTERNAL_NHAT092005_PATH)/../kernel

# ============================================================================
# Kernel Rust Support Integration
# ============================================================================
# Buildroot's linux.mk does NOT pass RUSTC/BINDGEN to the kernel build.
# The kernel defaults to searching PATH, but Buildroot's HOST_MAKE_ENV
# prepends output/host/bin to PATH, which has a rustc WITHOUT rust-src.
#
# Solution: Explicitly pass the system rustc (which has rust-src and the
# required aarch64-unknown-none target) to the kernel build via
# LINUX_MAKE_FLAGS. This ensures:
#   1. Kernel kconfig detects RUST_IS_AVAILABLE=y during configuration
#   2. Kernel builds Rust core/alloc crates for its custom target
#   3. Out-of-tree Rust kernel modules can compile against the sysroot
#
# Prerequisites (install via: scripts/setup-rust-kernel.sh):
#   - rustc >= 1.78.0 with rust-src component
#   - bindgen-cli >= 0.65.1
#   - libclang-dev
# ============================================================================

# Detect system Rust tools (resolved at Makefile parse time)
SYSTEM_RUSTC := $(shell command -v rustc 2>/dev/null)
SYSTEM_BINDGEN := $(shell command -v bindgen 2>/dev/null)

# Only add Rust flags if both tools are available
ifneq ($(SYSTEM_RUSTC),)
ifneq ($(SYSTEM_BINDGEN),)
LINUX_MAKE_FLAGS += RUSTC=$(SYSTEM_RUSTC) BINDGEN=$(SYSTEM_BINDGEN)
LINUX_MAKE_FLAGS += HOSTRUSTC=$(SYSTEM_RUSTC)

# Buildroot's linux.mk bundles HOST_CFLAGS/HOST_LDFLAGS into HOSTCC:
#   HOSTCC="gcc -O2 -isystem /path ... -L/path ..."
# The kernel's rust/Makefile uses HOSTCC directly in -Clinker=$(HOSTCC),
# which causes rustc to see -O2 as its own flag, splitting it into
# -O (valid) + '2' (Unrecognized option).
LINUX_MAKE_FLAGS += HOSTCC="$(HOSTCC_NOCCACHE)"
LINUX_MAKE_FLAGS += HOSTCFLAGS="$(subst -I/,-isystem /,$(subst -I /,-isystem /,$(HOST_CFLAGS)))"
LINUX_MAKE_FLAGS += HOSTLDFLAGS="$(HOST_LDFLAGS)"
endif
endif

include $(sort $(wildcard $(BR2_EXTERNAL_NHAT092005_PATH)/package/*/*.mk))
