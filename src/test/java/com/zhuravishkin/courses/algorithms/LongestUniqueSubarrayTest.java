package com.zhuravishkin.courses.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestUniqueSubarrayTest {

    @Test
    void run1() {
        assertEquals(0, LongestUniqueSubarray.run(new int[]{}));
    }

    @Test
    void run2() {
        assertEquals(1, LongestUniqueSubarray.run(new int[]{1}));
    }

    @Test
    void run3() {
        assertEquals(5, LongestUniqueSubarray.run(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    void run4() {
        assertEquals(4, LongestUniqueSubarray.run(new int[]{1, 2, 3, 4, 4, 5}));
    }

    @Test
    void run5() {
        assertEquals(4, LongestUniqueSubarray.run(new int[]{1, 2, 3, 4, 4}));
    }

    @Test
    void run6() {
        assertEquals(4, LongestUniqueSubarray.run(new int[]{1, 2, 3, 4, 2, 5}));
    }

    @Test
    void run7() {
        assertEquals(4, LongestUniqueSubarray.run(new int[]{1, 2, 3, 4, 2, 2, 5}));
    }

    @Test
    void run8() {
        assertEquals(4, LongestUniqueSubarray.run(new int[]{1, 2, 3, 4, 2, 5, 6}));
    }

    @Test
    void run9() {
        assertEquals(3, LongestUniqueSubarray.run(new int[]{1, 2, 3, 3, 2, 1}));
    }
}