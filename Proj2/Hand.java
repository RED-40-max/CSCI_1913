/*
 *   Project 2: UnoWar
 *   Author: Roshinikitha Somasundram
 *   Class summery: Hand
 *          - Tracks set of cards (hand) w/ array
 *          - handles rules ot access cards, check hand size, and play / replace cards
 *          - invalid card access w/ error messege
 */


public class Hand {

    public Card[] cards; //stores the cards within the current hand
    public Deck deck; //deck the hand draws from
    private int handSize; //size of the deck


    /* Constructor creates a hand w/ a no. of cards
     *
     *      - Saves the deck ref (for future draws)
     *      - Sets hand size
     *      - Creates array to hold hand size cards
     *      - Draws cards one by one from the deck until the hand is full
     */
    public Hand(Deck deck, int size){
        this.handSize = size;
        this.deck = deck;
        this.cards = new Card[size];

        for (int i = 0; i < size; i++) {
            this.cards[i] = deck.draw();
        }

    }


    //getters ( a hand size)
    public int getSize(){
        return handSize;
    }

    /* Method gets card at position in the hand
     *
     * Error Handling:
     *      - If the index is too large or negative:
     *           --> Prints an error message
     *           --> Returns the first card in the hand as a fallback
     *
     * Returns:
     *      - The card at index i if valid
     *      - The first card if invalid index
     */
    public Card get(int i)
    {
        if (i >= cards.length)
        {
            System.out.println("Invalid hand index!");
            return cards[0];
        }
        else if (i < 0)
        {
            System.out.println("Invalid hand index!");
            return cards[0];
        }

        return cards[i];
    }


    /* Method removes a card from the hand
     *
     * Steps:
     *      - If the card is null --> returns false
     *      - Otherwise, loops through the hand to find a matching card
     *      - When a match is found:
     *           --> Replaces by drawing a new card from the deck
     *           --> Returns true to show replacement
     *
     * If no matching card is found:
     *      - Returns false (no removal)
     */
    public boolean remove(Card card){

        if(card == null)
        {
            return false;
        }

        for (int i = 0; i < cards.length; i++)
        {
            if (cards[i].equals(card)) {
                cards[i] = deck.draw();
                return true;

            }
        }

        return false;

    }

}
