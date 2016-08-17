import static org.junit.Assert.*;
import org.junit.Test;

import problems.UnboundedKnapsack;


public class UnboundedKnapsackTest {

	@Test
	public void test() {
		int[] values = new int[] {160, 90, 15};
		int[] weights = new int[] {7, 3, 2};
		int capacity = 20;
		UnboundedKnapsack uk = new UnboundedKnapsack(values, weights, capacity);
		assertEquals(555, uk.calc());
	}

}
