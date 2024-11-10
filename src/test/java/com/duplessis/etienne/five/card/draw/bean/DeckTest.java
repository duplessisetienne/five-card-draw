package com.duplessis.etienne.five.card.draw.bean;

import com.duplessis.etienne.five.card.draw.shuffle.FisherYatesShuffle;
import com.duplessis.etienne.five.card.draw.shuffle.ShuffleStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {
    private ShuffleStrategy shuffleStrategy;

    @BeforeEach
    void setUp() {
        shuffleStrategy = new FisherYatesShuffle();
    }

    @Test
    void testDeckInitialization() {
        Deck deck = new Deck(shuffleStrategy);
        Set<Card> drawnCards = new HashSet<>();

        // Draw all 52 cards and verify uniqueness
        for (int i = 0; i < 52; i++) {
            Card card = deck.drawCard();
            assertFalse(drawnCards.contains(card), "Duplicate card found");
            drawnCards.add(card);
        }

        assertEquals(52, drawnCards.size(), "Deck should contain exactly 52 cards");
    }

    @Test
    void testDrawEmptyDeck() {
        Deck deck = new Deck(shuffleStrategy);
        // Draw all cards first
        for (int i = 0; i < 52; i++) {
            deck.drawCard();
        }

        assertThrows(IllegalStateException.class, deck::drawCard);
    }

    @Test
    void testShuffle() {
        Deck deck1 = new Deck(shuffleStrategy);
        Deck deck2 = new Deck(shuffleStrategy);

        deck2.shuffle();

        // Draw all cards from both decks
        boolean cardsInDifferentOrder = false;
        for (int i = 0; i < 52; i++) {
            Card card1 = deck1.drawCard();
            Card card2 = deck2.drawCard();
            if (!card1.toString().equals(card2.toString())) {
                cardsInDifferentOrder = true;
                break;
            }
        }

        assertTrue(cardsInDifferentOrder, "Shuffle should change card order");
    }
}
