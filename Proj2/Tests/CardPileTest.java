package Tests;
/**
 * Original Author: Daniel Kluver
 * Changes by: Adriana Picoral Fall 2025
 * This class has some basic tests for the Deck class.
 */
public class CardPileTest {

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
        Card c1 = new Card(1, 1);
        Card c2 = new Card(2, 1);
        Card c3 = new Card(1, 2);
        Card c4 = new Card(2, 2);


        CardPile pile = new CardPile(c1);

        doTest(1, pile.getNumCards(), "pile.getNumCards()");
        doTest("Ace of Spades", pile.getTopCard().toString(), "pile.getTopCard()");
        doTest(true, pile.canPlay(c2), "pile.canPlay(c2)");
        doTest(true, pile.canPlay(c3), "pile.canPlay(c3)");
        doTest(true, pile.canPlay(c4), "pile.canPlay(c4)");

        pile.play(c2);
        doTest(2, pile.getNumCards(), "pile.getNumCards()");
        doTest("Two of Spades", pile.getTopCard().toString(), "pile.getNumCards()");
        doTest(true, pile.canPlay(c1), "pile.canPlay(c1)");
        doTest(false, pile.canPlay(c3), "pile.canPlay(c3)");
        doTest(true, pile.canPlay(c4), "pile.canPlay(c4)");

        pile.play(c4);
        doTest(3, pile.getNumCards(), "pile.getNumCards()");
        doTest("Two of Hearts", pile.getTopCard().toString(), "pile.getTopCard");
        doTest(false, pile.canPlay(c1), "pile.canPlay(c1)");
        doTest(true, pile.canPlay(c3), "pile.canPlay(c3)");
        doTest(true, pile.canPlay(c4), "pile.canPlay(c4)");

        pile.play(c1);                          // should print "Illegal move detected!"
        doTest(3, pile.getNumCards(), "pile.getNumCards()");
        doTest("Two of Hearts", pile.getTopCard().toString(), "pile.getTopCard");

        pile.play(null);                        // should print "Illegal move detected!"
        doTest(3, pile.getNumCards(), "pile.getNumCards()");
        doTest("Two of Hearts", pile.getTopCard().toString(), "pile.getTopCard");
    }
}