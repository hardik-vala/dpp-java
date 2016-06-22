import static org.junit.Assert.*;

import problems.RedJohnsMurderPuzzle;

import org.junit.Test;


public class RedJohnsMurderPuzzleTest {

	@Test
	public void testSmallWidthWall() {
		RedJohnsMurderPuzzle rjmp = new RedJohnsMurderPuzzle(1);
		assertEquals(rjmp.solve(), 0);
	}

	@Test
	public void testMediumWidthWall() {
		RedJohnsMurderPuzzle rjmp = new RedJohnsMurderPuzzle(7);
		assertEquals(rjmp.solve(), 3);
	}

}
