package org.advent.day1.task1;

import org.advent.util.FileLoader;

import java.util.Arrays;

public class DayOneTaskSolverA {

    public static int solveTask() {
        final var rawData = FileLoader.loadFile("/org/advent/day1/task1/input.txt");

        return findMax(rawData);
    }

    static int findMax(String rawData) {
        return Arrays.stream(rawData.split("\\n\\n", 0))
                .map((line -> Arrays.stream(line.split("\\n", 0))
                        .mapToInt(Integer::parseInt).sum())).mapToInt(value -> value).max().orElse(0);
    }
}
