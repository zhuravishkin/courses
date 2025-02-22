package com.zhuravishkin.courses.leetcode.hash_table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. Find All Anagrams in a String
 * Given two strings s and p, return an array of all the start indices of p's  anagrams in s.
 * You may return the answer in any order.
 * Constraints:
 * 1 <= s.length, p.length <= 3 * 104
 * s and p consist of lowercase English letters.
 */
public class FindAllAnagramsInAString {
    public static List<Integer> findAnagrams(String s, String p) {
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (int right = 0; right < s.length(); right++) {
            char tmpR = s.charAt(right);
            map.compute(tmpR, (k, v) -> map.getOrDefault(tmpR, 0) - 1);
            map.computeIfPresent(tmpR, (k, v) -> v == 0 ? null : v);
            if (right >= p.length()) {
                char tmpL = s.charAt(left);
                map.compute(tmpL, (k, v) -> map.getOrDefault(tmpL, 0) + 1);
                map.computeIfPresent(tmpL, (k, v) -> v == 0 ? null : v);
                left++;
            }
            if (map.isEmpty()) {
                result.add(left);
            }
        }
        return result;
    }
}
