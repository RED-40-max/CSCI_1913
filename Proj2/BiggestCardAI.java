/*
 *   Project 2: UnoWar
 *   Author: Roshinikitha Somasundram
 *   Class summery: BiggestCardAI
 *          - subclass of AI / Over rides AI methods
 *          - always trys to play highest valid card
 *          - Tie breaker: If multiple playable cards have the same rank, the 1st in the hand
 *            is chosen (first-come, first-serve).
 */

public class BiggestCardAI extends AI
{
    /* Method that finds what highest card (for AI to play)
     *
     * Loops through every card in hand
     *
     * For each card:
     *      - Checks if its a valid move
     *      - If this is the first valid card, stores it as biggest
     *      - Otherwise, compares its rank with the current biggest
     *           --> If higher, replaces biggest with this card
     *
     * After checking all cards:
     *      - Returns the highest-ranked valid card found
     *      - If no valid cards are found, returns null (default initalized)
     */
    @Override
    public Card getPlay(Hand hand, CardPile cardPile)
    {
        Card biggestCard = null;

        for (int i = 0; i < hand.getSize(); i++)
        {
            Card currentCard = hand.get(i);

            if (cardPile.canPlay(currentCard)) {

                if ((biggestCard == null) || (currentCard.getRankNum() > biggestCard.getRankNum()))
                {
                    biggestCard = currentCard;
                }
            }
        }
        return biggestCard;
    }

    /* Method that returns a description of this AI type
     *
     * Used for printing matchups or debugging
     * Always returns: "Biggest Card AI"
     */
    @Override
    public String toString()
    {
        return "Biggest Card AI";

    }


}
