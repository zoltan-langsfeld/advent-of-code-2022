package org.advent.solver.day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameDecisionMapperTest {

    @Test
    void shouldMapToGameDecisionCorrectly() {
        assertEquals(GameDecision.ROCK, GameDecisionMapper.mapToGameDecision("A"));
        assertEquals(GameDecision.ROCK, GameDecisionMapper.mapToGameDecision("X"));

        assertEquals(GameDecision.PAPER, GameDecisionMapper.mapToGameDecision("B"));
        assertEquals(GameDecision.PAPER, GameDecisionMapper.mapToGameDecision("Y"));

        assertEquals(GameDecision.SCISSOR, GameDecisionMapper.mapToGameDecision("C"));
        assertEquals(GameDecision.SCISSOR, GameDecisionMapper.mapToGameDecision("Z"));
    }
}