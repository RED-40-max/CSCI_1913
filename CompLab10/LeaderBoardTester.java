/**
 * Tester class file.
 * CSCI 1913.
 * Originally written by Daniel Kluver
 * Changed by Adriana Picoral in Fall 2025
 */

public class LeaderBoardTester {

    public static void main(String[] args) {
        int errors = 0;
        // there are a fair number of tests -- mostly split between different data types, since you're building
        // something that's meant to be generic across multiple data types.
        // I recommend maybe only running one at a time at first -- then if you jsut want to confirm you passed (rather
        // than use this to debug what's wrong) -- look for true at the end of each test section.


        errors += integerTests();
        errors += doubleTests();
        errors += stringTests();
        errors += gameScoreTests();
        System.out.println("**************** End of Testing *******************");
        System.out.println(errors + " errors");
    }

    public static int integerTests() {
        int errors = 0;
        System.out.println("-------------------------------------");
        System.out.println("Test cases for INTEGER");
        System.out.println("Test 1\n");

        LeaderBoard<Integer> lb = new LeaderBoard<>(5, 1);
        for (int i = 20; i > 0; i-=2) {
            lb.add(i);
        }
        String before = lb.toString();
        System.out.println("before adding");
        System.out.println(before);
        lb.add(lb.lowScore());
        System.out.println("after adding " + lb.lowScore());
        String after = lb.toString();
        System.out.println(after);

        errors += Tester.doTest(after, before, "before matched after");

        System.out.println("\nTest 2\n");


        System.out.println("before adding");
        System.out.println(before);
        int before_low = lb.lowScore();
        int val = lb.lowScore()+1;
        lb.add(val);
        int after_low = lb.lowScore();
        System.out.println("after adding " + val);
        after = lb.toString();
        System.out.println(after);

        errors += Tester.doTest(true, before_low < after_low, "before_low < after_low");

        System.out.println("\nTest 3\n");

        String expected;
        String []seg;
        String middle;
        System.out.println("before adding");
        before = lb.toString();
        System.out.println(before);
        seg = lb.toString().split("\n", 0);
        middle = seg[seg.length/2];
        val = Integer.parseInt(middle.split(" ")[1]);
        lb.add(val);
        System.out.println("after adding " + val);
        after = lb.toString();
        System.out.println(after);
        expected = "1. 20\n" +
                "2. 18\n" +
                "3. 16\n" +
                "4. 16\n" +
                "5. 14\n";

        errors += Tester.doTest(true, expected.equals(after), "expected.equals(after)");

        System.out.println("\nTest 4\n");

        System.out.println("before adding");
        before = lb.toString();
        System.out.println(before);
        val = lb.highScore()+1;
        lb.add(val);
        System.out.println("after adding " + val);
        after = lb.toString();
        System.out.println(after);

        errors += Tester.doTest(true, lb.highScore() == val, "lb.highScore() == val");

        System.out.println("\nTest 5\n");

        System.out.println("before adding");
        before = lb.toString();
        System.out.println(before);
        val = lb.highScore()+1;
        lb.add(val);
        System.out.println("after adding " + val);
        after = lb.toString();
        System.out.println(after);

        errors += Tester.doTest(true, lb.highScore() == val, "lb.highScore() == val");

        System.out.println("\nTest 6\n");
        lb = new LeaderBoard<>(5, 2);

        System.out.println("before flushing");
        before = lb.toString();
        System.out.println(before);

        for (int i = 30; i > 0; i-=1) {
            lb.add(i);
        }
        System.out.println("after flushing ");
        after = lb.toString();
        System.out.println(after);

        val = 5;
        lb.add(val);
        System.out.println("after adding " + val);
        after = lb.toString();
        System.out.println(after);

        expected = "1. 30\n" +
                "2. 29\n" +
                "3. 28\n" +
                "4. 27\n" +
                "5. 26\n";

        errors += Tester.doTest(expected, after, "after matched expected");
        return errors;

    }

    public static int doubleTests() {
        int errors = 0;
        System.out.println("-------------------------------------");
        System.out.println("Test cases for DOUBLE");
        System.out.println("Test 1\n");

        LeaderBoard<Double> lbDouble = new LeaderBoard<Double>(5, 0.001);

        for (int i = 20; i > 0; i-=2) {
            lbDouble.add(i+0.01);
        }
        String before = lbDouble.toString();
        System.out.println("before adding");
        System.out.println(before);
        lbDouble.add(lbDouble.lowScore());
        System.out.println("after adding " + lbDouble.lowScore());
        String after = lbDouble.toString();
        System.out.println(after);

        errors += Tester.doTest(after, before, "before matched after");

        System.out.println("\nTest 2\n");


        System.out.println("before adding");
        System.out.println(before);
        Double beforeLowDouble = lbDouble.lowScore();
        Double valDouble = lbDouble.lowScore()+1;
        lbDouble.add(valDouble);
        Double afterLowDouble = lbDouble.lowScore();
        System.out.println("after adding " + valDouble);
        after = lbDouble.toString();
        System.out.println(after);

        errors += Tester.doTest(true, beforeLowDouble < afterLowDouble, "beforeLowDouble < afterLowDouble");

        System.out.println("\nTest 3\n");

        System.out.println("before adding");
        before = lbDouble.toString();
        System.out.println(before);
        String[] seg = lbDouble.toString().split("\n", 0);
        String middle = seg[seg.length/2];
        valDouble = Double.valueOf(middle.split(" ")[1]);
        lbDouble.add(valDouble);
        System.out.println("after adding " + valDouble);
        after = lbDouble.toString();
        System.out.println(after);

        String expected = "1. 20.01\n" +
                "2. 18.01\n" +
                "3. 16.01\n" +
                "4. 16.01\n" +
                "5. 14.01\n";

        errors += Tester.doTest(true, expected.equals(after), "expected.equals(after)");

        System.out.println("\nTest 4\n");

        System.out.println("before adding");
        before = lbDouble.toString();
        System.out.println(before);
        valDouble = lbDouble.highScore()+1;
        lbDouble.add(valDouble);
        System.out.println("after adding " + valDouble);
        after = lbDouble.toString();
        System.out.println(after);

        errors += Tester.doTest(true, lbDouble.highScore() == valDouble, "lbDouble.highScore() == valDouble");

        System.out.println("\nTest 5\n");

        System.out.println("before adding");
        before = lbDouble.toString();
        System.out.println(before);
        valDouble = lbDouble.highScore()+1;
        lbDouble.add(valDouble);
        System.out.println("after adding " + valDouble);
        after = lbDouble.toString();
        System.out.println(after);

        errors += Tester.doTest(true, lbDouble.highScore() == valDouble, "lbDouble.highScore() == valDouble");

        System.out.println("\nTest 6\n");
        lbDouble = new LeaderBoard<>(5, 0.2);

        System.out.println("before flushing");
        before = lbDouble.toString();
        System.out.println(before);

        for (int i = 30; i > 0; i-=1) {
            lbDouble.add(i+0.1);
        }
        System.out.println("after flushing ");
        after = lbDouble.toString();
        System.out.println(after);

        valDouble = 5+0.1;
        lbDouble.add(valDouble);
        System.out.println("after adding " + valDouble);
        after = lbDouble.toString();
        System.out.println(after);

        expected = "1. 30.1\n" +
                "2. 29.1\n" +
                "3. 28.1\n" +
                "4. 27.1\n" +
                "5. 26.1\n";

        errors += Tester.doTest(expected, after, "after matched expected");

        return errors;

    }

    public static int stringTests() {
        int errors = 0;
        System.out.println("-------------------------------------");
        System.out.println("Test cases for STRING");
        System.out.println("Test 1\n");

        LeaderBoard<String> lbString = new LeaderBoard<String>(5, "aaa");

        for (int i = 20; i > 0; i-=2) {
            lbString.add(Character.toString((char) (97+i)));
        }
        String before = lbString.toString();
        System.out.println("before adding");
        System.out.println(before);
        lbString.add(lbString.lowScore());
        System.out.println("after adding " + lbString.lowScore());
        String after = lbString.toString();
        System.out.println(after);

        errors += Tester.doTest(before, after, "after matched before");

        System.out.println("\nTest 2\n");

        System.out.println("before adding");
        System.out.println(before);
        String beforeLowString = lbString.lowScore();
        String valString = lbString.lowScore()+"b";
        lbString.add(valString);
        String afterLowString = lbString.lowScore();
        System.out.println("after adding " + valString);
        after = lbString.toString();
        System.out.println(after);

        errors += Tester.doTest(true, beforeLowString.compareTo(afterLowString)<0, "beforeLowString.compareTo(afterLowString)<0");

        System.out.println("\nTest 3\n");

        System.out.println("before adding");
        before = lbString.toString();
        System.out.println(before);
        String[] seg = lbString.toString().split("\n", 0);
        String middle = seg[seg.length/2];
        valString = middle.split(" ")[1];
        lbString.add(valString);
        System.out.println("after adding " + valString);
        after = lbString.toString();
        System.out.println(after);

        String expected = "1. u\n" +
                "2. s\n" +
                "3. q\n" +
                "4. q\n" +
                "5. o\n";

        errors += Tester.doTest(expected, after, "after matched expected");

        System.out.println("\nTest 4\n");

        System.out.println("before adding");
        before = lbString.toString();
        System.out.println(before);
        valString = lbString.highScore()+"bb";
        lbString.add(valString);
        System.out.println("after adding " + valString);
        after = lbString.toString();
        System.out.println(after);

        errors += Tester.doTest(valString, lbString.highScore(), "lbString.highScore() matched valString");

        System.out.println("\nTest 5\n");

        System.out.println("before adding");
        before = lbString.toString();
        System.out.println(before);
        valString = lbString.highScore()+"d";
        lbString.add(valString);
        System.out.println("after adding " + valString);
        after = lbString.toString();
        System.out.println(after);

        errors += Tester.doTest(valString, lbString.highScore(), "lbString.highScore() matched valString");

        System.out.println("\nTest 6\n");
        lbString = new LeaderBoard<String>(5, "bbb");

        System.out.println("before flushing");
        before = lbString.toString();
        System.out.println(before);

        for (int i = 25; i > 0; i-=1) {
            lbString.add(Character.toString((char) (97+i)));
        }
        System.out.println("after flushing ");
        after = lbString.toString();
        System.out.println(after);

        valString = "ccc";
        lbString.add(valString);
        System.out.println("after adding " + valString);
        after = lbString.toString();
        System.out.println(after);

        expected = "1. z\n" +
                "2. y\n" +
                "3. x\n" +
                "4. w\n" +
                "5. v\n";

        errors += Tester.doTest(expected, after, "after matched expected");
        return errors;
    }

    public static int gameScoreTests() {
        int errors = 0;
        System.out.println("-------------------------------------");
        System.out.println("Test cases for GAMESCORE");
        System.out.println("Test 1\n");

        LeaderBoard<GameScore> lbGameScore = new LeaderBoard<GameScore>(5, new GameScore("aaa", 1.1, true));
        for (int i = 20; i > 0; i-=2) {
            lbGameScore.add(new GameScore("DAK",i+0.01, true));
        }
        String before = lbGameScore.toString();
        System.out.println("before adding");
        System.out.println(before);
        lbGameScore.add(new GameScore("KEV", 12.01, true));
        System.out.println("after adding " + new GameScore("KEV", 12.01, true));
        String after = lbGameScore.toString();
        System.out.println(after);

        errors += Tester.doTest(after, before, "before matched after");

        System.out.println("\nTest 2\n");


        System.out.println("before adding");
        System.out.println(before);
        GameScore beforeLowGameScore = lbGameScore.lowScore();
        GameScore valGameScore = new GameScore("NEW", lbGameScore.lowScore().getScore()+1, true);
        lbGameScore.add(valGameScore);
        GameScore afterLowGameScore = lbGameScore.lowScore();
        System.out.println("after adding " + valGameScore);
        after = lbGameScore.toString();
        System.out.println(after);

        errors += Tester.doTest(true, beforeLowGameScore.compareTo(afterLowGameScore) < 0, "beforeLowGameScore.compareTo(afterLowGameScore) < 0");

        System.out.println("\nTest 3\n");

        System.out.println("before adding");
        before = lbGameScore.toString();
        System.out.println(before);
        String[] seg = lbGameScore.toString().split("\n", 0);
        String middle = seg[seg.length/2];
        middle = middle.split(" ")[2];
        double valDouble = Double.valueOf(middle.substring(0, middle.length()-1));
        valGameScore = new GameScore("NEW", valDouble, true);
        lbGameScore.add(valGameScore);
        System.out.println("after adding " + valGameScore.toString());
        after = lbGameScore.toString();
        System.out.println(after);

        // NOTE the new 16.01 score should go after the old one.
        String expected = "1. DAK 20.01*\n" +
                "2. DAK 18.01*\n" +
                "3. DAK 16.01*\n" +
                "4. NEW 16.01*\n" +
                "5. DAK 14.01*\n";

        errors += Tester.doTest(expected, after, "after matched expected");

        System.out.println("\nTest 4\n");

        System.out.println("before adding");
        before = lbGameScore.toString();
        System.out.println(before);
        valDouble = lbGameScore.highScore().getScore()+1;
        valGameScore = new GameScore("NEW", valDouble, true);
        lbGameScore.add(valGameScore);
        System.out.println("after adding " + valGameScore.toString());
        after = lbGameScore.toString();
        System.out.println(after);

        errors += Tester.doTest(valGameScore, lbGameScore.highScore() , "lbGameScore.highScore()  matched valGameScore");

        System.out.println("\nTest 5\n");

        System.out.println("before adding");
        before = lbGameScore.toString();
        System.out.println(before);
        valDouble = lbGameScore.highScore().getScore()+1;
        valGameScore = new GameScore("NEW", valDouble, true);
        lbGameScore.add(valGameScore);
        System.out.println("after adding " + valGameScore);
        after = lbGameScore.toString();
        System.out.println(after);

        errors += Tester.doTest(valGameScore, lbGameScore.highScore() , "lbGameScore.highScore()  matched valGameScore");

        System.out.println("\nTest 6\n");
        lbGameScore = new LeaderBoard<GameScore>(5, new GameScore("aaa", 0.1, false));

        System.out.println("before flushing");
        before = lbGameScore.toString();
        System.out.println(before);

        for (int i = 30; i > 0; i-=1) {
            lbGameScore.add(new GameScore("NEW", i+0.1, true));
        }
        System.out.println("after flushing ");
        after = lbGameScore.toString();
        System.out.println(after);

        valDouble = 5+0.1;
        valGameScore = new GameScore("LAST", valDouble, true);
        lbGameScore.add(valGameScore);
        System.out.println("after adding " + valGameScore.toString());
        after = lbGameScore.toString();
        System.out.println(after);

        expected = "1. NEW 30.1*\n" +
                "2. NEW 29.1*\n" +
                "3. NEW 28.1*\n" +
                "4. NEW 27.1*\n" +
                "5. NEW 26.1*\n";

        errors += Tester.doTest(expected, after, "after matched expected");
        return errors;

    }



}

