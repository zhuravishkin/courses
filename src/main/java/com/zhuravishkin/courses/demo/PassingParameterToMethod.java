package com.zhuravishkin.courses.demo;

public class PassingParameterToMethod {
    public static void main(String[] args) {
        int a = 1;
        Integer b = 5;
        User user = new User("Иван");
        process(a, b, user);
        System.out.println(a);
        System.out.println(b);
        System.out.println(user.getName());
    }

    private static void process(int a, Integer b, User user) {
        a++;
        b++;
        user.setName("John");
    }
}

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
