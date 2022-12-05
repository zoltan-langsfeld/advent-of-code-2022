package org.advent.solver.day5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day5TaskSolverTest {

    static final Day5TaskSolver day5TaskSolver = new Day5TaskSolver("/org/advent/solver/day_5_test_input.txt");

    @Test
    void solveTaskA() {
        // when
        final var actualResult = day5TaskSolver.solveTaskA();

        // then
        assertEquals("CMZ", actualResult);
    }

    @Test
    void solveTaskB() {
        // when
        final var actualResult = day5TaskSolver.solveTaskB();

        // then
        assertEquals("MCD", actualResult);
    }
}