package net.sliceofcode.psychic.poker.player;

import net.sliceofcode.psychic.poker.player.domain.Game;
import net.sliceofcode.psychic.poker.player.exceptions.InvalidLineException;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.fail;

/**
 * Created by pascal on 15.02.14.
 */
public class PsychicAdvisorTest
{
    private Game  game;
    private PsychicAdvisor advisor;

    @Before
    public void init()
    {
         advisor = new PsychicAdvisor();

    }

    @Test
    public void should_advice_straight_flush() throws InvalidLineException
    {
        game = Game.buildFromSetOfCard(new LineParser().parseLine("TH JH QC QD QS QH KH AH 2S 6S"));

        PsychicAdvisor advisor = new PsychicAdvisor();
        advisor.giveBestHandAdvice(game);
        fail("not implemented");
    }

    @Test
    public void should_advice_four_of_a_kind() throws InvalidLineException
    {
        game = Game.buildFromSetOfCard(new LineParser().parseLine("2H 2S 3H 3S 3C 2D 3D 6C 9C TH"));


        advisor.giveBestHandAdvice(game);
       fail("Not yet implemented");
    }
}
