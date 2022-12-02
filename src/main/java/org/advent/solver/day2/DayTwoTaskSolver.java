package org.advent.solver.day2;

import org.advent.util.FileLoader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DayTwoTaskSolver {

    private final String rawData;
    private final Map<Tuple, GameDecision> mapToGameDecision;

    public DayTwoTaskSolver(String pathToInputData) {
        this.rawData = FileLoader.loadFile(pathToInputData);
        // Made the decision to populate this map dynamically as defining all these rules manually would've been tedious,
        // and it also would not scale well. The penalty is that this map has to be generated at run time.
        this.mapToGameDecision = populateMapToGameDecision();
    }

    private Map<Tuple, GameDecision> populateMapToGameDecision() {
        final var mapToReturn = new HashMap<Tuple, GameDecision>();

        for (GameDecision decisionA : GameDecision.values()) {
            for (RoundResult roundResult : RoundResult.values()) {
                final var tuple = new Tuple(decisionA, roundResult);
                mapToReturn.put(tuple, findProperDecision(tuple));
            }
        }
        return mapToReturn;
    }

    private GameDecision findProperDecision(Tuple tuple) {
        if (tuple.getRoundResult().equals(RoundResult.TIE)) {
            return tuple.getGameDecision();
        }

        for (var decisionB : GameDecision.values()) {
            if (decisionB.getResult(tuple.getGameDecision()).equals(tuple.getRoundResult())) {
                return decisionB;
            }
        }
        return GameDecision.ROCK;
    }


    public int solveTaskA() {
        return Arrays.stream(rawData.split("\\n", 0))
                .map(this::calculateScoreForRoundTaskA).mapToInt(v -> v).sum();
    }

    private int calculateScoreForRoundTaskA(String line) {
        String[] splitLine = line.split(" ", 0);
        final var opponentDecision = GameConfig.charToGameDecision.get(splitLine[0]);
        final var myDecision = GameConfig.charToGameDecision.get(splitLine[1]);

        final var roundResult = myDecision.getResult(opponentDecision);

        return GameConfig.gameDecisionToValue.get(myDecision) + GameConfig.gameResultToValue.get(roundResult);
    }

    public int solveTaskB() {
        // The line below could be moved to the constructor to avoid splitting the same String twice as we
        // do the same in solveTaskA()
        return Arrays.stream(rawData.split("\\n", 0))
                .map(this::calculateScoreForRoundTaskB).mapToInt(v -> v).sum();
    }

    private int calculateScoreForRoundTaskB(String line) {
        String[] splitLine = line.split(" ", 0);
        final var opponentDecision = GameConfig.charToGameDecision.get(splitLine[0]);
        final var roundResult = GameConfig.charToRoundResult.get(splitLine[1]);

        final var myDecision = mapToGameDecision.get(new Tuple(opponentDecision, roundResult));

        return GameConfig.gameDecisionToValue.get(myDecision) + GameConfig.gameResultToValue.get(roundResult);
    }
}
