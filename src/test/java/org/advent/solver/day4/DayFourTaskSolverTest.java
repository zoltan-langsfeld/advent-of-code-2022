package org.advent.solver.day4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayFourTaskSolverTest {

    static final DayFourTaskSolver dayFourTaskSolver = new DayFourTaskSolver("/org/advent/solver/day_4_test_input.txt");

    @Test
    void shouldSolveTaskA() {
        // when
        final var actualResult = dayFourTaskSolver.solveTaskA();

        // then
        assertEquals(2, actualResult);
    }

    @Test
    void solveTaskB() {
        // when
        final var actualResult = dayFourTaskSolver.solveTaskB();

        // then
        assertEquals(4, actualResult);
    }
}