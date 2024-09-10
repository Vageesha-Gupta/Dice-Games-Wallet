package androidsamples.java.dicegames;

import static org.junit.Assert.assertEquals;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class WalletInstrumentedTest {
  @Test
  public void useAppContext() {
    // Context of the app under test.
    Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
    assertEquals("androidsamples.java.dicegames", appContext.getPackageName());
  }

  @Test
  public void testWalletViewModel() {
    WalletViewModel walletViewModel = new WalletViewModel();
    assertEquals(0, walletViewModel.balance());
    assertEquals(0, walletViewModel.totalRolls());
    assertEquals(0, walletViewModel.singleSixes());
    assertEquals(0, walletViewModel.doubleSixes());
    assertEquals(0, walletViewModel.doubleOthers());
  }
  @Test
    public void testWalletViewModelBalance() {
        WalletViewModel walletViewModel = new WalletViewModel();
        int bal = walletViewModel.balance();
        assertEquals(bal+1, walletViewModel.balance());
    }
  @Test
    public void testWalletViewModelTotalRolls() {
        WalletViewModel walletViewModel = new WalletViewModel();
        int rolls = walletViewModel.totalRolls();
        assertEquals(rolls+1, walletViewModel.totalRolls());
    }
    @Test
    public void testWalletViewModelSingleSixes() {
        WalletViewModel walletViewModel = new WalletViewModel();
        int six = walletViewModel.singleSixes();
        assertEquals(six+1, walletViewModel.singleSixes());
    }
    @Test
    public void testWalletViewModelDoubleSixes() {
        WalletViewModel walletViewModel = new WalletViewModel();
        int dSixes = walletViewModel.doubleSixes();
        assertEquals(dSixes+1, walletViewModel.doubleSixes());
    }
    @Test
    public void testWalletViewModelDoubleOthers() {
        WalletViewModel walletViewModel = new WalletViewModel();
        int dOthers = walletViewModel.doubleOthers();
        assertEquals(dOthers+1, walletViewModel.doubleOthers());
    }

}