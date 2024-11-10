package com.duplessis.etienne.five.card.draw.shuffle;

import com.duplessis.etienne.five.card.draw.model.Card;

import java.util.List;

public interface ShuffleStrategy {
    void shuffle(List<Card> cards);
    String getName();
}
