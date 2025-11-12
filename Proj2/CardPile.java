/*
 *   Project 2: UnoWar
 *   Author: Roshinikitha Somasundram
 *   Class summery: Card Pile
 *          - Tracks pile of cards + total num of cards
 *          - Rules for the discard pile, what can be added to it, when it resets
 *          - canPlay() only if valid card
 */

public class CardPile
{
    private Card topCard;
    private int numCards;

    public CardPile(Card topCard)
    {
        this.topCard = topCard;
        this.numCards = 1;
    }


    /* Method that determines whether a new card can be legally played
     *
     * A card can be played if:
     *      - Its rank is greater than or equal to the top card’s rank
     *        OR
     *      - Its suit matches the suit of the top card
     *
     * Returns:
     *      - true  → card can be legally played
     *      - false → move is illegal
     */
    public boolean canPlay(Card card)
    {
        if (topCard.getRankNum() <= card.getRankNum()) { //if has higher or equal rank then current card
            return true;
        } else if(topCard.getSuitNum() == card.getSuitNum()) { //if has same suit
            return true;
        }
        //otherwise it is false
        return false;

    }

    /* Method that attempts to play a card on the pile
     *
     * Steps:
     *      - Checks if the card is playable using canPlay()
     *      - If not playable → prints "Illegal move detected!"
     *      - If playable → sets this card as the new top card
     *                      and increments the pile count
     */
    public void play(Card card)
    {
        if (card == null)
        {
            System.out.print("Illegal move detected!");
            return;
        }

        if (!(canPlay(card)))
        {
            System.out.print("Illegal move detected!");
        }
        else
        {
            topCard = card;          // update top card
            numCards = numCards + 1; // increase pile size
        }

    }

//getters
    public int getNumCards()
    {
        return numCards;
    }

    public Card getTopCard()
    {
        return topCard;
    }



}
