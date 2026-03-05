# gpio-sysfs — GPIO Sysfs Control Tool

## Overview

| Field     | Value                              |
| --------- | ---------------------------------- |
| Type      | Userspace only (no kernel module)  |
| Interface | Deprecated `/sys/class/gpio` sysfs |
| Tool      | `gpio-sysfs-ctl`                   |

## Build

```bash
make tools TOOLS=gpio-sysfs
```

## Usage

```bash
gpio-sysfs-ctl --help
```

## Note

This driver wraps the deprecated `/sys/class/gpio` sysfs interface. Consider using `gpio-chardev` (character device with ioctl) for new development.
