package com.duplessis.etienne.five.card.draw.service;


import com.duplessis.etienne.five.card.draw.model.Hand;
import com.duplessis.etienne.five.card.draw.model.HandRank;
import com.duplessis.etienne.five.card.draw.shuffle.ShuffleStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.mockito.Mockito.when;

public class GameServiceTest {
    @Mock
    private HandEvaluator handEvaluator;

    @Mock
    private ShuffleStrategy shuffleStrategy;

    private GameService gameService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        gameService = new GameService(handEvaluator, shuffleStrategy);
        when(handEvaluator.evaluateHand(any(Hand.class))).thenReturn(HandRank.HIGH_CARD);
    }

    @Test
    void testDealHand() {
        Hand hand = gameService.dealHand();

        assertNotNull(hand);
        assertEquals(5, hand.getCards().size());
        assertNotNull(hand.getHandRank());
    }
}
