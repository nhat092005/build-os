#!/bin/bash

set -e

# Configuration
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"
DRIVERS_DIR="$PROJECT_ROOT/drivers"
OUTPUT_DIR="$PROJECT_ROOT/output"

ROOTFS_DIR="$OUTPUT_DIR/rootfs"
USR_BIN_DIR="$ROOTFS_DIR/usr/bin"

# Check staged rootfs exists
check_rootfs() {
    if [ ! -d "$ROOTFS_DIR" ]; then
        echo "Error: Invalid rootfs directory: $ROOTFS_DIR"
        exit 1
    fi
}

# Check usr/bin directory exists
check_usr_bin() {
    if [ ! -d "$USR_BIN_DIR" ]; then
        echo "Error: Invalid usr/bin directory: $USR_BIN_DIR"
        exit 1
    fi
}

# Check if file is an ELF executable
is_elf_executable() {
    local file="$1"
    
    # Check if file exists and is executable
    [ -x "$file" ] || return 1
    
    # Check if it's an ELF file
    if command -v file &> /dev/null; then
        file "$file" | grep -q "ELF.*executable"
        return $?
    else
        # Fallback: check magic number
        local magic=$(od -An -N4 -tx1 "$file" 2>/dev/null | tr -d ' ')
        [ "$magic" = "7f454c46" ]
        return $?
    fi
}

# Find userspace tools
find_tools() {
    local tools=()
    
    # Find all files in drivers/*/build/tools/
    while IFS= read -r -d '' file; do
        # Check if it's an ELF executable
        if is_elf_executable "$file"; then
            tools+=("$file")
        fi
    done < <(find "$DRIVERS_DIR" -path "*/build/tools/*" -type f -print0 2>/dev/null)
    
    # Output the tools array
    echo "${tools[@]}"
}

# Install tools to rootfs
install_tools() {
    local tools=("$@")
    local installed=0
    local dest="$USR_BIN_DIR"
    
    for tool in "${tools[@]}"; do
        local name=$(basename "$tool")
        if ! cp -f "$tool" "$dest/$name"; then
            echo "Error: Failed to copy $name"
            exit 1
        fi
        chmod +x "$dest/$name"
        echo "Installed $name"
        installed=$((installed + 1))
    done
    
    echo "Installed $installed tool(s) to $dest"
}

# Main
main() {    
    check_rootfs
    check_usr_bin

    IFS=' ' read -r -a tools <<< "$(find_tools)"
    
    if [ ${#tools[@]} -eq 0 ] || [ -z "${tools[0]}" ]; then
        echo "No ELF executable tools found to install."
        exit 0
    fi

    install_tools "${tools[@]}"
}

# Run main
main "$@"
