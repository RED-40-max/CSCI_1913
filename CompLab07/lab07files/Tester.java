/**
 * Tester class file.
 * CSCI 1913.
 * Written by Adriana Picoral in Fall 2025
 */

public class Tester {

    /**
     * doTest prints helpful messages informing the user whether
     * a test passed.
     * @param expected
     * @param output
     * @param message -- name of a method, or test
     */
    public static void doTest(Object expected, Object output, String message) {
        if (expected.equals(output)) {
            System.out.println(message + " passed test");
        } else if (expected instanceof Double) { // add a tolerance to double tests
            double e = (double) expected;
            double o = (double) output;
            if (Math.abs(e-o) < 0.0001) {
                System.out.println(message + " passed test");
            } else {
                System.out.print(message + " failed, expected was " + expected);
                System.out.println(" but output was " + output);
            }
        } else {
            System.out.print(message + " failed, expected was " + expected);
            System.out.println(" but output was " + output);
        }
    }
}
