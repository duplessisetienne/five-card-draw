package com.duplessis.etienne.five.card.draw.bean;

import com.duplessis.etienne.five.card.draw.shuffle.ShuffleStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Deck {
    private final List<Card> cards;
    private final ShuffleStrategy shuffleStrategy;

    @Autowired
    public Deck(@Qualifier("fisherYatesShuffle") ShuffleStrategy shuffleStrategy) {
        this.shuffleStrategy = shuffleStrategy;
        this.cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        System.out.println("Shuffling using " + shuffleStrategy.getName() + "...");
        shuffleStrategy.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("No cards left in deck");
        }
        return cards.remove(0);
    }

    public int remainingCards() {
        return cards.size();
    }
}
