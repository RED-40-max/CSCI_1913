/*
    Project 2: UnoWar
    Author: Roshinikitha Somasundram
    Class summery: Card
        -->

Notes
-------------------------------------------------


 */

public class Card
{
    private final int rank;
    private final int suit;

    public Card(int rank, int suit)
    {
        if((rank > 13)&& (rank < 0))//if rank is not valid
        {
            System.out.print("Invalid Card");
        } else if ((suit < 0 )&&(suit > 4))
        {
            System.out.print("Invalid Card");
        }
        else
        {
            this.rank = rank;
            this.suit = suit;
        }
    }


    public int getSuitNum(){
        return suit;
    }
    public int getRankNum(){
        return rank;
    }

    public String getRankName(){
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
                RankName = "King";
                break;
            case 13:
                RankName = "Queen";
                break;
            default:
                RankName = "Invalid";
                break;
        }

        return RankName;
    }

    public String getSuitName(){
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
                SuitName = "Dimonds";
                break;
            default:
                SuitName = "Invalid";
                break;
        }

        return SuitName;
    }

    @Override
    public String toString(){
        String FinalCardName = "";
        FinalCardName = getRankName()+ " of "+ getSuitName();
        return FinalCardName;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Card)) { //if it is an instence of card
            return false;
        }

        Card other = (Card) obj; //cast object to card

        if(this.rank == other.getRankNum())
        {
            if(this.suit == other.getSuitNum())
            {
                return true;
            }
        }
        return false;

    }

}