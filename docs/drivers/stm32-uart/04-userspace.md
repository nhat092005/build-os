# Userspace: STM32 UART

## Library: libstm32

### API

```c
stm32_dev_t *stm32_open(const char *dev, int baud);
void         stm32_close(stm32_dev_t *d);

int stm32_ping(stm32_dev_t *d);
int stm32_get_version(stm32_dev_t *d, char *buf, size_t len);
int stm32_get_status(stm32_dev_t *d, struct stm32_status *s);
int stm32_reset(stm32_dev_t *d);
int stm32_set_gpio(stm32_dev_t *d, const struct stm32_gpio *g);
int stm32_get_gpio(stm32_dev_t *d, uint8_t pin, struct stm32_gpio *g);
int stm32_get_adc(stm32_dev_t *d, uint8_t ch, struct stm32_adc *a);
int stm32_set_pwm(stm32_dev_t *d, const struct stm32_pwm *p);
```

## CLI Tool: stm32-ctl

Command-line interface to the `libstm32` functions for easy scripting.

### Usage

```
stm32-ctl <device> <baud> <command> [args...]
```

### Commands

| Command    | Arguments              | Description                              |
| ---------- | ---------------------- | ---------------------------------------- |
| `ping`     | —                      | Checks if STM32 is responsive            |
| `version`  | —                      | Prints firmware version string           |
| `status`   | —                      | Prints MCU state, uptime, VCC, Temp      |
| `reset`    | —                      | Triggers soft reset on STM32             |
| `gpio-set` | `<pin> <in/out> <0/1>` | e.g. `gpio-set 5 out 1` (pin 5 out high) |
| `gpio-get` | `<pin>`                | e.g. `gpio-get 5` (read pin 5)           |
| `adc`      | `<channel>`            | Reads ADC channel                        |
| `pwm`      | `<ch> <freq> <duty>`   | Set PWM parameters                       |

### Examples

```bash
stm32-ctl /dev/ttyAMA0 115200 status
# Output:
#   state:    1
#   uptime:   2400 s
#   vcc:      3290 mV
#   mcu_temp: 42 C

# Set pin 10 as output, value high (1)
stm32-ctl /dev/ttyAMA0 115200 gpio-set 10 out 1
# Output: OK

# Read GPIO pin 5
stm32-ctl /dev/ttyAMA0 115200 gpio-get 5
# Output:
#   pin:       5
#   direction: output
#   value:     1

# Read ADC channel 1
stm32-ctl /dev/ttyAMA0 115200 adc 1
# Output:
#   channel:    1
#   raw:        2048
#   voltage_mv: 1650

# Configure PWM channel 2, 10kHz, 50% duty (5000/10000)
stm32-ctl /dev/ttyAMA0 115200 pwm 2 10000 5000
# Output: OK
```
