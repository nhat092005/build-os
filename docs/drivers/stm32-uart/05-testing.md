# Testing: STM32 UART

## Build Verification

```bash
make tools TOOLS=stm32-uart

file drivers/stm32-uart/build/tools/stm32-ctl
# Expected: ELF 64-bit LSB executable, ARM aarch64
```

## Functional Tests

### Test: connection and ping

```bash
stm32-ctl /dev/ttyAMA0 115200 ping
# Expected: PING OK
```

### Test: hardware sensors

```bash
stm32-ctl /dev/ttyAMA0 115200 status
# Expected: Valid VCC (around 3300 mV) and realistic MCU temperature
```

### Test: ADC reporting

```bash
stm32-ctl /dev/ttyAMA0 115200 adc 0
# Expected: ADC channel 0 reading. If GND is connected, raw ~ 0.
```

## Error Cases

| Scenario              | Expected behavior                     |
| --------------------- | ------------------------------------- |
| Device absent         | `uart_send_cmd` timeout after retries |
| Hardware disconnected | CRC failures or framing errors        |
| Invalid parameters    | Command line tool rejects input       |
