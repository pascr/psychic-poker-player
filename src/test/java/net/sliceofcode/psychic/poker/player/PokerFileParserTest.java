package net.sliceofcode.psychic.poker.player;

import net.sliceofcode.psychic.poker.player.domain.Card;
import net.sliceofcode.psychic.poker.player.exceptions.InvalidFaceValueException;
import net.sliceofcode.psychic.poker.player.exceptions.InvalidLineException;
import net.sliceofcode.psychic.poker.player.exceptions.InvalidSuitValueException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by pascr on 13.02.14.
 */
public class PokerFileParserTest
{
    public static final int CARDS_PER_GAME = 10;
    private static String A_VALID_INPUT_LINE = "TH JH QC QD QS QH KH AH 2S 6S";
    private static String AN_INVALID_INPUT_LINE = "XX XX XX XX XX XX XX XX XX XX";

    private LineParser parser;

    @Before
    public void init()
    {
        parser = new LineParser();
    }

    @Test
    public void should_parse_one_line_and_extract_fields() throws InvalidLineException, InvalidFaceValueException, InvalidSuitValueException
    {
        List<Card> result = parser.parseLine(A_VALID_INPUT_LINE);
        assertNotNull(result);
        assertEquals("Extracted cards does not match", CARDS_PER_GAME, result.size());

    }

    @Test(expected = InvalidLineException.class)
    public void should_fail_if_line_is_in_wrong_format() throws InvalidLineException, InvalidFaceValueException, InvalidSuitValueException
    {
        parser.parseLine(AN_INVALID_INPUT_LINE);
    }
}
