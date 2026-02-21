#!/bin/bash

set -e

# Configuration
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"
DRIVERS_DIR="$PROJECT_ROOT/drivers"
OUTPUT_DIR="$PROJECT_ROOT/output"
BOOT_DIR="$OUTPUT_DIR/BOOT"

# Check staged BOOT exists
check_BOOT() {
    if [ ! -d "$BOOT_DIR" ]; then
        echo "Error: Staged BOOT not found."
        exit 1
    fi
    
    if [ ! -d "$BOOT_DIR/overlays" ]; then
        echo "Error: Invalid BOOT structure."
        exit 1
    fi
}

# Find overlays
find_overlay() {
    find "$DRIVERS_DIR" -path "*/build/dtbo/*.dtbo" -type f 2>/dev/null
}

# Install overlays to rootfs
install_overlays() {
    local overlays=("$@")
    local installed=0
    local dest="$BOOT_DIR/overlays"
    
    mkdir -p "$dest"
    
    for overlay in "${overlays[@]}"; do
        local name
        name=$(basename "$overlay")
        if ! cp -v "$overlay" "$dest/$name"; then
            echo "Error: Failed to copy $name"
            exit 1
        fi
        installed=$((installed + 1))
    done
}

# Main
main() {    
    check_BOOT
    
    mapfile -t overlays < <(find_overlay)
    
    if [ ${#overlays[@]} -eq 0 ] || [ -z "${overlays[0]}" ]; then
        echo "No device tree overlays found to install."
        exit 0
    fi
    
    install_overlays "${overlays[@]}"
}

# Run main
main "$@"
