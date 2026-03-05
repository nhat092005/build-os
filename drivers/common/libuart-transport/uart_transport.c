// SPDX-License-Identifier: GPL-2.0-or-later
/*
 * UART Transport Layer — Implementation
 *
 * Handles UART open/close, raw terminal configuration, frame assembly,
 * SOF synchronization, CRC verification, timeout, and retry logic.
 *
 * This file is the ONLY place that touches UART I/O and framing.
 * Protocol libs (libesp32, libstm32) call uart_transport_send_cmd()
 * and never deal with serial ports, CRC, or frame bytes directly.
 */

#include "uart_transport.h"

#include <errno.h>
#include <fcntl.h>
#include <stdarg.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/select.h>
#include <termios.h>
#include <time.h>
#include <unistd.h>

/**
 * uart_transport - Opaque transport handle
 * @int: file descriptor for UART device
 * @orig_tio: saved original terminal settings for restoration on close
 * @seq: next sequence number to use for outgoing frames
 * @verbose: if true, log debug messages to stderr
 */
struct uart_transport {
	int fd; /* UART file descriptor */
	struct termios orig_tio; /* saved terminal settings */
	uint8_t seq; /* next sequence number */
	bool verbose; /* debug logging to stderr */
};

/**
 * vlog() - Verbose logging helper
 * @t: transport handle
 * fmt: printf-style format string
 * ...: printf-style arguments
 * Only logs if t->verbose is true. Uses fprintf(stderr, ...).
 */
static void vlog(const uart_transport_t *t, const char *fmt, ...)
	__attribute__((format(printf, 2, 3)));

static void vlog(const uart_transport_t *t, const char *fmt, ...)
{
	if (!t->verbose)
		return;

	va_list ap;

	va_start(ap, fmt);
	fprintf(stderr, "[uart] ");
	vfprintf(stderr, fmt, ap);
	fprintf(stderr, "\n");
	va_end(ap);
}

/**
 * baud_to_speed() - Convert integer baud rate to termios speed constant
 */
static speed_t baud_to_speed(int baud)
{
	switch (baud) {
	case 9600:
		return B9600;
	case 19200:
		return B19200;
	case 38400:
		return B38400;
	case 57600:
		return B57600;
	case 115200:
		return B115200;
	case 230400:
		return B230400;
	case 460800:
		return B460800;
	case 500000:
		return B500000;
	case 576000:
		return B576000;
	case 921600:
		return B921600;
	case 1000000:
		return B1000000;
	default:
		return B0; /* invalid */
	}
}

/**
 * write_all() - Write exactly @len bytes, retrying on partial writes
 * @fd: file descriptor
 * @buf: data to write
 * @len: bytes to write
 * Returns 0 on success, -1 on error (errno set).
 */
static int write_all(int fd, const void *buf, size_t len)
{
	const uint8_t *p = buf;
	size_t remaining = len;

	while (remaining > 0) {
		ssize_t n = write(fd, p, remaining);

		if (n < 0) {
			if (errno == EINTR)
				continue;
			return -1;
		}
		p += n;
		remaining -= (size_t)n;
	}
	return 0;
}

/**
 * read_byte_timeout() - Read a single byte with timeout
 * @fd:         file descriptor
 * @out:        output byte
 * @timeout_ms: timeout in milliseconds
 *
 * Returns 0 on success, -1 on timeout or error.
 */
static int read_byte_timeout(int fd, uint8_t *out, int timeout_ms)
{
	fd_set rfds;
	struct timeval tv;

	FD_ZERO(&rfds);
	FD_SET(fd, &rfds);
	tv.tv_sec = timeout_ms / 1000;
	tv.tv_usec = (timeout_ms % 1000) * 1000L;

	int ret = select(fd + 1, &rfds, NULL, NULL, &tv);

	if (ret <= 0)
		return -1; /* timeout or error */

	ssize_t n = read(fd, out, 1);

	if (n != 1)
		return -1;

	return 0;
}

/**
 * read_exact_timeout() - Read exactly @len bytes with overall timeout
 * @fd:         file descriptor
 * @buf:        output buffer
 * @len:        bytes to read
 * @timeout_ms: overall timeout in milliseconds
 *
 * Returns 0 on success, -1 on timeout or error.
 */
static int read_exact_timeout(int fd, void *buf, size_t len, int timeout_ms)
{
	uint8_t *p = buf;
	size_t remaining = len;
	struct timespec start, now;

	clock_gettime(CLOCK_MONOTONIC, &start);

	while (remaining > 0) {
		clock_gettime(CLOCK_MONOTONIC, &now);
		int elapsed_ms = (int)((now.tv_sec - start.tv_sec) * 1000 +
				       (now.tv_nsec - start.tv_nsec) / 1000000);
		int left_ms = timeout_ms - elapsed_ms;

		if (left_ms <= 0)
			return -1;

		fd_set rfds;
		struct timeval tv;

		FD_ZERO(&rfds);
		FD_SET(fd, &rfds);
		tv.tv_sec = left_ms / 1000;
		tv.tv_usec = (left_ms % 1000) * 1000L;

		int ret = select(fd + 1, &rfds, NULL, NULL, &tv);

		if (ret < 0) {
			if (errno == EINTR)
				continue;
			return -1;
		}
		if (ret == 0)
			return -1; /* timeout */

		ssize_t n = read(fd, p, remaining);

		if (n < 0) {
			if (errno == EINTR)
				continue;
			return -1;
		}
		if (n == 0)
			return -1; /* EOF / device gone */

		p += n;
		remaining -= (size_t)n;
	}
	return 0;
}

/**
 * build_frame() - Assemble a frame into @out buffer
 * @out:         output buffer (must be >= UART_MAX_FRAME_SIZE)
 * @cmd:         command byte
 * @seq:         sequence number
 * @payload:     payload data (may be NULL)
 * @payload_len: payload length
 *
 * Returns total frame size including CRC.
 */
static size_t build_frame(uint8_t *out, uint8_t cmd, uint8_t seq,
			  const void *payload, uint16_t payload_len)
{
	size_t idx = 0;

	/* Header */
	out[idx++] = UART_SOF;
	out[idx++] = cmd;
	out[idx++] = (uint8_t)(payload_len & 0xFF); /* LEN low */
	out[idx++] = (uint8_t)((payload_len >> 8) & 0xFF); /* LEN high */
	out[idx++] = seq;

	/* Payload */
	if (payload_len > 0 && payload)
		memcpy(&out[idx], payload, payload_len);
	idx += payload_len;

	/* CRC over SOF→PAYLOAD */
	uint16_t crc = uart_crc16(out, idx);

	out[idx++] = (uint8_t)(crc & 0xFF); /* CRC low */
	out[idx++] = (uint8_t)((crc >> 8) & 0xFF); /* CRC high */

	return idx;
}

/**
 * recv_frame() - Receive a response frame with SOF sync
 * @t:            transport handle
 * @resp_cmd:     [out] command byte from response
 * @resp_seq:     [out] sequence number from response
 * @resp_payload: [out] payload buffer
 * @resp_len:     [in] buffer capacity; [out] actual payload length
 * @timeout_ms:   overall timeout
 *
 * Scans for SOF byte, reads header, reads payload, verifies CRC.
 *
 * Returns:
 *   UART_OK         on success
 *   UART_ERR_TIMEOUT on timeout
 *   UART_ERR_BADMSG  on CRC failure
 *   UART_ERR_IO      on read error
 */
static int recv_frame(uart_transport_t *t, uint8_t *resp_cmd, uint8_t *resp_seq,
		      void *resp_payload, uint16_t *resp_len, int timeout_ms)
{
	uint8_t sof;
	struct timespec start, now;

	clock_gettime(CLOCK_MONOTONIC, &start);

	/* Sync to SOF — discard garbage bytes until 0xAA found */
	for (;;) {
		clock_gettime(CLOCK_MONOTONIC, &now);
		int elapsed_ms = (int)((now.tv_sec - start.tv_sec) * 1000 +
				       (now.tv_nsec - start.tv_nsec) / 1000000);
		int left_ms = timeout_ms - elapsed_ms;

		if (left_ms <= 0) {
			vlog(t, "recv: timeout waiting for SOF");
			return UART_ERR_TIMEOUT;
		}

		if (read_byte_timeout(t->fd, &sof, left_ms) < 0) {
			vlog(t, "recv: timeout/error reading SOF byte");
			return UART_ERR_TIMEOUT;
		}

		if (sof == UART_SOF)
			break;

		vlog(t, "recv: discarding garbage byte 0x%02X", sof);
	}

	/* Read remaining header: CMD(1) + LEN(2) + SEQ(1) = 4 bytes */
	uint8_t hdr[4];

	clock_gettime(CLOCK_MONOTONIC, &now);
	int elapsed_ms = (int)((now.tv_sec - start.tv_sec) * 1000 +
			       (now.tv_nsec - start.tv_nsec) / 1000000);
	int left_ms = timeout_ms - elapsed_ms;

	if (left_ms <= 0 ||
	    read_exact_timeout(t->fd, hdr, sizeof(hdr), left_ms) < 0) {
		vlog(t, "recv: timeout reading header");
		return UART_ERR_TIMEOUT;
	}

	uint8_t cmd = hdr[0];
	uint16_t payload_len = (uint16_t)hdr[1] | ((uint16_t)hdr[2] << 8);
	uint8_t seq = hdr[3];

	if (payload_len > UART_MAX_PAYLOAD) {
		vlog(t, "recv: payload length %u exceeds max %u", payload_len,
		     UART_MAX_PAYLOAD);
		return UART_ERR_BADMSG;
	}

	/* Read payload + CRC */
	uint8_t tail[UART_MAX_PAYLOAD + UART_CRC_SIZE];
	size_t tail_len = payload_len + UART_CRC_SIZE;

	clock_gettime(CLOCK_MONOTONIC, &now);
	elapsed_ms = (int)((now.tv_sec - start.tv_sec) * 1000 +
			   (now.tv_nsec - start.tv_nsec) / 1000000);
	left_ms = timeout_ms - elapsed_ms;

	if (left_ms <= 0 ||
	    read_exact_timeout(t->fd, tail, tail_len, left_ms) < 0) {
		vlog(t, "recv: timeout reading payload+CRC");
		return UART_ERR_TIMEOUT;
	}

	/* Reconstruct full frame for CRC check */
	uint8_t frame[UART_MAX_FRAME_SIZE];
	size_t frame_len = 0;

	frame[frame_len++] = UART_SOF;
	memcpy(&frame[frame_len], hdr, sizeof(hdr));
	frame_len += sizeof(hdr);
	memcpy(&frame[frame_len], tail, payload_len);
	frame_len += payload_len;

	/* Verify CRC */
	uint16_t expected_crc = uart_crc16(frame, frame_len);
	uint16_t received_crc = (uint16_t)tail[payload_len] |
				((uint16_t)tail[payload_len + 1] << 8);

	if (expected_crc != received_crc) {
		vlog(t, "recv: CRC mismatch — expected 0x%04X, got 0x%04X",
		     expected_crc, received_crc);
		return UART_ERR_BADMSG;
	}

	/* Output */
	*resp_cmd = cmd;
	*resp_seq = seq;

	if (resp_payload && resp_len) {
		uint16_t copy_len = payload_len;

		if (copy_len > *resp_len)
			copy_len = *resp_len;
		memcpy(resp_payload, tail, copy_len);
		*resp_len = payload_len;
	} else if (resp_len) {
		*resp_len = payload_len;
	}

	vlog(t, "recv: cmd=0x%02X seq=%u len=%u CRC OK", cmd, seq, payload_len);
	return UART_OK;
}

uart_transport_t *uart_transport_open(const char *dev, int baud)
{
	if (!dev) {
		errno = EINVAL;
		return NULL;
	}

	speed_t speed = baud_to_speed(baud);

	if (speed == B0) {
		fprintf(stderr, "[uart] unsupported baud rate: %d\n", baud);
		errno = EINVAL;
		return NULL;
	}

	uart_transport_t *t = calloc(1, sizeof(*t));

	if (!t)
		return NULL;

	t->fd = -1;
	t->seq = 0;
	t->verbose = false;

	/* Open UART device */
	t->fd = open(dev, O_RDWR | O_NOCTTY | O_NONBLOCK);
	if (t->fd < 0) {
		fprintf(stderr, "[uart] failed to open %s: %s\n", dev,
			strerror(errno));
		goto err_free;
	}

	/* Clear O_NONBLOCK after open (we use select() for timeout) */
	int flags = fcntl(t->fd, F_GETFL, 0);

	if (flags < 0)
		goto err_close;
	if (fcntl(t->fd, F_SETFL, flags & ~O_NONBLOCK) < 0)
		goto err_close;

	/* Save original terminal settings */
	if (tcgetattr(t->fd, &t->orig_tio) < 0)
		goto err_close;

	/* Configure raw mode */
	struct termios tio;

	memset(&tio, 0, sizeof(tio));
	cfmakeraw(&tio);

	tio.c_cflag |= (CLOCAL | CREAD); /* enable receiver, ignore modem */
	tio.c_cflag &= ~CSIZE;
	tio.c_cflag |= CS8; /* 8 data bits */
	tio.c_cflag &= ~PARENB; /* no parity */
	tio.c_cflag &= ~CSTOPB; /* 1 stop bit */
	tio.c_cflag &= ~CRTSCTS; /* no HW flow control */

	tio.c_cc[VMIN] = 0; /* non-blocking reads */
	tio.c_cc[VTIME] = 0;

	cfsetispeed(&tio, speed);
	cfsetospeed(&tio, speed);

	/* Flush and apply */
	tcflush(t->fd, TCIOFLUSH);
	if (tcsetattr(t->fd, TCSANOW, &tio) < 0)
		goto err_close;

	return t;

err_close:
	close(t->fd);
err_free:
	free(t);
	return NULL;
}

void uart_transport_close(uart_transport_t *t)
{
	if (!t)
		return;

	if (t->fd >= 0) {
		/* Restore original terminal settings */
		tcsetattr(t->fd, TCSANOW, &t->orig_tio);
		close(t->fd);
	}
	free(t);
}

void uart_transport_set_verbose(uart_transport_t *t, bool verbose)
{
	if (t)
		t->verbose = verbose;
}

int uart_transport_send_cmd(uart_transport_t *t, uint8_t cmd,
			    const void *payload, uint16_t payload_len,
			    void *resp_buf, uint16_t *resp_len)
{
	if (!t)
		return UART_ERR_INVAL;
	if (payload_len > UART_MAX_PAYLOAD)
		return UART_ERR_INVAL;
	if (payload_len > 0 && !payload)
		return UART_ERR_INVAL;

	uint8_t frame[UART_MAX_FRAME_SIZE];
	uint8_t my_seq = t->seq++;
	size_t frame_len =
		build_frame(frame, cmd, my_seq, payload, payload_len);

	for (int attempt = 0; attempt < UART_MAX_RETRIES; attempt++) {
		if (attempt > 0) {
			vlog(t, "retry %d/%d for cmd=0x%02X seq=%u",
			     attempt + 1, UART_MAX_RETRIES, cmd, my_seq);
			/* Flush stale data before retry */
			tcflush(t->fd, TCIOFLUSH);
		}

		/* Send frame */
		vlog(t, "send: cmd=0x%02X seq=%u len=%u (%zu frame bytes)", cmd,
		     my_seq, payload_len, frame_len);

		if (write_all(t->fd, frame, frame_len) < 0) {
			vlog(t, "send: write failed: %s", strerror(errno));
			continue;
		}

		/* Wait for response */
		uint8_t resp_cmd, resp_seq;
		uint16_t rlen = resp_len ? *resp_len : 0;
		int ret = recv_frame(t, &resp_cmd, &resp_seq, resp_buf, &rlen,
				     UART_TIMEOUT_MS);

		if (ret == UART_ERR_TIMEOUT) {
			vlog(t, "recv: timeout (attempt %d/%d)", attempt + 1,
			     UART_MAX_RETRIES);
			continue;
		}

		if (ret == UART_ERR_BADMSG) {
			fprintf(stderr,
				"[uart] CRC error on response "
				"(attempt %d/%d)\n",
				attempt + 1, UART_MAX_RETRIES);
			continue;
		}

		if (ret != UART_OK)
			return ret;

		/* Verify sequence number match */
		if (resp_seq != my_seq) {
			vlog(t, "recv: SEQ mismatch — expected %u, got %u",
			     my_seq, resp_seq);
			fprintf(stderr,
				"[uart] SEQ mismatch: expected %u, "
				"got %u (attempt %d/%d)\n",
				my_seq, resp_seq, attempt + 1,
				UART_MAX_RETRIES);
			continue;
		}

		/* Success */
		if (resp_len)
			*resp_len = rlen;
		return UART_OK;
	}

	/* All retries exhausted — flush and return timeout */
	tcflush(t->fd, TCIOFLUSH);
	fprintf(stderr, "[uart] cmd 0x%02X failed after %d retries\n", cmd,
		UART_MAX_RETRIES);
	return UART_ERR_TIMEOUT;
}
