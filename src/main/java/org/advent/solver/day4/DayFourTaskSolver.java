package org.advent.solver.day4;

import org.advent.solver.TaskSolver;
import org.advent.util.FileLoader;

import java.util.Arrays;
import java.util.List;

public class DayFourTaskSolver implements TaskSolver {
    private final List<Line> lines;

    public DayFourTaskSolver(String pathToInputData) {
        final var rawData = FileLoader.loadFile(pathToInputData).split("\\n", 0);
        this.lines = Arrays.stream(rawData).map(this::processRawLine).toList();
    }

    private Line processRawLine(String rawLine) {
        return new Line(rawLine);
    }

    @Override
    public long solveTaskA() {

        return lines.stream()
                .map(Line::doesOneRangeFullyContainTheOther)
                .filter(processedLine -> processedLine.equals(true))
                .count();
    }


    @Override
    public long solveTaskB() {
        return lines.stream()
                .map(Line::doRangesOverlap)
                .filter(processedLine -> processedLine.equals(true))
                .count();
    }

}
