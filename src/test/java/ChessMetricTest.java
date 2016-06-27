import static org.junit.Assert.*;
import org.junit.Test;

import problems.ChessMetric;


public class ChessMetricTest {
	
	@Test
	public void testAdjacentStartAndEnd() {
		ChessMetric cm = new ChessMetric(3, new int[] {0, 0}, new int[] {1, 0}, 1);
		assertEquals(1, cm.count());
	}

	@Test
	public void testSingleLShapedMove() {
		ChessMetric cm = new ChessMetric(3, new int[] {0, 0}, new int[] {1, 2}, 1);
		assertEquals(1, cm.count());
	}

	@Test
	public void testStartAndEndTooFar() {
		ChessMetric cm = new ChessMetric(3, new int[] {0, 0}, new int[] {2, 2}, 1);
		assertEquals(0, cm.count());
	}

	@Test
	public void testLeavingAndReturningToCorner() {
		ChessMetric cm = new ChessMetric(3, new int[] {0, 0}, new int[] {0, 0}, 2);
		assertEquals(5, cm.count());
	}

	// @Test
	// public void testBigBoard() {
	// 	ChessMetric cm = new ChessMetric(100, new int[] {0, 0}, new int[] {0, 99}, 50);
	// 	assertEquals(243097320072600L, cm.count());
	// }

}
