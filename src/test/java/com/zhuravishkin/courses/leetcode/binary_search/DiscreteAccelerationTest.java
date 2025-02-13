package com.zhuravishkin.courses.leetcode.binary_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiscreteAccelerationTest {

    @Test
    void run1() {
        assertEquals(3.0, DiscreteAcceleration.run(10, new int[]{1, 9}));
    }

    @Test
    void run2() {
        assertEquals(3.666666666666667, DiscreteAcceleration.run(10, new int[]{1}));
    }

    @Test
    void run3() {
        assertEquals(2.047619047619048, DiscreteAcceleration.run(7, new int[]{1, 2, 3, 4, 6}));
    }

    @Test
    void run4() {
        assertEquals(329737645.750000000000000, DiscreteAcceleration.run(1000000000, new int[]{413470354, 982876160}));
    }

    @Test
    void run5() {
        assertEquals(53.700000000000000, DiscreteAcceleration.run(478, new int[]{1, 10, 25, 33, 239, 445, 453, 468, 477}));
    }

    @Test
    void run6() {
        assertEquals(5.0, DiscreteAcceleration.run(10, new int[]{}));
    }
}