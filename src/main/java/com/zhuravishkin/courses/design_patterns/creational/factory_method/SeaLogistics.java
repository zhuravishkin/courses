package com.zhuravishkin.courses.design_patterns.creational.factory_method;

// ConcreteCreator
public class SeaLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
