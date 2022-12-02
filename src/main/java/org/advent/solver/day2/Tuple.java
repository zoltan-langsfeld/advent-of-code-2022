package org.advent.solver.day2;

public class Tuple {
    private final GameDecision gameDecision;
    private final RoundResult roundResult;

    public Tuple(GameDecision gameDecision, RoundResult roundResult) {
        this.gameDecision = gameDecision;
        this.roundResult = roundResult;
    }

    public GameDecision getGameDecision() {
        return gameDecision;
    }

    public RoundResult getRoundResult() {
        return roundResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tuple tuple = (Tuple) o;

        if (gameDecision != tuple.gameDecision) return false;
        return roundResult == tuple.roundResult;
    }

    @Override
    public int hashCode() {
        int result = gameDecision != null ? gameDecision.hashCode() : 0;
        result = 31 * result + (roundResult != null ? roundResult.hashCode() : 0);
        return result;
    }
}
