import static org.junit.Assert.*;
import org.junit.Test;

import problems.MinimumChange;


public class MinimumChangeTest {
	
	@Test
	public void test1() {
		MinimumChange mc = new MinimumChange(11, new int[] {1, 3, 5});
		assertEquals(3, mc.calculate1());
	}

	@Test
	public void test2() {
		MinimumChange mc = new MinimumChange(11, new int[] {1, 3, 5});
		assertEquals(3, mc.calculate2());
	}

}
