package com.zhuravishkin.courses.stepik.multithreading;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class T3Point {
    int x;
    int y;

    public static void main(String[] args) throws InterruptedException {
        T3Point p = new T3Point(0, 0);
        Thread t1 = new Thread(() -> {
            p.x = 100;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            p.y = 100;
        });
        Thread t2 = new Thread(() -> System.out.println(p));
        t1.start();
        t2.start();
    }
}
