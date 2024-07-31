package com.zhuravishkin.courses.demo;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StreamCollectorsDemo {
    public static void main(String[] args) {
        String[] strings = {"a", "b", "c"};

        String collect = Arrays.stream(strings).collect(Collectors.joining(","));

        System.out.println(collect);
    }
}
