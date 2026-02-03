#!/bin/sh
# gpio_control.sh

GPIO_BASE=512

BCM_GPIO=$1
CMD=$2
VALUE=$3

# Calculate system GPIO number
SYS_GPIO=$((GPIO_BASE + BCM_GPIO))

case "$CMD" in
    export)
        echo "Exporting BCM GPIO $BCM_GPIO (system GPIO $SYS_GPIO)..."
        echo $SYS_GPIO > /sys/class/gpio/export
        sleep 1
        echo "Exported successfully!"
        ls -la /sys/class/gpio/ | grep gpio$SYS_GPIO
        ;;
        
    unexport)
        echo "Unexporting BCM GPIO $BCM_GPIO (system GPIO $SYS_GPIO)..."
        echo $SYS_GPIO > /sys/class/gpio/unexport
        echo "Done!"
        ;;
        
    out)
        echo "Setting BCM GPIO $BCM_GPIO as output..."
        echo out > /sys/class/gpio/gpio${SYS_GPIO}/direction
        echo "Done!"
        ;;
        
    in)
        echo "Setting BCM GPIO $BCM_GPIO as input..."
        echo in > /sys/class/gpio/gpio${SYS_GPIO}/direction
        echo "Done!"
        ;;
        
    on)
        echo "Turning BCM GPIO $BCM_GPIO ON..."
        echo 1 > /sys/class/gpio/gpio${SYS_GPIO}/value
        echo "Done!"
        ;;
        
    off)
        echo "Turning BCM GPIO $BCM_GPIO OFF..."
        echo 0 > /sys/class/gpio/gpio${SYS_GPIO}/value
        echo "Done!"
        ;;
        
    read)
        VALUE=$(cat /sys/class/gpio/gpio${SYS_GPIO}/value)
        echo "BCM GPIO $BCM_GPIO value: $VALUE"
        ;;
        
    blink)
        TIMES=${VALUE:-10}
        echo "Blinking BCM GPIO $BCM_GPIO $TIMES times..."
        for i in $(seq 1 $TIMES); do
            echo 1 > /sys/class/gpio/gpio${SYS_GPIO}/value
            echo -n "."
            sleep 0.5
            echo 0 > /sys/class/gpio/gpio${SYS_GPIO}/value
            sleep 0.5
        done
        echo " Done!"
        ;;
        
    *)
        echo "GPIO Control Script"
        echo "Usage: $0 <bcm_gpio> <command> [value]"
        echo ""
        echo "Commands:"
        echo "  export          - Export GPIO for use"
        echo "  unexport        - Unexport GPIO"
        echo "  out             - Set as output"
        echo "  in              - Set as input"
        echo "  on              - Turn on (set to 1)"
        echo "  off             - Turn off (set to 0)"
        echo "  read            - Read current value"
        echo "  blink [times]   - Blink LED (default 10 times)"
        echo ""
        echo "Examples:"
        echo "  $0 17 export    # Export GPIO 17"
        echo "  $0 17 out       # Set as output"
        echo "  $0 17 on        # Turn on"
        echo "  $0 17 blink 20  # Blink 20 times"
        echo "  $0 17 off       # Turn off"
        echo "  $0 17 unexport  # Clean up"
        exit 1
        ;;
esac