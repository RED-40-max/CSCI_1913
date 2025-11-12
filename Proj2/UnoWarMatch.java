/*
 *   Project 2: UnoWar
 *   Author: Roshinikitha Somasundram
 *   Class summary: UnoWarMatch
 *          - sims matches between 2 AI players
 *          - each AI uses own strat (construtor defined)
 *          - class handles:
 *              - setting up deck and hands
 *              - alt turns
 *              - returning rounds after 10 pts.
 *              - tracking win rates
 */



public class UnoWarMatch
{
    protected AI ai1;
    protected AI ai2;
    protected int deckNum;

    /* Constructor sets up a match between two AIs
     *
     * param:
     *      ai1 --> The first AI player
     *      ai2 --> The second AI player
     *
     * Each AI starts with 7 cards by default.
     */
    public UnoWarMatch(AI ai1, AI ai2)
    {
        this.ai1 = ai1;
        this.ai2 = ai2;
        this.deckNum = 7;

    }

    public void setDeckNum(int i)
    {
        this.deckNum = i;

    }

    /* Method plays 1 UnoWar game
     *
     * - Setup:
     *      - Creates and shuffles a deck
     *      - Deals new hands to both AIs
     *
     * - Game :
     *     - Each round starts w/ fresh CardPile
     *     - AIs takes turns playing cards
     *     - A card is valid if it can be played on the current pile
     *          - If a player cannot play, the other player wins the round
     * - Scoring:
     *     - The 1st AI to reach 10 points wins
     *     - Returns true if AI 1 wins
     *          - false if AI 2 wins
     */
    public boolean playGame()
    {
        // Setup
        Deck deck = new Deck();
        deck.shuffle();
        this.deckNum = 7;

        Hand hand1 = new Hand(deck, deckNum);
        Hand hand2 = new Hand(deck, deckNum);

        int score1 = 0;
        int score2 = 0;
        boolean ai1Starts = true;  // AI 1 plays first in round 1

        // Play rounds until someone reaches 10
        while ((score1 < 10) && (score2 < 10)) {

            CardPile pile = new CardPile(deck.draw());
            boolean ai1Turn = ai1Starts;

            boolean canGo = true;

            while (canGo) {
                AI current;
                Hand currentHand;

                if (ai1Turn)
                {
                    current = ai1;
                    currentHand = hand1;
                } else
                {
                    current = ai2;
                    currentHand = hand2;
                }

                // Ask the AI for a card
                Card chosen = current.getPlay(currentHand, pile);

                // Check if the AI could not find a valid card to play
                if (chosen == null)
                {
                    if (ai1Turn == true)
                    {
                        score2 = score2 + 1;
                        ai1Starts = false;
                    }
                    else
                    {
                        score1 = score1 + 1;
                        ai1Starts = true;
                    }

                    canGo = false;
                    break;
                }
                else
                {
                    currentHand.remove(chosen);
                    pile.play(chosen);
                }

                // Switch to the other AI’s turn for the next move
                if (ai1Turn == true)
                {
                    ai1Turn = false;
                }
                else
                {
                    ai1Turn = true;
                }

            }


        }

        return score1 > score2;

    }

    /* Method simulates games to calculate win rate
     *
     * input:
     *      nTrials --> number of games to simulate
     *
     * Steps:
     *      - Plays nTrials of games
     *      - Counts how many times AI 1 wins
     *      - Returns AI 1's win rate as a no. between 0 and 1 (percentage)
     *
     * ex.
     *      winRate(100) --> AI 1 wins 63 times --> returns 0.63
     */
    public double winRate(int nTrials)
    {

        double ai1_wins = 0;

        for (int i = 0; i < nTrials; i++)
        {
            boolean ai1_gameWin = playGame();
            if(ai1_gameWin)
            {
                ai1_wins ++;
            }

        }

        return (ai1_wins / (double) nTrials);

    }


}
