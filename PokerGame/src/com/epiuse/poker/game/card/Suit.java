package com.epiuse.poker.game.card;

public enum Suit {
    CLUBS("\u2663"),
    DIAMONDS("\u2666"),
    HEARTS("\u2665"),
    SPADES("\u2660");

    private final String suitValue;

    Suit(final String suitValue) {
        this.suitValue = suitValue;
    }

    public String getSuitValue() {
        return this.suitValue;
    }
}
