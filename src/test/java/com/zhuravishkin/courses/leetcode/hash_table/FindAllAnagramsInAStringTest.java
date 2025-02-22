package com.zhuravishkin.courses.leetcode.hash_table;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindAllAnagramsInAStringTest {

    @Test
    void findAnagrams1() {
        assertEquals(List.of(0, 6), FindAllAnagramsInAString.findAnagrams("cbaebabacd", "abc"));
    }

    @Test
    void findAnagrams2() {
        assertEquals(List.of(0, 1, 2), FindAllAnagramsInAString.findAnagrams("abab", "ab"));
    }
}