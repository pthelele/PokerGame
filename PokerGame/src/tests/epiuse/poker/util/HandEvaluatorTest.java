package tests.epiuse.poker.util;

import com.epiuse.poker.game.card.Card;
import com.epiuse.poker.game.card.Rank;
import com.epiuse.poker.game.card.Suit;
import com.epiuse.poker.game.player.PlayerHand;
import com.epiuse.poker.game.utils.HandEvaluator;
import com.epiuse.poker.game.utils.Util;
import org.junit.Assert;

import org.junit.jupiter.api.Test;


class HandEvaluatorTest {
    Util util = new Util();

    @Test
    void isStraightFlush() {
        HandEvaluator strFlushHand = new HandEvaluator();
        PlayerHand straightFlush = new PlayerHand();
        straightFlush.addCard(new Card(Rank.ACE, Suit.CLUBS));
        straightFlush.addCard(new Card(Rank.TWO, Suit.CLUBS));
        straightFlush.addCard(new Card(Rank.THREE, Suit.CLUBS));
        straightFlush.addCard(new Card(Rank.FIVE, Suit.CLUBS));
        straightFlush.addCard(new Card(Rank.FOUR, Suit.CLUBS));

        util.sortHand(straightFlush);

        Assert.assertTrue(strFlushHand.isStraightFlush(straightFlush));
    }

    @Test
    void isFourOfAKind() {
        HandEvaluator fourOfaKind = new HandEvaluator();
        PlayerHand play = new PlayerHand();

        play.addCard(new Card(Rank.FOUR, Suit.DIAMONDS));
        play.addCard(new Card(Rank.FOUR, Suit.HEARTS));
        play.addCard(new Card(Rank.FOUR, Suit.DIAMONDS));
        play.addCard(new Card(Rank.TWO, Suit.SPADES));
        play.addCard(new Card(Rank.FOUR, Suit.DIAMONDS));

        util.sortHand(play);

        Assert.assertTrue(fourOfaKind.isFourOfAKind(play, 5));
    }

    @Test
    void isFullHouse() {
        HandEvaluator fullHouse = new HandEvaluator();
        PlayerHand play = new PlayerHand();

        play.addCard(new Card(Rank.FOUR, Suit.DIAMONDS));
        play.addCard(new Card(Rank.FOUR, Suit.HEARTS));
        play.addCard(new Card(Rank.FOUR, Suit.DIAMONDS));
        play.addCard(new Card(Rank.SEVEN, Suit.SPADES));
        play.addCard(new Card(Rank.SEVEN, Suit.DIAMONDS));

        Assert.assertTrue(fullHouse.isFullHouse(play));
    }

    @Test
    void isFlush() {
        HandEvaluator handEvaluator = new HandEvaluator();
        PlayerHand play = new PlayerHand();

        play.addCard(new Card(Rank.KING, Suit.DIAMONDS));
        play.addCard(new Card(Rank.FIVE, Suit.DIAMONDS));
        play.addCard(new Card(Rank.SEVEN, Suit.DIAMONDS));
        play.addCard(new Card(Rank.SIX, Suit.DIAMONDS));
        play.addCard(new Card(Rank.EIGHT, Suit.DIAMONDS));

        Assert.assertTrue(handEvaluator.isFlush(play));

    }

    @Test
    void isRankSequential() {
        HandEvaluator sequential = new HandEvaluator();
        PlayerHand play = new PlayerHand();

        play.addCard(new Card(Rank.FOUR, Suit.DIAMONDS));
        play.addCard(new Card(Rank.FIVE, Suit.HEARTS));
        play.addCard(new Card(Rank.SEVEN, Suit.DIAMONDS));
        play.addCard(new Card(Rank.SIX, Suit.SPADES));
        play.addCard(new Card(Rank.EIGHT, Suit.DIAMONDS));

        util.sortHand(play);

        Assert.assertTrue(sequential.isRankSequential(play));
    }

    @Test
    void isStraight() {
        HandEvaluator straight = new HandEvaluator();
        PlayerHand play = new PlayerHand();

        play.addCard(new Card(Rank.FOUR, Suit.DIAMONDS));
        play.addCard(new Card(Rank.FIVE, Suit.HEARTS));
        play.addCard(new Card(Rank.SEVEN, Suit.DIAMONDS));
        play.addCard(new Card(Rank.SIX, Suit.SPADES));
        play.addCard(new Card(Rank.EIGHT, Suit.DIAMONDS));

        util.sortHand(play);

        Assert.assertTrue(straight.isRankSequential(play));
    }

    @Test
    void isThreeOFaKind() {
        HandEvaluator threeOfaKind = new HandEvaluator();
        PlayerHand play = new PlayerHand();

        play.addCard(new Card(Rank.TWO, Suit.HEARTS));
        play.addCard(new Card(Rank.SIX, Suit.CLUBS));
        play.addCard(new Card(Rank.EIGHT, Suit.DIAMONDS));
        play.addCard(new Card(Rank.SIX, Suit.HEARTS));
        play.addCard(new Card(Rank.SIX, Suit.SPADES));

        util.sortHand(play);

        Assert.assertTrue(threeOfaKind.isThreeOfAKind(play, 5));
    }

    @Test
    void isSuitMatching() {
        HandEvaluator handEvaluator = new HandEvaluator();
        PlayerHand play = new PlayerHand();

        play.addCard(new Card(Rank.FOUR, Suit.DIAMONDS));
        play.addCard(new Card(Rank.FOUR, Suit.HEARTS));
        play.addCard(new Card(Rank.SEVEN, Suit.DIAMONDS));
        play.addCard(new Card(Rank.FOUR, Suit.SPADES));
        play.addCard(new Card(Rank.FOUR, Suit.DIAMONDS));

        Assert.assertTrue(handEvaluator.isSuitMatching(play));
    }

    @Test
    void isTwoPair() {
        HandEvaluator twoPair = new HandEvaluator();
        PlayerHand play = new PlayerHand();

        play.addCard(new Card(Rank.FOUR, Suit.DIAMONDS));
        play.addCard(new Card(Rank.TWO, Suit.HEARTS));
        play.addCard(new Card(Rank.SEVEN, Suit.DIAMONDS));
        play.addCard(new Card(Rank.SEVEN, Suit.SPADES));
        play.addCard(new Card(Rank.FOUR, Suit.DIAMONDS));

        Assert.assertTrue(twoPair.isTwoPair(play, 5));
    }

    @Test
    void isOnePair() {
        HandEvaluator onePair = new HandEvaluator();
        PlayerHand play = new PlayerHand();

        play.addCard(new Card(Rank.ACE, Suit.HEARTS));
        play.addCard(new Card(Rank.SEVEN, Suit.HEARTS));
        play.addCard(new Card(Rank.SIX, Suit.SPADES));
        play.addCard(new Card(Rank.EIGHT, Suit.SPADES));
        play.addCard(new Card(Rank.KING, Suit.DIAMONDS));

        util.sortHand(play);
        Assert.assertTrue(onePair.isOnePair(play, 5));
    }
}
