package org.advent.solver.day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameDecisionTest {

    @Test
    public void shouldGetCorrectResult() {
        assertEquals(RoundResult.WIN, GameDecision.ROCK.getResult(GameDecision.SCISSOR));
        assertEquals(RoundResult.LOOSE, GameDecision.ROCK.getResult(GameDecision.PAPER));
        assertEquals(RoundResult.TIE, GameDecision.ROCK.getResult(GameDecision.ROCK));

        assertEquals(RoundResult.WIN, GameDecision.PAPER.getResult(GameDecision.ROCK));
        assertEquals(RoundResult.LOOSE, GameDecision.PAPER.getResult(GameDecision.SCISSOR));
        assertEquals(RoundResult.TIE, GameDecision.PAPER.getResult(GameDecision.PAPER));

        assertEquals(RoundResult.WIN, GameDecision.SCISSOR.getResult(GameDecision.PAPER));
        assertEquals(RoundResult.LOOSE, GameDecision.SCISSOR.getResult(GameDecision.ROCK));
        assertEquals(RoundResult.TIE, GameDecision.SCISSOR.getResult(GameDecision.SCISSOR));
    }
}