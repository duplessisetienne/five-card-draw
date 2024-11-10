package com.duplessis.etienne.five.card.draw.bean;

import lombok.*;

@NoArgsConstructor (force = true)
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Card   {
    private final Suit suit;
    private final Rank rank;



    // Getters and display methods

    public enum Suit {
        CLUBS("♣"), DIAMONDS("♦"), HEARTS("♥"), SPADES("♠");

        private final String symbol;

        Suit(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }
    }

    public enum Rank {
        TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"),
        EIGHT("8"), NINE("9"), TEN("10"), JACK("J"), QUEEN("Q"), KING("K"), ACE("A");

        private final String symbol;

        Rank(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }
    }
    @Override
    public String toString() {
        return rank.getSymbol() + suit.getSymbol();
    }



}
