package com.zhuravishkin.courses.demo;

public class AmbiguousDemo {
    public void introduce(String name, String age) {
        System.out.println("Метод с двумя строками!");
        System.out.println("Меня зовут " + name + ", мой возраст - " + age);
    }

    public void introduce(String name, Integer age) {
        System.out.println("Метод со строкой и числом!");
        System.out.println("Меня зовут " + name + ", мой возраст - " + age);
    }

    public static void main(String[] args) {

        AmbiguousDemo victor = new AmbiguousDemo();
//        victor.introduce("Виктор", null);
        victor.introduce("Виктор", (String) null);
    }
}
