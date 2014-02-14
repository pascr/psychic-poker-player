package net.sliceofcode.psychic.poker.player;

import net.sliceofcode.psychic.poker.player.domain.Game;
import net.sliceofcode.psychic.poker.player.exceptions.CannotParseFileException;
import net.sliceofcode.psychic.poker.player.exceptions.InvalidLineException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by pascr on 13.02.14.
 */
public class PokerFileReader {

    private final LineParser lineParser;

    public PokerFileReader(LineParser parser) {
        this.lineParser = parser;
    }

    public ArrayList<Game> readPokerFile(String file) throws CannotParseFileException {

        ArrayList<Game> games = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String strLine;

            while ((strLine = br.readLine()) != null) {

                games.add(Game.buildFromSetOfCard(lineParser.parseLine(strLine)));
            }

        } catch (IOException | InvalidLineException e) {
            throw new CannotParseFileException(e);
        }
        return games;
    }
}
