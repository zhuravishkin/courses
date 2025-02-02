package com.zhuravishkin.courses.leetcode.sliding_window;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class FindAllAnagramsInAStringTest {

    @Test
    void findAnagrams1() {
        assertIterableEquals(List.of(0, 6), FindAllAnagramsInAString.findAnagrams("cbaebabacd", "abc"));
    }

    @Test
    void findAnagrams2() {
        assertIterableEquals(List.of(0, 1, 2), FindAllAnagramsInAString.findAnagrams("abab", "ab"));
    }
}