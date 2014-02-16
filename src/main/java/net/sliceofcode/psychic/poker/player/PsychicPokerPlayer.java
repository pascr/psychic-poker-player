package net.sliceofcode.psychic.poker.player;

import net.sliceofcode.psychic.poker.player.domain.Game;
import net.sliceofcode.psychic.poker.player.exceptions.CannotParseFileException;

import java.util.List;

/**
 * Created by pascal on 16.02.14.
 */
public class PsychicPokerPlayer
{
    private final PsychicAdvisor advisor = new PsychicAdvisor();
    private final PokerFileReader pokerFileReader = new PokerFileReader(new LineParser());

    public void playFromInputFile(String file)
    {
        try
        {
            List<Game> gamesInFile = pokerFileReader.readPokerFile(file);

            for (Game game : gamesInFile)
            {
                //output Hand: TH JH QC QD QS Deck: QH KH AH 2S 6S Best hand: straight-flush

                System.out.println("Hand:" + game.getHandAsString() + " Deck:" + game.gatDeckAsString() + " Best hand: " + advisor.giveBestHandAdvice(game));
            }
        } catch (CannotParseFileException e)
        {
            System.out.println(e);
        }
    }
}
