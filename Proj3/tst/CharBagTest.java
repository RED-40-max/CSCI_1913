package tst;
import CharBag;
import LetterSample;
import Tester;

public class CharBagTest {
    public static void main(String[] args) {
        int errors = 0;
        CharBag cb = new CharBag();

        errors += testInitial(cb);
        errors += oneLetter(cb);

        errors += emptyAgain(cb);

        errors +=  addABunch(cb);

        errors += testRemove(cb);
        errors += emptyItOut(cb);
        errors += Tester.doTest(0, cb.getSize(), "cb.getSize()");

        ////////////
        // test caps
        ////////////
        cb.add('A');
        cb.add('B');
        String expected = "CharBag{a:1, b:1, c:0, d:0, e:0, f:0, g:0, h:0, i:0, j:0, k:0, l:0, m:0, n:0, o:0, p:0, q:0, r:0, s:0, t:0, u:0, v:0, w:0, x:0, y:0, z:0, .:0}";
        errors += Tester.doTest(expected, cb.toString(), "cb.toString()");

        errors += emptyItOut(cb);
        errors += addMore(cb);

        cb = new CharBag();
        errors += Tester.doTest(0, cb.getSize(), "cb.getSize()");
        testRandom(cb);

        // shift the proportions
        cb.add('b');
        cb.add('b');
        cb.add('b');

        testRandom(cb);

        System.out.println("***************** End of testing *****************");
        System.out.println(errors + " errors");
    }

    private static int testRandom(CharBag cb) {
        int errors = 0;
        ////////////////////////////////
        // test random letter generation
        ////////////////////////////////
        cb.add('a');
        cb.add('b');
        cb.add('b');
        int a = 0;
        int b = 0;
        for (int i = 0; i < 10000; i++) {
            char c = cb.getRandomChar();
            if (c == 'a') {
                a++;
            } else if (c == 'b') {
                b++;
            } else {
                errors++;
                System.out.println("Test failed, a CharBag with only a and b generated a not a/b value");
            }
        }
        System.out.println(a + ", " + b);
        // random, being the way it is, means that we can't predict the exact values here. But, they should be close to each other.
        // however, if I did my math right then 95% of the time a and b should be between 5098 and 4902 (inclusive)
        // run this a few times, if your mostly in these bounds you're fine.
        return errors;
    }

    private static int emptyItOut(CharBag cb) {
        int errors = 0;
        ///////////////
        // empty it out
        ///////////////
        for (char c = 'a'; c <= 'z'; c++) {
            cb.remove(c);
            cb.remove(c);
        }
        errors += Tester.doTest(0, cb.getSize(), "cb.getSize()");
        return errors;
    }

    private static int addMore(CharBag cb) {
        int errors = 0;
        ///////////////////////////////////////////
        // test that invalid letters all map to '.'
        ///////////////////////////////////////////
        String toAdd = "`1234567890-=~!@#$%^&*()_+[]{}\\|;:'\".,/<>? \t\n";
        for (int i = 0; i < toAdd.length(); i++) {
            cb.add(toAdd.charAt(i));
        }

        errors += Tester.doTest(45, cb.getSize(), "cb.getSize()");
        errors += Tester.doTest(45, cb.getCount(LetterSample.STOP), "cb.getCount(LetterSample.STOP)");
        errors += Tester.doTest(45, cb.getCount('@'), "cb.getCount('@')");

        return errors;
    }

    private static int testRemove(CharBag cb) {
        int errors = 0;
        /////////////////////////////////////////////////////////////
        // test remove, also removing things not in the bag.
        /////////////////////////////////////////////////////////////
        for (char c = 'a'; c <= 'z'; c++) {
            cb.remove(c);
        }

        String expected = "CharBag{a:2, b:0, c:0, d:2, e:2, f:2, g:2, h:2, i:0, j:2, k:0, l:2, m:0, n:0, o:2, p:0, q:2, r:2, s:2, t:2, u:2, v:0, w:2, x:0, y:2, z:0, .:0}";
        errors += Tester.doTest(expected, cb.toString(), "cb.toString()");
        errors += Tester.doTest(32, cb.getSize(), "cb.getSize()");
        return errors;
    }

    private static int addABunch(CharBag cb) {
        int errors = 0;
        String toAdd = "qawsedfrtghyujloqawsedfrtghyujkolqawsedfrtguyhjlop";
        for (int i = 0; i < toAdd.length(); i++) {
            cb.add(toAdd.charAt(i));
        }
        String expected = "CharBag{a:3, b:0, c:0, d:3, e:3, f:3, g:3, h:3, i:0, j:3, k:1, l:3, m:0, n:0, o:3, p:1, q:3, r:3, s:3, t:3, u:3, v:0, w:3, x:0, y:3, z:0, .:0}";
        errors += Tester.doTest(expected, cb.toString(), "cb.toString()");
        errors += Tester.doTest(50, cb.getSize(), "cb.getSize()");
        return errors;
    }

    private static int emptyAgain(CharBag cb) {
        int errors = 0;
        cb.remove('a');
        for (char c = 'a'; c <= 'z'; c++) {
            errors += Tester.doTest(0, cb.getCount(c), "cb.getCount(c)");
        }

        errors += Tester.doTest(0, cb.getCount(LetterSample.STOP), "empty CharBag");
        errors += Tester.doTest(0, cb.getSize(), "cb.getSize()");

        for (int i = 0; i < 100; i++) {
            errors += Tester.doTest(LetterSample.STOP, cb.getRandomChar(), "an empty charBag randomly generates '.'");
        }
        return errors;
    }

    private static int oneLetter(CharBag cb) {
        int errors = 0;
        cb.add('a');
        errors += Tester.doTest(1, cb.getCount('a'), "cb.getCount('a')");
        errors += Tester.doTest(1, cb.getSize(), "cb.getSize()");

        for (char c = 'b'; c <= 'z'; c++) {
            errors += Tester.doTest(0, cb.getCount(c), "cb.getCount(c)");
        }
        for (int i = 0; i < 100; i++) {
            errors += Tester.doTest('a', cb.getRandomChar(), "cb.getRandomChar()");
        }
        return errors;
    }

    private static int testInitial(CharBag cb) {
        int errors = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            if (cb.getCount(c) != 0) {
                errors++;
                System.out.println("Test failed -- empty CharBag has something in it!");
            } else {
                System.out.println("Test passed.");
            }
        }
        if (cb.getCount(LetterSample.STOP) != 0) {
            errors++;
            System.out.println("Test failed -- empty CharBag has something in it!");
        }

        errors += Tester.doTest(0, cb.getSize(), "cb.getSize()");

        for (int i = 0; i < 100; i++) {
            if (cb.getRandomChar() != LetterSample.STOP) {
                errors++;
                System.out.println("Test failed -- an empty charBag should only randomly generate '.'");
            }
        }
        return errors;
    }
}

/* Your results on the last two may vary:
4936, 5064 <this number shouldn't match exactly>
5869, 4131 <this number shouldn't match exactly>

 */