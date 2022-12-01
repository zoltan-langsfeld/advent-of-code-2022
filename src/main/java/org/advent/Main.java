package org.advent;

import org.advent.day1.DayOneTaskSolver;

public class Main {

    public static void main(String[] args) {
        DayOneTaskSolver dayOneTaskSolver = new DayOneTaskSolver("/org/advent/day1/day_1_input.txt");

        System.out.printf("Find the Elf carrying the most Calories. How many total Calories is that Elf carrying? Answer: %s%n", dayOneTaskSolver.solveTaskA());
        System.out.printf("Find the top three Elves carrying the most Calories. How many Calories are those Elves carrying in total? Answer: %s%n", dayOneTaskSolver.solveTaskB());
    }
}
