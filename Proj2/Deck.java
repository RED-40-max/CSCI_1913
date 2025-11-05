/*
 *   Project 2: UnoWar
 *   Author: Roshinikitha Somasundram
 *   Class summery: Deck
 *
 * (DONE) CODE
 * ADD COMMENTS
 *
 * ---------- Notes --------------------
 */

import java.util.ArrayList;
import java.util.Random;

public class Deck
{
    public Card[] deck = new Card[52];
    public ArrayList <Card> discardPile = new ArrayList<>();

    public Deck()
    {
        int i = 0;
        for (int suit = 1; suit <= 4; suit++)
        {
            for(int rank = 1; rank <= 13; rank++)
            {
                Card card = new Card(rank, suit);
                deck[i] = card;
                i++;
            }
        }
        shuffle();
    }

    public void shuffle()
    {
        Random random = new Random();
        for(int i = deck.length -1; i > 0; i--)
        {
            int j = random.nextInt(i + 1);
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
        discardPile.clear(); //clears all elements
    }

    public Card draw()
    {
        if(deck.length == discardPile.size())
        {
            //then we need to create a new deck, clear discard
            shuffle();
        }
        //find the card to draw
        int nextCard =  deck.length - discardPile.size() -1;

        //take it from the deck to the discard pile
        Card cardDrawn = deck[nextCard];

        discardPile.add(cardDrawn);

        return cardDrawn;
    }

    public int cardsRemaining()
    {
        return (deck.length - discardPile.size()); //return the deck size and whatnot
    }

    public boolean isEmpty()
    {
        if (deck.length == discardPile.size())
        {
            return true;
        }
        return false;
    }

}
