package androidsamples.java.dicegames;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import androidx.lifecycle.ViewModelProvider;
import androidx.appcompat.app.AppCompatActivity;

public class WalletActivity extends AppCompatActivity {

  private WalletViewModel mWalletVM;
  private TextView mTxt_Bal;
  private Button mBtnDie;

  // Additional UI elements
  private TextView mTxtSixes;
  private TextView mTxtTotalRolls;
  private TextView mTxtPreviousRoll;
  private View mLayoutRolls;
  private View mLayoutDoubleSixes;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_wallet);

    // Initialize ViewModel
    mWalletVM = new ViewModelProvider(this).get(WalletViewModel.class);

    // Initialize UI elements
    mTxt_Bal = findViewById(R.id.txt_balance);
    mBtnDie = findViewById(R.id.btn_die);
    mTxtSixes = findViewById(R.id.txt_sixes);
    mTxtTotalRolls = findViewById(R.id.txt_total_rolls);
    mTxtPreviousRoll = findViewById(R.id.txt_previous_roll);
    mLayoutRolls = findViewById(R.id.layout_rolls);
    mLayoutDoubleSixes = findViewById(R.id.layout_double_sixes);

    // Update UI with the initial state from ViewModel
    updateUI();

    // Set onClick listener to roll die
    mBtnDie.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        // Delegate dice roll logic to the ViewModel
        mWalletVM.rollDie();

        // Update the UI after each roll
        updateUI();
      }
    });
  }

  // Updates the UI with the ViewModel's current state
  private void updateUI() {
    // Update balance and die button text
    mTxt_Bal.setText(Integer.toString(mWalletVM.balance()));
    mBtnDie.setText(Integer.toString(mWalletVM.dieValue()));

    // Show the hidden layouts if they are not visible
    if (mLayoutRolls.getVisibility() == View.GONE) {
      mLayoutRolls.setVisibility(View.VISIBLE);
    }
    if (mWalletVM.doubleSixes() > 0 && mLayoutDoubleSixes.getVisibility() == View.GONE) {
      mLayoutDoubleSixes.setVisibility(View.VISIBLE);
    }

    // Update sixes rolled, total rolls, and previous roll
    mTxtSixes.setText(Integer.toString(mWalletVM.singleSixes()));
    mTxtTotalRolls.setText(Integer.toString(mWalletVM.totalRolls()));
    mTxtPreviousRoll.setText("Previous Roll: " + mWalletVM.previousRoll());

    // Show previous roll text if it was hidden
    if (mTxtPreviousRoll.getVisibility() == View.GONE) {
      mTxtPreviousRoll.setVisibility(View.VISIBLE);
    }
  }
}





