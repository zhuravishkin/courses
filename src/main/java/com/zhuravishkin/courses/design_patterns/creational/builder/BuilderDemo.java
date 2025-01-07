package com.zhuravishkin.courses.design_patterns.creational.builder;

// Client
public class BuilderDemo {
    public static void main(String[] args) {
        Director director = new Director();

        // Строим спортивный автомобиль
        CarBuilder sportsCarBuilder = new SportsCarBuilder();
        director.setBuilder(sportsCarBuilder);
        Car sportsCar = director.constructCar();
        System.out.println(sportsCar);

        // Строим семейный автомобиль
        CarBuilder familyCarBuilder = new FamilyCarBuilder();
        director.setBuilder(familyCarBuilder);
        Car familyCar = director.constructCar();
        System.out.println(familyCar);
    }
}

// Product
class Car {
    private String engine;
    private int wheels;
    private boolean airbags;
    private String color;

    // Setters (используются Builder'ом)
    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public void setAirbags(boolean airbags) {
        this.airbags = airbags;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine='" + engine + '\'' +
                ", wheels=" + wheels +
                ", airbags=" + airbags +
                ", color='" + color + '\'' +
                '}';
    }
}

// Builder
interface CarBuilder {
    void buildEngine();

    void buildWheels();

    void buildAirbags();

    void paintCar();

    Car getCar();
}

// ConcreteBuilder
class SportsCarBuilder implements CarBuilder {
    private final Car car;

    public SportsCarBuilder() {
        this.car = new Car();
    }

    @Override
    public void buildEngine() {
        car.setEngine("V8 Engine");
    }

    @Override
    public void buildWheels() {
        car.setWheels(4);
    }

    @Override
    public void buildAirbags() {
        car.setAirbags(true);
    }

    @Override
    public void paintCar() {
        car.setColor("Red");
    }

    @Override
    public Car getCar() {
        return car;
    }
}

class FamilyCarBuilder implements CarBuilder {
    private final Car car;

    public FamilyCarBuilder() {
        this.car = new Car();
    }

    @Override
    public void buildEngine() {
        car.setEngine("Eco Engine");
    }

    @Override
    public void buildWheels() {
        car.setWheels(4);
    }

    @Override
    public void buildAirbags() {
        car.setAirbags(true);
    }

    @Override
    public void paintCar() {
        car.setColor("Blue");
    }

    @Override
    public Car getCar() {
        return car;
    }
}

// Director
class Director {
    private CarBuilder builder;

    public void setBuilder(CarBuilder builder) {
        this.builder = builder;
    }

    public Car constructCar() {
        builder.buildEngine();
        builder.buildWheels();
        builder.buildAirbags();
        builder.paintCar();

        return builder.getCar();
    }
}
