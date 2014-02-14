package net.sliceofcode.psychic.poker.player;

/**
 * Created by pascr on 13.02.14.
 */
public enum Face {

    KING('K'),QUEEN('Q'),JACK('J'),TEN('T'),NINE('9'),EIGHT('8'),SEVEN('7'),SIX('6'),FIVE('5'),FOUR('4'),THREE('3'),TWO('2'),ACE('A');

    private final char value;

    Face(char c) {
       this.value=c;
    }

    public static Face build(char c)
    {

        for (Face f:Face.values()){
            if(f.getValue() == c) return f ;

        }
        return null;

    }

    public char getValue() {
        return value;
    }
}
