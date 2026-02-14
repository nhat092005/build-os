#!/bin/bash

set -e

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"
DRIVERS_DIR="$PROJECT_ROOT/drivers"
OUTPUT_DIR="$PROJECT_ROOT/output"
BOOT_DIR="$OUTPUT_DIR/BOOT"

check_BOOT() {
    if [ ! -d "$BOOT_DIR/overlays" ]; then
        echo "Error: Invalid or missing BOOT structure."
        exit 1
    fi
}

find_overlay() {
    find "$DRIVERS_DIR" -path "*/build/dtbo/*.dtbo" -type f 2>/dev/null
}

remove_overlays() {
    local dest="$BOOT_DIR/overlays"
    local removed=0

    while IFS= read -r overlay; do
        name=$(basename "$overlay")

        if [ -f "$dest/$name" ]; then
            rm -v "$dest/$name"
            removed=$((removed + 1))
        fi
    done < <(find_overlay)

    echo "Removed $removed overlay(s)."
}

main() {
    check_BOOT
    remove_overlays
}

main "$@"
