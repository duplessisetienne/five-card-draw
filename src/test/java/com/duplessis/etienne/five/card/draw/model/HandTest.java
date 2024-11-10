package com.duplessis.etienne.five.card.draw.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HandTest {
    private Hand hand;

    @BeforeEach
    void setUp() {
        hand = new Hand();
    }

    @Test
    void testAddCard() {
        Card card = new Card(Card.Suit.HEARTS, Card.Rank.ACE);
        hand.addCard(card);
        assertEquals(1, hand.getCards().size());
        assertEquals(card, hand.getCards().get(0));
    }

    @Test
    void testAddCardLimit() {
        // Add 5 cards
        for (int i = 0; i < 5; i++) {
            hand.addCard(new Card(Card.Suit.HEARTS, Card.Rank.values()[i]));
        }

        assertThrows(IllegalStateException.class, () ->
                hand.addCard(new Card(Card.Suit.HEARTS, Card.Rank.ACE)));
    }

    @Test
    void testHandToString() {
        hand.addCard(new Card(Card.Suit.HEARTS, Card.Rank.ACE));
        hand.addCard(new Card(Card.Suit.SPADES, Card.Rank.KING));
        assertEquals("A♥ K♠", hand.toString());
    }
}
