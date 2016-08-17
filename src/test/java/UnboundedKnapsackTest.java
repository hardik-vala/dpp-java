import static org.junit.Assert.*;
import org.junit.Test;

import problems.UnboundedKnapsack;


public class UnboundedKnapsackTest {

	@Test
	public void testZeroCapacity() {
		int[] values = new int[] {160, 90, 15};
		int[] weights = new int[] {7, 3, 2};
		int capacity = 0;
		UnboundedKnapsack uk = new UnboundedKnapsack(values, weights, capacity);
		assertEquals(0, uk.calc());
	}

	@Test
	public void testZeroCapacityWithZeroItem() {
		int[] values = new int[] {160, 90, 15, 0};
		int[] weights = new int[] {7, 3, 2, 0};
		int capacity = 0;
		UnboundedKnapsack uk = new UnboundedKnapsack(values, weights, capacity);
		assertEquals(0, uk.calc());
	}

	@Test
	public void testNonZeroCapacity() {
		int[] values = new int[] {160, 90, 15};
		int[] weights = new int[] {7, 3, 2};
		int capacity = 20;
		UnboundedKnapsack uk = new UnboundedKnapsack(values, weights, capacity);
		assertEquals(555, uk.calc());
	}

	@Test
	public void testNonZeroCapacityWithZeroItem() {
		int[] values = new int[] {160, 90, 15, 0};
		int[] weights = new int[] {7, 3, 2, 0};
		int capacity = 20;
		UnboundedKnapsack uk = new UnboundedKnapsack(values, weights, capacity);
		assertEquals(555, uk.calc());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testZeroWeightItemWithNonZeroValue() {
		int[] values = new int[] {160, 90, 15, 1};
		int[] weights = new int[] {7, 3, 2, 0};
		int capacity = 20;
		UnboundedKnapsack uk = new UnboundedKnapsack(values, weights, capacity);
		uk.calc();
	}

}
