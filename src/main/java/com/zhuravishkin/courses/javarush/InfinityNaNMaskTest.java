package com.zhuravishkin.courses.javarush;

public class InfinityNaNMaskTest {
    public static void main(String[] args) {
        System.out.println(Double.POSITIVE_INFINITY / 0);
        System.out.println(Double.NEGATIVE_INFINITY / 0);
        System.out.println(Double.POSITIVE_INFINITY * 0);
        System.out.println(Math.sqrt(-4));

        int a = 9;
        System.out.println(Integer.toBinaryString(a) + " " + a);
        a |= (1 << 2);
        System.out.println(Integer.toBinaryString(a) + " " + a);

        int b = 15;
        System.out.println(Integer.toBinaryString(b) + " " + b);
        b &= ~(1 << 2);
        System.out.println(Integer.toBinaryString(b) + " " + b);

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(0 / 0);
    }
}
