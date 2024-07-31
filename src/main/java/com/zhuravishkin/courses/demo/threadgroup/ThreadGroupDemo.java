package com.zhuravishkin.courses.demo.threadgroup;

public class ThreadGroupDemo {
    public static void main(String[] args) {
        TestThread thread = new TestThread();

        ThreadGroup threadGroupA = new ThreadGroup("threadGroupA");
        ThreadGroup threadGroupB = new ThreadGroup("threadGroupB");

        Thread thread1 = new Thread(thread, "thread1");
        Thread thread2 = new Thread(threadGroupA, thread, "thread2");
        Thread thread3 = new Thread(threadGroupB, thread, "thread3");

        thread1.start();
        thread2.start();
        thread3.start();

        System.out.println(Thread.currentThread().getThreadGroup() + ":" +
                Thread.currentThread().getName() + ":" +
                Thread.currentThread().getPriority());
    }
}
