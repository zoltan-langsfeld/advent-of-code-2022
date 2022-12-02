package org.advent.solver.day2;

import org.advent.util.FileLoader;

import java.util.Arrays;

public class DayTwoTaskSolver {

    private final String rawData;

    public DayTwoTaskSolver(String pathToInputData) {
        this.rawData = FileLoader.loadFile(pathToInputData);
    }


    public int solveTaskA() {
        return Arrays.stream(rawData.split("\\n", 0))
                .map(this::calculateScoreForRound).mapToInt(v -> v).sum();
    }

    private int calculateScoreForRound(String line) {
        String[] splitLine = line.split(" ", 0);
        final var opponentDecision = GameDecisionMapper.mapToGameDecision(splitLine[0]);
        final var myDecision = GameDecisionMapper.mapToGameDecision(splitLine[1]);

        final var roundResult = myDecision.getResult(opponentDecision);

        return GameConfig.gameDecisionToValue.get(myDecision) + GameConfig.gameResultToValue.get(roundResult);
    }

    public int solveTaskB() {
        return 0;
    }
}
