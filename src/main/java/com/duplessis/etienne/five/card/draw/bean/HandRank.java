package com.duplessis.etienne.five.card.draw.bean;

public enum HandRank {

    STRAIGHT_FLUSH("Straight Flush"),
    FOUR_OF_A_KIND("Four of a Kind"),
    FULL_HOUSE("Full House"),
    FLUSH("Flush"),
    STRAIGHT("Straight"),
    THREE_OF_A_KIND("Three of a Kind"),
    TWO_PAIR("Two Pair"),
    ONE_PAIR("One Pair"),
    HIGH_CARD("High Card");

    private final String display;

    HandRank(String display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return display;
    }
}
