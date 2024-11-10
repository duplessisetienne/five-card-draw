package com.duplessis.etienne.five.card.draw.service;

import com.duplessis.etienne.five.card.draw.model.Card;
import com.duplessis.etienne.five.card.draw.model.Hand;
import com.duplessis.etienne.five.card.draw.model.HandRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandEvaluatorTest {

    private HandEvaluator evaluator;
    private Hand hand;

    @BeforeEach
    void setUp() {
        evaluator = new HandEvaluator();
        hand = new Hand();
    }

    @Test
    void testStraightFlush() {
        hand.addCard(new Card(Card.Suit.HEARTS, Card.Rank.TEN));
        hand.addCard(new Card(Card.Suit.HEARTS, Card.Rank.JACK));
        hand.addCard(new Card(Card.Suit.HEARTS, Card.Rank.QUEEN));
        hand.addCard(new Card(Card.Suit.HEARTS, Card.Rank.KING));
        hand.addCard(new Card(Card.Suit.HEARTS, Card.Rank.ACE));

        assertEquals(HandRank.STRAIGHT_FLUSH, evaluator.evaluateHand(hand));
    }

    @Test
    void testFourOfAKind() {
        hand.addCard(new Card(Card.Suit.HEARTS, Card.Rank.ACE));
        hand.addCard(new Card(Card.Suit.DIAMONDS, Card.Rank.ACE));
        hand.addCard(new Card(Card.Suit.CLUBS, Card.Rank.ACE));
        hand.addCard(new Card(Card.Suit.SPADES, Card.Rank.ACE));
        hand.addCard(new Card(Card.Suit.HEARTS, Card.Rank.KING));

        assertEquals(HandRank.FOUR_OF_A_KIND, evaluator.evaluateHand(hand));
    }

    @Test
    void testFullHouse() {
        hand.addCard(new Card(Card.Suit.HEARTS, Card.Rank.ACE));
        hand.addCard(new Card(Card.Suit.DIAMONDS, Card.Rank.ACE));
        hand.addCard(new Card(Card.Suit.CLUBS, Card.Rank.ACE));
        hand.addCard(new Card(Card.Suit.SPADES, Card.Rank.KING));
        hand.addCard(new Card(Card.Suit.HEARTS, Card.Rank.KING));

        assertEquals(HandRank.FULL_HOUSE, evaluator.evaluateHand(hand));
    }

    @Test
    void testFlush() {
        hand.addCard(new Card(Card.Suit.HEARTS, Card.Rank.TWO));
        hand.addCard(new Card(Card.Suit.HEARTS, Card.Rank.FIVE));
        hand.addCard(new Card(Card.Suit.HEARTS, Card.Rank.SEVEN));
        hand.addCard(new Card(Card.Suit.HEARTS, Card.Rank.JACK));
        hand.addCard(new Card(Card.Suit.HEARTS, Card.Rank.KING));

        assertEquals(HandRank.FLUSH, evaluator.evaluateHand(hand));
    }

    @Test
    void testStraight() {
        hand.addCard(new Card(Card.Suit.HEARTS, Card.Rank.TEN));
        hand.addCard(new Card(Card.Suit.DIAMONDS, Card.Rank.JACK));
        hand.addCard(new Card(Card.Suit.CLUBS, Card.Rank.QUEEN));
        hand.addCard(new Card(Card.Suit.SPADES, Card.Rank.KING));
        hand.addCard(new Card(Card.Suit.HEARTS, Card.Rank.ACE));

        assertEquals(HandRank.STRAIGHT, evaluator.evaluateHand(hand));
    }

    @Test
    void testThreeOfAKind() {
        hand.addCard(new Card(Card.Suit.HEARTS, Card.Rank.ACE));
        hand.addCard(new Card(Card.Suit.DIAMONDS, Card.Rank.ACE));
        hand.addCard(new Card(Card.Suit.CLUBS, Card.Rank.ACE));
        hand.addCard(new Card(Card.Suit.SPADES, Card.Rank.KING));
        hand.addCard(new Card(Card.Suit.HEARTS, Card.Rank.QUEEN));

        assertEquals(HandRank.THREE_OF_A_KIND, evaluator.evaluateHand(hand));
    }

    @Test
    void testTwoPair() {
        hand.addCard(new Card(Card.Suit.HEARTS, Card.Rank.ACE));
        hand.addCard(new Card(Card.Suit.DIAMONDS, Card.Rank.ACE));
        hand.addCard(new Card(Card.Suit.CLUBS, Card.Rank.KING));
        hand.addCard(new Card(Card.Suit.SPADES, Card.Rank.KING));
        hand.addCard(new Card(Card.Suit.HEARTS, Card.Rank.QUEEN));

        assertEquals(HandRank.TWO_PAIR, evaluator.evaluateHand(hand));
    }

    @Test
    void testOnePair() {
        hand.addCard(new Card(Card.Suit.HEARTS, Card.Rank.ACE));
        hand.addCard(new Card(Card.Suit.DIAMONDS, Card.Rank.ACE));
        hand.addCard(new Card(Card.Suit.CLUBS, Card.Rank.KING));
        hand.addCard(new Card(Card.Suit.SPADES, Card.Rank.QUEEN));
        hand.addCard(new Card(Card.Suit.HEARTS, Card.Rank.JACK));

        assertEquals(HandRank.ONE_PAIR, evaluator.evaluateHand(hand));
    }

    @Test
    void testHighCard() {
        hand.addCard(new Card(Card.Suit.HEARTS, Card.Rank.ACE));
        hand.addCard(new Card(Card.Suit.DIAMONDS, Card.Rank.KING));
        hand.addCard(new Card(Card.Suit.CLUBS, Card.Rank.QUEEN));
        hand.addCard(new Card(Card.Suit.SPADES, Card.Rank.JACK));
        hand.addCard(new Card(Card.Suit.HEARTS, Card.Rank.NINE));

        assertEquals(HandRank.HIGH_CARD, evaluator.evaluateHand(hand));
    }
}
