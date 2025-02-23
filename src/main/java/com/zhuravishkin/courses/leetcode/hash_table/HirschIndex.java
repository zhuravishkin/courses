package com.zhuravishkin.courses.leetcode.hash_table;

import java.util.List;

/**
 * Индекс Хирша
 * Дан массив целых чисел citations, где citations[i] — число цитирований, полученных исследователем для его i-й статьи.
 * Нужно найти h-индекс исследователя.
 * h-индекс (индекс Хирша) определяется как максимальное значение h, при котором
 * данный исследователь опубликовал не менее h статей, каждая из которых была процитирована не менее h раз.
 * Constraints:
 * citations[i] >= 0
 * len(citations) >= 1
 */
public class HirschIndex {
    public static int findHirschIndex(List<Integer> citations) {
        int[] arr = new int[citations.size() + 1];
        for (int i : citations) {
            arr[Math.min(i, citations.size())]++;
        }
        int count = 0;
        for (int i = citations.size(); i > 0; i--) {
            count += arr[i];
            if (count >= i) {
                return i;
            }
        }
        return 0;
    }
}
