package com.zhuravishkin.courses.demo.concurrency;

public class DeadlockExample {
    // Первый ресурс
    private static final Object resource1 = new Object();
    // Второй ресурс
    private static final Object resource2 = new Object();

    public static void main(String[] args) {
        // Поток 1 пытается захватить ресурс 1, затем ресурс 2
        Thread thread1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: Locked resource 1");
                try {
                    Thread.sleep(100); // Добавляем задержку для увеличения вероятности возникновения дедлока
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource2) {
                    System.out.println("Thread 1: Locked resource 2");
                }
            }
        });

        // Поток 2 пытается захватить ресурс 2, затем ресурс 1
        Thread thread2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: Locked resource 2");
                try {
                    Thread.sleep(100); // Добавляем задержку для увеличения вероятности возникновения дедлока
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource1) {
                    System.out.println("Thread 2: Locked resource 1");
                }
            }
        });

        // Запускаем оба потока
        thread1.start();
        thread2.start();
    }
}
