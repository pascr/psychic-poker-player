package net.sliceofcode.psychic.poker.player;

/**
 * Created by pascr on 13.02.14.
 */
public enum Suit
{
   CLUBS('C'),DIAMONDS('D'),HEARTS('H'),SPADES('S');

    private final char value;

    Suit(char c) {
        this.value = c;
    }

    public static Suit build(char c)
    {

        for (Suit s:Suit.values()){
            if(s.getValue() == c) return s ;

        }
        return null;

    }

    public char getValue() {
        return value;
    }


}
