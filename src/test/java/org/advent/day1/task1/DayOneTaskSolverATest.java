package org.advent.day1.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayOneTaskSolverATest {

    @Test
    void shouldFindMax() {
        // given
        final var input = "1\n2\n\n6\n\n5\n6\n7\n";

        // when
        final var calculatedMax = DayOneTaskSolverA.findMax(input);

        // then
        assertEquals(18, calculatedMax);
    }
}