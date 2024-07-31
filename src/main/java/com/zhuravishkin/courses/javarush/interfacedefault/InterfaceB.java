package com.zhuravishkin.courses.javarush.interfacedefault;

import java.util.Random;

public interface InterfaceB extends InterfaceA {
    double getDouble();

    default boolean getBoolean() {
        System.out.println(getPrivate());
        return new Random().nextBoolean();
    }

    private String getPrivate() {
        return "private";
    }
}
