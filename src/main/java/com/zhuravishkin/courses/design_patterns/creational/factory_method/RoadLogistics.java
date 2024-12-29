package com.zhuravishkin.courses.design_patterns.creational.factory_method;

// ConcreteCreator
public class RoadLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}
