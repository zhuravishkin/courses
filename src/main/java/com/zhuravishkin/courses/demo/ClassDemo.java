package com.zhuravishkin.courses.demo;

import lombok.SneakyThrows;

public class ClassDemo {
    @SneakyThrows
    public static void main(String[] args) {
        Class<Integer> cl = int.class;
        System.out.println(cl);
        System.out.println(cl.getModule());
        System.out.println(cl.getPackageName());
        System.out.println(cl.isPrimitive());

        System.out.println();
        Class<?> str = Class.forName("java.lang.String");
        System.out.println(str.getCanonicalName());
    }
}
