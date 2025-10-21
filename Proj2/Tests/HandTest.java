/**
 * Original Author: Daniel Kluver
 * Changes by: Adriana Picoral Fall 2025
 * Some basic tets of the Hand class.
 */
public class HandTest {

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
        Hand hand = new Hand(deck, 7);
        doTest(7, hand.getSize(), "hand.getSize()");
        doTest(45, deck.cardsRemaining(), "deck.cardsRemaining()");

        hand = new Hand(deck, 4);
        doTest(4, hand.getSize(), "hand.getSize()");
        doTest(41, deck.cardsRemaining(), "deck.cardsRemaining()");

        hand = new Hand(deck, 2);
        doTest(2, hand.getSize(), "hand.getSize()");
        doTest(39, deck.cardsRemaining(), "deck.cardsRemaining()");
        System.out.println("card 0 = " + hand.get(0));   // should print a random card
        System.out.println("card 1 = " + hand.get(1));   // should print a different random card
        
        Card c1 = hand.get(0);
        Card c2 = hand.get(1);

        // and "out of range" cards -- these should all just be c1
        // it should also print an error
        Card cn3 = hand.get(-3);                         // should print Invalid hand index!
        Card c4 = hand.get(4);                           // should print Invalid hand index!
        doTest(true, c1 == cn3, "comparison");
        doTest(true, c1 == c4, "comparison");

        Card notIn = deck.draw();
        doTest(false, hand.remove(notIn), "hand.remove(notIn)");

        doTest(true, hand.get(0).equals(c1), "hand.get(0).equals(c1))");
        doTest(true, hand.get(1).equals(c2), "hand.get(1).equals(c2))");

        doTest(true, hand.remove(c1), "hand.remove(c1)");
        doTest(false, c1.equals(hand.get(0)), "c1.equals(hand.get(0))");
        doTest(false, c2.equals(hand.get(0)), "c2.equals(hand.get(0))");
        System.out.println(hand.get(0));                 // should print a random card different than before.
    }
}
