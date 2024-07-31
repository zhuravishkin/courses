package com.zhuravishkin.courses.demo;

import java.util.ArrayList;
import java.util.List;

public class ListReferenceDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);
        test(list);
        System.out.println(list);
    }

    public static void test(List<String> list) {
        list.add("d");
    }
}
