# Kernel Driver: SHT3x

## Module Registration

```c
module_i2c_driver(sht3x_driver);
```

This registers the driver with the I2C subsystem.
The kernel calls `probe()` when a matching device is found in DTS.

**Driver ID tables:**

```c
static const struct of_device_id sht3x_of_match[] = {
	{ .compatible = "sensirion,sht3x" },
	{ }
};

static const struct i2c_device_id sht3x_id[] = {
	{ "sht3x", 0 },
	{ }
};
```

## Private Data Structure

```c
struct sht3x_data {
	struct i2c_client *client;
	struct mutex lock;
	struct delayed_work work;
	s32 temperature;
	s32 humidity;
	unsigned long last_update;
	bool valid;
	bool heater_enabled;
	unsigned long heater_on_since;
	bool periodic_running;
};
```

| Field              | Type                  | Purpose                               |
| ------------------ | --------------------- | ------------------------------------- |
| `client`           | `struct i2c_client *` | I2C client handle                     |
| `lock`             | `struct mutex`        | serializes all I2C transactions       |
| `work`             | `struct delayed_work` | periodic measurement work (1 Hz)      |
| `temperature`      | `s32`                 | cached temperature in milli-°C        |
| `humidity`         | `s32`                 | cached humidity in milli-%RH          |
| `last_update`      | `unsigned long`       | jiffies timestamp of last measurement |
| `valid`            | `bool`                | true if cached data is valid          |
| `heater_enabled`   | `bool`                | current heater state                  |
| `heater_on_since`  | `unsigned long`       | jiffies when heater was last enabled  |
| `periodic_running` | `bool`                | true if periodic mode is active       |

## probe()

**Called when:** kernel finds DTS node with `compatible = "sensirion,sht3x"`

**Step-by-step:**

1. `dev_info(dev, "Probing SHT3x driver v%s\n", "1.0.0")` — log start
2. `i2c_check_functionality(I2C_FUNC_I2C)` — verify adapter supports raw I2C
3. `devm_kzalloc()` — allocate `struct sht3x_data`, managed by device lifetime
4. `i2c_set_clientdata(client, data)` — store private data
5. `devm_mutex_init(dev, &data->lock)` — initialize mutex (kernel-managed)
6. Soft reset: send `0x30 0xA2`, wait 1 ms — bring sensor to known state
7. Start periodic mode: send `0x21 0x30` (1 MPS, high repeatability)
8. `devm_hwmon_device_register_with_info()` — register with hwmon subsystem
9. `INIT_DELAYED_WORK()` + `schedule_delayed_work()` — periodic data fetch
10. `dev_info(dev, "SHT3x sensor registered at 0x%02x\n", client->addr)`

**Error handling:**

- Any `devm_*` failure → return error code, kernel frees previous allocations
- Soft reset failure → hard error, return immediately
- Periodic mode failure → warning only, fallback to single-shot

**Expected dmesg on success:**

```
sht3x 1-0044: Probing SHT3x driver v1.0.0
sht3x 1-0044: SHT3x sensor registered at 0x44
```

## remove()

```c
static void sht3x_remove(struct i2c_client *client)
{
	struct sht3x_data *data = i2c_get_clientdata(client);

	if (data->periodic_running)
		cancel_delayed_work_sync(&data->work);

	mutex_lock(&data->lock);
	if (data->heater_enabled) {
		sht3x_send_cmd(data, 0x30, 0x66); /* disable heater */
		data->heater_enabled = false;
	}
	if (data->periodic_running)
		sht3x_send_cmd(data, 0x30, 0x93); /* break: stop periodic */
	mutex_unlock(&data->lock);

	dev_info(&client->dev, "SHT3x sensor removed\n");
}
```

Manual cleanup in remove():

- Cancel delayed work (`cancel_delayed_work_sync`)
- Disable heater if left on (`0x30 0x66`)
- Stop periodic measurement on sensor (`0x30 0x93` break command)
- hwmon device unregistered automatically (devm\_)

## Core Functions

### `sht3x_crc8()`

**Purpose:** Compute CRC-8 over sensor data for integrity verification
**Called from:** `sht3x_parse_measurement()`

Algorithm: Sensirion CRC-8 — polynomial 0x31, init 0xFF.
Applied to each 2-byte word (temperature and humidity separately).

### `sht3x_send_cmd()`

**Purpose:** Send a 2-byte I2C command to the sensor
**Called from:** measurement, heater control, reset functions

Uses `i2c_master_send()` with up to 3 retries (1ms delay between).
Caller MUST hold `data->lock`.

### `sht3x_read_data()`

**Purpose:** Read 6 bytes of measurement data from sensor
**Called from:** `sht3x_measure_single_shot()`, `sht3x_fetch_periodic()`

Format: `[temp_MSB, temp_LSB, temp_CRC, hum_MSB, hum_LSB, hum_CRC]`
Uses `i2c_master_recv()` with retry logic.

### `sht3x_parse_measurement()`

**Purpose:** CRC-check and convert raw sensor data
**Called from:** single-shot and periodic measurement paths

Conversion (from SHT3x datasheet):

- Temperature: `T [m°C] = -45000 + 175000 × raw / 65535`
- Humidity: `RH [m%RH] = 100000 × raw / 65535`

Uses `div_u64()` for 64-bit intermediate to avoid overflow.

### `sht3x_measure_single_shot()`

**Purpose:** Trigger one-time measurement
**Called from:** `sht3x_read_measurement()` (fallback when periodic cache stale)

Sends `0x2C 0x06` (high repeatability, clock stretching), waits 20 ms,
reads 6 bytes, parses result.

### `sht3x_work_fn()`

**Purpose:** Periodic measurement work handler (runs every 1 second)
**Called from:** workqueue (scheduled by `schedule_delayed_work`)

Fetches periodic data (`0xE0 0x00`), updates cache, reschedules.
Also checks heater safety: `WARN_ON_ONCE` if heater enabled > 30 seconds.

## hwmon Interface

### Channel configuration

```c
static const struct hwmon_channel_info * const sht3x_info[] = {
	HWMON_CHANNEL_INFO(temp, HWMON_T_INPUT | HWMON_T_LABEL),
	HWMON_CHANNEL_INFO(humidity, HWMON_H_INPUT | HWMON_H_LABEL),
	NULL
};
```

| Attribute         | Type  | Permission | Content                 |
| ----------------- | ----- | ---------- | ----------------------- |
| `temp1_input`     | hwmon | 0444       | temperature in milli-°C |
| `temp1_label`     | hwmon | 0444       | "SHT3x Temperature"     |
| `humidity1_input` | hwmon | 0444       | humidity in milli-%RH   |
| `humidity1_label` | hwmon | 0444       | "SHT3x Humidity"        |

### sysfs attributes (custom)

```c
static DEVICE_ATTR_RW(heater_enable);
```

| Attribute       | Permission | Read returns | Write accepts |
| --------------- | ---------- | ------------ | ------------- |
| `heater_enable` | 0644       | "0" or "1"   | "0" or "1"    |

## I2C Commands Reference

| Command               | Bytes       | Purpose                       |
| --------------------- | ----------- | ----------------------------- |
| Single-shot (high CS) | `0x2C 0x06` | One-time measurement, 20 ms   |
| Periodic 1 MPS high   | `0x21 0x30` | Start continuous mode         |
| Fetch data            | `0xE0 0x00` | Read data from periodic mode  |
| Heater enable         | `0x30 0x6D` | Turn on internal heater       |
| Heater disable        | `0x30 0x66` | Turn off internal heater      |
| Soft reset            | `0x30 0xA2` | Reset sensor to default state |
| Break                 | `0x30 0x93` | Stop periodic measurement     |
| Read status           | `0xF3 0x2D` | Read status register          |

## Kbuild

```makefile
obj-m += sht3x.o
```
