package Tests;
import AI;
import BiggestCardAI;
import Card;
import CardPile;
import Deck;
import Hand;
import SmallestCardAI;

/**
 * Original Author: Daniel Kluver
 * Changes by: Adriana Picoral Fall 2025
 * Some basic tests of the AITest class.
 */

public class AITest {

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
        AI randomAI = new AI();
        AI smallestAI = new SmallestCardAI();
        AI biggestAI = new BiggestCardAI();

        doTest("Random Card AI", randomAI.toString(), "hand.getSize()");
        doTest("Smallest Card AI", smallestAI.toString(), "hand.getSize()");
        doTest("Biggest Card AI", biggestAI.toString(), "hand.getSize()");

        System.out.println("\n*********** Testing choices ***********");
        // These tests will require you personally verifying them.
        // I can't see a way to fix that (without providing you with some of the solution).
        Deck deck = new Deck();
        Hand hand = new Hand(deck, 5);
        CardPile pile = new CardPile(deck.draw());
        AI testAI = smallestAI; // change this to be the different AIs

        System.out.println("Top card is: "+pile.getTopCard());

        System.out.println("Hand is: ");
        for (int i=0; i < hand.getSize(); i++) {
            System.out.println(i + " " + hand.get(i));;
        }

        Card choice = testAI.getPlay(hand, pile);
        System.out.println(testAI.toString() + " chose: " + choice);


        System.out.println("\n*********** Testing choices ***********");
        // These tests will require you personally verifying them.
        // I can't see a way to fix that (without providing you with some of the solution).
        Deck deck2 = new Deck();
        Hand hand2 = new Hand(deck, 5);
        CardPile pile2 = new CardPile(deck2.draw());
        AI testAI2 = biggestAI; // change this to be the different AIs

        System.out.println("Top card is: "+pile2.getTopCard());

        System.out.println("Hand is: ");
        for (int i=0; i < hand2.getSize(); i++) {
            System.out.println(i + " " + hand2.get(i));;
        }

        Card choice2 = testAI2.getPlay(hand2, pile2);
        System.out.println(testAI2.toString() + " chose: " + choice2);
        System.out.println("\n****************************************");

    }
}
