package com.epiuse.poker.game.player;

public enum Hand {
    STRAIGHTFLUSH("Straight Flush"),
    FOUROFAKIND("Four of a Kind"),
    FULLHOUSE("Full House"),
    FLUSH("Flush"),
    STRAIGHT("Straight"),
    THREEOFAKIND("Three of a Kind"),
    TWOPAIR("Two Pair"),
    ONEPAIR("One Pair"),
    HIGHCARDS("High Cards")
    ;


    private final String playerRankValue;

    Hand(String playerRankValue) {
        this.playerRankValue = playerRankValue;
    }

    public String getPlayerRankValue() {
        return this.playerRankValue;
    }
}
