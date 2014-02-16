package net.sliceofcode.psychic.poker.player.domain;

import net.sliceofcode.psychic.poker.player.exceptions.InvalidSuitValueException;

/**
 * Created by pascr on 13.02.14.
 */
public enum Suit
{
    CLUBS('C', 32768), DIAMONDS('D', 16384), HEARTS('H', 8192), SPADES('S', 4096);

    private final char value;

    private final int cactusKevSuitBits;

    Suit(char c, int l)
    {
        this.value = c;
        this.cactusKevSuitBits = l;
    }

    public static Suit build(char c) throws InvalidSuitValueException
    {

        for (Suit s : Suit.values())
        {
            if (s.getValue() == c) return s;

        }
        throw new InvalidSuitValueException("Invalid suit value " + c);

    }

    public char getValue()
    {
        return value;
    }

    public int getCactusKevFormatSuitBit()
    {
        return cactusKevSuitBits;
    }


}
