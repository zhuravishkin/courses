package com.zhuravishkin.courses.demo;

import lombok.Data;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Data
public class Test {
    public static void main(String[] args) {
        String name;
        Object object;
        List<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        List<String> list2 = list;
        list2.remove("b");
        System.out.println(list);
        System.out.println(list2);
        Map<String, String> map = new HashMap<>();

//        Object[] objects = new String[2];
//        objects[0] = "test";
////        objects[1] = 1;
//        for (int i = 0; i < objects.length; i++) {
//            System.out.println(objects[i]);
//        }
//
//        String[] strings = new String[0];
//        strings[0] = "test";

//        int a = 150;
//        byte b = (byte) a;
//        System.out.println(b);
//        System.out.println(Integer.toBinaryString(150));

//        RuntimeException runtimeException = new RuntimeException();
//        out.println("hello");
//        throw runtimeException;
    }
}
