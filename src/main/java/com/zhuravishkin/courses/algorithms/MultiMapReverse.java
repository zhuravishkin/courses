package com.zhuravishkin.courses.algorithms;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MultiMapReverse {
    public static void main(String[] args) {
        Map<Integer, List<Long>> map = Map.of(1, List.of(0L, 1L, 2L), 2, List.of(3L, 4L));
        System.out.println(map);
        Map<Long, Integer> collect = map.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream().map(aLong -> Map.entry(aLong, entry.getKey())))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(collect);
    }
}
