package net.sliceofcode.psychic.poker.player;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;

/**
 * Created by pascal on 17.02.14.
 */
public class MainTest
{

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void init() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }


    @After
    public void clean() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void should_fail_if_no_args(){
        String[] args = {};
        Main.main(args);
        assertEquals("Usage : psychic-poker-player <input file>\n",outContent.toString());
    }

    @Test
    public void should_work_with_valid_file(){
        String[] args = {getClass().getClassLoader().getResource("input.txt").getFile()};
        Main.main(args);
        assertTrue(outContent.toString().contains("Deck:"));
        assertTrue(outContent.toString().contains("Hand:"));
    }

    @Test
    public void should_fail_with_invalid_file(){
        String[] args = {"invalid_file.invalid"};
        Main.main(args);
        assertFalse(errContent.toString().isEmpty());

    }
}
