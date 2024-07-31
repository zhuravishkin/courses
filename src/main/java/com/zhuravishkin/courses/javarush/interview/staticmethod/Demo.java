package com.zhuravishkin.courses.javarush.interview.staticmethod;

public class Demo {
    public static void main(String[] args) {
        A a = new B();
        a.method1();
        a.method2();
        B b = new B();
        b.method1();
        b.method2();
    }
}
