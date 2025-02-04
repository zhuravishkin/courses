package com.zhuravishkin.courses.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class IntersectionOfTwoArraysTest {

    @Test
    void intersection1() {
        assertArrayEquals(new int[]{2}, IntersectionOfTwoArrays.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
    }

    @Test
    void intersection2() {
        assertArrayEquals(new int[]{4, 9}, IntersectionOfTwoArrays.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));
    }
}