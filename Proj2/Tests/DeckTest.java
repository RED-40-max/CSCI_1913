package Tests;
import Card;
import Deck;

/**
 * Original Author: Daniel Kluver
 * Changes by: Adriana Picoral Fall 2025
 * This class has some basic tests for the Deck class.
 */
public class DeckTest {

    /**
     * doTest prints helpful messages informing the user whether or not
     * a test passed.
     * @param expected
     * @param output
     * @param message -- name of a method, or test
     */
    public static void doTest(Object expected, Object output, String message) {
        if (expected.equals(output)) {
            System.out.println(message + " passed test");
        } else {
            System.out.print(message + " failed, expected was " + expected);
            System.out.println(" but output was " + output);
        }
    }

    public static void main(String[] args) {
        Deck deck = new Deck();

        doTest(52, deck.cardsRemaining(), "deck.cardsRemaining()");
        doTest(false, deck.isEmpty(), "deck.isEmpty()");

        Card card = deck.draw();
        System.out.println(card);  //  should be a random card - check that it's different every time you run your code
        doTest(51, deck.cardsRemaining(), "deck.cardsRemaining()");
        doTest(false, deck.isEmpty(), "deck.isEmpty()");

        // loop should print nothing!
        for(int i = 50; i>=0; i--) {
            if(deck.isEmpty()) {
                System.out.println("Unexpectedly empty");
            }

            Card c2 = deck.draw();

            if(card.equals(c2)) {
                System.out.println("Duplicate card?");
            }
            if(i != deck.cardsRemaining()) {
                System.out.println("Deck count seems off!");
            }
        }
        doTest(true, deck.isEmpty(), "deck.isEmpty()");

        // this loop should print nothing
        for(int i = 51; i>=0; i--) {
            Card card2 = deck.draw();
            if(i != deck.cardsRemaining()) {
                System.out.println("Incorrect card length.");
            }
        }

        doTest(true, deck.isEmpty(), "deck.isEmpty()");
        System.out.println(deck.draw());             // should print a random card
    }
}