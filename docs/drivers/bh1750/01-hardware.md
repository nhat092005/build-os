# Hardware: BH1750

## Device

| Property       | Value                                                                           |
| -------------- | ------------------------------------------------------------------------------- |
| Chip           | ROHM BH1750FVI                                                                  |
| Interface      | I2C                                                                             |
| Supply voltage | 2.4 – 3.6 V (typ. 3.0 V)                                                        |
| I2C address    | 0x23 (ADDR LOW, default)                                                        |
| Alt. address   | 0x5C (ADDR HIGH)                                                                |
| Bus speed      | Up to 400 kHz (Fast Mode)                                                       |
| Measurement    | 1 lx (H-res), 0.5 lx (H-res2), 4 lx (L-res)                                     |
| Meas. time     | 120 ms (H-res/H2), 16 ms (L-res)                                                |
| Range          | 1 – 65535 lx                                                                    |
| Datasheet      | [ROHM BH1750FVI](https://www.mouser.com/datasheet/2/348/bh1750fvi-e-186247.pdf) |

## Wiring — Raspberry Pi 4

| Signal | RPi4 Physical Pin | BCM   |
| ------ | ----------------- | ----- |
| VCC    | Pin 1             | 3.3V  |
| GND    | Pin 6             | GND   |
| SDA    | Pin 3             | GPIO2 |
| SCL    | Pin 5             | GPIO3 |
| ADDR   | GND               | GND   |

I2C bus: `i2c-1` (`/dev/i2c-1`)
I2C address: `0x23` (from DTS `reg = <0x23>`)

## Device Tree Overlay

```dts
/dts-v1/;
/plugin/;

/ {
	compatible = "brcm,bcm2711", "brcm,bcm2837", "brcm,bcm2835";

	fragment@0 {
		target = <&i2c1>;
		__overlay__ {
			status = "okay";
			clock-frequency = <100000>;
			#address-cells = <1>;
			#size-cells = <0>;

			bh1750: bh1750@23 {
				compatible = "rohm,bh1750";
				reg = <0x23>;
				status = "okay";
			};
		};
	};

	__overrides__ {
		addr = <&bh1750>, "reg:0";
	};
};
```

### Explanation

| Property          | Value           | Meaning                               |
| ----------------- | --------------- | ------------------------------------- |
| `compatible`      | `"rohm,bh1750"` | matches driver's `of_device_id` table |
| `reg`             | `<0x23>`        | I2C slave address on the bus          |
| `clock-frequency` | `<100000>`      | I2C bus speed: 100 kHz Standard Mode  |
| `status`          | `"okay"`        | enables the node                      |

## Enabling on Target

```bash
# Add to /boot/config.txt
dtparam=i2c_arm=on
dtoverlay=bh1750

# Reboot then verify
dmesg | grep bh1750
ls /sys/bus/iio/devices/
```
