package com.zhuravishkin.courses.demo.interfaceimpl;

public class InterfaceDemo implements A, B {
    @Override
    public void foo() {
        A.super.foo();
    }
}
