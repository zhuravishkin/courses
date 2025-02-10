package com.zhuravishkin.courses.leetcode.binary_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {

    @Test
    void search1() {
        assertEquals(4, BinarySearch.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }

    @Test
    void search2() {
        assertEquals(-1, BinarySearch.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }
}