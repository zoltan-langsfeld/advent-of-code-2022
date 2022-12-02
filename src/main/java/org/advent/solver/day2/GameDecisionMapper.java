package org.advent.solver.day2;

public class GameDecisionMapper {

    public static GameDecision mapToGameDecision(String input) {

        return switch (input) {
            case "B", "Y" -> GameDecision.PAPER;
            case "C", "Z" -> GameDecision.SCISSOR;
            default -> GameDecision.ROCK;
        };
    }
}
