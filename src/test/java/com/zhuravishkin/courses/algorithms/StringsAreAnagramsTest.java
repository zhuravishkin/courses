package com.zhuravishkin.courses.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StringsAreAnagramsTest {

    @Test
    void run1() {
        assertTrue(StringsAreAnagrams.run("abcd", "badc"));
    }

    @Test
    void run2() {
        assertFalse(StringsAreAnagrams.run("aabcd", "badc"));
    }

    @Test
    void run3() {
        assertFalse(StringsAreAnagrams.run("abcd", "bbadc"));
    }

    @Test
    void run4() {
        assertFalse(StringsAreAnagrams.run("abcd", "qwer"));
    }

    @Test
    void run5() {
        assertFalse(StringsAreAnagrams.run("abcd", "badcc"));
    }

    @Test
    void run6() {
        assertFalse(StringsAreAnagrams.run("abcdd", "badc"));
    }

    @Test
    void run7() {
        assertTrue(StringsAreAnagrams.run("aaa", "aaa"));
    }

    @Test
    void run8() {
        assertTrue(StringsAreAnagrams.run("", ""));
    }
}