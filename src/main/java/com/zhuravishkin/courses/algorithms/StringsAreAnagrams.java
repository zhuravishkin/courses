package com.zhuravishkin.courses.algorithms;

/*
Являются ли строки анаграммами
*/

import java.util.HashMap;
import java.util.Map;

public class StringsAreAnagrams {
    public static void main(String[] args) {
        run("abcda", "badc");
    }

    public static boolean run(String a, String b) {
        char[] arrA = a.toCharArray();
        char[] arrB = b.toCharArray();

        Map<Character, Integer> mapA = mapFromArr(arrA);
        Map<Character, Integer> mapB = mapFromArr(arrB);

        System.out.println(mapA);
        System.out.println(mapB);

        return mapA.equals(mapB);
    }

    public static Map<Character, Integer> mapFromArr(char[] arr) {
        Map<Character, Integer> map = new HashMap<>();
        for (char n : arr) {
            if (map.containsKey(n)) {
                int count = map.get(n);
                map.put(n, ++count);
            } else {
                map.put(n, 1);
            }
        }

        return map;
    }
}
