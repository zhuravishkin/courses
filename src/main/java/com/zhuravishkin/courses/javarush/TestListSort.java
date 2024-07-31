package com.zhuravishkin.courses.javarush;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestListSort {
    public static class Person {
        private String name;
        private int age;
        private int height;

        public Person(String name, int age, int height) {
            this.name = name;
            this.age = age;
            this.height = height;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public int getHeight() {
            return height;
        }
    }

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("Ivan", 20, 180));
        list.add(new Person("Igor", 25, 170));
        list.add(new Person("Fedor", 30, 160));
        list.add(new Person("Artem", 15, 150));
        list.add(new Person("Ilya", 7, 190));
        list.add(new Person("Alex", 50, 180));
        list.add(new Person("John", 30, 180));
        list.add(new Person("Jack", 30, 110));

        for (Person person : list) {
            System.out.println(person.name + " " + person.age + " " + person.height);
        }

        list.sort(Comparator.comparing(Person::getAge).reversed().thenComparing(Person::getHeight));

        System.out.println();
        for (Person person : list) {
            System.out.println(person.name + " " + person.age + " " + person.height);
        }
    }
}
