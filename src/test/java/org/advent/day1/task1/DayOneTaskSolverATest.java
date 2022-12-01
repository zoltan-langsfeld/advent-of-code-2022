package org.advent.day1.task1;

import org.advent.util.FileLoader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayOneTaskSolverATest {

    @Test
    void shouldFindMax() {
        // given
        final var input = FileLoader.loadFile("/org/advent/day1/task1/day_1_test_input.txt");

        // when
        final var calculatedMax = DayOneTaskSolverA.findMax(input);

        // then
        assertEquals(24000, calculatedMax);
    }
}