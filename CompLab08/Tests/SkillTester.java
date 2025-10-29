import CodeMonster;
import Skill;

package CompLab08.Tests;
/**
 * SkillTester class file.
 * CSCI 1913.
 * Originall Written by Daniel Kluver
 * Modified by Adriana Picoral in Fall 2025
 */

public class SkillTester {
    public static void main(String[] args) {
        int errors = 0;

        System.out.println("***** Test Skill constructors, getters, toString *****");
        Skill sk1 = new Skill("recursion", 100, 13);
        errors += Tester.doTest("recursion", sk1.getName(), "Skill.getName()");
        errors += Tester.doTest(100, sk1.getStrength(), "Skill.getStrength()");
        errors += Tester.doTest(13, sk1.getUsageLimit(), "Skill.getUsageLimit()");
        errors += Tester.doTest(13, sk1.getUsageLeft(), "Skill.getUsageLeft()");
        errors += Tester.doTest("recursion 13/13", sk1.toString(), "Skill.toString()");

        Skill sk2 = new Skill("iteration", 10, 103);
        errors += Tester.doTest("iteration", sk2.getName(), "Skill.getName()");
        errors += Tester.doTest(10, sk2.getStrength(), "Skill.getStrength()");
        errors += Tester.doTest(103, sk2.getUsageLimit(), "Skill.getUsageLimit()");
        errors += Tester.doTest(103, sk2.getUsageLeft(), "Skill.getUsageLeft()");
        errors += Tester.doTest("iteration 103/103", sk2.toString(), "Skill.toString()");

        System.out.println("***** Test Skill applyChanges, CodeMonster *****");
        sk1 = new Skill("recursion", 15, 13);
        sk2 = new Skill("iteration", 10, 103);

        Skill[] ska1 = new Skill[]{sk1};
        CodeMonster cm1 = new CodeMonster(103, 10.3, "Scheme", ska1);
        Skill[] ska2 = new Skill[]{sk2};
        CodeMonster cm2 = new CodeMonster(140, 1, "Pearl", ska2);
        cm1.prepForBattle();
        cm2.prepForBattle();

        errors += Tester.doTest(103, cm1.getHp(), "getHp() after prepForBattle");
        errors += Tester.doTest(140, cm2.getHp(), "getHp() after prepForBattle");

        sk1.applyChanges(cm1, cm2);
        errors += Tester.doTest(103, cm1.getHp(), "getHp() after applyChanges");
        errors += Tester.doTest(125, cm2.getHp(), "getHp() after applyChanges");

        sk2.applyChanges(cm2, cm1);
        errors += Tester.doTest(93, cm1.getHp(), "getHp() after applyChanges");
        errors += Tester.doTest(125, cm2.getHp(), "getHp() after applyChanges");

        sk1.applyChanges(cm1, cm2);
        errors += Tester.doTest(93, cm1.getHp(), "getHp() after applyChanges");
        errors += Tester.doTest(110, cm2.getHp(), "getHp() after applyChanges");

        System.out.println("***** Test Skill.useSkill *****");
        sk1 = new Skill("recursion", 15, 13);
        sk2 = new Skill("iteration", 10, 103);
        ska1 = new Skill[]{sk1};
        cm1 = new CodeMonster(103, 10.3, "Scheme", ska1);
        ska2 = new Skill[]{sk2};
        cm2 = new CodeMonster(140, 1, "Pearl", ska2);
        cm1.prepForBattle();
        cm2.prepForBattle();

        errors += Tester.doTest(13, sk1.getUsageLeft(), "Skill.getUsageLeft()");
        errors += Tester.doTest(103, sk2.getUsageLeft(), "Skill.getUsageLeft()");
        errors += Tester.doTest(103, cm1.getHp(), "CodeMonster.getHp()");
        errors += Tester.doTest(140, cm2.getHp(), "CodeMonster.getHp()");

        sk1.useSkill(cm1, cm2);
        errors += Tester.doTest(12, sk1.getUsageLeft(), "Skill.getUsageLeft() after useSkill");
        errors += Tester.doTest(103, sk2.getUsageLeft(), "Skill.getUsageLeft() after useSkill");
        errors += Tester.doTest(103, cm1.getHp(), "CodeMonster.getHp() after useSkill");
        errors += Tester.doTest(125, cm2.getHp(), "CodeMonster.getHp() after useSkill");

        sk2.useSkill(cm2, cm1);
        errors += Tester.doTest(12, sk1.getUsageLeft(), "Skill.getUsageLeft() after useSkill");
        errors += Tester.doTest(102, sk2.getUsageLeft(), "Skill.getUsageLeft() after useSkill");
        errors += Tester.doTest(93, cm1.getHp(), "CodeMonster.getHp() after useSkill");
        errors += Tester.doTest(125, cm2.getHp(), "CodeMonster.getHp() after useSkill");

        sk1.useSkill(cm1, cm2);
        errors += Tester.doTest(11, sk1.getUsageLeft(), "Skill.getUsageLeft() after useSkill");
        errors += Tester.doTest(102, sk2.getUsageLeft(), "Skill.getUsageLeft() after useSkill");
        errors += Tester.doTest(93, cm1.getHp(), "CodeMonster.getHp() after useSkill");
        errors += Tester.doTest(110, cm2.getHp(), "CodeMonster.getHp() after useSkill");

        // test useSkill and usageLimit and refresh
        System.out.println("***** Test Skill.useSkill and Skill.refresh *****");
        sk1 = new Skill("recursion", 5, 3);
        sk2 = new Skill("iteration", 10, 10);
        ska1 = new Skill[]{sk1};
        cm1 = new CodeMonster(103, 10.3, "Scheme", ska1);
        ska2 = new Skill[]{sk2};
        cm2 = new CodeMonster(140, 1, "Pearl", ska2);
        cm1.prepForBattle();
        cm2.prepForBattle();

        errors += Tester.doTest(3, sk1.getUsageLeft(), "Skill.getUsageLeft()");
        errors += Tester.doTest(140, cm2.getHp(), "CodeMonster.getHp()");

        sk1.useSkill(cm1, cm2);
        errors += Tester.doTest(2, sk1.getUsageLeft(), "Skill.getUsageLeft() after useSkill");
        errors += Tester.doTest(135, cm2.getHp(), "CodeMonster.getHp() after useSkill");

        sk1.useSkill(cm1, cm2);
        errors += Tester.doTest(1, sk1.getUsageLeft(), "Skill.getUsageLeft() after useSkill");
        errors += Tester.doTest(130, cm2.getHp(), "CodeMonster.getHp() after useSkill");

        sk1.useSkill(cm1, cm2);
        errors += Tester.doTest(0, sk1.getUsageLeft(), "Skill.getUsageLeft() after useSkill");
        errors += Tester.doTest(125, cm2.getHp(), "CodeMonster.getHp() after useSkill");

        sk1.useSkill(cm1, cm2);
        errors += Tester.doTest(0, sk1.getUsageLeft(), "Skill.getUsageLeft() after useSkill");
        errors += Tester.doTest(125, cm2.getHp(), "CodeMonster.getHp() after useSkill");

        sk1.useSkill(cm1, cm2);
        errors += Tester.doTest(0, sk1.getUsageLeft(), "Skill.getUsageLeft() after useSkill");
        errors += Tester.doTest(125, cm2.getHp(), "CodeMonster.getHp() after useSkill");

        sk1.refresh();
        errors += Tester.doTest(3, sk1.getUsageLeft(), "Skill.getUsageLeft() after refresh");

        sk1.useSkill(cm1, cm2);
        errors += Tester.doTest(2, sk1.getUsageLeft(), "Skill.getUsageLeft() after useSkill");
        errors += Tester.doTest(120, cm2.getHp(), "CodeMonster.getHp() after useSkill");

        System.out.println("**************************** End of testing ****************************");
        System.out.println(errors + " errors");
    }
}