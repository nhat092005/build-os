# Hardware: SHT3x

## Device

| Property       | Value                                                                                              |
| -------------- | -------------------------------------------------------------------------------------------------- |
| Chip           | Sensirion SHT30/SHT31/SHT35                                                                        |
| Interface      | I2C                                                                                                |
| Supply voltage | 2.15 – 5.5 V (typ. 3.3 V)                                                                          |
| I2C address    | 0x44 (ADDR LOW, default)                                                                           |
| Alt. address   | 0x45 (ADDR HIGH)                                                                                   |
| Bus speed      | Up to 1 MHz (Fast Mode Plus)                                                                       |
| Temperature    | −40 to +125 °C, 0.01 °C res                                                                        |
| Humidity       | 0 to 100 %RH, 0.01 %RH res                                                                         |
| Measurement    | ~15 ms (high repeatability)                                                                        |
| Datasheet      | [Sensirion SHT3x](https://sensirion.com/media/documents/213E6A3B/63A5A569/Datasheet_SHT3x_DIS.pdf) |

## Wiring — Raspberry Pi 4

| Signal | RPi4 Physical Pin | BCM   | Wire color (convention) |
| ------ | ----------------- | ----- | ----------------------- |
| VCC    | Pin 1             | —     | Red (3.3V)              |
| GND    | Pin 6             | —     | Black                   |
| SDA    | Pin 3             | GPIO2 | Blue                    |
| SCL    | Pin 5             | GPIO3 | Yellow                  |

I2C bus: `i2c-1` (`/dev/i2c-1`)
I2C address: `0x44` (from DTS `reg = <0x44>`)

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

			sht3x: sht3x@44 {
				compatible = "sensirion,sht3x";
				reg = <0x44>;
				status = "okay";
			};
		};
	};

	__overrides__ {
		addr = <&sht3x>, "reg:0";
	};
};
```

### Explanation

| Property          | Value               | Meaning                               |
| ----------------- | ------------------- | ------------------------------------- |
| `compatible`      | `"sensirion,sht3x"` | matches driver's `of_device_id` table |
| `reg`             | `<0x44>`            | I2C slave address on the bus          |
| `clock-frequency` | `<100000>`          | I2C bus speed: 100 kHz Standard Mode  |
| `status`          | `"okay"`            | enables the node                      |

### Override: alternate I2C address

```
dtoverlay=sht3x,addr=0x45
```

## Enabling on Target

```bash
# Add to /boot/config.txt
dtparam=i2c_arm=on
dtoverlay=sht3x

# Reboot then verify
dmesg | grep sht3x
ls /sys/class/hwmon/
```
