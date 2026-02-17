# Override for host-libopenssl to fix AVX512 assembly issue
# This file is automatically sourced by Buildroot after the main package .mk file

# Override HOST_LIBOPENSSL_CONFIGURE_CMDS to add no-asm option
# This fixes: crypto/modes/aes-gcm-avx512.s: Error: open CFI at the end of file
define HOST_LIBOPENSSL_CONFIGURE_CMDS
	cd $(@D); \
		$(HOST_CONFIGURE_OPTS) \
		./config \
		--prefix=$(HOST_DIR) \
		--openssldir=$(HOST_DIR)/etc/ssl \
		no-docs \
		no-tests \
		no-fuzz-libfuzzer \
		no-fuzz-afl \
		no-asm \
		shared \
		zlib-dynamic
endef
