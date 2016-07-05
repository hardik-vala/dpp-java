import static org.junit.Assert.*;
import org.junit.Test;

import problems.CoinChange;


public class CoinChangeTest {
	
	@Test
	public void testSmallSizedProblem() {
		CoinChange cc = new CoinChange(4, new int[] {1, 2, 3});
		assertEquals(4, cc.calculate());
	}

	@Test
	public void testMediumSizedProblem() {
		CoinChange cc = new CoinChange(10, new int[] {2, 5, 3, 6});
		assertEquals(5, cc.calculate());
	}

}
