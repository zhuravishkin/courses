package com.zhuravishkin.courses.leetcode.sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. Find All Anagrams in a String
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 * Анаграмма — это слово или фраза, полученная путём перестановки букв другого слова или фразы
 */
public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int start = 0;
        int end = 0;
        int size = p.length();
        char[] pattern = new char[26];
        char[] tmp = new char[26];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            pattern[p.charAt(i) - 'a']++;
        }

        for (; end < s.length(); end++) {
            if (end < size - 1) {
                tmp[s.charAt(end) - 'a']++;
            } else {
                tmp[s.charAt(end) - 'a']++;

                if (Arrays.equals(pattern, tmp)) {
                    result.add(start);
                }

                tmp[s.charAt(start) - 'a']--;
                start++;
            }
        }

        return result;
    }
}
