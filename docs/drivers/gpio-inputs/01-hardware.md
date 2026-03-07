# Hardware: GPIO Inputs

## Wiring — Raspberry Pi 4

| Signal | RPi4 Physical Pin | BCM    |
| ------ | ----------------- | ------ |
| Button | Pin 32            | GPIO12 |
| GND    | Pin 34            | GND    |

Active-low configuration: internal pull-up is enabled by the DTS. Pressing
the button connects GPIO12 to GND.

## Device Tree Overlay

```dts
/ {
	compatible = "brcm,bcm2711";

	fragment@0 {
		target = <&gpio>;
		__overlay__ {
			gpio_inputs_pins: gpio_inputs_pins {
				brcm,pins = <12>;
				brcm,function = <0>; /* in */
				brcm,pull = <2>; /* up */
			};
		};
	};

	fragment@1 {
		target-path = "/";
		__overlay__ {
			gpio-keys {
				compatible = "custom,gpio-inputs";
				pinctrl-names = "default";
				pinctrl-0 = <&gpio_inputs_pins>;

				button@12 {
					label = "gpio-button-1";
					gpios = <&gpio 12 1>; /* GPIO_ACTIVE_LOW */
					linux,code = <0x100>; /* BTN_0 */
					debounce-interval = <20>; /* ms */
				};
			};
		};
	};
};
```
