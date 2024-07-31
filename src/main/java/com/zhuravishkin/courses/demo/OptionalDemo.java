package com.zhuravishkin.courses.demo;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> optional;
        optional = Optional.of("hello");
//        optional = Optional.empty();
        optional.ifPresent(System.out::println);
        System.out.println(optional.orElse("bar"));
    }
}
