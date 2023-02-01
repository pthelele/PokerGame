package com.epiuse.poker.game.card;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cardDeck = new ArrayList<>();
    private Card card;

    public Deck() {

    }

    public void createCardDeck() {
        Suit[] suits = Suit.values();
        Rank[] rank = Rank.values();

        for(int i = 0; i < 4; i ++) {
            for (int j = 0; j < 13; j++) {
                card = new Card(rank[j], suits[i]);
                cardDeck.add(card);
            }
        }
    }

    public ArrayList<Card> getCardDeck() {
        return  this.cardDeck;
    }

    public void shuffleDeck() {
        Collections.shuffle(cardDeck);
    }
}
