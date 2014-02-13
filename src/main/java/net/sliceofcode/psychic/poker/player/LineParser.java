package net.sliceofcode.psychic.poker.player;

import net.sliceofcode.psychic.poker.player.exceptions.InvalidLineException;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by pascr on 13.02.14.
 */
public class LineParser {

    private static final String POKER_LINE_VALIDATE_INPUT_REGEXP = "([ATJQK|2-9]+[CDHS]+(\\s|$)){10}";
    // Cards will be separated by single spaces
    private static final String SPACE_CHAR = " ";

    /**
     * Parses a line, validates and extract cards
     *
     * @param inputLine
     */
    public Set<String> parseLine(String inputLine) throws InvalidLineException {
        if (inputLine.matches(POKER_LINE_VALIDATE_INPUT_REGEXP)) {
            String[] cards = inputLine.split(SPACE_CHAR);

            Set ret = new LinkedHashSet<String>();

            ret.addAll(Arrays.asList(cards));

            return ret;

        } else {
            throw new InvalidLineException();
        }

    }


}
