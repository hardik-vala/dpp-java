import static org.junit.Assert.*;
import org.junit.Test;

import problems.LongestZigZagSequence;


public class LongestZigZagSequenceTest {
	
	@Test
	public void testZigZagSeq() {
		LongestZigZagSequence lzs = new LongestZigZagSequence(new int[] {1, 7, 4, 9, 2, 5});
		assertEquals(6, lzs.calculate());
	}

	@Test
	public void testMediumSizedSeq() {
		int[] seq = new int[] {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
		LongestZigZagSequence lzs = new LongestZigZagSequence(seq);
		assertEquals(7, lzs.calculate());
	}

	@Test
	public void testSingleElementSeq() {
		LongestZigZagSequence lzs = new LongestZigZagSequence(new int[] {44});
		assertEquals(1, lzs.calculate());
	}

	@Test
	public void testStrictlyIncreasingSeq() {
		int[] seq = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
		LongestZigZagSequence lzs = new LongestZigZagSequence(seq);
		assertEquals(2, lzs.calculate());
	}

	@Test
	public void testLargerSizedSeq() {
		int[] seq = new int[] {70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32,
			32};
		LongestZigZagSequence lzs = new LongestZigZagSequence(seq);
		assertEquals(8, lzs.calculate());
	}

	@Test
	public void testEvenLargerSizedSeq() {
		int[] seq = new int[] {
			374, 40, 854, 203, 203, 156, 362, 279, 812, 955,
			600, 947, 978, 46, 100, 953, 670, 862, 568, 188,
			67, 669, 810, 704, 52, 861, 49, 640, 370, 908,
			477, 245, 413, 109, 659, 401, 483, 308, 609, 120, 
			249, 22, 176, 279, 23, 22, 617, 462, 459, 244
		};
		LongestZigZagSequence lzs = new LongestZigZagSequence(seq);
		assertEquals(36, lzs.calculate());
	}

}
