package com.epiuse.poker.game.utils;

import com.epiuse.poker.game.player.PlayerHand;


public class HandEvaluator {

    public HandEvaluator() {

    }

    public boolean isStraightFlush(PlayerHand playerHand) {
        boolean isStraightFlush = false;
        if(isRankSequential(playerHand) && isSuitMatching(playerHand)) {
            isStraightFlush = true;
        }
        return isStraightFlush;
    }

    public boolean isFourOfAKind(PlayerHand playerHand, int numCards) {
        boolean isFourOfAKind = false;
        int [] rank = new int[numCards];

        for(int i = 0; i < playerHand.getPlayerHand().size();  i++) {
            rank[i] = playerHand.getPlayerHand().get(i).getRank().getRankValue();
        }

        Util util = new Util();

        if( util.checkPair(rank, numCards) == 4) {
            isFourOfAKind = true;
        }

        return isFourOfAKind;
    }

    public boolean isFullHouse(PlayerHand playerHand) {
        boolean isFullHouse;

        int[] rank = new int[5]; //A full house will only work with 5 cards dealt to player

        for(int i = 0; i < rank.length; i ++) {
            rank[i] = playerHand.getPlayerHand().get(i).getRank().getRankValue();
        }

        int countPair = 1;
        int numCompare = playerHand.getPlayerHand().get(0).getRank().getRankValue();

        for(int i =0; i < rank.length; i ++) {
            if(numCompare == playerHand.getPlayerHand().get(i).getRank().getRankValue()){
                countPair ++;
            } else {
                numCompare = playerHand.getPlayerHand().get(i).getRank().getRankValue();
            }
        }

        isFullHouse = countPair == 5 ? true : false;

        return isFullHouse;
    }

    public boolean isFlush(PlayerHand playerHand) {
        boolean isFlush = false;

        if(isSuitMatching(playerHand) && !isRankSequential(playerHand)) {
            isFlush = true;
        }

        return isFlush;
    }

    public boolean isStraight(PlayerHand playerHand) {
        boolean isStraight = false;

        if(!isSuitMatching(playerHand) && isRankSequential(playerHand)) {
            isStraight = true;
        }
        return isStraight;
    }

    public boolean isThreeOfAKind(PlayerHand playerHand, int numCards) {
        boolean isThreeOfAKind = false;
        int [] rank = new int[numCards];

        for(int i = 0; i < playerHand.getPlayerHand().size();  i++) {
            rank[i] = playerHand.getPlayerHand().get(i).getRank().getRankValue();
        }

        Util util = new Util();

        if( util.checkPair(rank, numCards) == 3) {
            isThreeOfAKind = true;
        }

        return isThreeOfAKind;
    }

    public boolean isOnePair(PlayerHand playerHand, int numCards) {
        boolean isOnePair = false;
        int [] rank = new int[numCards];

        for(int i = 0; i < playerHand.getPlayerHand().size();  i++) {
            rank[i] = playerHand.getPlayerHand().get(i).getRank().getRankValue();
        }

        Util util = new Util();

        if( util.checkPair(rank, numCards) == 2) {
            isOnePair = true;
        }

        return isOnePair;

    }

    public boolean isTwoPair(PlayerHand playerHand, int numCards) {

        int[] rank = new int[numCards];

        for (int i = 0; i < playerHand.getPlayerHand().size(); i++) {
            rank[i] = playerHand.getPlayerHand().get(i).getRank().getRankValue();
        }
        boolean pairFound = false;
        int foundPair = 15;

        for (int i = 0; i < rank.length; i++) {
            if (rank[i] == foundPair) {
                continue;
            }
            for (int u = i + 1; u < rank.length; u++) {
                if (rank[i] == rank[u]) {
                    if (foundPair == 15) {
                        foundPair = rank[i];
                    } else {
                        pairFound = true;
                        break;
                    }
                }
            }


        }
        return pairFound;
    }

    public boolean isRankSequential(PlayerHand playerHand) {
        boolean isRankSequential = true;

        for(int i = 0; i < playerHand.getPlayerHand().size() - 1; i ++) {
            if(playerHand.getPlayerHand().get(i).getRank().getRankValue() != playerHand.getPlayerHand().get(i + 1).getRank().getRankValue() - 1){
                isRankSequential = false;
                break;
            }
        }

        return isRankSequential;
    }

    public boolean isSuitMatching(PlayerHand playerHand){
        boolean isSuitMatching = true;
        String suit = playerHand.getPlayerHand().get(0).getSuit().getSuitValue();

        for(int i = 1; i < playerHand.getPlayerHand().size(); i ++) {
            if(!suit.equalsIgnoreCase(playerHand.getPlayerHand().get(i).getSuit().getSuitValue())) {
                isSuitMatching = false;
                break;
            }
        }

        return isSuitMatching;
    }

}
