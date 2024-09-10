package androidsamples.java.dicegames;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class WalletTest {
  private WalletViewModel viewModel;

  @Before
  public void setUp() {
    viewModel = new WalletViewModel();
  }

  @Test
  public void testInitialBalance() {
    assertEquals(0, viewModel.balance());
  }

  @Test
  public void testDieRollIncreasesBalance() {

    viewModel.rollDie();
    int dieValue = viewModel.dieValue();

    if (dieValue == 6) {

      assertEquals(5, viewModel.balance());
    } else {

      assertEquals(0, viewModel.balance());
    }
  }

  @Test
  public void testRollSingleSix() {
    viewModel.rollDie();  // Assuming this rolls a 6
    assertEquals(5, viewModel.balance());
    assertEquals(1, viewModel.singleSixes());
  }

  @Test
  public void testRollDoubleSix() {
    viewModel.rollDie();  // 6 rolled
    viewModel.rollDie();  // 6 rolled again
    assertEquals(10, viewModel.balance());
    assertEquals(2, viewModel.doubleSixes());
  }
}