package com.zhuravishkin.courses.javarush;

public class CollingExtendsTest {
    public static void main(String[] args) {
        C c = new C();
    }

    static class A {
        public A() {
            System.out.println("Вызов конструктора A");
        }
    }

    static class B extends A {
        public B() {
            System.out.println("Вызов конструктора B");
        }
    }

    static class C extends B {
        public C() {
            System.out.println("Вызов конструктора C");
        }
    }
}
