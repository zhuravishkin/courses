package com.zhuravishkin.courses.algorithms;

import com.zhuravishkin.courses.algorithms.interview.IsomorphicStrings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IsomorphicStringsTest {

    @Test
    void run1() {
        assertTrue(IsomorphicStrings.run("a", "b"));
    }

    @Test
    void run2() {
        assertTrue(IsomorphicStrings.run("egg", "add"));
    }

    @Test
    void run3() {
        assertTrue(IsomorphicStrings.run("paper", "title"));
    }

    @Test
    void run4() {
        assertTrue(IsomorphicStrings.run("title", "paper"));
    }

    @Test
    void run5() {
        assertFalse(IsomorphicStrings.run("foo", "bar"));
    }

    @Test
    void run6() {
        assertFalse(IsomorphicStrings.run("paper", "tidle"));
    }

    @Test
    void run7() {
        assertTrue(IsomorphicStrings.run("aaa", "aaa"));
    }

    @Test
    void run8() {
        assertTrue(IsomorphicStrings.run("", ""));
    }

    @Test
    void run9() {
        assertFalse(IsomorphicStrings.run("aab", "eeff"));
    }
}