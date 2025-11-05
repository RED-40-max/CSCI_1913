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

public class SmallestCardAI extends AI
{
    @Override
    //ties broken by first come first serve
    public Card getPlay(Hand hand, CardPile cardPile)
    {
        int smallestRank = 13;
        int smallCardIndex = 0;

        for(int i = 0; i < hand.getSize(); i++)
        {
            Card currCard = hand.get(i);

            if (currCard.getRankNum() < smallestRank)
            {
                smallestRank = currCard.getRankNum();
                smallCardIndex = i;
            }

        }

        return hand.get(smallCardIndex);
    }

    @Override //overrides the regular AI
    public String toString()
    {
        return "Smallest Card AI";
    }



}
