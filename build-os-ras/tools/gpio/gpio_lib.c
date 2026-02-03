/**
 * @file gpio_lib.c
 */

/* Defines feature macro*/
#define _DEFAULT_SOURCE

/* Includes ------------------------------------------------------------------*/

#include "gpio_lib.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#include <errno.h>

/* Defines -------------------------------------------------------------------*/

#define SYSFS_GPIO_DIR "/sys/class/gpio"
#define BUFFER_MAX 64

/* Private Functions Prototypes ----------------------------------------------*/

/**
 * @brief Write a string to a file
 *
 * @param path File path
 * @param value String to write
 *
 * @return 0 on success, -1 on error
 */
static int write_file(const char *path, const char *value);

/**
 * @brief Read a string from a file
 *
 * @param path File path
 * @param buffer Buffer to store read string
 * @param size Size of the buffer
 *
 * @return Number of bytes read on success, -1 on error
 */
static int read_file(const char *path, char *buffer, size_t size);

/* Functions ------------------------------------------------------------------*/

int gpio_export(int bcm_gpio)
{
    char buffer[BUFFER_MAX];
    int sys_gpio = BCM_TO_SYS(bcm_gpio);

    snprintf(buffer, sizeof(buffer), "%d", sys_gpio);

    // Try to export (ignore error if already exported)
    int ret = write_file(SYSFS_GPIO_DIR "/export", buffer);
    if (ret == 0)
    {
        usleep(100000); // Wait 100ms for sysfs
    }

    return 0; // Always return success
}

int gpio_is_exported(int gpio)
{
    char path[BUFFER_MAX];
    snprintf(path, sizeof(path), SYSFS_GPIO_DIR "/gpio%d/direction", BCM_TO_SYS(gpio));

    int fd = open(path, O_RDONLY);
    if (fd < 0)
    {
        if (errno == ENOENT)
        {
            return 0; // Not exported
        }
        else
        {
            perror("open");
            return -1; // Error
        }
    }

    close(fd);
    return 1; // Exported
}

int gpio_unexport(int bcm_gpio)
{
    char buffer[BUFFER_MAX];
    int sys_gpio = BCM_TO_SYS(bcm_gpio);

    snprintf(buffer, sizeof(buffer), "%d", sys_gpio);
    return write_file(SYSFS_GPIO_DIR "/unexport", buffer);
}

int gpio_set_direction(int bcm_gpio, gpio_direction_t dir)
{
    char path[BUFFER_MAX];
    int sys_gpio = BCM_TO_SYS(bcm_gpio);

    snprintf(path, sizeof(path), SYSFS_GPIO_DIR "/gpio%d/direction", sys_gpio);

    if (dir == GPIO_DIRECTION_OUT)
    {
        return write_file(path, "out");
    }
    else
    {
        return write_file(path, "in");
    }
}

gpio_direction_t gpio_get_direction(int gpio)
{
    char path[BUFFER_MAX];
    char buffer[16];
    int sys_gpio = BCM_TO_SYS(gpio);

    snprintf(path, sizeof(path), SYSFS_GPIO_DIR "/gpio%d/direction", sys_gpio);

    if (read_file(path, buffer, sizeof(buffer)) < 0)
    {
        return -1;
    }

    if (strncmp(buffer, "out", 3) == 0)
    {
        return GPIO_DIRECTION_OUT;
    }
    else if (strncmp(buffer, "in", 2) == 0)
    {
        return GPIO_DIRECTION_IN;
    }
    else
    {
        return -1; // Unknown direction
    }
}

int gpio_write(int bcm_gpio, gpio_value_t value)
{
    char path[BUFFER_MAX];
    int sys_gpio = BCM_TO_SYS(bcm_gpio);

    snprintf(path, sizeof(path), SYSFS_GPIO_DIR "/gpio%d/value", sys_gpio);

    if (value == GPIO_HIGH)
    {
        return write_file(path, "1");
    }
    else
    {
        return write_file(path, "0");
    }
}

int gpio_read(int bcm_gpio)
{
    char path[BUFFER_MAX];
    char buffer[4];
    int sys_gpio = BCM_TO_SYS(bcm_gpio);

    snprintf(path, sizeof(path), SYSFS_GPIO_DIR "/gpio%d/value", sys_gpio);

    if (read_file(path, buffer, sizeof(buffer)) < 0)
    {
        return -1;
    }

    return (buffer[0] == '1') ? GPIO_HIGH : GPIO_LOW;
}

int gpio_toggle(int bcm_gpio)
{
    int current = gpio_read(bcm_gpio);
    if (current < 0)
    {
        return -1;
    }

    return gpio_write(bcm_gpio, !current);
}

int gpio_init(int bcm_gpio, gpio_direction_t dir)
{
    if (gpio_export(bcm_gpio) < 0)
    {
        return -1;
    }

    usleep(100000); // Wait for export

    if (gpio_set_direction(bcm_gpio, dir) < 0)
    {
        return -1;
    }

    return 0;
}

int gpio_cleanup(int bcm_gpio)
{
    gpio_write(bcm_gpio, GPIO_LOW);
    return gpio_unexport(bcm_gpio);
}

/* Private functions ---------------------------------------------------------*/

static int write_file(const char *path, const char *value)
{
    int fd = open(path, O_WRONLY);
    if (fd < 0)
    {
        perror(path);
        return -1;
    }

    ssize_t len = strlen(value);
    if (write(fd, value, len) != len)
    {
        perror("write");
        close(fd);
        return -1;
    }

    close(fd);
    return 0;
}

static int read_file(const char *path, char *buffer, size_t size)
{
    int fd = open(path, O_RDONLY);
    if (fd < 0)
    {
        perror(path);
        return -1;
    }

    ssize_t len = read(fd, buffer, size - 1);
    if (len < 0)
    {
        perror("read");
        close(fd);
        return -1;
    }

    buffer[len] = '\0';
    close(fd);
    return 0;
}