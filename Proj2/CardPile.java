/*
 *   Project 2: UnoWar
 *   Author: Roshinikitha Somasundram
 *   Class summery: Card Pile
 *
 * ---------- Notes --------------------
 */

public class CardPile
{
    private Card topCard;

    //constructor,
    public CardPile(Card topCard)
    {
        this.topCard = topCard;
    }

    //check if the input card is legal to play on stack

    public boolean canPlay(Card card)
    {
        //card can be played only if
        //as a higher rank than current card
        //has same rank as current card
        //has same suit as top card

        if (topCard.getRankNum() <= card.getRankNum()) { //if has higher or equal rank then current card
            return true;
        } else if(topCard.getSuitNum() == card.getSuitNum()) { //if has same suit
            return true;
        }
        //otherwise it is false
        return false;

    }

    public void play(Card card)
    {
        //adds another card to the card pile making this the new top card
    }

    public int getNumCards()
    {

    }



}
