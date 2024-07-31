package com.zhuravishkin.courses.javarush.multithreading;

public class NewThread implements Runnable {
    Thread thread;

    public NewThread() {
        thread = new Thread(this, "demo_thread");
        System.out.println("Demo thread created " + thread);
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 5; i > 0; i--) {
            System.out.println("Дочерний поток " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Дочерний поток завершён");
    }
}

class NewThreadDemo {
    public static void main(String[] args) {
        new NewThread();
        for (int i = 5; i > 0; i--) {
            System.out.println("Главный поток " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Главный поток завершён");
    }
}
