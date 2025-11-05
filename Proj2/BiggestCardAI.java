/*
 *   Project 2: UnoWar
 *   Author: Roshinikitha Somasundram
 *   Class summery: Hand
 *
 *  (DONE) CODE
 *  ADD Comments
 *
 * ---------- Notes --------------------
 */

public class BiggestCardAI extends AI
{
    @Override
    //ties broken by first come first serve
    public Card getPlay(Hand hand, CardPile cardPile)
    {
        Card LargestCard = new Card(1, 1); //auto set to the smallest suit and random rank
        for(int i = 0; i < hand.getSize(); i++)
        {
            Card currCard = hand.get(i);
            if (currCard.getRankNum() > LargestCard.getRankNum())
            {
                LargestCard = currCard;
            }
        }
        return LargestCard;
    }

    public String toString()
    {
        return "Biggest Card AI";

    }


}
