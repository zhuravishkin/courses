package com.zhuravishkin.courses.algorithms.interview;

/*
Дан массив целых чисел, необходимо найти длину максимального непрерывного подмассива без повторяющихся элементов
sliding window
*/

import java.util.HashSet;
import java.util.Set;

public class LongestUniqueSubarray {
    public static void main(String[] args) {
        System.out.println(run(new int[]{1, 2, 3, 4, 2, 5, 6}));
    }

    public static int run(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int right = 0;
        int left = 0;
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            right++;
            if (!set.contains(arr[i])) {
                set.add(arr[i]);
                max = Math.max(max, right - left);
            } else {
                left = i;
            }
        }

        return max;
    }
}
