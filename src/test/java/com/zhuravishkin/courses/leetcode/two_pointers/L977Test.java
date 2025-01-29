package com.zhuravishkin.courses.leetcode.two_pointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class L977Test {

    @Test
    void sortedSquares1() {
        assertArrayEquals(new int[]{0, 1, 9, 16, 100}, L977.sortedSquares(new int[]{-4, -1, 0, 3, 10}));
    }

    @Test
    void sortedSquares2() {
        assertArrayEquals(new int[]{4, 9, 9, 49, 121}, L977.sortedSquares(new int[]{-7, -3, 2, 3, 11}));
    }
}