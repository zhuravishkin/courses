package com.zhuravishkin.courses.javarush.interview.streamstest;

import java.util.List;

public class StreamApiDemo {
    public static void main(String[] args) {
        List<Integer> list = List.of(2, 5, 1, 7, 6);
        System.out.println("first - " + list.stream().findFirst().orElse(null));
        System.out.println("last - " + list.stream().reduce((integer, integer2) -> integer2).orElse(null));
        System.out.println("last - " + list.stream().peek(integer -> {}));
        Boolean a = null;
        boolean b = false;
        System.out.println(a && b);
    }
}
