import static org.junit.Assert.*;
import org.junit.Test;

import problems.BalancedParantheses;


public class BalancedParanthesesTest {
	
	@Test
	public void test1() {
		BalancedParantheses bp = new BalancedParantheses(1);
		assertEquals(1L, bp.count());
	}

	@Test
	public void test2() {
		BalancedParantheses bp = new BalancedParantheses(2);
		assertEquals(2L, bp.count());
	}

	@Test
	public void test3() {
		BalancedParantheses bp = new BalancedParantheses(3);
		assertEquals(4L, bp.count());
	}

	@Test
	public void test4() {
		BalancedParantheses bp = new BalancedParantheses(4);
		assertEquals(8L, bp.count());
	}

	@Test
	public void test5() {
		BalancedParantheses bp = new BalancedParantheses(5);
		assertEquals(16L, bp.count());
	}

}
