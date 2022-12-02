package org.advent.solver.day2;

import java.util.Map;

/**
 * In the future, these values should be loaded from a properties file.
 */
public class GameConfig {
    public static final Map<GameDecision, Integer> gameDecisionToValue = Map.of(GameDecision.ROCK, 1, GameDecision.PAPER, 2, GameDecision.SCISSOR, 3);
    public static final Map<RoundResult, Integer> gameResultToValue = Map.of(RoundResult.WIN, 6, RoundResult.TIE, 3, RoundResult.LOOSE, 0);
}
