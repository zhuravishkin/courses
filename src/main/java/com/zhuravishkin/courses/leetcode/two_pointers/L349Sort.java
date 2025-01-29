package com.zhuravishkin.courses.leetcode.two_pointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Найти пересечение двух отсортированных массивов ИЛИ, другими словами, для двух отсортированных массивов найти все элементы, которые встречаются в обоих массивах
 */
public class L349Sort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{1, 2, 2, 4}, new int[]{-2, 2})));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        int first = 0;
        int second = 0;
        Set<Integer> result = new HashSet<>();
        while (first < nums1.length && second < nums2.length) {
            int el1 = nums1[first];
            int el2 = nums2[second];
            if (el1 == el2) {
                result.add(el1);
                first++;
                second++;
            } else if (el1 < el2) {
                first++;
            } else {
                second++;
            }
        }

        return result.stream().mapToInt(a -> a).toArray();
    }
}
