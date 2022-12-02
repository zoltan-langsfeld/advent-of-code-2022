package org.advent.solver.day2;

public enum GameDecision {
    ROCK, PAPER, SCISSOR;

    public RoundResult getResult(GameDecision other) {
        if (this.equals(other)) {
            return RoundResult.TIE;
        } else if (this.equals(ROCK) && other.equals(PAPER)) {
            return RoundResult.LOOSE;
        } else if (this.equals(PAPER) && other.equals(SCISSOR)) {
            return RoundResult.LOOSE;
        } else if (this.equals(SCISSOR) && other.equals(ROCK)) {
            return RoundResult.LOOSE;
        } else {
            return RoundResult.WIN;
        }
    }
}
