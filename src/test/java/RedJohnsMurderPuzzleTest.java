import static org.junit.Assert.*;
import org.junit.Test;

import problems.RedJohnsMurderPuzzle;


public class RedJohnsMurderPuzzleTest {

	@Test
	public void testSmallWidthWall() {
		RedJohnsMurderPuzzle rjmp = new RedJohnsMurderPuzzle(1);
		assertEquals(0, rjmp.solve());
	}

	@Test
	public void testMediumWidthWall() {
		RedJohnsMurderPuzzle rjmp = new RedJohnsMurderPuzzle(7);
		assertEquals(3, rjmp.solve());
	}

}
