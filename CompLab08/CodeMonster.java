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

public class CodeMonster
{
    private int maxHp;
    private int currentHp;
    private double speedScore;
    private double nextTurnTime;
    private String name;
    private Skill[] moves;
    private int moveIndex;

    /**
     * Constructor: called when create a new monster object with hp, speed, name, and moves limit.
     *
     * maxHp = max hit points
     * speed score = how fast the monster is
     * name = name of mosnter
     * moves = the set of skills / moves it can preform
     *
     * When created,
     *      current hp is initally maxed out (to maxHp)
     *      nextTurnTime is intally set to the speed score
     *      move index is set to the very first move it has
     */
    public CodeMonster(int maxHp, double speedScore, String name, Skill[] moves)
    {
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.speedScore = speedScore;
        this.name = name;
        this.moves = new Skill[moves.length];
        this.moves = moves;

        this.nextTurnTime = speedScore;

        this.moveIndex = 0; //tracks the move that monster used recently

    }

//getters
    public int getHp()
    {
        return currentHp;
    }

    public int getMaxHp()
    {
        return maxHp;
    }

    public Skill[] getMoves()
    {
        return moves;
    }

    public String getName()
    {
        return name;
    }

    public double getSpeedScore()
    {
        return speedScore;
    }

    public double getNextTurnTime()
    {
        return nextTurnTime;

    }

//setter
    public void setNextTurnTime(double nextTurnTime)
    {
        this.nextTurnTime = nextTurnTime;

    }

    /* Method that resets Hp, turn time, and moves you use
     *
     *  refreshes the skills that the monster has new set
     */
    public void prepForBattle()
    { //might have to adjust if overridden

        this.currentHp = getMaxHp();
        this.nextTurnTime = getSpeedScore();
        this.moveIndex = 0; //resets

        for (Skill s : moves) {
            s.refresh();
        }

    }

    @Override //overrides natural string
    public String toString()
    {
        return name + " " + currentHp + "/" + maxHp;
    }

    /* Method that checks if the monster is alive using the currentHp
     *
     * reads the object's current hp
     *      compares it to 0 (dead / no hit points)
     * returns true if
     */
    public boolean isAlive()
    {
        if(currentHp > 0)
        {
            return true;
        }
        return false;
    }

    /* Method that determines which skill uses on its turn
    *
    * gets a skill based on moves and moveIndex (the current move it is at)
    *      resets moveIndex to 0 after it reaches the end
    *      rotate through moves in order
    *
    * increases turn time by the speed (so faster monsters go more often)
    *
    * returns the chosen skill that CodeMonster uses
    */
    public Skill takeTurn()
    {
        if(moveIndex >= moves.length)
        {
            moveIndex = 0;
        }

        Skill chosenMove = moves[moveIndex];
        moveIndex++;

        nextTurnTime += speedScore;

        return chosenMove;
    }

    /* Method that adjusts the monster’s current health by a given amount and makes sure it's within valid bounds
    *
    * reads the input amount
    *      adds it to the monster’s current HP
    *
    *   if HP goes above the max, sets it back maxHp
    *   if HP goes below zero, sets it back to 0 (dead)
    *
    */
    public void adjustHealth(int amount)
    {
        currentHp += amount;

        if (currentHp > maxHp)
        {
            currentHp = maxHp;
        } else if (currentHp < 0)
        {
            currentHp = 0;
        }
    }




}
