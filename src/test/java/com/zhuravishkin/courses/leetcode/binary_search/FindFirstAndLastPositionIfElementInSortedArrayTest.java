package com.zhuravishkin.courses.leetcode.binary_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FindFirstAndLastPositionIfElementInSortedArrayTest {

    @Test
    void searchRange1() {
        assertArrayEquals(new int[]{3, 4}, FindFirstAndLastPositionIfElementInSortedArray.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }

    @Test
    void searchRange2() {
        assertArrayEquals(new int[]{-1, -1}, FindFirstAndLastPositionIfElementInSortedArray.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
    }

    @Test
    void searchRange3() {
        assertArrayEquals(new int[]{-1, -1}, FindFirstAndLastPositionIfElementInSortedArray.searchRange(new int[]{}, 0));
    }

    @Test
    void searchRange4() {
        assertArrayEquals(new int[]{0, 0}, FindFirstAndLastPositionIfElementInSortedArray.searchRange(new int[]{1}, 1));
    }

    @Test
    void searchRange5() {
        assertArrayEquals(new int[]{-1, -1}, FindFirstAndLastPositionIfElementInSortedArray.searchRange(new int[]{1}, 0));
    }

    @Test
    void searchRange6() {
        assertArrayEquals(new int[]{-1, -1}, FindFirstAndLastPositionIfElementInSortedArray.searchRange(new int[]{2, 2}, 3));
    }
}