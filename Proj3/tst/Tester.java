package tst;
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
    public static int doTest(Object expected, Object output, String message) {

        if (expected == null && output != null) {
            System.out.print("Expected type was null");
            System.out.println(" but output type was " + output.getClass());
            return 1;
        }

        if (expected == null && output == null) {
            System.out.println(message + " passed test");
            return 0;
        }

        if (!expected.getClass().equals(output.getClass())) {
            System.out.print("Expected type was " + expected.getClass());
            System.out.println(" but output type was " + output.getClass());
            return 1;
        }

        if (expected.equals(output)) {
            System.out.println(message + " passed test");
            return 0;
        } else if (expected instanceof Double) { // add a tolerance to double tests
            double e = (double) expected;
            double o = (double) output;
            if (Math.abs(e-o) < 0.0001) {
                System.out.println(message + " passed test");
                return 0;
            } else {
                System.out.print(message + " failed, expected was " + expected);
                System.out.println(" but output was " + output);
                return 1;
            }
        } else {
            System.out.print(message + " failed, expected was " + expected);
            System.out.println(" but output was " + output + "!!!!!!");
            return 1;
        }
    }
}
