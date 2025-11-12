package tst;
import java.util.Set;
import java.util.TreeSet;

import Gibberisher;

public class GibberisherTests {
    public static void main(String[] args) {
        int errors = 0;
        // The purpose of this file is to do some **very** basic tests of the giberisher.

        // Test 1: is it counting segments right.
        Gibberisher gb = new Gibberisher(4);
        gb.train(new String[]{"apple", "dog", "november", "december"});
        errors += Tester.doTest(28, gb.getSampleCount(), "gb.getSampleCount()");

        // train should be callable more than once!
        gb.train(new String[]{"quest"});
        errors += Tester.doTest(34, gb.getSampleCount(), "gb.getSampleCount()");

        // Test 2: If we were to run the gibberisher right now, since it's only seen those words it should just
        // repeat them back. you have to train with A LOT of words to get useful behavior.

        Set<String> uniqueWords = new TreeSet<>();
        // we're using this  for testing -- remember -- you are not allowed the set or TreeSet classes!
        for(int i = 0; i < 200; i++) {
            uniqueWords.add(gb.generate());
        }

        String expected = "[apple, december, dog, november, quest]";
        errors += Tester.doTest(expected, uniqueWords.toString(), "generate words");


        // Test 3: If we feed very deliberate words in, we can get some very deliberate words out.
        gb = new Gibberisher(2);
        gb.train(new String[]{"abcdef", "defhijk"});
        uniqueWords = new TreeSet<>();
        for(int i = 0; i < 200; i++) {
            uniqueWords.add(gb.generate());
        }
        // because of the overlap of "def" in both words we can generate 4 options
        expected = "[abcdef, abcdefhijk, def, defhijk]";
        errors += Tester.doTest(expected, uniqueWords.toString(), "generate words");

        System.out.println("***************** End of testing *****************");
        System.out.println(errors + " errors");
    }
}
