# GPIO Sysfs

GPIO Control via Linux sysfs Interface (Userspace Only)

Userspace library and CLI tool for controlling GPIO pins through the Linux
`/sys/class/gpio` sysfs interface. No kernel module — uses the kernel's
built-in GPIO sysfs ABI directly.

> **Note:** The sysfs GPIO interface is deprecated since kernel 4.x.
> Prefer `gpio-chardev` (character device interface) for new development.

## Stack

```
┌──────────────────────────────────┐
│ BCM GPIO (via /sys/class/gpio/)  │ ← Linux sysfs ABI
└────────────┬─────────────────────┘
             │ open/read/write on sysfs files
┌────────────▼─────────────────────┐
│ gpio-sysfs-ctl                   │ ← Userspace tool
│ depends: libio (static)          │
│                                  │
│ Commands:                        │
│   export / unexport              │
│   <pin> set direction <in|out>   │
│   <pin> set value <0|1>          │
│   <pin> blink <count> <delay_ms> │
│   <pin> info                     │
│   list                           │
└──────────────────────────────────┘
```

## Components

| Component      | Present | Path                               |
| -------------- | ------- | ---------------------------------- |
| Kernel module  | No      | — (uses kernel built-in sysfs ABI) |
| DTS overlay    | No      | — (not needed)                     |
| Userspace lib  | Yes     | `userspace/lib/libio.{h,c}`        |
| Userspace tool | Yes     | `userspace/tools/gpio-sysfs-ctl.c` |

## Quick Start

```bash
make tools TOOLS=gpio-sysfs

# On target:
gpio-sysfs-ctl export 21
gpio-sysfs-ctl 21 set direction out
gpio-sysfs-ctl 21 set value 1
gpio-sysfs-ctl 21 get value
gpio-sysfs-ctl 21 blink 5 500
gpio-sysfs-ctl unexport 21
```

## File Map

| File                               | Description                                             |
| ---------------------------------- | ------------------------------------------------------- |
| `userspace/lib/libio.h`            | Library API: export, direction, value, edge, active_low |
| `userspace/lib/libio.c`            | Implementation: sysfs read/write helpers                |
| `userspace/tools/gpio-sysfs-ctl.c` | CLI tool: wraps libio functions                         |
| `Makefile`                         | Build orchestration (tools only)                        |
