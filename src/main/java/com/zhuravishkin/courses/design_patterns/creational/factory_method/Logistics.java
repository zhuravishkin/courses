package com.zhuravishkin.courses.design_patterns.creational.factory_method;

// Creator
public abstract class Logistics {
    // Фабричный метод
    public abstract Transport createTransport();

    public void planDelivery() {
        Transport transport = createTransport();
        transport.deliver();
    }
}
