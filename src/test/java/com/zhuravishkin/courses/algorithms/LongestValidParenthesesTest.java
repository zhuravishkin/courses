package com.zhuravishkin.courses.algorithms;

import com.zhuravishkin.courses.algorithms.interview.LongestValidParentheses;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestValidParenthesesTest {

    @Test
    void run1() {
        assertEquals(2, LongestValidParentheses.run("(()"));
    }

    @Test
    void run2() {
        assertEquals(4, LongestValidParentheses.run(")()())"));
    }

    @Test
    void run3() {
        assertEquals(2, LongestValidParentheses.run("()"));
    }

    @Test
    void run4() {
        assertEquals(4, LongestValidParentheses.run("(())"));
    }

    @Test
    void run5() {
        assertEquals(6, LongestValidParentheses.run("((()))"));
    }

    @Test
    void run6() {
        assertEquals(6, LongestValidParentheses.run("()()()"));
    }

    @Test
    void run7() {
        assertEquals(6, LongestValidParentheses.run("()(())"));
    }

    @Test
    void run8() {
        assertEquals(8, LongestValidParentheses.run("(())(())"));
    }

    @Test
    void run9() {
        assertEquals(0, LongestValidParentheses.run("((("));
    }

    @Test
    void run10() {
        assertEquals(0, LongestValidParentheses.run(")))"));
    }

    @Test
    void run11() {
        assertEquals(0, LongestValidParentheses.run(""));
    }

    @Test
    void run12() {
        assertEquals(6, LongestValidParentheses.run("(())))((()))"));
    }
}