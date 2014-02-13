package net.sliceofcode.psychic.poker.player;

/**
 * Created by pascr on 13.02.14.
 */
public class Card
{
    private final Face face;
    private final Suit suit;

    public Card(Face face, Suit suit) {
        this.face = face;
        this.suit = suit;
    }

    public Face getFace() {
        return face;
    }

    public Suit getSuit() {
        return suit;
    }


}
