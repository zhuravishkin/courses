package com.zhuravishkin.courses.stepik.multithreading;

public class T2PrintStatic {
    public static int value = 10;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> print());
        Thread t2 = new Thread(() -> print());

        t1.start();
        t1.join();

        t2.start();
        t2.join();
    }

    public static void print() {
        int i = 5;
        System.out.println(i);
        i += value;
        value = 20;
        System.out.println(i);
    }
}
