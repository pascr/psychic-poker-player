package net.sliceofcode.psychic.poker.player;

import net.sliceofcode.psychic.poker.player.exceptions.CannotParseFileException;
import net.sliceofcode.psychic.poker.player.exceptions.InvalidLineException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by pascr on 13.02.14.
 */
public class PokerFileReader {

    private final LineParser lineParser;

    public PokerFileReader(LineParser parser)
    {
        this.lineParser =parser;
    }

    public void readPokerFile(String file) throws CannotParseFileException {

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String strLine;

            while ((strLine = br.readLine()) != null) {

              lineParser.parseLine(strLine);
            }

        } catch (IOException | InvalidLineException e) {
           throw new CannotParseFileException(e);
        }
    }
}
