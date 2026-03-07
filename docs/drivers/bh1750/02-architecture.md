# Architecture: BH1750

## System Diagram

```
┌─────────────────────────────────────────────────────────────┐
│ HARDWARE                                                    │
│ BH1750FVI @ 0x23 (I2C1)                                     │
│ Interface: I2C (single-byte commands)                       │
└───────────────────────┬─────────────────────────────────────┘
                        │ i2c_master_send / i2c_master_recv
┌───────────────────────▼─────────────────────────────────────┐
│ KERNEL SPACE                                                │
│                                                             │
│ Device Tree (dts/bh1750-overlay.dts)                        │
│ └─► i2c_driver registration via module_i2c_driver()         │
│     │                                                       │
│     └─► probe()                                             │
│         ├─► devm_iio_device_alloc() — allocate IIO device   │
│         ├─► devm_mutex_init()                               │
│         ├─► power on (cmd 0x01)                             │
│         ├─► start continuous mode                           │
│         ├─► devm_iio_device_register()                      │
│         ├─► schedule_delayed_work() — periodic read         │
│         └─► devm_pm_runtime_enable() — runtime PM           │
│                                                             │
│ Kernel Interface (IIO):                                     │
│   /sys/bus/iio/devices/iio:deviceX/                         │
│     in_illuminance_raw        ← raw ADC value               │
│     in_illuminance_scale      ← scale factor                │
│     in_illuminance_input      ← processed lux (milli-lux)   │
└─────────────────────────────────────────────────────────────┘
```

## Design Decisions

### Why IIO?

The BH1750 is an ambient light sensor. The IIO subsystem provides standard
`in_illuminance_*` channels, enabling tools like `iio_readdev` and
automatic integration with the IIO buffered data path. Raw + scale +
processed channels give userspace choice of precision vs. convenience.

### Resource management: devm\_\*

- `devm_iio_device_alloc()` — IIO device + private data
- `devm_mutex_init()` — mutex
- `devm_iio_device_register()` — IIO device
- `devm_pm_runtime_enable()` — runtime PM

### Concurrency model

- **Mutex** (`data->lock`): serializes all I2C transactions
- `mutex_lock_interruptible()` in all IIO read callbacks
- Periodic work handler acquires mutex before each read
- Runtime PM integrates with work cancel/restart

### Runtime Power Management

The driver implements `pm_runtime_suspend` / `pm_runtime_resume`:

- **Suspend**: cancels periodic work, sends power-down command (0x00)
- **Resume**: sends power-on (0x01), waits 10 ms, restarts continuous mode
- Autosuspend delay: 2000 ms

## Data Flow

### Read path (userspace → hardware)

```
userspace: cat .../in_illuminance_input
    │
    ▼ IIO core calls bh1750_read_raw(IIO_CHAN_INFO_PROCESSED)
    │ 1. pm_runtime_resume_and_get()
    │ 2. mutex_lock_interruptible(&data->lock)
    │ 3. if continuous mode and cache fresh (<1s) → use cache
    │ 4. else: one-time measurement:
    │    a. send measurement cmd (0x20 H-res, 0x21 H2, 0x23 L-res)
    │    b. wait (180 ms H-res, 24 ms L-res)
    │    c. recv 2 bytes (big-endian raw ADC)
    │ 5. convert: mlux = raw * 10000 / 12 (H-res) or / 24 (H2)
    │ 6. mutex_unlock
    │ 7. pm_runtime_put_autosuspend()
    ▼
userspace receives: milli-lux integer
```

## Kernel APIs Used

| Header                      | APIs Used                                           | Purpose            |
| --------------------------- | --------------------------------------------------- | ------------------ |
| `linux/module.h`            | `module_i2c_driver`, `MODULE_*`                     | module lifecycle   |
| `linux/i2c.h`               | `i2c_master_send`, `i2c_master_recv`                | I2C communication  |
| `linux/iio/iio.h`           | `devm_iio_device_alloc`, `devm_iio_device_register` | IIO registration   |
| `linux/mutex.h`             | `devm_mutex_init`, `mutex_lock_interruptible`       | mutual exclusion   |
| `linux/delay.h`             | `fsleep`                                            | measurement delays |
| `linux/pm_runtime.h`        | `devm_pm_runtime_enable`, `pm_runtime_*`            | power management   |
| `linux/workqueue.h`         | `INIT_DELAYED_WORK`, `schedule_delayed_work`        | periodic polling   |
| `linux/byteorder/generic.h` | `be16_to_cpu`                                       | endian conversion  |

## Resolution Modes

| Mode   | Command (OT) | Command (Cont) | Resolution | Meas. Time | Poll Interval |
| ------ | ------------ | -------------- | ---------- | ---------- | ------------- |
| H-res  | 0x20         | 0x10           | 1 lx       | 180 ms     | 200 ms        |
| H-res2 | 0x21         | 0x11           | 0.5 lx     | 180 ms     | 200 ms        |
| L-res  | 0x23         | 0x13           | 4 lx       | 24 ms      | 50 ms         |

Selected via `module_param(resolution, uint, 0444)`: 0=H, 1=H2, 2=L.

## Limitations

| Limitation                    | Impact                            | Workaround                         |
| ----------------------------- | --------------------------------- | ---------------------------------- |
| Single device per bus address | Only 1 BH1750 at 0x23 per I2C bus | Use 0x5C for second device via DTS |
| No interrupt support          | Polling only                      | Continuous mode reduces latency    |
| No userspace tool             | Must use IIO sysfs directly       | `cat` or `iio_readdev`             |
