package com.zhuravishkin.courses.leetcode.two_pointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class L283Test {

    @Test
    void intersection1() {
        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, L283.moveZeroes(new int[]{0, 1, 0, 3, 12}));
    }

    @Test
    void intersection2() {
        assertArrayEquals(new int[]{0}, L283.moveZeroes(new int[]{0}));
    }

    @Test
    void intersection3() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 0, 0}, L283.moveZeroes(new int[]{1, 0, 2, 3, 0, 4}));
    }
}