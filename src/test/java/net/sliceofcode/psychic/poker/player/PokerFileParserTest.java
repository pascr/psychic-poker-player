package net.sliceofcode.psychic.poker.player;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

/**
 * Created by pascr on 13.02.14.
 */
public class PokerFileParserTest
{
    private static String A_VALID_INPUT_LINE= "TH JH QC DQ QS QH KH AH 2S 6S";
    private static String AN_INVALID_INPUT_LINE= "XX XX XX XX XX XX XX XX XX XX";

    private LineParser parser;
    @Before
    public void init()
    {
        LineParser parser = new LineParser();
    }

    @Test
    public void should_parse_one_line_and_extract_fields()
    {
        parser.parseLine(A_VALID_INPUT_LINE);
        assertTrue(false);
    }

    @Test (expected = InvalidLineException.class)
    public void should_fail_if_line_is_in_wrong_format()
    {
        parser.parseLine(AN_INVALID_INPUT_LINE);
        assertTrue(false);
    }
}
