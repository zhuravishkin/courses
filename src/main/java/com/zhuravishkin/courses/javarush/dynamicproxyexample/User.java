package com.zhuravishkin.courses.javarush.dynamicproxyexample;

public class User implements IUser {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
