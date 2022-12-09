package org.advent.solver.day8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day8TaskSolverTest {

    // given
    private static final Day8TaskSolver taskSolver = new Day8TaskSolver("/org/advent/solver/day_8_test_input.txt");

    @Test
    void shouldSolveTaskA() {
        // when
        final var actualResult = taskSolver.solveA();

        // then
        assertEquals(21, actualResult);
    }

    @Test
    void shouldSolveTaskB() {
        // when
        final var actualResult = taskSolver.solveB();

        // then
        assertEquals(8, actualResult);
    }


}