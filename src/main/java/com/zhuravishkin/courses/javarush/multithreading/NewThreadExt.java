package com.zhuravishkin.courses.javarush.multithreading;

public class NewThreadExt extends Thread {

    public NewThreadExt() {
        super("demo_thread");
        System.out.println("Дочерний поток " + this);
        start();
    }

    @Override
    public void run() {
        for (int i = 6; i > 0; i--) {
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

class NewThreadDemoExt {
    public static void main(String[] args) {
        new NewThreadExt();
        for (int i = 6; i > 0; i--) {
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
