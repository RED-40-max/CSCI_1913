/**
 * Nikki Som, Shawn Grove, Leonard Jin
 */

public class GameScore implements Comparable<GameScore> {

  public GameScore(String name, double score, boolean hardMode) {
    this.name = name;
    this.score = score;
    this.onHardMode = hardMode;
  }

  public String getName() {
    return name;
  }

  public double getScore() {
    return score;
  }

  public boolean isHardMode() {
    return onHardMode;
  }

  @Override
  public String toString() {
    return name + " " + score + (onHardMode ? "*" : "");
  }

  /**
   * @param obj Object to compare to a GameScore instance
   * @returns True if an object is exactly equal to a GameScore instance, ie. same name, score and Difficulty.
   */
  @Override

  public boolean equals(Object obj) {
    if (!(obj instanceof GameScore)) {
      System.out.println("Not an instance of GameScore");
      return false;
    }

    GameScore tempScore = (GameScore)(obj);

    if (tempScore.onHardMode != this.onHardMode) {
      System.out.println("Different Difficulty");
      return false;
    }
    if (tempScore.score != this.score) {
      System.out.println("Different Score");
      return false;
    }
    if (!this.name.equals(tempScore.name)) {
      System.out.println("Different Name");
      return false;
    }
    return true;
  }

  /**
   * Compare two game scores.
   * @param arg0: GameScore to compare to another instance.
   *               arg0 is the right comparand. eg. inst < arg0
   */
  @Override
  public int compareTo(GameScore arg0) {
    // If the difficulty of the two instances is the same, we can just compare their scores directly.
    if (arg0.onHardMode == this.onHardMode) {
      if (this.score == arg0.score)
        return 0;
      // Return 1 if this instance is greater than arg0, otherwise -1.
      return this.score > arg0.score ? 1 : -1;
    }

    // Since we returned earlier if the difficulties were the same,
    // whichever instance is on hard mode will be greater.
    //
    // if this is on hardmode return 1 else -1
    return this.onHardMode ? 1 : -1;

  }

  private final String name;
  private final double score;
  private final boolean onHardMode;
}

