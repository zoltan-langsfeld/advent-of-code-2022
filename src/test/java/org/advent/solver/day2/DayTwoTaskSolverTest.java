package org.advent.solver.day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayTwoTaskSolverTest {

    @Test
    void shouldSolveTaskA() {
        // given
        final var dayTwoTaskSolver = new DayTwoTaskSolver("/org/advent/solver/day_2_test_input.txt");

        // when
        final var actualResult = dayTwoTaskSolver.solveTaskA();

        // then
        assertEquals(15, actualResult);
    }

    @Test
    void shouldSolveTaskB() {
    }
}