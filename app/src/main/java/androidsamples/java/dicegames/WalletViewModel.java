package androidsamples.java.dicegames;

import android.util.Log;

import androidx.lifecycle.ViewModel;
//
//public class WalletViewModel extends ViewModel {
//
//  private static final String TAG = "WalletViewModel";
//  private static final int WIN_VAL = 6;
//  private static final int INCREMENT = 5;
//  private int mBal;
//  private Die die;
//
//  /**
//   * The no argument constructor.
//   */
//  public WalletViewModel() {
//    mBal = 0;
//    die = new Die6();
//  }
//
//  /**
//   * Reports the current balance.
//   *
//   */
//  public int balance() {
//
//    return mBal;
//  }
//
//  /**
//   * Rolls the {@link Die} in the wallet and implements the changes accordingly.
//   */
//  public void rollDie() {
//    die.roll();
//    Log.d(TAG, "die = "+die.value());
//    if(die.value() == WIN_VAL){
//      mBal += INCREMENT;
//      Log.d(TAG, "new balance = " + mBal);
//    }
//
//  }
//
//  /**
//   * Reports the current value of the {@link Die}.
//   *
//   */
//  public int dieValue() {
//
//    return die.value();
//  }
//
//  /**
//   * Reports the number of single (or first) sixes rolled so far.
//   *
//   */
//  public int singleSixes() {
//
//    return 0;
//  }
//
//  /**
//   * Reports the total number of dice rolls so far.
//   *
//   */
//  public int totalRolls() {
//
//    return 0;
//  }
//
//  /**
//   * Reports the number of times two sixes were rolled in a row.
//   *
//   */
//  public int doubleSixes() {
//
//    return 0;
//  }
//
//  /**
//   * Reports the number of times any other number was rolled twice in a row.
//   *
//   */
//  public int doubleOthers() {
//
//    return 0;
//  }
//
//  /**
//   * Reports the value of the die on the previous roll.
//   *
//   */
//  public int previousRoll() {
//    return 0;
//  }
//  @Override
//  protected void onCleared(){
//    super.onCleared();
//    Log.d(TAG, "onCleared");
//  }
//}
public class WalletViewModel extends ViewModel {

  private static final String TAG = "WalletViewModel";
  private static final int WIN_VAL = 6;
  private static final int INCREMENT_NORMAL = 5;
  private static final int INCREMENT_IF_CONSECUTIVE_SIXES = 10;
  private static final int DECREMENT = 5;

  private int mBal;
  private int totalRolls;
  private int numWins;
  private int numLoses;
  private int prevRoll;
  private Die die;

  public WalletViewModel() {
    mBal = 0;
    totalRolls = 0;
    numWins = 0;
    numLoses = 0;
    prevRoll = -1; // No roll initially
    die = new Die6();
  }

  public int balance() {
    return mBal;
  }

  public int totalRolls() {
    return totalRolls;
  }

  public int singleSixes() {
    return numWins;
  }

  public int doubleSixes() {
    return (numWins > 1) ? 1 : 0; // Just a sample logic for two consecutive sixes
  }

  public int doubleOthers() {
    return (numLoses > 1) ? 1 : 0; // Sample logic for two consecutive non-sixes
  }

  public int previousRoll() {
    return prevRoll;
  }

  public int dieValue() {
    return die.value();
  }

  public void rollDie() {
    die.roll();
    totalRolls++;

    int currentRoll = die.value();
    Log.d(TAG, "Die rolled = " + currentRoll);

    // Check for wins and losses based on consecutive rolls
    if (currentRoll == WIN_VAL) {
      if (prevRoll == WIN_VAL) {
        // Two consecutive sixes
        mBal += INCREMENT_IF_CONSECUTIVE_SIXES;
      } else {
        // Single six
        mBal += INCREMENT_NORMAL;
      }
      numWins++;
      numLoses = 0; // Reset loses since we rolled a six
    } else {
      if (prevRoll != WIN_VAL && prevRoll != -1) {
        // Two consecutive non-sixes
        mBal -= DECREMENT;
        numLoses++;
      } else {
        numLoses = 1; // Start tracking losses
      }
      numWins = 0; // Reset wins since it's not a six
    }

    // Update previous roll
    prevRoll = currentRoll;

    Log.d(TAG, "New balance = " + mBal);
  }

  @Override
  protected void onCleared(){
    super.onCleared();
    Log.d(TAG, "onCleared");
  }
}