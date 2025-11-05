/*
 *   Project 2: UnoWar
 *   Author: Roshinikitha Somasundram
 *   Class summery: Card Pile
 *
 * (DONE) CODE
 * (DONE) COMMENTS
 *
 * ---------- Notes --------------------
 */

public class CardPile
{
    private Card topCard;
    private int numCards;

    //constructor,
    public CardPile(Card topCard)
    {
        this.topCard = topCard;
    }

    /* Determines wheather a card can be played
     *    can only if it's bigger or equal in rank to the top card
     *      or same in suit to the top card
     *    otherwise it cannot be played
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

    /* Checks if the card can be played, then plays a card if valid
     *      if card cannot be played, prints according error messege
     *      otherwise, it replaced the card preposed to play, as the current top card
     */
    public void play(Card card)
    {
        if (!(canPlay(card)))
        {
            System.out.print("Illegal move detected!");
        }
        else //adds another card to the card pile making this the new top card
        {
            topCard = card;
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
