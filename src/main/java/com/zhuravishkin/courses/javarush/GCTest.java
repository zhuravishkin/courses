package com.zhuravishkin.courses.javarush;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GCTest {
    public static void main(String[] args) throws InterruptedException {
        Set<String> set = new HashSet<>();
        set.add("John");
        set.add("Sam");
        set.add("Dean");
        List<String> list = new ArrayList<>();
        for (String s : set) {
            list.add(s);
        }
        set = null;
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(1000);
            System.gc();
        }
        System.out.println(list);
    }
}
