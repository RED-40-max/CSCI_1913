package CompLab08;
/* Computer Lab 08: Battle Sim
 *
 * Authors: Nikki Som, Shawn Grove, Leonard Jin
 *
 * Files in project:
 *     Skill.java – defines base skill behavior
 *     CodeMonster.java – defines monsters that use skills in battle
 *     Battle.java – static methods to simulate battles
 *     VampiricSkill.java – special skill that deals and heals damage
 *     FastSkill.java – special skill that refunds turn time
 *
 */

public class Battle {


    /* Method that runs a single turn in the battle
    *
    * assigns that monster as attacker and the other as defender (initally)
    *
    * compares nextTurnTime to see who's faster and who should attack first
    *      the one with the smaller or equal nextTurnTime goes first
    *      (otherwise it gose to initally set default)
    *
    * attacker selects a skill using takeTurn()
    *      then uses that skill on the defender
    *
    * prints a message describing the action taken in this turn
    */
    public static void doOneTurn(CodeMonster one, CodeMonster two)
    {
        CodeMonster attacker = two;
        CodeMonster defender = one;

        if (one.getNextTurnTime() <= two.getNextTurnTime())
        {
            attacker = one;
            defender = two;
        }

        //otherwise proceed how it is like already

        Skill chosenSkill = attacker.takeTurn();
        chosenSkill.useSkill(attacker, defender);

        System.out.println(attacker + " uses " + chosenSkill + " on " + defender);
    }

    /* Method that runs the full battle sim between two CodeMonsters
    *
    * preps both monsters for battle
    *      (heals, resets moves, resets timers)
    *      prints an intro message showing the matchup
    *
    * calls doOneTurn() while both CodeMonsters are alive
    *     ends loop only after one dies
    *
    * once one CodeMonster dies, other is winner
    * prints the final winner message and returns the winning CodeMonster
    */
    public static CodeMonster battle(CodeMonster one, CodeMonster two)
    {

        one.prepForBattle();
        two.prepForBattle();


        System.out.println(one + " vs. " + two);


        while (one.isAlive() && two.isAlive())
        {
            doOneTurn(one, two);
        }

        CodeMonster winner;
        if (one.isAlive())
        {
            winner = one;
        }
        else
        {
            winner = two;
        }

        System.out.println(winner + " wins!");
        return winner;

    }

}
