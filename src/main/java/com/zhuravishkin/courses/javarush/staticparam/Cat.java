package com.zhuravishkin.courses.javarush.staticparam;

public class Cat {
    static int catCount;
    public String name;

    public Cat(String name) {
        this.name = name;
        catCount++;
    }
}
