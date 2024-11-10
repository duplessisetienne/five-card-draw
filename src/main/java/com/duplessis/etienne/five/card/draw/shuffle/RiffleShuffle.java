package com.duplessis.etienne.five.card.draw.shuffle;

import com.duplessis.etienne.five.card.draw.model.Card;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class RiffleShuffle implements ShuffleStrategy{

    private final Random random;
    private final int numberOfRiffles;

    public RiffleShuffle() {
        this(new Random(), 7); // Casino standard is 7 riffles
    }

    RiffleShuffle(Random random, int numberOfRiffles) {
        this.random = random;
        this.numberOfRiffles = numberOfRiffles;
    }

    @Override
    public void shuffle(List<Card> cards) {
        for (int riffle = 0; riffle < numberOfRiffles; riffle++) {
            performSingleRiffle(cards);
        }
    }

    private void performSingleRiffle(List<Card> cards) {
        int size = cards.size();
        List<Card> result = new ArrayList<>(size);

        // Split the deck into two halves
        List<Card> leftHalf = new ArrayList<>(cards.subList(0, size/2));
        List<Card> rightHalf = new ArrayList<>(cards.subList(size/2, size));

        // Riffle merge the two halves
        while (!leftHalf.isEmpty() || !rightHalf.isEmpty()) {
            // Simulate slight imperfections in shuffling
            if (!leftHalf.isEmpty() && (rightHalf.isEmpty() || random.nextDouble() < 0.5)) {
                result.add(leftHalf.remove(0));
            } else if (!rightHalf.isEmpty()) {
                result.add(rightHalf.remove(0));
            }
        }

        // Update the original list
        cards.clear();
        cards.addAll(result);
    }

    @Override
    public String getName() {
        return "Riffle Shuffle";
    }
}
