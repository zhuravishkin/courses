package com.zhuravishkin.courses.demo;

public abstract class AbstractClassDemo {
    private int date;

    public AbstractClassDemo(int date) {
        this.date = date;
    }

    public int getDate() {
        return date;
    }

    public static void main(String[] args) {
        AbstractClassDemo demo = new AbstractClassDemo(1990) {
        };
        System.out.println(demo.getDate());
    }
}
