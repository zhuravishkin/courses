package com.zhuravishkin.courses.javarush;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1, "John");
        concurrentHashMap.put(2, "Neo");
        concurrentHashMap.put(3, "Morpheus");

        for (Integer key : concurrentHashMap.keySet()) {
            if (key == 2) {
                concurrentHashMap.remove(key);
            }
        }

        System.out.println(concurrentHashMap);

        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "John");
        hashMap.put(2, "Neo");
        hashMap.put(3, "Morpheus");

        for (Integer key : hashMap.keySet()) {
            if (key == 2) {
                hashMap.remove(key);
            }
        }

        System.out.println(hashMap);
    }
}
