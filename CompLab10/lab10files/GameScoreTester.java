/**
 * Tester class file.
 * CSCI 1913.
 * Originally written by Daniel Kluver
 * Changed by Adriana Picoral in Fall 2025
 */

import java.util.Arrays;
import java.util.Random;


public class GameScoreTester{

    public static void main(String[] args) {
        int errors = 0;

        GameScore g1 = new GameScore("DAK", 15.2, true);
        // new String here is deliberately to catch a common error in your equals definition
        // remember you can't compare Strings with == use .equals instead!
        GameScore g2 = new GameScore(new String("DAK"), 15.2, true);

        System.out.println("************ Test basic method functions ************");
        errors += Tester.doTest("DAK", g1.getName(), "g1.getName()");
        errors += Tester.doTest(15.2, g1.getScore(), "g1.getScore()");
        errors += Tester.doTest(true, g1.isHardMode(), "g1.isHardMode()");
        errors += Tester.doTest("DAK 15.2*", g1.toString(), "g1.toString()");
        errors += Tester.doTest(true, g1.equals(g2), "g1.equals(g2)");

        // catching another way you can mis-program equals by making the parameter wrong.
        // don't be mistaken, the parameter to your .equals method is Object.
        // If you don't know why make sure to ask in lab or office hours so we can explain it!wo

        System.out.println("************ Test equal method functions ************");
        // basic test
        GameScore g3 = new GameScore("DAK", 15.2, true);
        GameScore g3f = new GameScore("DAK", 15.2, false);
        GameScore g4 = new GameScore(new String("DAK"), 15.2, true);
        Object o = g4;
        Object o1 = g3;
        Object o2 = g3f;
        errors += Tester.doTest(true, o1.equals(o), "o1.equals(o)");
        errors += Tester.doTest(true, g3.equals(o), "g3.equals(o)");

        // test for class
        errors += Tester.doTest(false, o.equals(null), "o.equals(null)");

        // test for details
        GameScore g5 = new GameScore("DAK", 15.1, true); // test for smaller score
        errors += Tester.doTest(false, g5.equals(o), "g5.equals(o)");

        GameScore g6 = new GameScore("DAK", 15.3, true); // test for larger score
        errors += Tester.doTest(false, g6.equals(o), "g6.equals(o)");

        GameScore g7 = new GameScore("DAK", 15.2, false);
        errors += Tester.doTest(false, g7.equals(o), "g7.equals(o)");
        errors += Tester.doTest(true, g7.equals(o2), "g7.equals(o2)");

        GameScore g8 = new GameScore("dAk", 15.2, false);
        errors += Tester.doTest(false, g8.equals(o), "g8.equals(o)");

        GameScore g9 = new GameScore(" DAK", 15.2, false);
        errors += Tester.doTest(false, g9.equals(o), "g9.equals(o)");

        System.out.println("****************** Test comparator ******************");

        g1 = new GameScore("DAK", 1000, false);
        g2 = new GameScore("DJK", 110, false);
        errors += Tester.doTest(true, g1.compareTo(g2) > 0, "g1.compareTo(g2) > 0");
        errors += Tester.doTest(true, g2.compareTo(g1) < 0, "g2.compareTo(g1) < 0");

        g1 = new GameScore("DJK", 1000, false);
        g2 = new GameScore("DAK", 1000, false);
        errors += Tester.doTest(true, g1.compareTo(g2) == 0, "g1.compareTo(g2) == 0");
        errors += Tester.doTest(true, g2.compareTo(g1) == 0, "g2.compareTo(g1) == 0");

        g1 = new GameScore("DAK", 110, true);
        g2 = new GameScore("DJK", 110, false);
        errors += Tester.doTest(true, g1.compareTo(g2) > 0, "g1.compareTo(g2) > 0");
        errors += Tester.doTest(false, g2.compareTo(g1) > 0, "g2.compareTo(g1) > 0");

        g1 = new GameScore("DJK", 100, true);
        g2 = new GameScore("DAK", 110, false);
        errors += Tester.doTest(true, g1.compareTo(g2) > 0, "g2.compareTo(g1) > 0");
        errors += Tester.doTest(true, g2.compareTo(g1) < 0, "g2.compareTo(g1) < 0");

        g1 = new GameScore("DAK", 110, true);
        g2 = new GameScore("DJK", 10, false);
        errors += Tester.doTest(true, g1.compareTo(g2) > 0, "g2.compareTo(g1) > 0");
        errors += Tester.doTest(true, g2.compareTo(g1) < 0, "g2.compareTo(g1) < 0");

        g1 = new GameScore("ABC", 1000, true);
        g2 = new GameScore("ABC", 110, true);
        errors += Tester.doTest(true, g1.compareTo(g2) > 0, "g2.compareTo(g1) > 0");
        errors += Tester.doTest(true, g2.compareTo(g1) < 0, "g2.compareTo(g1) < 0");

        g1 = new GameScore("ABC", 100, true);
        g2 = new GameScore("ABC", 100, true);
        errors += Tester.doTest(true, g1.compareTo(g2) == 0, "g2.compareTo(g1) == 0");
        errors += Tester.doTest(false, g2.compareTo(g1) != 0, "g2.compareTo(g1) != 0");

        // Another common issue here -- if you're casting scores to ints (intentionally or not) these might fail.
        g1 = new GameScore("DAK", 10, true);
        g2 = new GameScore("DJK", 9.99, true);
        errors += Tester.doTest(true, g1.compareTo(g2) > 0, "g2.compareTo(g1) > 0");
        errors += Tester.doTest(true, g2.compareTo(g1) < 0, "g2.compareTo(g1) < 0");

        g1 = new GameScore("DAK", 10.01, false);
        g2 = new GameScore("DJK", 10, false);
        errors += Tester.doTest(true, g1.compareTo(g2) > 0, "g2.compareTo(g1) > 0");
        errors += Tester.doTest(true, g2.compareTo(g1) < 0, "g2.compareTo(g1) < 0");


        System.out.println("*********** Test Comparable implementation ********** ");
        // the sorting is at end as the pressure test
        GameScore[] scores = {
                new GameScore("DAK", 900, false),
                new GameScore("DAK", 999.9, false),
                new GameScore("DAK", 1000, false),
                new GameScore("DAK", 1000.1, false),
                new GameScore("DAK", 1100, false),
                new GameScore("DAK", 900, true),
                new GameScore("DAK", 999.9, true),
                new GameScore("DAK", 1000, true),
                new GameScore("DAK", 1000.1, true),
                new GameScore("DAK", 1100, true),
        }                                      ;
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            // shuffle
            for (int k = 0; k < scores.length-1; k++) {
                int swapPos = random.nextInt(scores.length-1-k)+k;
                GameScore tmp = scores[swapPos];
                scores[swapPos] = scores[k];
                scores[k] = tmp;
            }
            // sort -- this relies on you to implement Comparable correctly.
            // also note -- this will sort smallest-to-biggest.
            Arrays.sort(scores);
            // test
            errors += Tester.doTest("[DAK 900.0, DAK 999.9, DAK 1000.0, DAK 1000.1, DAK 1100.0, DAK 900.0*, DAK 999.9*, DAK 1000.0*, DAK 1000.1*, DAK 1100.0*]",
                    Arrays.toString(scores), "Arrays.toString(scores)");

        }

        System.out.println("******************* End of Testing ****************** ");
        System.out.println(errors + " errors");

    }
}