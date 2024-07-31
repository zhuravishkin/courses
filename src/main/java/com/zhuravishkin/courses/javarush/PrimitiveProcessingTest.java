package com.zhuravishkin.courses.javarush;

import java.util.concurrent.ThreadLocalRandom;

public class PrimitiveProcessingTest {
    public static void main(String[] args) {
        long startA = System.nanoTime();
        int a = 10;
        System.out.println(System.nanoTime() - startA);
        long startB = System.nanoTime();
        int b = 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1;
        System.out.println(System.nanoTime() - startB);
        long startC = System.nanoTime();
        int c = 0;
        for (int i = 0; i < 11; i++) {
            c = i++;
        }
        System.out.println(System.nanoTime() - startC);
        long startD = System.nanoTime();
        int d = 0;
        do {
            d = ThreadLocalRandom.current().nextInt(0, 11);
        } while (d != 10);
        System.out.println(System.nanoTime() - startD);
    }
}
