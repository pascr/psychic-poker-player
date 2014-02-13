package net.sliceofcode.psychic.poker.player;

import net.sliceofcode.psychic.poker.player.exceptions.CannotParseFileException;
import net.sliceofcode.psychic.poker.player.exceptions.InvalidLineException;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by pascr on 13.02.14.
 */
public class PokerFileReaderTest
{
    /**
     *
     */
    private LineParser mockLineParser;
    private PokerFileReader fileReader;

    @Before
    public void init(){
         mockLineParser = mock(LineParser.class);
         fileReader = new PokerFileReader(mockLineParser);
    }

    @Test
    public void  should_read_lines_and_pass_them_to_line_parser() throws InvalidLineException, CannotParseFileException
    {
        fileReader.readPokerFile(getClass().getClassLoader().getResource("input.txt").getFile());
        //ensure the 9 lines were read from the sample file
        verify(mockLineParser,times(9)).parseLine(anyString());

    };

    @Test(expected = CannotParseFileException.class)
    public void  should_throw_excpetion_if_file_not_found() throws InvalidLineException, CannotParseFileException
    {
        fileReader.readPokerFile("THIS_FILE_DOES_NOT_EXIST");

    };

}
