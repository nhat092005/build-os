# build-os

Minimal embedded Linux build system based on Buildroot.

## Description

`build-os` provides a structured environment for building a custom embedded Linux system.  
It integrates Buildroot with custom kernel modules and utility scripts for managing drivers.

This repository focuses on:

- Building a root filesystem
- Compiling custom kernel modules
- Installing and removing modules safely
- Maintaining a clean project structure

## Requirements

- Linux host
- Buildroot
- GNU Make
- GCC toolchain
- Git