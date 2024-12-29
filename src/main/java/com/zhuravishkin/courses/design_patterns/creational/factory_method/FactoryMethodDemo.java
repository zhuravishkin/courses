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
