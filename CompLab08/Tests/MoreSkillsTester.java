import CodeMonster;
import FastSkill;
import Skill;
import VampiricSkill;
package CompLab08.Tests;
import CompLab08.HealingSkill;

public class MoreSkillsTester {
    public static void main(String[] args) {
        int errors = 0;

        FastSkill fast = new FastSkill("Compile", 6, 10);
        HealingSkill heal = new HealingSkill("strong type", 6, 100);
        VampiricSkill vamp = new VampiricSkill("memory leak", 3, 19);

        // this is a particularly obscure way to check if a class extends another class
        // The biggest value here is that this version will still compile if inheritance is
        // setup wrong.
        errors += Tester.doTest(true, Skill.class.isInstance(fast), "fast is a Skill");
        errors += Tester.doTest(true, Skill.class.isInstance(heal), "heal is a Skill");
        errors += Tester.doTest(true, Skill.class.isInstance(vamp), "vamp is a Skill");

        System.out.println("****** Testing HealingSkill ******");
        CodeMonster cm1 = new CodeMonster(100, 10, "dummy1", new Skill[0]);
        CodeMonster cm2 = new CodeMonster(100, 10, "dummy2", new Skill[0]);
        // set everything up!
        cm1.prepForBattle();
        cm2.prepForBattle();
        cm1.adjustHealth(-50);
        cm2.adjustHealth(-50);

        errors += Tester.doTest(50, cm1.getHp(), "cm1.getHp()");
        errors += Tester.doTest(50, cm2.getHp(), "cm2.getHp()");

        heal.applyChanges(cm1, cm2);
        errors += Tester.doTest(56, cm1.getHp(), "cm1.getHp() after heal.applyChanges(cm1, cm2)");
        errors += Tester.doTest(50, cm2.getHp(), "cm2.getHp() after heal.applyChanges(cm1, cm2)");

        heal.applyChanges(cm1, cm2);
        errors += Tester.doTest(62, cm1.getHp(), "cm1.getHp() after heal.applyChanges(cm1, cm2)");
        errors += Tester.doTest(50, cm2.getHp(), "cm2.getHp() after heal.applyChanges(cm1, cm2)");

        System.out.println("****** Testing VampiricSkill ******");
        // reset everything!
        cm1.prepForBattle();
        cm2.prepForBattle();
        cm1.adjustHealth(-50);
        cm2.adjustHealth(-50);

        errors += Tester.doTest(50, cm1.getHp(), "cm1.getHp() after resetting everything");
        errors += Tester.doTest(50, cm2.getHp(), "cm2.getHp() after resetting everything");

        vamp.applyChanges(cm1, cm2);
        errors += Tester.doTest(53, cm1.getHp(), "cm1.getHp() after vamp.applyChanges(cm1, cm2)");
        errors += Tester.doTest(47, cm2.getHp(), "cm2.getHp() after vamp.applyChanges(cm1, cm2)");

        vamp.applyChanges(cm1, cm2);
        errors += Tester.doTest(56, cm1.getHp(), "cm1.getHp() after vamp.applyChanges(cm1, cm2)");
        errors += Tester.doTest(44, cm2.getHp(), "cm2.getHp() after vamp.applyChanges(cm1, cm2)");

        System.out.println("****** Testing FastSkill ******");
        // reset everything!
        cm1.prepForBattle();
        cm2.prepForBattle();
        cm1.adjustHealth(-50);
        cm2.adjustHealth(-50);

        errors += Tester.doTest(50, cm1.getHp(), "cm1.getHp() after resetting everything");
        errors += Tester.doTest(10.0, cm1.getNextTurnTime(), "cm1.getNextTurnTime() after resetting everything");
        errors += Tester.doTest(50, cm2.getHp(), "cm2.getHp() after resetting everything");
        errors += Tester.doTest(10.0, cm2.getNextTurnTime(), "cm1.getNextTurnTime() after resetting everything");

        fast.applyChanges(cm1, cm2);
        errors += Tester.doTest(50, cm1.getHp(), "cm1.getHp() after fast.applyChanges(cm1, cm2)");
        errors += Tester.doTest(0.0, cm1.getNextTurnTime(), "cm1.getNextTurnTime() after fast.applyChanges(cm1, cm2)");
        errors += Tester.doTest(44, cm2.getHp(), "cm2.getHp() after fast.applyChanges(cm1, cm2)");
        errors += Tester.doTest(10.0, cm2.getNextTurnTime(), "cm1.getNextTurnTime() after fast.applyChanges(cm1, cm2)");

        fast.applyChanges(cm1, cm2);
        errors += Tester.doTest(50, cm1.getHp(), "cm1.getHp() after fast.applyChanges(cm1, cm2)");
        errors += Tester.doTest(-10.0, cm1.getNextTurnTime(), "cm1.getNextTurnTime() after fast.applyChanges(cm1, cm2)");
        errors += Tester.doTest(38, cm2.getHp(), "cm2.getHp() after fast.applyChanges(cm1, cm2)");
        errors += Tester.doTest(10.0, cm2.getNextTurnTime(), "cm1.getNextTurnTime() after fast.applyChanges(cm1, cm2)");

        System.out.println("**************************** End of testing ****************************");
        System.out.println(errors + " errors");
    }




}

/*

true
true
true
50
50
56
50
62
50
50
50
53
47
56
44
50
10.0
50
10.0
50
0.0
44
10.0
50
-10.0
38
10.0


 */