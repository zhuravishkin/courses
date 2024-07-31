package com.zhuravishkin.courses.javarush;

import java.util.List;
import java.util.stream.Collectors;

public class StreamAPITest {
    public static void main(String[] args) {
        List<User> users = List.of(new User("Sam", 30), new User("Dean", 32),
                new User("Cas", 20), new User("John", 25), new User(null, 29));
        System.out.println(users.stream()
                .filter(x -> x.getName() != null)
                .filter(x -> x.getAge() >= 30)
                .collect(Collectors.toList()));
    }

    static class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
