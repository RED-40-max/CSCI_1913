/*
 *   Project 2: UnoWar
 *   Author: Roshinikitha Somasundram
 *   Class summary: AI (completly random)
 *         - Super class to other AI's
 *         - Randomly play a valid card
 *
 */


import java.util.Random;

public class AI
{
    protected Random random = new Random(); //random variable initalization so subclass can also use

    /* Method that finds what card AI plays
     *
     * Loops through cards in the hand (from first to last)
     *
     * For each card:
     *      - Checks if it can be played
     *      - If yes, returns card as play
     *
     * If no cards in the hand are playable:
     *      - Returns null (shows no valid move is available)
     */
    public Card getPlay(Hand hand, CardPile cardPile)
    {
        for (int i = 0; i < hand.getSize(); i++) {

            Card card = hand.get(i);

            if (cardPile.canPlay(card)) {
                return card; // first valid card
            }
        }
        return null; // no valid cards
    }

    /* Method that returns a string of this AI type
     *
     * Used mainly for display purposes when printing results
     *
     * Always returns "Random Card AI"
     */
    @Override
    public String toString()
    {
        return "Random Card AI";
    }

}
