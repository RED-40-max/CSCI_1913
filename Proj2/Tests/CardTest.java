package Tests;
/**
 * Original Author: Daniel Kluver
 * Changes by: Adriana Picoral Fall 2025
 * A class that tests the cards class.
 * After implementing the cards class this file should behave as described
 */
public class CardTest {

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

        Card as = new Card(1, 1);
        doTest("Ace of Spades", as.toString(), "new Card(1,1)");
        doTest("Ace", as.getRankName(), ".getRankName() method");
        doTest(1, as.getRankNum(), ".getRankNum() method");
        doTest("Spades", as.getSuitName(), ".getSuitName() method");

        Card one = new Card(2, 2);
        doTest("Two of Hearts", one.toString(), "new Card(2,2)");

        Card two = new Card(3, 3);
        doTest("Three of Clubs", two.toString(), "new Card(3,3)");

        Card three = new Card(4, 4);
        doTest("Four of Diamonds", three.toString(), "new Card(4,4)");

        Card four = new Card(10, 4);
        doTest("Ten of Diamonds", four.toString(), "new Card(10,4)");

        Card five = new Card(12, 2);
        doTest("Queen of Hearts", five.toString(), "new Card(12,2)");

        Card js = new Card(11, 1);
        Card jc = new Card(11, 3);
        Card other = new Card(11, 3);

        doTest(false, as.equals(js), "as.equals(js)");
        doTest(false, as.equals(jc), "as.equals(jc)");
        doTest(false, jc.equals(other), "jc.equals(other)");


        Card err = new Card(-4, 4);               // should print "Invalid Card"
        doTest("Ace of Spades", err.toString(), "invalid card");

        err = new Card(3, 11);                    // should print "Invalid Card"
        doTest("Ace of Spades", err.toString(), "invalid card");

        err = new Card(33, 2);                    // should print "Invalid Card"
        doTest("Ace of Spades", err.toString(), "invalid card");


        /*
        You may find it useful to make other Card methods. Please do.
        If you do make other methods I recommend designing some tests and putting them in this file
        This will help you avoid bugs, or at the least catch bugs before they become an issue.
        */

    }
}
