package org.advent.solver.day7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day7TaskSolverTest {

    // given
    private static final Day7TaskSolver taskSolver = new Day7TaskSolver("/org/advent/solver/day_7_test_input.txt");

    @Test
    void shouldSolveTaskA() {
        // when
        final var actualResult = taskSolver.solveA();

        // then
        assertEquals(95437, actualResult);
    }

    @Test
    void shouldSolveTaskB() {
        // when
        final var actualResult = taskSolver.solveB();

        // then
        assertEquals(24933642, actualResult);
    }
}