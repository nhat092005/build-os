# ARCHITECTURE.md — build-os System Architecture

> Describes the overall system design, component boundaries, and key architectural decisions.

---

## System Layers

```
┌─────────────────────────────────────────────────────────────┐
│  Hardware: Raspberry Pi 4 Model B (BCM2711, aarch64)        │
├─────────────────────────────────────────────────────────────┤
│  Linux Kernel 6.12.70 (RPi fork)                            │
│  ├── Out-of-tree drivers (drivers/*/src/*.c, *.rs)          │
│  ├── Device Tree Overlays (drivers/*/dts/*.dts)             │
│  └── In-tree kernel (buildroot/output/build/linux-custom/)  │
├─────────────────────────────────────────────────────────────┤
│  Userspace                                                  │
│  ├── Driver CLI tools (drivers/*/userspace/tools/)          │
│  ├── Shared libraries (drivers/common/libuart-transport/)   │
│  └── BusyBox + OpenSSH + WiFi (from Buildroot rootfs)       │
├─────────────────────────────────────────────────────────────┤
│  Build System                                               │
│  ├── Makefile (top-level: Docker wrapper + all targets)     │
│  ├── mk/docker.mk (DOCKER_RUN_NO_TTY / DOCKER_RUN_TTY)      │
│  ├── Docker image: build-os-builder (hermetic)              │
│  └── Buildroot (kernel + rootfs + packages)                 │
├─────────────────────────────────────────────────────────────┤
│  CI/CD (GitHub Actions)                                     │
│  ├── ci.yml        — build + checkpatch on push/PR          │
│  ├── docker-publish.yml — push builder to ghcr.io           │
│  └── release.yml   — full OS build + GitHub Release on tag  │
└─────────────────────────────────────────────────────────────┘
```

## Docker Wrapping (mk/docker.mk)

Every build target is wrapped with `$(RUN)`:

```
Host:      $(RUN) = docker run --rm -i -v $(PWD):/root -w /root build-os-builder
Container: $(RUN) = (empty) — commands run directly
```

Detection: `IN_DOCKER := $(shell test -f /.dockerenv && echo 1)`.

## KERNEL_DIR Dual-Value Strategy

| Context                         | Value                                        | Set By              |
| ------------------------------- | -------------------------------------------- | ------------------- |
| Normal (after `make buildroot`) | `$(BUILDROOT_DIR)/output/build/linux-custom` | Makefile default    |
| CI (fresh clone)                | `kernel/` (after `make kernel-prepare`)      | Override on cmdline |

## CI Pipeline

```
push main/dev-* → ci.yml
  → docker build (local, not pull)
  → make kernel-prepare
  → make dtbo → make modules → make tools
  → checkpatch.pl (excludes userspace/, common/, *.mod.c)
  → upload artifacts
```

## Release Pipeline

```
push tag v* → release.yml
  → docker pull ghcr.io/nhat092005/build-os-builder:latest
  → make buildroot (full OS, ~0.5 hours)
  → make build (all drivers)
  → sudo make stage-output (extracts boot + rootfs)
  → GitHub Release with sdcard.img + sha256
```

## Deployment Pipeline

```
external/board/raspberrypi/config.txt   ← source of truth
        ↓ make stage-output
output/BOOT/ + output/rootfs/           ← staged (never edit directly)
        ↓ make install-overlays/modules/tools
output/ updated with driver artifacts
        ↓ sudo make deploy-sdcard DEVICE=/dev/sdX
SD card                                 ← flashed
```
