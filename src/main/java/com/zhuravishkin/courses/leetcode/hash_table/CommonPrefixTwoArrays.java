package com.zhuravishkin.courses.leetcode.hash_table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Общий префикс двух массивов
 * Даны два целочисленных массива nums1 и nums2 длины n. Оба массива содержат только числа от 1 до n включительно,
 * при этом каждое число обязательно встречается ровно один раз в каждом из массивов.
 * Нужно найти общий префиксный массив для nums1 и nums2.
 * Префиксный массив nums1 и nums2 — это массив nums3 такой, что nums3[i] равен количеству чисел,
 * которые присутствуют на индексе i или до него как в nums1, так и в nums2.
 * Constraints:
 * len(nums1) = len(nums2)
 * len(nums1), len(nums2) >= 1
 */
public class CommonPrefixTwoArrays {
    public static List<Integer> findCommonPrefix(List<Integer> nums1, List<Integer> nums2) {
        List<Integer> result = new ArrayList<>(nums1.size());
        Map<Integer, Integer> map = new HashMap<>();
        int common = 0;
        for (int i = 0; i < nums1.size(); i++) {
            map.put(nums1.get(i), map.getOrDefault(nums1.get(i), 0) + 1);
            if (map.get(nums1.get(i)) == 2) {
                common++;
            }
            map.put(nums2.get(i), map.getOrDefault(nums2.get(i), 0) + 1);
            if (map.get(nums2.get(i)) == 2) {
                common++;
            }
            result.add(common);
        }
        return result;
    }
}
