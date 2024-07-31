package com.zhuravishkin.courses.demo;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CountDownLatchDemo {
    @SneakyThrows
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        AtomicInteger count = new AtomicInteger();

        for (int i = 0; i < 20; i++) {
            executorService.submit(() -> {
                countDownLatch.countDown();
                try {
                    count.incrementAndGet();
                    TimeUnit.NANOSECONDS.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            });
        }

        countDownLatch.await();
        System.out.println(count);
        System.exit(0);
    }
}
