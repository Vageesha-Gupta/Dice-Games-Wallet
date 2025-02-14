package androidsamples.java.dicegames;

import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import androidx.lifecycle.ViewModel;

public class WalletViewModel extends ViewModel {

  private static final String TAG = "WalletViewModel";
  private static final int WIN_VAL = 6;
  private static final int INCREMENT_NORMAL = 5;
  private static final int INCREMENT_IF_CONSECUTIVE_SIXES = 10;
  private static final int DECREMENT = 5;

  private int mBal;
  private int totalRolls;
  private int numWins;
  private int numLosses;
  private int prevRoll;
  Die die;
  private int dblSixes;
  private int dblOthers;
  //test toast
  private MutableLiveData<Boolean> sixRolledLiveData = new MutableLiveData<>();
  //test end
  public WalletViewModel() {
    mBal = 0;
    totalRolls = 0;
    numWins = 0;
    numLosses = 0;
    prevRoll = -1; // No roll initially
    die = new Die6();
    dblSixes=0;
    dblOthers=0;
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
    // Return 1 if there were two consecutive sixes; otherwise, return 0
//    return (prevRoll == WIN_VAL && die.value() == WIN_VAL) ? 1 : 0;
    return dblSixes;
  }

  public int doubleOthers() {
    // Return 1 if there were two consecutive non-sixes; otherwise, return 0
//    return (prevRoll != WIN_VAL && die.value() == prevRoll && prevRoll != -1) ? 1 : 0;
    return dblOthers;
  }

  public int previousRoll() {
    return prevRoll;
  }

  public int dieValue() {
    return die.value();
  }

  public LiveData<Boolean> getSixRolledLiveData() {
    return sixRolledLiveData;
  }



  public void rollDie() {
    // Save the current roll value before updating it
    int currentRoll = die.value();

    // Update the die and total rolls
    die.roll();
    totalRolls++;

    Log.d(TAG, "Die rolled = " + currentRoll);

    // Update previous roll before changing it
    int previousRoll = prevRoll; // Save the previous roll
    prevRoll = currentRoll; // Update previous roll to the current one

    // Check for wins and losses based on consecutive rolls
    if (currentRoll == WIN_VAL) {
      if (previousRoll == WIN_VAL) {
        // Two consecutive sixes
        mBal += INCREMENT_IF_CONSECUTIVE_SIXES;
        dblSixes++;
      } else {
        // Single six
        mBal += INCREMENT_NORMAL;
      }
      numWins++;
      numLosses = 0; // Reset losses since we rolled a six
      sixRolledLiveData.setValue(true);
    } else {
      if (currentRoll != WIN_VAL && previousRoll != -1 && currentRoll==previousRoll) {
        // Two consecutive non-sixes
        mBal -= DECREMENT;
        dblOthers++;
        numLosses++;
      }

//      numWins = 0; // Reset wins since it's not a six
      sixRolledLiveData.setValue(false);
    }

    Log.d(TAG, "New balance = " + mBal);
  }


  @Override
  protected void onCleared(){
    super.onCleared();
    Log.d(TAG, "onCleared");
  }

}
