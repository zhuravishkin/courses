package com.zhuravishkin.courses.demo.proxy;

public class Man implements Person {
    private final String name;
    private final int age;
    private final String city;
    private final String country;

    public Man(String name, int age, String city, String country) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.country = country;
    }

    @Override
    public void introduce() {
        System.out.println("Меня зовут " + this.name);
    }

    @Override
    public void sayAge(int age) {
        System.out.println("Мне " + this.age + " лет");
    }

    @Override
    public void sayFrom(String city, String country) {
        System.out.println("Я из города " + this.city + ", " + this.country);
    }
}
