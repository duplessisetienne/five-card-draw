package com.duplessis.etienne.five.card.draw.service;

import com.duplessis.etienne.five.card.draw.model.Card;
import com.duplessis.etienne.five.card.draw.model.Hand;
import com.duplessis.etienne.five.card.draw.model.HandRank;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class HandEvaluator {

    public HandRank evaluateHand(Hand hand) {
        List<Card> cards = hand.getCards();

        if (isStraightFlush(cards)) return HandRank.STRAIGHT_FLUSH;
        if (isFourOfAKind(cards)) return HandRank.FOUR_OF_A_KIND;
        if (isFullHouse(cards)) return HandRank.FULL_HOUSE;
        if (isFlush(cards)) return HandRank.FLUSH;
        if (isStraight(cards)) return HandRank.STRAIGHT;
        if (isThreeOfAKind(cards)) return HandRank.THREE_OF_A_KIND;
        if (isTwoPair(cards)) return HandRank.TWO_PAIR;
        if (isOnePair(cards)) return HandRank.ONE_PAIR;

        return HandRank.HIGH_CARD;
    }

    private boolean isStraightFlush(List<Card> cards) {
        return isFlush(cards) && isStraight(cards);
    }

    private boolean isFourOfAKind(List<Card> cards) {
        Map<Card.Rank, Long> rankCounts = getRankCounts(cards);
        return rankCounts.values().stream().anyMatch(count -> count == 4);
    }

    private boolean isFullHouse(List<Card> cards) {
        Map<Card.Rank, Long> rankCounts = getRankCounts(cards);
        return rankCounts.values().stream().anyMatch(count -> count == 3) &&
                rankCounts.values().stream().anyMatch(count -> count == 2);
    }

    private boolean isFlush(List<Card> cards) {
        return cards.stream().map(Card::getSuit).distinct().count() == 1;
    }

    private boolean isStraight(List<Card> cards) {
        List<Integer> ranks = cards.stream()
                .map(card -> card.getRank().ordinal())
                .sorted()
                .collect(Collectors.toList());

        for (int i = 0; i < ranks.size() - 1; i++) {
            if (ranks.get(i + 1) - ranks.get(i) != 1) {
                return false;
            }
        }
        return true;
    }

    private boolean isThreeOfAKind(List<Card> cards) {
        Map<Card.Rank, Long> rankCounts = getRankCounts(cards);
        return rankCounts.values().stream().anyMatch(count -> count == 3);
    }

    private boolean isTwoPair(List<Card> cards) {
        Map<Card.Rank, Long> rankCounts = getRankCounts(cards);
        return rankCounts.values().stream().filter(count -> count == 2).count() == 2;
    }

    private boolean isOnePair(List<Card> cards) {
        Map<Card.Rank, Long> rankCounts = getRankCounts(cards);
        return rankCounts.values().stream().filter(count -> count == 2).count() == 1;
    }

    private Map<Card.Rank, Long> getRankCounts(List<Card> cards) {
        return cards.stream().collect(Collectors.groupingBy(Card::getRank, Collectors.counting()));
    }

}
