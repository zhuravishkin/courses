package com.zhuravishkin.courses.javarush;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class HashMapDemo {
    public static void main(String[] args) {
        Map<Integer, String[]> map = Map.of(
                1, new String[]{"a", "1"},
                2, new String[]{"b", "2"}
        );
        map.forEach((integer, strings) -> System.out.println(Arrays.deepToString(strings)));

        Map<String, String[]> hashMap = new HashMap<>();
        String a = "79336661111,https://yandex.ru";
        String b = "79336661111,https://www.google.ru";
        String c = "79336661111,https://www.youtube.com";
        Stream.of(a, b, c)
                .map(s -> s.split(","))
                .forEach(strings -> hashMap.put(strings[0], hashMap.get(strings[0]) == null ? strings : getArray(hashMap.get(strings[0]), strings)));
        hashMap.forEach((integer, strings) -> System.out.println(Arrays.deepToString(strings)));
    }

    public static String[] getArray(String[] previous, String[] current) {
        previous[1] = previous[1] + ";" + current[1];
        return previous;
    }
}
