package com.zhuravishkin.courses.leetcode.hash_table;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HirschIndexTest {

    @Test
    void findHirschIndex1() {
        assertEquals(3, HirschIndex.findHirschIndex(List.of(10, 1, 8, 0, 3)));
    }

    @Test
    void findHirschIndex2() {
        assertEquals(2, HirschIndex.findHirschIndex(List.of(100, 200)));
    }
}