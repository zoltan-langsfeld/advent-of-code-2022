package org.advent.solver.day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayTwoTaskSolverTest {

    static final DayTwoTaskSolver dayTwoTaskSolver = new DayTwoTaskSolver("/org/advent/solver/day_2_test_input.txt");

    @Test
    void shouldSolveTaskA() {
        // when
        final var actualResult = dayTwoTaskSolver.solveTaskA();

        // then
        assertEquals(15, actualResult);
    }

    @Test
    void shouldSolveTaskB() {
        // when
        final var actualResult = dayTwoTaskSolver.solveTaskB();

        // then
        assertEquals(12, actualResult);
    }
}