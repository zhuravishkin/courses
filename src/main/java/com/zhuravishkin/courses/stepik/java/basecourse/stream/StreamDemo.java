package com.zhuravishkin.courses.stepik.java.basecourse.stream;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        IntStream intStream = pseudoRandomStream(13);
        intStream
                .limit(10)
                .forEach(System.out::println);

        Stream<Integer> stream = Stream.of(2, 1, 5, 4, 7, 6, 9, 8);
        Comparator<Integer> comparator = Comparator.comparingInt(o -> o);
        BiConsumer<Integer, Integer> biConsumer = (integer, integer2) -> System.out.println(integer + ":" + integer2);
        findMinMax(stream, comparator, biConsumer);
    }

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, operand -> ((operand * operand) / 10) % 1000);
    }

    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<? extends T> list = stream.collect(Collectors.toList());
        list.sort(order);
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }
    }
}
