package com.zhuravishkin.courses.design_patterns.creational.factory_method;

// ConcreteProduct
public class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering by ship");
    }
}
