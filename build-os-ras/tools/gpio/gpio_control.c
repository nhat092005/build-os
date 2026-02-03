/**
 * @file gpio_control.c
 */

/* Defines feature macro*/
#define _DEFAULT_SOURCE

/* Includes ------------------------------------------------------------------*/

#include "gpio_lib.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <signal.h>
#include <sys/types.h>
#include <fcntl.h>
#include <errno.h>

/* Defines -------------------------------------------------------------------*/

#define PIDFILE "/var/run/gpio_control.pid"

/* Private variables ---------------------------------------------------------*/

static volatile int running = 1;

/* Private function prototypes -----------------------------------------------*/

/**
 * @brief Print usage information
 *
 * @param prog Program name
 */
static void print_usage(const char *prog);

/**
 * @brief Signal handler for graceful termination
 *
 * @param sig Signal number
 */
static void signal_handler(int sig);

/**
 * @brief Daemonize process using double-fork technique
 *
 * @return 0 on success (daemon child), 1 if parent (should exit), -1 on error
 */
static int daemonize(void);

/**
 * @brief Write PID file
 *
 * @return 0 on success, -1 on error
 */
static int write_pidfile(void);

/**
 * @brief Remove PID file
 */
static void remove_pidfile(void);

/**
 * @brief Check if daemon is already running
 *
 * @return 1 if running, 0 if not
 */
static int pidfile_exists(void);

/* Main Function --------------------------------------------------------------*/

int main(int argc, char *argv[])
{
    // Register signal handlers
    signal(SIGINT, signal_handler);  // Ctrl+C
    signal(SIGTERM, signal_handler); // kill command

    // Check arguments
    if (argc < 3)
    {
        print_usage(argv[0]);
        return 1;
    }

    int gpio = atoi(argv[1]);
    const char *cmd = argv[2];

    printf("GPIO Control: BCM GPIO %d (System GPIO %d)\n",
           gpio, BCM_TO_SYS(gpio));

    // Execute commands
    if (strcmp(cmd, "export") == 0)
    {
        if (gpio_export(gpio) != 0)
        {
            fprintf(stderr, "Error exporting GPIO %d\n", gpio);
            return 1;
        }
        else
        {
            printf("GPIO %d exported\n", gpio);
        }
    }
    else if (strcmp(cmd, "unexport") == 0)
    {
        if (gpio_unexport(gpio) != 0)
        {
            fprintf(stderr, "Error unexporting GPIO %d\n", gpio);
            return 1;
        }
        else
        {
            printf("GPIO %d unexported\n", gpio);
        }
    }
    else if (strcmp(cmd, "direction") == 0)
    {
        if (!gpio_is_exported(gpio))
        {
            fprintf(stderr, "GPIO %d not initialized. Run init first.\n", gpio);
            return 1;
        }

        if (argc < 4)
        {
            fprintf(stderr, "Error: direction requires argument (in/out)\n");
            return 1;
        }

        gpio_direction_t dir = (strcmp(argv[3], "out") == 0)
                                   ? GPIO_DIRECTION_OUT
                                   : GPIO_DIRECTION_IN;

        if (gpio_set_direction(gpio, dir) == 0)
        {
            printf("GPIO %d direction set to %s\n",
                   gpio, (dir == GPIO_DIRECTION_OUT) ? "output" : "input");
        }
    }
    else if (strcmp(cmd, "init") == 0)
    {
        if (argc < 4)
        {
            fprintf(stderr, "Error: init requires direction (in/out)\n");
            return 1;
        }

        gpio_direction_t dir = (strcmp(argv[3], "out") == 0)
                                   ? GPIO_DIRECTION_OUT
                                   : GPIO_DIRECTION_IN;

        if (gpio_init(gpio, dir) != 0)
        {
            fprintf(stderr, "Error initializing GPIO %d as %s\n",
                    gpio, (dir == GPIO_DIRECTION_OUT) ? "output" : "input");
            return 1;
        }
        else
        {
            printf("GPIO %d initialized as %s\n",
                   gpio, (dir == GPIO_DIRECTION_OUT) ? "output" : "input");
        }
    }
    else if (strcmp(cmd, "set") == 0)
    {
        if (!gpio_is_exported(gpio))
        {
            fprintf(stderr, "GPIO %d not initialized. Run init first.\n", gpio);
            return 1;
        }

        if (gpio_get_direction(gpio) != GPIO_DIRECTION_OUT)
        {
            fprintf(stderr, "GPIO %d is not output\n", gpio);
            return 1;
        }

        if (argc < 4)
        {
            fprintf(stderr, "Error: set requires value (0/1)\n");
            return 1;
        }

        int value = atoi(argv[3]);
        if (gpio_write(gpio, value) != 0)
        {
            fprintf(stderr, "Error setting GPIO %d to %d\n", gpio, value);
            return 1;
        }
        else
        {
            printf("GPIO %d set to %d\n", gpio, value);
        }
    }
    else if (strcmp(cmd, "get") == 0)
    {
        if (!gpio_is_exported(gpio))
        {
            fprintf(stderr, "GPIO %d not initialized. Run init first.\n", gpio);
            return 1;
        }

        int value = gpio_read(gpio);
        if (value >= 0)
        {
            printf("GPIO %d value: %d (%s)\n",
                   gpio, value, value ? "HIGH" : "LOW");
        }
        else
        {
            fprintf(stderr, "Error reading GPIO %d\n", gpio);
            return 1;
        }
    }
    else if (strcmp(cmd, "toggle") == 0)
    {
        if (!gpio_is_exported(gpio))
        {
            fprintf(stderr, "GPIO %d not initialized. Run init first.\n", gpio);
            return 1;
        }

        if (gpio_get_direction(gpio) != GPIO_DIRECTION_OUT)
        {
            fprintf(stderr, "GPIO %d is not output\n", gpio);
            return 1;
        }

        if (gpio_toggle(gpio) == 0)
        {
            int value = gpio_read(gpio);
            printf("GPIO %d toggled to %d\n", gpio, value);
        }
    }
    else if (strcmp(cmd, "blink") == 0)
    {
        int times = (argc >= 4) ? atoi(argv[3]) : 10;
        int daemon_mode = 0;

        // Check for --daemon flag
        if (argc >= 5 && strcmp(argv[4], "--daemon") == 0)
        {
            // Check if daemon already running
            if (pidfile_exists())
            {
                return 1;
            }

            daemon_mode = 1;
            int ret = daemonize();

            if (ret < 0)
            {
                fprintf(stderr, "Failed to daemonize\n");
                return 1;
            }
            if (ret > 0)
            {
                // Parent process - just exit
                return 0;
            }

            // Daemon child - write PID file
            if (write_pidfile() < 0)
            {
                return 1;
            }
            // Child process continues below
        }

        if (daemon_mode)
        {
            if (gpio_init(gpio, GPIO_DIRECTION_OUT) != 0)
            {
                fprintf(stderr, "Error initializing GPIO %d as output\n", gpio);
                return 1;
            }
        }
        else
        {
            if (!gpio_is_exported(gpio))
            {
                fprintf(stderr, "GPIO %d not initialized. Run init first.\n", gpio);
                return 1;
            }

            if (gpio_get_direction(gpio) != GPIO_DIRECTION_OUT)
            {
                fprintf(stderr, "GPIO %d is not output\n", gpio);
                return 1;
            }
        }

        for (int i = 1; i <= times && running; i++)
        {
            if (!running)
            {
                break;
            }

            gpio_write(gpio, GPIO_HIGH);
            usleep(500000);

            gpio_write(gpio, GPIO_LOW);
            usleep(500000);
        }

        gpio_write(gpio, GPIO_LOW); // ensure LOW at end
        if (daemon_mode)
        {
            gpio_cleanup(gpio); // cleanup GPIO
            remove_pidfile();   // remove PID file
        }
    }

    else if (strcmp(cmd, "cleanup") == 0)
    {
        if (gpio_cleanup(gpio) == 0)
        {
            printf("GPIO %d cleaned up\n", gpio);
        }
    }
    else
    {
        fprintf(stderr, "Unknown command: %s\n", cmd);
        print_usage(argv[0]);
        return 1;
    }

    return 0;
}

/* Private functions ---------------------------------------------------------*/

void print_usage(const char *prog)
{
    printf("GPIO Control Utility\n");
    printf("Usage: %s <bcm_gpio> <command> [options]\n\n", prog);
    printf("Commands:\n");
    printf("  export                    Export GPIO pin\n");
    printf("  unexport                  Unexport GPIO pin\n");
    printf("  direction <in|out>        Set GPIO direction\n");
    printf("  init <in|out>             Initialize GPIO (export + direction)\n");
    printf("  set <0|1>                 Set GPIO value (output mode)\n");
    printf("  get                       Get GPIO value\n");
    printf("  toggle                    Toggle GPIO value\n");
    printf("  blink [times] [--daemon]  Blink GPIO (default: 10 times)\n");
    printf("  cleanup                   Set to 0 and unexport\n");
    printf("\n");
    printf("Examples:\n");
    printf("  %s 17 init out            # Initialize GPIO 17 as output\n", prog);
    printf("  %s 17 set 1               # Turn GPIO 17 ON\n", prog);
    printf("  %s 17 blink 20            # Blink GPIO 17 20 times (foreground)\n", prog);
    printf("  %s 17 blink 20 --daemon   # Blink in background\n", prog);
    printf("  %s 27 init in             # Initialize GPIO 27 as input\n", prog);
    printf("  %s 27 get                 # Read GPIO 27 value\n", prog);
    printf("  %s 17 cleanup             # Clean up GPIO 17\n", prog);
    printf("\n");
    printf("Note: Uses BCM GPIO numbering (physical pin 11 = GPIO 17)\n");
}

static void signal_handler(int sig)
{
    (void)sig;
    running = 0;
}

static int daemonize(void)
{
    pid_t pid, sid;

    // First fork - create child
    pid = fork();
    if (pid < 0)
    {
        perror("First fork failed");
        return -1;
    }

    if (pid > 0)
    {
        // Parent exits immediately (PID file will be written by daemon)
        printf("Check PID: cat %s\n", PIDFILE);
        printf("To stop: kill $(cat %s)\n", PIDFILE);
        return 1; // Parent should exit
    }

    // First child continues here
    // Create new session - detach from terminal
    sid = setsid();
    if (sid < 0)
    {
        perror("setsid failed");
        return -1;
    }

    // Ignore SIGHUP (terminal hangup)
    signal(SIGHUP, SIG_IGN);

    // Second fork - prevent reacquiring terminal
    pid = fork();
    if (pid < 0)
    {
        perror("Second fork failed");
        return -1;
    }

    if (pid > 0)
    {
        // First child exits (no zombie because parent already exited)
        exit(0);
    }

    // Grandchild continues as true daemon
    // Change working directory to root
    if (chdir("/") < 0)
    {
        perror("chdir failed");
        return -1;
    }

    // Close standard file descriptors
    close(STDIN_FILENO);
    close(STDOUT_FILENO);
    close(STDERR_FILENO);

    // Reopen to /dev/null
    open("/dev/null", O_RDONLY); // stdin
    open("/dev/null", O_WRONLY); // stdout
    open("/dev/null", O_WRONLY); // stderr

    return 0; // Daemon child continues
}

static int write_pidfile(void)
{
    FILE *f = fopen(PIDFILE, "w");
    if (!f)
    {
        perror("fopen pidfile");
        return -1;
    }

    fprintf(f, "%d\n", getpid());
    fclose(f);
    return 0;
}

static void remove_pidfile(void)
{
    unlink(PIDFILE);
}

static int pidfile_exists(void)
{
    FILE *f = fopen(PIDFILE, "r");
    if (!f)
    {
        return 0; // PID file does not exist
    }

    int pid;
    if (fscanf(f, "%d", &pid) != 1)
    {
        fclose(f);
        unlink(PIDFILE); // Invalid PID file, remove it
        return 0;
    }
    fclose(f);

    // Check if process is still running
    if (pid > 0 && kill(pid, 0) == 0)
    {
        fprintf(stderr, "Daemon already running (PID %d)\n", pid);
        fprintf(stderr, "To stop: kill %d\n", pid);
        return 1; // Daemon is running
    }

    // Process not running, remove stale PID file
    unlink(PIDFILE);
    return 0;
}
