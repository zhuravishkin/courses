package com.zhuravishkin.courses.demo;

public class ThreadUncaughtDemo {
    public static void main(String[] args) {
        Cat cat = new ThreadUncaughtDemo().new Cat();
        Thread thread = new Thread(cat);
        thread.setUncaughtExceptionHandler((t, e) -> {
            System.out.printf("UncaughtExceptionHandler start, %s, %s%n", t.getName(), e.getMessage());
        });
        try {
            thread.start();
            thread.join();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        System.out.println("Main thread finished");
    }

    class Cat implements Runnable {
        @Override
        public void run() {
            System.out.println("Cat run start");
            throw new RuntimeException("test exception");
        }
    }
}
