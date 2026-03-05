# CI/CD

## Workflows Overview

| Trigger                                                                                                                            | Workflow             | Purpose                           | Typical duration |
| ---------------------------------------------------------------------------------------------------------------------------------- | -------------------- | --------------------------------- | ---------------- |
| Push to `main`/`dev-*` or PR to `main` (paths: `drivers/**`, `kernel/**`, `docker/Dockerfile`, `Makefile`, `mk/**`, `external/**`) | `ci.yml`             | Build all drivers and checkpatch  | 10-20 min        |
| Push to `main` (paths: `docker/Dockerfile`)                                                                                        | `docker-publish.yml` | Rebuild and publish builder image | 10-20 min        |
| Push tag `v*`                                                                                                                      | `release.yml`        | Full OS build → GitHub Release    | 150-240 min      |

Docs-only changes (`task/**`, `prompt/**`, `*.md`) do **not** trigger any workflow.

## Image Registry

- **Builder image**: `ghcr.io/nhat092005/build-os-builder`
- **SDK base image**: `ghcr.io/nhat092005/build-os-sdk:gcc14.3-glibc` (baked into builder via `--build-arg SDK_IMAGE`)
- **Local tag**: `build-os-builder` — all `make` targets use this name; CI pulls from ghcr.io then retags locally

## CI (`ci.yml`)

**Trigger paths** (push to `main`/`dev-*` or PR to `main`):
- `drivers/**`, `kernel/**`, `docker/Dockerfile`, `Makefile`, `mk/**`, `external/**`

**Steps:**
1. Checkout (no submodules)
2. `git submodule update --init --depth 1 kernel` — shallow kernel clone only
3. `docker pull ghcr.io/.../build-os-builder:latest` + retag as `build-os-builder`
4. `make kernel-prepare` — runs `bcm2711_defconfig` + `modules_prepare` inside Docker (~2-3 min)
5. Verify `CONFIG_RUST=y` in `kernel/.config`
6. `make modules` — builds all kernel drivers inside Docker
7. `make dtbo` — builds all device tree overlays inside Docker
8. `make tools` — builds all userspace tools inside Docker
9. checkpatch — `kernel/scripts/checkpatch.pl --strict --no-tree -f` on all `drivers/**/*.c` and `*.h`
10. Upload `drivers/**/build/module/*.ko` and `drivers/**/build/dtbo/*.dtbo` as artifacts (7-day retention)

**What CI does NOT run:** `make buildroot` (60+ min), `make deploy-sdcard` (requires hardware), `make stage-output` (no sdcard.img in CI).

**Run CI locally:**
```bash
make ci-check
```

### kernel-prepare rationale

`make modules` requires a prepared kernel tree with `Module.symvers`, generated headers, scripts, and Rust artifacts. Rather than running the 60-min `make buildroot`, `make kernel-prepare` runs `modules_prepare` directly on the `kernel/` submodule in ~2-3 min. This works because `CONFIG_MODVERSIONS=n` eliminates the need for a matching `Module.symvers`.

## Docker Publish (`docker-publish.yml`)

**Trigger:** push to `main`, path `docker/Dockerfile`.

Builds `build-os-builder` with `--build-arg SDK_IMAGE=ghcr.io/nhat092005/build-os-sdk:gcc14.3-glibc` and pushes to `ghcr.io/nhat092005/build-os-builder` with tags `latest` and `sha-<commit>`. Uses registry cache (`buildcache` tag) so unchanged layers are not re-pushed.

## Release (`release.yml`)

**Trigger:** push of a tag matching `v*`.

**Sequence:**
1. Full checkout (`submodules: recursive`) — both `buildroot/` and `kernel/` needed
2. Pull builder image + retag
3. Restore `buildroot/dl` cache (key: hash of `external/configs/*_defconfig`) to skip re-downloads
4. `make buildroot` inside Docker — full Buildroot OS build using `raspberrypi4_64_custom_defconfig`
5. `make build` inside Docker — builds dtbo, modules, and tools against the just-built kernel
6. Install `mtools` + `sudo make stage-output` — extract boot/rootfs from Buildroot images
7. Verify `sdcard.img` exists, compute `sha256sum`
8. Create GitHub Release with `sdcard.img` + `sdcard.img.sha256` and auto-generated notes

**Flash the image:**
```bash
sudo dd if=sdcard.img of=/dev/sdX bs=4M status=progress && sync
```

**Trigger a release:**
```bash
git tag v1.0.0
git push origin v1.0.0
```

## Submodule Strategy

| Workflow             | Submodules needed          | Strategy                                                                    |
| -------------------- | -------------------------- | --------------------------------------------------------------------------- |
| `ci.yml`             | `kernel/` only             | `submodules: false` + manual `git submodule update --init --depth 1 kernel` |
| `release.yml`        | `buildroot/` and `kernel/` | `submodules: recursive` (full clone, no depth)                              |
| `docker-publish.yml` | None                       | `submodules: false`                                                         |

## Cache Strategy

| Workflow             | Cache                                 | Key                                            |
| -------------------- | ------------------------------------- | ---------------------------------------------- |
| `ci.yml`             | Docker layer cache via ghcr.io        | `buildcache` tag (owned by docker-publish.yml) |
| `release.yml`        | `buildroot/dl` via `actions/cache@v4` | `hashFiles('external/configs/*_defconfig')`    |
| `docker-publish.yml` | Registry cache (`type=registry`)      | persistent `buildcache` tag                    |

## Permissions

| Workflow             | `contents` | `packages` |
| -------------------- | ---------- | ---------- |
| `ci.yml`             | read       | read       |
| `release.yml`        | write      | read       |
| `docker-publish.yml` | read       | write      |
