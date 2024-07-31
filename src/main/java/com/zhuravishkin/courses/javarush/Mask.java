package com.zhuravishkin.courses.javarush;

public class Mask {
    public static void main(String[] args) {
        int a = 15;
        System.out.println(Integer.toBinaryString(a) + " " + a);
        a &= ~(1 << 2);
        System.out.println(Integer.toBinaryString(a) + " " + a);
        int b = a & (1 << 1);
        System.out.println(Integer.toBinaryString(b) + " " + b);
        int c = a & (1 << 2);
        System.out.println(Integer.toBinaryString(c) + " " + c);
        int d = a & (1 << 3);
        System.out.println(Integer.toBinaryString(d) + " " + d);
    }
}
