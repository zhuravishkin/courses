package com.zhuravishkin.courses.demo.local;

import java.util.ArrayList;
import java.util.List;

public class Car {
    public static void main(String[] args) {
        Car car = new Car();
        List<Car> policeCar = car.createPoliceCar(5);
        policeCar.forEach(System.out::println);
    }

    public List<Car> createPoliceCar(int count) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            final int number = i;
            cars.add(new Car() {
                int policeNumber;

                {
                    policeNumber = number;
                }

                @Override
                public String toString() {
                    return "police car - " + ++policeNumber;
                }
            });
        }
        return cars;
    }
}
