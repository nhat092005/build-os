# Docker

Hermetic build environment for cross-compiling kernel drivers and Buildroot images.

## Images

| Image              | Purpose                                    | Base           |
| ------------------ | ------------------------------------------ | -------------- |
| `build-os-sdk`     | Toolchain only (GCC 14.x + cross-compiler) | `ubuntu:24.04` |
| `build-os-builder` | Full builder (SDK + Rust + host deps)      | `build-os-sdk` |

## Registry

- SDK: `ghcr.io/nhat092005/build-os-sdk:gcc14.3-glibc`
- Builder: `ghcr.io/nhat092005/build-os-builder:latest`

## Files

| File                          | Purpose                                      |
| ----------------------------- | -------------------------------------------- |
| `Dockerfile`                  | Full builder image                           |
| `sdk.Dockerfile`              | SDK base image                               |
| `entrypoint.sh`               | Creates toolchain symlink at container start |
| `sdk.Dockerfile.dockerignore` | SDK build context filter                     |

## Build

```bash
make docker-build            # Build builder image locally
make sdk-image-build         # Build SDK image locally
make sdk-image-push          # Push SDK to ghcr.io
```

## Entrypoint

`entrypoint.sh` creates symlink: `/root/toolchains/aarch64-buildroot-linux-gnu_sdk-buildroot → /toolchain/`

This ensures the Buildroot defconfig toolchain path resolves inside the container.
