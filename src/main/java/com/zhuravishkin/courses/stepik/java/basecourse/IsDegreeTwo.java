package com.zhuravishkin.courses.stepik.java.basecourse;

public class IsDegreeTwo {
    public static void main(String[] args) {
        int a = 16;
//        System.out.println(Integer.toBinaryString(a));
        System.out.println(String.format("%16s", Integer.toBinaryString(a)).replace(' ', '0'));
        System.out.println(Integer.bitCount(a));
    }
}
