package com.duplessis.etienne.five.card.draw.shuffle;

import com.duplessis.etienne.five.card.draw.model.Card;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class OverhandShuffle implements ShuffleStrategy{
    private final Random random;
    private final int numberOfShuffles;

    public OverhandShuffle() {
        this(new Random(), 10); // Multiple overhand shuffles needed for randomization
    }

    OverhandShuffle(Random random, int numberOfShuffles) {
        this.random = random;
        this.numberOfShuffles = numberOfShuffles;
    }

    @Override
    public void shuffle(List<Card> cards) {
        for (int shuffle = 0; shuffle < numberOfShuffles; shuffle++) {
            performSingleOverhand(cards);
        }
    }

    private void performSingleOverhand(List<Card> cards) {
        List<Card> result = new ArrayList<>();
        List<Card> current = new ArrayList<>(cards);

        while (!current.isEmpty()) {
            // Take a small packet of cards (1-4 cards typically)
            int packetSize = 1 + random.nextInt(4);
            int cardsToTake = Math.min(packetSize, current.size());

            // Take cards from the top and add to result
            List<Card> packet = current.subList(0, cardsToTake);
            result.addAll(0, new ArrayList<>(packet));
            packet.clear();
        }

        // Update the original list
        cards.clear();
        cards.addAll(result);
    }

    @Override
    public String getName() {
        return "Overhand Shuffle";
    }
}
