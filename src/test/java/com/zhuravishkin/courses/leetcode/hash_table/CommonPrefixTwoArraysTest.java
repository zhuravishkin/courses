package com.zhuravishkin.courses.leetcode.hash_table;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommonPrefixTwoArraysTest {

    @Test
    void findCommonPrefix1() {
        assertEquals(List.of(0, 1, 3, 3, 5), CommonPrefixTwoArrays.findCommonPrefix(List.of(2, 1, 3, 4, 5), List.of(3, 1, 2, 5, 4)));
    }

    @Test
    void findCommonPrefix2() {
        assertEquals(List.of(1, 2, 3), CommonPrefixTwoArrays.findCommonPrefix(List.of(1, 2, 3), List.of(1, 2, 3)));
    }
}