import static org.junit.Assert.*;
import org.junit.Test;

import problems.BalancedSubsequences;


public class BalancedSubsequencesTest {
	
	@Test
	public void testMediumSeq() {
		BalancedSubsequences bs = new BalancedSubsequences("((())())(");
		assertEquals(8, bs.count());
	}

	@Test
	public void testLargeSeq() {
		String seq = "())(())()())()()()))))()(()()))()()()()()()()())";
		BalancedSubsequences bs = new BalancedSubsequences(seq);
		assertEquals(14150760, bs.count());
	}

}
