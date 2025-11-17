/**
 * Tests for CSci 1913 Lab 11
 * Original version: James Moen
 * With Edits by Daniel Kluver and Mark Nie prior to Fall 2025
 * Modified by Adriana Picoral in Fall 2025
 */


public class MapTest {

    public static void main(String[] args) {
        int errors = 0;
        Map<String, String> hogwarts;
        hogwarts = new Map<String, String>(5);

        errors += Tester.doTest(0, hogwarts.size(), "hogwarts.size()");

        hogwarts.put("Harry", "Ginny");
        hogwarts.put("Ron", "Lavender");
        hogwarts.put("Voldemort", null);
        hogwarts.put(null, "Wormtail");

        errors += Tester.doTest(4, hogwarts.size(), "hogwarts.size()");

        errors += Tester.doTest(true, hogwarts.containsKey("Harry"), "hogwarts.containsKey(\"Harry\")");
        errors += Tester.doTest(false, hogwarts.containsKey("Ginny"), "hogwarts.containsKey(\"Ginny\")");
        errors += Tester.doTest(true, hogwarts.containsKey("Ron"), "hogwarts.containsKey(\"Ron\")");
        errors += Tester.doTest(true, hogwarts.containsKey("Voldemort"), "hogwarts.containsKey(\"Voldemort\")");
        errors += Tester.doTest(true, hogwarts.containsKey(null), "hogwarts.containsKey(null)");
        errors += Tester.doTest(false, hogwarts.containsKey("Joanne"), "hogwarts.containsKey(\"Joanne\")");


        errors += Tester.doTest("Ginny", hogwarts.get("Harry"), "hogwarts.get(\"Harry\")");
        errors += Tester.doTest("Lavender", hogwarts.get("Ron"), "hogwarts.get(\"Ron\")");
        errors += Tester.doTest(null, hogwarts.get("Voldemort"), "hogwarts.get(\"Voldemort\")");
        errors += Tester.doTest("Wormtail", hogwarts.get(null), "hogwarts.get(null)");
        errors += Tester.doTest(null, hogwarts.get("Joanne"), "hogwarts.get(\"Joanne\")");

        hogwarts.put("Ron", "Hermione");
        hogwarts.put("Albus", "Gellert");
        hogwarts.put(null, null);
        errors += Tester.doTest(5, hogwarts.size(), "hogwarts.size()");

        errors += Tester.doTest(true, hogwarts.containsKey(null), "hogwarts.containsKey(null)");
        errors += Tester.doTest(true, hogwarts.containsKey("Albus"), "hogwarts.containsKey(\"Albus\")");
        errors += Tester.doTest(false, hogwarts.containsKey("Hermione"), "hogwarts.containsKey(\"Hermione\")");

        errors += Tester.doTest("Gellert", hogwarts.get("Albus"), "hogwarts.get(\"Albus\")");
        errors += Tester.doTest("Ginny", hogwarts.get("Harry"), "hogwarts.get(\"Harry\")");
        errors += Tester.doTest("Hermione", hogwarts.get("Ron"), "hogwarts.get(\"Ron\")");
        errors += Tester.doTest(null, hogwarts.get("Voldemort"), "hogwarts.get(\"Voldemort\")");
        errors += Tester.doTest(null, hogwarts.get(null), "hogwarts.get(null)");


        // Testing generics support and array doubling
        // Weasley's Wizard Wheezes Candy List With Prices
        Map<String, Integer> weasleys = new Map<>(0);
        weasleys.put("Love Potion", 10);
        errors += Tester.doTest(1, weasleys.size(), "weasleys.size()");

        weasleys.put("U-No-Poo", 7);
        errors += Tester.doTest(2, weasleys.size(), "weasleys.size()");
        weasleys.put("Fever Fudge", 6);
        weasleys.put("Nosebleed Nougat", 8);
        weasleys.put("Skiving Snackboxes", 40);
        errors += Tester.doTest(5, weasleys.size(), "weasleys.size()");

        // A map whose key is a customized class
        Map<Point, Integer> pointMap = new Map<>(1);
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 1);
        Point p2_dup = new Point(2, 1);
        Point p3 = new Point(4, 5);

        pointMap.put(p1, 2);
        pointMap.put(p2, 7);
        pointMap.put(p2_dup, 10);
        errors += Tester.doTest(2, pointMap.get(p1), "pointMap.get(p1)");
        errors += Tester.doTest(10, pointMap.get(p2), "pointMap.get(p2)");
        errors += Tester.doTest(true, pointMap.containsKey(p1), "pointMap.containsKey(p1)");
        errors += Tester.doTest(false, pointMap.containsKey(p3), "pointMap.containsKey(p3)");
        errors += Tester.doTest(2, pointMap.size(), "pointMap.size()");

        pointMap.put(p3, 9);
        pointMap.put(null, 11);
        errors += Tester.doTest(11, pointMap.get(null), "pointMap.get(null)");

        System.out.println("****************** End of testing ******************");
        System.out.println(errors + " errors");

    }

}