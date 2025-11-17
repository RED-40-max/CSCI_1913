package tst;
import Tester;
import TrieNode;

public class TrieNodeTest {
    public static void main(String[] args) {
        int errors = 0;
        TrieNode<Double> tn = new TrieNode<>();
        errors += Tester.doTest(null, tn.getData(), "empty node");

        tn.setData(4.5);
        errors += Tester.doTest(4.5, tn.getData(), "tn.setData() and tn.getData()");

        tn.setData(4.54e5);
        errors += Tester.doTest(4.54e5, tn.getData(), "tn.setData() and tn.getData()");

        // (until we call getChild treeSize should stay at 1 (itself)).
        errors += Tester.doTest(1, tn.getTreeSize(), "tn.getTreeSize()");

        TrieNode<Double> an = tn.getChild('a');
        // calling getChild should add a child for a
        errors += Tester.doTest(2, tn.getTreeSize(), "tn.getTreeSize() with one child");

        TrieNode<Double> bn = tn.getChild('b');
        errors += Tester.doTest(3, tn.getTreeSize(), "tn.getTreeSize() with two children");
        System.out.println(tn);


        errors += Tester.doTest(an, tn.getChild('a'), "second tn.getData()");
        errors += Tester.doTest(bn, tn.getChild('b'), "second tn.getData()");
        errors += Tester.doTest(false, tn.getChild('a') == bn, "second tn.getData()");
        errors += Tester.doTest(false, tn.getChild('b') == an, "second tn.getData()");

        errors += Tester.doTest(3, tn.getTreeSize(), "tn.getTreeSize() with two children");

        an.getChild('b');
        // this should add 1 to the tree as an sees it
        // as well as 1 to the tree as the root node (tn) sees it.
        errors += Tester.doTest(2, an.getTreeSize(), "tn.getTreeSize() with one children");
        errors += Tester.doTest(1, bn.getTreeSize(), "tn.getTreeSize() with no children");
        errors += Tester.doTest(4, tn.getTreeSize(), "tn.getTreeSize() with two children, one child has a child");

        System.out.println("********************* Eng of testing *********************");
        System.out.println(errors + " errors");
    }
}