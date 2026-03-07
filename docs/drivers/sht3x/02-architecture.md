# Architecture: SHT3x

## System Diagram

```
┌─────────────────────────────────────────────────────────────┐
│ HARDWARE                                                    │
│ SHT3x @ 0x44 (I2C1)                                        │
│ Interface: I2C (2-byte commands, NOT SMBus registers)       │
└───────────────────────┬─────────────────────────────────────┘
                        │ i2c_master_send / i2c_master_recv
┌───────────────────────▼─────────────────────────────────────┐
│ KERNEL SPACE                                                │
│                                                             │
│ Device Tree (dts/sht3x-overlay.dts)                         │
│ └─► i2c_driver registration via module_i2c_driver()         │
│     │                                                       │
│     └─► probe()                                             │
│         ├─► devm_kzalloc() — allocate struct sht3x_data     │
│         ├─► devm_mutex_init() — serialize I2C access        │
│         ├─► soft reset (0x30 0xA2)                          │
│         ├─► start periodic mode (0x21 0x30, 1 Hz)           │
│         ├─► devm_hwmon_device_register_with_info()          │
│         └─► schedule_delayed_work() — periodic fetch        │
│                                                             │
│ Kernel Interface:                                           │
│   /sys/class/hwmon/hwmonX/temp1_input     ← temperature     │
│   /sys/class/hwmon/hwmonX/humidity1_input ← humidity        │
│   /sys/class/hwmon/hwmonX/heater_enable   ← heater control  │
└─────────────────────────────────────────────────────────────┘
```

## Design Decisions

### Why hwmon?

The SHT3x is a temperature and humidity sensor. The hwmon subsystem
provides a standard Linux interface for hardware monitoring with conventions
for temperature (`temp1_input` in milli-°C) and humidity (`humidity1_input`
in milli-%RH). This allows standard tools (lm-sensors, `sensors` command)
to work without custom userspace code.

### Why i2c_master_send/recv instead of SMBus?

The SHT3x uses 2-byte commands (MSB first), NOT standard SMBus registers.
The I2C protocol requires raw send/receive operations, incompatible with
the `i2c_smbus_read_byte_data()` register-based API.

### Resource management: devm\_\*

All resources use devm\_\* allocation:

- `devm_kzalloc()` — private data
- `devm_mutex_init()` — mutex
- `devm_hwmon_device_register_with_info()` — hwmon device

Probe failure at any point automatically frees all previously allocated
devm\_ resources. The only manual cleanup is in `remove()`: cancelling
`delayed_work` and sending heater disable / break commands to hardware.

### Concurrency model

- **Mutex** (`data->lock`): serializes all I2C transactions
- All file operations use `mutex_lock_interruptible()` (returns -ERESTARTSYS on signal)
- The periodic work handler (`sht3x_work_fn`) acquires the mutex before each fetch
- No spinlocks or atomic ops needed — all I2C operations can sleep

## Data Flow

### Read path (userspace → hardware)

```
userspace: cat /sys/class/hwmon/hwmonX/temp1_input
    │
    ▼ hwmon core calls sht3x_hwmon_read(hwmon_temp, hwmon_temp_input)
    │ 1. mutex_lock_interruptible(&data->lock)
    │ 2. if periodic mode active and cache fresh (<2s) → use cache
    │ 3. else: single-shot measurement:
    │    a. send 0x2C 0x06 (high repeatability, clock stretch)
    │    b. wait 20ms
    │    c. recv 6 bytes [temp_msb, temp_lsb, temp_crc, hum_msb, hum_lsb, hum_crc]
    │    d. CRC-8 verify each word (poly 0x31, init 0xFF)
    │    e. convert: T = -45000 + 175000 × raw / 65535 (milli-°C)
    │    f. convert: RH = 100000 × raw / 65535 (milli-%RH)
    │ 4. return data->temperature (long)
    │ 5. mutex_unlock
    ▼
userspace receives: milli-°C integer (e.g. "25340" = 25.34 °C)
```

### Heater control path

```
userspace: echo 1 > /sys/class/hwmon/hwmonX/heater_enable
    │
    ▼ sysfs core calls heater_enable_store()
    │ 1. kstrtobool(buf, &enable)
    │ 2. mutex_lock_interruptible(&data->lock)
    │ 3. send 0x30 0x6D (heater enable) or 0x30 0x66 (disable)
    │ 4. record heater_on_since = jiffies
    │ 5. mutex_unlock
    ▼
hardware heater state updated
```

## Kernel APIs Used

| Header              | APIs Used                                     | Purpose                |
| ------------------- | --------------------------------------------- | ---------------------- |
| `linux/module.h`    | `module_i2c_driver`, `MODULE_*`               | module lifecycle       |
| `linux/i2c.h`       | `i2c_master_send`, `i2c_master_recv`          | raw I2C communication  |
| `linux/hwmon.h`     | `devm_hwmon_device_register_with_info`        | hwmon registration     |
| `linux/mutex.h`     | `devm_mutex_init`, `mutex_lock_interruptible` | mutual exclusion       |
| `linux/delay.h`     | `fsleep`, `usleep_range`                      | measurement delays     |
| `linux/jiffies.h`   | `jiffies`, `time_before`, `time_after`        | cache freshness        |
| `linux/workqueue.h` | `INIT_DELAYED_WORK`, `schedule_delayed_work`  | periodic measurement   |
| `linux/kernel.h`    | `div_u64`, `container_of`                     | math, container access |

## Dependencies

| Dependency       | Where  | Why                                  |
| ---------------- | ------ | ------------------------------------ |
| `linux/i2c.h`    | kernel | I2C bus access (not SMBus)           |
| `linux/hwmon.h`  | kernel | Standard sensor monitoring interface |
| I2C1 bus enabled | DTS    | `dtparam=i2c_arm=on` required        |

## Limitations

| Limitation                    | Impact                             | Workaround                         |
| ----------------------------- | ---------------------------------- | ---------------------------------- |
| Single device per bus address | Only 1 SHT3x at 0x44 per I2C bus   | Use 0x45 for second device via DTS |
| No interrupt support          | Polling only (periodic or on-read) | Periodic mode reduces latency      |
| Heater safety                 | WARN_ON_ONCE if heater on >30s     | Automatic warning in work handler  |
| No userspace tool             | Must use sysfs directly            | `cat` / `sensors` command suffices |
