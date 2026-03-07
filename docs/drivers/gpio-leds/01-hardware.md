# Hardware: GPIO LEDs

## Wiring — Raspberry Pi 4

| Signal | RPi4 Pin | BCM    | Notes                |
| ------ | -------- | ------ | -------------------- |
| LED+   | Pin 38   | GPIO20 | Anode (through 330Ω) |
| LED-   | Pin 39   | GND    | Cathode              |

Active-high: GPIO20 HIGH = LED on, LOW = LED off.

## Device Tree Overlay

```dts
/ {
	compatible = "brcm,bcm2711";
	fragment@0 {
		target-path = "/";
		__overlay__ {
			gpio-leds {
				compatible = "custom,gpio-led";
				gpios = <&gpio 20 0>;      /* GPIO20, ACTIVE_HIGH */
				label = "gpio-led";
				default-state = "off";
				default-trigger = "none";
				retain-state-suspend;
				status = "okay";
			};
		};
	};
};
```

| Property               | Value               | Meaning                             |
| ---------------------- | ------------------- | ----------------------------------- |
| `compatible`           | `"custom,gpio-led"` | matches driver's OF table           |
| `gpios`                | `<&gpio 20 0>`      | BCM GPIO20, GPIO_ACTIVE_HIGH        |
| `label`                | `"gpio-led"`        | sysfs name under `/sys/class/leds/` |
| `default-state`        | `"off"`             | LED off at probe time               |
| `default-trigger`      | `"none"`            | no automatic trigger                |
| `retain-state-suspend` | present             | keep LED state across suspend       |

### Overrides

```
dtoverlay=gpio-leds,gpio=<pin>,label=<name>,trigger=<name>,retain_state=<0|1>
```
