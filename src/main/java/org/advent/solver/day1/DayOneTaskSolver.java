package org.advent.solver.day1;

import org.advent.util.FileLoader;

import java.util.Arrays;
import java.util.List;

public class DayOneTaskSolver {

    private final List<Integer> preprocessedData;

    public DayOneTaskSolver(String pathToInputData) {
        final var rawData = FileLoader.loadFile(pathToInputData);
        this.preprocessedData = Arrays.stream(rawData.split("\\n\\n", 0))
                .map((line -> Arrays.stream(line.split("\\n", 0))
                        .mapToInt(Integer::parseInt).sum())).mapToInt(value -> value).boxed().toList();
    }


    public int solveTaskA() {
        return preprocessedData.stream().mapToInt(value -> value).max().orElse(0);
    }

    public int solveTaskB() {
        return preprocessedData
                .stream()
                .mapToInt(value -> value)
                .map(value -> -1 * value)
                .sorted()
                .map(value -> -1 * value)
                .limit(3).sum();
    }
}
