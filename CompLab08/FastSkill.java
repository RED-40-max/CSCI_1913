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

public class FastSkill extends Skill{

    public FastSkill(String name, int strength, int usageLimit)
    {
        super(name, strength,usageLimit); //calls the super constructor

    }

    @Override
    /* Damanges foe and keeps time the same
     *
     * the super class is overriden for this method, so that it now subtracts the time from OG.
     *      as a result, time remains the same
     *
     * me = object of self
     * foe = object of opposition
     */
    public void applyChanges(CodeMonster me, CodeMonster foe)
    {
        super.applyChanges(me, foe);

        double currentTime = me.getNextTurnTime();
        double speed = me.getSpeedScore();

        me.setNextTurnTime(currentTime - speed); //give back time
    }
}
