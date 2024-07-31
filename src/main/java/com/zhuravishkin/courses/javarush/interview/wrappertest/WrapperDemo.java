package com.zhuravishkin.courses.javarush.interview.wrappertest;

public class WrapperDemo {
    public static void main(String[] args) {
        System.out.println(Float.BYTES);
        System.out.println(Double.BYTES);
        System.out.println(Float.floatToIntBits(1F));
        System.out.println(Integer.divideUnsigned(2, 2));
        System.out.println(Integer.remainderUnsigned(5, 2));
        System.out.println(Integer.toBinaryString(5));
        System.out.println(Integer.highestOneBit(5));
        System.out.println(Integer.lowestOneBit(5));
        System.out.println(Integer.numberOfLeadingZeros(5));
        System.out.println(Integer.numberOfTrailingZeros(5));
        System.out.println(Character.charCount(65535));
        System.out.println(Character.charCount(65536));
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
        Runtime.getRuntime().gc();
        System.out.println(Runtime.version());
        System.out.println(System.getenv().keySet());
        System.out.println(System.getProperties());
        System.runFinalization();
    }
}
