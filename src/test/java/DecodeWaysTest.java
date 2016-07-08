import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import problems.DecodeWays;


public class DecodeWaysTest {
	
	@Test
	public void testOneLetterMessage() {
		LinkedList<Short> message = new LinkedList<Short>(Arrays.asList((short) 1));
		DecodeWays dw = new DecodeWays(message);
		assertEquals(1, dw.count());
	}

	@Test
	public void testShortMessage() {
		LinkedList<Short> message = new LinkedList<Short>(Arrays.asList((short) 1, (short) 2,
			(short) 3, (short) 4));

		DecodeWays dw = new DecodeWays(message);
		assertEquals(3, dw.count());
	}

	@Test
	public void testLongMessageWithOneDecoding() {
		LinkedList<Short> message = new LinkedList<Short>(Arrays.asList((short) 9, (short) 8,
			(short) 7, (short) 6, (short) 5, (short) 4, (short) 3, (short) 2));

		DecodeWays dw = new DecodeWays(message);
		assertEquals(1, dw.count());
	}

}
