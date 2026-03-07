# Hardware: GPIO Rust

## Wiring — Raspberry Pi 4

| Signal | RPi4 Pin | BCM    | Notes                |
| ------ | -------- | ------ | -------------------- |
| LED+   | Pin 36   | GPIO16 | Anode (through 330Ω) |
| LED-   | Pin 39   | GND    | Cathode              |

Note: GPIO16 is the default if `gpio_pin` module parameter is not specified.
Active-high: GPIO HIGH = LED on, LOW = LED off.

## Device Tree Overlay

```dts
/ {
	compatible = "brcm,bcm2711";
	fragment@0 {
		target-path = "/";
		__overlay__ {
			gpio-rust {
				compatible = "gpio-rust";
				gpios = <&gpio 16 0>;   /* Default: GPIO16, ACTIVE_HIGH */
				status = "okay";
			};
		};
	};
};
```
