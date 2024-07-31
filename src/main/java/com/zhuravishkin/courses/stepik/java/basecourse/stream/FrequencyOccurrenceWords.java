package com.zhuravishkin.courses.stepik.java.basecourse.stream;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FrequencyOccurrenceWords {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
//        Map<String, List<String>> collect = bufferedReader
//                .lines()
//                .flatMap(s -> Arrays.stream(s.split(" ")))
//                .collect(Collectors.groupingBy(Function.identity()));
        Map<String, Long> collect = bufferedReader.lines()
//                .flatMap(s -> Arrays.stream(s.split(" ")))
                .flatMap(s -> Stream.of(s.split("[\\p{Punct}\\s]+")))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);

        Map<String, Long> map = new LinkedHashMap<>();

        collect.entrySet().stream()
//                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed().thenComparing(Map.Entry::getKey))
                .forEachOrdered(entry -> map.put(entry.getKey(), entry.getValue()));
        System.out.println(map);

        map.keySet().stream()
                .limit(10)
                .forEach(System.out::println);
    }
}

// Мама мыла раму! мыла мыла раму!

// Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.
