package net.sliceofcode.psychic.poker.player;

import net.sliceofcode.psychic.poker.player.domain.Game;
import net.sliceofcode.psychic.poker.player.domain.Hand;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by pascal on 15.02.14.
 */
public class PsychicAdvisorTest
{
    private Game game;
    private PsychicAdvisor advisor;

    @Before
    public void init()
    {
        advisor = new PsychicAdvisor();

    }

    @Test
    public void should_advice_straight_flush() throws Exception
    {
        game = createGame("TH JH QC QD QS QH KH AH 2S 6S");

        assertEquals(Hand.STRAIGHT_FLUSH,advisor.giveBestHandAdvice(game));

    }

    @Test
    public void should_advice_four_of_a_kind() throws Exception
    {
        game =  createGame("2H 2S 3H 3S 3C 2D 3D 6C 9C TH");

        assertEquals(Hand.FOUR_OF_A_KIND,advisor.giveBestHandAdvice(game));

    }

    @Test
    public void should_advice_full_house() throws Exception
    {
        game =  createGame("2H 2S 3H 3S 3C 2D 9C 3D 6C TH");

        assertEquals(Hand.FULL_HOUSE,advisor.giveBestHandAdvice(game));

    }

    @Test
    public void should_advice_flush() throws Exception
    {
        game =  createGame("2H AD 5H AC 7H AH 6H 9H 4H 3C");

        assertEquals(Hand.FLUSH,advisor.giveBestHandAdvice(game));

    }

    @Test
    public void should_advice_straight() throws Exception
    {
        game =  createGame("AC 2D 9C 3S KD 5S 4D KS AS 4C");

        assertEquals(Hand.STRAIGHT,advisor.giveBestHandAdvice(game));

    }

    @Test
    public void should_advice_tree_of_a_kind() throws Exception
    {
        game =  createGame("KS AH 2H 3C 4H KC 2C TC 2D AS");

        assertEquals(Hand.THREE_OF_A_KIND,advisor.giveBestHandAdvice(game));

    }

    @Test
    public void should_advice_two_pairs() throws Exception
    {
        game =  createGame("AH 2C 9S AD 3C QH KS JS JD KD");

        assertEquals(Hand.TWO_PAIRS,advisor.giveBestHandAdvice(game));

    }

    @Test
    public void should_advice_one_pair() throws Exception
    {
        game =  createGame("6C 9C 8C 2D 7C 2H TC 4C 9S AH");

        assertEquals(Hand.ONE_PAIR,advisor.giveBestHandAdvice(game));

    }

    @Test
    public void should_advice_highest_card() throws Exception
    {
        game =  createGame("3D 5S 2H QD TD 6S KH 9H AD QH");

        assertEquals(Hand.HIGHEST_CARD,advisor.giveBestHandAdvice(game));

    }

    private Game createGame(String s) throws Exception
    {
        return Game.buildFromSetOfCard(new LineParser().parseLine(s));
    }
}
