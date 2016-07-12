import static org.junit.Assert.*;
import org.junit.Test;

import problems.LongestBalancedSubsequence;


public class LongestBalancedSubsequenceTest {
	
	@Test
	public void testSmallBalancedSeqWithSeparatedPairsDP() {
		LongestBalancedSubsequence lbs = new LongestBalancedSubsequence("()()");
		assertEquals(4, lbs.calculateDP());
	}

	@Test
	public void testSmallBalancedSeqWithSeparatedPairsNonDP() {
		LongestBalancedSubsequence lbs = new LongestBalancedSubsequence("()()");
		assertEquals(4, lbs.calculateNonDP());
	}

	@Test
	public void testSmallBalancedSeqWithNestedPairsDP() {
		LongestBalancedSubsequence lbs = new LongestBalancedSubsequence("(())");
		assertEquals(4, lbs.calculateDP());
	}

	@Test
	public void testSmallBalancedSeqWithNestedPairsNonDP() {
		LongestBalancedSubsequence lbs = new LongestBalancedSubsequence("(())");
		assertEquals(4, lbs.calculateNonDP());
	}

	@Test
	public void testMediumBalancedSeqWithSeparatedPairsDP() {
		LongestBalancedSubsequence lbs = new LongestBalancedSubsequence("()()()");
		assertEquals(6, lbs.calculateDP());
	}

	@Test
	public void testMediumBalancedSeqWithSeparatedPairsNonDP() {
		LongestBalancedSubsequence lbs = new LongestBalancedSubsequence("()()()");
		assertEquals(6, lbs.calculateNonDP());
	}

	@Test
	public void testMediumNonBalancedSeqDP() {
		LongestBalancedSubsequence lbs = new LongestBalancedSubsequence("()()(()");
		assertEquals(6, lbs.calculateDP());
	}

	@Test
	public void testMediumNonBalancedSeqNonDP() {
		LongestBalancedSubsequence lbs = new LongestBalancedSubsequence("()()(()");
		assertEquals(6, lbs.calculateNonDP());
	}

}
