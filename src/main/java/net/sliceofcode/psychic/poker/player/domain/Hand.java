package net.sliceofcode.psychic.poker.player.domain;

/**
 * Created by pascr on 16.02.14.
 */
public enum Hand
{

    STRAIGHT_FLUSH("straight-flush"), FOUR_OF_A_KIND("four-of-a-kind"), FULL_HOUSE("full-house"), FLUSH("flush"),
    STRAIGHT("straight"), THREE_OF_A_KIND("three-of-a-kind"), TWO_PAIRS("two-pairs"), ONE_PAIR("one-pair"),
    HIGHEST_CARD("highest-card");

    private String name;

    Hand(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name;
    }
}
