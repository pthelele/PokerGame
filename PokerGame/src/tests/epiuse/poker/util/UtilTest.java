package tests.epiuse.poker.util;

import com.epiuse.poker.game.card.Card;
import com.epiuse.poker.game.card.Rank;
import com.epiuse.poker.game.card.Suit;
import com.epiuse.poker.game.player.PlayerHand;
import com.epiuse.poker.game.utils.HandEvaluator;
import com.epiuse.poker.game.utils.Util;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.lang.reflect.Array;
import java.util.ArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UtilTest {
    private HandEvaluator handEvaluator;
    private PlayerHand play;
    private Util util;

    @BeforeAll
    void setHandObjects() {
        handEvaluator = new HandEvaluator();
        ArrayList<Card> cards = new ArrayList<>();

        play = new PlayerHand(cards);
        cards.add(new Card(Rank.JACK, Suit.DIAMONDS));
        cards.add(new Card(Rank.JACK, Suit.HEARTS));
        cards.add(new Card(Rank.JACK, Suit.DIAMONDS));
        cards.add(new Card(Rank.JACK, Suit.SPADES));
        cards.add(new Card(Rank.NINE, Suit.DIAMONDS));
    }

    @Test
    void sortHand() {

        Util util = new Util();
        try{
            util.sortHand(play);
            Assert.assertTrue(true);
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    void checkPair() {
        boolean isPaired;
        int [] rank = new int[5];

        for(int i = 0; i < play.getPlayerHand().size(); i ++) {
            rank[i] = play.getPlayerHand().get(i).getRank().getRankValue();
        }

        util = new Util();
        isPaired = util.checkPair(rank, 5) > 1 ? true : false;

        Assert.assertTrue(isPaired);
    }

}