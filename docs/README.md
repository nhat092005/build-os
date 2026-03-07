# build-os Documentation

This is the central repository for the system architecture, constraints, guidelines, and driver documentation for the **build-os** project.

## Core Documentation

If you are new to the project or starting a non-trivial task, always review these foundational documents first:

| File                                       | Description                                                                                             |
| ------------------------------------------ | ------------------------------------------------------------------------------------------------------- |
| **[`CONSTRAINTS.md`](./CONSTRAINTS.md)**   | **Read First.** The non-negotiable hard rules spanning the kernel, build system, CI/CD, and deployment. |
| **[`ARCHITECTURE.md`](./ARCHITECTURE.md)** | System design, hardware targets, deployment pipelines, and layer boundaries.                            |
| **[`DECISIONS.md`](./DECISIONS.md)**       | Architecture Decision Records (ADR). Explains _why_ specific technical paths were chosen or rejected.   |
| **[`TEST_PLAN.md`](./TEST_PLAN.md)**       | Standardized verification procedures required before marking any driver task as complete.               |

## Sub-Directories

The documentation is logically split into directories based on domain.

| Directory                    | Description                                                                                                                                                                                                               |
| ---------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **[`drivers/`](./drivers/)** | Technical documentation for every custom kernel module and userspace driver (e.g., I2C sensors, GPIO handlers, UART communicators). Each driver has its own multi-file breakdown (Architecture, Hardware, Testing, etc.). |
