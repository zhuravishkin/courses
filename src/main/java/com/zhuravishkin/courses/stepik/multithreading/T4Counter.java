package com.zhuravishkin.courses.stepik.multithreading;

import lombok.ToString;

@ToString
public class T4Counter {
    private int count = 0;

    private Object lock = new Object();

    public void increment() {
        synchronized (lock) {
            count++;
        }
    }

//    public void increment() {
//        count++;
//    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        T4Counter test = new T4Counter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                test.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                test.increment();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("count = " + test.getCount());
    }
}
