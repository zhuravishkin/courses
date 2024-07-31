package com.zhuravishkin.courses.demo;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ListToMapDemo {
    public static void main(String[] args) {
        List<String> strings = List.of("aaa", "b", "ccc", "d", "eee", "hh", "ii");
        TreeMap<Integer, List<String>> map = strings.stream().collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toList()));
        System.out.println(map);
    }
}
