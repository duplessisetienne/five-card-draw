package com.duplessis.etienne.five.card.draw.bean;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardTest {
    @Test
    void testCardCreation() {
        Card card = new Card(Card.Suit.HEARTS, Card.Rank.ACE);
        assertEquals(Card.Suit.HEARTS, card.getSuit());
        assertEquals(Card.Rank.ACE, card.getRank());
    }

    @Test
    void testCardToString() {
        Card card = new Card(Card.Suit.SPADES, Card.Rank.KING);
        assertEquals("K♠", card.toString());
    }
}
