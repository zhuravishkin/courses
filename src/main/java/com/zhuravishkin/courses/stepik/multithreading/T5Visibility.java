package com.zhuravishkin.courses.stepik.multithreading;

import lombok.ToString;

@ToString
public class T5Visibility {
    public static int value;

    public static void main(String[] args) throws InterruptedException {
        Thread reader = new Thread(() -> {
            int temp = 0;
            while (true) {
//                System.out.println("value read: " + value);
                if (temp != value) {
                    temp = value;
                    System.out.println("value = " + value);
                }
            }
        });
        reader.setDaemon(true);

        Thread writer = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                value++;
                System.out.println("value updated: " + value);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        reader.start();
        writer.start();
    }
}
