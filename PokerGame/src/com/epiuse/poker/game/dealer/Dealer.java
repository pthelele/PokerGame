package com.epiuse.poker.game.dealer;

import com.epiuse.poker.game.card.Card;

import java.util.ArrayList;

public class Dealer {
    private ArrayList<Card> cards = new ArrayList<Card>();

    public Dealer() {

    }

    public void setDeck(Card card) {
        cards.add(card);
    }

    public ArrayList<Card> getDeck() {
        return this.cards;
    }
}
