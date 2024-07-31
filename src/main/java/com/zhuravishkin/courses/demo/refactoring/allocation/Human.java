package com.zhuravishkin.courses.demo.refactoring.allocation;

import lombok.Builder;

public class Human {
    private String name;
    private Integer age;
    private Address address;

    public Human(String name, Integer age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getFullAddress() {
        return address.getFullAddress();
    }
}

@Builder
class Address {
    private String country;
    private String city;
    private String street;
    private String house;
    private String quarter;

    public String getFullAddress() {
        StringBuilder result = new StringBuilder();
        return result
                .append(country)
                .append(", ")
                .append(city)
                .append(", ")
                .append(street)
                .append(", ")
                .append(house)
                .append(" ")
                .append(quarter).toString();
    }
}
