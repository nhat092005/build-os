#!/bin/bash

set -e

# Configuration
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"
TOOLCHAINS_DIR="$PROJECT_ROOT/toolchains"

remove_toolchains() {
    if [ -d "$TOOLCHAINS_DIR" ]; then
        rm -rf "$TOOLCHAINS_DIR"
    fi
}

main() {
    remove_toolchains
}

main "$@"