package com.duplessis.etienne.five.card.draw.shuffle;

import com.duplessis.etienne.five.card.draw.model.Card;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class FisherYatesShuffle implements ShuffleStrategy{

    private final Random random;

    public FisherYatesShuffle() {
        this.random = new Random();
    }

    // For testing with a seeded random
    FisherYatesShuffle(Random random) {
        this.random = random;
    }

    @Override
    public void shuffle(List<Card> cards) {
        for (int i = cards.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }

    @Override
    public String getName() {
        return "Fisher-Yates Shuffle";
    }
}
