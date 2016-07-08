import static org.junit.Assert.*;
import org.junit.Test;

import problems.BalancedParentheses;


public class BalancedParenthesesTest {
	
	@Test
	public void test1() {
		BalancedParentheses bp = new BalancedParentheses(1);
		assertEquals(1L, bp.count());
	}

	@Test
	public void test2() {
		BalancedParentheses bp = new BalancedParentheses(2);
		assertEquals(2L, bp.count());
	}

	@Test
	public void test3() {
		BalancedParentheses bp = new BalancedParentheses(3);
		assertEquals(4L, bp.count());
	}

	@Test
	public void test4() {
		BalancedParentheses bp = new BalancedParentheses(4);
		assertEquals(8L, bp.count());
	}

	@Test
	public void test5() {
		BalancedParentheses bp = new BalancedParentheses(5);
		assertEquals(16L, bp.count());
	}

}
