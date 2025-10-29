import CodeMonster;
import Skill;

package CompLab08.Tests;
/**
 * CodeMonsterTester class file.
 * CSCI 1913.
 * Originall Written by Daniel Kluver
 * Modified by Adriana Picoral in Fall 2025
 */

public class CodeMonsterTester {
    public static void main(String[] args) {
        int errors = 0;

        System.out.println("***** Test CodeMonster constructors, getters, toString *****");
        Skill sk1 = new Skill("tarpit", 10, 3);
        Skill[] ska1 = new Skill[]{sk1};
        CodeMonster cm1 = new CodeMonster(103, 10.3, "BF", ska1);
        Skill sk2 = new Skill("for loop", 3, 10);
        Skill[] ska2 = new Skill[]{sk2};
        CodeMonster cm2 = new CodeMonster(14, 1, "C++", ska2);

        errors += Tester.doTest(103, cm1.getMaxHp(), "CodeMonster.getMaxHp()");
        errors += Tester.doTest(10.3, cm1.getSpeedScore(), "CodeMonster.getSpeedScore()");
        errors += Tester.doTest("BF", cm1.getName(), "CodeMonster.getName()");
        errors += Tester.doTest(true, ska1 == cm1.getMoves(), "CodeMonster.getMaxHp()");

        errors += Tester.doTest(14, cm2.getMaxHp(), "CodeMonster.getMaxHp()");
        errors += Tester.doTest(1.0, cm2.getSpeedScore(), "CodeMonster.getSpeedScore()");
        errors += Tester.doTest("C++", cm2.getName(), "CodeMonster.getName()");
        errors += Tester.doTest(true, ska2 == cm2.getMoves(), "CodeMonster.getMaxHp()");

        System.out.println("***** Test CodeMonster.toString() *****");
        String cm1s = cm1.toString();
        String cm2s = cm2.toString();
        errors += Tester.doTest("BF 103/103", cm1s, "CodeMonster.toString()");
        errors += Tester.doTest("C++ 14/14", cm2s, "CodeMonster.toString()");


        System.out.println("***** Test CodeMonster prep for battle initial values *****");
        sk1 = new Skill("tarpit", 10, 3);
        // use the skill to get a usage out -- this should be reset later.
        sk1.useSkill(cm1, cm2);
        errors += Tester.doTest(2, sk1.getUsageLeft(), "Skill.getUsageLeft()after prepForBattle");

        ska1 = new Skill[]{sk1};
        cm1 = new CodeMonster(103, 10.3, "BF", ska1);
        cm1.prepForBattle();
        errors += Tester.doTest(103, cm1.getHp(), "CodeMonster.getHp() after prepForBattle");
        errors += Tester.doTest(true, cm1.isAlive(), "CodeMonster.isAlive() after prepForBattle");
        errors += Tester.doTest(10.3, cm1.getNextTurnTime(), "CodeMonster.getNextTurnTime() after prepForBattle");
        errors += Tester.doTest(3, sk1.getUsageLeft(), "Skill.getUsageLeft()after prepForBattle");

        System.out.println("***** Test CodeMonster HP management *****");
        sk1 = new Skill("tarpit", 10, 3);
        ska1 = new Skill[]{sk1};
        cm1 = new CodeMonster(103, 10.3, "BF", ska1);
        cm1.prepForBattle();
        errors += Tester.doTest(103, cm1.getHp(), "CodeMonster.getHp() after prepForBattle");
        errors += Tester.doTest(true, cm1.isAlive(), "CodeMonster.isAlive() after prepForBattle");

        cm1.adjustHealth(-10);
        errors += Tester.doTest(93, cm1.getHp(), "CodeMonster.getHp() after adjustHealth");
        errors += Tester.doTest(true, cm1.isAlive(), "CodeMonster.isAlive() after adjustHealth");

        cm1.adjustHealth(-10);
        errors += Tester.doTest(83, cm1.getHp(), "CodeMonster.getHp() after adjustHealth");
        errors += Tester.doTest(true, cm1.isAlive(), "CodeMonster.isAlive() after adjustHealth");

        cm1.adjustHealth(-30);
        errors += Tester.doTest(53, cm1.getHp(), "CodeMonster.getHp() after adjustHealth");
        errors += Tester.doTest(true, cm1.isAlive(), "CodeMonster.isAlive() after adjustHealth");

        cm1.adjustHealth(-100);
        errors += Tester.doTest(0, cm1.getHp(), "CodeMonster.getHp() after adjustHealth");
        errors += Tester.doTest(false, cm1.isAlive(), "CodeMonster.isAlive() after adjustHealth");

        cm1.adjustHealth(60);
        errors += Tester.doTest(60, cm1.getHp(), "CodeMonster.getHp() after adjustHealth");
        errors += Tester.doTest(true, cm1.isAlive(), "CodeMonster.isAlive() after adjustHealth");

        cm1.adjustHealth(60);
        errors += Tester.doTest(103, cm1.getHp(), "CodeMonster.getHp() after adjustHealth");
        errors += Tester.doTest(true, cm1.isAlive(), "CodeMonster.isAlive() after adjustHealth");

        cm1.adjustHealth(-100);
        errors += Tester.doTest(3, cm1.getHp(), "CodeMonster.getHp() after adjustHealth");
        errors += Tester.doTest(true, cm1.isAlive(), "CodeMonster.isAlive() after adjustHealth");

        cm1.prepForBattle(); // should reset health
        errors += Tester.doTest(103, cm1.getHp(), "CodeMonster.getHp() after prepForBattle");
        errors += Tester.doTest(true, cm1.isAlive(), "CodeMonster.isAlive() after prepForBattle");

        System.out.println("***** Test CodeMonster nextTurnTime management *****");
        sk1 = new Skill("tarpit", 10, 3);
        ska1 = new Skill[]{sk1};
        cm1 = new CodeMonster(103, 10.3, "BF", ska1);
        cm1.prepForBattle();
        errors += Tester.doTest(10.3, cm1.getNextTurnTime(), "CodeMonster.getNextTurnTime() after prepForBattle");

        cm1.setNextTurnTime(13.42);
        errors += Tester.doTest(13.42, cm1.getNextTurnTime(), "CodeMonster.getNextTurnTime() after setNextTurnTime");

        cm1.setNextTurnTime(10.02);
        errors += Tester.doTest(10.02, cm1.getNextTurnTime(), "CodeMonster.getNextTurnTime() after setNextTurnTime");

        cm1.setNextTurnTime(42.02);
        errors += Tester.doTest(42.02, cm1.getNextTurnTime(), "CodeMonster.getNextTurnTime() after setNextTurnTime");

        System.out.println("***** Test CodeMonster takeTurn (rotate through skills, and adjust turn time) *****");
        sk1 = new Skill("tarpit", 10, 3);
        sk2 = new Skill("esoteric", 1, 300);
        Skill sk3 = new Skill("[]", 2, 100);
        ska1 = new Skill[]{sk1, sk2, sk3};
        cm1 = new CodeMonster(103, 10.3, "BF", ska1);
        cm1.prepForBattle();
        errors += Tester.doTest(10.3, cm1.getNextTurnTime(), "CodeMonster.getNextTurnTime() after prepForBattle");

        Skill ret = cm1.takeTurn();
        errors += Tester.doTest(20.6, cm1.getNextTurnTime(), "CodeMonster.getNextTurnTime() after takeTurn");
        errors += Tester.doTest(true, ret == sk1, "takeTurn");

        ret = cm1.takeTurn();
        errors += Tester.doTest(30.9, cm1.getNextTurnTime(), "CodeMonster.getNextTurnTime() after takeTurn");
        errors += Tester.doTest(true, ret == sk2, "takeTurn");

        ret = cm1.takeTurn();
        errors += Tester.doTest(41.2, cm1.getNextTurnTime(), "CodeMonster.getNextTurnTime() after takeTurn");
        errors += Tester.doTest(true, ret == sk3, "takeTurn");

        ret = cm1.takeTurn();
        errors += Tester.doTest(51.5, cm1.getNextTurnTime(), "CodeMonster.getNextTurnTime() after takeTurn");
        errors += Tester.doTest(true, ret == sk1, "takeTurn");

        ret = cm1.takeTurn();
        errors += Tester.doTest(61.8, cm1.getNextTurnTime(), "CodeMonster.getNextTurnTime() after takeTurn");
        errors += Tester.doTest(true, ret == sk2, "takeTurn");

        System.out.println("**************************** End of testing ****************************");
        System.out.println(errors + " errors");
    }
}


/*


103
10.3
BF
true
14
1.0
C++
true
before call
after call
BF 103/103
C++ 14/14
2
103
true
10.3
3
103
true
93
true
83
true
53
true
0
false
60
true
103
true
3
true
103
true
10.3
13.42
10.02
42.02
10.3
20.6
true
30.9
true
41.2
true
51.5
true
61.8
true


 */