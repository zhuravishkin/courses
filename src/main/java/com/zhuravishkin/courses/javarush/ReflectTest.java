package com.zhuravishkin.courses.javarush;

import java.lang.reflect.Method;

public class ReflectTest {
    public static void main(String[] args) {
        A a = new A();
        Class<?> c = a.getClass();
        Method[] methods = c.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i].getModifiers());
            System.out.println(methods[i]);
        }
    }

    public static class A {
        void o() {
        }

        public void m() {
        }

        private void n() {
        }
    }
}
