package com.zhuravishkin.courses.codewars.kata7;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArraysTest {
    public static void main(String[] args) {
        int[][] array = new int[][]{{10, 17}, {200, 207}, {10, 17}};
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i][0] + ":" + array[i][1]);
        }
        System.out.println(Arrays.equals(array[0], array[2]));
        int[] arr = Arrays.stream(array)
                .flatMapToInt(x -> IntStream.rangeClosed(x[0], x[1]))
                .distinct()
                .toArray();
        System.out.println(Arrays.deepToString(new int[][]{arr}));
        long count = Arrays.stream(array)
                .flatMapToInt(x -> IntStream.rangeClosed(x[0], x[1]))
                .distinct()
                .count();
        System.out.println(count);
    }
}
