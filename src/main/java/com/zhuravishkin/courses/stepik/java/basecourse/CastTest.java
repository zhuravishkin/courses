package com.zhuravishkin.courses.stepik.java.basecourse;

public class CastTest {
    public static void main(String[] args) {
        Object a = new A();
        B b = (B) a;
    }

    static class A {
    }

    static class B {
    }
}
