package com.zhuravishkin.courses.javarush.multithreading;

public class SuspendResume {
    public static void main(String args[]) {
        NewThreadState ob1 = new NewThreadState("One");
        System.out.println("New State - " + ob1.t.getState());

        // Start the threads.
        ob1.t.start();
        System.out.println("Start State - " + ob1.t.getState());

        try {
            Thread.sleep(1000);
            ob1.mysuspend();
            System.out.println("Suspend State - " + ob1.t.getState());
            System.out.println("Suspending thread One");
            Thread.sleep(1000);
            ob1.myresume();
            System.out.println("Resume State - " + ob1.t.getState());
            System.out.println("Resume State - " + ob1.t.getState());
            System.out.println("Resuming thread One");
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }

        // wait for threads to finish
        try {
            System.out.println("Waiting for threads to finish.");
            ob1.t.join();
            System.out.println("State - " + ob1.t.getState());
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }

        System.out.println("Main thread exiting.");
    }
}

class NewThreadState implements Runnable {
    String name; // name of thread
    Thread t;
    boolean suspendFlag;

    NewThreadState(String threadname) {
        name = threadname;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        suspendFlag = false;
    }

    // This is the entry point for thread.
    public void run() {
        try {
            for (int i = 10; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(200);
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(name + " interrupted.");
        }
        System.out.println(name + " exiting.");
    }

    synchronized void mysuspend() {
        suspendFlag = true;
    }

    synchronized void myresume() {
        suspendFlag = false;
        System.out.println("Before notify State - " + t.getState());
        notify();
        System.out.println("After notify State - " + t.getState());
    }
}
