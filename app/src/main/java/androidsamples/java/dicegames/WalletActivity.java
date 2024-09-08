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


  private TextView mTxt_Bal;
  private Button Btn;
  private String TAG = "WalletActivity";

  private WalletViewModel mWalletVM;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_wallet);

    mTxt_Bal = findViewById(R.id.txt_bal);
    Btn = findViewById(R.id.btn_die);
    mWalletVM = new ViewModelProvider(this).get(WalletViewModel.class);
    mTxt_Bal.setText(Integer.toString(mWalletVM.balance()));
    Btn.setText(Integer.toString(mWalletVM.dieValue()));

    Btn.setOnClickListener(new View.onClickListener()){
      public void onClick(View view){
        mWalletVM.rollDie();
      }
    }
    private void updateUI(){
      mTxt_Bal.setText(Integer.toString(mWalletVM.balance()));
      Btn.setText(Integer.toString(mWalletVM.dieValue()));
    }



  }
  @Override
  protected void onStart(){
    super.onStart();
    Log.d(TAG,"onStart");
  }
  @Override
  protected void onResume(){
    super.onResume();
    Log.d(TAG,"onResume");
  }
  @Override
  protected void onStop(){
    super.onStop();
    Log.d(TAG,"onStop");
  }
  @Override
  protected void onDestroy(){
    super.onDestroy();
    Log.d(TAG,"onDestroy");
  }
  @Override
  protected void onPause(){
    super.onPause();
    Log.d(TAG,"onPause");
  }

//  protected void onSaveInstanceState(@NonNull Bundle outState) {
//
//    super.onSaveInstanceState(outState);
//    Log.d(TAG,"onSaveInstanceState");
//    outState.putInt(KEY_BALANCE, mBal);
//    outState.putInt(KEY_DIE_VAL, die.value());
//    Log.d(TAG, "Saved: balance = " + mBal+",die=" + die.value());
//  }

}