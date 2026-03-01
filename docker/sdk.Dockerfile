# docker/sdk.Dockerfile — SDK base image
#
# Build: make sdk-image-build
# Push:  make sdk-image-push
FROM ubuntu:24.04

# Copy and relocate the Buildroot SDK
COPY toolchains/aarch64-buildroot-linux-gnu_sdk-buildroot/ /toolchain/
RUN /toolchain/relocate-sdk.sh

# Set environment variables for the SDK
ENV PATH=/toolchain/bin:${PATH}
ENV CROSS_COMPILE=aarch64-linux-
