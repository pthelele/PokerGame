package tests.epiuse.poker.util;

import com.epiuse.poker.game.card.Card;
import com.epiuse.poker.game.card.Rank;
import com.epiuse.poker.game.card.Suit;
import com.epiuse.poker.game.player.PlayerHand;
import com.epiuse.poker.game.utils.HandEvaluator;
import com.epiuse.poker.game.utils.Util;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class HandEvaluatorTest {
    Util util = new Util();

    @Test
    void isStraightFlush() {
        HandEvaluator strFlushHand = new HandEvaluator();
        ArrayList<Card> cards = new ArrayList<>();

        cards.add(new Card(Rank.ACE, Suit.CLUBS));
        cards.add(new Card(Rank.TWO, Suit.CLUBS));
        cards.add(new Card(Rank.THREE, Suit.CLUBS));
        cards.add(new Card(Rank.FIVE, Suit.CLUBS));
        cards.add(new Card(Rank.FOUR, Suit.CLUBS));

        PlayerHand straightFlush = new PlayerHand(cards);

        util.sortHand(straightFlush);

        Assert.assertTrue(strFlushHand.isStraightFlush(straightFlush));
    }

    @Test
    void isFourOfAKind() {
        HandEvaluator fourOfaKind = new HandEvaluator();
        ArrayList<Card> cards = new ArrayList<>();

        cards.add(new Card(Rank.FOUR, Suit.DIAMONDS));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));
        cards.add(new Card(Rank.FOUR, Suit.DIAMONDS));
        cards.add(new Card(Rank.TWO, Suit.SPADES));
        cards.add(new Card(Rank.FOUR, Suit.DIAMONDS));

        PlayerHand play = new PlayerHand(cards);

        util.sortHand(play);

        Assert.assertTrue(fourOfaKind.isFourOfAKind(play, 5));
    }

    @Test
    void isFullHouse() {
        HandEvaluator fullHouse = new HandEvaluator();
        ArrayList<Card> cards = new ArrayList<>();


        cards.add(new Card(Rank.FOUR, Suit.DIAMONDS));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));
        cards.add(new Card(Rank.FOUR, Suit.DIAMONDS));
        cards.add(new Card(Rank.SEVEN, Suit.SPADES));
        cards.add(new Card(Rank.SEVEN, Suit.DIAMONDS));

        PlayerHand play = new PlayerHand(cards);

        Assert.assertTrue(fullHouse.isFullHouse(play));
    }

    @Test
    void isFlush() {
        HandEvaluator handEvaluator = new HandEvaluator();
        ArrayList<Card> cards = new ArrayList<>();

        cards.add(new Card(Rank.KING, Suit.DIAMONDS));
        cards.add(new Card(Rank.FIVE, Suit.DIAMONDS));
        cards.add(new Card(Rank.SEVEN, Suit.DIAMONDS));
        cards.add(new Card(Rank.SIX, Suit.DIAMONDS));
        cards.add(new Card(Rank.EIGHT, Suit.DIAMONDS));

        PlayerHand play = new PlayerHand(cards);

        Assert.assertTrue(handEvaluator.isFlush(play));

    }

    @Test
    void isRankSequential() {
        HandEvaluator sequential = new HandEvaluator();
        ArrayList<Card> cards = new ArrayList<>();

        cards.add(new Card(Rank.FOUR, Suit.DIAMONDS));
        cards.add(new Card(Rank.FIVE, Suit.HEARTS));
        cards.add(new Card(Rank.SEVEN, Suit.DIAMONDS));
        cards.add(new Card(Rank.SIX, Suit.SPADES));
        cards.add(new Card(Rank.EIGHT, Suit.DIAMONDS));

        PlayerHand play = new PlayerHand(cards);

        util.sortHand(play);

        Assert.assertTrue(sequential.isRankSequential(play));
    }

    @Test
    void isStraight() {
        HandEvaluator straight = new HandEvaluator();
        ArrayList<Card> cards = new ArrayList<>();

        cards.add(new Card(Rank.FOUR, Suit.DIAMONDS));
        cards.add(new Card(Rank.FIVE, Suit.HEARTS));
        cards.add(new Card(Rank.SEVEN, Suit.DIAMONDS));
        cards.add(new Card(Rank.SIX, Suit.SPADES));
        cards.add(new Card(Rank.EIGHT, Suit.DIAMONDS));

        PlayerHand play = new PlayerHand(cards);

        util.sortHand(play);

        Assert.assertTrue(straight.isRankSequential(play));
    }

    @Test
    void isThreeOFaKind() {
        HandEvaluator threeOfaKind = new HandEvaluator();
        ArrayList<Card> cards = new ArrayList<>();

        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        cards.add(new Card(Rank.SIX, Suit.CLUBS));
        cards.add(new Card(Rank.EIGHT, Suit.DIAMONDS));
        cards.add(new Card(Rank.SIX, Suit.HEARTS));
        cards.add(new Card(Rank.SIX, Suit.SPADES));

        PlayerHand play = new PlayerHand(cards);

        util.sortHand(play);

        Assert.assertTrue(threeOfaKind.isThreeOfAKind(play, 5));
    }

    @Test
    void isSuitMatching() {
        HandEvaluator handEvaluator = new HandEvaluator();
        ArrayList<Card> cards = new ArrayList<>();


        cards.add(new Card(Rank.FOUR, Suit.DIAMONDS));
        cards.add(new Card(Rank.FOUR, Suit.HEARTS));
        cards.add(new Card(Rank.SEVEN, Suit.DIAMONDS));
        cards.add(new Card(Rank.FOUR, Suit.SPADES));
        cards.add(new Card(Rank.FOUR, Suit.DIAMONDS));

        PlayerHand play = new PlayerHand(cards);

        Assert.assertTrue(handEvaluator.isSuitMatching(play));
    }

    @Test
    void isTwoPair() {
        HandEvaluator twoPair = new HandEvaluator();
        ArrayList<Card> cards = new ArrayList<>();

        cards.add(new Card(Rank.FOUR, Suit.DIAMONDS));
        cards.add(new Card(Rank.TWO, Suit.HEARTS));
        cards.add(new Card(Rank.SEVEN, Suit.DIAMONDS));
        cards.add(new Card(Rank.SEVEN, Suit.SPADES));
        cards.add(new Card(Rank.FOUR, Suit.DIAMONDS));

        PlayerHand play = new PlayerHand(cards);

        Assert.assertTrue(twoPair.isTwoPair(play, 5));
    }

    @Test
    void isOnePair() {
        HandEvaluator onePair = new HandEvaluator();
        ArrayList<Card> cards = new ArrayList<>();

        cards.add(new Card(Rank.ACE, Suit.HEARTS));
        cards.add(new Card(Rank.SEVEN, Suit.HEARTS));
        cards.add(new Card(Rank.SIX, Suit.SPADES));
        cards.add(new Card(Rank.EIGHT, Suit.SPADES));
        cards.add(new Card(Rank.KING, Suit.DIAMONDS));

        PlayerHand play = new PlayerHand(cards);

        util.sortHand(play);
        Assert.assertTrue(onePair.isOnePair(play, 5));
    }
}
