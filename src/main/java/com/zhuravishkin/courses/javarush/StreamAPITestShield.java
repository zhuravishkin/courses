package com.zhuravishkin.courses.javarush;

import java.util.List;

public class StreamAPITestShield {
    public static void main(String[] args) {
        List<Double> list = List.of(4.0, 9.0, 16.0);

        double d = list.stream().reduce(1.0, (a, b) -> a * Math.sqrt(b));
        System.out.println(d);

        double e = list.parallelStream().reduce(1.0, (a, b) -> a * Math.sqrt(b));
        System.out.println(e);

        double f = list.parallelStream().reduce(1.0, (a, b) -> a * Math.sqrt(b), (a, b) -> a * b);
        System.out.println(f);
    }
}
