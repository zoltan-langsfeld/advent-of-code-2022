package org.advent.solver.day8;

import org.advent.util.FileLoader;

public class Day8TaskSolver {

    private final int[][] forest;
    private final int noColumns;
    private final int noRows;

    public Day8TaskSolver(String pathToInputData) {
        final var rawData = FileLoader.loadFile(pathToInputData).split("\n");
        this.noColumns = rawData[0].toCharArray().length;
        this.noRows = rawData.length;
        this.forest = parseRawData(rawData);
    }

    private int[][] parseRawData(String[] rawData) {
        final var tempForest = new int[this.noRows][this.noColumns];

        for (int rowId = 0; rowId < rawData.length; rowId++) {
            final var charsInLine = rawData[rowId].toCharArray();
            for (int columnId = 0; columnId < charsInLine.length; columnId++) {
                tempForest[rowId][columnId] = charsInLine[columnId];
            }
        }

        return tempForest;
    }

    public int solveA() {
        int nrOfVisibleTrees = 0;

        for (int rowId = 0; rowId < this.noRows; rowId++) {
            for (int columnId = 0; columnId < this.noColumns; columnId++) {
                if (isTreeOnTheEdge(rowId, columnId) || isTreeVisible(rowId, columnId)) {
                    nrOfVisibleTrees++;
                }
            }
        }

        return nrOfVisibleTrees;
    }

    private boolean isTreeOnTheEdge(int rowId, int columnId) {
        return rowId == 0 || rowId == forest.length - 1 || columnId == 0 || columnId == forest[0].length - 1;
    }

    private boolean isTreeVisible(int selectedRowId, int selectedColumnId) {
        return isVisibleFromTheLeft(selectedRowId, selectedColumnId)
                || isVisibleFromTheRight(selectedRowId, selectedColumnId)
                || isVisibleFromTheTop(selectedRowId, selectedColumnId)
                || isVisibleFromTheBottom(selectedRowId, selectedColumnId);
    }

    private boolean isVisibleFromTheLeft(int selectedRowId, int selectedColumnId) {
        for (int columId = 0; columId < selectedColumnId; columId++) {
            if (this.forest[selectedRowId][columId] >= this.forest[selectedRowId][selectedColumnId]) {
                return false;
            }
        }
        return true;
    }

    private boolean isVisibleFromTheRight(int selectedRowId, int selectedColumnId) {
        for (int columId = selectedColumnId + 1; columId < this.noColumns; columId++) {
            if (this.forest[selectedRowId][columId] >= this.forest[selectedRowId][selectedColumnId]) {
                return false;
            }
        }
        return true;
    }

    private boolean isVisibleFromTheTop(int selectedRowId, int selectedColumnId) {
        for (int rowId = 0; rowId < selectedRowId; rowId++) {
            if (this.forest[rowId][selectedColumnId] >= this.forest[selectedRowId][selectedColumnId]) {
                return false;
            }
        }
        return true;
    }

    private boolean isVisibleFromTheBottom(int selectedRowId, int selectedColumnId) {
        for (int rowId = selectedRowId + 1; rowId < noRows; rowId++) {
            if (this.forest[rowId][selectedColumnId] >= this.forest[selectedRowId][selectedColumnId]) {
                return false;
            }
        }
        return true;
    }

    public int solveB() {
        var highestScore = 0;
        for (int rowId = 0; rowId < this.noRows; rowId++) {
            for (int columnId = 0; columnId < this.noColumns; columnId++) {
                final int currentScore = isTreeOnTheEdge(rowId, columnId) ? 0 : calculateScore(rowId, columnId);
                if (currentScore > highestScore) {
                    highestScore = currentScore;
                }
            }
        }

        return highestScore;
    }

    private int calculateScore(int inputRowId, int inputColumnId) {
        return getVisibilityToTheRight(inputRowId, inputColumnId)
                * getVisibilityToTheLeft(inputRowId, inputColumnId)
                * getVisibilityToTheTop(inputRowId, inputColumnId)
                * getVisibilityToTheBottom(inputRowId, inputColumnId);
    }

    private int getVisibilityToTheLeft(int inputRowId, int inputColumnId) {
        int visibilityScore = 0;

        for (int columnIndex = inputColumnId - 1; columnIndex >= 0; columnIndex--) {
            visibilityScore++;
            if (this.forest[inputRowId][columnIndex] >= this.forest[inputRowId][inputColumnId]) {
                return visibilityScore;
            }
        }
        return visibilityScore;
    }

    private int getVisibilityToTheRight(int inputRowId, int inputColumnId) {
        int visibilityScore = 0;
        for (int columnIndex = inputColumnId + 1; columnIndex < noColumns; columnIndex++) {
            visibilityScore++;
            if (this.forest[inputRowId][columnIndex] >= this.forest[inputRowId][inputColumnId]) {
                return visibilityScore;
            }
        }
        return visibilityScore;
    }

    private int getVisibilityToTheTop(int inputRowId, int inputColumnId) {
        int visibilityScore = 0;
        for (int rowIndex = inputRowId - 1; rowIndex >= 0; rowIndex--) {
            visibilityScore++;
            if (this.forest[rowIndex][inputColumnId] >= this.forest[inputRowId][inputColumnId]) {
                return visibilityScore;
            }
        }
        return visibilityScore;
    }

    private int getVisibilityToTheBottom(int inputRowId, int inputColumnId) {
        int visibilityScore = 0;
        for (int rowIndex = inputRowId + 1; rowIndex < noRows; rowIndex++) {
            visibilityScore++;
            if (this.forest[rowIndex][inputColumnId] >= this.forest[inputRowId][inputColumnId]) {
                return visibilityScore;
            }
        }
        return visibilityScore;
    }
}
