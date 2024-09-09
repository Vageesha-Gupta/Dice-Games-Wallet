package androidsamples.java.dicegames;

import static androidsamples.java.dicegames.R.id.Btn;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class WalletActivity extends AppCompatActivity {
  private int mBalance;
  private Die mDie;
  private TextView mTxt_Bal;
  private Button mBtnDie;
//  private final String TAG = "WalletActivity";
  private final int WIN_VALUE=6;
  private int numWins=0;
  private int numLoses=0;
  private final int INCREMENT_NORMAL=5;
  private final int INCREMENT_IF_CONSECUTIVE_SIXES=10;
  private final int DECREMENT=5;


//  private WalletViewModel mWalletVM;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_wallet);
    mDie=new Die6();
    mTxt_Bal = findViewById(R.id.txt_balance);
    mBtnDie = findViewById(R.id.btn_die);

//    mWalletVM = new ViewModelProvider(this).get(WalletViewModel.class);
//    mTxt_Bal.setText(Integer.toString(mWalletVM.balance()));
//    mBtnDie.setText(Integer.toString(mWalletVM.dieValue()));

//    Btn.setOnClickListener(new View.OnClickListener()){
//      public void onClick(View view){
//        mWalletVM.rollDie();
//      }
//    }
    mBtnDie.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        //roll die
        mDie.roll();
        //add coins
        if (mDie.value() == WIN_VALUE && numWins == 0) {
          numLoses = 0;
          numWins++;
          mBalance += INCREMENT_NORMAL;
        } else if (mDie.value() == WIN_VALUE && numWins > 0) {
          numWins++;
          mBalance += INCREMENT_IF_CONSECUTIVE_SIXES;
        } else if (mDie.value() != WIN_VALUE && numLoses == 0) {
          //if not a six
          numWins = 0;
          numLoses++;
        } else if (mDie.value() != WIN_VALUE && numLoses > 0) {
          //if not a six consecutively
          mBalance -= DECREMENT;
          numLoses++;
        }
        //update ui
        updateUI();
      }
      //
    });

  }

  private void updateUI() {
    mTxt_Bal.setText(Integer.toString(mBalance));
    mBtnDie.setText(Integer.toString(mDie.value()));
  }

//  @Override
//  protected void onStart(){
//    super.onStart();
//    Log.d(TAG,"onStart");
//  }
//  @Override
//  protected void onResume(){
//    super.onResume();
//    Log.d(TAG,"onResume");
//  }
//  @Override
//  protected void onStop(){
//    super.onStop();
//    Log.d(TAG,"onStop");
//  }
//  @Override
//  protected void onDestroy(){
//    super.onDestroy();
//    Log.d(TAG,"onDestroy");
//  }
//  @Override
//  protected void onPause(){
//    super.onPause();
//    Log.d(TAG,"onPause");
//  }

//  protected void onSaveInstanceState(@NonNull Bundle outState) {
//
//    super.onSaveInstanceState(outState);
//    Log.d(TAG,"onSaveInstanceState");
//    outState.putInt(KEY_BALANCE, mBal);
//    outState.putInt(KEY_DIE_VAL, die.value());
//    Log.d(TAG, "Saved: balance = " + mBal+",die=" + die.value());
//  }

}