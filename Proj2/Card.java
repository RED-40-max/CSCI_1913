/*
 *   Project 2: UnoWar
 *   Author: Roshinikitha Somasundram
 *   Class summery: Card
 *          - reps a single playing card with a suit and a rank.
 *          - Each card is has two numbers:
 *                  rank: 1 (Ace) - 13 (King)
 *                  suit:
 *                  1 (Spades)
 *                  2 (Hearts)
 *                  3 (Clubs)
 *                  4 (Diamonds)
 *          - Makes sure cards are valid
 *          - defines equality (card + suit are both same, or obj is also same)
 *
 */

public final class Card{

    private final int suit ;
    private final int rank ;

    /* Constructor that creates a card w/ a rank and suit
     *
     * Rank and suit are within valid ranges:
     *      rank: between 1 - 13
     *      suit: between 1 - 4
     *
     * If invalid values are provided:
     *      - Prints "Invalid Card"
     *      - Defaults Ace of Spades (rank = 1, suit = 1)
     */
    public Card(int rank, int suit)
    {
        if ((rank < 1 || rank > 13) || (suit < 1 || suit > 4))
        {
            System.out.print("Invalid Card");
            this.rank = 1;
            this.suit = 1;
        } else
        {
            this.rank = rank;
            this.suit = suit;
        }
    }

    //getters (suit + rank)
    public int getSuitNum(){
        return suit;
    }
    public int getRankNum(){
        return rank;
    }

    /* Method converts the rank no. into name
     *
     * Uses a switch statement to match rank --> name
     *      ex.: 1 --> "Ace", 11 --> "Jack", etc.
     *
     * Returns "Invalid" if the rank doesn’t match any valid value.
     */
    public String getRankName()
    {
        String RankName;

        switch(this.rank){
            case 1:
                RankName = "Ace";
                break;
            case 2:
                RankName = "Two";
                break;
            case 3:
                RankName = "Three";
                break;
            case 4:
                RankName = "Four";
                break;
            case 5:
                RankName = "Five";
                break;
            case 6:
                RankName = "Six";
                break;
            case 7:
                RankName = "Seven";
                break;
            case 8:
                RankName = "Eight";
                break;
            case 9:
                RankName = "Nine";
                break;
            case 10:
                RankName = "Ten";
                break;
            case 11:
                RankName = "Jack";
                break;
            case 12:
                RankName = "Queen";
                break;
            case 13:
                RankName = "King";
                break;
            default:
                RankName = "Invalid";
                break;
        }

        return RankName;
    }

    /* Method converts the suit no. into name
     *
     * Uses a switch statement to map suit → name
     *      ex.: 1 --> "Spades", 4 --> "Diamonds"
     *
     * Returns "Invalid" if the suit doesn’t match any valid value.
     */
    public String getSuitName()
    {
        String SuitName;
        switch(suit)
        {
            case 1:
                SuitName = "Spades";
                break;
            case 2:
                SuitName = "Hearts";
                break;
            case 3:
                SuitName = "Clubs";
                break;
            case 4:
                SuitName = "Diamonds";
                break;
            default:
                SuitName = "Invalid";
                break;
        }

        return SuitName;
    }

    /* Method that returns the card as string
     *
     * Combines the rank and suit names into one phrase:
     *      ex: "Ace of Spades"
     */
    @Override
    public String toString(){
        String FinalCardName = "";
        FinalCardName = getRankName()+ " of "+ getSuitName();
        return FinalCardName;
    }

    /* Method checks if cards are equal
     *
     * Compares rank and suit:
     *      - Returns true if both are same
     *      - Returns false otherwise
     *
     * Also checks the obj being compared is Card.
     */
    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Card))
        {
            return false;
        }

        Card other = (Card) obj;

        if(this.rank == other.getRankNum() && this.suit == other.getSuitNum())
        {
            return true;

        } else
        {
            return false;
        }
    }


}