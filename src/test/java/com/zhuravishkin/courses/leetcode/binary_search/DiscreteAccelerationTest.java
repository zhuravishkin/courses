package com.zhuravishkin.courses.leetcode.binary_search;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertLinesMatch;

class DiscreteAccelerationTest {

    @Test
    void stringMatching1() {
        assertLinesMatch(List.of("as", "hero"), DiscreteAcceleration.stringMatching(new String[]{"mass", "as", "hero", "superhero"}));
    }

    @Test
    void stringMatching2() {
        assertLinesMatch(List.of("et", "code"), DiscreteAcceleration.stringMatching(new String[]{"leetcode", "et", "code"}));
    }

    @Test
    void stringMatching3() {
        assertLinesMatch(List.of(), DiscreteAcceleration.stringMatching(new String[]{"blue", "green", "bu"}));
    }
}