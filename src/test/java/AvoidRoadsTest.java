import static org.junit.Assert.*;
import org.junit.Test;

import problems.AvoidRoads;


public class AvoidRoadsTest {

	@Test
	public void testModeratelySizedCityWithFewBadBlocks() {
		AvoidRoads ar = new AvoidRoads(6, 6, new String[] {"0 0 0 1", "6 6 5 6"});
		assertEquals(252L, ar.count());
	}

	@Test
	public void testSmallestPossibleCity() {
		AvoidRoads ar = new AvoidRoads(1, 1, new String[] {});
		assertEquals(2L, ar.count());
	}

	@Test
	public void testBigCityWithNoBadBlocks() {
		AvoidRoads ar = new AvoidRoads(35, 31, new String[] {});
		assertEquals(6406484391866534976L, ar.count());
	}

	@Test
	public void testPathsBlocked() {
		AvoidRoads ar = new AvoidRoads(2, 2, new String[] {"0 0 1 0", "1 2 2 2", "1 1 2 1"});
		assertEquals(0L, ar.count());
	}

}
