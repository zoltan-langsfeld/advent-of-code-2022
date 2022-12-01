package org.advent.day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayOneTaskSolverTest {

    @Test
    void shouldFindMax() {
        // given
        final var dayOneTaskSolver = new DayOneTaskSolver("/org/advent/day1/day_1_test_input.txt");

        // when
        final var calculatedMax = dayOneTaskSolver.solveTaskA();

        // then
        assertEquals(24000, calculatedMax);
    }

    @Test
    void shouldFindTop3() {
        // given
        final var dayOneTaskSolver = new DayOneTaskSolver("/org/advent/day1/day_1_test_input.txt");

        // when
        final var sumOfTop3 = dayOneTaskSolver.solveTaskB();

        // then
        assertEquals(45000, sumOfTop3);
    }
}