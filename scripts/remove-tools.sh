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
    if [ ! -d "$USR_BIN_DIR" ]; then
        echo "Error: Invalid or missing rootfs at $USR_BIN_DIR"
        exit 1
    fi
}

# Check if file is an ELF executable
is_elf_executable() {
    local file="$1"
    
    # Check if file exists
    [ -f "$file" ] || return 1
    
    # Method 1: Use 'file' command if available
    if command -v file &> /dev/null; then
        file "$file" | grep -q "ELF.*executable" && \
        ! file "$file" | grep -q "shared object" && \
        ! file "$file" | grep -q "relocatable"
        return $?
    fi
    
    # Method 2: Fallback - check ELF magic number
    local magic=$(od -An -N4 -tx1 "$file" 2>/dev/null | tr -d ' ')
    if [ "$magic" = "7f454c46" ]; then
        local e_type=$(od -An -j16 -N2 -tx2 "$file" 2>/dev/null | tr -d ' ')
        [[ "$e_type" =~ ^000[23] ]]
        return $?
    fi
    
    return 1
}

# Should skip this file?
should_skip() {
    local file="$1"
    local basename=$(basename "$file")
    
    # Skip by extension
    [[ "$basename" == *.o ]] && return 0
    [[ "$basename" == *.a ]] && return 0
    [[ "$basename" == *.so* ]] && return 0
    [[ "$basename" == *.c ]] && return 0
    [[ "$basename" == *.h ]] && return 0
    
    return 1
}

# Find built userspace tools (ELF executables only)
find_tools() {
    local tools=()
    
    # Find all files in drivers/*/build/tools/
    while IFS= read -r -d '' file; do
        # Skip non-executables by extension
        should_skip "$file" && continue
        
        # Check if it's an ELF executable
        if is_elf_executable "$file"; then
            tools+=("$(basename "$file")")
        fi
    done < <(find "$DRIVERS_DIR" -path "*/build/tools/*" -type f -print0 2>/dev/null)
    
    # Output unique tool names
    printf '%s\n' "${tools[@]}" | sort -u
}

# Remove tools from rootfs
remove_tools() {
    local removed=0
    local not_found=0
    local dest="$USR_BIN_DIR"
    
    while IFS= read -r name; do
        [ -z "$name" ] && continue
        
        if [ -f "$dest/$name" ]; then
            echo "Removed $name"
            rm -f "$dest/$name"
            removed=$((removed + 1))
        else
            echo "Not found $name (skipping)"
            not_found=$((not_found + 1))
        fi
    done < <(find_tools)
    
    if [ $removed -gt 0 ]; then
        echo "Removed $removed tool(s) from $dest"
    fi
    
    if [ $not_found -gt 0 ]; then
        echo "Warning $not_found tool(s) not found in rootfs"
    fi
    
    if [ $removed -eq 0 ] && [ $not_found -eq 0 ]; then
        echo "No tools found to remove"
    fi
}

# Main
main() {
    check_rootfs
    remove_tools
}

main "$@"
