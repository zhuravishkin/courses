package com.zhuravishkin.courses.javarush.interview.classtest;

public class ClassDemo {
    public static void main(String[] args) {
        System.out.println(ClassDemo.class.getModule());
        System.out.println(ClassDemo.class.getClassLoader());
    }
}
