package net.sliceofcode.psychic.poker.player.domain;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by pascr on 13.02.14.
 */
public class Game
{
    public static final int CARDS_PER_HAND_OR_DECK = 5;

    private final List<Card> hand = new LinkedList<>();
    private final List<Card> deck = new LinkedList<>();

    public static Game buildFromSetOfCard(List<Card> cards)
    {
        Game game = new Game();

        for (int i = 0; i < cards.size(); i++)
        {
            if (i < CARDS_PER_HAND_OR_DECK)
            {
                game.getHand().add(cards.get(i));
            } else
            {
                game.getDeck().add(cards.get(i));
            }

        }
        return game;

    }

    public List<Card> getHand()
    {
        return hand;
    }


    public List<Card> getDeck()
    {
        return deck;
    }


    public String getHandAsString()
    {
        return prettyList(hand);


    }

    public String gatDeckAsString()
    {
        return prettyList(deck);
    }

    private String prettyList(List<Card> cards)
    {
        StringBuilder sb = new StringBuilder();
        Iterator<Card> it = cards.iterator();

        for (; ; )
        {
            Card c = it.next();
            sb.append(c);
            if (!it.hasNext()) return sb.toString();
            sb.append(" ");
        }


    }
}
