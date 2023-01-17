package com.epiuse.poker.game.player;

import com.epiuse.poker.game.card.Card;

import java.util.ArrayList;

public class PlayerHand {
    private ArrayList<Card> playerHand = new ArrayList<Card>();

    public PlayerHand () {

    }

    public void addCard(Card card) {
        playerHand.add(card);
    }

    public ArrayList<Card> getPlayerHand() {
        return this.playerHand;
    }
}
