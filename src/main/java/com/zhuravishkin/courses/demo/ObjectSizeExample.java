package com.zhuravishkin.courses.demo;

import org.openjdk.jol.info.ClassLayout;

public class ObjectSizeExample {
    public static void main(String[] args) {
        Object object = new Object();
        System.out.println(ClassLayout.parseInstance(object).toPrintable());

        Long aLong = 1L;
        System.out.println(ClassLayout.parseInstance(aLong).toPrintable());
    }
}
