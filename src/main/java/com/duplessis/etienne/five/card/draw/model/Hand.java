package com.duplessis.etienne.five.card.draw.model;



import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Hand {

    private final List<Card> cards;

    private  HandRank handRank;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        if (cards.size() >= 5) {
            throw new IllegalStateException("Hand already has 5 cards");
        }
        cards.add(card);
    }

    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }

    @Override
    public String toString() {
        return String.join(" ", cards.stream().map(Card::toString).toList());
    }
}
