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

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UtilTest {
    private HandEvaluator handEvaluator;
    private PlayerHand play;
    private Util util;

    @BeforeAll
    void setHandObjects() {
        handEvaluator = new HandEvaluator();
        play = new PlayerHand();
        play.addCard(new Card(Rank.JACK, Suit.DIAMONDS));
        play.addCard(new Card(Rank.JACK, Suit.HEARTS));
        play.addCard(new Card(Rank.JACK, Suit.DIAMONDS));
        play.addCard(new Card(Rank.JACK, Suit.SPADES));
        play.addCard(new Card(Rank.NINE, Suit.DIAMONDS));
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