import static org.junit.Assert.*;
import org.junit.Test;

import problems.MinimumEditDistance;


public class MinimumEditDistanceTest {

	@Test
	public void testEmptyStringsOnSolWithQuadraticSpace() {
		MinimumEditDistance med = new MinimumEditDistance("", "");
		assertEquals(0, med.calculateWithQuadraticSpace());
	}

	@Test
	public void testEmptyStringsOnSolWithLinearSpace() {
		MinimumEditDistance med = new MinimumEditDistance("", "");
		assertEquals(0, med.calculateWithLinearSpace());
	}

	@Test
	public void testOneEmptyStringOnSolWithQuadraticSpace() {
		MinimumEditDistance med = new MinimumEditDistance("abcde", "");
		assertEquals(5, med.calculateWithQuadraticSpace());
	}

	@Test
	public void testOneEmptyStringOnSolWithLinearSpace() {
		MinimumEditDistance med = new MinimumEditDistance("abcde", "");
		assertEquals(5, med.calculateWithLinearSpace());
	}

	@Test
	public void testSmallStringsOnSolWithQuadraticSpace() {
		MinimumEditDistance med = new MinimumEditDistance("Saturday", "Sunday");
		assertEquals(3, med.calculateWithQuadraticSpace());
	}

	@Test
	public void testSmallStringsOnSolWithLinearSpace() {
		MinimumEditDistance med = new MinimumEditDistance("Saturday", "Sunday");
		assertEquals(3, med.calculateWithLinearSpace());
	}

}
