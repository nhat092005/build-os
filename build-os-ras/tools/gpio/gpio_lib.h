/**
 * @file gpio_lib.h
 */

#ifndef GPIO_LIB_H
#define GPIO_LIB_H

/* Defines -------------------------------------------------------------------*/

#define GPIO_BASE 512 // Base number for gpiochip512

// Convert BCM GPIO to system GPIO number
#define BCM_TO_SYS(bcm) (GPIO_BASE + (bcm))

/* Typedef -------------------------------------------------------------------*/

/**
 * @brief GPIO direction
 */
typedef enum
{
    GPIO_DIRECTION_IN,
    GPIO_DIRECTION_OUT
} gpio_direction_t;

/**
 * @brief GPIO value
 */
typedef enum
{
    GPIO_LOW = 0,
    GPIO_HIGH = 1
} gpio_value_t;

/* Functions Prototypes ------------------------------------------------------*/

/**
 * @brief Export GPIO pin for use
 * 
 * @param bcm_gpio BCM GPIO number (e.g., 17)
 * 
 * @return 0 on success, -1 on error
 */
int gpio_export(int bcm_gpio);

/** 
 * @brief Check if GPIO is already exported
 * 
 * @param gpio BCM GPIO number
 * 
 * @return 1 if exported, 0 if not, -1 on error
 */
int gpio_is_exported(int gpio);

/**
 * @brief Unexport GPIO pin (cleanup)
 * 
 * @param bcm_gpio BCM GPIO number
 * 
 * @return 0 on success, -1 on error
 */
int gpio_unexport(int bcm_gpio);

/**
 * @brief Set GPIO direction (input or output)
 * 
 * @param bcm_gpio BCM GPIO number
 * @param dir GPIO_DIRECTION_IN or GPIO_DIRECTION_OUT
 * 
 * @return 0 on success, -1 on error
 */
int gpio_set_direction(int bcm_gpio, gpio_direction_t dir);

/**
 * @brief Get GPIO direction
 * 
 * @param gpio BCM GPIO number
 * 
 * @return GPIO_DIRECTION_IN or GPIO_DIRECTION_OUT on success, -1 on error
 */
gpio_direction_t gpio_get_direction(int gpio);

/**
 * @brief Write value to GPIO (output mode)
 * 
 * @param bcm_gpio BCM GPIO number
 * @param value GPIO_HIGH or GPIO_LOW
 * 
 * @return 0 on success, -1 on error
 */
int gpio_write(int bcm_gpio, gpio_value_t value);

/**
 * @brief Read value from GPIO
 * 
 * @param bcm_gpio BCM GPIO number
 * 
 * @return GPIO_HIGH or GPIO_LOW on success, -1 on error
 */
int gpio_read(int bcm_gpio);

/**
 * @brief Toggle GPIO value
 * 
 * @param bcm_gpio BCM GPIO number
 * 
 * @return 0 on success, -1 on error
 */
int gpio_toggle(int bcm_gpio);

/**
 * @brief Initialize GPIO (export + set direction)
 * 
 * @param bcm_gpio BCM GPIO number
 * @param dir GPIO direction
 * 
 * @return 0 on success, -1 on error
 */
int gpio_init(int bcm_gpio, gpio_direction_t dir);

/**
 * @brief Cleanup GPIO (write 0 + unexport)
 * 
 * @param bcm_gpio BCM GPIO number
 * 
 * @return 0 on success, -1 on error
 */
int gpio_cleanup(int bcm_gpio);

#endif /* GPIO_LIB_H */