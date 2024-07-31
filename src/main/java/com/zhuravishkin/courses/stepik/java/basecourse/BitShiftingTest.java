package com.zhuravishkin.courses.stepik.java.basecourse;

public class BitShiftingTest {
    public static void main(String[] args) {
        int a = 350;
        System.out.println(Integer.toBinaryString(a));
        int b = 2 << 3;
//        int b = (int) Math.pow(2, 4);
        System.out.println(Integer.toBinaryString(b));
        int c = a ^ b;
        System.out.println(Integer.toBinaryString(c));

        System.out.println();
        int d = -1;
        System.out.println(Integer.toBinaryString(d));
        d >>>= 7;
        System.out.println(Integer.toBinaryString(d));
        byte e = -1;
        System.out.println(Integer.toBinaryString(e));
        e >>>= 7;
        System.out.println(Integer.toBinaryString(e));

        System.out.println();
        char ch1 = '\\';
        char ch2 = 'a';
        int f = ch1;
        int g = ch2;
        System.out.println((char) (f + g));
    }
}
