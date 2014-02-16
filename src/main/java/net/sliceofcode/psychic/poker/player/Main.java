package net.sliceofcode.psychic.poker.player;

/**
 * Created by pascal on 16.02.14.
 */
public class Main
{
    /**
     * Main application method
     * @param args
     */
    public static void main(String[] args)
    {
        if (args.length != 1)
        {
            System.out.println("Usage : psychic-poker-player <input file>");
            return;
        }

        PsychicPokerPlayer psychicPokerPlayer = new PsychicPokerPlayer();

        psychicPokerPlayer.playFromInputFile(args[0]);
    }
}
