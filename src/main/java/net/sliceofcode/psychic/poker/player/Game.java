package net.sliceofcode.psychic.poker.player;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by pascr on 13.02.14.
 */
public class Game
{
    private final Set<Card> hand = new HashSet<Card>();
    private final Set<Card> deck = new HashSet<Card>();

    public static Game buildFromSetOfCard(List<Card> cards)
    {
        Game game = new Game();
        for (int i=0;i<cards.size();i++)
        {
            if(i<5){
                game.getHand().add(cards.get(i));
            }else{
                game.getDeck().add(cards.get(i));
            }

        }
        return game;

    }

    public Set<Card> getHand() {
        return hand;
    }



    public Set<Card> getDeck() {
        return deck;
    }

}
