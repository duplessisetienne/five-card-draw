package com.duplessis.etienne.five.card.draw.service;

import com.duplessis.etienne.five.card.draw.model.Deck;
import com.duplessis.etienne.five.card.draw.model.Hand;
import com.duplessis.etienne.five.card.draw.shuffle.ShuffleStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private final HandEvaluator handEvaluator;
    private final ShuffleStrategy shuffleStrategy;

    @Autowired
    public GameService(HandEvaluator handEvaluator, @Qualifier("overhandShuffle") ShuffleStrategy shuffleStrategy) {
        this.handEvaluator = handEvaluator;
        this.shuffleStrategy = shuffleStrategy;
    }

    public Hand dealHand() {
        Deck deck = new Deck(shuffleStrategy);
        System.out.println("Shuffling ... Shuffling ... Shuffling ...");
        deck.shuffle();

        Hand hand = new Hand();
        for (int i = 0; i < 5; i++) {
            hand.addCard(deck.drawCard());
        }

        hand.setHandRank(handEvaluator.evaluateHand(hand));
        return hand;
    }
}
