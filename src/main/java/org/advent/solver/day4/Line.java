package org.advent.solver.day4;

import java.util.HashSet;
import java.util.Set;

public class Line {

    private final Set<Integer> rangeA;
    private final Set<Integer> rangeB;

    public Line(String line) {
        final var splitLine = line.split(",");
        final var rangeStrA = splitLine[0];
        final var rangeStrB = splitLine[1];

        this.rangeA = getSectionIds(rangeStrA);
        this.rangeB = getSectionIds(rangeStrB);
    }

    private Set<Integer> getSectionIds(String rangeStr) {

        final var splitArea = rangeStr.split("-");
        final var begin = Integer.parseInt(splitArea[0]);
        final var end = Integer.parseInt(splitArea[1]);

        final var sectionIds = new HashSet<Integer>();

        for (int i = begin; i <= end; i++) {
            sectionIds.add(i);
        }

        return sectionIds;
    }

    public boolean doesOneRangeFullyContainTheOther() {
        return rangeA.containsAll(rangeB) || rangeB.containsAll(rangeA);
    }

    public boolean doRangesOverlap() {
        // copying is needed in order to not modify existing state
        final var intersection = new HashSet<>(rangeA);
        intersection.retainAll(rangeB);

        return !intersection.isEmpty();
    }
}
