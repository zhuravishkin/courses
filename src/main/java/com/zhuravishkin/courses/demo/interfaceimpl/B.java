package com.zhuravishkin.courses.demo.interfaceimpl;

public interface B {
    default void foo() {
        System.out.println("B");
    }
}
