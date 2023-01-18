package com.epiuse.poker.game.player;

import com.epiuse.poker.game.card.Card;
import com.epiuse.poker.game.card.Deck;

import java.util.ArrayList;

public class PlayerHand {
    private ArrayList<Card> playerHand = new ArrayList<Card>();

    public PlayerHand () {

    }

    public PlayerHand(ArrayList<Card> card) {
        playerHand = card;
    }

    //Dealing the cards to the player
    //Removing the existing hand if any.
    //putting back cards from the hand to the deck
    public void dealCard(Deck cardDeck, int numberOfDealtCards) {
        //Remove from hand, and add to the deck
        if(playerHand.size() > 0) {
            for(int i = 0; i < playerHand.size(); i ++) {
                cardDeck.getCardDeck().add(playerHand.get(0));
                playerHand.remove(0);
            }
        }

        //Dealing to the player
        for(int i = 0; i < numberOfDealtCards; i ++) {
            playerHand.add(cardDeck.getCardDeck().get(i));
        }
    }

    public ArrayList<Card> getPlayerHand() {
        return this.playerHand;
    }
}
