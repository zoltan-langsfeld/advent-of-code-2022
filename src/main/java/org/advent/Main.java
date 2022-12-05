package org.advent;

import org.advent.solver.day1.DayOneTaskSolver;
import org.advent.solver.day2.DayTwoTaskSolver;
import org.advent.solver.day3.DayThreeTaskSolver;
import org.advent.solver.day4.DayFourTaskSolver;

public class Main {

    public static void main(String[] args) {

        System.out.println("---------Day 1---------");
        DayOneTaskSolver dayOneTaskSolver = new DayOneTaskSolver("/org/advent/solver/day_1_input.txt");
        System.out.printf("Find the Elf carrying the most Calories. How many total Calories is that Elf carrying? Answer: %s%n", dayOneTaskSolver.solveTaskA());
        System.out.printf("Find the top three Elves carrying the most Calories. How many Calories are those Elves carrying in total? Answer: %s%n", dayOneTaskSolver.solveTaskB());

        System.out.println("---------Day 2---------");
        DayTwoTaskSolver dayTwoTaskSolver = new DayTwoTaskSolver("/org/advent/solver/day_2_input.txt");
        System.out.printf("What would your total score be if everything goes exactly according to your strategy guide? Answer: %s%n", dayTwoTaskSolver.solveTaskA());
        System.out.printf("Following the Elf's instructions for the second column, what would your total score be if everything goes exactly according to your strategy guide? Answer: %s%n", dayTwoTaskSolver.solveTaskB());

        System.out.println("---------Day 3---------");
        final var dayThreeTaskSolver = new DayThreeTaskSolver("/org/advent/solver/day_3_input.txt");
        System.out.printf("Find the item type that appears in both compartments of each rucksack. What is the sum of the priorities of those item types? Answer: %s%n", dayThreeTaskSolver.solveTaskA());
        System.out.printf("Find the item type that corresponds to the badges of each three-Elf group. What is the sum of the priorities of those item types? Answer: %s%n", dayThreeTaskSolver.solveTaskB());

        System.out.println("---------Day 4---------");
        final var dayFourTaskSolver = new DayFourTaskSolver("/org/advent/solver/day_4_input.txt");
        System.out.printf("In how many assignment pairs does one range fully contain the other? Answer: %s%n", dayFourTaskSolver.solveTaskA());
        System.out.printf("In how many assignment pairs do the ranges overlap? Answer: %s%n", dayFourTaskSolver.solveTaskB());
    }
}
