package org.advent.solver.day3;

import org.advent.util.FileLoader;

public class DayThreeTaskSolver {
    private final String[] rawData;

    public DayThreeTaskSolver(String pathToInputData) {
        this.rawData = FileLoader.loadFile(pathToInputData).split("\\n", 0);

    }

    public int solveTaskA() {
        var sum = 0;

        for (String rawLine : rawData) {
            final var line = rawLine.toCharArray();
            char commonChar = ' ';
            int lineMidLength = line.length / 2;

            for (int j = 0; j < lineMidLength && commonChar == ' '; j++) {
                for (int k = lineMidLength; k < line.length; k++) {
                    if (line[j] == line[k]) {
                        commonChar = line[j];
                        break;
                    }
                }
            }
            sum += getPriority(commonChar);
        }

        return sum;
    }

    public int solveTaskB() {
        var currentGroupId = 0;
        var sum = 0;

        while (currentGroupId * 3 + 2 < rawData.length) {
            var commonChar = ' ';

            final var backPackAContent = rawData[currentGroupId * 3].toCharArray();
            final var backPackBContent = rawData[currentGroupId * 3 + 1].toCharArray();
            final var backPackCContent = rawData[currentGroupId * 3 + 2].toCharArray();

            for (int aIndex = 0; aIndex < backPackAContent.length && commonChar == ' '; aIndex++) {
                for (int bIndex = 0; bIndex < backPackBContent.length && commonChar == ' '; bIndex++) {
                    for (char c : backPackCContent) {
                        if (backPackAContent[aIndex] == backPackBContent[bIndex] && backPackAContent[aIndex] == c) {
                            commonChar = backPackAContent[aIndex];
                            break;
                        }
                    }
                }
            }
            currentGroupId++;
            sum += getPriority(commonChar);
        }

        return sum;
    }

    public int getPriority(char ch) {
        int intValueOfChar = (int) ch;
        if (intValueOfChar <= 122 & intValueOfChar >= 97) {
            return ((int) ch - 96);
        }
        if (intValueOfChar <= 90 & intValueOfChar >= 65) {
            return ((int) ch - 38);
        }
        return -1;
    }
}
