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
  private View mPrevRollLayout;
  private View mLayoutRolls;
  private View mLayoutDoubleSixes;
  private TextView mTxtDblSixes;
  private TextView mTxtDblOthers;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_wallet);

    // Initialize ViewModel
    mWalletVM = new ViewModelProvider(this).get(WalletViewModel.class);

    // Initialize UI elements
    mTxt_Bal = findViewById(R.id.txt_balance);
    mBtnDie = findViewById(R.id.btn_die);
    mBtnDie.setText(R.string.numOnDie);
    mTxtSixes = findViewById(R.id.txt_sixes);
    mTxtTotalRolls = findViewById(R.id.txt_total_rolls);
    mTxtPreviousRoll = findViewById(R.id.txt_previous_roll);
    mLayoutRolls = findViewById(R.id.layout_rolls);
    mLayoutDoubleSixes = findViewById(R.id.layout_double_sixes);
    mPrevRollLayout = findViewById(R.id.prev_roll_layout);
    mTxtDblSixes=findViewById(R.id.txt_double_sixes);
    mTxtDblOthers=findViewById(R.id.txt_double_others);

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
    int balance = mWalletVM.balance(); // Get balance directly from ViewModel
    mTxt_Bal.setText(Integer.toString(balance));
    mBtnDie.setText(Integer.toString(mWalletVM.dieValue()));

    // Update sixes rolled, total rolls, and previous roll
    mTxtSixes.setText(Integer.toString(mWalletVM.singleSixes()));
    mTxtTotalRolls.setText(Integer.toString(mWalletVM.totalRolls()));
    int previousRoll = mWalletVM.previousRoll();
    mTxtPreviousRoll.setText(Integer.toString(previousRoll));

    // Show the hidden layouts if they are not visible
    if (mLayoutRolls.getVisibility() == View.GONE) {
      mLayoutRolls.setVisibility(View.VISIBLE);
    }
    if ((mWalletVM.doubleSixes() > 0 || mWalletVM.doubleOthers()>0) && mLayoutDoubleSixes.getVisibility() == View.GONE) {
      mLayoutDoubleSixes.setVisibility(View.VISIBLE);
      mTxtDblSixes.setText(Integer.toString((mWalletVM.doubleSixes())));
      mTxtDblOthers.setText(Integer.toString((mWalletVM.doubleOthers())));
    }

    // Ensure previous roll text visibility
    if (mWalletVM.totalRolls()>1 && mWalletVM.previousRoll()!=-1 && mPrevRollLayout.getVisibility() == View.GONE) {
      mPrevRollLayout.setVisibility(View.VISIBLE);

    }
  }

}





