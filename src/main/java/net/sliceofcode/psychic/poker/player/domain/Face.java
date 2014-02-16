package net.sliceofcode.psychic.poker.player.domain;

import net.sliceofcode.psychic.poker.player.exceptions.InvalidFaceValueException;

/**
 * Created by pascr on 13.02.14.
 */
public enum Face
{
    TWO('2', 2), THREE('3', 3), FOUR('4', 5), FIVE('5', 7), SIX('6', 11), SEVEN('7', 13), EIGHT('8', 17), NINE('9', 19), TEN('T', 23), JACK('J', 29), QUEEN('Q', 31), KING('K', 37), ACE('A', 41);

    private final char value;
    private final int prime;

    Face(char c, int prime)
    {
        this.value = c;
        this.prime = prime;
    }

    public static Face build(char c) throws InvalidFaceValueException
    {

        for (Face f : Face.values())
        {
            if (f.getValue() == c) return f;

        }
        throw new InvalidFaceValueException("Invalid face value " + c);

    }

    public char getValue()
    {
        return value;
    }

    public int getPrime()
    {
        return prime;
    }
}
