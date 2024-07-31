package com.zhuravishkin.courses.javarush.interview.bytetest;

public class ByteDemo {
    public static void main(String[] args) {
        byte a1 = 10;
        byte a2 = (byte) -a1;
        System.out.println(a2);
        final byte b1 = 10;
        byte b2 = -b1;
        System.out.println(b2);
    }
}
