package com.zhuravishkin.courses.demo.concurrency;

import org.springframework.core.task.SimpleAsyncTaskExecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadDemo {
    public static void main(String[] args) {
        Executors executors;
        ThreadPoolExecutor threadPoolExecutor;
        SimpleAsyncTaskExecutor simpleAsyncTaskExecutor;
        ThreadLocalRandom threadLocalRandom;

        GridThreadSerialNumber serialNumber = new GridThreadSerialNumber();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                Integer value = serialNumber.get();
                System.out.print(value);
            }).start();
        }
    }
}
