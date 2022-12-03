package org.advent.solver.day3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayThreeTaskSolverTest {

    static final DayThreeTaskSolver dayThreeTaskSolver = new DayThreeTaskSolver("/org/advent/solver/day_3_test_input.txt");

    @Test
    void shouldSolveTaskA() {
        // when
        final var actualResult = dayThreeTaskSolver.solveTaskA();

        // then
        assertEquals(157, actualResult);
    }

    @Test
    void shouldSolveTaskB() {
        // when
        final var actualResult = dayThreeTaskSolver.solveTaskB();

        // then
        assertEquals(70, actualResult);
    }
}