package androidsamples.java.dicegames;

import java.util.Random;

/**
 * An implementation of a six-faced {@link Die} using {@link Random}.
 */
public class Die6 implements Die {
  private static final int FACES = 6;
  private Random mRng;
  private int mVal;
  public Die6() {
    mRng = new Random();
  }

  @Override
  public void roll() {
    mVal = mRng.nextInt(FACES) + 1;
  }

  @Override
  public int value() {
    return mVal;
  }
}
