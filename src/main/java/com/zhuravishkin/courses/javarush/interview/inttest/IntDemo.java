package com.zhuravishkin.courses.javarush.interview.inttest;

public class IntDemo {
    public static void main(String[] args) {
        int a = 0;
        a = 5;
        int b = 2 * (a = 7);
        System.out.println(a);
        System.out.println(b);
    }
}
