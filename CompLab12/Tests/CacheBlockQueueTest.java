package Tests;
/**
 * CacheBlockQueueNodeTest tester file
 * Original author: Daniel Kluver
 * Modified by Adriana Picoral in Fall 2025
 */

public class CacheBlockQueueTest {
    public static void main(String[] args) {
        int errors = 0;
        ///////////////////////////////////////////////////////////////
        System.out.println("************* Test initial conditions and constructor *************");
        ///////////////////////////////////////////////////////////////

        CacheBlockQueue<String> rq = new CacheBlockQueue<>();
        errors += Tester.doTest(null, rq.front(), "empty queue front");
        errors += Tester.doTest(null, rq.dequeue(), "empty queue dequeue");
        errors += Tester.doTest(0, rq.getSize(), "empty queue getSize");
        errors += Tester.doTest(0, rq.frontOfLineRepeatCount(), "empty queue frontOfLineRepeatCount");
        errors += Tester.doTest(true, rq.isEmpty(), "empty queue isEmpty");
        errors += Tester.doTest("", rq.toString(), "empty queue toString");

        ///////////////////////////////////////////////
        System.out.println("************* Test non-CacheBlock behavior *************");
        ///////////////////////////////////////////////

        rq.enqueue("apple");
        errors += Tester.doTest(false, rq.isEmpty(), "queue isEmpty");
        errors += Tester.doTest(1, rq.getSize(), "queue getSize");
        errors += Tester.doTest(1, rq.frontOfLineRepeatCount(), "queue frontOfLineRepeatCount");
        errors += Tester.doTest("apple", rq.front(), "queue front");
        errors += Tester.doTest("apple:1", rq.toString(), "queue toString");

        rq.enqueue("banana");
        errors += Tester.doTest(false, rq.isEmpty(), "queue isEmpty");
        errors += Tester.doTest(2, rq.getSize(), "queue getSize");
        errors += Tester.doTest(1, rq.frontOfLineRepeatCount(), "queue frontOfLineRepeatCount");
        errors += Tester.doTest("apple", rq.front(), "queue front");
        errors += Tester.doTest("apple:1, banana:1", rq.toString(), "queue toString");

        errors += Tester.doTest("apple", rq.dequeue(), "queue dequeue");
        errors += Tester.doTest(false, rq.isEmpty(), "queue isEmpty");
        errors += Tester.doTest(1, rq.getSize(), "queue getSize");
        errors += Tester.doTest(1, rq.frontOfLineRepeatCount(), "queue frontOfLineRepeatCount");

        errors += Tester.doTest("banana", rq.front(), "queue front");
        errors += Tester.doTest("banana:1", rq.toString(), "queue toString");

        rq.enqueue("apple");
        rq.enqueue("pear");
        rq.enqueue("banana");
        errors += Tester.doTest(4, rq.getSize(), "queue getSize");
        errors += Tester.doTest("banana", rq.front(), "queue front");

        errors += Tester.doTest("banana:1, apple:1, pear:1, banana:1", rq.toString(), "queue toString");
        errors += Tester.doTest("banana", rq.dequeue(), "queue dequeue");
        errors += Tester.doTest("apple", rq.dequeue(), "queue dequeue");
        errors += Tester.doTest("pear", rq.dequeue(), "queue dequeue");
        errors += Tester.doTest("banana", rq.dequeue(), "queue dequeue");

        errors += Tester.doTest(null, rq.front(), "queue front");
        errors += Tester.doTest(null, rq.dequeue(), "queue dequeue");

        errors += Tester.doTest(0, rq.getSize(), "queue getSize");
        errors += Tester.doTest(0, rq.frontOfLineRepeatCount(), "queue frontOfLineRepeatCount");

        errors += Tester.doTest(true, rq.isEmpty(), "queue isEmpty");
        errors += Tester.doTest(null, rq.dequeue(), "queue dequeue");
        errors += Tester.doTest(0, rq.getSize(), "queue getSize");
        errors += Tester.doTest("", rq.toString(), "queue toString");

        rq.enqueue("apple");
        rq.enqueue("pear");
        errors += Tester.doTest("apple", rq.dequeue(), "queue dequeue");
        errors += Tester.doTest("pear", rq.dequeue(), "queue dequeue");
        errors += Tester.doTest(true, rq.isEmpty(), "queue isEmpty");

        ///////////////////////////////////////////
        System.out.println("************* Test CacheBlock behavior *************");
        ///////////////////////////////////////////

        for (int i = 0; i < 10; i++) {
            rq.enqueue("apple");
        }
        for (int i = 0; i < 13; i++) {
            rq.enqueue("pear");
        }
        for (int i = 0; i < 4; i++) {
            rq.enqueue("apple");
        }
        for (int i = 0; i < 2; i++) {
            rq.enqueue("banana");
        }

        errors += Tester.doTest("apple", rq.front(), "queue front");
        errors += Tester.doTest(10, rq.frontOfLineRepeatCount(), "queue frontOfLineRepeatCount");
        errors += Tester.doTest(29, rq.getSize(), "queue getSize");

        errors += Tester.doTest("apple:10, pear:13, apple:4, banana:2", rq.toString(), "queue toString");

        for (int i = 0; i < 8; i++) {
            if(!rq.dequeue().equals("apple")) {
                System.out.println("Test fail - wrong deque");
            }
        }

        errors += Tester.doTest("apple", rq.front(), "queue front");
        errors += Tester.doTest(2, rq.frontOfLineRepeatCount(), "queue frontOfLineRepeatCount");
        errors += Tester.doTest(21, rq.getSize(), "queue getSize");
        errors += Tester.doTest("apple:2, pear:13, apple:4, banana:2", rq.toString(), "queue toString");

        for (int i = 0; i < 2; i++) {
            if(!rq.dequeue().equals("apple")) {
                System.out.println("Test fail - wrong dequue");
            }
        }
        for (int i = 0; i < 12; i++) {
            if(!rq.dequeue().equals("pear")) {
                System.out.println("Test fail - wrong dequue");
            }
        }

        errors += Tester.doTest("pear", rq.front(), "queue front");
        errors += Tester.doTest(1, rq.frontOfLineRepeatCount(), "queue frontOfLineRepeatCount");
        errors += Tester.doTest(7, rq.getSize(), "queue getSize");
        errors += Tester.doTest("pear:1, apple:4, banana:2", rq.toString(), "queue toString");

        int count = 0;
        while(!rq.isEmpty()) {
            count++;
            rq.dequeue();
        }

        errors += Tester.doTest(7, count, "how many to remove to get to empty");

        rq.enqueue("banana");
        errors += Tester.doTest("banana", rq.front(), "queue front");

        System.out.println("********************* End of testing *********************");
        System.out.print(errors + " errors");
    }
}