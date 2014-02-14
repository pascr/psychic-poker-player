package net.sliceofcode.psychic.poker.player;

import net.sliceofcode.psychic.poker.player.domain.Card;
import net.sliceofcode.psychic.poker.player.domain.Face;
import net.sliceofcode.psychic.poker.player.domain.Suit;
import net.sliceofcode.psychic.poker.player.exceptions.InvalidLineException;

import java.util.*;

/**
 * Created by pascr on 13.02.14.
 */
public class LineParser {

    private static final String POKER_LINE_VALIDATE_INPUT_REGEXP = "([ATJQK|2-9]+[CDHS]+(\\s|$)){10}";
    // Cards will be separated by single spaces
    private static final String SPACE_CHAR = " ";

    public static final int FACE_CHAR_POSITION = 0;
    public static final int SUIT_CHAR_POSITION = 1;

    /**
     * Parses a line, validates and extract cards
     *
     * @param inputLine
     */
    public List<Card> parseLine(String inputLine) throws InvalidLineException {

        if (inputLine.matches(POKER_LINE_VALIDATE_INPUT_REGEXP)) {
            String[] cards = inputLine.split(SPACE_CHAR);

            LinkedList<Card> ret = new LinkedList<>();

            for(String cardValue: cards)
            {

                Card card = new Card(Face.build(cardValue.charAt(FACE_CHAR_POSITION)), Suit.build(cardValue.charAt(SUIT_CHAR_POSITION)));
                ret.add(card);
            }

            return ret;

        } else {
            throw new InvalidLineException();
        }

    }


}
