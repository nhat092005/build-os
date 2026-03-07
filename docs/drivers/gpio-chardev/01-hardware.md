# Hardware: GPIO Chardev

## Wiring — Raspberry Pi 4

| Signal | RPi4 Pin | BCM    | Notes                |
| ------ | -------- | ------ | -------------------- |
| LED+   | Pin 40   | GPIO21 | Anode (through 330Ω) |
| LED-   | Pin 39   | GND    | Cathode              |

Active-high: GPIO21 HIGH = LED on, LOW = LED off.

## Device Tree Overlay

```dts
/ {
	compatible = "brcm,bcm2711";

	fragment@0 {
		target = <&gpio>;
		__overlay__ {
			gpio_chardev_pins: gpio_chardev_pins {
				brcm,pins = <21>;
				brcm,function = <1>;   /* output */
				brcm,pull = <0>;       /* no pull */
			};
		};
	};

	fragment@1 {
		target-path = "/";
		__overlay__ {
			gpio-chardev {
				compatible = "gpio-chardev";
				pinctrl-names = "default";
				pinctrl-0 = <&gpio_chardev_pins>;
				gpios = <&gpio 21 0>;   /* GPIO21, ACTIVE_HIGH */
				status = "okay";
			};
		};
	};
};
```

| Property     | Value            | Meaning                      |
| ------------ | ---------------- | ---------------------------- |
| `compatible` | `"gpio-chardev"` | matches driver's OF table    |
| `gpios`      | `<&gpio 21 0>`   | BCM GPIO21, GPIO_ACTIVE_HIGH |
| `pinctrl`    | output, no pull  | explicit pin configuration   |
