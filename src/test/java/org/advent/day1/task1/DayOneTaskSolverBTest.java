package org.advent.day1.task1;

import org.advent.util.FileLoader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayOneTaskSolverBTest {

    @Test
    void shouldFindMax() {
        // given
        final var input = FileLoader.loadFile("/org/advent/day1/task1/day_1_test_input.txt");

        // when
        final var sumOfTop3 = DayOneTaskSolverB.findSumOfTop3(input);

        // then
        assertEquals(45000, sumOfTop3);
    }

}
