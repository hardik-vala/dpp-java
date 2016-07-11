import static org.junit.Assert.*;
import org.junit.Test;

import problems.LongestIncreasingSubsequence;


public class LongestIncreasingSubsequenceTest {
	
	@Test
	public void testSingleElementSeq() {
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence(new int[] {1});
		assertEquals(1, lis.calculate());
	}

	@Test
	public void testMultipleElementSeq() {
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence(
			new int[] {10, 22, 9, 33, 21, 50, 41, 60, 80});
		assertEquals(6, lis.calculate());
	}

}
