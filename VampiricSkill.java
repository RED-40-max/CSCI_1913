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

public class VampiricSkill extends Skill {

    //overloaded constructor that calls super
    public VampiricSkill(String name, int strength, int usageLimit)
    {
        super(name, strength, usageLimit);
    }

    @Override
    /* Damanges foe and Strengthens me
     *
     * the super class is overriden for this method, so that it now additionally 'steals' the strength
     *
     * me = object of self
     * foe = object of opposition
     */
    public void applyChanges(CodeMonster me, CodeMonster foe)
    {
        super.applyChanges(me, foe);
        me.adjustHealth(getStrength()); //strengthens
    }

}
