package com.zhuravishkin.courses.leetcode.two_pointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class L349SortTest {

    @Test
    void intersection1() {
        assertArrayEquals(new int[]{2}, L349Sort.intersection(new int[]{1, 2, 3, 4}, new int[]{0, 2}));
    }

    @Test
    void intersection2() {
        assertArrayEquals(new int[]{4, 9}, L349Sort.intersection(new int[]{4, 5, 9}, new int[]{3, 4, 8, 9, 10}));
    }
}