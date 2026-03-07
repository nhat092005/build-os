# CONSTRAINTS.md — Hard Constraints

> These are non-negotiable. No task, no matter how urgent, overrides them.
> If a constraint needs to change, update this file explicitly with rationale.

---

## Kernel Code

- **Never use `BUG_ON()`** — use `WARN_ON_ONCE()` + recovery path
- **Never use legacy GPIO API** (`gpio_request`, `gpio_set_value`) — use `gpiod_*` exclusively
- **Never hardcode GPIO pin numbers** in driver source — use DTS or `module_param()`
- **Never use `typedef struct`** in kernel headers — use `struct name` directly
- **Always run `checkpatch.pl --strict --no-tree`** on every kernel diff before done
- **ABI is frozen once released** — never change uapi headers or ioctl numbers after a release tag

## Git Submodules

- **Never edit `kernel/` or `buildroot/` directly** — they are read-only git submodules
- Changes go in `external/` (Buildroot config), `drivers/` (out-of-tree), or project-level files

## Build System

- **All build targets use `$(RUN)`** — run inside Docker container, not on bare host
- **Exception: deployment targets are HOST-ONLY** — `make stage-output`, `make deploy-sdcard`, `make install-*`, `make remove-*` require root and hardware access
- **`make buildroot` runs INSIDE Docker** — it is wrapped with `$(RUN)`
- **`kernel-prepare` required before `make modules`** on fresh clone (CI mode)
- **`make build-all` = `make buildroot` + `make build`** — do not use in CI, use `make build` instead
- **Never copy to SD card manually** — always use the full deploy pipeline

## CI/CD

- **CI builds Docker image locally** (`docker build`), never relies on `docker pull` — image may not exist on registry yet
- **checkpatch excludes**: `userspace/`, `common/`, `*.mod.c` — different coding standards
- **`upload-artifact` skips gitignored files** — use find+cp to `/tmp` workaround
- **`docker/setup-buildx-action@v3` required** for registry cache in `docker-publish.yml`

## Deployment

- **`output/` is generated** — never edit files in `output/` directly
- **Source of truth**: `external/board/raspberrypi/config.txt` → `make stage-output` overlays it
