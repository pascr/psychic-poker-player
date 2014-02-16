package net.sliceofcode.psychic.poker.player.domain;

/**
 * Created by pascr on 13.02.14.
 */
public class Card
{
    private final Face face;
    private final Suit suit;

    public Card(Face face, Suit suit)
    {
        this.face = face;
        this.suit = suit;
    }

    public Face getFace()
    {
        return face;
    }


    public Suit getSuit()
    {
        return suit;
    }

    /**
     * Cactus kev's card representation
     * @return the int value of the card
     */
    public int getAsCactusKevFormat()
    {
        return face.getPrime() | face.ordinal() << 8 | suit.getCactusKevFormatSuitBit() | 1 << (16 + face.ordinal());
    }

    @Override
    public String toString()
    {
        return String.valueOf(face.getValue()) + String.valueOf(suit.getValue());

    }
}
