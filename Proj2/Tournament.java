/*
 *   Project 2: UnoWar
 *   Author: Roshinikitha Somasundram
 *   Class summary: Tournament
 *          - class runs full tournament that tests all matchups
 *          - uses  UnoWarMatch class to sim games + win rates
 *          - each pair of AI
 *              - play matches
 *              - calc win rate and print
 *          - Main runner / entry point of program
 *
 */
public class Tournament
{


    /* Main method --> the program starts
     *
     *  - Create one of each AI type:
     *       - Random Card AI (base AI)
     *       - Smallest Card AI
     *       - Biggest Card AI
     *
     * - Store all AIs inside an array
     *
     * - Use two nested loops to compare every possible pair of AIs.
     *
     * - For each matchup, call Simulate() to run multiple games
     *     and print the win rate between AIs.
     */
    public static void main(String[] args)
    {
        AI AI = new AI();
        AI smallestAI = new SmallestCardAI();
        AI biggestAI = new BiggestCardAI();

        AI[] Players = {AI, smallestAI, biggestAI};

        for (int i = 0; i < 3; i++)
        {
            for(int x = 0; x < 3; x++)
            {
                Simulate(Players[i], Players[x], 10000);
            }
        }

    }


    /* Method simulates matches between AIs
     *
     * input:
     *      ai1 --> the first AI player
     *      ai2 --> the second AI player
     *      nTrials --> number of games to play for this matchup
     *
     *
     * - Create a UnoWarMatch between the two AIs
     *  - Run the winRate() method to get how often AI 1 wins
     *  - Print out the results with both AI names and their win rate
     *
     * ex.
     *      "Random Card AI vs Smallest Card AI winRate: 0.342"
     */
    public static void Simulate(AI ai1 ,AI ai2, int nTrails)
    {
        UnoWarMatch round = new UnoWarMatch(ai1, ai2);
        double rate = round.winRate(nTrails);

        System.out.printf(ai1.toString() + ai2.toString() + "winRate:" + rate + "\n");
    }

}
