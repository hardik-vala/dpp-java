import static org.junit.Assert.*;
import org.junit.Test;

import problems.SubarraySum;


public class SubarraySumTest {
	
	@Test
	public void testSmallMixedArrayForPosSum() {
		SubarraySum ss = new SubarraySum(new int[] {1, -1, 2 , 4, 5, -10}, 7);
		assertEquals(3, ss.count());
	}

	@Test
	public void testSmallMixedArrayForZeroSum() {
		SubarraySum ss = new SubarraySum(new int[] {1, -1, 2 , 4, 5, -10}, 0);
		assertEquals(3, ss.count());
	}

	@Test
	public void testSmallMixedArrayForNegSum() {
		SubarraySum ss = new SubarraySum(new int[] {1, -1, 2 , 4, 5, -10}, -1);
		assertEquals(3, ss.count());
	}

}
