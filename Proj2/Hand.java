/*
    Project 2: UnoWar
    Author: Roshinikitha Somasundram
    Class summery: Deck

Notes
-------------------------------------------------

*/


public class Hand {

    public Card[] cards; //stores the cards within the current hand
    public Deck deck; //deck the hand draws from
    private int handSize; //size of the deck

    public Hand(Deck deck, int size){
        this.handSize = size;
        this.deck = deck;
        this.cards = new Card[size];

        for (int i = 0; i < size; i++) {
            this.cards[i] = deck.draw();
        }

    }

    public int getSize(){
        return handSize;
    }

    public Card get(int i){

        if(i >= cards.length)
        {
            System.out.println("Error, index is too big, will return first card instead");
            return cards[0];
        } else if (i < 0)
        {
            System.out.println("Error, index is too small, will return first card instead");
            return cards[0];
        }

        return cards[i];

    }

    public boolean remove(Card card){

        if(card == null)
        {
            return false;
        }

        for (int i = 0; i < cards.length; i++)
        {
            if (cards[i] == card) {
                cards[i] = deck.draw();
                return true;

            }
        }

        return false;

    }

}
