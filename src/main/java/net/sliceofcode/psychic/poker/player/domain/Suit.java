package net.sliceofcode.psychic.poker.player.domain;

import net.sliceofcode.psychic.poker.player.exceptions.InvalidSuitValueException;

/**
 * Created by pascr on 13.02.14.
 */
public enum Suit
{
    CLUBS('C', Constants.CACTUS_KEV_CLUBS_BITS), DIAMONDS('D', Constants.CACTUS_KEV_DIAMOND_BITS), HEARTS('H', Constants.CACTUS_KEV_HEARTS_BITS), SPADES('S', Constants.CACTUS_KEV_SPADES_BITS);

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


    private static class Constants
    {
        public static final int CACTUS_KEV_CLUBS_BITS = 32768;
        public static final int CACTUS_KEV_DIAMOND_BITS = 16384;
        public static final int CACTUS_KEV_HEARTS_BITS = 8192;
        public static final int CACTUS_KEV_SPADES_BITS = 4096;
    }
}
