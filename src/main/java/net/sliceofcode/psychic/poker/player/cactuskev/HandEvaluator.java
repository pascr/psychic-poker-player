package net.sliceofcode.psychic.poker.player.cactuskev;

import net.sliceofcode.psychic.poker.player.cactuskev.lookup.FlushesLookup;
import net.sliceofcode.psychic.poker.player.cactuskev.lookup.ProductsLookup;
import net.sliceofcode.psychic.poker.player.cactuskev.lookup.UniqueLookup;
import net.sliceofcode.psychic.poker.player.cactuskev.lookup.ValuesLookup;

/**
 * Created by pascr on 16.02.14.
 *
 * Basic java port of Cactus Kev's Poker Hand Evaluator
 * (http://www.suffecool.net/poker/evaluator.html)
 */
public class HandEvaluator
{
    private static HandEvaluator instance = null;

    private HandEvaluator()
    {
    }

    public static HandEvaluator getInstance()
    {
        if (instance == null)
            instance = new HandEvaluator();
        return instance;
    }


    // perform a binary search on a pre-sorted array
    //
    private int getPrimesProductIndex(long key)
    {
        int low = 0, high = 4887, mid;

        while (low <= high)
        {
            mid = (high + low) >> 1;      // divide by two
            if (key < ProductsLookup.products[mid])
                high = mid - 1;
            else if (key > ProductsLookup.products[mid])
                low = mid + 1;
            else
                return (mid);
        }

        return (-1);
    }


    /**
     * Evaluates the hand score
     * @param c1 bit representation of the first card
     * @param c2 bit representation of the second card
     * @param c3 bit representation of the third card
     * @param c4 bit representation of the fourth card
     * @param c5 bit representation of the fifth card
     * @return score
     */
    public int eval_5cards(int c1, int c2, int c3, int c4, int c5)
    {

        int q = (c1 | c2 | c3 | c4 | c5) >> 16;


        // check for Flushes and Straight Flushes
        if ((c1 & c2 & c3 & c4 & c5 & 0xF000) != 0){
            return FlushesLookup.flushes[q];
        }

        // check for Straights and High Card hands
        short s = UniqueLookup.unique5[q];
        if (s != 0){
            return s;
        }

        // let's do it the hard way
        q = (c1 & 0xFF) * (c2 & 0xFF) * (c3 & 0xFF) * (c4 & 0xFF) * (c5 & 0xFF);
        q = getPrimesProductIndex(q);

        return ValuesLookup.values[q];


    }


}
