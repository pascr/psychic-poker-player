package net.sliceofcode.psychic.poker.player;

import net.sliceofcode.psychic.poker.player.cactuskev.HandEvaluator;
import net.sliceofcode.psychic.poker.player.cactuskev.HandScorer;
import net.sliceofcode.psychic.poker.player.domain.Card;
import net.sliceofcode.psychic.poker.player.domain.Game;
import net.sliceofcode.psychic.poker.player.domain.Hand;
import org.paukov.combinatorics.Factory;
import org.paukov.combinatorics.Generator;
import org.paukov.combinatorics.ICombinatoricsVector;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by pascr on 14.02.14.
 */
public class PsychicAdvisor
{

    private static final int MAX_CARD_WITHDRAWN_FROM_HAND = 5;
    public static final int WORST_SCORE = 7462;

    public Hand giveBestHandAdvice(Game game)
    {
        List<List<Card>> possibleHands = buildPossibleHandCombination(game);

        //worst hand in Cactus kev Evaluation algorithm
        int score = WORST_SCORE;

        for (List<Card> hand : possibleHands)
        {

            int handScore = calculateScore(hand);

            if (handScore < score && handScore > 0)
            {
                score = handScore;
            }
        }

        return HandScorer.getHandFromScoreValue(score);
    }

    private int calculateScore(List<Card> hand)
    {

        return HandEvaluator.getInstance().eval_5cards(hand.get(0).getAsCactusKevFormat(), hand.get(1).getAsCactusKevFormat(), hand.get(2).getAsCactusKevFormat(), hand.get(3).getAsCactusKevFormat(), hand.get(4).getAsCactusKevFormat());

    }

    private List<List<Card>> buildPossibleHandCombination(Game game)
    {
        List<List<Card>> possibleCombination = new LinkedList<>();
        for (int i = 0; i < MAX_CARD_WITHDRAWN_FROM_HAND; i++)
        {
            ICombinatoricsVector<Card> initialVector = Factory.createVector(game.getHand());

            // Create a simple combination generator to generate 5 to 1 card combinations of the initial vector
            Generator<Card> gen = Factory.createSimpleCombinationGenerator(initialVector, MAX_CARD_WITHDRAWN_FROM_HAND - i);

            // keep all possible combinations
            for (ICombinatoricsVector<Card> combination : gen)
            {
                for (int j = 0; MAX_CARD_WITHDRAWN_FROM_HAND != combination.getSize(); j++)
                {
                    //complete with deck card in order
                    combination.addValue(game.getDeck().get(j));
                }
                possibleCombination.add(combination.getVector());
            }

        }

        //the deck should be taken into account as last hand
        List<Card> deckAsList = new LinkedList();
        deckAsList.addAll(game.getDeck());
        possibleCombination.add(deckAsList);

        return possibleCombination;
    }
}
