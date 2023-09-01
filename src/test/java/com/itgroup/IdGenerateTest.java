package com.itgroup;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IdGenerateTest {
    private long lastTimestamp = -1L;
    private long sequence = 0L;
    private final long sequenceBits = 12L;
    private final long machineId = 1L; // example machineId
    private final long machineIdBits = 10L;
    private final long machineIdShift = sequenceBits;
    private final long timestampLeftShift = sequenceBits + machineIdBits;
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);


    private synchronized long nextId() {
        long timestamp = System.currentTimeMillis();

        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                while (timestamp <= lastTimestamp) {
                    timestamp = System.currentTimeMillis();
                }
            }
        } else {
            sequence = 0L;
        }

        lastTimestamp = timestamp;
        return ((timestamp << timestampLeftShift) | (machineId << machineIdShift) | sequence);
    }

    @Test
    void generateRandomId() {
        for (int i = 0; i < 5; i++) {
            System.out.println(nextId());
        }
    }
}
