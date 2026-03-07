# Kernel Driver: BH1750

## Module Registration

```c
module_i2c_driver(bh1750_driver);
```

**Driver ID tables:**

```c
static const struct of_device_id bh1750_of_match[] = {
	{ .compatible = "rohm,bh1750" },
	{}
};

static const struct i2c_device_id bh1750_id[] = { { "bh1750", 0 }, {} };
```

## Private Data Structure

```c
struct bh1750_data {
	struct i2c_client *client;
	struct mutex lock;
	struct delayed_work work;
	u16 raw;
	unsigned long last_update;
	bool valid;
	enum bh1750_resolution res;
	bool continuous;
};
```

| Field         | Type                     | Purpose                               |
| ------------- | ------------------------ | ------------------------------------- |
| `client`      | `struct i2c_client *`    | I2C client handle                     |
| `lock`        | `struct mutex`           | serializes all I2C transactions       |
| `work`        | `struct delayed_work`    | periodic measurement work             |
| `raw`         | `u16`                    | cached raw ADC reading                |
| `last_update` | `unsigned long`          | jiffies timestamp of last measurement |
| `valid`       | `bool`                   | true if cached data is valid          |
| `res`         | `enum bh1750_resolution` | current resolution mode (H/H2/L)      |
| `continuous`  | `bool`                   | true if continuous mode is active     |

## probe()

**Called when:** kernel finds DTS node with `compatible = "rohm,bh1750"`

**Step-by-step:**

1. `dev_info(dev, "Probing BH1750 driver v%s\n", "1.0.0")`
2. `i2c_check_functionality(I2C_FUNC_I2C)` — verify adapter
3. Clamp `resolution` module param (0-2)
4. `devm_iio_device_alloc()` — allocate IIO device + private data
5. `devm_mutex_init()` — initialize mutex
6. Power on: send `0x01`, wait 10 ms
7. Configure `indio_dev`: name, channels, modes (INDIO_DIRECT_MODE)
8. Start continuous measurement mode
9. `devm_iio_device_register()` — register IIO device
10. `INIT_DELAYED_WORK()` + `schedule_delayed_work()` — periodic poll
11. `devm_pm_runtime_enable()` + autosuspend setup (2000 ms)

**Expected dmesg on success:**

```
bh1750 1-0023: Probing BH1750 driver v1.0.0
bh1750 1-0023: BH1750 sensor registered at 0x23 (resolution=0)
```

## remove()

```c
static void bh1750_remove(struct i2c_client *client)
{
	/* Cancel periodic work */
	if (data->continuous)
		cancel_delayed_work_sync(&data->work);
	/* Power down the sensor */
	mutex_lock(&data->lock);
	bh1750_send_cmd(data, BH1750_CMD_POWER_DOWN); /* 0x00 */
	mutex_unlock(&data->lock);
	dev_info(&client->dev, "BH1750 sensor removed\n");
}
```

## IIO Channel Specification

```c
static const struct iio_chan_spec bh1750_channels[] = {
	{
		.type = IIO_LIGHT,
		.info_mask_separate = BIT(IIO_CHAN_INFO_RAW) |
				      BIT(IIO_CHAN_INFO_SCALE) |
				      BIT(IIO_CHAN_INFO_PROCESSED),
	},
};
```

| sysfs Attribute        | IIO Info Mask             | Returns                       |
| ---------------------- | ------------------------- | ----------------------------- |
| `in_illuminance_raw`   | `IIO_CHAN_INFO_RAW`       | raw ADC value (u16)           |
| `in_illuminance_scale` | `IIO_CHAN_INFO_SCALE`     | 0.833333 (H/L), 0.416667 (H2) |
| `in_illuminance_input` | `IIO_CHAN_INFO_PROCESSED` | milli-lux integer             |

### Lux Conversion

| Mode   | Formula                   | Example                |
| ------ | ------------------------- | ---------------------- |
| H-res  | `mlux = raw * 10000 / 12` | raw=1000 → 833333 mlux |
| H-res2 | `mlux = raw * 10000 / 24` | raw=1000 → 416666 mlux |
| L-res  | `mlux = raw * 10000 / 12` | raw=1000 → 833333 mlux |

## BH1750 Commands Reference

| Command     | Byte   | Purpose                    |
| ----------- | ------ | -------------------------- |
| Power Down  | `0x00` | Enter sleep mode           |
| Power On    | `0x01` | Wake from sleep            |
| Reset       | `0x07` | Reset data register        |
| Cont H-res  | `0x10` | Continuous, 1 lx, 120 ms   |
| Cont H-res2 | `0x11` | Continuous, 0.5 lx, 120 ms |
| Cont L-res  | `0x13` | Continuous, 4 lx, 16 ms    |
| OT H-res    | `0x20` | One-time, 1 lx, 120 ms     |
| OT H-res2   | `0x21` | One-time, 0.5 lx, 120 ms   |
| OT L-res    | `0x23` | One-time, 4 lx, 16 ms      |

## Module Parameters

| Parameter    | Type   | Default | Permission | Description                              |
| ------------ | ------ | ------- | ---------- | ---------------------------------------- |
| `resolution` | `uint` | 0       | 0444       | 0=H-res 1lx, 1=H-res2 0.5lx, 2=L-res 4lx |

## Kbuild

```makefile
obj-m += bh1750.o
```
