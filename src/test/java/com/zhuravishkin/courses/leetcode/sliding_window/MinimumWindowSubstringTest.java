package com.zhuravishkin.courses.leetcode.sliding_window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumWindowSubstringTest {

    @Test
    void minWindow1() {
        assertEquals("BANC", MinimumWindowSubstring.minWindow("ADOBECODEBANC", "ABC"));
    }

    @Test
    void minWindow2() {
        assertEquals("a", MinimumWindowSubstring.minWindow("a", "a"));
    }

    @Test
    void minWindow3() {
        assertEquals("", MinimumWindowSubstring.minWindow("a", "aa"));
    }
}