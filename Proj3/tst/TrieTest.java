package tst;
import Trie;

public class TrieTest {
    public static void main(String[] args) {
        int errors = 0;
        // This class is a bit harder to test. There's a lot of how it behaves _internally_
        // that we care about, but which is hard to really expose for testing. I don't think
        // I have an easy way to help you test that unfortunately.

        Trie<Integer> numbers = new Trie<>();
        errors += Tester.doTest(null, numbers.get("one"), "get(\"one\") method");

        numbers.put("one", 1);
        errors += Tester.doTest(1, numbers.get("one"), "get(\"one\") method");
        // (remember the root represents "", then it should have "o" as a child, then "on" etc.)

        errors += Tester.doTest(null, numbers.get("two"), "get(\"two\") method");

        numbers.put("two", 2);
        errors += Tester.doTest(2, numbers.get("two"), "get(\"two\") method");

        errors += Tester.doTest(null, numbers.get("ten"), "get(\"ten\") method");

        numbers.put("ten", 10);
        errors += Tester.doTest(10, numbers.get("ten"), "get(\"ten\") method");
        System.out.println("********************* Eng of testing *********************");
        System.out.println(errors + " errors");
    }
}