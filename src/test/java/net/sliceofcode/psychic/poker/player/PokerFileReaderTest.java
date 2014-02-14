package net.sliceofcode.psychic.poker.player;

import net.sliceofcode.psychic.poker.player.domain.Game;
import net.sliceofcode.psychic.poker.player.exceptions.CannotParseFileException;
import net.sliceofcode.psychic.poker.player.exceptions.InvalidLineException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by pascr on 13.02.14.
 */
public class PokerFileReaderTest {
    public static final int GAMES_IN_FILE = 9;
    public static final int CARDS_IN_HAND_OR_DECK = 5;
    /**
     *
     */
    private LineParser spyLineParser;
    private PokerFileReader fileReader;

    @Before
    public void init() {
        spyLineParser = spy(new LineParser());
        fileReader = new PokerFileReader(spyLineParser);
    }

    @Test
    public void should_read_lines_and_pass_them_to_line_parser() throws InvalidLineException, CannotParseFileException {
        List<Game> games = fileReader.readPokerFile(getClass().getClassLoader().getResource("input.txt").getFile());
        //ensure the 9 lines were read from the sample file
        verify(spyLineParser, times(9)).parseLine(anyString());
        assertEquals(GAMES_IN_FILE, games.size());

        //check games have valid decks and hands
        for (int i = 0; i < GAMES_IN_FILE; i++) {
            Game game = games.get(i);
            assertNotNull("deck is null", game.getDeck());
            assertNotNull("hand is null", game.getHand());
            assertEquals("deck has wrong number of cards", CARDS_IN_HAND_OR_DECK, game.getDeck().size());
            assertEquals("hand has wrong number of cards", CARDS_IN_HAND_OR_DECK, game.getHand().size());
        }

    }

    ;

    @Test(expected = CannotParseFileException.class)
    public void should_throw_excpetion_if_file_not_found() throws InvalidLineException, CannotParseFileException {
        fileReader.readPokerFile("THIS_FILE_DOES_NOT_EXIST");

    }

    ;

}
