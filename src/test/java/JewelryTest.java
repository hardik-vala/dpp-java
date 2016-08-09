import static org.junit.Assert.*;
import org.junit.Test;

import problems.Jewelry;


public class JewelryTest {
	
	// Valid allocations:
	// Bob              Frank
	// 1,2                3
	// 2,3                5
	// 1,3                4
	// 1,4                5
	@Test
	public void testSmallJewlerySet() {
		Jewelry j = new Jewelry(new int[] {1, 2, 3, 4, 5});
		assertEquals(4L, j.count());
	}

	// Valid allocations are:
	//	 Bob       		Frank
	//	 1,2		      3
	//   1,3       		  4
	//   1,4		      5  (first 5)
	//   1,4         	  5  (second 5)
	//   2,3 		      5  (first 5)
	//   2,3         	  5  (second 5)
	//    5  (first 5)	  5  (second 5)
	//    5  (second 5)	  5  (first 5)
	// 1,2,3,4       	 5,5
	// Note that each '5' is a different piece of jewelry and needs to be accounted for separately.
	// There are 9 legal ways of allocating the jewelry to Bob and Frank given the policy.
	@Test
	public void testSmallJewlerySetWithEndingDup() {
		Jewelry j = new Jewelry(new int[] {1, 2, 5, 3, 4, 5});
		assertEquals(9L, j.count());
	}

	@Test
	public void testSmallJewelryWithEndingTripleDup() {
		Jewelry j = new Jewelry(new int[] {2, 1, 2, 2});
		assertEquals(6L, j.count());
	}

	@Test
	public void testSmallJewlerySetWithMiddleDup() {
		Jewelry j = new Jewelry(new int[] {1, 2, 2, 3});
		assertEquals(4L, j.count());
	}

	@Test
	public void testSmallJewlerySetWithMultiDups() {
		Jewelry j = new Jewelry(new int[] {1, 2, 2, 3, 4, 4, 5, 6});
		assertEquals(33L, j.count());
	}

	@Test
	public void testSmallJewlerySetWithAllDups() {
		Jewelry j = new Jewelry(new int[] {1, 1, 1, 1, 1});
		assertEquals(25L, j.count());
	}

	@Test
	public void testNoPossibleAllocations() {
		int[] jewelry = new int[] {123, 217, 661, 678, 796, 964, 54, 111, 417, 526, 917, 923};
		Jewelry j = new Jewelry(jewelry);
		assertEquals(0L, j.count());
	}

}
