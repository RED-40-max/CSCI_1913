/*
 *   Project 2: UnoWar
 *   Author: Roshinikitha Somasundram
 *   Class summery: Card
 *
 * ADD CODE
 * ADD Comments
 *
 *
 * ---------- Notes --------------------
 */

 import java.util.Random;

public class AI
{
    protected Random random;

    public Card getPlay(Hand hand, CardPile cardPile)
    {
        int handSize = hand.getSize();
        if (handSize == 0 )
        {
            return ((Card) null); //no cards
        }

        return hand.get(random.nextInt(handSize - 0 + 1) + 0);
    }

    @Override //overrides the OG java
    public String toString()
    {
        return "Random Card AI";
    }

}
