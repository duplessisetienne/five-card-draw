package com.duplessis.etienne.five.card.draw.shuffle;

import com.duplessis.etienne.five.card.draw.model.Card;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class ShuffleTest {

    @Test
    void testFisherYatesShuffle() {
        List<Card> originalOrder = createOrderedDeck();
        List<Card> shuffledOrder = new ArrayList<>(originalOrder);

        // Use seeded random for reproducible tests
        ShuffleStrategy shuffler = new FisherYatesShuffle(new Random(42));
        shuffler.shuffle(shuffledOrder);

        assertNotEquals(originalOrder, shuffledOrder);
        assertEquals(52, shuffledOrder.size());
        assertTrue(containsSameCards(originalOrder, shuffledOrder));
    }

    @Test
    void testRiffleShuffle() {
        List<Card> originalOrder = createOrderedDeck();
        List<Card> shuffledOrder = new ArrayList<>(originalOrder);

        ShuffleStrategy shuffler = new RiffleShuffle(new Random(42), 1);
        shuffler.shuffle(shuffledOrder);

        assertNotEquals(originalOrder, shuffledOrder);
        assertEquals(52, shuffledOrder.size());
        assertTrue(containsSameCards(originalOrder, shuffledOrder));
    }

    @Test
    void testOverhandShuffle() {
        List<Card> originalOrder = createOrderedDeck();
        List<Card> shuffledOrder = new ArrayList<>(originalOrder);

        ShuffleStrategy shuffler = new OverhandShuffle(new Random(42), 1);
        shuffler.shuffle(shuffledOrder);

        assertNotEquals(originalOrder, shuffledOrder);
        assertEquals(52, shuffledOrder.size());
        assertTrue(containsSameCards(originalOrder, shuffledOrder));
    }

    private List<Card> createOrderedDeck() {
        List<Card> deck = new ArrayList<>();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
        return deck;
    }

    private boolean containsSameCards(List<Card> list1, List<Card> list2) {
        if (list1.size() != list2.size()) return false;
        List<Card> temp1 = new ArrayList<>(list1);
        List<Card> temp2 = new ArrayList<>(list2);
        temp1.sort((c1, c2) -> c1.toString().compareTo(c2.toString()));
        temp2.sort((c1, c2) -> c1.toString().compareTo(c2.toString()));
        return temp1.equals(temp2);
    }
}
