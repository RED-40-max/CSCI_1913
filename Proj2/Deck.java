/*
 *   Project 2: UnoWar
 *   Author: Roshinikitha Somasundram
 *   Class summery: Deck
 *          - Tracks 52 cards used + next card
 *          - handles rules for when and how to:
 *              - create, shuffel, resett, and draw the deck
 */

import java.util.Random;

public class Deck
{
    public Card[] deck = new Card[52];
    private int nextCardIndex;


    /* Constructor that creates deck of 52 cards
     *
     *      - Loops through all 4 suits (1–4)
     *      - For each suit, creates cards of rank 1–13
     *      - Adds each new Card object into the deck array
     *
     * After creating all cards:
     *      - auto calls shuffle() to randomize card order
     */
    public Deck()
    {
        int i = 0;
        for (int suit = 1; suit <= 4; suit++)
        {
            for(int rank = 1; rank <= 13; rank++)
            {
                Card card = new Card(rank, suit);
                deck[i++] = card;
            }
        }
        shuffle();
    }

    /* Method shuffles the deck
     *
     * Uses the Fisher-Yates shuffle algorithm:
     *      - Iterates backward through the deck
     *      - Randomly swaps each card with another earlier card
     *
     * After shuffling:
     *      - Resets nextCardIndex to 0 so drawing starts from the top again
     */
    public void shuffle()
    {
        Random random = new Random();
        for(int i = deck.length -1; i > 0; i--)
        {
            int j = random.nextInt(i + 1);
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
        nextCardIndex = 0; //clears all elements
    }

    /* Method draws next available card
     *
     * Steps:
     *      - Checks if the deck is empty (all 52 cards drawn)
     *          --> If true, auto reshuffles
     *      - gets card at nextCardIndex
     *      - inc nextCardIndex so the next draw is new
     *
     * Returns:
     *      - The drawn Card object
     */
    public Card draw()
    {
        if(deck.length == nextCardIndex)
        {
            //then we need to create a new deck, clear discard
            shuffle();
        }

        //take it from the deck to the discard pile
        Card cardDrawn = deck[nextCardIndex];
        nextCardIndex++;

        return cardDrawn;
    }

    /* Method returns the no. of cards in the deck
     *
     * Calculates w:  52 (total deck size) - no. cards drawn
     */
    public int cardsRemaining()
    {
        return (deck.length - nextCardIndex); //return the deck size and whatnot
    }

    /* Method checks if the deck is empty
     *
     * Returns:
     *      - true  --> if all 52 cards have been drawn
     *      - otherwise --> false
     */
    public boolean isEmpty()
    {
        if (deck.length == nextCardIndex)
        {
            return true;
        }
        return false;
    }

}
