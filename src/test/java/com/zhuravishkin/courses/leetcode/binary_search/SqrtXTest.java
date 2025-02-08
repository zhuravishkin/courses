package com.zhuravishkin.courses.leetcode.binary_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SqrtXTest {

    @Test
    void mySqrt1() {
        assertEquals(2, SqrtX.mySqrt(4));
    }

    @Test
    void mySqrt2() {
        assertEquals(2, SqrtX.mySqrt(8));
    }

    @Test
    void mySqrt3() {
        assertEquals(1, SqrtX.mySqrt(1));
    }

    @Test
    void mySqrt4() {
        assertEquals(3, SqrtX.mySqrt(9));
    }

    @Test
    void mySqrt5() {
        assertEquals(0, SqrtX.mySqrt(0));
    }
}