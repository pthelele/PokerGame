package com.epiuse.poker.game;

import com.epiuse.poker.game.card.Card;
import com.epiuse.poker.game.card.Rank;
import com.epiuse.poker.game.card.Suit;
import com.epiuse.poker.game.dealer.Dealer;
import com.epiuse.poker.game.player.Hand;
import com.epiuse.poker.game.player.PlayerHand;
import com.epiuse.poker.game.utils.HandEvaluator;
import com.epiuse.poker.game.utils.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Play {

    public static void main(String args[]) {
        ArrayList<Card> deck = new ArrayList<Card>();
        Card card;

        Suit[] suits = Suit.values();
        Rank[] rank = Rank.values();

        HandEvaluator handEvaluator = new HandEvaluator();
        PlayerHand playerHand = new PlayerHand();

        Util util = new Util();

        //Adding cards to the deck ArrayList
        for(int i = 0; i < 4; i ++) {
            for (int j = 0; j < 13; j++) {
                card = new Card(rank[j], suits[i]);
                deck.add(card);
            }
        }





        System.out.println("Enter number of cards to deal for player");
        Scanner input = new Scanner(System.in);
        int cardsToDeal = Integer.parseInt(input.nextLine());

            //Using the Library to shuffle the cards.
            Collections.shuffle(deck);
            Collections.shuffle(deck);

            System.out.print("Shuffling...Shuffling...Shuffling... Your hand: ");

            //Dealing cards from the deck
            for(int i = 0; i < cardsToDeal; i++) {
                playerHand.addCard(deck.get(i));
                deck.remove(i);
            }



            //sorting the hand
            util.sortHand(playerHand);


            String playersHand = "";
            //Classifying player's hand
            if(handEvaluator.isStraightFlush(playerHand)) {
                playersHand = Hand.STRAIGHTFLUSH.getPlayerRankValue();
            } else if(handEvaluator.isFourOfAKind(playerHand, cardsToDeal)) {
                playersHand = Hand.FOUROFAKIND.getPlayerRankValue();
            } else if (handEvaluator.isFullHouse(playerHand)){
                playersHand = Hand.FULLHOUSE.getPlayerRankValue();
            }else if(handEvaluator.isFlush(playerHand)) {
                playersHand = Hand.FLUSH.getPlayerRankValue();
            } else if(handEvaluator.isStraight(playerHand)) {
                playersHand = Hand.STRAIGHT.getPlayerRankValue();
            } else if(handEvaluator.isThreeOfAKind(playerHand, cardsToDeal)) {
                playersHand = Hand.THREEOFAKIND.getPlayerRankValue();
            } else if(handEvaluator.isTwoPair(playerHand, cardsToDeal)) {
                playersHand = Hand.TWOPAIR.getPlayerRankValue();
            } else if(handEvaluator.isOnePair(playerHand, cardsToDeal)) {
                playersHand = Hand.ONEPAIR.getPlayerRankValue();
            } else {
                playersHand = Hand.HIGHCARDS.getPlayerRankValue();
            }

            //Displaying results of the crads
            for(int i = 0; i < playerHand.getPlayerHand().size(); i++) {
                if(playerHand.getPlayerHand().get(i).getRank().getRankValue() == 11) {
                    System.out.print("J"
                            + playerHand.getPlayerHand().get(i).getSuit().getSuitValue());
                } else if (playerHand.getPlayerHand().get(i).getRank().getRankValue() == 12) {
                    System.out.print("Q"
                            + playerHand.getPlayerHand().get(i).getSuit().getSuitValue());
                } else if (playerHand.getPlayerHand().get(i).getRank().getRankValue() == 13) {
                    System.out.print("K"
                            + playerHand.getPlayerHand().get(i).getSuit().getSuitValue());
                } else if (playerHand.getPlayerHand().get(i).getRank().getRankValue() == 1){
                    System.out.print("ACE"
                            + playerHand.getPlayerHand().get(i).getSuit().getSuitValue());
                } else {
                    System.out.print(playerHand.getPlayerHand().get(i).getRank().getRankValue()
                            + playerHand.getPlayerHand().get(i).getSuit().getSuitValue());
                }
            }

            //Displaying what hand the player has got.
            System.out.println();
            System.out.println("You have: " + playersHand);
    }
}
