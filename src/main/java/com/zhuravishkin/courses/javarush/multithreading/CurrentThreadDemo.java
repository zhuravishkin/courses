package com.zhuravishkin.courses.javarush.multithreading;

public class CurrentThreadDemo {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + " " + thread);
        thread.setName("Ibrahimovich");
        System.out.println(thread.getName() + " " + thread);
    }
}
