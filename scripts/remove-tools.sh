#!/bin/bash

set -e

# Configuration
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"
DRIVERS_DIR="$PROJECT_ROOT/drivers"
OUTPUT_DIR="$PROJECT_ROOT/output"
ROOTFS_DIR="$OUTPUT_DIR/rootfs"

# Check staged rootfs exists
check_rootfs() {
    if [ ! -d "$ROOTFS_DIR/usr/bin" ]; then
        echo "Error: Invalid or missing rootfs."
        exit 1
    fi
}

# Find built userspace tools
find_tools() {
    find "$DRIVERS_DIR" -path "*/build/tools/*" -type f -executable 2>/dev/null
}

# Remove tools from rootfs
remove_tools() {
    local removed=0
    local dest="$ROOTFS_DIR/usr/bin"

    while IFS= read -r tool; do
        name=$(basename "$tool")

        if [ -f "$dest/$name" ]; then
            rm -v "$dest/$name"
            removed=$((removed + 1))
        fi
    done < <(find_tools)

    echo "Removed $removed tool(s)."
}

# Main
main() {
    check_rootfs
    remove_tools
}

main "$@"
