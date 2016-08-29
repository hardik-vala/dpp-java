import static org.junit.Assert.*;
import org.junit.Test;

import problems.MaximumSubarraySum;


public class MaximumSubarraySumTest {

	@Test
	public void testSingletonArray() {
		MaximumSubarraySum mss = new MaximumSubarraySum(new int[] {1});
		assertEquals(1, mss.find());
	}

	@Test
	public void testSingletonArrayWithConstantSpaceSol() {
		MaximumSubarraySum mss = new MaximumSubarraySum(new int[] {1});
		assertEquals(1, mss.findWithConstantSpace());
	}

	@Test
	public void testGeneralCase() {
		MaximumSubarraySum mss = new MaximumSubarraySum(new int[] {1, -2, 3, 10, -4, 7, 2, -5});
		assertEquals(18, mss.find());
	}

	@Test
	public void testGeneralCaseWithConstantSpaceSol() {
		MaximumSubarraySum mss = new MaximumSubarraySum(new int[] {1, -2, 3, 10, -4, 7, 2, -5});
		assertEquals(18, mss.findWithConstantSpace());
	}

}
