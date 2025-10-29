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
public class Skill
{
    protected  String name;
    protected int strength;
    protected int usageLimit;
    protected int usageLeft;


    /**
     * Constructor: called when create a new skill objects with a name, strength, and usage limit.
     *
     * name = the name of the Skill
     * strength = how strong the Skill is (damage amount)
     * usageLimit = how many times this Skill can be used
     * When created,
     *      usageLeft is maxed out to usageLimit (will change)
     */

    public Skill(String name, int strength, int usageLimit)
    {
        this.name = name;
        this.strength = strength;
        this.usageLimit = usageLimit;
        this.usageLeft = usageLimit;
    }

//One liner methods
    //getters
    public String getName()
    {
        return name;

    }

    public int getStrength()
    {
        return strength;
    }

    public int getUsageLimit()
    {
        return usageLimit;
    }

    public int getUsageLeft()
    {
        return usageLeft;
    }

//other one liners
    public void refresh()
    {
        //resets private variables
        this.usageLeft = this.usageLimit;
    }

    @Override //overrides natural string
    public String toString()
    {
        return (name + " " + getUsageLeft() + "/" + usageLimit );

    }

    /* Method that applies damage to Foe based on 'my' strength
     *
     * me = object of the player
     * foe = the object of the opposition
     */
    public void applyChanges(CodeMonster me, CodeMonster foe)
    {
        int damage = - (strength);
        foe.adjustHealth(damage);
    }

    /* Method that uses up skil and updates the usages left
     *
     * me = object of the player
     * foe = the object of the opposition
     *
     */
    public void useSkill(CodeMonster me, CodeMonster foe)
    {
        if (usageLeft > 0) {
            usageLeft--;
            applyChanges(me, foe);
        }

    }

}
