import static org.junit.Assert.*;

import problems.BadNeighbours;

import org.junit.Test;


public class BadNeighboursTest {
	
	@Test
	public void testRandomDonationsinModeratelySizedNeighbourhood() {
		BadNeighbours bn = new BadNeighbours(new int[] {10, 3, 2, 5, 7, 8});
		assertEquals(19, bn.calculate());
	}

	@Test
	public void testReallySmallNeighbourhood() {
		BadNeighbours bn = new BadNeighbours(new int[] {11, 15});
		assertEquals(15, bn.calculate());
	}

	@Test
	public void testIdenticalDonations() {
		BadNeighbours bn = new BadNeighbours(new int[] {7, 7, 7, 7, 7, 7, 7});
		assertEquals(21, bn.calculate());
	}

	@Test
	public void testCyclicDonations() {
		BadNeighbours bn = new BadNeighbours(new int[] {1, 2, 3, 4, 5, 1, 2, 3, 4, 5});
		assertEquals(16, bn.calculate());
	}

	@Test
	public void testRandomDonationsinBigNeighbourhood() {
		BadNeighbours bn = new BadNeighbours(new int[] {94, 40, 49, 65, 21, 21, 106, 80, 92, 81,
			679, 4, 61, 6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397, 52, 72, 37, 51, 1, 81,
			45, 435, 7, 36, 57, 86, 81, 72});
		assertEquals(2926, bn.calculate());
	}

}
