package org.advent.solver.day2;

public enum GameDecision {
    ROCK, PAPER, SCISSOR;

    // My initial idea was to implement the Comparable interface, but it turned out that I'd violate the transitivity rule required by the Comparable interface.
    // No matter what order one chooses, transitivity won't be fulfilled, i.e. ROCK.compareTo(SCISSOR) > 0 && SCISSOR.compareTo(PAPER) > 0) does not imply ROCK.compareTo(PAPER) > 0.
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
