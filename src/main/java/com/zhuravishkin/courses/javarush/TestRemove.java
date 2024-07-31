package com.zhuravishkin.courses.javarush;

import java.util.ArrayList;
import java.util.List;

public class TestRemove {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(5);
        integers.add(1);
        integers.add(11);
        integers.add(7);
        integers.add(6);

        for (Integer integer : integers) {
            if (integer > 10) {
                integers.remove(integer);
            }
        }

        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
