package com.zhuravishkin.courses.algorithms;

import com.zhuravishkin.courses.algorithms.interview.LongestSequencesNumbers1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSequencesNumbers1Test {

    @Test
    void run1() {
        assertEquals(2, LongestSequencesNumbers1.run(new int[]{1, 1, 0, 0, 1, 1, 0}));
    }

    @Test
    void run2() {
        assertEquals(3, LongestSequencesNumbers1.run(new int[]{1, 1, 0, 0, 1, 1, 1}));
    }

    @Test
    void run3() {
        assertEquals(5, LongestSequencesNumbers1.run(new int[]{1, 1, 1, 1, 1}));
    }

    @Test
    void run4() {
        assertEquals(0, LongestSequencesNumbers1.run(new int[]{0, 0, 0, 0, 0}));
    }

    @Test
    void run5() {
        assertEquals(0, LongestSequencesNumbers1.run(new int[]{}));
    }
}