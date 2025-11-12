/*
 *   Project 2: UnoWar
 *   Author: Roshinikitha Somasundram
 *   Class summery: SmallestCardAI
 *          - subclass of AI / Over rides AI methods
 *          - always trys to play smallest valid card
 *          - Tie breaker: If multiple playable cards have the same rank, the 1st in the hand
 *            is chosen (first-come, first-serve).
 *
 */

public class SmallestCardAI extends AI
{
    /* Method selects card to play based on lowest rank
     *
     * Loops through every card in the hand
     *
     * For each card:
     *      - Checks if it is a valid play
     *      - If this is the first valid card, stores as “smallest”
     *      - Otherwise, compares rank with the current “smallest” card
     *           --> If lower, replaces “smallest” with this card
     *
     * After checking all cards:
     *      - Returns the lowest-ranked valid card
     *      - If no valid cards, returns null
     */
    @Override
    public Card getPlay(Hand hand, CardPile cardPile)
    {
        Card smallest = null;

        for (int i = 0; i < hand.getSize(); i++)
        {
            Card curr = hand.get(i);

            if (cardPile.canPlay(curr))
            {
                if (smallest == null || curr.getRankNum() < smallest.getRankNum())
                {
                    smallest = curr;
                }
            }
        }
        return smallest;
    }

    /* Method that returns a disc of this AI type
     *
     * Used for printing matchups or debugging
     * Always returns: "Smallest Card AI"
     */
    @Override
    public String toString()
    {
        return "Smallest Card AI";
    }



}
