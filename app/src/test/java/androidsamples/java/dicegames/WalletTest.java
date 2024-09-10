package androidsamples.java.dicegames;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;


import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import android.util.Log;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(RobolectricTestRunner.class)
public class WalletTest {
  private WalletViewModel viewModel;
  Die die;

  @Mock
  Die mockDie;
  @Before
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    viewModel = new WalletViewModel();
    viewModel.die = mockDie;
  }
  @Test
  public void roll_single_six() {
    when(mockDie.value()).thenReturn(6);
    int bal = viewModel.balance();
    int six = viewModel.singleSixes();
    viewModel.rollDie();
    assertEquals(bal+5, viewModel.balance());
    assertEquals(six+1, viewModel.singleSixes());

    verify(mockDie).roll();
  }
  @Test
    public void roll_non_six() {
        when(mockDie.value()).thenReturn(3);
        int bal = viewModel.balance();
        int six = viewModel.singleSixes();
        viewModel.rollDie();
        assertEquals(bal, viewModel.balance());
        assertEquals(six, viewModel.singleSixes());

        verify(mockDie).roll();
    }



//  @Test
//  public void testInitialBalance() {
//    assertEquals(0, viewModel.balance());
//  }
//
//  @Test
//  public void testDieRollIncreasesBalance() {
//
//    viewModel.rollDie();
//    int dieValue = viewModel.dieValue();
//
//    if (dieValue == 6) {
//
//      assertEquals(5, viewModel.balance());
//    } else {
//
//      assertEquals(0, viewModel.balance());
//    }
//  }
//
//  @Test
//  public void testRollSingleSix() {
//    viewModel.rollDie();  // Assuming this rolls a 6
//    assertEquals(5, viewModel.balance());
//    assertEquals(1, viewModel.singleSixes());
//  }
//
//  @Test
//  public void testRollDoubleSix() {
//    viewModel.rollDie();  // 6 rolled
//    viewModel.rollDie();  // 6 rolled again
//    assertEquals(10, viewModel.balance());
//    assertEquals(2, viewModel.doubleSixes());
//  }
}