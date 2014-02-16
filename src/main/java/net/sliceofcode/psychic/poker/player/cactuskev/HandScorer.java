package net.sliceofcode.psychic.poker.player.cactuskev;

import net.sliceofcode.psychic.poker.player.domain.Hand;

/**
 * Created by pascal on 16.02.14.
 *
 * Basic java port of Cactus Kev's Poker Hand Evaluator
 *
 * (http://www.suffecool.net/poker/evaluator.html)
 */
public class HandScorer
{
    /**
     * Returns the hand score based on a score value (lowest is better)
     * @param value the score value
     * @return Hand score
     */
    public static Hand getHandFromScoreValue(int value)
    {
        if (value > 6185) return (Hand.HIGHEST_CARD);        // 1277 high card
        if (value > 3325) return (Hand.ONE_PAIR);         // 2860 one pair
        if (value > 2467) return (Hand.TWO_PAIRS);         //  858 two pair
        if (value > 1609) return (Hand.THREE_OF_A_KIND);  //  858 three-kind
        if (value > 1599) return (Hand.STRAIGHT);         //   10 straights
        if (value > 322) return (Hand.FLUSH);            // 1277 flushes
        if (value > 166) return (Hand.FULL_HOUSE);       //  156 full house
        if (value > 10) return (Hand.FOUR_OF_A_KIND);   //  156 four-kind
        return (Hand.STRAIGHT_FLUSH);                   //   10 straight-flushes
    }
}
