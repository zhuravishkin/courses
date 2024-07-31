package com.zhuravishkin.courses.demo.interfaceimpl;

public interface A {
    default void foo() {
        System.out.println("A");
    }
}
