# SPDX-License-Identifier: GPL-2.0
# Makefile for Docker integration (top-level)

DOCKER_IMAGE          ?= build-os-builder
DOCKER_CONTAINER_ROOT ?= /root

DOCKER_INTERACTIVE := -i
DOCKER_TTY  := $(shell [ -t 0 ] && echo "-t")
DOCKER_TERM := $(if $(TERM),-e TERM=$(TERM),-e TERM=xterm-256color)

DOCKER_MOUNT   ?= $(PWD):$(DOCKER_CONTAINER_ROOT)
DOCKER_WORKDIR ?= $(DOCKER_CONTAINER_ROOT)

DOCKER_RUN_NO_TTY = docker run --rm \
                $(DOCKER_INTERACTIVE) \
                -v $(DOCKER_MOUNT) \
                -w $(DOCKER_WORKDIR) \
                $(DOCKER_IMAGE)

DOCKER_RUN_TTY = docker run --rm \
                $(DOCKER_INTERACTIVE) \
                $(DOCKER_TTY) \
                $(DOCKER_TERM) \
                -v $(DOCKER_MOUNT) \
                -w $(DOCKER_WORKDIR) \
                $(DOCKER_IMAGE)
