# Kernel Driver: GPIO Inputs

## Module Registration

```c
module_platform_driver(gpio_inputs_driver);
```

**Driver ID table:**

```c
static const struct of_device_id gpio_inputs_of_match[] = {
	{ .compatible = "bos,gpio-inputs" },
	{ }
};
```

## Private Data Structures

### Per-button state

```c
struct gpio_inputs_button {
	struct gpio_desc *desc;
	int irq;
	unsigned int code;
	bool active_low;
	bool sw_debounce;
	struct delayed_work debounce_work;
	struct input_dev *input;
};
```

### Driver-level state

```c
struct gpio_inputs_data {
	struct device *dev;
	struct input_dev *input;
	int num_buttons;
	struct gpio_inputs_button *buttons;
};
```

## probe()

1. `dev_info(dev, "Probing GPIO inputs driver v%s\n", "1.0.0")`
2. Count GPIOs: `gpiod_count(dev, NULL)`
3. Allocate `struct gpio_inputs_data` + button array (devm)
4. Allocate `devm_input_allocate_device()` — input device
5. Set capabilities: `set_bit(EV_KEY, input->evbit)`
6. For each button:
   a. `devm_gpiod_get_index(dev, NULL, i, GPIOD_IN)` — acquire GPIO
   b. `of_property_read_u32_index()` — get `linux,code` (e.g. BTN_0)
   c. `input_set_capability(input, EV_KEY, code)`
   d. `gpiod_to_irq(desc)` — get IRQ
   e. Try `gpiod_set_debounce(desc, 20000)` — 20ms hardware debounce
   f. If fails → `INIT_DELAYED_WORK()` for software debounce
   g. `devm_request_threaded_irq(RISING|FALLING|ONESHOT)`
7. `input_register_device(input)`

**Expected dmesg:**

```
gpio-inputs gpio-inputs: Probing GPIO inputs driver v1.0.0
gpio-inputs gpio-inputs: GPIO inputs driver registered with 1 button(s)
```

## remove()

```c
for (i = 0; i < data->num_buttons; i++) {
	if (data->buttons[i].sw_debounce)
		cancel_delayed_work_sync(&data->buttons[i].debounce_work);
}
```

## IRQ Flow

```
GPIO edge → IRQ handler (top half)
    │ returns IRQ_WAKE_THREAD
    ▼
IRQ thread (bottom half)
    ├─ HW debounce: gpio_inputs_report() → input_report_key + input_sync
    └─ SW debounce: schedule_delayed_work(&btn->debounce_work, 20ms)
                         └─► gpio_inputs_debounce_work()
                               └─► gpio_inputs_report()
```

## PM (Power Management)

- **Suspend:** Disables all button IRQs
- **Resume:** Re-enables IRQs, reads and reports current state for each button

## Kbuild

```makefile
obj-m += gpio_inputs.o
```
