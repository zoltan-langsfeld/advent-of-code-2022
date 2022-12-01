package org.advent;

import org.advent.day1.task1.DayOneTaskSolverA;
import org.advent.day1.task1.DayOneTaskSolverB;

public class Main {

    public static void main(String[] args) {

        System.out.printf("Find the Elf carrying the most Calories. How many total Calories is that Elf carrying? Answer: %s%n", DayOneTaskSolverA.solveTask());
        System.out.printf("Find the top three Elves carrying the most Calories. How many Calories are those Elves carrying in total? Answer: %s%n", DayOneTaskSolverB.solveTask());
    }
}
