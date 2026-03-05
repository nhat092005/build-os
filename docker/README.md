# DESIGN.md - Full Docker Build Platform

## Architecture

Everything runs inside Docker: Buildroot, kernel, rootfs, drivers.

Host requires Docker Engine 24 or newer. Nothing else.

```
GHCR: ghcr.io/nhat092005/build-os-sdk:gcc14.3-glibc
  └─ build-os-builder (FROM SDK + Rust + host tools)
      └─ docker run -v $(PWD):/build
          ├─ make buildroot   -> Buildroot builds kernel + rootfs
          └─ make build-all   -> out-of-tree driver iteration
```

---

## Toolchain Symlink Trick

Defconfig expects:

```
BR2_TOOLCHAIN_EXTERNAL_PATH = $(BR2_EXTERNAL)/../toolchains/aarch64-buildroot-linux-gnu_sdk-buildroot
```

Inside container: `BR2_EXTERNAL = /build/external` so the resolved path is `/build/toolchains/aarch64-buildroot-linux-gnu_sdk-buildroot`.

The SDK is baked into the image at `/toolchain/`. The entrypoint creates a symlink on every container start:

```bash
ln -sf /toolchain /build/toolchains/aarch64-buildroot-linux-gnu_sdk-buildroot
```

The defconfig is never modified. The symlink makes it work transparently on any machine.

---

## Kernel Config Derivation

The kernel config is derived the same way Buildroot does it internally:

1. Apply `make ARCH=arm64 bcm2711_defconfig` from the `kernel/` submodule.
2. Merge `external/board/raspberrypi/linux-rust.config` fragment which sets:
   - `CONFIG_RUST=y`
   - `CONFIG_MODVERSIONS=n`

`CONFIG_MODVERSIONS=n` means the kernel does not check symbol CRCs on `insmod`. Module.symvers correctness is not critical for this build.

---

## Rust Detection

`external/external.mk` detects Rust toolchain via:

```makefile
SYSTEM_RUSTC := $(shell command -v rustc)
SYSTEM_BINDGEN := $(shell command -v bindgen)
```

Rust is installed in the builder image at `/usr/local/cargo/bin/` which is on `$PATH`, so it is detected automatically by Buildroot without any extra configuration.

---

## Stale Stamp Protection

When the Rust install path changes between image rebuilds, Buildroot may have stale kernel stamps pointing to the old path. This causes a `rustc not found` error at build time.

The entrypoint detects this mismatch on every container start and removes the affected stamps automatically, forcing a clean kernel reconfigure on the next build. No manual intervention is needed.

---

## Driver Build Paths

| Variable              | Value                                      |
| --------------------- | ------------------------------------------ |
| LINUX_DIR (Buildroot) | /build/buildroot/output/build/linux-custom |
| KERNEL_DIR (Makefile) | buildroot/output/build/linux-custom        |
| TARGET_CROSS          | aarch64-linux- (from toolchain symlink)    |

---

## CI/CD

### Workflows

| Trigger | Workflow | What it does |
|---------|----------|--------------|
| Push to `main`/`dev-*` or PR — `drivers/`, `kernel/`, `Makefile*` changed | `ci.yml` | Build all modules + DTBOs + tools + checkpatch |
| Push to `main` — `docker/Dockerfile` changed | `docker-publish.yml` | Rebuild and push builder image to `ghcr.io` |
| Push tag `v*` | `release.yml` | Full Buildroot OS build → GitHub Release with `sdcard.img` |

All workflows pull `ghcr.io/nhat092005/build-os-builder:latest` — no `apt-get` or SDK build on the runner.

### Run CI checks locally

```bash
# Full CI check (Docker required) — mirrors GitHub Actions ci.yml
make ci-check

# Rebuild the builder image
make ci-image
```

`make ci-check` runs `kernel-prepare` + `modules` + `dtbo` + `tools` + `checkpatch.pl` in sequence, all inside the builder container.

### Pull the published builder image

```bash
docker pull ghcr.io/nhat092005/build-os-builder:latest
docker tag  ghcr.io/nhat092005/build-os-builder:latest build-os-builder
```

After tagging, all `make` targets (`make modules`, `make build-all`, etc.) work without running `make docker-build` first.

### Design decisions

See [`.github/CI-DESIGN.md`](../.github/CI-DESIGN.md) for the full rationale: `kernel-prepare` strategy, submodule selection per workflow, image caching, and timeout budgets.

---

## Pinned Versions

| Component | Version                                 |
| --------- | --------------------------------------- |
| SDK / GCC | 14.3.0 (Buildroot, from GHCR SDK image) |
| Kernel    | raspberrypi/linux (submodule)           |
| Rust      | 1.93.1                                  |
| bindgen   | 0.72.1                                  |