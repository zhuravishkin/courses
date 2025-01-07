package com.zhuravishkin.courses.design_patterns.creational.factory_method;

// Client
public class FactoryMethodDemo {
    public static void main(String[] args) {
        Logistics logistics;

        // Используем фабрику для грузоперевозок по дороге
        logistics = new RoadLogistics();
        logistics.planDelivery();

        // Используем фабрику для морских перевозок
        logistics = new SeaLogistics();
        logistics.planDelivery();
    }
}

// Product
interface Transport {
    void deliver();
}

// ConcreteProduct
class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering by land in a truck.");
    }
}

class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering by sea in a ship.");
    }
}

// Creator
abstract class Logistics {
    // Фабричный метод
    public abstract Transport createTransport();

    public void planDelivery() {
        Transport transport = createTransport();
        transport.deliver();
    }
}

// ConcreteCreator
class RoadLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Truck();
    }
}

class SeaLogistics extends Logistics {
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}
