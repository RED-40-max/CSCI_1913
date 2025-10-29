import Battle;
import CodeMonster;
import Skill;

package CompLab08.Tests;
/**
 * BattleTester class file.
 * CSCI 1913.
 * Originall Written by Daniel Kluver
 * Modified by Adriana Picoral in Fall 2025
 */

public class BattleTester {
    public static void main(String[] args) {
        int errors = 0;

        // setup
        Skill sk1 = new Skill("recursion", 6, 4);
        Skill sk2 = new Skill("immutable", 3, 6);
        Skill sk3 = new Skill("iteration", 2, 200);

        CodeMonster cm1 = new CodeMonster(40, 5, "Scheme", new Skill[]{sk1, sk2});
        CodeMonster cm2 = new CodeMonster(40, 2.1, "C", new Skill[]{sk3});

        System.out.println("******* Test one turn -- cm2 should go and use sk3 *******");
        cm1.prepForBattle();
        cm2.prepForBattle();
        Battle.doOneTurn(cm1, cm2);                      // C 40/40 uses iteration 200/200 on Scheme 40/40
        errors += Tester.doTest(38, cm1.getHp(), "cm1.getHp()");
        errors += Tester.doTest(40, cm2.getHp(), "cm2.getHp()");
        errors += Tester.doTest(5.0, cm1.getNextTurnTime(), "cm1.getNextTurnTime()");
        errors += Tester.doTest(4.2, cm2.getNextTurnTime(), "cm2.getNextTurnTime()");
        errors += Tester.doTest(4, sk1.getUsageLeft(), "sk1.getUsageLeft()");
        errors += Tester.doTest(6, sk2.getUsageLeft(), "sk2.getUsageLeft()");
        errors += Tester.doTest(199, sk3.getUsageLeft(), "sk2.getUsageLeft()");

        System.out.println("******* Test another turn cm2 should go again and use sk3 *******");
        Battle.doOneTurn(cm1, cm2);                      // C 40/40 uses iteration 199/200 on Scheme 38/40
        errors += Tester.doTest(36, cm1.getHp(), "cm1.getHp()");
        errors += Tester.doTest(40, cm2.getHp(), "cm2.getHp()");
        errors += Tester.doTest(5.0, cm1.getNextTurnTime(), "cm1.getNextTurnTime()");
        errors += Tester.doTest(6.3, cm2.getNextTurnTime(), "cm2.getNextTurnTime()");
        errors += Tester.doTest(4, sk1.getUsageLeft(), "sk1.getUsageLeft()");
        errors += Tester.doTest(6, sk2.getUsageLeft(), "sk2.getUsageLeft()");
        errors += Tester.doTest(198, sk3.getUsageLeft(), "sk2.getUsageLeft()");

        System.out.println("******* Test a third turn, cm1 should go this time and use sk1 *******");
        Battle.doOneTurn(cm1, cm2);                      // Scheme 36/40 uses recursion 4/4 on C 40/40
        errors += Tester.doTest(36, cm1.getHp(), "cm1.getHp()");
        errors += Tester.doTest(34, cm2.getHp(), "cm2.getHp()");
        errors += Tester.doTest(10.0, cm1.getNextTurnTime(), "cm1.getNextTurnTime()");
        errors += Tester.doTest(6.3, cm2.getNextTurnTime(), "cm2.getNextTurnTime()");
        errors += Tester.doTest(3, sk1.getUsageLeft(), "sk1.getUsageLeft()");
        errors += Tester.doTest(6, sk2.getUsageLeft(), "sk2.getUsageLeft()");
        errors += Tester.doTest(198, sk3.getUsageLeft(), "sk2.getUsageLeft()");


        System.out.println("******* Setup a test where cm1 and cm2 are tired. In this case, cm1 should go and use sk2 *******");
        cm1.setNextTurnTime(10);
        cm2.setNextTurnTime(10);
        Battle.doOneTurn(cm1, cm2);                      // Scheme 36/40 uses immutable 6/6 on C 34/40
        errors += Tester.doTest(36, cm1.getHp(), "cm1.getHp()");
        errors += Tester.doTest(31, cm2.getHp(), "cm2.getHp()");
        errors += Tester.doTest(15.0, cm1.getNextTurnTime(), "cm1.getNextTurnTime()");
        errors += Tester.doTest(10.0, cm2.getNextTurnTime(), "cm2.getNextTurnTime()");
        errors += Tester.doTest(3, sk1.getUsageLeft(), "sk1.getUsageLeft()");
        errors += Tester.doTest(5, sk2.getUsageLeft(), "sk2.getUsageLeft()");
        errors += Tester.doTest(198, sk3.getUsageLeft(), "sk2.getUsageLeft()");


        System.out.println("******* Test a real battle between sk1 and sk2 *******");
        // important note -- the conditions of battle from the previous code should
        // be reset by prep to battle before the fight!
        CodeMonster winner = Battle.battle(cm1, cm2);

        /* Expected output:
        Scheme 40/40 vs. C 40/40
        C 40/40 uses iteration 200/200 on Scheme 40/40
        C 40/40 uses iteration 199/200 on Scheme 38/40
        Scheme 36/40 uses recursion 4/4 on C 40/40
        C 34/40 uses iteration 198/200 on Scheme 36/40
        C 34/40 uses iteration 197/200 on Scheme 34/40
        Scheme 32/40 uses immutable 6/6 on C 34/40
        C 31/40 uses iteration 196/200 on Scheme 32/40
        C 31/40 uses iteration 195/200 on Scheme 30/40
        C 31/40 uses iteration 194/200 on Scheme 28/40
        Scheme 26/40 uses recursion 3/4 on C 31/40
        C 25/40 uses iteration 193/200 on Scheme 26/40
        C 25/40 uses iteration 192/200 on Scheme 24/40
        Scheme 22/40 uses immutable 5/6 on C 25/40
        C 22/40 uses iteration 191/200 on Scheme 22/40
        C 22/40 uses iteration 190/200 on Scheme 20/40
        Scheme 18/40 uses recursion 2/4 on C 22/40
        C 16/40 uses iteration 189/200 on Scheme 18/40
        C 16/40 uses iteration 188/200 on Scheme 16/40
        C 16/40 uses iteration 187/200 on Scheme 14/40
        Scheme 12/40 uses immutable 4/6 on C 16/40
        C 13/40 uses iteration 186/200 on Scheme 12/40
        C 13/40 uses iteration 185/200 on Scheme 10/40
        Scheme 8/40 uses recursion 1/4 on C 13/40
        C 7/40 uses iteration 184/200 on Scheme 8/40
        C 7/40 uses iteration 183/200 on Scheme 6/40
        C 7/40 uses iteration 182/200 on Scheme 4/40
        Scheme 2/40 uses immutable 3/6 on C 7/40
        C 4/40 uses iteration 181/200 on Scheme 2/40
        C 4/40 wins!
         */

        errors += Tester.doTest(true, winner == cm2, "cm2 wins");

        System.out.println("**************************** End of testing ****************************");
        System.out.println(errors + " errors");
    }
}
