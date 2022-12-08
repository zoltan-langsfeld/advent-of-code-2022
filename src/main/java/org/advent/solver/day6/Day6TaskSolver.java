package org.advent.solver.day6;

import org.advent.util.FileLoader;

import java.util.ArrayList;
import java.util.HashSet;

public class Day6TaskSolver {

    private final String rawData;

    public Day6TaskSolver(String pathToInputData) {
        this.rawData = FileLoader.loadFile(pathToInputData);
    }

    public int solveTaskA() {
        final var chars = rawData.toCharArray();
        final var tempSet = new HashSet<>();
        var charsProcessed = 0;

        for (int i = 0; i < chars.length; i++) {
            if (tempSet.size() == 4) {
                charsProcessed = i - 1;
                break;
            }
            if (tempSet.contains(chars[i])) {
                tempSet.clear();
            }
            tempSet.add(chars[i]);
        }

        return charsProcessed;
    }

    public int solveTaskB(String input) {
        final var chars = input.toCharArray();
        final var tempList = new ArrayList<>();
        var charsProcessed = 0;

        for (int i = 0; i < chars.length; i++) {
            if (tempList.size() == 14) {
                charsProcessed = i - 1;
                break;
            }

            if (tempList.contains(chars[i])) {
                tempList.clear();
            }
            tempList.add(chars[i]);
        }

        if (charsProcessed == 0) {
            charsProcessed = chars.length - tempList.size();
        }

        return charsProcessed;
    }
}
