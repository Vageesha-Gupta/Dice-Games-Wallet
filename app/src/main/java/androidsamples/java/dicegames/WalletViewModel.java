package androidsamples.java.dicegames;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class WalletViewModel extends ViewModel {

  private static final String TAG = "WalletViewModel";
  private static final int WIN_VAL = 6;
  private static final int INCREMENT = 5;
  private int mBal;
  private Die die;

  /**
   * The no argument constructor.
   */
  public WalletViewModel() {
    mBal = 0;
    die = new Die6();
  }

  /**
   * Reports the current balance.
   *
   */
  public int balance() {
    // TODO implement method
    return mBal;
  }

  /**
   * Rolls the {@link Die} in the wallet and implements the changes accordingly.
   */
  public void rollDie() {
    die.roll();
    Log.d(TAG, "die = "+die.value());
    if(die.value() == WIN_VAL){
      mBal += INCREMENT;
      Log.d(TAG, "new balance = " + mBal);
    }

  }

  /**
   * Reports the current value of the {@link Die}.
   *
   */
  public int dieValue() {
    // TODO implement method
    return die.value();
  }

  /**
   * Reports the number of single (or first) sixes rolled so far.
   *
   */
  public int singleSixes() {
    // TODO implement method
    return 0;
  }

  /**
   * Reports the total number of dice rolls so far.
   *
   */
  public int totalRolls() {
    // TODO implement method
    return 0;
  }

  /**
   * Reports the number of times two sixes were rolled in a row.
   *
   */
  public int doubleSixes() {
    // TODO implement method
    return 0;
  }

  /**
   * Reports the number of times any other number was rolled twice in a row.
   *
   */
  public int doubleOthers() {
    // TODO implement method
    return 0;
  }

  /**
   * Reports the value of the die on the previous roll.
   *
   */
  public int previousRoll() {
    // TODO implement method
    return 0;
  }
  @Override
  protected void onCleared(){
    super.onCleared();
    Log.d(TAG, "onCleared");
  }
}
