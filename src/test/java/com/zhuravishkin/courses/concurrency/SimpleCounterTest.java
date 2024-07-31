package com.zhuravishkin.courses.concurrency;

import com.zhuravishkin.courses.demo.concurrency.counter.CorrectCounter;
import com.zhuravishkin.courses.demo.concurrency.counter.SimpleCounter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class SimpleCounterTest {

    @SneakyThrows
    @Test
    void testSimple() {
        SimpleCounter counter = new SimpleCounter();

        new Thread(() -> {
            long tmp = 0;
            while (true) {
                long current = counter.getCount();
                if (tmp != current) {
                    tmp = current;
                    log.info("reader: value = " + current);
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.increment();
                log.info("writer: changed to " + counter.getCount());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        Thread.sleep(1000);
    }

    @SneakyThrows
    @Test
    void testWithCountDownLatch() {
//        SimpleCounter counter = new SimpleCounter();
        CorrectCounter counter = new CorrectCounter();

        CountDownLatch latch = new CountDownLatch(1);
        int number = 1000;

        for (int i = 0; i < number; i++) {
            new Thread(() -> {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                counter.increment();
            }).start();
        }

        latch.countDown();
        Thread.sleep(1000);
        assertEquals(number, counter.getCount());
    }
}