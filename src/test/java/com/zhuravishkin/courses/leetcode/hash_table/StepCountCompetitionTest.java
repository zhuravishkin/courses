package com.zhuravishkin.courses.leetcode.hash_table;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StepCountCompetitionTest {

    @Test
    @Tag("только участник с id=1 участвовал в соревнованиях каждый день")
    void findCompetitionWinners1() {
        assertEquals(List.of(1), StepCountCompetition.findCompetitionWinners(List.of(
                List.of(List.of(1, 1000), List.of(2, 3500)),
                List.of(List.of(1, 1500)))));
    }

    @Test
    @Tag("все участники принимали участие каждый день, но только участник под номером 1 прошел больше всего шагов")
    void findCompetitionWinners2() {
        assertEquals(List.of(1), StepCountCompetition.findCompetitionWinners(List.of(
                List.of(List.of(2, 4000), List.of(1, 500), List.of(3, 2000)),
                List.of(List.of(1, 5000), List.of(3, 150), List.of(2, 1000)),
                List.of(List.of(2, 3420), List.of(1, 10_000), List.of(3, 12_850)))));
    }

    @Test
    void findCompetitionWinners3() {
        assertThat(List.of(3, 2)).containsExactlyInAnyOrderElementsOf(StepCountCompetition.findCompetitionWinners(List.of(
                List.of(List.of(2, 4000), List.of(1, 500), List.of(3, 2000)),
                List.of(List.of(1, 500), List.of(3, 4000), List.of(2, 2000)),
                List.of(List.of(2, 100), List.of(1, 500), List.of(3, 100)))));
    }
}