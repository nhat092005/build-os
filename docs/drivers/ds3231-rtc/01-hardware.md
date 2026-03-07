# Hardware: DS3231 RTC

## Device

| Property        | Value                               |
| --------------- | ----------------------------------- |
| Chip            | Maxim DS3231                        |
| Interface       | I2C                                 |
| I2C address     | 0x68 (fixed, no address pins)       |
| Bus speed       | 400 kHz (I2C Fast Mode)             |
| Battery         | CR2032 coin cell                    |
| Time range      | 2000-01-01 to 2199-12-31            |
| Temp resolution | 0.25 °C (updated every 64s)         |
| Alarms          | Alarm 1 (second) + Alarm 2 (minute) |

## Wiring — Raspberry Pi 4

| Signal  | RPi4 Pin | BCM   | Notes                      |
| ------- | -------- | ----- | -------------------------- |
| VCC     | Pin 1    | —     | 3.3V                       |
| GND     | Pin 6    | —     | Ground                     |
| SDA     | Pin 3    | GPIO2 | I2C data                   |
| SCL     | Pin 5    | GPIO3 | I2C clock                  |
| SQW/INT | Pin 7    | GPIO4 | Alarm interrupt (optional) |

## Device Tree Overlay

```dts
ds3231: ds3231@68 {
	compatible = "maxim,ds3231";
	reg = <0x68>;
	wakeup-source;
	interrupt-parent = <&gpio>;
	interrupts = <4 2>;   /* GPIO4, IRQ_TYPE_EDGE_FALLING */
};
```

Override: `dtoverlay=ds3231-rtc,int_pin=17`
