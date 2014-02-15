package net.sliceofcode.psychic.poker.player;

import net.sliceofcode.psychic.poker.player.domain.Card;
import net.sliceofcode.psychic.poker.player.domain.Game;
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

    public boolean giveBestHandAdvice(Game game)
    {

        List<List<Card>> possibleHands = buildPossibleHandCombination(game);

        int score = 0;

        for (List<Card> hand : possibleHands)
        {

            int handScore = calculateScore(hand);

            if (handScore > score)
            {
                score = handScore;
            }
        }


        return false;
    }

    private int calculateScore(List<Card> hand)
    {
        return 0;
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
