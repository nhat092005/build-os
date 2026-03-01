# syntax=docker/dockerfile:1
#
# build-os hermetic builder
# Containerized Embedded Linux build platform.
#
# Builds: Buildroot + Linux kernel + rootfs + out-of-tree drivers.
# Requires: Docker Engine only.

ARG SDK_IMAGE=ghcr.io/nhat092005/build-os-sdk:gcc14.3-glibc

FROM ${SDK_IMAGE}

# Buildroot host dependencies 
RUN --mount=type=cache,target=/var/cache/apt,sharing=locked \
    --mount=type=cache,target=/var/lib/apt,sharing=locked \
    apt-get update && apt-get install -y --no-install-recommends \
        # Core build tools
        build-essential \
        make \
        cmake \
        fakeroot \
        # Kernel build deps
        bc \
        flex \
        bison \
        libssl-dev \
        libelf-dev \
        # Buildroot host tools
        unzip \
        wget \
        rsync \
        cpio \
        # Device tree
        device-tree-compiler \
        # Scripting & config
        perl \
        python3 \
        python3-ply \
        python3-pip \
        libncurses-dev \
        # Cross-compilation extras
        libclang-dev \
        clang \
        # Misc required by Buildroot packages
        file \
        curl \
        ca-certificates \
        patch \
        gzip \
        bzip2 \
        xz-utils \
        libtool \
        automake \
        autoconf \
        pkgconf \
        gettext \
        libffi-dev \
    && find /usr/lib/llvm-*/lib -name "*.a" -delete 2>/dev/null || true

# Rust toolchain — pinned, detected automatically by external/external.mk
ARG RUST_VERSION=1.93.1
ARG BINDGEN_VERSION=0.72.1

ENV RUSTUP_HOME=/usr/local/rustup
ENV CARGO_HOME=/usr/local/cargo
ENV PATH=/usr/local/cargo/bin:${PATH}

RUN --mount=type=cache,target=/usr/local/cargo/registry,sharing=locked \
    curl --proto '=https' --tlsv1.2 -sSf https://sh.rustup.rs | \
        sh -s -- -y \
            --no-modify-path \
            --default-toolchain ${RUST_VERSION} \
            --component rust-src \
            --target aarch64-unknown-none && \
    /usr/local/cargo/bin/rustup target add aarch64-unknown-none-softfloat && \
    /usr/local/cargo/bin/cargo install bindgen-cli@${BINDGEN_VERSION} && \
    rm -rf ${RUSTUP_HOME}/toolchains/${RUST_VERSION}-*/share/{doc,man}

# Entrypoint — creates toolchain symlink before any command runs
COPY docker/entrypoint.sh /usr/local/bin/entrypoint.sh
RUN chmod +x /usr/local/bin/entrypoint.sh

# Build environment
ENV ARCH=arm64
ENV CROSS_COMPILE=aarch64-linux-

# KERNEL_DIR is provided at runtime (via Makefile.native)
# and references the Buildroot-generated kernel build directory.
    
WORKDIR /build

ENTRYPOINT ["/usr/local/bin/entrypoint.sh"]
CMD ["bash"]
