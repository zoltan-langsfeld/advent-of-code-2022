package org.advent.day1.task1;

import org.advent.util.FileLoader;

import java.util.Arrays;

public class DayOneTaskSolverB {

    public static int solveTask() {
        final var rawData = FileLoader.loadFile("/org/advent/day1/task1/input.txt");

        return findSumOfTop3(rawData);
    }

    static int findSumOfTop3(String rawData) {
        return Arrays.stream(rawData.split("\\n\\n", 0))
                .map((line -> Arrays.stream(line.split("\\n", 0))
                        .mapToInt(Integer::parseInt).sum()))
                .mapToInt(value -> value)
                .map(value -> -1 * value)
                .sorted()
                .map(value -> -1 * value)
                .limit(3).sum();
    }
}
