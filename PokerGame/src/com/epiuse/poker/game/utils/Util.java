package com.epiuse.poker.game.utils;


import com.epiuse.poker.game.card.Card;
import com.epiuse.poker.game.player.PlayerHand;

public class Util {

    public void sortHand(PlayerHand playerHand) {
        Card tempCard;

        for(int i = 0; i < playerHand.getPlayerHand().size(); i++) {
            for(int j = 1; j < (playerHand.getPlayerHand().size()); j++) {
                if(playerHand.getPlayerHand().get(j-1).getRank().getRankValue() > playerHand.getPlayerHand().get(j).getRank().getRankValue()) {
                    tempCard = playerHand.getPlayerHand().get(j-1);
                    playerHand.getPlayerHand().set(j-1, playerHand.getPlayerHand().get(j));
                    playerHand.getPlayerHand().set(j, tempCard);
                }
            }
        }
    }

    public int checkPair(int[] arr, int numCards) {
        int pair = 0;

        for(int i = 0; i < arr.length; i++) {
            for(int j = 1; j < arr.length; j++) {
                if(arr[i] == arr[j]) {
                    pair++;
                }
            }
            if(pair == 4) {
                break;
            } else if(pair == 3) {
                break;
            } else if (pair == 2) {
                break;
            } else {
                pair = 0;
            }
        }
        return pair;
    }
}
