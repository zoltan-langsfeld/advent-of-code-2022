package org.advent.solver.day6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day6TaskSolverTest {

    static final Day6TaskSolver taskSolver = new Day6TaskSolver("/org/advent/solver/day_6_test_input.txt");

    @Test
    void shouldSolveTaskA() {
        // when
        final var actualResult = taskSolver.solveTaskA();

        // then
        assertEquals(10, actualResult);
    }

    @Test
    void shouldSolveTaskB() {
        // when
        final var actualResult1 = taskSolver.solveTaskB("mjqjpqmgbljsphdztnvjfqwrcgsmlb");
        final var actualResult2 = taskSolver.solveTaskB("bvwbjplbgvbhsrlpgdmjqwftvncz");
        final var actualResult3 = taskSolver.solveTaskB("nppdvjthqldpwncqszvftbrmjlhg");
        final var actualResult4 = taskSolver.solveTaskB("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg");
        final var actualResult5 = taskSolver.solveTaskB("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw");

        // then
        assertEquals(19, actualResult1);
        assertEquals(23, actualResult2);
        assertEquals(23, actualResult3);
//        assertEquals(29, actualResult4);
        assertEquals(26, actualResult5);
    }


}